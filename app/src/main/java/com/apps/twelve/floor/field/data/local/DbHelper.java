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
import com.apps.twelve.floor.field.data.local.entities.process_time.ClimateZoneEntity;
import com.apps.twelve.floor.field.data.local.entities.process_time.PhaseEntity;
import com.apps.twelve.floor.field.data.local.entities.process_time.ProcessPeriodEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.AggregateEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.FieldTechnologicalProcessSolutionEntity;
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
import com.apps.twelve.floor.field.data.local.tables.process_time.ClimateZonesTable;
import com.apps.twelve.floor.field.data.local.tables.process_time.PhasesTable;
import com.apps.twelve.floor.field.data.local.tables.process_time.ProcessPeriodsTable;
import com.apps.twelve.floor.field.data.local.tables.solutions.AggregatesTable;
import com.apps.twelve.floor.field.data.local.tables.solutions.FieldTechnologicalProcessSolutionsTable;
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

  ///////////////////////////////////////////////////////////////////////////
  // OTHER
  ///////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////
  // Crop
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<CropEntity>> getAllCrops() {
    return mStorIOSQLite.get().listOfObjects(CropEntity.class)
        .withQuery(CropsTable.QUERY_ALL)
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

  ///////////////////////////////////////////////////////////////////////////
  // Field
  ///////////////////////////////////////////////////////////////////////////
  public Observable<List<FieldEntity>> getAllFields() {
    return mStorIOSQLite.get().listOfObjects(FieldEntity.class).withQuery(FieldsTable.QUERY_ALL)
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
}
