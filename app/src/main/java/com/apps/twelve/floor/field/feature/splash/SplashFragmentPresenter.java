package com.apps.twelve.floor.field.feature.splash;

/**
 * Created by yarrick on 04.08.17.
 */

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.base.BasePresenter;
import com.apps.twelve.floor.field.data.local.PreferencesHelper;
import com.apps.twelve.floor.field.data.local.db_filler.DbFillHelper;
import com.apps.twelve.floor.field.utils.ThreadSchedulers;
import com.arellomobile.mvp.InjectViewState;
import javax.inject.Inject;
import rx.Observable;
import rx.Subscription;

@InjectViewState public class SplashFragmentPresenter extends BasePresenter<ISplashFragmentView> {

  @Inject PreferencesHelper mPreferencesHelper;

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();

    fillDbWithInitialData();
  }

  private void fillDbWithInitialData() {
    if (mPreferencesHelper.getIsDbFilled()) {
      getViewState().showStartFragment();
      return;
    }
    Subscription subscription =
        Observable.just(new DbFillHelper()).map(DbFillHelper::fillDbWithInitialData)
        .compose(ThreadSchedulers.applySchedulers()).subscribe(isDbFilled -> {
          // TODO: on testing version - DB is cleared on every start, so we need to fill it all the time
          // TODO: when DB migration will be done - uncomment this
          //mPreferencesHelper.setIsDbFilled(isDbFilled);
          if (isDbFilled) {
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
