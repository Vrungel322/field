package com.apps.twelve.floor.field.mvp.presenters.activities;

import android.os.Handler;
import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.mvp.presenters.BasePresenter;
import com.apps.twelve.floor.field.mvp.presenters.interfaces.IMainActivityPresenter;
import com.apps.twelve.floor.field.mvp.views.IMainActivityView;
import com.arellomobile.mvp.InjectViewState;

/**
 * Created by John on 27.03.2017.
 */
@InjectViewState public class MainActivityPresenter extends BasePresenter<IMainActivityView>
    implements IMainActivityPresenter {

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    delaySplash();
  }

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override public void delaySplash() {
    final Handler handler = new Handler();
    handler.postDelayed(() -> getViewState().afterSplash(), 1000);
  }
}
