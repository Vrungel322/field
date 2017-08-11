package com.apps.twelve.floor.field.feature.edit_field_technological_solution;

import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.base.BasePresenter;
import com.apps.twelve.floor.field.data.DataManager;
import com.apps.twelve.floor.field.data.local.objects.solutions.BaseTechnologicalSolutionObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.TechnologicalSolutionObject;
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

  @NonNull private TechnologicalSolutionObject mSolution;

  public EditFieldTechnologicalSolutionPresenter(@NonNull TechnologicalSolutionObject solution) {
    this.mSolution = solution;
  }

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();

    getSolutionTypesForSelect();
    getSolutionValuesForSelect();
  }

  public void updateActionBar(boolean mIsActionBarShown, String title) {
    mRxBus.post(new RxBusHelper.FragmentChangedOnScreen(mIsActionBarShown,
        title + mSolution.getSolutionValueName(), false));
  }

  public void restoreActionBar() {
    mRxBus.post(new RxBusHelper.FragmentChangedOnScreen(false, "", true));
  }

  public void updateSolutionType(TechnologicalSolutionTypeObject solutionType) {
    mSolution.setSolutionType(solutionType);
    getViewState().setSelectedSolutionType(solutionType);
  }

  public void updateSolutionValue(BaseTechnologicalSolutionObject solutionValue) {
    mSolution.setSolutionValue(solutionValue);
    getViewState().setSelectedSolutionValue(solutionValue);
  }

  ///////////////////////////////////////////////////////////////////////////
  // Private section
  ///////////////////////////////////////////////////////////////////////////

  private void getSolutionTypesForSelect() {
    Subscription subscription = mDataManager.getAllTechnologicalSolutionTypes()
        .compose(ThreadSchedulers.applySchedulers()).doOnNext(this::syncSolutionType)
        .subscribe(this::updateSolutionTypesSpinner, Timber::e);

    addToUnsubscription(subscription);
  }

  private void getSolutionValuesForSelect() {
    Subscription subscription =
        mDataManager.getAllTechnologicalSolutionValuesByType(mSolution.getSolutionType())
            .compose(ThreadSchedulers.applySchedulers())
            .doOnNext(this::syncSolutionValue)
            .subscribe(this::updateSolutionValuesSpinner, Timber::e);

    addToUnsubscription(subscription);
  }

  private void syncSolutionType(List<TechnologicalSolutionTypeObject> solutionTypes) {
    if (mSolution.getSolutionType() == null) return;
    for (TechnologicalSolutionTypeObject solutionType : solutionTypes) {
      if (solutionType.getId() == mSolution.getSolutionTypeId()) {
        mSolution.setSolutionType(solutionType);
        break;
      }
    }
  }

  private void syncSolutionValue(List<BaseTechnologicalSolutionObject> solutionValues) {
    if (mSolution.getSolutionValue() == null) return;
    for (BaseTechnologicalSolutionObject solutionValue : solutionValues) {
      if (solutionValue.getId() == mSolution.getSolutionValueId()) {
        mSolution.setSolutionValue(solutionValue);
        break;
      }
    }
  }

  private void updateSolutionTypesSpinner(List<TechnologicalSolutionTypeObject> solutionTypes) {
    getViewState().addSolutionTypesToSpinnerAdapter(solutionTypes);
    if (mSolution.getSolutionType() != null) {
      getViewState().setSelectedSolutionType(mSolution.getSolutionType());
    }
  }

  private void updateSolutionValuesSpinner(List<BaseTechnologicalSolutionObject> solutionValues) {
    getViewState().addSolutionValuesToSpinnerAdapter(solutionValues);
    if (mSolution.getSolutionValue() != null) {
      getViewState().setSelectedSolutionValue(mSolution.getSolutionValue());
    }
  }
}
