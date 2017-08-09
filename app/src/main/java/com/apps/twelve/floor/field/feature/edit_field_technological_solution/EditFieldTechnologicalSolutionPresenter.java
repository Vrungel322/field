package com.apps.twelve.floor.field.feature.edit_field_technological_solution;

import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.base.BasePresenter;
import com.apps.twelve.floor.field.data.DataManager;
import com.apps.twelve.floor.field.data.local.objects.solutions.BaseTechnologicalSolutionObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.TechnologicalSolutionTypeObject;
import com.apps.twelve.floor.field.utils.RxBus;
import com.apps.twelve.floor.field.utils.RxBusHelper;
import com.apps.twelve.floor.field.utils.ThreadSchedulers;
import com.arellomobile.mvp.InjectViewState;
import java.util.List;
import javax.inject.Inject;
import rx.Subscription;
import timber.log.Timber;

/**
 * Created by Yaroslav on 29.05.2017.
 */

@InjectViewState public class EditFieldTechnologicalSolutionPresenter
    extends BasePresenter<ITechnologicalSolutionFragmentView> {

  @Inject DataManager mDataManager;
  @Inject RxBus mRxBus;

  @NonNull private BaseTechnologicalSolutionObject mSolution;

  public EditFieldTechnologicalSolutionPresenter(
      @NonNull BaseTechnologicalSolutionObject solution) {
    this.mSolution = solution;
  }

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();

    getSolutionTypesForSelect();
  }

  public void updateActionBar(boolean mIsActionBarShown, String title) {
    mRxBus.post(new RxBusHelper.FragmentChangedOnScreen(mIsActionBarShown, title, false));
  }

  public void restoreActionBar() {
    mRxBus.post(new RxBusHelper.FragmentChangedOnScreen(false, "", true));
  }

  ///////////////////////////////////////////////////////////////////////////
  // Private section
  ///////////////////////////////////////////////////////////////////////////

  private void getSolutionTypesForSelect() {
    Subscription subscription = mDataManager.getAllTechnologicalSolutionTypes()
        .compose(ThreadSchedulers.applySchedulers())
        .map(this::syncSolutionType)
        .subscribe(this::updateSolutionTypesSpinner, Timber::e);

    addToUnsubscription(subscription);
  }

  private List<TechnologicalSolutionTypeObject> syncSolutionType(
      List<TechnologicalSolutionTypeObject> solutionTypes) {
    if (mSolution.getType() == null) return solutionTypes;
    for (TechnologicalSolutionTypeObject solutionType : solutionTypes) {
      if (solutionType.getId() == mSolution.getType().getId()) {
        mSolution.setType(solutionType);
        break;
      }
    }
    return solutionTypes;
  }

  private void updateSolutionTypesSpinner(List<TechnologicalSolutionTypeObject> solutionTypes) {
    getViewState().addSolutionTypesToSpinnerAdapter(solutionTypes);
    if (mSolution.getType() != null) {
      getViewState().setSelectedSolutionType(mSolution.getType());
    }
  }
}
