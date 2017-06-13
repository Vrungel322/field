package com.apps.twelve.floor.field.feature.edit_field;

import android.text.TextUtils;
import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.base.BasePresenter;
import com.apps.twelve.floor.field.data.DataManager;
import com.apps.twelve.floor.field.data.local.objects.CropObject;
import com.apps.twelve.floor.field.data.local.objects.FieldObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.SoilTypeObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.ClimateZoneObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.PhaseObject;
import com.apps.twelve.floor.field.utils.RxBus;
import com.apps.twelve.floor.field.utils.RxBusHelper;
import com.apps.twelve.floor.field.utils.ThreadSchedulers;
import com.arellomobile.mvp.InjectViewState;
import com.google.android.gms.maps.model.LatLng;
import com.pushtorefresh.storio.sqlite.operations.put.PutResult;
import java.util.List;
import javax.inject.Inject;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

/**
 * Created by Yaroslav on 03.04.2017.
 */

@InjectViewState public class EditFieldPresenter extends BasePresenter<IEditFieldFragmentView> {

  @Inject DataManager mDataManager;
  @Inject RxBus mRxBus;

  private FieldObject mFieldObject;

  public EditFieldPresenter(FieldObject fieldObject) {
    if (fieldObject == null) {
      setField(FieldObject.newInstance());
    } else {
      setField(fieldObject);
    }
  }

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();

    getCropsForSelect();
    getPreviousCropsForSelect();
    getClimateZonesForSelect();
    getPhasesForSelect();

