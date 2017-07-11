package com.apps.twelve.floor.field.data.local;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.data.local.entities.CropActiveComponentHarmfulObjectEntity;
import com.apps.twelve.floor.field.data.local.entities.CropEntity;
import com.apps.twelve.floor.field.data.local.entities.DealerEntity;
import com.apps.twelve.floor.field.data.local.entities.FieldEntity;
import com.apps.twelve.floor.field.data.local.entities.PhenologicalCharacteristicEntity;
import com.apps.twelve.floor.field.data.local.entities.SoilTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.TillageDirectionEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionNameEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionSpanValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.PhenologicalCharacteristicValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.SoilTypeValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.TillageDirectionValueEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.HarmfulObjectEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.HarmfulObjectPhaseEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.HarmfulObjectTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.PestClassEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.PestEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.PestOrderEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.WeedClassEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.WeedEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.WeedGroupEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.WeedNutritionTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.process_time.ClimateZoneEntity;
import com.apps.twelve.floor.field.data.local.entities.process_time.PhaseEntity;
import com.apps.twelve.floor.field.data.local.entities.process_time.ProcessPeriodEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.ActiveComponentEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.ActiveComponentInProductEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.AggregateEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.FieldTechnologicalProcessSolutionEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.InsectEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.ProductCategoryEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.ProductEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.TechnologicalSolutionTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.technological_map.CropTechnologicalProcessEntity;
import com.apps.twelve.floor.field.data.local.entities.technological_map.FieldCropTechnologicalProcessEntity;
import com.apps.twelve.floor.field.data.local.entities.technological_map.TechnologicalProcessStateEntity;
import com.apps.twelve.floor.field.data.local.entities.technological_map.TechnologicalProcessesConditionEntity;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionSpanValueObject;
import com.apps.twelve.floor.field.data.local.tables.CropsActiveComponentsHarmfulObjectsTable;
import com.apps.twelve.floor.field.data.local.tables.CropsTable;
import com.apps.twelve.floor.field.data.local.tables.DealersTable;
import com.apps.twelve.floor.field.data.local.tables.FieldsTable;
import com.apps.twelve.floor.field.data.local.tables.PhenologicalCharacteristicsTable;
import com.apps.twelve.floor.field.data.local.tables.SoilTypesTable;
import com.apps.twelve.floor.field.data.local.tables.TillageDirectionsTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.ConditionNamesTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.ConditionSpanValuesTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.ConditionTypesTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.ConditionsTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.PhenologicalCharacteristicValuesTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.SoilTypeValuesTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.TillageDirectionValuesTable;
import com.apps.twelve.floor.field.data.local.tables.harmful_objects.HarmfulObjectPhasesTable;
import com.apps.twelve.floor.field.data.local.tables.harmful_objects.HarmfulObjectTypesTable;
import com.apps.twelve.floor.field.data.local.tables.harmful_objects.HarmfulObjectsTable;
import com.apps.twelve.floor.field.data.local.tables.harmful_objects.PestClassesTable;
import com.apps.twelve.floor.field.data.local.tables.harmful_objects.PestOrdersTable;
import com.apps.twelve.floor.field.data.local.tables.harmful_objects.PestsTable;
import com.apps.twelve.floor.field.data.local.tables.harmful_objects.WeedClassesTable;
import com.apps.twelve.floor.field.data.local.tables.harmful_objects.WeedGroupsTable;
import com.apps.twelve.floor.field.data.local.tables.harmful_objects.WeedNutritionTypesTable;
import com.apps.twelve.floor.field.data.local.tables.harmful_objects.WeedsTable;
import com.apps.twelve.floor.field.data.local.tables.process_time.ClimateZonesTable;
import com.apps.twelve.floor.field.data.local.tables.process_time.PhasesTable;
import com.apps.twelve.floor.field.data.local.tables.process_time.ProcessPeriodsTable;
import com.apps.twelve.floor.field.data.local.tables.solutions.ActiveComponentsTable;
import com.apps.twelve.floor.field.data.local.tables.solutions.AggregatesTable;
import com.apps.twelve.floor.field.data.local.tables.solutions.FieldTechnologicalProcessSolutionsTable;
import com.apps.twelve.floor.field.data.local.tables.solutions.InsectsTable;
import com.apps.twelve.floor.field.data.local.tables.solutions.ProductCategoriesTable;
import com.apps.twelve.floor.field.data.local.tables.solutions.ProductsTable;
import com.apps.twelve.floor.field.data.local.tables.solutions.TechnologicalSolutionTypesTable;
import com.apps.twelve.floor.field.data.local.tables.technological_map.CropTechnologicalProcessesTable;
import com.apps.twelve.floor.field.data.local.tables.technological_map.FieldCropTechnologicalProcessesTable;
import com.apps.twelve.floor.field.data.local.tables.technological_map.TechnologicalProcessStatesTable;
import com.apps.twelve.floor.field.data.local.tables.technological_map.TechnologicalProcessesConditionsTable;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.operations.delete.DeleteResult;
import com.pushtorefresh.storio.sqlite.operations.put.PutResult;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

