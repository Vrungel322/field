package com.apps.twelve.floor.field.data;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.data.local.DbCombinedFieldRelationsHelper;
import com.apps.twelve.floor.field.data.local.DbCombinedPhaseRelationsHelper;
import com.apps.twelve.floor.field.data.local.DbHelper;
import com.apps.twelve.floor.field.data.local.mappers.ClimateZoneEntityToClimateZoneObject;
import com.apps.twelve.floor.field.data.local.mappers.ClimateZoneObjectToClimateZoneEntity;
import com.apps.twelve.floor.field.data.local.mappers.CombinedFieldEntityToFieldObject;
import com.apps.twelve.floor.field.data.local.mappers.CropEntityToCropObject;
import com.apps.twelve.floor.field.data.local.mappers.CropObjectToCropEntity;
import com.apps.twelve.floor.field.data.local.mappers.FieldObjectToFieldEntity;
import com.apps.twelve.floor.field.data.local.mappers.PhaseEntityToPhaseObject;
import com.apps.twelve.floor.field.data.local.mappers.PhaseObjectToPhaseEntity;
import com.apps.twelve.floor.field.data.local.objects.CropObject;
import com.apps.twelve.floor.field.data.local.objects.FieldObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.ClimateZoneObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.PhaseObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.FieldTechnologicalProcessSolutionObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.TechnologicalSolutionTypeObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessObject;
import com.apps.twelve.floor.field.utils.TestUtils;
import com.pushtorefresh.storio.sqlite.operations.delete.DeleteResult;
import com.pushtorefresh.storio.sqlite.operations.put.PutResult;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

/**
 * Created by John on 27.03.2017.
 */

public class DataManager {

  //@Inject RestApi mRestApi;
  @Inject DbHelper mDbHelper;
  @Inject DbCombinedFieldRelationsHelper mDbCombinedFieldRelationsHelper;
  @Inject DbCombinedPhaseRelationsHelper mDbCombinedPhaseRelationsHelper;

  public DataManager() {
    App.getAppComponent().inject(this);
  }

  ///////////////////////////////////////////////////////////////////////////
  // DB methods
  ///////////////////////////////////////////////////////////////////////////

  public Observable<List<FieldObject>> getAllFields() {
    return mDbCombinedFieldRelationsHelper.getCombinedFieldEntities()
        .concatMap(Observable::from)
        .map(combinedFieldEntity -> new CombinedFieldEntityToFieldObject().transform(
            combinedFieldEntity))
        .toList();
  }

  public PutResult putField(FieldObject fieldObject) {
    return mDbHelper.putField(new FieldObjectToFieldEntity().transform(fieldObject));
  }

  public PutResult putPhase(PhaseObject phaseObject) {
    return mDbHelper.putPhase(new PhaseObjectToPhaseEntity().transform(phaseObject));
  }

  /*public Observable<List<PhaseObject>> getAllPhases() {
    return mDbCombinedPhaseRelationsHelper.getCombinedPhaseEntities()
        .concatMap(Observable::from)
        .map(combinedPhaseEntity -> new CombinedPhaseEntityToPhaseObject().transform(
            combinedPhaseEntity))
        .toList();
  }*/
  public Observable<List<PhaseObject>> getAllPhases() {
    return Observable.concat(Observable.just(PhaseObject.EMPTY), mDbHelper.getAllPhases()
        .concatMap(Observable::from)
        .map(phaseEntity -> new PhaseEntityToPhaseObject().transform(phaseEntity))).toList();
  }

  public DeleteResult deleteField(FieldObject fieldObject) {
    return mDbHelper.deleteField(new FieldObjectToFieldEntity().transform(fieldObject));
  }

  public Observable<List<CropObject>> getAllCrops() {
    return mDbHelper.getAllCrops()
        .concatMap(Observable::from)
        .map(cropEntity -> new CropEntityToCropObject().transform(cropEntity))
        .toList();
  }

  public Observable<CropObject> getCropById(long id) {
    return mDbHelper.getCropById(id)
        .map(cropEntity -> new CropEntityToCropObject().transform(cropEntity))
        .take(1);
  }

  public PutResult putCrop(CropObject cropObject) {
    return mDbHelper.putCrop(new CropObjectToCropEntity().transform(cropObject));
  }

  public PutResult putClimateZone(ClimateZoneObject climateZoneObject) {
    return mDbHelper.putClimateZone(
        new ClimateZoneObjectToClimateZoneEntity().transform(climateZoneObject));
  }

  public Observable<List<ClimateZoneObject>> getAllClimateZones() {
    return mDbHelper.getAllClimateZones()
        .concatMap(Observable::from)
        .map(climateZoneEntity -> new ClimateZoneEntityToClimateZoneObject().transform(
            climateZoneEntity))
        .toList();
  }

  public Observable<List<FieldCropTechnologicalProcessObject>> getFieldTechnologicalProcesses(
      long mFieldObjectId) {
    // TODO
    return Observable.just(TestUtils.getFieldTechnologicalProcesses());
  }

  public Observable<List<FieldTechnologicalProcessSolutionObject>> getTechnologicalSolutions(
      long mTechnologicalProcessId) {
    // TODO
    return Observable.just(TestUtils.getTechnologicalSolutions());
  }

  public Observable<List<TechnologicalSolutionTypeObject>> getAllTechnologicalSolutionTypes() {
    // TODO
    return Observable.just(TestUtils.getAllTechnologicalSolutionTypes());
  }
}
