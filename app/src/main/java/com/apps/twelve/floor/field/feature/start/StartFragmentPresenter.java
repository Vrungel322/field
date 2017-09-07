package com.apps.twelve.floor.field.feature.start;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.base.BasePresenter;
import com.arellomobile.mvp.InjectViewState;

/**
 * Created by yarrick on 07.09.17.
 */

@InjectViewState public class StartFragmentPresenter extends BasePresenter<IStartFragmentView> {

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }
}