/**
 * Created by Yaroslav on 11.04.2017.
 */

public class DbHelper {

  @Inject StorIOSQLite mStorIOSQLite;

  public DbHelper() {
    App.getAppComponent().inject(this);
  }

  ///////////////////////////////////////////////////////////////////////////
  // CONDITIONS
  ///////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////
  // Condition
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<ConditionEntity>> getAllConditions() {
    return mStorIOSQLite.get()
        .listOfObjects(ConditionEntity.class)
        .withQuery(ConditionsTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putCondition(ConditionEntity conditionEntity) {
    return mStorIOSQLite.put().object(conditionEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteCondition(ConditionEntity conditionEntity) {
    return mStorIOSQLite.delete().object(conditionEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Condition span value
  ///////////////////////////////////////////////////////////////////////////
  public List<ConditionSpanValueEntity> getConditionSpanValueEntity() {
    return mStorIOSQLite.get()
        .listOfObjects(ConditionSpanValueEntity.class)
        .withQuery(ConditionSpanValuesTable.QUERY_ALL)
        .prepare()
        .executeAsBlocking();
  }

  public PutResult putConditionSpanValueEntity(ConditionSpanValueEntity conditionSpanValueEntity) {
    return mStorIOSQLite.put().object(conditionSpanValueEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteConditionSpanValueEntity(ConditionSpanValueEntity conditionSpanValueEntity) {
    return mStorIOSQLite.delete().object(conditionSpanValueEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Condition type
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<ConditionTypeEntity>> getAllConditionTypes() {
    return mStorIOSQLite.get()
        .listOfObjects(ConditionTypeEntity.class)
        .withQuery(ConditionTypesTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putConditionType(ConditionTypeEntity conditionTypeEntity) {
    return mStorIOSQLite.put().object(conditionTypeEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteConditionType(ConditionTypeEntity conditionTypeEntity) {
    return mStorIOSQLite.delete().object(conditionTypeEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Phenological characteristic value
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<PhenologicalCharacteristicValueEntity>> getAllPhenologicalCharacteristicValues() {
    return mStorIOSQLite.get()
        .listOfObjects(PhenologicalCharacteristicValueEntity.class)
        .withQuery(PhenologicalCharacteristicValuesTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putPhenologicalCharacteristicValue(
      PhenologicalCharacteristicValueEntity phenologicalCharacteristicValueEntity) {
    return mStorIOSQLite.put()
        .object(phenologicalCharacteristicValueEntity)
        .prepare()
        .executeAsBlocking();
  }

  public DeleteResult deletePhenologicalCharacteristicValue(
      PhenologicalCharacteristicValueEntity phenologicalCharacteristicValueEntity) {
    return mStorIOSQLite.delete()
        .object(phenologicalCharacteristicValueEntity)
        .prepare()
        .executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Soil type value
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<SoilTypeValueEntity>> getAllSoilTypeValues() {
    return mStorIOSQLite.get()
        .listOfObjects(SoilTypeValueEntity.class)
        .withQuery(SoilTypeValuesTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putSoilTypeValue(SoilTypeValueEntity soilTypeValueEntity) {
    return mStorIOSQLite.put().object(soilTypeValueEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteSoilTypeValue(SoilTypeValueEntity soilTypeValueEntity) {
    return mStorIOSQLite.delete().object(soilTypeValueEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Tillage direction value
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<TillageDirectionValueEntity>> getAllTillageDirectionValues() {
    return mStorIOSQLite.get()
        .listOfObjects(TillageDirectionValueEntity.class)
        .withQuery(TillageDirectionValuesTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putTillageDirectionValue(
      TillageDirectionValueEntity tillageDirectionValueEntity) {
    return mStorIOSQLite.put().object(tillageDirectionValueEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteTillageDirectionValue(
      TillageDirectionValueEntity tillageDirectionValueEntity) {
    return mStorIOSQLite.delete().object(tillageDirectionValueEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // PROCESS TIME
  ///////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////
  // Climate zone
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<ClimateZoneEntity>> getAllClimateZones() {
    return mStorIOSQLite.get()
        .listOfObjects(ClimateZoneEntity.class)
        .withQuery(ClimateZonesTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putClimateZone(ClimateZoneEntity climateZoneEntity) {
    return mStorIOSQLite.put().object(climateZoneEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteClimateZone(ClimateZoneEntity climateZoneEntity) {
    return mStorIOSQLite.delete().object(climateZoneEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Phase
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<PhaseEntity>> getAllPhases() {
    return mStorIOSQLite.get()
        .listOfObjects(PhaseEntity.class)
        .withQuery(PhasesTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putPhase(PhaseEntity phaseEntity) {
    return mStorIOSQLite.put().object(phaseEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deletePhase(PhaseEntity phaseEntity) {
    return mStorIOSQLite.delete().object(phaseEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Process period
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<ProcessPeriodEntity>> getAllProcessPeriods() {
    return mStorIOSQLite.get()
        .listOfObjects(ProcessPeriodEntity.class)
        .withQuery(ProcessPeriodsTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putProcessPeriod(ProcessPeriodEntity processPeriodEntity) {
    return mStorIOSQLite.put().object(processPeriodEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteProcessPeriod(ProcessPeriodEntity processPeriodEntity) {
    return mStorIOSQLite.delete().object(processPeriodEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // SOLUTIONS
  ///////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////
  // Aggregate
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<AggregateEntity>> getAllAggregates() {
    return mStorIOSQLite.get()
        .listOfObjects(AggregateEntity.class)
        .withQuery(AggregatesTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putAggregate(AggregateEntity aggregateEntity) {
    return mStorIOSQLite.put().object(aggregateEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteAggregate(AggregateEntity aggregateEntity) {
    return mStorIOSQLite.delete().object(aggregateEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Insect
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<InsectEntity>> getAllInsects() {
    return mStorIOSQLite.get()
        .listOfObjects(InsectEntity.class)
        .withQuery(InsectsTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putInsect(InsectEntity insectEntity) {
    return mStorIOSQLite.put().object(insectEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteInsect(InsectEntity insectEntity) {
    return mStorIOSQLite.delete().object(insectEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Active Component
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<ActiveComponentEntity>> getAllActiveComponents() {
    return mStorIOSQLite.get()
        .listOfObjects(ActiveComponentEntity.class)
        .withQuery(ActiveComponentsTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putActiveComponent(ActiveComponentEntity activeComponentEntity) {
    return mStorIOSQLite.put().object(activeComponentEntity).prepare().executeAsBlocking();
  }

  public PutResult putActiveComponentInProduct(
      ActiveComponentInProductEntity activeComponentInProductEntity) {
    return mStorIOSQLite.put().object(activeComponentInProductEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteActiveComponent(ActiveComponentEntity activeComponentEntity) {
    return mStorIOSQLite.delete().object(activeComponentEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Field Technological Process Solution
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<FieldTechnologicalProcessSolutionEntity>> getAllFieldTechnologicalProcessSolutions() {
    return mStorIOSQLite.get()
        .listOfObjects(FieldTechnologicalProcessSolutionEntity.class)
        .withQuery(FieldTechnologicalProcessSolutionsTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putFieldTechnologicalProcessSolution(
      FieldTechnologicalProcessSolutionEntity fieldTechnologicalProcessSolutionEntity) {
    return mStorIOSQLite.put()
        .object(fieldTechnologicalProcessSolutionEntity)
        .prepare()
        .executeAsBlocking();
  }

  public DeleteResult deleteFieldTechnologicalProcessSolution(
      FieldTechnologicalProcessSolutionEntity fieldTechnologicalProcessSolutionEntity) {
    return mStorIOSQLite.delete()
        .object(fieldTechnologicalProcessSolutionEntity)
        .prepare()
        .executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Product Category
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<ProductCategoryEntity>> getAllProductCategories() {
    return mStorIOSQLite.get()
        .listOfObjects(ProductCategoryEntity.class)
        .withQuery(ProductCategoriesTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putProductCategory(ProductCategoryEntity productCategoryEntity) {
    return mStorIOSQLite.put().object(productCategoryEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteProductCategory(ProductCategoryEntity productCategoryEntity) {
    return mStorIOSQLite.delete().object(productCategoryEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Product
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<ProductEntity>> getAllProducts() {
    return mStorIOSQLite.get()
        .listOfObjects(ProductEntity.class)
        .withQuery(ProductsTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putProduct(ProductEntity productEntity) {
    return mStorIOSQLite.put().object(productEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteProduct(ProductEntity productEntity) {
    return mStorIOSQLite.delete().object(productEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Technological Solution Type
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<TechnologicalSolutionTypeEntity>> getAllTechnologicalSolutionTypes() {
    return mStorIOSQLite.get()
        .listOfObjects(TechnologicalSolutionTypeEntity.class)
        .withQuery(TechnologicalSolutionTypesTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putTechnologicalSolutionType(
      TechnologicalSolutionTypeEntity technologicalSolutionTypeEntity) {
    return mStorIOSQLite.put()
        .object(technologicalSolutionTypeEntity)
        .prepare()
        .executeAsBlocking();
  }

  public DeleteResult deleteTechnologicalSolutionType(
      TechnologicalSolutionTypeEntity technologicalSolutionTypeEntity) {
    return mStorIOSQLite.delete()
        .object(technologicalSolutionTypeEntity)
        .prepare()
        .executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // TECHNOLOGICAL MAP
  ///////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////
  // Crop Technological Process
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<CropTechnologicalProcessEntity>> getAllCropTechnologicalProcesses() {
    return mStorIOSQLite.get()
        .listOfObjects(CropTechnologicalProcessEntity.class)
        .withQuery(CropTechnologicalProcessesTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putCropTechnologicalProcess(
      CropTechnologicalProcessEntity cropTechnologicalProcessEntity) {
    return mStorIOSQLite.put().object(cropTechnologicalProcessEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteCropTechnologicalProcess(
      CropTechnologicalProcessEntity cropTechnologicalProcessEntity) {
    return mStorIOSQLite.delete()
        .object(cropTechnologicalProcessEntity)
        .prepare()
        .executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Field Crop Technological Process
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<FieldCropTechnologicalProcessEntity>> getAllFieldCropTechnologicalProcesses() {
    return mStorIOSQLite.get()
        .listOfObjects(FieldCropTechnologicalProcessEntity.class)
        .withQuery(FieldCropTechnologicalProcessesTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putFieldCropTechnologicalProcess(
      FieldCropTechnologicalProcessEntity fieldCropTechnologicalProcessEntity) {
    return mStorIOSQLite.put()
        .object(fieldCropTechnologicalProcessEntity)
        .prepare()
        .executeAsBlocking();
  }

  public DeleteResult deleteFieldCropTechnologicalProcess(
      FieldCropTechnologicalProcessEntity fieldCropTechnologicalProcessEntity) {
    return mStorIOSQLite.delete()
        .object(fieldCropTechnologicalProcessEntity)
        .prepare()
        .executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Technological Processes Condition
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<TechnologicalProcessesConditionEntity>> getAllTechnologicalProcessesConditions() {
    return mStorIOSQLite.get()
        .listOfObjects(TechnologicalProcessesConditionEntity.class)
        .withQuery(TechnologicalProcessesConditionsTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putTechnologicalProcessesCondition(
      TechnologicalProcessesConditionEntity technologicalProcessesConditionEntity) {
    return mStorIOSQLite.put()
        .object(technologicalProcessesConditionEntity)
        .prepare()
        .executeAsBlocking();
  }

  public DeleteResult deleteTechnologicalProcessesCondition(
      TechnologicalProcessesConditionEntity technologicalProcessesConditionEntity) {
    return mStorIOSQLite.delete()
        .object(technologicalProcessesConditionEntity)
        .prepare()
        .executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Technological Process State
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<TechnologicalProcessStateEntity>> getAllTechnologicalProcessStates() {
    return mStorIOSQLite.get()
        .listOfObjects(TechnologicalProcessStateEntity.class)
        .withQuery(TechnologicalProcessStatesTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putTechnologicalProcessState(
      TechnologicalProcessStateEntity technologicalProcessStateEntity) {
    return mStorIOSQLite.put()
        .object(technologicalProcessStateEntity)
        .prepare()
        .executeAsBlocking();
  }

  public DeleteResult deleteTechnologicalProcessState(
      TechnologicalProcessStateEntity technologicalProcessStateEntity) {
    return mStorIOSQLite.delete()
        .object(technologicalProcessStateEntity)
        .prepare()
        .executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // HARMFUL OBJECTS
  ///////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////
  // Harmful object type
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<HarmfulObjectTypeEntity>> getAllHarmfulObjectTypes() {
    return mStorIOSQLite.get()
        .listOfObjects(HarmfulObjectTypeEntity.class)
        .withQuery(HarmfulObjectTypesTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putHarmfulObjectType(HarmfulObjectTypeEntity harmfulObjectTypeEntity) {
    return mStorIOSQLite.put().object(harmfulObjectTypeEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteHarmfulObjectType(HarmfulObjectTypeEntity harmfulObjectTypeEntity) {
    return mStorIOSQLite.delete().object(harmfulObjectTypeEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Harmful object
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<HarmfulObjectEntity>> getAllHarmfulObjects() {
    return mStorIOSQLite.get()
        .listOfObjects(HarmfulObjectEntity.class)
        .withQuery(HarmfulObjectsTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putHarmfulObject(HarmfulObjectEntity harmfulObjectEntity) {
    return mStorIOSQLite.put().object(harmfulObjectEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteHarmfulObject(HarmfulObjectEntity harmfulObjectEntity) {
    return mStorIOSQLite.delete().object(harmfulObjectEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Harmful Object phase
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<HarmfulObjectPhaseEntity>> getAllHarmfulObjectPhases() {
    return mStorIOSQLite.get()
        .listOfObjects(HarmfulObjectPhaseEntity.class)
        .withQuery(HarmfulObjectPhasesTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putHarmfulObjectPhase(HarmfulObjectPhaseEntity harmfulObjectPhaseEntity) {
    return mStorIOSQLite.put().object(harmfulObjectPhaseEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteHarmfulObjectPhase(HarmfulObjectPhaseEntity harmfulObjectPhaseEntity) {
    return mStorIOSQLite.delete().object(harmfulObjectPhaseEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Weed nutrition type
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<WeedNutritionTypeEntity>> getAllWeedNutritionTypes() {
    return mStorIOSQLite.get()
        .listOfObjects(WeedNutritionTypeEntity.class)
        .withQuery(WeedNutritionTypesTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putWeedNutritionType(WeedNutritionTypeEntity weedNutritionTypeEntity) {
    return mStorIOSQLite.put().object(weedNutritionTypeEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteWeedNutritionType(WeedNutritionTypeEntity weedNutritionTypeEntity) {
    return mStorIOSQLite.delete().object(weedNutritionTypeEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Weed class
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<WeedClassEntity>> getAllWeedClasses() {
    return mStorIOSQLite.get()
        .listOfObjects(WeedClassEntity.class)
        .withQuery(WeedClassesTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putWeedClass(WeedClassEntity weedClassEntity) {
    return mStorIOSQLite.put().object(weedClassEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteWeedClass(WeedClassEntity weedClassEntity) {
    return mStorIOSQLite.delete().object(weedClassEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Weed group
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<WeedGroupEntity>> getAllWeedGroups() {
    return mStorIOSQLite.get()
        .listOfObjects(WeedGroupEntity.class)
        .withQuery(WeedGroupsTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putWeedGroup(WeedGroupEntity weedGroupEntity) {
    return mStorIOSQLite.put().object(weedGroupEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteWeedGroup(WeedGroupEntity weedGroupEntity) {
    return mStorIOSQLite.delete().object(weedGroupEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Weed
  ///////////////////////////////////////////////////////////////////////////
  public List<WeedEntity> getAllWeed() {
    return mStorIOSQLite.get()
        .listOfObjects(WeedEntity.class)
        .withQuery(WeedsTable.QUERY_ALL)
        .prepare()

        .executeAsBlocking()
        //.asRxObservable()
        //.take(1)
        ;
  }

  public PutResult putWeed(WeedEntity weedEntity) {
    return mStorIOSQLite.put().object(weedEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteWeed(WeedEntity weedEntity) {
    return mStorIOSQLite.delete().object(weedEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Pest class
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<PestClassEntity>> getAllPestClasses() {
    return mStorIOSQLite.get()
        .listOfObjects(PestClassEntity.class)
        .withQuery(PestClassesTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putPestClass(PestClassEntity pestClassEntity) {
    return mStorIOSQLite.put().object(pestClassEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deletePestClass(PestClassEntity pestClassEntity) {
    return mStorIOSQLite.delete().object(pestClassEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Pest order
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<PestOrderEntity>> getAllPestOrders() {
    return mStorIOSQLite.get()
        .listOfObjects(PestOrderEntity.class)
        .withQuery(PestOrdersTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putPestOrder(PestOrderEntity pestOrderEntity) {
    return mStorIOSQLite.put().object(pestOrderEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deletePestOrder(PestOrderEntity pestOrderEntity) {
    return mStorIOSQLite.delete().object(pestOrderEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Pest
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<PestEntity>> getAllPests() {
    return mStorIOSQLite.get()
        .listOfObjects(PestEntity.class)
        .withQuery(PestsTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putPest(PestEntity pestEntity) {
    return mStorIOSQLite.put().object(pestEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deletePest(PestEntity pestEntity) {
    return mStorIOSQLite.delete().object(pestEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // OTHER
  ///////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////
  // Crop
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<CropEntity>> getAllCrops() {
    return mStorIOSQLite.get()
        .listOfObjects(CropEntity.class)
        .withQuery(CropsTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public Observable<List<CropEntity>> getSupportedCrops() {

    List<CropEntity> cropEntities = mStorIOSQLite.get()
        .listOfObjects(CropEntity.class)
        .withQuery(CropsTable.QUERY_ALL_SUPPORTED)
        .prepare()
        .executeAsBlocking();

    return mStorIOSQLite.get()
        .listOfObjects(CropEntity.class)
        .withQuery(CropsTable.QUERY_ALL_SUPPORTED)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public Observable<CropEntity> getCropById(long id) {
    return mStorIOSQLite.get()
        .object(CropEntity.class)
        .withQuery(CropsTable.getCropByIdQuery(id))
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putCrop(CropEntity cropEntity) {
    return mStorIOSQLite.put().object(cropEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteCrop(CropEntity cropEntity) {
    return mStorIOSQLite.delete().object(cropEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Dealer
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<DealerEntity>> getAllDealers() {
    return mStorIOSQLite.get()
        .listOfObjects(DealerEntity.class)
        .withQuery(DealersTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putDealer(DealerEntity dealerEntity) {
    return mStorIOSQLite.put().object(dealerEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteDealer(DealerEntity dealerEntity) {
    return mStorIOSQLite.delete().object(dealerEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Field
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<FieldEntity>> getAllFields() {
    return mStorIOSQLite.get()
        .listOfObjects(FieldEntity.class)
        .withQuery(FieldsTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public List<FieldEntity> getAllFieldsAsList() {
    return mStorIOSQLite.get()
        .listOfObjects(FieldEntity.class)
        .withQuery(FieldsTable.QUERY_ALL)
        .prepare()
        .executeAsBlocking();
  }

  public PutResult putField(FieldEntity fieldEntity) {
    return mStorIOSQLite.put().object(fieldEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteField(FieldEntity fieldEntity) {
    return mStorIOSQLite.delete().object(fieldEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Crop Active component Harmful object
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<CropActiveComponentHarmfulObjectEntity>> getAllCropsActiveComponentsHarmfulObjects() {
    return mStorIOSQLite.get()
        .listOfObjects(CropActiveComponentHarmfulObjectEntity.class)
        .withQuery(CropsActiveComponentsHarmfulObjectsTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putCropActiveComponentHarmfulObject(
      CropActiveComponentHarmfulObjectEntity cropActiveComponentHarmfulObjectEntity) {
    return mStorIOSQLite.put()
        .object(cropActiveComponentHarmfulObjectEntity)
        .prepare()
        .executeAsBlocking();
  }

  public DeleteResult deleteCropActiveComponentHarmfulObject(
      CropActiveComponentHarmfulObjectEntity cropActiveComponentHarmfulObjectEntity) {
    return mStorIOSQLite.delete()
        .object(cropActiveComponentHarmfulObjectEntity)
        .prepare()
        .executeAsBlocking();
  }

  public PutResult putConditionEntity(ConditionEntity conditionEntity) {
    return mStorIOSQLite.put().object(conditionEntity).prepare().executeAsBlocking();
  }

  public List<ConditionEntity> getAllConditionEntityAsList() {
    return mStorIOSQLite.get()
        .listOfObjects(ConditionEntity.class)
        .withQuery(ConditionsTable.QUERY_ALL)
        .prepare()
        .executeAsBlocking();
  }

  public List<ProcessPeriodEntity> getAllProcessPeriodEntitiesAsList() {
    return mStorIOSQLite.get()
        .listOfObjects(ProcessPeriodEntity.class)
        .withQuery(ProcessPeriodsTable.QUERY_ALL)
        .prepare()
        .executeAsBlocking();
  }

  public PutResult putConditionName(ConditionNameEntity conditionNameEntity) {
    return mStorIOSQLite.put().object(conditionNameEntity).prepare().executeAsBlocking();
  }

  public List<ConditionNameEntity> getAllConditionNameEntitiesAsList() {
    return mStorIOSQLite.get()
        .listOfObjects(ConditionNameEntity.class)
        .withQuery(ConditionNamesTable.QUERY_ALL)
        .prepare()
        .executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Tillage direction
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<TillageDirectionEntity>> getAllTillageDirections() {
    return mStorIOSQLite.get()
        .listOfObjects(TillageDirectionEntity.class)
        .withQuery(TillageDirectionsTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putTillageDirection(TillageDirectionEntity tillageDirectionEntity) {
    return mStorIOSQLite.put().object(tillageDirectionEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteTillageDirection(TillageDirectionEntity tillageDirectionEntity) {
    return mStorIOSQLite.delete().object(tillageDirectionEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Phenological characteristic
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<PhenologicalCharacteristicEntity>> getAllPhenologicalCharacteristics() {
    return mStorIOSQLite.get()
        .listOfObjects(PhenologicalCharacteristicEntity.class)
        .withQuery(PhenologicalCharacteristicsTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putPhenologicalCharacteristic(
      PhenologicalCharacteristicEntity phenologicalCharacteristicEntity) {
    return mStorIOSQLite.put()
        .object(phenologicalCharacteristicEntity)
        .prepare()
        .executeAsBlocking();
  }

  public DeleteResult deletePhenologicalCharacteristic(
      PhenologicalCharacteristicEntity phenologicalCharacteristicEntity) {
    return mStorIOSQLite.delete()
        .object(phenologicalCharacteristicEntity)
        .prepare()
        .executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Soil type
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<SoilTypeEntity>> getAllSoilTypes() {
    return mStorIOSQLite.get()
        .listOfObjects(SoilTypeEntity.class)
        .withQuery(SoilTypesTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putSoilType(SoilTypeEntity soilTypeEntity) {
    return mStorIOSQLite.put().object(soilTypeEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteSoilType(SoilTypeEntity soilTypeEntity) {
    return mStorIOSQLite.delete().object(soilTypeEntity).prepare().executeAsBlocking();
  }
}
