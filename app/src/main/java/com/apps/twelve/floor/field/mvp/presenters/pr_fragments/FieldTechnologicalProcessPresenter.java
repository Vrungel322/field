package com.apps.twelve.floor.field.mvp.presenters.pr_fragments;

import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.mvp.data.DataManager;
import com.apps.twelve.floor.field.mvp.data.local.objects.FieldTechnologicalProcessObject;
import com.apps.twelve.floor.field.mvp.presenters.BasePresenter;
import com.apps.twelve.floor.field.mvp.views.ITechnologicalProcessFragmentView;
import com.apps.twelve.floor.field.utils.ThreadSchedulers;
import com.arellomobile.mvp.InjectViewState;
import javax.inject.Inject;
import rx.Subscription;
import timber.log.Timber;

/**
 * Created by Yaroslav on 25.05.2017.
 */

@InjectViewState public class FieldTechnologicalProcessPresenter
    extends BasePresenter<ITechnologicalProcessFragmentView> {

  @Inject DataManager mDataManager;

  @NonNull private FieldTechnologicalProcessObject mFieldTechnologicalProcess;

  public FieldTechnologicalProcessPresenter(
      @NonNull FieldTechnologicalProcessObject technologicalProcess) {
    this.mFieldTechnologicalProcess = technologicalProcess;
  }

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();

    getAllTechnologicalSolutions();
  }

  private void getAllTechnologicalSolutions() {
    // TODO
    Subscription subscription =
        mDataManager.getTechnologicalSolutions(mFieldTechnologicalProcess.getId())
            .compose(ThreadSchedulers.applySchedulers())
            .subscribe(technologicalSolutions -> getViewState().showTechnologicalSolutions(
                technologicalSolutions), Timber::e);

    addToUnsubscription(subscription);
  }

  public void onSolutionClickedAtPosition(int position) {
    // TODO: open tech process solution edit screen
  }
}
