package com.apps.twelve.floor.field.feature.field_technological_map;

import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.base.BasePresenter;
import com.apps.twelve.floor.field.data.DataManager;
import com.apps.twelve.floor.field.data.local.objects.FieldObject;
import com.apps.twelve.floor.field.utils.RxBus;
import com.apps.twelve.floor.field.utils.RxBusHelper;
import com.apps.twelve.floor.field.utils.ThreadSchedulers;
import com.arellomobile.mvp.InjectViewState;
import javax.inject.Inject;
import rx.Subscription;
import timber.log.Timber;

/**
 * Created by Yaroslav on 23.05.2017.
 */

@InjectViewState public class FieldTechnologicalMapPresenter
    extends BasePresenter<IFieldTechnologicalMapFragmentView> {

  @Inject DataManager mDataManager;
  @Inject RxBus mRxBus;

  @NonNull private FieldObject mFieldObject;

  public FieldTechnologicalMapPresenter(@NonNull FieldObject fieldObject) {
    this.mFieldObject = fieldObject;
  }

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();

    showFieldDataOnView();
    getAllFieldTechnologicalProcesses();
  }

  public void onTechProcessClickedAtPosition(int position) {
    getViewState().openTechnologicalProcessFragment(position);
  }

  public void updateActionBar(boolean mIsActionBarShown, String title) {
    mRxBus.post(new RxBusHelper.FragmentChangedOnScreen(mIsActionBarShown, title, false));
  }

  public void restoreActionBar() {
    mRxBus.post(new RxBusHelper.FragmentChangedOnScreen(false, "", false));
  }

  ///////////////////////////////////////////////////////////////////////////
  // Private section
  ///////////////////////////////////////////////////////////////////////////

  private void getAllFieldTechnologicalProcesses() {
    Subscription subscription = mDataManager.getFieldTechnologicalProcesses(mFieldObject.getId())
        .compose(ThreadSchedulers.applySchedulers())
        .subscribe(
            technologicalProcesses -> getViewState().showTechnologicalMap(technologicalProcesses),
            Timber::e);

    addToUnsubscription(subscription);
  }

  private void showFieldDataOnView() {
    getViewState().updateCrop(mFieldObject.getCropName());
    getViewState().updatePhase(mFieldObject.getPhaseName());
    getViewState().updateArea(mFieldObject.getArea());
    getViewState().updateSowingDate(mFieldObject.getSowingDate());
  }
}
