package com.apps.twelve.floor.field.mvp.presenters.pr_fragments;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.mvp.data.local.DbManager;
import com.apps.twelve.floor.field.mvp.presenters.BasePresenter;
import com.apps.twelve.floor.field.mvp.views.IStartFragmentView;
import com.apps.twelve.floor.field.utils.ThreadSchedulers;
import com.arellomobile.mvp.InjectViewState;
import javax.inject.Inject;
import rx.Subscription;
import timber.log.Timber;

/**
 * Created by John on 28.03.2017.
 */

@InjectViewState public class StartFragmentPresenter extends BasePresenter<IStartFragmentView> {

  @Inject DbManager mDbManager;

  private int mFieldTypePosition = -1;

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    getAllFields();
  }

  public void showFieldTypeDialog() {
    getViewState().showFieldAddTypeDialog();
  }

  public void hideFieldTypeDialog() {
    mFieldTypePosition = -1;
    getViewState().hideFieldAddTypeDialog();
  }

  public void setFieldTypePosition(int position) {
    mFieldTypePosition = position;
  }

  public int getFieldTypePosition() {
    return mFieldTypePosition;
  }

  private void getAllFields() {
    Subscription subscription = mDbManager.getAllFields()
        .compose(ThreadSchedulers.applySchedulers())
        .subscribe(fields -> getViewState().showFields(fields), Timber::e);

    addToUnsubscription(subscription);
  }
}
