package com.apps.twelve.floor.field.mvp.presenters.pr_activities;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.mvp.presenters.BasePresenter;
import com.apps.twelve.floor.field.mvp.presenters.pr_interfaces.IMainActivityPresenter;
import com.apps.twelve.floor.field.mvp.views.IMainActivityView;
import com.arellomobile.mvp.InjectViewState;

/**
 * Created by John on 27.03.2017.
 */
@InjectViewState public class MainActivityPresenter extends BasePresenter<IMainActivityView>
    implements IMainActivityPresenter {

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    getViewState().addStartFragment();
  }

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }
}
