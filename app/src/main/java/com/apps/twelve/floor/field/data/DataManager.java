package com.apps.twelve.floor.field.data;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.data.local.DbCombinedFieldRelationsHelper;
import com.apps.twelve.floor.field.data.local.DbHelper;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionNameEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.SpanConditionValueEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.WeedEntity;
import com.apps.twelve.floor.field.data.local.entities.process_time.ProcessPeriodEntity;
import com.apps.twelve.floor.field.data.local.entities.technological_map.FieldCropTechnologicalProcessConditionEntity;
import com.apps.twelve.floor.field.data.local.mappers.CombinedFieldEntityToFieldObjectMapper;
import com.apps.twelve.floor.field.data.local.mappers.CropEntityToCropObjectMapper;
import com.apps.twelve.floor.field.data.local.mappers.CropObjectToCropEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.FieldObjectToFieldEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.PhenologicalCharacteristicObjectToPhenologicalCharacteristicEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.SoilTypeEntityToSoilTypeObjectMapper;
import com.apps.twelve.floor.field.data.local.mappers.SoilTypeObjectToSoilTypeEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.TillageDirectionObjectToTillageDirectionEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.conditions.ConditionNameObjectToConditionNameEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.conditions.ConditionObjectToConditionEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.conditions.ConditionTypeObjectToConditionTypeEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.conditions.HarmfulObjectConditionValueObjectToHarmfulObjectConditionValueEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.conditions.HarmfulObjectPhaseConditionValueObjectToHarmfulObjectPhaseConditionValueEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.conditions.PhenologicalCharacteristicConditionValueObjectToPhenologicalCharacteristicConditionValueEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.conditions.PreviousCropConditionValueObjectToPreviousCropConditionValueEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.conditions.SoilTypeConditionValueObjectToSoilTypeConditionValueEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.conditions.SpanConditionConditionValueObjectToSpanConditionConditionValueEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.conditions.TillageDirectionConditionValueObjectToTillageDirectionConditionValueEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.harmful_objects.DiseaseObjectToDiseaseEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.harmful_objects.DiseasePathogenTypeObjectToDiseasePathogenTypeEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.harmful_objects.HarmfulObjectObjectToHarmfulObjectEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.harmful_objects.HarmfulObjectPhaseObjectToHarmfulObjectPhaseEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.harmful_objects.HarmfulObjectTypeObjectToHarmfulObjectTypeEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.harmful_objects.PestClassObjectToPestClassEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.harmful_objects.PestObjectToPestEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.harmful_objects.PestOrderObjectToPestOrderEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.harmful_objects.WeedClassObjectToWeedClassEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.harmful_objects.WeedGroupObjectToWeedGroupEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.harmful_objects.WeedNutritionTypeObjectToWeedNutritionTypeEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.harmful_objects.WeedObjectToWeedEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.process_time.ClimateZoneEntityToClimateZoneObjectMapper;
import com.apps.twelve.floor.field.data.local.mappers.process_time.ClimateZoneObjectToClimateZoneEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.process_time.PhaseEntityToPhaseObjectMapper;
import com.apps.twelve.floor.field.data.local.mappers.process_time.PhaseObjectToPhaseEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.process_time.ProcessPeriodObjectToProcessPeriodEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.solutions.ActiveComponentInProductObjectToActiveComponentInProductEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.solutions.ActiveComponentObjectToActiveComponentEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.solutions.AggregateObjectToAggregateEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.solutions.InsectObjectToInsectEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.solutions.ProductCategoryObjectToProductCategoryEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.solutions.ProductObjectToProductEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.solutions.TechnologicalSolutionObjectToTechnologicalSolutionEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.solutions.TechnologicalSolutionTypeObjectToTechnologicalSolutionTypeEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.technological_map.CropTechnologicalProcessObjectToCropTechnologicalProcessEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.technological_map.CropTechnologicalProcessesSequenceObjectToCropTechnologicalProcessesSequenceEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.technological_map.FieldCropTechnologicalProcessConditionObjectToFieldCropTechnologicalProcessConditionEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.technological_map.TechnologicalProcessConditionObjectToTechnologicalProcessConditionEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.technological_map.TechnologicalProcessStateObjectToTechnologicalProcessStateEntityMapper;
import com.apps.twelve.floor.field.data.local.objects.CropObject;
import com.apps.twelve.floor.field.data.local.objects.FieldObject;
import com.apps.twelve.floor.field.data.local.objects.PhenologicalCharacteristicObject;
import com.apps.twelve.floor.field.data.local.objects.SoilTypeObject;
import com.apps.twelve.floor.field.data.local.objects.TillageDirectionObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionNameObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionTypeObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.HarmfulObjectConditionValueObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.HarmfulObjectPhaseConditionValueObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.PhenologicalCharacteristicConditionValueObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.PreviousCropConditionValueObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.SoilTypeConditionValueObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.SpanConditionValueObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.TillageDirectionConditionValueObject;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.DiseaseObject;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.DiseasePathogenTypeObject;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.HarmfulObjectObject;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.HarmfulObjectPhaseObject;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.HarmfulObjectTypeObject;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.PestClassObject;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.PestObject;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.PestOrderObject;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.WeedClassObject;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.WeedGroupObject;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.WeedNutritionTypeObject;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.WeedObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.ClimateZoneObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.PhaseObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.ProcessPeriodObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.ActiveComponentInProductObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.ActiveComponentObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.AggregateObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.BaseTechnologicalSolutionObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.FieldTechnologicalProcessSolutionObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.InsectObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.ProductCategoryObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.ProductObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.TechnologicalSolutionObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.TechnologicalSolutionTypeObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.CropTechnologicalProcessObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.CropTechnologicalProcessesSequenceObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessConditionObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.TechnologicalProcessConditionObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.TechnologicalProcessStateObject;
import com.apps.twelve.floor.field.utils.TestUtils;
import com.pushtorefresh.storio.sqlite.operations.delete.DeleteResult;
import com.pushtorefresh.storio.sqlite.operations.put.PutResult;
import java.util.ArrayList;
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

  public PutResult putSoilTypeValue(SoilTypeConditionValueObject soilTypeConditionValueObject) {
    return mDbHelper.putSoilTypeValue(
        new SoilTypeConditionValueObjectToSoilTypeConditionValueEntityMapper().transform(
            soilTypeConditionValueObject));
  }

  public PutResult putHarmfulObjectValue(HarmfulObjectConditionValueObject harmfulObjectValue) {
    return mDbHelper.putHarmfulObjectValue(
        new HarmfulObjectConditionValueObjectToHarmfulObjectConditionValueEntityMapper().transform(
            harmfulObjectValue));
  }

  public PutResult putHarmfulObjectPhaseValue(
      HarmfulObjectPhaseConditionValueObject harmfulObjectPhaseValue) {
    return mDbHelper.putHarmfulObjectPhaseValue(
        new HarmfulObjectPhaseConditionValueObjectToHarmfulObjectPhaseConditionValueEntityMapper().transform(
            harmfulObjectPhaseValue));
  }

  public PutResult putPreviousCropValue(
      PreviousCropConditionValueObject previousCropConditionValueObject) {
    return mDbHelper.putPreviousCropValue(
        new PreviousCropConditionValueObjectToPreviousCropConditionValueEntityMapper().transform(
            previousCropConditionValueObject));
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

  public PutResult putCropTechnologicalProcess(
      CropTechnologicalProcessObject cropTechnologicalProcessObject) {
    return mDbHelper.putCropTechnologicalProcess(
        new CropTechnologicalProcessObjectToCropTechnologicalProcessEntityMapper().transform(
            cropTechnologicalProcessObject));
  }

  public PutResult putHarmfulObjectType(HarmfulObjectTypeObject harmfulObjectTypeObject) {
    return mDbHelper.putHarmfulObjectType(
        new HarmfulObjectTypeObjectToHarmfulObjectTypeEntityMapper().transform(
            harmfulObjectTypeObject));
  }

  public PutResult putHarmfulObject(HarmfulObjectObject harmfulObjectObject) {
    return mDbHelper.putHarmfulObject(
        new HarmfulObjectObjectToHarmfulObjectEntityMapper().transform(harmfulObjectObject));
  }

  public PutResult putHarmfulObjectPhase(HarmfulObjectPhaseObject harmfulObjectPhaseObject) {
    return mDbHelper.putHarmfulObjectPhase(
        new HarmfulObjectPhaseObjectToHarmfulObjectPhaseEntityMapper().transform(
            harmfulObjectPhaseObject));
  }

  public PutResult putPestClass(PestClassObject pestClassObject) {
    return mDbHelper.putPestClass(
        new PestClassObjectToPestClassEntityMapper().transform(pestClassObject));
  }

  public PutResult putPestOrder(PestOrderObject pestOrderObject) {
    return mDbHelper.putPestOrder(
        new PestOrderObjectToPestOrderEntityMapper().transform(pestOrderObject));
  }

  public PutResult putPest(PestObject pestObject) {
    return mDbHelper.putPest(new PestObjectToPestEntityMapper().transform(pestObject));
  }

  public PutResult putTillageDirection(TillageDirectionObject tillageDirectionObject) {
    return mDbHelper.putTillageDirection(
        new TillageDirectionObjectToTillageDirectionEntityMapper().transform(
            tillageDirectionObject));
  }

  public PutResult putTillageDirectionValue(
      TillageDirectionConditionValueObject tillageDirectionConditionValueObject) {
    return mDbHelper.putTillageDirectionValue(
        new TillageDirectionConditionValueObjectToTillageDirectionConditionValueEntityMapper().transform(
            tillageDirectionConditionValueObject));
  }

  public PutResult putWeedNutritionType(WeedNutritionTypeObject weedNutritionTypeObject) {
    return mDbHelper.putWeedNutritionType(
        new WeedNutritionTypeObjectToWeedNutritionTypeEntityMapper().transform(
            weedNutritionTypeObject));
  }

  public PutResult putWeedClass(WeedClassObject weedClassObject) {
    return mDbHelper.putWeedClass(
        new WeedClassObjectToWeedClassEntityMapper().transform(weedClassObject));
  }

  public PutResult putWeedGroup(WeedGroupObject weedGroupObject) {
    return mDbHelper.putWeedGroup(
        new WeedGroupObjectToWeedGroupEntityMapper().transform(weedGroupObject));
  }

  public PutResult putWeed(WeedObject weedObject) {
    return mDbHelper.putWeed(new WeedObjectToWeedEntityMapper().transform(weedObject));
  }

  public List<WeedEntity> getAllWeedEntitiesAsList() {
    return mDbHelper.getAllWeed();
  }

  public PutResult putPhenologicalCharacteristic(
      PhenologicalCharacteristicObject phenologicalCharacteristicObject) {
    return mDbHelper.putPhenologicalCharacteristic(
        new PhenologicalCharacteristicObjectToPhenologicalCharacteristicEntityMapper().transform(
            phenologicalCharacteristicObject));
  }

  public PutResult putDiseasePathogenType(DiseasePathogenTypeObject diseasePathogenTypeObject) {
    return mDbHelper.putDiseasePathogenType(
        new DiseasePathogenTypeObjectToDiseasePathogenTypeEntityMapper().transform(
            diseasePathogenTypeObject));
  }

  public PutResult putDisease(DiseaseObject diseaseObject) {
    return mDbHelper.putDisease(new DiseaseObjectToDiseaseEntityMapper().transform(diseaseObject));
  }

  public PutResult putPhenologicalCharacteristicValue(
      PhenologicalCharacteristicConditionValueObject phenologicalCharacteristicConditionValueObject) {
    return mDbHelper.putPhenologicalCharacteristicValue(
        new PhenologicalCharacteristicConditionValueObjectToPhenologicalCharacteristicConditionValueEntityMapper()
            .transform(phenologicalCharacteristicConditionValueObject));
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

  public PutResult putActiveComponent(ActiveComponentObject activeComponentObject) {
    return mDbHelper.putActiveComponent(
        new ActiveComponentObjectToActiveComponentEntityMapper().transform(activeComponentObject));
  }

  public PutResult putActiveComponentInProduct(
      ActiveComponentInProductObject activeComponentInProductObject) {
    return mDbHelper.putActiveComponentInProduct(
        new ActiveComponentInProductObjectToActiveComponentInProductEntityMapper().transform(
            activeComponentInProductObject));
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
    // TODO get data from DB, not from test util
    /*return mDbHelper.getFieldCropTechnologicalProcesses(mFieldObjectId)
        .concatMap(Observable::from)
        .map(fieldCropTechnologicalProcessEntity -> {new FieldCropTechnologicalProcessEntityToFieldCropTechnologicalProcessObjectMapper(fieldCropTechnologicalProcessEntity)})
        .toList();*/

    return Observable.just(TestUtils.getFieldTechnologicalProcesses());
  }

  public Observable<List<FieldCropTechnologicalProcessObject>> getAllActualTechnologicalProcesses() {
    // TODO get data from DB, not from test util
    /*return mDbHelper.getAllActualTechnologicalProcesses()
        .concatMap(Observable::from)
        .map(fieldCropTechnologicalProcessEntity -> {new FieldCropTechnologicalProcessEntityToFieldCropTechnologicalProcessObjectMapper(fieldCropTechnologicalProcessEntity)})
        .toList();*/

    return Observable.just(TestUtils.getAllActualTechnologicalProcesses());
  }

  public Observable<List<FieldTechnologicalProcessSolutionObject>> getTechnologicalSolutions(
      long mTechnologicalProcessId) {
    // TODO get data from DB, not from test util
    return Observable.just(TestUtils.getTechnologicalProcessSolutions());
  }

  public PutResult putTechnologicalSolution(
      TechnologicalSolutionObject technologicalSolutionObject) {
    return mDbHelper.putTechnologicalSolution(
        new TechnologicalSolutionObjectToTechnologicalSolutionEntityMapper().transform(
            technologicalSolutionObject));
  }

  public Observable<List<TechnologicalSolutionTypeObject>> getAllTechnologicalSolutionTypes() {
    // TODO get data from DB, not from test util
    return Observable.just(TestUtils.getAllTechnologicalSolutionTypes());
  }

  public Observable<List<TechnologicalProcessStateObject>> getAllTechnologicalProcessStates() {
    // TODO get data from DB, not from test util
    return Observable.just(TestUtils.getAllTechnologicalProcessStates());
  }

  public Observable<List<FieldCropTechnologicalProcessConditionObject>> getAllFieldCropTechnologicalProcessesConditions(
      long fieldTechnologicalProcessId) {
    // TODO: get data from DB, not TestUtils
    return Observable.just(TestUtils.getFieldCropTechnologicalProcessConditions());
  }

  public Observable<List<BaseTechnologicalSolutionObject>> getAllTechnologicalSolutionValuesByType(
      TechnologicalSolutionTypeObject solutionType) {

    if (solutionType == null) {
      return Observable.just(new ArrayList<BaseTechnologicalSolutionObject>());
    }

    /*if (solutionType.getId() == 1) {
      return mDbHelper.getAllAggregates()
          .concatMap(Observable::from)
          .map(aggregateEntity -> new AggregateEntityToAggregateObjectMapper().transform(
              aggregateEntity)).toList();
    } else if (solutionType.getId() == 2) {
      //Препараты
      return mDbHelper.getAllProducts()
          .concatMap(Observable::from)
          .map(productEntity -> new ProductEntityToProductObjectMapper().transform(
              productEntity)).toList();
    } else if (solutionType.getId() == 3) {
      //Действующие вещества
      return mDbHelper.getAllActiveComponents()
          .concatMap(Observable::from)
          .map(activeComponentEntity -> new ActiveComponentEntityToActiveComponentObjectMapper().transform(
              activeComponentEntity)).toList();
    } else if (solutionType.getId() == 4) {
      //Насекомые
      return mDbHelper.getAllInsects()
          .concatMap(Observable::from)
          .map(insectEntity -> new InsectEntityToInsectObjectMapper().transform(
              insectEntity)).toList();
    } else if (solutionType.getId() == 5) {
      // TODO: Other solutions
      return Observable.just(new ArrayList<BaseTechnologicalSolutionObject>());
    }*/

    // TODO: get data from DB, not TestUtils
    if (solutionType.getId() == 1) {
      return Observable.just(TestUtils.getAggregates());
    } else if (solutionType.getId() == 2) {
      return Observable.just(TestUtils.getProducts());
    } else if (solutionType.getId() == 3) {
      return Observable.just(TestUtils.getActiveComponents());
    } else if (solutionType.getId() == 4) {
      return Observable.just(TestUtils.getInsects());
    }

    return Observable.just(new ArrayList<BaseTechnologicalSolutionObject>());
  }

  public PutResult putCondition(ConditionObject conditionObject) {
    return mDbHelper.putConditionEntity(
        new ConditionObjectToConditionEntityMapper().transform(conditionObject));
  }

  public PutResult putTechnologicalProcessCondition(
      TechnologicalProcessConditionObject technologicalProcessCondition) {
    return mDbHelper.putTechnologicalProcessesCondition(
        new TechnologicalProcessConditionObjectToTechnologicalProcessConditionEntityMapper().transform(
            technologicalProcessCondition));
  }

  public PutResult putCropTechnologicalProcessesSequence(
      CropTechnologicalProcessesSequenceObject cropTechnologicalProcessesSequence) {
    return mDbHelper.putCropTechnologicalProcessesSequence(
        new CropTechnologicalProcessesSequenceObjectToCropTechnologicalProcessesSequenceEntityMapper()
            .transform(cropTechnologicalProcessesSequence));
  }

  public PutResult putSpanValue(SpanConditionValueObject spanConditionValueObject) {
    return mDbHelper.putConditionSpanValue(
        new SpanConditionConditionValueObjectToSpanConditionConditionValueEntityMapper().transform(
            spanConditionValueObject));
  }

  public List<SpanConditionValueEntity> getConditionSpanValueEntitiesAsList() {
    return mDbHelper.getConditionSpanValueEntity();
  }

  public List<ConditionEntity> getAllConditionEntitiesAsList() {
    return mDbHelper.getAllConditionEntityAsList();
  }

  public PutResult putProcessPeriod(ProcessPeriodObject processPeriodObject) {
    return mDbHelper.putProcessPeriod(
        new ProcessPeriodObjectToProcessPeriodEntityMapper().transform(processPeriodObject));
  }

  public List<ProcessPeriodEntity> getAllProcessPeriodEntitiesAsList() {
    return mDbHelper.getAllProcessPeriodEntitiesAsList();
  }

  public PutResult putConditionName(ConditionNameObject conditionNameObject) {
    return mDbHelper.putConditionName(
        new ConditionNameObjectToConditionNameEntityMapper().transform(conditionNameObject));
  }

  public List<ConditionNameEntity> getAllConditionNameEntitiesAsList() {
    return mDbHelper.getAllConditionNameEntitiesAsList();
  }

  public PutResult putFieldCropTechnologicalProcessCondition(
      FieldCropTechnologicalProcessConditionObject fieldCropTechnologicalProcessConditionObject) {
    return mDbHelper.putFieldCropTechnologicalProcessCondition(
        new FieldCropTechnologicalProcessConditionObjectToFieldCropTechnologicalProcessConditionEntityMapper()
            .transform(fieldCropTechnologicalProcessConditionObject));
  }

  public Observable<List<FieldCropTechnologicalProcessConditionEntity>> getAllFieldCropTechnologicalProcessesConditions() {
    return mDbHelper.getAllFieldCropTechnologicalProcessesConditions();
  }
}
