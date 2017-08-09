package com.apps.twelve.floor.field.feature.edit_field_technological_process;

import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.base.BasePresenter;
import com.apps.twelve.floor.field.data.DataManager;
import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessObject;
import com.apps.twelve.floor.field.utils.RxBus;
import com.apps.twelve.floor.field.utils.RxBusHelper;
import com.apps.twelve.floor.field.utils.ThreadSchedulers;
import com.arellomobile.mvp.InjectViewState;
import javax.inject.Inject;
import rx.Subscription;
import timber.log.Timber;

/**
 * Created by Yaroslav on 25.05.2017.
 */

@InjectViewState public class FieldTechnologicalProcessPresenter
    extends BasePresenter<ITechnologicalProcessFragmentView> {

  @Inject DataManager mDataManager;
  @Inject RxBus mRxBus;

  @NonNull private FieldCropTechnologicalProcessObject mFieldTechnologicalProcess;

  public FieldTechnologicalProcessPresenter(
      @NonNull FieldCropTechnologicalProcessObject technologicalProcess) {
    this.mFieldTechnologicalProcess = technologicalProcess;
  }

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();

    getAllTechnologicalSolutions();
  }

  public void onSolutionClickedAtPosition(int position) {
    getViewState().openEditFieldTechnologicalSolutionFragment(position);
  }

  public void onAddNewSolutionClicked() {
    // TODO: open add tech process solution screen
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

  private void getAllTechnologicalSolutions() {
    // TODO
    Subscription subscription = mDataManager.getTechnologicalSolutions(/*TODO: uncomment after test*//*mFieldTechnologicalProcess.getId()*/
        1)
        .compose(ThreadSchedulers.applySchedulers())
        .subscribe(technologicalSolutions -> getViewState().showTechnologicalSolutions(
            technologicalSolutions), Timber::e);

    addToUnsubscription(subscription);
  }
}
