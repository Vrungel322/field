package com.apps.twelve.floor.field.mvp.presenters.pr_fragments;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.mvp.presenters.BasePresenter;
import com.apps.twelve.floor.field.mvp.presenters.pr_interfaces.IStartFragmentPreasenter;
import com.apps.twelve.floor.field.mvp.views.IStartFragmentView;
import com.arellomobile.mvp.InjectViewState;

/**
 * Created by John on 28.03.2017.
 */

@InjectViewState public class StartFragmentPresenter extends BasePresenter<IStartFragmentView>
    implements IStartFragmentPreasenter {

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }
}
