package com.apps.twelve.floor.field.feature.field_technological_map.presenters;

import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.base.BasePresenter;
import com.apps.twelve.floor.field.data.DataManager;
import com.apps.twelve.floor.field.data.local.objects.FieldObject;
import com.apps.twelve.floor.field.feature.field_technological_map.views.IFieldTechnologicalMapFragmentView;
import com.apps.twelve.floor.field.utils.ThreadSchedulers;
import com.arellomobile.mvp.InjectViewState;
import javax.inject.Inject;
import rx.Subscription;
import timber.log.Timber;

/**
 * Created by Yaroslav on 23.05.2017.
 */

@InjectViewState public class FieldTechnologicalMapPresenter
    extends BasePresenter<IFieldTechnologicalMapFragmentView> {

  @Inject DataManager mDataManager;

  @NonNull private FieldObject mFieldObject;

  public FieldTechnologicalMapPresenter(@NonNull FieldObject fieldObject) {
    this.mFieldObject = fieldObject;
  }

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();

    getAllFieldTechnologicalProcesses();
  }

  private void getAllFieldTechnologicalProcesses() {
    // TODO
    Subscription subscription = mDataManager.getFieldTechnologicalProcesses(mFieldObject.getId())
        .compose(ThreadSchedulers.applySchedulers())
        .subscribe(
            technologicalProcesses -> getViewState().showTechnologicalMap(technologicalProcesses),
            Timber::e);

    addToUnsubscription(subscription);
  }

  public void onTechProcessClickedAtPosition(int position) {
    getViewState().openTechnologicalProcessFragment(position);
  }
}
