package com.apps.twelve.floor.field.data.local;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.data.local.entities.CropEntity;
import com.apps.twelve.floor.field.data.local.entities.DealerEntity;
import com.apps.twelve.floor.field.data.local.entities.FieldEntity;
import com.apps.twelve.floor.field.data.local.entities.ProductPestCropEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionSpanValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.PestEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.PestPhaseEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.PhenologicalCharacteristicEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.SoilTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.TillageDirectionEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.WeedGroupEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.WeedNutritionTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.process_time.ClimateZoneEntity;
import com.apps.twelve.floor.field.data.local.entities.process_time.PhaseEntity;
import com.apps.twelve.floor.field.data.local.entities.process_time.ProcessPeriodEntity;
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
import com.apps.twelve.floor.field.data.local.tables.CropsTable;
import com.apps.twelve.floor.field.data.local.tables.DealersTable;
import com.apps.twelve.floor.field.data.local.tables.FieldsTable;
import com.apps.twelve.floor.field.data.local.tables.ProductsPestsCropsTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.ConditionSpanValuesTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.ConditionTypesTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.ConditionsTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.PestPhasesTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.PestsTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.PhenologicalCharacteristicsTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.SoilTypesTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.TillageDirectionsTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.WeedGroupsTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.WeedNutritionTypesTable;
import com.apps.twelve.floor.field.data.local.tables.process_time.ClimateZonesTable;
import com.apps.twelve.floor.field.data.local.tables.process_time.PhasesTable;
import com.apps.twelve.floor.field.data.local.tables.process_time.ProcessPeriodsTable;
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
  public Observable<List<ConditionSpanValueEntity>> getAllConditionSpanValues() {
    return mStorIOSQLite.get()
        .listOfObjects(ConditionSpanValueEntity.class)
        .withQuery(ConditionSpanValuesTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putConditionSpanValue(ConditionSpanValueEntity conditionSpanValueEntity) {
    return mStorIOSQLite.put().object(conditionSpanValueEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteConditionSpanValue(ConditionSpanValueEntity conditionSpanValueEntity) {
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

  // Pest phase
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<PestPhaseEntity>> getAllPestPhases() {
    return mStorIOSQLite.get()
        .listOfObjects(PestPhaseEntity.class)
        .withQuery(PestPhasesTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putPestPhase(PestPhaseEntity pestPhaseEntity) {
    return mStorIOSQLite.put().object(pestPhaseEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deletePestPhase(PestPhaseEntity pestPhaseEntity) {
    return mStorIOSQLite.delete().object(pestPhaseEntity).prepare().executeAsBlocking();
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
  // Product Pest Crop
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<ProductPestCropEntity>> getAllProductsPestsCrops() {
    return mStorIOSQLite.get()
        .listOfObjects(ProductPestCropEntity.class)
        .withQuery(ProductsPestsCropsTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putProductPestCrop(ProductPestCropEntity productPestCropEntity) {
    return mStorIOSQLite.put().object(productPestCropEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteProductPestCrop(ProductPestCropEntity productPestCropEntity) {
    return mStorIOSQLite.delete().object(productPestCropEntity).prepare().executeAsBlocking();
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

  public PutResult putConditionSpanValueEntity(ConditionSpanValueEntity conditionSpanValueEntity) {
    return mStorIOSQLite.put().object(conditionSpanValueEntity).prepare().executeAsBlocking();
  }

  public List<ProcessPeriodEntity> getAllProcessPeriodEntitiesAsList() {
    return mStorIOSQLite.get()
        .listOfObjects(ProcessPeriodEntity.class)
        .withQuery(ProcessPeriodsTable.QUERY_ALL)
        .prepare()
        .executeAsBlocking();
  }
}
