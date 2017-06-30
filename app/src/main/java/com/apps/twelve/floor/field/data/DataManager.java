package com.apps.twelve.floor.field.data;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.data.local.DbCombinedFieldRelationsHelper;
import com.apps.twelve.floor.field.data.local.DbHelper;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionEntity;
import com.apps.twelve.floor.field.data.local.entities.process_time.ProcessPeriodEntity;
import com.apps.twelve.floor.field.data.local.mappers.AggregateObjectToAggregateEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.ClimateZoneEntityToClimateZoneObjectMapper;
import com.apps.twelve.floor.field.data.local.mappers.ClimateZoneObjectToClimateZoneEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.CombinedFieldEntityToFieldObjectMapper;
import com.apps.twelve.floor.field.data.local.mappers.ConditionObjectToConditionEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.ConditionSpanValueObjectToConditionSpanValueEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.ConditionTypeObjectToConditionTypeEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.CropEntityToCropObjectMapper;
import com.apps.twelve.floor.field.data.local.mappers.CropObjectToCropEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.FieldObjectToFieldEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.InsectObjectToInsectEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.PestObjectToPestEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.PhaseEntityToPhaseObjectMapper;
import com.apps.twelve.floor.field.data.local.mappers.PhaseObjectToPhaseEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.PhenologicalCharacteristicObjectToPhenologicalCharacteristicEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.ProductCategoryObjectToProductCategoryEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.ProductObjectToProductEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.SoilTypeEntityToSoilTypeObjectMapper;
import com.apps.twelve.floor.field.data.local.mappers.SoilTypeObjectToSoilTypeEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.TechnologicalProcessStateObjectToTechnologicalProcessStateEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.TechnologicalSolutionTypeObjectToTechnologicalSolutionTypeEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.TillageDirectionObjectToTillageDirectionEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.WeedNutritionTypeObjectToWeedNutritionTypeEntityMapper;
import com.apps.twelve.floor.field.data.local.objects.CropObject;
import com.apps.twelve.floor.field.data.local.objects.FieldObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionSpanValueObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionTypeObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.PestObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.PhenologicalCharacteristicObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.SoilTypeObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.TillageDirectionObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.WeedNutritionTypeObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.ClimateZoneObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.PhaseObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.AggregateObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.FieldTechnologicalProcessSolutionObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.InsectObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.ProductCategoryObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.ProductObject;
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
        .map(combinedFieldEntity -> new CombinedFieldEntityToFieldObjectMapper().transform(
            combinedFieldEntity))
        .toList();
  }

  public PutResult putField(FieldObject fieldObject) {
    return mDbHelper.putField(new FieldObjectToFieldEntityMapper().transform(fieldObject));
  }

  public PutResult putPhase(PhaseObject phaseObject) {
    return mDbHelper.putPhase(new PhaseObjectToPhaseEntityMapper().transform(phaseObject));
  }

  public Observable<List<PhaseObject>> getAllPhases() {
    return Observable.concat(Observable.just(PhaseObject.EMPTY), mDbHelper.getAllPhases()
        .concatMap(Observable::from)
        .map(phaseEntity -> new PhaseEntityToPhaseObjectMapper().transform(phaseEntity))).toList();
  }

  public DeleteResult deleteField(FieldObject fieldObject) {
    return mDbHelper.deleteField(new FieldObjectToFieldEntityMapper().transform(fieldObject));
  }

  public Observable<List<CropObject>> getAllCrops() {
    return Observable.concat(Observable.just(CropObject.EMPTY), mDbHelper.getAllCrops()
        .concatMap(Observable::from)
        .map(cropEntity -> new CropEntityToCropObjectMapper().transform(cropEntity))).toList();
  }

  public Observable<List<CropObject>> getSupportedCrops() {
    return Observable.concat(Observable.just(CropObject.EMPTY), mDbHelper.getSupportedCrops()
        .concatMap(Observable::from)
        .map(cropEntity -> new CropEntityToCropObjectMapper().transform(cropEntity))).toList();
  }

  public Observable<CropObject> getCropById(long id) {
    return mDbHelper.getCropById(id)
        .map(cropEntity -> new CropEntityToCropObjectMapper().transform(cropEntity))
        .take(1);
  }

  public PutResult putCrop(CropObject cropObject) {
    return mDbHelper.putCrop(new CropObjectToCropEntityMapper().transform(cropObject));
  }

  public PutResult putClimateZone(ClimateZoneObject climateZoneObject) {
    return mDbHelper.putClimateZone(
        new ClimateZoneObjectToClimateZoneEntityMapper().transform(climateZoneObject));
  }

  public Observable<List<ClimateZoneObject>> getAllClimateZones() {
    return Observable.concat(Observable.just(ClimateZoneObject.EMPTY),
        mDbHelper.getAllClimateZones()
            .concatMap(Observable::from)
            .map(climateZoneEntity -> new ClimateZoneEntityToClimateZoneObjectMapper().transform(
                climateZoneEntity))).toList();
  }

  public PutResult putConditionType(ConditionTypeObject conditionTypeObject) {
    return mDbHelper.putConditionType(
        new ConditionTypeObjectToConditionTypeEntityMapper().transform(conditionTypeObject));
  }

  public PutResult putSoilType(SoilTypeObject soilTypeObject) {
    return mDbHelper.putSoilType(
        new SoilTypeObjectToSoilTypeEntityMapper().transform(soilTypeObject));
  }

  public Observable<List<SoilTypeObject>> getAllSoilTypes() {
    return Observable.concat(Observable.just(SoilTypeObject.EMPTY), mDbHelper.getAllSoilTypes()
        .concatMap(Observable::from)
        .map(
            soilTypeEntity -> new SoilTypeEntityToSoilTypeObjectMapper().transform(soilTypeEntity)))
        .toList();
  }

  public PutResult putTechnologicalProcessState(
      TechnologicalProcessStateObject technologicalProcessStateObject) {
    return mDbHelper.putTechnologicalProcessState(
        new TechnologicalProcessStateObjectToTechnologicalProcessStateEntityMapper().transform(
            technologicalProcessStateObject));
  }

  public PutResult putPest(PestObject pestObject) {
    return mDbHelper.putPest(new PestObjectToPestEntityMapper().transform(pestObject));
  }

  public PutResult putTillageDirection(TillageDirectionObject tillageDirectionObject) {
    return mDbHelper.putTillageDirection(
        new TillageDirectionObjectToTillageDirectionEntityMapper().transform(
            tillageDirectionObject));
  }

  public PutResult putWeedNutritionType(WeedNutritionTypeObject weedNutritionTypeObject) {
    return mDbHelper.putWeedNutritionType(
        new WeedNutritionTypeObjectToWeedNutritionTypeEntityMapper().transform(
            weedNutritionTypeObject));
  }

  public PutResult putPhenologicalCharacteristic(
      PhenologicalCharacteristicObject phenologicalCharacteristicObject) {
    return mDbHelper.putPhenologicalCharacteristic(
        new PhenologicalCharacteristicObjectToPhenologicalCharacteristicEntityMapper().transform(
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

  public PutResult putProduct(ProductObject productObject) {
    return mDbHelper.putProduct(new ProductObjectToProductEntityMapper().transform(productObject));
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
        new ConditionObjectToConditionEntityMapper().transform(conditionObject));
  }

  public PutResult putSpanValue(ConditionSpanValueObject conditionSpanValueObject) {
    return mDbHelper.putConditionSpanValueEntity(
        new ConditionSpanValueObjectToConditionSpanValueEntityMapper().transform(
            conditionSpanValueObject));
  }

  public List<ConditionEntity> getAllConditionEntitiesAsList() {
    return mDbHelper.getAllConditionEntityAsList();
  }

  public PutResult putProcessPeriod(ProcessPeriodEntity processPeriodEntity) {
    return mDbHelper.putProcessPeriod(processPeriodEntity);
  }

  public List<ProcessPeriodEntity> getAllProcessPeriodEntitiesAsList() {
    return mDbHelper.getAllProcessPeriodEntitiesAsList();
  }
}
