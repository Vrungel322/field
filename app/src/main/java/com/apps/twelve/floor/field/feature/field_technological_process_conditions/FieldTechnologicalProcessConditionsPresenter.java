package com.apps.twelve.floor.field.feature.field_technological_process_conditions;

import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.base.BasePresenter;
import com.apps.twelve.floor.field.data.DataManager;
import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessObject;
import com.arellomobile.mvp.InjectViewState;
import javax.inject.Inject;

/**
 * Created by yarrick on 16.08.17.
 */

@InjectViewState public class FieldTechnologicalProcessConditionsPresenter
    extends BasePresenter<ITechnologicalProcessConditionsFragmentView> {

  @Inject DataManager mDataManager;

  @NonNull private FieldCropTechnologicalProcessObject mFieldTechnologicalProcess;

  public FieldTechnologicalProcessConditionsPresenter(
      @NonNull FieldCropTechnologicalProcessObject technologicalProcess) {
    this.mFieldTechnologicalProcess = technologicalProcess;
  }

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    // TODO: get list of conditions
  }
}
