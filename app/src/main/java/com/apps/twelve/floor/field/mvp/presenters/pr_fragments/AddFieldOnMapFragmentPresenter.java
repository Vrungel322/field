package com.apps.twelve.floor.field.mvp.presenters.pr_fragments;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.mvp.data.DataManager;
import com.apps.twelve.floor.field.mvp.data.model.Field;
import com.apps.twelve.floor.field.mvp.presenters.BasePresenter;
import com.apps.twelve.floor.field.mvp.views.IAddFieldOnMapFragmentView;
import com.arellomobile.mvp.InjectViewState;
import javax.inject.Inject;

/**
 * Created by Yaroslav on 30.03.2017.
 */

@InjectViewState public class AddFieldOnMapFragmentPresenter
    extends BasePresenter<IAddFieldOnMapFragmentView> {

  @Inject DataManager mDataManager;

  private Field field; // TODO: filed to edit or create

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
  }
}
