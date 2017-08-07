package com.apps.twelve.floor.field.feature.splash;

/**
 * Created by yarrick on 04.08.17.
 */

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.base.BasePresenter;
import com.apps.twelve.floor.field.data.local.db_filler.DbFillHelper;
import com.apps.twelve.floor.field.utils.ThreadSchedulers;
import com.arellomobile.mvp.InjectViewState;
import rx.Observable;
import rx.Subscription;

@InjectViewState public class SplashFragmentPresenter extends BasePresenter<ISplashFragmentView> {

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();

    initiateDbFiller();
  }

  private void initiateDbFiller() {
    Subscription subscription =
        Observable.just(new DbFillHelper()).map(DbFillHelper::fillDbWithInitialData)
        .compose(ThreadSchedulers.applySchedulers())
        .subscribe(isOk -> {
          if (isOk) {
            getViewState().showStartFragment();
          } else {
            getViewState().showErrorDialog();
          }
        });

    addToUnsubscription(subscription);
  }

  public void hideErrorDialog() {
    // TODO: maybe need to close the app
    getViewState().hideErrorDialog();
  }
}
