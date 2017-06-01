package com.apps.twelve.floor.field.feature.edit_field_technological_process.presenters;

import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.base.BasePresenter;
import com.apps.twelve.floor.field.data.DataManager;
import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessObject;
import com.apps.twelve.floor.field.feature.edit_field_technological_process.views.ITechnologicalProcessFragmentView;
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

  @NonNull private FieldCropTechnologicalProcessObject mFieldTechnologicalProcess;

  public FieldTechnologicalProcessPresenter(
      @NonNull FieldCropTechnologicalProcessObject technologicalProcess) {
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
    getViewState().openEditFieldTechnologicalSolutionFragment(position);
  }

  public void onAddNewSolutionClicked() {
    // TODO: open add tech process solution screen
  }
}
