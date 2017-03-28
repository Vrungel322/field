package com.apps.twelve.floor.field.mvp.presenters.pr_fragments;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.mvp.data.DataManager;
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

  @Inject DataManager dataManager;

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    fetchFields();
  }

  private void fetchFields() {
    Subscription subscription = dataManager.fetchFields()
        .compose(ThreadSchedulers.applySchedulers())
        .subscribe(
            fields -> {getViewState().showFields(fields);},
            throwable -> {Timber.e(throwable);}
            );

    addToUnsubscription(subscription);
  }
}
