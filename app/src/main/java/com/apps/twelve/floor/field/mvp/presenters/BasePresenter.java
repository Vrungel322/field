package com.apps.twelve.floor.field.mvp.presenters;

import android.support.annotation.NonNull;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by John on 27.03.2017.
 */
public abstract class BasePresenter<V extends MvpView> extends MvpPresenter<V> {

  private CompositeSubscription mCompositeSubscription = new CompositeSubscription();

  public BasePresenter() {
    inject();
  }

  protected void addToUnsubscription(@NonNull Subscription subscription) {
    mCompositeSubscription.add(subscription);
  }

  @Override public void onDestroy() {
    super.onDestroy();
    mCompositeSubscription.clear();
  }

  protected abstract void inject();
}