    subscribeToPolygonEditResult();
    updateViewState();
  }

  public void setField(FieldObject fieldObject) {
    this.mFieldObject = fieldObject;
  }

  public void updateFieldName(String name) {
    if (name.equals(mFieldObject.getName())) return;
    mFieldObject.setName(name);
    getViewState().setFieldNameText(name);
  }

  public void updateFieldArea(String area) {
    double dArea = 0;
    if (!TextUtils.isEmpty(area)) {
      try {
        dArea = Double.parseDouble(area);
      } catch (NumberFormatException e) {
        Timber.e(e);
        dArea = 0;
      }
    }

    mFieldObject.setArea(dArea);
    getViewState().setFieldAreaText(String.valueOf(dArea));
  }

  public void updateFieldArea(double area) {
    if (area == mFieldObject.getArea()) return;

    mFieldObject.setArea(area);
    getViewState().setFieldAreaText(String.valueOf(area));
  }

  public void updateFieldCrop(CropObject cropObject) {
    mFieldObject.setCrop(cropObject);
    getViewState().setSelectedCrop(cropObject);
  }

  public void updateFieldPreviousCrop(CropObject cropObject) {
    mFieldObject.setPreviousCrop(cropObject);
    getViewState().setSelectedPreviousCrop(cropObject);
  }

  public void updateFieldClimateZone(ClimateZoneObject climateZoneObject) {
    mFieldObject.setClimateZone(climateZoneObject);
    getViewState().setSelectedClimateZone(climateZoneObject);
  }

  public void updateFieldPhase(PhaseObject phaseObject) {
    mFieldObject.setPhase(phaseObject);
    getViewState().setSelectedPhase(phaseObject);
  }

  public void updateFieldSoilType(SoilTypeObject soilTypeObject) {
    // TODO:
    /*mFieldObject.setSoilType(soilTypeObject);
    getViewState().setSelectedSoilType(soilTypeObject);*/
  }

  public void updateFieldPoints(List<LatLng> points) {
    mFieldObject.clearPoints();
    mFieldObject.addAllPoints(points);
  }

  public void saveField() {
    PutResult putResult = mDataManager.putField(mFieldObject);

    int changeId = -1;
    if (putResult.wasInserted()) {
      if (putResult.insertedId() != null) {
        //noinspection ConstantConditions
        mFieldObject.setId(putResult.insertedId());
        changeId = RxBusHelper.FieldChangedInDb.CHANGE_INSERT;
      } else {
        Timber.e("Incorrect Field id after DB put");
        return;
      }
    } else if (putResult.wasUpdated()) {
      changeId = RxBusHelper.FieldChangedInDb.CHANGE_UPDATE;
    }

    mRxBus.post(new RxBusHelper.FieldChangedInDb(mFieldObject, changeId));
  }

  public void setEditMode(boolean isEditMode) {
    mRxBus.post(new RxBusHelper.SwitchFieldEditMode(isEditMode));
    getViewState().setBtnOkEnabled(!isEditMode);
  }

  public void setTrackingMode(boolean isTrackingMode) {
    mRxBus.post(new RxBusHelper.SwitchFieldTrackingMode(isTrackingMode));
    getViewState().setBtnOkEnabled(!isTrackingMode);
  }

  ///////////////////////////////////////////////////////////////////////////
  // Private section
  ///////////////////////////////////////////////////////////////////////////

  private void updateViewState() {
    getViewState().setFieldNameText(mFieldObject.getName());
    getViewState().setFieldAreaText(String.valueOf(mFieldObject.getArea()));

    if (mFieldObject.hasPoints()) {
      // TODO: update markers, polyline and polygon on map
    }
  }

  private void getCropsForSelect() {
    Subscription subscription = mDataManager.getAllCrops()
        .compose(ThreadSchedulers.applySchedulers())
        .map(this::syncFieldCrop)
        .subscribe(this::updateCropsSpinner, Timber::e);

    addToUnsubscription(subscription);
  }

  private void getPreviousCropsForSelect() {
    Subscription subscription = mDataManager.getAllCrops()
        .compose(ThreadSchedulers.applySchedulers())
        .map(this::syncFieldPreviousCrop)
        .subscribe(this::updatePreviousCropsSpinner, Timber::e);

    addToUnsubscription(subscription);
  }

  private void getClimateZonesForSelect() {
    Subscription subscription = mDataManager.getAllClimateZones()
        .compose(ThreadSchedulers.applySchedulers())
        .map(this::syncFieldClimateZone)
        .subscribe(this::updateClimateZonesSpinner, Timber::e);

    addToUnsubscription(subscription);
  }

  private void getPhasesForSelect() {
    Subscription subscription = mDataManager.getAllPhases()
        .compose(ThreadSchedulers.applySchedulers())
        .map(this::syncFieldPhase)
        .subscribe(this::updatePhasesSpinner, Timber::e);

    addToUnsubscription(subscription);
  }

  private List<CropObject> syncFieldCrop(List<CropObject> crops) {
    if (mFieldObject.getCrop() == null) return crops;
    for (CropObject crop : crops) {
      if (crop.getId() == mFieldObject.getCrop().getId()) {
        mFieldObject.setCrop(crop);
        break;
      }
    }
    return crops;
  }

  private List<CropObject> syncFieldPreviousCrop(List<CropObject> crops) {
    if (mFieldObject.getPreviousCrop() == null) return crops;
    for (CropObject crop : crops) {
      if (crop.getId() == mFieldObject.getPreviousCrop().getId()) {
        mFieldObject.setPreviousCrop(crop);
        break;
      }
    }
    return crops;
  }

  private List<ClimateZoneObject> syncFieldClimateZone(List<ClimateZoneObject> climateZones) {
    if (mFieldObject.getClimateZone() == null) return climateZones;
    for (ClimateZoneObject climateZone : climateZones) {
      if (climateZone.getId() == mFieldObject.getClimateZone().getId()) {
        mFieldObject.setClimateZone(climateZone);
        break;
      }
    }
    return climateZones;
  }

  private List<PhaseObject> syncFieldPhase(List<PhaseObject> phases) {
    if (mFieldObject.getPhase() == null) return phases;
    for (PhaseObject phase : phases) {
      if (phase.getId() == mFieldObject.getPhase().getId()) {
        mFieldObject.setPhase(phase);
        break;
      }
    }
    return phases;
  }

  private void updateCropsSpinner(List<CropObject> crops) {
    getViewState().addCropsToSpinnerAdapter(crops);
    if (mFieldObject.getCrop() != null) {
      getViewState().setSelectedCrop(mFieldObject.getCrop());
    }
  }

  private void updatePreviousCropsSpinner(List<CropObject> crops) {
    getViewState().addPreviousCropsToSpinnerAdapter(crops);
    if (mFieldObject.getPreviousCrop() != null) {
      getViewState().setSelectedPreviousCrop(mFieldObject.getPreviousCrop());
    }
  }

  private void updateClimateZonesSpinner(List<ClimateZoneObject> climateZones) {
    getViewState().addClimateZonesToSpinnerAdapter(climateZones);
    if (mFieldObject.getClimateZone() != null) {
      getViewState().setSelectedClimateZone(mFieldObject.getClimateZone());
    }
  }

  private void updatePhasesSpinner(List<PhaseObject> phases) {
    getViewState().addPhasesToSpinnerAdapter(phases);
    if (mFieldObject.getPhase() != null) {
      getViewState().setSelectedPhase(mFieldObject.getPhase());
    }
  }

  private void subscribeToPolygonEditResult() {
    Subscription subscription = mRxBus.filteredObservable(RxBusHelper.HandlePolygonEditResult.class)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(msg -> {
          updateFieldPoints(msg.points);
          updateFieldArea(msg.area);
        }, Timber::e);
    addToUnsubscription(subscription);
  }
}
