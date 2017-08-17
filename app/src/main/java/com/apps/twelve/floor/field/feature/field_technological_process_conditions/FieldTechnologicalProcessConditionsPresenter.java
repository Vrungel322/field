package com.apps.twelve.floor.field.feature.field_technological_process_conditions;

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
 * Created by yarrick on 16.08.17.
 */

@InjectViewState public class FieldTechnologicalProcessConditionsPresenter
    extends BasePresenter<ITechnologicalProcessConditionsFragmentView> {

  @Inject DataManager mDataManager;
  @Inject RxBus mRxBus;

  @NonNull private FieldCropTechnologicalProcessObject mFieldTechnologicalProcess;

  public FieldTechnologicalProcessConditionsPresenter(
      @NonNull FieldCropTechnologicalProcessObject technologicalProcess) {
    this.mFieldTechnologicalProcess = technologicalProcess;
  }

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    getAllFieldTechnologicalProcessConditions();
    // TODO: subscribe to conditions change in DB, and call ViewState.updCond(cond)
  }

  public void updateActionBar(boolean mIsActionBarShown, String title) {
    mRxBus.post(new RxBusHelper.FragmentChangedOnScreen(mIsActionBarShown,
        title + mFieldTechnologicalProcess.getTechProcessName(), false));
  }

  public void restoreActionBar() {
    mRxBus.post(new RxBusHelper.FragmentChangedOnScreen(false, "", false));
  }

  public void onConditionClickedAtPosition(int position) {
    // TODO: call mDataManager.updCondition(position/id)
  }

  private void getAllFieldTechnologicalProcessConditions() {
    Subscription subscription = mDataManager.getAllFieldCropTechnologicalProcessesConditions(
        mFieldTechnologicalProcess.getId())
        .compose(ThreadSchedulers.applySchedulers())
        .subscribe(conditions -> getViewState().showConditions(conditions), Timber::e);

    addToUnsubscription(subscription);
  }

  public void onOkClicked() {
    getViewState().openTechnologicalProcessFragment(mFieldTechnologicalProcess);
  }
}
