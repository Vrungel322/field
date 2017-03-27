package com.apps.twelve.floor.field.mvp.presenters.activities;

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
  }

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }
}