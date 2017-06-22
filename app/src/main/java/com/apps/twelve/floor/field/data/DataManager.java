package com.apps.twelve.floor.field.data;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.data.local.DbCombinedFieldRelationsHelper;
import com.apps.twelve.floor.field.data.local.DbHelper;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionEntity;
import com.apps.twelve.floor.field.data.local.mappers.AggregateObjectToAggregateEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.ClimateZoneEntityToClimateZoneObject;
import com.apps.twelve.floor.field.data.local.mappers.ClimateZoneObjectToClimateZoneEntity;
import com.apps.twelve.floor.field.data.local.mappers.CombinedFieldEntityToFieldObject;
import com.apps.twelve.floor.field.data.local.mappers.ConditionObjectToConditionEntity;
import com.apps.twelve.floor.field.data.local.mappers.ConditionSpanValueObjectToConditionSpanValueEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.ConditionTypeObjectToConditionTypeEntity;
import com.apps.twelve.floor.field.data.local.mappers.CropEntityToCropObject;
import com.apps.twelve.floor.field.data.local.mappers.CropObjectToCropEntity;
import com.apps.twelve.floor.field.data.local.mappers.FieldObjectToFieldEntity;
import com.apps.twelve.floor.field.data.local.mappers.InsectObjectToInsectEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.PestObjectToPestEntity;
import com.apps.twelve.floor.field.data.local.mappers.PhaseEntityToPhaseObject;
import com.apps.twelve.floor.field.data.local.mappers.PhaseObjectToPhaseEntity;
import com.apps.twelve.floor.field.data.local.mappers.PhenologicalCharacteristicObjectToPhenologicalCharacteristicEntity;
import com.apps.twelve.floor.field.data.local.mappers.ProductCategoryObjectToProductCategoryEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.SoilTypeEntityToSoilTypeObject;
import com.apps.twelve.floor.field.data.local.mappers.SoilTypeObjectToSoilTypeEntity;
import com.apps.twelve.floor.field.data.local.mappers.TechnologicalProcessStateObjectToTechnologicalProcessStateEntity;
import com.apps.twelve.floor.field.data.local.mappers.TechnologicalSolutionTypeObjectToTechnologicalSolutionTypeEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.TillageDirectionObjectToTillageDirectionEntity;
import com.apps.twelve.floor.field.data.local.objects.CropObject;
import com.apps.twelve.floor.field.data.local.objects.FieldObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionSpanValueObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionTypeObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.PestObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.PhenologicalCharacteristicObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.SoilTypeObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.TillageDirectionObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.ClimateZoneObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.PhaseObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.AggregateObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.FieldTechnologicalProcessSolutionObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.InsectObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.ProductCategoryObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.TechnologicalSolutionTypeObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.TechnologicalProcessStateObject;
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

  public DataManager() {
    App.getAppComponent().inject(this);
  }

  ///////////////////////////////////////////////////////////////////////////
  // DB methods
  ///////////////////////////////////////////////////////////////////////////

  public Observable<List<FieldObject>> getAllFields() {
    return mDbCombinedFieldRelationsHelper.getCombinedFieldEntitiesAsync()
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

  public Observable<List<PhaseObject>> getAllPhases() {
    return Observable.concat(Observable.just(PhaseObject.EMPTY), mDbHelper.getAllPhases()
        .concatMap(Observable::from)
        .map(phaseEntity -> new PhaseEntityToPhaseObject().transform(phaseEntity))).toList();
  }

  public DeleteResult deleteField(FieldObject fieldObject) {
    return mDbHelper.deleteField(new FieldObjectToFieldEntity().transform(fieldObject));
  }

  public Observable<List<CropObject>> getAllCrops() {
    return Observable.concat(Observable.just(CropObject.EMPTY), mDbHelper.getAllCrops()
        .concatMap(Observable::from)
        .map(cropEntity -> new CropEntityToCropObject().transform(cropEntity))).toList();
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
    return Observable.concat(Observable.just(ClimateZoneObject.EMPTY),
        mDbHelper.getAllClimateZones()
            .concatMap(Observable::from)
            .map(climateZoneEntity -> new ClimateZoneEntityToClimateZoneObject().transform(
                climateZoneEntity))).toList();
  }

  public PutResult putConditionType(ConditionTypeObject conditionTypeObject) {
    return mDbHelper.putConditionType(
        new ConditionTypeObjectToConditionTypeEntity().transform(conditionTypeObject));
  }

  public PutResult putSoilType(SoilTypeObject soilTypeObject) {
    return mDbHelper.putSoilType(new SoilTypeObjectToSoilTypeEntity().transform(soilTypeObject));
  }

  public Observable<List<SoilTypeObject>> getAllSoilTypes() {
    return Observable.concat(Observable.just(SoilTypeObject.EMPTY), mDbHelper.getAllSoilTypes()
        .concatMap(Observable::from)
        .map(soilTypeEntity -> new SoilTypeEntityToSoilTypeObject().transform(soilTypeEntity)))
        .toList();
  }

  public PutResult putTechnologicalProcessState(
      TechnologicalProcessStateObject technologicalProcessStateObject) {
    return mDbHelper.putTechnologicalProcessState(
        new TechnologicalProcessStateObjectToTechnologicalProcessStateEntity().transform(
            technologicalProcessStateObject));
  }

  public PutResult putPest(PestObject pestObject) {
    return mDbHelper.putPest(new PestObjectToPestEntity().transform(pestObject));
  }

  public PutResult putTillageDirection(TillageDirectionObject tillageDirectionObject) {
    return mDbHelper.putTillageDirection(
        new TillageDirectionObjectToTillageDirectionEntity().transform(tillageDirectionObject));
  }

  public PutResult putPhenologicalCharacteristic(
      PhenologicalCharacteristicObject phenologicalCharacteristicObject) {
    return mDbHelper.putPhenologicalCharacteristic(
        new PhenologicalCharacteristicObjectToPhenologicalCharacteristicEntity().transform(
            phenologicalCharacteristicObject));
  }

  public PutResult putTechnologicalSolutionType(
      TechnologicalSolutionTypeObject technologicalSolutionTypeObject) {
    return mDbHelper.putTechnologicalSolutionType(
        new TechnologicalSolutionTypeObjectToTechnologicalSolutionTypeEntityMapper().transform(
            technologicalSolutionTypeObject));
  }

  public PutResult putAggregate(AggregateObject aggregateObject) {
    return mDbHelper.putAggregate(
        new AggregateObjectToAggregateEntityMapper().transform(aggregateObject));
  }

  public PutResult putInsect(InsectObject insectObject) {
    return mDbHelper.putInsect(new InsectObjectToInsectEntityMapper().transform(insectObject));
  }

  public PutResult putProductCategory(ProductCategoryObject productCategoryObject) {
    return mDbHelper.putProductCategory(
        new ProductCategoryObjectToProductCategoryEntityMapper().transform(productCategoryObject));
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

  public PutResult putCondition(ConditionObject conditionObject) {
    return mDbHelper.putConditionEntity(
        new ConditionObjectToConditionEntity().transform(conditionObject));
  }

  public PutResult putSpanValue(ConditionSpanValueObject conditionSpanValueObject) {
    return mDbHelper.putConditionSpanValueEntity(
        new ConditionSpanValueObjectToConditionSpanValueEntityMapper().transform(
            conditionSpanValueObject));
  }

  public List<ConditionEntity> getAllConditionEntitiesAsList() {
    return mDbHelper.getAllConditionEntityAsList();
  }
}
