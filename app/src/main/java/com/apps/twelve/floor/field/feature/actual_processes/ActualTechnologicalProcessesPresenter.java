package com.apps.twelve.floor.field.feature.actual_processes;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.base.BasePresenter;
import com.apps.twelve.floor.field.data.DataManager;
import com.apps.twelve.floor.field.utils.RxBus;
import com.apps.twelve.floor.field.utils.RxBusHelper;
import com.apps.twelve.floor.field.utils.ThreadSchedulers;
import com.arellomobile.mvp.InjectViewState;
import javax.inject.Inject;
import rx.Subscription;
import timber.log.Timber;

/**
 * Created by yarrick on 07.09.17.
 */

@InjectViewState public class ActualTechnologicalProcessesPresenter
    extends BasePresenter<IActualTechnologicalProcessesFragmentView> {

  @Inject DataManager mDataManager;
  @Inject RxBus mRxBus;

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();

    getAllActualTechnologicalProcesses();

    subscribeToActualTechnologicalProcessDbChanges();
  }

  public void onTechProcessClickedAtPosition(int position) {
    getViewState().openTechnologicalProcessFragment(position);
  }

  public void updateActionBar(boolean isActionBarShown, String title) {
    mRxBus.post(new RxBusHelper.FragmentChangedOnScreen(isActionBarShown, title, false));
  }

  public void restoreActionBar() {
    mRxBus.post(new RxBusHelper.FragmentChangedOnScreen(false, "", false));
  }

  ///////////////////////////////////////////////////////////////////////////
  // Private section
  ///////////////////////////////////////////////////////////////////////////
  private void getAllActualTechnologicalProcesses() {
    Subscription subscription = mDataManager.getAllActualTechnologicalProcesses()
        .compose(ThreadSchedulers.applySchedulers())
        .subscribe(technologicalProcesses -> getViewState().showTechnologicalProcesses(
            technologicalProcesses), Timber::e);

    addToUnsubscription(subscription);
  }

  private void subscribeToActualTechnologicalProcessDbChanges() {
    // TODO
  }
}
