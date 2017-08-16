package com.apps.twelve.floor.field.feature.field_technological_process;

import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.base.BasePresenter;
import com.apps.twelve.floor.field.data.DataManager;
import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.TechnologicalProcessStateObject;
import com.apps.twelve.floor.field.utils.RxBus;
import com.apps.twelve.floor.field.utils.RxBusHelper;
import com.apps.twelve.floor.field.utils.ThreadSchedulers;
import com.arellomobile.mvp.InjectViewState;
import java.util.List;
import javax.inject.Inject;
import rx.Subscription;
import timber.log.Timber;

/**
 * Created by Yaroslav on 25.05.2017.
 */

@InjectViewState public class FieldTechnologicalProcessPresenter
    extends BasePresenter<ITechnologicalProcessFragmentView> {

  @Inject DataManager mDataManager;
  @Inject RxBus mRxBus;

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

    subscribeToStatesForSelect();

    setDoneDate();
  }

  public void onSolutionClickedAtPosition(int position) {
    getViewState().openEditFieldTechnologicalSolutionFragment(position);
  }

  public void onAddNewSolutionClicked() {
    // TODO: open add tech process solution screen
  }

  public void updateActionBar(boolean mIsActionBarShown, String title) {
    mRxBus.post(new RxBusHelper.FragmentChangedOnScreen(mIsActionBarShown,
        title + mFieldTechnologicalProcess.getTechProcessName(), false));
  }

  public void restoreActionBar() {
    mRxBus.post(new RxBusHelper.FragmentChangedOnScreen(false, "", true));
  }

  public void updateTechnologicalProcessState(TechnologicalProcessStateObject state) {
    mFieldTechnologicalProcess.setState(state);
    getViewState().setSelectedTechnologicalProcessState(state);
  }

  ///////////////////////////////////////////////////////////////////////////
  // Private section
  ///////////////////////////////////////////////////////////////////////////

  private void getAllTechnologicalSolutions() {
    // TODO
    Subscription subscription =
        mDataManager.getTechnologicalSolutions(mFieldTechnologicalProcess.getId())
        .compose(ThreadSchedulers.applySchedulers())
        .subscribe(technologicalSolutions -> getViewState().showTechnologicalSolutions(
            technologicalSolutions), Timber::e);

    addToUnsubscription(subscription);
  }

  private void subscribeToStatesForSelect() {
    Subscription subscription = mDataManager.getAllTechnologicalProcessStates()
        .compose(ThreadSchedulers.applySchedulers())
        .doOnNext(this::syncTechnologicalProcessState)
        .subscribe(this::updateStatesSpinner, Timber::e);

    addToUnsubscription(subscription);
  }

  private void syncTechnologicalProcessState(List<TechnologicalProcessStateObject> states) {
    if (mFieldTechnologicalProcess.getState() == null) return;
    for (TechnologicalProcessStateObject state : states) {
      if (state.getId() == mFieldTechnologicalProcess.getState().getId()) {
        mFieldTechnologicalProcess.setState(state);
        break;
      }
    }
  }

  private void updateStatesSpinner(List<TechnologicalProcessStateObject> states) {
    getViewState().addTechnologicalProcessStatesToSpinnerAdapter(states);
    if (mFieldTechnologicalProcess.getState() != null) {
      getViewState().setSelectedTechnologicalProcessState(mFieldTechnologicalProcess.getState());
    }
  }

  private void setDoneDate() {
    // TODO: TechProcess must contain it's done date, for now we think it is always empty

    /*if (mFieldTechnologicalProcess.getDoneDate > 0) {
      return;
    }*/
    getViewState().updateDoneDate(System.currentTimeMillis());
  }
}
