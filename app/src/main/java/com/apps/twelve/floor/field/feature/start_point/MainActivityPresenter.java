package com.apps.twelve.floor.field.feature.start_point;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.base.BasePresenter;
import com.apps.twelve.floor.field.utils.RxBus;
import com.apps.twelve.floor.field.utils.RxBusHelper;
import com.arellomobile.mvp.InjectViewState;
import javax.inject.Inject;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

/**
 * Created by John on 27.03.2017.
 */
@InjectViewState public class MainActivityPresenter extends BasePresenter<IMainActivityView> {

  @Inject RxBus mRxBus;

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    getViewState().addStartFragment();

    subscribeToFragmentChanged();
  }

  private void subscribeToFragmentChanged() {
    Subscription subscription = mRxBus.filteredObservable(RxBusHelper.FragmentChangedOnScreen.class)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(msg -> onFragmentChanged(msg.isActionbarShown, msg.title, msg.isRestoring),
            Timber::e);
    addToUnsubscription(subscription);
  }

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  private void onFragmentChanged(boolean isActionbarShown, String title, boolean isRestoring) {
    if (!isRestoring) {
      getViewState().updateActionbar(isActionbarShown, title, true);
    } else {
      getViewState().restoreActionBar();
    }
  }
}
