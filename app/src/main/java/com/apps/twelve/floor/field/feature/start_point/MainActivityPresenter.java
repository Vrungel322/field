package com.apps.twelve.floor.field.feature.start_point;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.base.BasePresenter;
import com.arellomobile.mvp.InjectViewState;

/**
 * Created by John on 27.03.2017.
 */
@InjectViewState public class MainActivityPresenter extends BasePresenter<IMainActivityView> {

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    getViewState().addStartFragment();
  }

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }
}