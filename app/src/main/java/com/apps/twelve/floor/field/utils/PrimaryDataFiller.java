package com.apps.twelve.floor.field.utils;

import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SparseArrayCompat;
import com.apps.twelve.floor.field.data.DataManager;
import com.apps.twelve.floor.field.data.local.db_filler.MetaEntity;
import com.apps.twelve.floor.field.data.local.entities.CropEntity;
import com.apps.twelve.floor.field.data.local.entities.IEntity;
import com.apps.twelve.floor.field.data.local.entities.PhenologicalCharacteristicEntity;
import com.apps.twelve.floor.field.data.local.entities.SoilTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.TillageDirectionEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionNameEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionSpanValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.HarmfulObjectPhaseValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.HarmfulObjectValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.PhenologicalCharacteristicValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.PreviousCropValueEntity;
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
import com.apps.twelve.floor.field.data.local.entities.solutions.InsectEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.ProductCategoryEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.ProductEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.TechnologicalSolutionEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.TechnologicalSolutionTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.technological_map.CropTechnologicalProcessEntity;
import com.apps.twelve.floor.field.data.local.entities.technological_map.TechnologicalProcessConditionEntity;
import com.apps.twelve.floor.field.data.local.entities.technological_map.TechnologicalProcessStateEntity;
import com.apps.twelve.floor.field.data.local.mappers.CropObjectToCropEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.mappers.PhenologicalCharacteristicObjectToPhenologicalCharacteristicEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.SoilTypeObjectToSoilTypeEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.TillageDirectionObjectToTillageDirectionEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.conditions.ConditionNameObjectToConditionNameEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.conditions.ConditionObjectToConditionEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.conditions.ConditionSpanValueObjectToConditionSpanValueEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.conditions.ConditionTypeObjectToConditionTypeEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.conditions.HarmfulObjectPhaseValueObjectToHarmfulObjectPhaseValueEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.conditions.HarmfulObjectValueObjectToHarmfulObjectValueEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.conditions.PhenologicalCharacteristicValueObjectToPhenologicalCharacteristicValueEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.conditions.PreviousCropValueObjectToPreviousCropValueEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.conditions.SoilTypeValueObjectToSoilTypeValueEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.conditions.TillageDirectionValueObjectToTillageDirectionValueEntityMapper;
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
import com.apps.twelve.floor.field.data.local.mappers.process_time.ClimateZoneObjectToClimateZoneEntityMapper;
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
import com.apps.twelve.floor.field.data.local.mappers.technological_map.TechnologicalProcessConditionObjectToTechnologicalProcessConditionEntityMapper;
import com.apps.twelve.floor.field.data.local.mappers.technological_map.TechnologicalProcessStateObjectToTechnologicalProcessStateEntityMapper;
import com.apps.twelve.floor.field.data.local.objects.CropObject;
import com.apps.twelve.floor.field.data.local.objects.PhenologicalCharacteristicObject;
import com.apps.twelve.floor.field.data.local.objects.SoilTypeObject;
import com.apps.twelve.floor.field.data.local.objects.TillageDirectionObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionNameObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionSpanValueObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionTypeObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.HarmfulObjectPhaseValueObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.HarmfulObjectValueObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.PhenologicalCharacteristicValueObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.PreviousCropValueObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.SoilTypeValueObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.TillageDirectionValueObject;
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
import com.apps.twelve.floor.field.data.local.objects.solutions.InsectObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.ProductCategoryObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.ProductObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.TechnologicalSolutionObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.TechnologicalSolutionTypeObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.CropTechnologicalProcessObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.TechnologicalProcessConditionObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.TechnologicalProcessStateObject;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import timber.log.Timber;

/**
 * Created by yarrick on 04.07.17.
 * Fills database with primary data
 * TODO: on release version primary data gonna be filled from *.json (in res) file by Retrofit
 * TODO: like it was received from server
 */

public final class PrimaryDataFiller {

  private DataManager mDataManager;
  private Gson mGson;

  private CropFiller mCropFiller;
  private ClimateZoneFiller mClimateZoneFiller;
  private PhaseFiller mPhaseFiller;
  private ConditionTypeFiller mConditionTypeFiller;
  private SpanValueFiller mSpanValueFiller;
  private SoilTypeFiller mSoilTypeFiller;
  private SoilTypeValueFiller mSoilTypeValueFiller;
  private TechnologicalProcessStateFiller mTechnologicalProcessStateFiller;
  private PestClassFiller mPestClassFiller;
  private PestOrderFiller mPestOrderFiller;
  private PestFiller mPestFiller;
  private TillageDirectionFiller mTillageDirectionFiller;
  private TillageDirectionValueFiller mTillageDirectionValueFiller;
  private PhenologicalCharacteristicFiller mPhenologicalCharacteristicFiller;
  private PhenologicalCharacteristicValueFiller mPhenologicalCharacteristicValueFiller;
  private TechnologicalSolutionTypeFiller mTechnologicalSolutionTypeFiller;
  private AggregateFiller mAggregateFiller;
  private InsectFiller mInsectFiller;
  private ProductCategoryFiller mProductCategoryFiller;
  private ProductFiller mProductFiller;
  private WeedNutritionTypeFiller mWeedNutritionTypeFiller;
  private WeedClassFiller mWeedClassFiller;
  private WeedGroupFiller mWeedGroupFiller;
  private ConditionsFiller mConditionsFiller;
  private ProcessPeriodFiller mProcessPeriodFiller;
  private WeedFiller mWeedFiller;
  private ConditionNamesFiller mConditionNamesFiller;
  private HarmfulObjectTypeFiller mHarmfulObjectTypeFiller;
  private HarmfulObjectFiller mHarmfulObjectFiller;
  private HarmfulObjectPhaseFiller mHarmfulObjectPhaseFiller;
  private ActiveComponentFiller mActiveComponentFiller;
  private ActiveComponentInProductFiller mActiveComponentInProductFiller;
  private TechnologicalSolutionFiller mTechnologicalSolutionFiller;
  private CropTechnologicalProcessFiller mCropTechnologicalProcessFiller;
  private HarmfulObjectPhaseValueFiller mHarmfulObjectPhaseValueFiller;
  private HarmfulObjectValueFiller mHarmfulObjectValueFiller;
  private PreviousCropValueFiller mPreviousCropValueFiller;
  private FillerKeeper mFillerKeeper;
  private CropTechnologicalProcessConditionFiller mCropTechnologicalProcessConditionFiller;

  public PrimaryDataFiller(DataManager dataManager, Gson gson) {
    this.mDataManager = dataManager;
    this.mGson = gson;
  }

  /*public void tryToParseData() {
    HarmfulObjectTypeObject[] hos = new HarmfulObjectTypeObject[mHarmfulObjectTypeFiller.objects.size()];
    for (int i = 0; i < mHarmfulObjectTypeFiller.objects.size(); i++) {
      hos[i] = mHarmfulObjectTypeFiller.objects.valueAt(i);
    }

    String hoJson = gson.toJson(hos);
    HarmfulObjectTypeObject[] arrayHos = gson.fromJson(hoJson, hos.getClass());

    Timber.d("DBG: ho -> JSON: " + hoJson);
    for (int i = 0; i < arrayHos.length; i++) {
      Timber.d("DBG: JSON -> ho[" + i + "]: " + arrayHos[i].getId() + "; " + arrayHos[i].getName());
    }
    if (arrayHos.length == 0) {
      Timber.d("DBG: JSON -> ho: NOTHING");
    }


    // PhenologicalCharacteristic
    PhenologicalCharacteristicObject[] phcs = new PhenologicalCharacteristicObject[mPhenologicalCharacteristicFiller.objects.size()];
    for (int i = 0; i < mPhenologicalCharacteristicFiller.objects.size(); i++) {
      phcs[i] = mPhenologicalCharacteristicFiller.objects.valueAt(i);
    }

    String phcJson = gson.toJson(phcs);
    PhenologicalCharacteristicObject[] arrayPhcs = gson.fromJson(phcJson, phcs.getClass());

    Timber.d("DBG: phc -> JSON: " + phcJson);
    for (int i = 0; i < arrayPhcs.length; i++) {
      Timber.d("DBG: JSON -> phc[" + i + "]: " + arrayPhcs[i].getId() + "; " + arrayPhcs[i].getName());
    }
    if (arrayPhcs.length == 0) {
      Timber.d("DBG: JSON -> phc: NOTHING");
    }


    // MEs
    Timber.d("DBG: ----------------------------------------");
    MetaEntity[] mes = new MetaEntity[2];
    mes[0] = new MetaEntity("HarmfulObjectTypeEntity", hoJson);
    mes[1] = new MetaEntity("PhenologicalCharacteristicEntity", phcJson);

    String mesJson = gson.toJson(mes);
    MetaEntity[] arrayMes = gson.fromJson(mesJson, mes.getClass());

    Timber.d("DBG: mes -> JSON: " + mesJson);
    for (int i = 0; i < arrayMes.length; i++) {
      Timber.d("DBG: JSON -> mes[" + i + "]: " + arrayMes[i].entityKey + "; " + arrayMes[i].entityJsonValue);
    }
    if (arrayMes.length == 0) {
      Timber.d("DBG: JSON -> mes: NOTHING");
    }
  }*/

  public void addTestData() {

    initFillers();
    makeObjects();
    saveObjects();
    checkObjects();

    writeObjectsToJson();
  }

  private void writeObjectsToJson() {

    MetaEntity[] mes = new MetaEntity[mFillerKeeper.fillers.size()];
    for (int i = 0; i < mFillerKeeper.fillers.size(); i++) {
      //mes[i] = new MetaEntity(mFillerKeeper.fillers.get(i).getEntityKey(), mFillerKeeper.fillers.get(i).getEntitiesArray());
      mes[i] = new MetaEntity(mFillerKeeper.fillers.get(i).getEntityKey(),
          mFillerKeeper.fillers.get(i).convertObjectsToJson());
    }
    String mesJson = mGson.toJson(mes);

    // Check everything
    Timber.d("DBG: mes -> JSON: " + mesJson);

    /*MetaEntity[] arrayMes = mGson.fromJson(mesJson, mes.getClass());
    Timber.d("DBG: mes -> JSON: " + mesJson);
    if (arrayMes.length == 0) {
      Timber.d("DBG: JSON -> mes: NOTHING");
    }
    for (int i = 0; i < arrayMes.length; i++) {
      Timber.d("DBG: JSON -> mes[" + i + "]: " + arrayMes[i].entityKey + "; " + arrayMes[i].entityJsonValue);

      IEntity[] cropEntities = mCropFiller.convertJsonToEntities(arrayMes[i].entityJsonValue);
      if (cropEntities.length == 0) {
        Timber.d("DBG: JSON -> cropEntities: NOTHING");
      }
      for (int j = 0; j < cropEntities.length; j++) {
        CropEntity cropEntity = (CropEntity) cropEntities[j];
        Timber.d("DBG: JSON -> cropEntity[" + j + "]: " + cropEntity.getId() + "; " + cropEntity.getName());
      }
    }*/
  }

  private void initFillers() {
    mFillerKeeper = new FillerKeeper();

    // solutions
    mTechnologicalSolutionTypeFiller = new TechnologicalSolutionTypeFiller();
    mFillerKeeper.addFiller(mTechnologicalSolutionTypeFiller);
    mProductCategoryFiller = new ProductCategoryFiller();
    mFillerKeeper.addFiller(mProductCategoryFiller);
    mProductFiller = new ProductFiller();
    mFillerKeeper.addFiller(mProductFiller);
    mAggregateFiller = new AggregateFiller();
    mFillerKeeper.addFiller(mAggregateFiller);
    mActiveComponentFiller = new ActiveComponentFiller();
    mFillerKeeper.addFiller(mActiveComponentFiller);
    mInsectFiller = new InsectFiller();
    mFillerKeeper.addFiller(mInsectFiller);
    mActiveComponentInProductFiller = new ActiveComponentInProductFiller();
    mFillerKeeper.addFiller(mActiveComponentInProductFiller);
    mTechnologicalSolutionFiller = new TechnologicalSolutionFiller();
    mFillerKeeper.addFiller(mTechnologicalSolutionFiller);

    // harmful objects
    mHarmfulObjectTypeFiller = new HarmfulObjectTypeFiller();
    mFillerKeeper.addFiller(mHarmfulObjectTypeFiller);
    mWeedNutritionTypeFiller = new WeedNutritionTypeFiller();
    mFillerKeeper.addFiller(mWeedNutritionTypeFiller);
    mWeedClassFiller = new WeedClassFiller();
    mFillerKeeper.addFiller(mWeedClassFiller);
    mWeedGroupFiller = new WeedGroupFiller();
    mFillerKeeper.addFiller(mWeedGroupFiller);
    mWeedFiller = new WeedFiller();
    mFillerKeeper.addFiller(mWeedFiller);
    mPestClassFiller = new PestClassFiller();
    mFillerKeeper.addFiller(mPestClassFiller);
    mPestOrderFiller = new PestOrderFiller();
    mFillerKeeper.addFiller(mPestOrderFiller);
    mPestFiller = new PestFiller();
    mFillerKeeper.addFiller(mPestFiller);
    // TODO: diseases
    mHarmfulObjectFiller = new HarmfulObjectFiller();
    mFillerKeeper.addFiller(mHarmfulObjectFiller);
    mHarmfulObjectPhaseFiller = new HarmfulObjectPhaseFiller();
    mFillerKeeper.addFiller(mHarmfulObjectPhaseFiller);

    // other
    mCropFiller = new CropFiller();
    mFillerKeeper.addFiller(mCropFiller);
    mSoilTypeFiller = new SoilTypeFiller();
    mFillerKeeper.addFiller(mSoilTypeFiller);
    mTillageDirectionFiller = new TillageDirectionFiller();
    mFillerKeeper.addFiller(mTillageDirectionFiller);
    mPhenologicalCharacteristicFiller = new PhenologicalCharacteristicFiller();
    mFillerKeeper.addFiller(mPhenologicalCharacteristicFiller);

    // process time
    mClimateZoneFiller = new ClimateZoneFiller();
    mFillerKeeper.addFiller(mClimateZoneFiller);
    mPhaseFiller = new PhaseFiller();
    mFillerKeeper.addFiller(mPhaseFiller);
    mProcessPeriodFiller = new ProcessPeriodFiller();
    mFillerKeeper.addFiller(mProcessPeriodFiller);

    // conditions
    mConditionNamesFiller = new ConditionNamesFiller();
    mFillerKeeper.addFiller(mConditionNamesFiller);
    mConditionTypeFiller = new ConditionTypeFiller();
    mFillerKeeper.addFiller(mConditionTypeFiller);
    mPreviousCropValueFiller = new PreviousCropValueFiller();
    mFillerKeeper.addFiller(mPreviousCropValueFiller);
    mSpanValueFiller = new SpanValueFiller();
    mFillerKeeper.addFiller(mSpanValueFiller);
    mSoilTypeValueFiller = new SoilTypeValueFiller();
    mFillerKeeper.addFiller(mSoilTypeValueFiller);
    mHarmfulObjectValueFiller = new HarmfulObjectValueFiller();
    mFillerKeeper.addFiller(mHarmfulObjectValueFiller);
    mHarmfulObjectPhaseValueFiller = new HarmfulObjectPhaseValueFiller();
    mFillerKeeper.addFiller(mHarmfulObjectPhaseValueFiller);
    mTillageDirectionValueFiller = new TillageDirectionValueFiller();
    mFillerKeeper.addFiller(mTillageDirectionValueFiller);
    mPhenologicalCharacteristicValueFiller = new PhenologicalCharacteristicValueFiller();
    mFillerKeeper.addFiller(mPhenologicalCharacteristicValueFiller);
    mConditionsFiller = new ConditionsFiller();
    mFillerKeeper.addFiller(mConditionsFiller);

    // technological map
    mTechnologicalProcessStateFiller = new TechnologicalProcessStateFiller();
    mFillerKeeper.addFiller(mTechnologicalProcessStateFiller);
    mCropTechnologicalProcessFiller = new CropTechnologicalProcessFiller();
    mFillerKeeper.addFiller(mCropTechnologicalProcessFiller); // TODO: finish
    mCropTechnologicalProcessConditionFiller = new CropTechnologicalProcessConditionFiller();
    mFillerKeeper.addFiller(mCropTechnologicalProcessConditionFiller);
    // TODO: Tech processes Conditions

    // TODO
  }

  private void makeObjects() {
    for (BaseFiller filler : mFillerKeeper.fillers) {
      filler.makeObjects();
    }
  }

  private void saveObjects() {
    for (BaseFiller filler : mFillerKeeper.fillers) {
      filler.saveObjects();
    }
  }

  private void checkObjects() {
    //Timber.e(String.valueOf(mDataManager.getAllProcessPeriodEntitiesAsList().size()));
    //Timber.e(String.valueOf(mDataManager.getAllWeedEntitiesAsList().size()));
    //Timber.e(String.valueOf(mDataManager.getAllConditionNameEntitiesAsList().size()));
    Timber.e(String.valueOf(mDataManager.getConditionSpanValueEntitiesAsList().size()));
    // TODO
  }

  ///////////////////////////////////////////////////////////////////////////
  // Fillers
  ///////////////////////////////////////////////////////////////////////////

  private final class FillerKeeper {
    ArrayList<BaseFiller> fillers = new ArrayList<>();

    void addFiller(BaseFiller filler) {
      fillers.add(filler);
    }
  }

  private abstract class BaseFiller {
    abstract String getEntityKey();

    abstract void makeObjects();

    abstract void saveObjects();

    abstract IEntity[] getEntitiesArray();

    abstract String convertObjectsToJson();

    abstract IEntity[] convertJsonToEntities(String json);

    String toJsonConversion(SparseArrayCompat objects, IEntity[] arr, Mapper mapper) {
      fillEntitiesArray(objects, arr, mapper);
      return mGson.toJson(arr);
    }

    void fillEntitiesArray(SparseArrayCompat objects, IEntity[] arr, Mapper mapper) {
      for (int i = 0; i < objects.size(); i++) {
        arr[i] = (IEntity) mapper.transform(objects.valueAt(i));
      }
    }
  }

  private class CropFiller extends BaseFiller {

    static final int CORN_KEY = 1;

    private static final int CAPACITY = 15;

    private SparseArrayCompat<CropObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return CropEntity[].class.getName();
    }

    @Override void makeObjects() {
      objects.put(CORN_KEY, new CropObject(1, "Кукурудза", 0, false, true));
      objects.put(2, new CropObject(2, "Озима пшениця", 0, false, false));
      objects.put(3, new CropObject(3, "Озимий ячмінь", 0, false, false));
      objects.put(4, new CropObject(4, "Озиме жито", 0, false, false));
      objects.put(5, new CropObject(5, "Озиме тритікале", 0, false, false));
      objects.put(6, new CropObject(6, "Соя", 0, false, false));
      objects.put(7, new CropObject(7, "Горох", 0, false, false));
      objects.put(8, new CropObject(8, "Кормові боби", 0, false, false));
      objects.put(9, new CropObject(9, "Люпин", 0, false, false));
      objects.put(10, new CropObject(10, "Квасоля", 0, false, false));
      objects.put(11, new CropObject(11, "Чина", 0, false, false));
      objects.put(12, new CropObject(12, "Сочевиця", 0, false, false));
      objects.put(13, new CropObject(13, "Нут", 0, false, false));
      objects.put(14, new CropObject(14, "Цукровий буряк", 0, false, false));
      objects.put(15, new CropObject(15, "Ярий ячмінь", 0, false, false));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putCrop(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      CropEntity[] res = new CropEntity[objects.size()];
      fillEntitiesArray(objects, res, new CropObjectToCropEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new CropEntity[objects.size()],
          new CropObjectToCropEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, CropEntity[].class);
    }
  }

  private class SoilTypeFiller extends BaseFiller {

    private static final int CAPACITY = 6;

    private SparseArrayCompat<SoilTypeObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return SoilTypeEntity[].class.getName();
    }

    @Override void makeObjects() {
      // TODO: add coordinates
      objects.put(1, new SoilTypeObject(1, "Піщані, або легкі грунти", ""));
      objects.put(2, new SoilTypeObject(2, "Глинисті, або важкі грунти ", ""));
      objects.put(3, new SoilTypeObject(3, "Кам'янисті грунти", ""));
      objects.put(4, new SoilTypeObject(4, "Торф'яно-болотні грунти", ""));
      objects.put(5, new SoilTypeObject(5, "Супіщані грунти", ""));
      objects.put(6, new SoilTypeObject(6, "Суглинні, або середні грунти", ""));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putSoilType(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      SoilTypeEntity[] res = new SoilTypeEntity[objects.size()];
      fillEntitiesArray(objects, res, new SoilTypeObjectToSoilTypeEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new SoilTypeEntity[objects.size()],
          new SoilTypeObjectToSoilTypeEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, SoilTypeEntity[].class);
    }
  }

  private class TillageDirectionFiller extends BaseFiller {

    private static final int CAPACITY = 4;

    private SparseArrayCompat<TillageDirectionObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return TillageDirectionEntity[].class.getName();
    }

    @Override void makeObjects() {
      objects.put(1, new TillageDirectionObject(1, "під кутом 45⁰ до напряму оранки"));
      objects.put(2, new TillageDirectionObject(2, "Човнико-вий або діагональ-ний"));
      objects.put(3, new TillageDirectionObject(3, "міжряддя вздовж рядків"));
      objects.put(4, new TillageDirectionObject(4, "суцільний обробіток"));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putTillageDirection(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      TillageDirectionEntity[] res = new TillageDirectionEntity[objects.size()];
      fillEntitiesArray(objects, res, new TillageDirectionObjectToTillageDirectionEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new TillageDirectionEntity[objects.size()],
          new TillageDirectionObjectToTillageDirectionEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, TillageDirectionEntity[].class);
    }
  }

  private class PhenologicalCharacteristicFiller extends BaseFiller {

    private static final int CAPACITY = 7;

    private SparseArrayCompat<PhenologicalCharacteristicObject> objects =
        new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return PhenologicalCharacteristicEntity[].class.getName();
    }

    @Override void makeObjects() {
      objects.put(1, new PhenologicalCharacteristicObject(1, "Цвітіння черемухи, черешні"));
      objects.put(2, new PhenologicalCharacteristicObject(3,
          "Активна вегетація. Рослини не повинні перебувати в стресовому стані"));
      objects.put(3, new PhenologicalCharacteristicObject(4,
          "Початок масового льоту кукурудзяного метелика -визначається за допомогою феромонних пасток. "));
      objects.put(4, new PhenologicalCharacteristicObject(5,
          "масове відкладання яєць кукурудзяним метеликом"));
      objects.put(5,
          new PhenologicalCharacteristicObject(6, "проникнення перших гусениць у стебла"));
      objects.put(6, new PhenologicalCharacteristicObject(7, "Активна вегетація бур’янів"));
      objects.put(7, new PhenologicalCharacteristicObject(8,
          "Візуально визначається по наявності чор-ного прошарку (чорної точки) між зерном і місцем прикріплення його до качана"));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putPhenologicalCharacteristic(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      PhenologicalCharacteristicEntity[] res = new PhenologicalCharacteristicEntity[objects.size()];
      fillEntitiesArray(objects, res,
          new PhenologicalCharacteristicObjectToPhenologicalCharacteristicEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new PhenologicalCharacteristicEntity[objects.size()],
          new PhenologicalCharacteristicObjectToPhenologicalCharacteristicEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, PhenologicalCharacteristicEntity[].class);
    }
  }

  private class ConditionNamesFiller extends BaseFiller {
    private static final int PREVIOUS_CROP_KEY = 1;
    private static final int SOIL_TYPE_KEY = 2;
    private static final int SOIL_MOISTURE_KEY = 3;
    private static final int SOIL_TEMPERATURE_KEY = 4;
    private static final int PLANNED_YIELD_KEY = 5;
    private static final int HARMFUL_OBJECT_KEY = 6;
    private static final int HARMFUL_OBJECT_PHASE_KEY = 7;
    private static final int AIR_TEMPERATURE_KEY = 8;
    private static final int AIR_MOISTURE_KEY = 9;
    private static final int WEED_AMOUNT_KEY = 10;
    private static final int GRAIN_MOISTURE_KEY = 11;
    private static final int TILLAGE_DIRECTION_KEY = 12;
    private static final int TILLAGE_DEPTH_KEY = 13;
    private static final int PHENOLOGICAL_CHARACTERISTIC_KEY = 14;

    private static final int CAPACITY = 14;

    private SparseArrayCompat<ConditionNameObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return ConditionNameEntity[].class.getName();
    }

    @Override void makeObjects() {
      objects.put(PREVIOUS_CROP_KEY, new ConditionNameObject(1, "Предшественник"));
      objects.put(SOIL_TYPE_KEY, new ConditionNameObject(2, "Тип почвы"));
      objects.put(SOIL_MOISTURE_KEY, new ConditionNameObject(3, "Влажность почвы"));
      objects.put(SOIL_TEMPERATURE_KEY, new ConditionNameObject(4, "Температура почвы"));
      objects.put(PLANNED_YIELD_KEY, new ConditionNameObject(5, "Планируемая урожайность"));
      objects.put(HARMFUL_OBJECT_KEY, new ConditionNameObject(6, "Вредный объект"));
      objects.put(HARMFUL_OBJECT_PHASE_KEY, new ConditionNameObject(7, "Фаза вредного объекта"));
      objects.put(AIR_TEMPERATURE_KEY, new ConditionNameObject(8, "Температура воздуха"));
      objects.put(AIR_MOISTURE_KEY, new ConditionNameObject(9, "Влажность воздуха"));
      objects.put(WEED_AMOUNT_KEY, new ConditionNameObject(10, "Количество сорняков"));
      objects.put(GRAIN_MOISTURE_KEY, new ConditionNameObject(11, "Влажность зерна"));
      objects.put(TILLAGE_DIRECTION_KEY, new ConditionNameObject(12, "Напраление обработки"));
      objects.put(TILLAGE_DEPTH_KEY, new ConditionNameObject(13, "Глубина обработки"));
      objects.put(PHENOLOGICAL_CHARACTERISTIC_KEY,
          new ConditionNameObject(14, "Фенологческая характеристика"));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putConditionName(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      ConditionNameEntity[] res = new ConditionNameEntity[objects.size()];
      fillEntitiesArray(objects, res, new ConditionNameObjectToConditionNameEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new ConditionNameEntity[objects.size()],
          new ConditionNameObjectToConditionNameEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, ConditionNameEntity[].class);
    }
  }

  private class ConditionTypeFiller extends BaseFiller {

    static final int SOIL_TYPE_KEY = 1;
    static final int HARMFUL_OBJECT_KEY = 2;
    static final int HARMFUL_OBJECT_PHASE_KEY = 3;
    static final int TILLAGE_DIRECTION_KEY = 4;
    static final int PHENOLOGICAL_CHARACTERISTIC_KEY = 5;
    static final int SPAN_VALUE_KEY = 6;
    static final int NUMBER_VALUE_KEY = 7;
    static final int PREVIOUS_CROP_KEY = 8;

    private static final int CAPACITY = 8;

    private SparseArrayCompat<ConditionTypeObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return ConditionTypeEntity[].class.getName();
    }

    @Override void makeObjects() {
      objects.put(SOIL_TYPE_KEY, new ConditionTypeObject(1, "Тип почвы"));
      objects.put(HARMFUL_OBJECT_KEY, new ConditionTypeObject(2, "Вредный объект"));
      objects.put(HARMFUL_OBJECT_PHASE_KEY,
          new ConditionTypeObject(3, "Фаза развития вредного объекта"));
      objects.put(TILLAGE_DIRECTION_KEY,
          new ConditionTypeObject(4, "Направление обработки почвы, посева, опрыскивания"));
      objects.put(PHENOLOGICAL_CHARACTERISTIC_KEY,
          new ConditionTypeObject(5, "Фенологическая характеристика"));
      objects.put(SPAN_VALUE_KEY, new ConditionTypeObject(6, "Числовой диапазон"));
      objects.put(NUMBER_VALUE_KEY, new ConditionTypeObject(7, "Число"));
      objects.put(PREVIOUS_CROP_KEY, new ConditionTypeObject(8, "Предшественник"));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putConditionType(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      ConditionTypeEntity[] res = new ConditionTypeEntity[objects.size()];
      fillEntitiesArray(objects, res, new ConditionTypeObjectToConditionTypeEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new ConditionTypeEntity[objects.size()],
          new ConditionTypeObjectToConditionTypeEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, ConditionTypeEntity[].class);
    }
  }

  private class SoilTypeValueFiller extends BaseFiller {

    private static final int CAPACITY = 6;

    private SparseArrayCompat<SoilTypeValueObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return SoilTypeValueEntity[].class.getName();
    }

    @Override void makeObjects() {
      ConditionTypeObject soilTypeConditionType =
          mConditionTypeFiller.objects.get(ConditionTypeFiller.SOIL_TYPE_KEY);

      int currentId = 1;
      for (int i = 0; i < mSoilTypeFiller.objects.size(); i++) {
        objects.put(currentId, new SoilTypeValueObject(currentId, soilTypeConditionType,
            mSoilTypeFiller.objects.valueAt(i)));
        currentId++;
      }
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putSoilTypeValue(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      SoilTypeValueEntity[] res = new SoilTypeValueEntity[objects.size()];
      fillEntitiesArray(objects, res, new SoilTypeValueObjectToSoilTypeValueEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new SoilTypeValueEntity[objects.size()],
          new SoilTypeValueObjectToSoilTypeValueEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, SoilTypeValueEntity[].class);
    }
  }

  private class TillageDirectionValueFiller extends BaseFiller {

    private static final int CAPACITY = 4;

    private SparseArrayCompat<TillageDirectionValueObject> objects =
        new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return TillageDirectionValueEntity[].class.getName();
    }

    @Override void makeObjects() {
      ConditionTypeObject tillageDirectionConditionTypeObject =
          mConditionTypeFiller.objects.get(ConditionTypeFiller.TILLAGE_DIRECTION_KEY);

      int currentId = 1;
      for (int i = 0; i < mTillageDirectionFiller.objects.size(); i++) {
        objects.put(currentId,
            new TillageDirectionValueObject(currentId, tillageDirectionConditionTypeObject,
                mTillageDirectionFiller.objects.valueAt(i)));
        currentId++;
      }
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putTillageDirectionValue(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      TillageDirectionValueEntity[] res = new TillageDirectionValueEntity[objects.size()];
      fillEntitiesArray(objects, res,
          new TillageDirectionValueObjectToTillageDirectionValueEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new TillageDirectionValueEntity[objects.size()],
          new TillageDirectionValueObjectToTillageDirectionValueEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, TillageDirectionValueEntity[].class);
    }
  }

  private class PhenologicalCharacteristicValueFiller extends BaseFiller {

    private static final int CAPACITY = 8;

    private SparseArrayCompat<PhenologicalCharacteristicValueObject> objects =
        new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return PhenologicalCharacteristicValueEntity[].class.getName();
    }

    @Override void makeObjects() {
      ConditionTypeObject phenologicalCharacteristicConditionType =
          mConditionTypeFiller.objects.get(ConditionTypeFiller.PHENOLOGICAL_CHARACTERISTIC_KEY);

      int currentId = 1;
      for (int i = 0; i < mPhenologicalCharacteristicFiller.objects.size(); i++) {
        objects.put(currentId, new PhenologicalCharacteristicValueObject(currentId,
            phenologicalCharacteristicConditionType,
            mPhenologicalCharacteristicFiller.objects.valueAt(i)));
        currentId++;
      }
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putPhenologicalCharacteristicValue(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      PhenologicalCharacteristicValueEntity[] res =
          new PhenologicalCharacteristicValueEntity[objects.size()];
      fillEntitiesArray(objects, res,
          new PhenologicalCharacteristicValueObjectToPhenologicalCharacteristicValueEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new PhenologicalCharacteristicValueEntity[objects.size()],
          new PhenologicalCharacteristicValueObjectToPhenologicalCharacteristicValueEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, PhenologicalCharacteristicValueEntity[].class);
    }
  }

  private class PreviousCropValueFiller extends BaseFiller {

    private static final int CAPACITY = CropFiller.CAPACITY;

    private SparseArrayCompat<PreviousCropValueObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return PreviousCropValueEntity[].class.getName();
    }

    @Override void makeObjects() {
      ConditionTypeObject previousCropConditionType =
          mConditionTypeFiller.objects.get(ConditionTypeFiller.PREVIOUS_CROP_KEY);

      int currentId = 1;
      for (int i = 0; i < mCropFiller.objects.size(); i++) {
        objects.put(currentId, new PreviousCropValueObject(currentId, previousCropConditionType,
            mCropFiller.objects.valueAt(i)));
        currentId++;
      }
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putPreviousCropValue(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      PreviousCropValueEntity[] res = new PreviousCropValueEntity[objects.size()];
      fillEntitiesArray(objects, res, new PreviousCropValueObjectToPreviousCropValueEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new PreviousCropValueEntity[objects.size()],
          new PreviousCropValueObjectToPreviousCropValueEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, PreviousCropValueEntity[].class);
    }
  }

  private class SpanValueFiller extends BaseFiller {
    //Soil Moisture
    static final int SPAN_40_70_KEY = 1;
    static final int SPAN_50_65_KEY = 2;
    static final int SPAN_40_60_KEY = 3;
    static final int SPAN_40_50_KEY = 4;
    static final int SPAN_30_40_KEY = 5;
    static final int SPAN_20_50_KEY = 6;

    //Soil Temperature
    static final int SPAN_0_5_KEY = 7;
    static final int SPAN_8_12_KEY = 8;

    //Planned yield
    //All values from 8 to 10 - this is already exists

    //Air Temperature
    static final int SPAN_0_10_KEY = 9;
    static final int SPAN_10_300_KEY = 10;
    static final int SPAN_12_20_KEY = 11;
    static final int SPAN_8_10_KEY = 12;
    static final int SPAN_0_25_KEY = 13;

    //Air Moisture
    static final int SPAN_60_99_KEY = 14;
    static final int SPAN_30_50_KEY = 15;
    static final int SPAN_50_99_KEY = 16;
    static final int SPAN_0_80_KEY = 17;

    //Grain moisture
    static final int SPAN_14_99_KEY = 18;
    static final int SPAN_0_30_KEY = 19;

    //Tillage Depth
    static final int SPAN_10_12_KEY = 20;
    static final int SPAN_6_10_KEY = 21;
    static final int SPAN_5_8_KEY = 22;
    static final int SPAN_4_8_KEY = 23;
    static final int SPAN_2_4_KEY = 24;
    static final int SPAN_4_5_KEY = 25;
    static final int SPAN_6_8_KEY = 26;

    // Weed amount
    static final int SPAN_10_50_KEY = 27;
    static final int SPAN_1_5_KEY = 28;

    // Grain moisture
    static final int SPAN_0_14_KEY = 29;

    private static final int CAPACITY = 29;

    private SparseArrayCompat<ConditionSpanValueObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return ConditionSpanValueEntity[].class.getName();
    }

    @Override void makeObjects() {
      ConditionTypeObject spanValueConditionTypeObject =
          mConditionTypeFiller.objects.get(ConditionTypeFiller.SPAN_VALUE_KEY);

      //Soil Moisture
      objects.put(SPAN_40_70_KEY,
          new ConditionSpanValueObject(SPAN_40_70_KEY, spanValueConditionTypeObject, 40, 70));
      objects.put(SPAN_50_65_KEY,
          new ConditionSpanValueObject(SPAN_50_65_KEY, spanValueConditionTypeObject, 50, 65));
      objects.put(SPAN_40_60_KEY,
          new ConditionSpanValueObject(SPAN_40_60_KEY, spanValueConditionTypeObject, 40, 60));
      objects.put(SPAN_40_50_KEY,
          new ConditionSpanValueObject(SPAN_40_50_KEY, spanValueConditionTypeObject, 40, 50));
      objects.put(SPAN_30_40_KEY,
          new ConditionSpanValueObject(SPAN_30_40_KEY, spanValueConditionTypeObject, 30, 40));
      objects.put(SPAN_20_50_KEY,
          new ConditionSpanValueObject(SPAN_20_50_KEY, spanValueConditionTypeObject, 20, 50));

      //Soil Temperature
      objects.put(SPAN_0_5_KEY,
          new ConditionSpanValueObject(SPAN_0_5_KEY, spanValueConditionTypeObject, 0, 5));
      objects.put(SPAN_8_10_KEY,
          new ConditionSpanValueObject(SPAN_8_10_KEY, spanValueConditionTypeObject, 8, 10));
      objects.put(SPAN_8_12_KEY,
          new ConditionSpanValueObject(SPAN_8_12_KEY, spanValueConditionTypeObject, 8, 12));

      //Air Temperature
      objects.put(SPAN_0_10_KEY,
          new ConditionSpanValueObject(SPAN_0_10_KEY, spanValueConditionTypeObject, 0, 10));
      objects.put(SPAN_10_300_KEY,
          new ConditionSpanValueObject(SPAN_10_300_KEY, spanValueConditionTypeObject, 10, 300));
      objects.put(SPAN_12_20_KEY,
          new ConditionSpanValueObject(SPAN_12_20_KEY, spanValueConditionTypeObject, 12, 20));
      objects.put(SPAN_0_25_KEY,
          new ConditionSpanValueObject(SPAN_0_25_KEY, spanValueConditionTypeObject, 0, 25));

      //Air Moisture
      objects.put(SPAN_60_99_KEY,
          new ConditionSpanValueObject(SPAN_60_99_KEY, spanValueConditionTypeObject, 60, 99));
      objects.put(SPAN_30_50_KEY,
          new ConditionSpanValueObject(SPAN_30_50_KEY, spanValueConditionTypeObject, 30, 50));
      objects.put(SPAN_50_99_KEY,
          new ConditionSpanValueObject(SPAN_50_99_KEY, spanValueConditionTypeObject, 50, 99));
      objects.put(SPAN_0_80_KEY,
          new ConditionSpanValueObject(SPAN_0_80_KEY, spanValueConditionTypeObject, 0, 80));

      //Grain moisture
      objects.put(SPAN_14_99_KEY,
          new ConditionSpanValueObject(SPAN_14_99_KEY, spanValueConditionTypeObject, 14, 99));
      objects.put(SPAN_0_30_KEY,
          new ConditionSpanValueObject(SPAN_0_30_KEY, spanValueConditionTypeObject, 0, 30));

      //Tillage Depth
      objects.put(SPAN_10_12_KEY,
          new ConditionSpanValueObject(SPAN_10_12_KEY, spanValueConditionTypeObject, 10, 12));
      objects.put(SPAN_6_10_KEY,
          new ConditionSpanValueObject(SPAN_6_10_KEY, spanValueConditionTypeObject, 6, 10));
      objects.put(SPAN_5_8_KEY,
          new ConditionSpanValueObject(SPAN_5_8_KEY, spanValueConditionTypeObject, 5, 8));
      objects.put(SPAN_4_8_KEY,
          new ConditionSpanValueObject(SPAN_4_8_KEY, spanValueConditionTypeObject, 4, 8));
      objects.put(SPAN_2_4_KEY,
          new ConditionSpanValueObject(SPAN_2_4_KEY, spanValueConditionTypeObject, 2, 4));
      objects.put(SPAN_4_5_KEY,
          new ConditionSpanValueObject(SPAN_4_5_KEY, spanValueConditionTypeObject, 4, 5));
      objects.put(SPAN_6_8_KEY,
          new ConditionSpanValueObject(SPAN_6_8_KEY, spanValueConditionTypeObject, 6, 8));

      // Weed amount
      objects.put(SPAN_10_50_KEY,
          new ConditionSpanValueObject(SPAN_10_50_KEY, spanValueConditionTypeObject, 10, 50));
      objects.put(SPAN_1_5_KEY,
          new ConditionSpanValueObject(SPAN_1_5_KEY, spanValueConditionTypeObject, 1, 5));

      // Grain moisture
      objects.put(SPAN_0_14_KEY,
          new ConditionSpanValueObject(SPAN_0_14_KEY, spanValueConditionTypeObject, 0, 14));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putSpanValue(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      ConditionSpanValueEntity[] res = new ConditionSpanValueEntity[objects.size()];
      fillEntitiesArray(objects, res,
          new ConditionSpanValueObjectToConditionSpanValueEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new ConditionSpanValueEntity[objects.size()],
          new ConditionSpanValueObjectToConditionSpanValueEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, ConditionSpanValueEntity[].class);
    }
  }

  private class HarmfulObjectPhaseValueFiller extends BaseFiller {

    private static final int CAPACITY = HarmfulObjectPhaseFiller.CAPACITY;

    private SparseArrayCompat<HarmfulObjectPhaseValueObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return HarmfulObjectPhaseValueEntity[].class.getName();
    }

    @Override void makeObjects() {
      ConditionTypeObject harmfulObjectPhaseConditionType =
          mConditionTypeFiller.objects.get(ConditionTypeFiller.HARMFUL_OBJECT_PHASE_KEY);

      int currentId = 1;
      for (int i = 0; i < mHarmfulObjectPhaseFiller.objects.size(); i++) {
        objects.put(currentId, new HarmfulObjectPhaseValueObject(currentId, harmfulObjectPhaseConditionType,
            mHarmfulObjectPhaseFiller.objects.valueAt(i)));
        currentId++;
      }
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putHarmfulObjectPhaseValue(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      HarmfulObjectPhaseValueEntity[] res = new HarmfulObjectPhaseValueEntity[objects.size()];
      fillEntitiesArray(objects, res,
          new HarmfulObjectPhaseValueObjectToHarmfulObjectPhaseValueEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new HarmfulObjectPhaseValueEntity[objects.size()],
          new HarmfulObjectPhaseValueObjectToHarmfulObjectPhaseValueEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, HarmfulObjectPhaseValueEntity[].class);
    }
  }

  private class HarmfulObjectValueFiller extends BaseFiller {

    private static final int CAPACITY = HarmfulObjectFiller.CAPACITY;

    private SparseArrayCompat<HarmfulObjectValueObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return HarmfulObjectValueEntity[].class.getName();
    }

    @Override void makeObjects() {
      ConditionTypeObject harmfulObjectConditionType =
          mConditionTypeFiller.objects.get(ConditionTypeFiller.HARMFUL_OBJECT_KEY);

      int currentId = 1;
      for (int i = 0; i < mHarmfulObjectFiller.objects.size(); i++) {
        objects.put(currentId, new HarmfulObjectValueObject(currentId, harmfulObjectConditionType,
            mHarmfulObjectFiller.objects.valueAt(i)));
        currentId++;
      }
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putHarmfulObjectValue(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      HarmfulObjectValueEntity[] res = new HarmfulObjectValueEntity[objects.size()];
      fillEntitiesArray(objects, res,
          new HarmfulObjectValueObjectToHarmfulObjectValueEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new HarmfulObjectValueEntity[objects.size()],
          new HarmfulObjectValueObjectToHarmfulObjectValueEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, HarmfulObjectValueEntity[].class);
    }
  }

  private class ConditionsFiller extends BaseFiller {

    private static final int CAPACITY = 36
        + HarmfulObjectValueFiller.CAPACITY
        + HarmfulObjectPhaseValueFiller.CAPACITY
        + PreviousCropValueFiller.CAPACITY
        + TillageDirectionValueFiller.CAPACITY
        + PhenologicalCharacteristicValueFiller.CAPACITY;

    private SparseArrayCompat<ConditionObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return ConditionEntity[].class.getName();
    }

    @Override void makeObjects() {
      ConditionTypeObject spanValueConditionType =
          mConditionTypeFiller.objects.get(ConditionTypeFiller.SPAN_VALUE_KEY);
      ConditionTypeObject soilTypeConditionType = mConditionTypeFiller.objects.get(ConditionTypeFiller.SOIL_TYPE_KEY);
      ConditionTypeObject harmfulObjectConditionType = mConditionTypeFiller.objects.get(ConditionTypeFiller.HARMFUL_OBJECT_KEY);
      ConditionTypeObject harmfulObjectPhaseConditionType = mConditionTypeFiller.objects.get(ConditionTypeFiller.HARMFUL_OBJECT_PHASE_KEY);
      ConditionTypeObject previousCropConditionType =
          mConditionTypeFiller.objects.get(ConditionTypeFiller.PREVIOUS_CROP_KEY);
      ConditionTypeObject tillageDirectionConditionType =
          mConditionTypeFiller.objects.get(ConditionTypeFiller.TILLAGE_DIRECTION_KEY);
      ConditionTypeObject phenologicalCharacteristicConditionType =
          mConditionTypeFiller.objects.get(ConditionTypeFiller.PHENOLOGICAL_CHARACTERISTIC_KEY);

      ConditionNameObject airTemperatureConditionName =
          mConditionNamesFiller.objects.get(ConditionNamesFiller.AIR_TEMPERATURE_KEY);
      ConditionNameObject airMoistureConditionName =
          mConditionNamesFiller.objects.get(ConditionNamesFiller.AIR_MOISTURE_KEY);
      ConditionNameObject soilTypeConditionName = mConditionNamesFiller.objects.get(ConditionNamesFiller.SOIL_TYPE_KEY);
      ConditionNameObject soilMoistureConditionName =
          mConditionNamesFiller.objects.get(ConditionNamesFiller.SOIL_MOISTURE_KEY);
      ConditionNameObject soilTemperatureConditionName =
          mConditionNamesFiller.objects.get(ConditionNamesFiller.SOIL_TEMPERATURE_KEY);
      ConditionNameObject harmfulObjectConditionName = mConditionNamesFiller.objects.get(ConditionNamesFiller.HARMFUL_OBJECT_KEY);
      ConditionNameObject harmfulObjectPhaseConditionName = mConditionNamesFiller.objects.get(ConditionNamesFiller.HARMFUL_OBJECT_PHASE_KEY);
      ConditionNameObject previousCropConditionName =
          mConditionNamesFiller.objects.get(ConditionNamesFiller.PREVIOUS_CROP_KEY);
      ConditionNameObject plannedYieldConditionName =
          mConditionNamesFiller.objects.get(ConditionNamesFiller.PLANNED_YIELD_KEY);
      ConditionNameObject weedAmountConditionName =
          mConditionNamesFiller.objects.get(ConditionNamesFiller.WEED_AMOUNT_KEY);
      ConditionNameObject grainMoistureConditionName =
          mConditionNamesFiller.objects.get(ConditionNamesFiller.GRAIN_MOISTURE_KEY);
      ConditionNameObject tillageDirectionConditionName =
          mConditionNamesFiller.objects.get(ConditionNamesFiller.TILLAGE_DIRECTION_KEY);
      ConditionNameObject tillageDepthConditionName =
          mConditionNamesFiller.objects.get(ConditionNamesFiller.TILLAGE_DEPTH_KEY);
      ConditionNameObject phenologicalCharacteristicConditionName =
          mConditionNamesFiller.objects.get(ConditionNamesFiller.PHENOLOGICAL_CHARACTERISTIC_KEY);

      ConditionSpanValueObject temperature0to10 =
          mSpanValueFiller.objects.get(SpanValueFiller.SPAN_0_10_KEY);
      ConditionSpanValueObject temperature10to300 =
          mSpanValueFiller.objects.get(SpanValueFiller.SPAN_10_300_KEY);
      ConditionSpanValueObject temperature12to20 =
          mSpanValueFiller.objects.get(SpanValueFiller.SPAN_12_20_KEY);
      ConditionSpanValueObject temperature8to10 =
          mSpanValueFiller.objects.get(SpanValueFiller.SPAN_8_10_KEY);
      ConditionSpanValueObject temperature0to25 =
          mSpanValueFiller.objects.get(SpanValueFiller.SPAN_0_25_KEY);

      int lowestPriority = ConditionObject.LOWEST_PRIORITY;
      int highestPriority = ConditionObject.HIGHEST_PRIORITY;

      // Air temperatures
      objects.put(1, new ConditionObject(1, lowestPriority, airTemperatureConditionName,
          spanValueConditionType, temperature0to10));
      objects.put(2, new ConditionObject(2, lowestPriority, airTemperatureConditionName,
          spanValueConditionType, temperature10to300));
      objects.put(3, new ConditionObject(3, lowestPriority, airTemperatureConditionName,
          spanValueConditionType, temperature12to20));
      objects.put(4, new ConditionObject(4, lowestPriority, airTemperatureConditionName,
          spanValueConditionType, temperature8to10));
      objects.put(5, new ConditionObject(5, lowestPriority, airTemperatureConditionName,
          spanValueConditionType, temperature0to25));

      // Air moisture
      objects.put(6,
          new ConditionObject(6, lowestPriority, airMoistureConditionName, spanValueConditionType,
              mSpanValueFiller.objects.get(SpanValueFiller.SPAN_60_99_KEY)));
      objects.put(7,
          new ConditionObject(7, lowestPriority, airMoistureConditionName, spanValueConditionType,
              mSpanValueFiller.objects.get(SpanValueFiller.SPAN_30_50_KEY)));
      objects.put(8,
          new ConditionObject(8, lowestPriority, airMoistureConditionName, spanValueConditionType,
              mSpanValueFiller.objects.get(SpanValueFiller.SPAN_50_99_KEY)));
      objects.put(9,
          new ConditionObject(9, lowestPriority, airMoistureConditionName, spanValueConditionType,
              mSpanValueFiller.objects.get(SpanValueFiller.SPAN_0_80_KEY)));

      // Soil types
      objects.put(10,
          new ConditionObject(10, lowestPriority, soilTypeConditionName, soilTypeConditionType,
              mSoilTypeValueFiller.objects.get(1)));
      objects.put(11,
          new ConditionObject(11, lowestPriority, soilTypeConditionName, soilTypeConditionType,
              mSoilTypeValueFiller.objects.get(2)));

      // Soil moisture
      objects.put(12, new ConditionObject(12, highestPriority, soilMoistureConditionName,
          spanValueConditionType, mSpanValueFiller.objects.get(SpanValueFiller.SPAN_40_70_KEY)));
      objects.put(13, new ConditionObject(13, highestPriority, soilMoistureConditionName,
          spanValueConditionType, mSpanValueFiller.objects.get(SpanValueFiller.SPAN_50_65_KEY)));
      objects.put(14, new ConditionObject(14, 2, soilMoistureConditionName, spanValueConditionType,
          mSpanValueFiller.objects.get(SpanValueFiller.SPAN_40_60_KEY)));
      objects.put(15,
          new ConditionObject(15, lowestPriority, soilMoistureConditionName, spanValueConditionType,
              mSpanValueFiller.objects.get(SpanValueFiller.SPAN_40_50_KEY)));
      objects.put(16,
          new ConditionObject(16, lowestPriority, soilMoistureConditionName, spanValueConditionType,
              mSpanValueFiller.objects.get(SpanValueFiller.SPAN_30_40_KEY)));
      objects.put(17,
          new ConditionObject(17, lowestPriority, soilMoistureConditionName, spanValueConditionType,
              mSpanValueFiller.objects.get(SpanValueFiller.SPAN_20_50_KEY)));

      // Soil temperature
      objects.put(18, new ConditionObject(18, highestPriority, soilTemperatureConditionName,
          spanValueConditionType, mSpanValueFiller.objects.get(SpanValueFiller.SPAN_0_5_KEY)));
      objects.put(19, new ConditionObject(19, highestPriority, soilTemperatureConditionName,
          spanValueConditionType, mSpanValueFiller.objects.get(SpanValueFiller.SPAN_8_10_KEY)));
      objects.put(20, new ConditionObject(20, highestPriority, soilTemperatureConditionName,
          spanValueConditionType, mSpanValueFiller.objects.get(SpanValueFiller.SPAN_8_12_KEY)));
      objects.put(21, new ConditionObject(21, lowestPriority, soilTemperatureConditionName,
          spanValueConditionType, mSpanValueFiller.objects.get(SpanValueFiller.SPAN_8_10_KEY)));

      // Planned yield
      objects.put(22,
          new ConditionObject(22, lowestPriority, plannedYieldConditionName, spanValueConditionType,
              mSpanValueFiller.objects.get(SpanValueFiller.SPAN_8_10_KEY)));

      // Weed amount
      objects.put(23,
          new ConditionObject(23, lowestPriority, weedAmountConditionName, spanValueConditionType,
              mSpanValueFiller.objects.get(SpanValueFiller.SPAN_10_50_KEY)));
      objects.put(24,
          new ConditionObject(24, lowestPriority, weedAmountConditionName, spanValueConditionType,
              mSpanValueFiller.objects.get(SpanValueFiller.SPAN_1_5_KEY)));
      objects.put(25,
          new ConditionObject(25, highestPriority, weedAmountConditionName, spanValueConditionType,
              mSpanValueFiller.objects.get(SpanValueFiller.SPAN_10_50_KEY)));
      objects.put(26,
          new ConditionObject(26, highestPriority, weedAmountConditionName, spanValueConditionType,
              mSpanValueFiller.objects.get(SpanValueFiller.SPAN_1_5_KEY)));

      // Grain moisture
      objects.put(27, new ConditionObject(27, highestPriority, grainMoistureConditionName,
          spanValueConditionType, mSpanValueFiller.objects.get(SpanValueFiller.SPAN_0_14_KEY)));
      objects.put(28, new ConditionObject(28, lowestPriority, grainMoistureConditionName,
          spanValueConditionType, mSpanValueFiller.objects.get(SpanValueFiller.SPAN_0_30_KEY)));

      // Tillage depth
      objects.put(29,
          new ConditionObject(29, lowestPriority, tillageDepthConditionName, spanValueConditionType,
              mSpanValueFiller.objects.get(SpanValueFiller.SPAN_10_12_KEY)));
      objects.put(30,
          new ConditionObject(30, lowestPriority, tillageDepthConditionName, spanValueConditionType,
              mSpanValueFiller.objects.get(SpanValueFiller.SPAN_6_10_KEY)));
      objects.put(31,
          new ConditionObject(31, lowestPriority, tillageDepthConditionName, spanValueConditionType,
              mSpanValueFiller.objects.get(SpanValueFiller.SPAN_5_8_KEY)));
      objects.put(32,
          new ConditionObject(32, lowestPriority, tillageDepthConditionName, spanValueConditionType,
              mSpanValueFiller.objects.get(SpanValueFiller.SPAN_4_8_KEY)));
      objects.put(33,
          new ConditionObject(33, lowestPriority, tillageDepthConditionName, spanValueConditionType,
              mSpanValueFiller.objects.get(SpanValueFiller.SPAN_2_4_KEY)));
      objects.put(34,
          new ConditionObject(34, lowestPriority, tillageDepthConditionName, spanValueConditionType,
              mSpanValueFiller.objects.get(SpanValueFiller.SPAN_4_5_KEY)));
      objects.put(35,
          new ConditionObject(35, lowestPriority, tillageDepthConditionName, spanValueConditionType,
              mSpanValueFiller.objects.get(SpanValueFiller.SPAN_6_8_KEY)));

      int currentId = 36;

      // Phenological characteristic
      /*
      37, "Цвітіння черемухи, черешні"
      38, "Активна вегетація. Рослини не повинні перебувати в стресовому стані"
      39, "Початок масового льоту кукурудзяного метелика -визначається за допомогою феромонних пасток. "
      40, "масове відкладання яєць кукурудзяним метеликом"
      41, "проникнення перших гусениць у стебла"
      42, "Активна вегетація бур’янів"
      43, "Візуально визначається по наявності чор-ного прошарку (чорної точки) між зерном і місцем прикріплення його до качана"
      */
      for (int i = 0; i < mPhenologicalCharacteristicValueFiller.objects.size(); i++) {
        objects.put(currentId,
            new ConditionObject(currentId, lowestPriority, phenologicalCharacteristicConditionName,
                phenologicalCharacteristicConditionType,
                mPhenologicalCharacteristicValueFiller.objects.valueAt(i)));
        currentId++;
      }

      // Tillage directions
      /*
      44 "під кутом 45⁰ до напряму оранки")
      45 "Човнико-вий або діагональ-ний")
      46 "міжряддя вздовж рядків")
      47 "суцільний обробіток")
      */
      for (int i = 0; i < mTillageDirectionValueFiller.objects.size(); i++) {
        objects.put(currentId,
            new ConditionObject(currentId, lowestPriority, tillageDirectionConditionName,
                tillageDirectionConditionType, mTillageDirectionValueFiller.objects.valueAt(i)));
        currentId++;
      }

      // Harmful objects
      for (int i = 0; i < mHarmfulObjectValueFiller.objects.size(); i++) {
        objects.put(currentId,
            new ConditionObject(currentId, lowestPriority, harmfulObjectConditionName,
                harmfulObjectConditionType, mHarmfulObjectValueFiller.objects.valueAt(i)));
        currentId++;
      }

      // Harmful object phases
      objects.put(currentId,
          new ConditionObject(currentId, lowestPriority, harmfulObjectPhaseConditionName,
              harmfulObjectPhaseConditionType, mHarmfulObjectPhaseValueFiller.objects.get(5)));
      currentId++;
      objects.put(currentId,
          new ConditionObject(currentId, lowestPriority, harmfulObjectPhaseConditionName,
              harmfulObjectPhaseConditionType, mHarmfulObjectPhaseValueFiller.objects.get(16)));
      currentId++;
      objects.put(currentId,
          new ConditionObject(currentId, lowestPriority, harmfulObjectPhaseConditionName,
              harmfulObjectPhaseConditionType, mHarmfulObjectPhaseValueFiller.objects.get(11)));
      currentId++;
      objects.put(currentId, new ConditionObject(currentId, highestPriority,
          harmfulObjectPhaseConditionName, harmfulObjectPhaseConditionType,
          mHarmfulObjectPhaseValueFiller.objects.get(1)));
      currentId++;
      objects.put(currentId, new ConditionObject(currentId, highestPriority,
          harmfulObjectPhaseConditionName, harmfulObjectPhaseConditionType,
          mHarmfulObjectPhaseValueFiller.objects.get(3)));
      currentId++;
      objects.put(currentId, new ConditionObject(currentId, highestPriority,
          harmfulObjectPhaseConditionName, harmfulObjectPhaseConditionType,
          mHarmfulObjectPhaseValueFiller.objects.get(4)));
      currentId++;
      objects.put(currentId, new ConditionObject(currentId, highestPriority,
          harmfulObjectPhaseConditionName, harmfulObjectPhaseConditionType,
          mHarmfulObjectPhaseValueFiller.objects.get(7)));
      currentId++;
      objects.put(currentId, new ConditionObject(currentId, highestPriority,
          harmfulObjectPhaseConditionName, harmfulObjectPhaseConditionType,
          mHarmfulObjectPhaseValueFiller.objects.get(10)));
      currentId++;
      objects.put(currentId, new ConditionObject(currentId, highestPriority,
          harmfulObjectPhaseConditionName, harmfulObjectPhaseConditionType,
          mHarmfulObjectPhaseValueFiller.objects.get(8)));
      currentId++;
      objects.put(currentId,
          new ConditionObject(currentId, lowestPriority, harmfulObjectPhaseConditionName,
              harmfulObjectPhaseConditionType, mHarmfulObjectPhaseValueFiller.objects.get(12)));
      currentId++;
      objects.put(currentId,
          new ConditionObject(currentId, lowestPriority, harmfulObjectPhaseConditionName,
              harmfulObjectPhaseConditionType, mHarmfulObjectPhaseValueFiller.objects.get(6)));
      currentId++;
      objects.put(currentId,
          new ConditionObject(currentId, lowestPriority, harmfulObjectPhaseConditionName,
              harmfulObjectPhaseConditionType, mHarmfulObjectPhaseValueFiller.objects.get(7)));
      currentId++;
      objects.put(currentId,
          new ConditionObject(currentId, lowestPriority, harmfulObjectPhaseConditionName,
              harmfulObjectPhaseConditionType, mHarmfulObjectPhaseValueFiller.objects.get(10)));
      currentId++;
      objects.put(currentId,
          new ConditionObject(currentId, lowestPriority, harmfulObjectPhaseConditionName,
              harmfulObjectPhaseConditionType, mHarmfulObjectPhaseValueFiller.objects.get(8)));
      currentId++;
      objects.put(currentId,
          new ConditionObject(currentId, lowestPriority, harmfulObjectPhaseConditionName,
              harmfulObjectPhaseConditionType, mHarmfulObjectPhaseValueFiller.objects.get(13)));
      currentId++;
      objects.put(currentId,
          new ConditionObject(currentId, lowestPriority, harmfulObjectPhaseConditionName,
              harmfulObjectPhaseConditionType, mHarmfulObjectPhaseValueFiller.objects.get(14)));
      currentId++;
      objects.put(currentId,
          new ConditionObject(currentId, lowestPriority, harmfulObjectPhaseConditionName,
              harmfulObjectPhaseConditionType, mHarmfulObjectPhaseValueFiller.objects.get(15)));
      currentId++;
      objects.put(currentId, new ConditionObject(currentId, 2, harmfulObjectPhaseConditionName,
          harmfulObjectPhaseConditionType, mHarmfulObjectPhaseValueFiller.objects.get(10)));
      currentId++;
      objects.put(currentId, new ConditionObject(currentId, 2, harmfulObjectPhaseConditionName,
          harmfulObjectPhaseConditionType, mHarmfulObjectPhaseValueFiller.objects.get(9)));
      currentId++;

      // Previous crops
      for (int i = 0; i < mPreviousCropValueFiller.objects.size(); i++) {
        objects.put(currentId,
            new ConditionObject(currentId, lowestPriority, previousCropConditionName,
                previousCropConditionType, mPreviousCropValueFiller.objects.valueAt(i)));
        currentId++;
      }
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putCondition(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      ConditionEntity[] res = new ConditionEntity[objects.size()];
      fillEntitiesArray(objects, res, new ConditionObjectToConditionEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new ConditionEntity[objects.size()],
          new ConditionObjectToConditionEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, ConditionEntity[].class);
    }
  }

  private class CropTechnologicalProcessConditionFiller extends BaseFiller {
    private static final int CAPACITY = 15;

    private SparseArrayCompat<TechnologicalProcessConditionObject> objects =
        new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return TechnologicalProcessConditionEntity[].class.getName();
    }

    @Override void makeObjects() {
      CropTechnologicalProcessObject posevStepTechProc =
          mCropTechnologicalProcessFiller.objects.get(6);
      CropTechnologicalProcessObject posevLisostepTechProc =
          mCropTechnologicalProcessFiller.objects.get(7);
      CropTechnologicalProcessObject posevPolesseTechProc =
          mCropTechnologicalProcessFiller.objects.get(8);

      CropTechnologicalProcessObject soilGerbStepTechProc =
          mCropTechnologicalProcessFiller.objects.get(24);
      CropTechnologicalProcessObject soilGerbLisostepTechProc =
          mCropTechnologicalProcessFiller.objects.get(25);
      CropTechnologicalProcessObject soilGerbPolesseTechProc =
          mCropTechnologicalProcessFiller.objects.get(26);

      // 4a - Посів та припосівне внесення добрив
      objects.put(1, new TechnologicalProcessConditionObject(1, 1, posevStepTechProc,
          mConditionsFiller.objects.get(20))); /*т почвы 8-12*/
      objects.put(2, new TechnologicalProcessConditionObject(2, 1, posevStepTechProc,
          mConditionsFiller.objects.get(22))); /*план урожайность 8-10*/
      objects.put(3, new TechnologicalProcessConditionObject(3, 1, posevStepTechProc,
          mConditionsFiller.objects.get(3))); /*т воздуха 12-20*/
      objects.put(4, new TechnologicalProcessConditionObject(4, 1, posevStepTechProc,
          mConditionsFiller.objects.get(30))); /*глубина обработки 6-10*/
      objects.put(5, new TechnologicalProcessConditionObject(5, 1, posevStepTechProc,
          mConditionsFiller.objects.get(37))); /*фенол хар: цвет черемухи*/
      objects.put(6, new TechnologicalProcessConditionObject(6, 2, posevLisostepTechProc,
          mConditionsFiller.objects.get(20))); /*т почвы 8-12*/
      objects.put(7, new TechnologicalProcessConditionObject(7, 2, posevLisostepTechProc,
          mConditionsFiller.objects.get(22))); /*план урожайность 8-10*/
      objects.put(8, new TechnologicalProcessConditionObject(8, 2, posevLisostepTechProc,
          mConditionsFiller.objects.get(3))); /*т воздуха 12-20*/
      objects.put(9, new TechnologicalProcessConditionObject(9, 2, posevLisostepTechProc,
          mConditionsFiller.objects.get(31))); /*глубина обработки 5-8*/ // 32
      objects.put(10, new TechnologicalProcessConditionObject(10, 2, posevLisostepTechProc,
          mConditionsFiller.objects.get(37))); /*фенол хар: цвет черемухи*/
      objects.put(11, new TechnologicalProcessConditionObject(11, 3, posevPolesseTechProc,
          mConditionsFiller.objects.get(20))); /*т почвы 8-12*/
      objects.put(12, new TechnologicalProcessConditionObject(12, 3, posevPolesseTechProc,
          mConditionsFiller.objects.get(22))); /*план урожайность 8-10*/
      objects.put(13, new TechnologicalProcessConditionObject(13, 3, posevPolesseTechProc,
          mConditionsFiller.objects.get(3))); /*т воздуха 12-20*/
      objects.put(14, new TechnologicalProcessConditionObject(14, 3, posevPolesseTechProc,
          mConditionsFiller.objects.get(32))); /*глубина обработки 4-8*/
      objects.put(15, new TechnologicalProcessConditionObject(15, 3, posevPolesseTechProc,
          mConditionsFiller.objects.get(37))); /*фенол хар: цвет черемухи*/

      // 5б Внесення гербіциду по вегетуючій культурі
      /*objects.put(, new TechnologicalProcessConditionObject(, 1, soilGerbStepTechProc, mConditionsFiller.objects.get())); *//*TODO: вред об. Однорічні і багаторічні дводольні та злакові бур’яни*//*
      objects.put(, new TechnologicalProcessConditionObject(, 1, soilGerbStepTechProc, mConditionsFiller.objects.get()));
      objects.put(, new TechnologicalProcessConditionObject(, 1, soilGerbStepTechProc, mConditionsFiller.objects.get()));*/
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putTechnologicalProcessCondition(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      TechnologicalProcessConditionEntity[] res =
          new TechnologicalProcessConditionEntity[objects.size()];
      fillEntitiesArray(objects, res,
          new TechnologicalProcessConditionObjectToTechnologicalProcessConditionEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new TechnologicalProcessConditionEntity[objects.size()],
          new TechnologicalProcessConditionObjectToTechnologicalProcessConditionEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, TechnologicalProcessConditionEntity[].class);
    }
  }

  private class HarmfulObjectTypeFiller extends BaseFiller {

    static final int WEED_KEY = 1;
    static final int PEST_KEY = 2;
    static final int DISEASE_KEY = 3;

    private static final int CAPACITY = 3;

    private SparseArrayCompat<HarmfulObjectTypeObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return HarmfulObjectTypeEntity[].class.getName();
    }

    @Override void makeObjects() {
      objects.put(WEED_KEY, new HarmfulObjectTypeObject(1, "Сорняки"));
      objects.put(PEST_KEY, new HarmfulObjectTypeObject(2, "Вредители"));
      objects.put(DISEASE_KEY, new HarmfulObjectTypeObject(3, "Болезни"));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putHarmfulObjectType(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      HarmfulObjectTypeEntity[] res = new HarmfulObjectTypeEntity[objects.size()];
      fillEntitiesArray(objects, res, new HarmfulObjectTypeObjectToHarmfulObjectTypeEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new HarmfulObjectTypeEntity[objects.size()],
          new HarmfulObjectTypeObjectToHarmfulObjectTypeEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, HarmfulObjectTypeEntity[].class);
    }
  }

  private class PestClassFiller extends BaseFiller {

    private static final int MYRIAPODA_KEY = 1;
    private static final int INSECTA_KEY = 2;

    private static final int CAPACITY = 2;

    private SparseArrayCompat<PestClassObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return PestClassEntity[].class.getName();
    }

    @Override void makeObjects() {
      objects.put(MYRIAPODA_KEY, new PestClassObject(1, "Багатоніжки"));
      objects.put(INSECTA_KEY, new PestClassObject(2, "Комахи"));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putPestClass(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      PestClassEntity[] res = new PestClassEntity[objects.size()];
      fillEntitiesArray(objects, res, new PestClassObjectToPestClassEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new PestClassEntity[objects.size()],
          new PestClassObjectToPestClassEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, PestClassEntity[].class);
    }
  }

  private class PestOrderFiller extends BaseFiller {

    private static final int DIPLOPODA_KEY = 1;
    private static final int COLEOPTERA_KEY = 2;
    private static final int DIPTERA_KEY = 3;
    private static final int HOMOPTERA_KEY = 4;
    private static final int LEPIDOPTERA_KEY = 5;

    private static final int CAPACITY = 5;

    private SparseArrayCompat<PestOrderObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return PestOrderEntity[].class.getName();
    }

    @Override void makeObjects() {
      objects.put(DIPLOPODA_KEY, new PestOrderObject(1, "Двопарноногі"));
      objects.put(COLEOPTERA_KEY, new PestOrderObject(2, "Твердокрилі (жуки)"));
      objects.put(DIPTERA_KEY, new PestOrderObject(3, "Двокрилі (мухи)"));
      objects.put(HOMOPTERA_KEY, new PestOrderObject(4, "Рівнокрилі"));
      objects.put(LEPIDOPTERA_KEY, new PestOrderObject(5, "Лускокрилі (метелики)"));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putPestOrder(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      PestOrderEntity[] res = new PestOrderEntity[objects.size()];
      fillEntitiesArray(objects, res, new PestOrderObjectToPestOrderEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new PestOrderEntity[objects.size()],
          new PestOrderObjectToPestOrderEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, PestOrderEntity[].class);
    }
  }

  private class PestFiller extends BaseFiller {

    private static final int CAPACITY = 13;

    private SparseArrayCompat<PestObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return PestEntity[].class.getName();
    }

    @Override void makeObjects() {
      HarmfulObjectTypeObject pestHarmfulObjectType =
          mHarmfulObjectTypeFiller.objects.get(HarmfulObjectTypeFiller.PEST_KEY);

      PestClassObject insectaPestClass = mPestClassFiller.objects.get(PestClassFiller.INSECTA_KEY);
      PestClassObject myriapodaPestClass =
          mPestClassFiller.objects.get(PestClassFiller.MYRIAPODA_KEY);

      PestOrderObject coleopteraPestOrder =
          mPestOrderFiller.objects.get(PestOrderFiller.COLEOPTERA_KEY);
      PestOrderObject dipteraPestOrder = mPestOrderFiller.objects.get(PestOrderFiller.DIPTERA_KEY);
      PestOrderObject homopteraPestOrder =
          mPestOrderFiller.objects.get(PestOrderFiller.HOMOPTERA_KEY);
      PestOrderObject lepidopteraPestOrder =
          mPestOrderFiller.objects.get(PestOrderFiller.LEPIDOPTERA_KEY);
      PestOrderObject diplopodaPestOrder =
          mPestOrderFiller.objects.get(PestOrderFiller.DIPLOPODA_KEY);

      objects.put(1, new PestObject(1, pestHarmfulObjectType, "Широкий ковалик", insectaPestClass,
          coleopteraPestOrder));
      objects.put(2, new PestObject(2, pestHarmfulObjectType, "Буроногий ковалик", insectaPestClass,
          coleopteraPestOrder));
      objects.put(3, new PestObject(3, pestHarmfulObjectType, "Темний ковалик", insectaPestClass,
          coleopteraPestOrder));
      objects.put(4, new PestObject(4, pestHarmfulObjectType, "Посівний ковалик", insectaPestClass,
          coleopteraPestOrder));
      objects.put(5, new PestObject(5, pestHarmfulObjectType, "Степовий ковалик", insectaPestClass,
          coleopteraPestOrder));
      objects.put(6, new PestObject(6, pestHarmfulObjectType, "Мідляк піщаний", insectaPestClass,
          coleopteraPestOrder));
      objects.put(7, new PestObject(7, pestHarmfulObjectType, "Мідляк степовий", insectaPestClass,
          coleopteraPestOrder));
      objects.put(8,
          new PestObject(8, pestHarmfulObjectType, "Кукурудзяна чорнотілка", insectaPestClass,
              coleopteraPestOrder));
      objects.put(9,
          new PestObject(9, pestHarmfulObjectType, "Південний сірий довгоносик", insectaPestClass,
              coleopteraPestOrder));
      objects.put(10, new PestObject(10, pestHarmfulObjectType, "Шведська муха", insectaPestClass,
          dipteraPestOrder));
      objects.put(11, new PestObject(11, pestHarmfulObjectType, "Попелиця", insectaPestClass,
          homopteraPestOrder));
      objects.put(12,
          new PestObject(12, pestHarmfulObjectType, "Кукурудзяний метелик", insectaPestClass,
              lepidopteraPestOrder));
      objects.put(13,
          new PestObject(13, pestHarmfulObjectType, "Ківсяк піщаний", myriapodaPestClass,
              diplopodaPestOrder));
      objects.put(14, new PestObject(14, pestHarmfulObjectType, "Хрущ травневий", insectaPestClass,
          coleopteraPestOrder));
      objects.put(15, new PestObject(15, pestHarmfulObjectType, "Хрущ польовий", insectaPestClass,
          coleopteraPestOrder));
      objects.put(16, new PestObject(16, pestHarmfulObjectType, "Хлібний жук", insectaPestClass,
          coleopteraPestOrder));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putPest(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      PestEntity[] res = new PestEntity[objects.size()];
      fillEntitiesArray(objects, res, new PestObjectToPestEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new PestEntity[objects.size()],
          new PestObjectToPestEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, PestEntity[].class);
    }
  }

  private class WeedNutritionTypeFiller extends BaseFiller {

    private static final int NON_PARASITES_KEY = 1;

    private static final int CAPACITY = 3;

    private SparseArrayCompat<WeedNutritionTypeObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return WeedNutritionTypeEntity[].class.getName();
    }

    @Override void makeObjects() {
      objects.put(NON_PARASITES_KEY, new WeedNutritionTypeObject(1, "Непаразити"));
      objects.put(2, new WeedNutritionTypeObject(2, "Напівпаразити"));
      objects.put(3, new WeedNutritionTypeObject(3, "Паразити"));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putWeedNutritionType(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      WeedNutritionTypeEntity[] res = new WeedNutritionTypeEntity[objects.size()];
      fillEntitiesArray(objects, res, new WeedNutritionTypeObjectToWeedNutritionTypeEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new WeedNutritionTypeEntity[objects.size()],
          new WeedNutritionTypeObjectToWeedNutritionTypeEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, WeedNutritionTypeEntity[].class);
    }
  }

  private class WeedClassFiller extends BaseFiller {

    private static final int DICOT_KEY = 1;
    private static final int MONOCOT_KEY = 39;
    private static final int CEREAL_KEY = 40;
    private static final int SPORE_KEY = 41;

    private static final int CAPACITY = 41;

    private SparseArrayCompat<WeedClassObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return WeedClassEntity[].class.getName();
    }

    @Override void makeObjects() {
      objects.put(1, new WeedClassObject(DICOT_KEY, "Дводольні", 0, true));
      objects.put(2, new WeedClassObject(2, "Губоцвіті ", DICOT_KEY, false));
      objects.put(3, new WeedClassObject(3, "Капустяні", DICOT_KEY, false));
      objects.put(4, new WeedClassObject(4, "Фіалкові", DICOT_KEY, false));
      objects.put(5, new WeedClassObject(5, "Макові", DICOT_KEY, false));
      objects.put(6, new WeedClassObject(6, "Геранієві", DICOT_KEY, false));
      objects.put(7, new WeedClassObject(7, "Айстрові", DICOT_KEY, false));
      objects.put(8, new WeedClassObject(8, "Бурачникові", DICOT_KEY, false));
      objects.put(9, new WeedClassObject(9, "Жовтецеві", DICOT_KEY, false));
      objects.put(10, new WeedClassObject(10, "Гвоздикові", DICOT_KEY, false));
      objects.put(11, new WeedClassObject(11, "Лободові", DICOT_KEY, false));
      objects.put(12, new WeedClassObject(12, "Мальвові", DICOT_KEY, false));
      objects.put(13, new WeedClassObject(13, "Бобові", DICOT_KEY, false));
      objects.put(14, new WeedClassObject(14, "Зонтичні", DICOT_KEY, false));
      objects.put(15, new WeedClassObject(15, "Паролистові", DICOT_KEY, false));
      objects.put(16, new WeedClassObject(16, "Маренові", DICOT_KEY, false));
      objects.put(17, new WeedClassObject(17, "Гречкові", DICOT_KEY, false));
      objects.put(18, new WeedClassObject(18, "Резедові", DICOT_KEY, false));
      objects.put(19, new WeedClassObject(19, "Амарантові", DICOT_KEY, false));
      objects.put(20, new WeedClassObject(20, "Складноцвіті", DICOT_KEY, false));
      objects.put(21, new WeedClassObject(21, "Пасльонові", DICOT_KEY, false));
      objects.put(22, new WeedClassObject(22, "Первоцвітові", DICOT_KEY, false));
      objects.put(23, new WeedClassObject(23, "Кропивні", DICOT_KEY, false));
      objects.put(24, new WeedClassObject(24, "Конопляні", DICOT_KEY, false));
      objects.put(25, new WeedClassObject(25, "Камелінові", DICOT_KEY, false));
      objects.put(26, new WeedClassObject(26, "Портулакові", DICOT_KEY, false));
      objects.put(27, new WeedClassObject(27, "Щирицеві", DICOT_KEY, false));
      objects.put(28, new WeedClassObject(28, "Барвінкові", DICOT_KEY, false));
      objects.put(29, new WeedClassObject(29, "Квасеницюваті", DICOT_KEY, false));
      objects.put(30, new WeedClassObject(30, "Хвилівникові", DICOT_KEY, false));
      objects.put(31, new WeedClassObject(31, "Онагрові", DICOT_KEY, false));
      objects.put(32, new WeedClassObject(32, "Молочайні", DICOT_KEY, false));
      objects.put(33, new WeedClassObject(33, "Ранникові", DICOT_KEY, false));
      objects.put(34, new WeedClassObject(34, "Березкові", DICOT_KEY, false));
      objects.put(35, new WeedClassObject(35, "Подорожникові", DICOT_KEY, false));
      objects.put(36, new WeedClassObject(36, "Розові", DICOT_KEY, false));
      objects.put(37, new WeedClassObject(37, "Лілійні", DICOT_KEY, false));
      objects.put(38, new WeedClassObject(38, "Шорстколисті", DICOT_KEY, false));
      objects.put(39, new WeedClassObject(MONOCOT_KEY, "Однодольні", 0, true));
      objects.put(40, new WeedClassObject(CEREAL_KEY, "Злакові (тонконогові)", MONOCOT_KEY, false));
      objects.put(41, new WeedClassObject(SPORE_KEY, "Хвощовидні (спорові)", 0, true));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putWeedClass(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      WeedClassEntity[] res = new WeedClassEntity[objects.size()];
      fillEntitiesArray(objects, res, new WeedClassObjectToWeedClassEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new WeedClassEntity[objects.size()],
          new WeedClassObjectToWeedClassEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, WeedClassEntity[].class);
    }
  }

  private class WeedGroupFiller extends BaseFiller {

    private static final int SEMI_YEAR_KEY = 1;
    private static final int ARDENT_KEY = 2;
    private static final int EPHEMERAL_KEY = 3;
    private static final int EARLY_KEY = 4;
    private static final int LATE_KEY = 5;
    private static final int WINTER_KEY = 6;
    private static final int WINTERING_KEY = 7;
    private static final int TWO_YEAR_KEY = 8;
    private static final int POLY_YEAR_KEY = 9;
    private static final int ROOT_KEY = 10;
    private static final int ROOT_SPROUT_KEY = 11;
    private static final int ROOT_FIBER_KEY = 12;
    private static final int STEM_ROOT_KEY = 13;
    private static final int REPENT_KEY = 14;
    private static final int TUBEROUS_KEY = 15;
    private static final int ONION_KEY = 16;

    private static final int CAPACITY = 16;

    private SparseArrayCompat<WeedGroupObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return WeedGroupEntity[].class.getName();
    }

    @Override void makeObjects() {
      objects.put(SEMI_YEAR_KEY, new WeedGroupObject(SEMI_YEAR_KEY, "Малорічні", 0, true));
      objects.put(ARDENT_KEY, new WeedGroupObject(ARDENT_KEY, "Ярі", SEMI_YEAR_KEY, true));
      objects.put(EPHEMERAL_KEY, new WeedGroupObject(EPHEMERAL_KEY, "Ефемери", ARDENT_KEY, false));
      objects.put(EARLY_KEY, new WeedGroupObject(EARLY_KEY, "Ранні", ARDENT_KEY, false));
      objects.put(LATE_KEY, new WeedGroupObject(LATE_KEY, "Пізні", ARDENT_KEY, false));
      objects.put(WINTER_KEY, new WeedGroupObject(WINTER_KEY, "Озимі", SEMI_YEAR_KEY, false));
      objects.put(WINTERING_KEY,
          new WeedGroupObject(WINTERING_KEY, "Зимуючі", SEMI_YEAR_KEY, false));
      objects.put(TWO_YEAR_KEY,
          new WeedGroupObject(TWO_YEAR_KEY, "Дворічні", SEMI_YEAR_KEY, false));
      objects.put(POLY_YEAR_KEY, new WeedGroupObject(POLY_YEAR_KEY, "Багаторічні", 0, true));
      objects.put(ROOT_KEY, new WeedGroupObject(ROOT_KEY, "Кореневищні", POLY_YEAR_KEY, false));
      objects.put(ROOT_SPROUT_KEY,
          new WeedGroupObject(ROOT_SPROUT_KEY, "Коренепаросткові", POLY_YEAR_KEY, false));
      objects.put(ROOT_FIBER_KEY,
          new WeedGroupObject(ROOT_FIBER_KEY, "Коренемичкуваті", POLY_YEAR_KEY, false));
      objects.put(STEM_ROOT_KEY,
          new WeedGroupObject(STEM_ROOT_KEY, "Стрижнекореневі", POLY_YEAR_KEY, false));
      objects.put(REPENT_KEY, new WeedGroupObject(REPENT_KEY, "Повзучі", POLY_YEAR_KEY, false));
      objects.put(TUBEROUS_KEY,
          new WeedGroupObject(TUBEROUS_KEY, "Бульбові", POLY_YEAR_KEY, false));
      objects.put(ONION_KEY, new WeedGroupObject(ONION_KEY, "Цибулинні", POLY_YEAR_KEY, false));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putWeedGroup(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      WeedGroupEntity[] res = new WeedGroupEntity[objects.size()];
      fillEntitiesArray(objects, res, new WeedGroupObjectToWeedGroupEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new WeedGroupEntity[objects.size()],
          new WeedGroupObjectToWeedGroupEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, WeedGroupEntity[].class);
    }
  }

  private class WeedFiller extends BaseFiller {

    private static final int CAPACITY = 125;

    private SparseArrayCompat<WeedObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return WeedEntity[].class.getName();
    }

    @Override void makeObjects() {
      long weedHarmfulObjectTypeId =
          mHarmfulObjectTypeFiller.objects.get(HarmfulObjectTypeFiller.WEED_KEY).getId();

      long nonParasiteNutritionTypeId =
          mWeedNutritionTypeFiller.objects.get(WeedNutritionTypeFiller.NON_PARASITES_KEY).getId();

      long ephemeralWeedGroupId =
          mWeedGroupFiller.objects.get(WeedGroupFiller.EPHEMERAL_KEY).getId();
      long earlyWeedGroupId = mWeedGroupFiller.objects.get(WeedGroupFiller.EARLY_KEY).getId();
      long lateWeedGroupId = mWeedGroupFiller.objects.get(WeedGroupFiller.LATE_KEY).getId();
      long winterWeedGroupId = mWeedGroupFiller.objects.get(WeedGroupFiller.WINTER_KEY).getId();
      long winteringWeedGroupId =
          mWeedGroupFiller.objects.get(WeedGroupFiller.WINTERING_KEY).getId();
      long twoYearWeedGroupId = mWeedGroupFiller.objects.get(WeedGroupFiller.TWO_YEAR_KEY).getId();
      long rootWeedGroupId = mWeedGroupFiller.objects.get(WeedGroupFiller.ROOT_KEY).getId();
      long rootSproutWeedGroupId =
          mWeedGroupFiller.objects.get(WeedGroupFiller.ROOT_SPROUT_KEY).getId();
      long rootFiberWeedGroupId =
          mWeedGroupFiller.objects.get(WeedGroupFiller.ROOT_FIBER_KEY).getId();
      long stemRootWeedGroupId =
          mWeedGroupFiller.objects.get(WeedGroupFiller.STEM_ROOT_KEY).getId();
      long repentWeedGroupId = mWeedGroupFiller.objects.get(WeedGroupFiller.REPENT_KEY).getId();
      long tuberousWeedGroupId = mWeedGroupFiller.objects.get(WeedGroupFiller.TUBEROUS_KEY).getId();
      long onionWeedGroupId = mWeedGroupFiller.objects.get(WeedGroupFiller.ONION_KEY).getId();

      long cerealWeedClassId = mWeedClassFiller.objects.get(WeedClassFiller.CEREAL_KEY).getId();

      // 5th parameter is hardcoded (look for values in WeedClassFiller)
      objects.put(1, new WeedObject(1, weedHarmfulObjectTypeId, "Зірочник середній, або мокрець",
          nonParasiteNutritionTypeId, 10, ephemeralWeedGroupId));
      objects.put(2,
          new WeedObject(2, weedHarmfulObjectTypeId, "Гостриця лежача", nonParasiteNutritionTypeId,
              38, ephemeralWeedGroupId));
      objects.put(3, new WeedObject(3, weedHarmfulObjectTypeId, "Червець однорічний",
          nonParasiteNutritionTypeId, 10, earlyWeedGroupId));
      objects.put(4,
          new WeedObject(4, weedHarmfulObjectTypeId, "Кукіль звичайний", nonParasiteNutritionTypeId,
              10, earlyWeedGroupId));
      objects.put(5,
          new WeedObject(5, weedHarmfulObjectTypeId, "Наземка польова", nonParasiteNutritionTypeId,
              11, earlyWeedGroupId));
      objects.put(6,
          new WeedObject(6, weedHarmfulObjectTypeId, "Лобода біла", nonParasiteNutritionTypeId, 11,
              earlyWeedGroupId));
      objects.put(7,
          new WeedObject(7, weedHarmfulObjectTypeId, "Редька дика", nonParasiteNutritionTypeId, 3,
              earlyWeedGroupId));
      objects.put(8,
          new WeedObject(8, weedHarmfulObjectTypeId, "Гірчиця польова", nonParasiteNutritionTypeId,
              3, earlyWeedGroupId));
      objects.put(9, new WeedObject(9, weedHarmfulObjectTypeId, "Гібіск трійчастий",
          nonParasiteNutritionTypeId, 12, earlyWeedGroupId));
      objects.put(10, new WeedObject(10, weedHarmfulObjectTypeId, "Горошок волохатий",
          nonParasiteNutritionTypeId, 13, earlyWeedGroupId));
      objects.put(11, new WeedObject(11, weedHarmfulObjectTypeId, "Біфора промениста",
          nonParasiteNutritionTypeId, 14, earlyWeedGroupId));
      objects.put(12,
          new WeedObject(12, weedHarmfulObjectTypeId, "Якірці сланкі", nonParasiteNutritionTypeId,
              15, earlyWeedGroupId));
      objects.put(13,
          new WeedObject(13, weedHarmfulObjectTypeId, "Рутка лікарська", nonParasiteNutritionTypeId,
              5, earlyWeedGroupId));
      objects.put(14, new WeedObject(14, weedHarmfulObjectTypeId, "Підмаренник чіпкий",
          nonParasiteNutritionTypeId, 16, earlyWeedGroupId));
      objects.put(15, new WeedObject(15, weedHarmfulObjectTypeId, "Гречка татарська",
          nonParasiteNutritionTypeId, 16, earlyWeedGroupId));
      objects.put(16, new WeedObject(16, weedHarmfulObjectTypeId, "Гірчак березковидний",
          nonParasiteNutritionTypeId, 16, earlyWeedGroupId));
      objects.put(17,
          new WeedObject(17, weedHarmfulObjectTypeId, "Резеда жовта", nonParasiteNutritionTypeId,
              18, lateWeedGroupId));
      objects.put(18, new WeedObject(18, weedHarmfulObjectTypeId, "Щириця жминдовидна",
          nonParasiteNutritionTypeId, 27, lateWeedGroupId));
      objects.put(19,
          new WeedObject(19, weedHarmfulObjectTypeId, "Щириця біла", nonParasiteNutritionTypeId, 27,
              lateWeedGroupId));
      objects.put(20, new WeedObject(20, weedHarmfulObjectTypeId, "Череда трироздільна",
          nonParasiteNutritionTypeId, 7, lateWeedGroupId));
      objects.put(21,
          new WeedObject(21, weedHarmfulObjectTypeId, "Паслін чорний", nonParasiteNutritionTypeId,
              21, lateWeedGroupId));
      objects.put(22, new WeedObject(22, weedHarmfulObjectTypeId, "Дурман звичайний",
          nonParasiteNutritionTypeId, 21, lateWeedGroupId));
      objects.put(23, new WeedObject(23, weedHarmfulObjectTypeId, "Очка курячі польові",
          nonParasiteNutritionTypeId, 22, lateWeedGroupId));
      objects.put(24,
          new WeedObject(24, weedHarmfulObjectTypeId, "Остудник голий", nonParasiteNutritionTypeId,
              10, lateWeedGroupId));
      objects.put(25, new WeedObject(25, weedHarmfulObjectTypeId, "Шпергель звичайний",
          nonParasiteNutritionTypeId, 10, lateWeedGroupId));
      objects.put(26,
          new WeedObject(26, weedHarmfulObjectTypeId, "Кропива жалка", nonParasiteNutritionTypeId,
              23, lateWeedGroupId));
      objects.put(27,
          new WeedObject(27, weedHarmfulObjectTypeId, "Коноплі дикі", nonParasiteNutritionTypeId,
              24, lateWeedGroupId));
      objects.put(28, new WeedObject(28, weedHarmfulObjectTypeId, "Комеліна звичайна",
          nonParasiteNutritionTypeId, 25, lateWeedGroupId));
      objects.put(29, new WeedObject(29, weedHarmfulObjectTypeId, "Комеліна звичайна",
          nonParasiteNutritionTypeId, 3, lateWeedGroupId));
      objects.put(30, new WeedObject(30, weedHarmfulObjectTypeId, "Залізниця гірська",
          nonParasiteNutritionTypeId, 2, lateWeedGroupId));
      objects.put(31,
          new WeedObject(31, weedHarmfulObjectTypeId, "Жабрій ладанний", nonParasiteNutritionTypeId,
              2, lateWeedGroupId));
      objects.put(32, new WeedObject(32, weedHarmfulObjectTypeId, "Жабрій звичайний",
          nonParasiteNutritionTypeId, 2, lateWeedGroupId));
      objects.put(33, new WeedObject(33, weedHarmfulObjectTypeId, "Геліотроп європейський",
          nonParasiteNutritionTypeId, 38, lateWeedGroupId));
      objects.put(34, new WeedObject(34, weedHarmfulObjectTypeId, "Портулак городній",
          nonParasiteNutritionTypeId, 26, lateWeedGroupId));
      objects.put(35,
          new WeedObject(35, weedHarmfulObjectTypeId, "Курай руський", nonParasiteNutritionTypeId,
              11, lateWeedGroupId));
      objects.put(36,
          new WeedObject(36, weedHarmfulObjectTypeId, "Щириця звичайна", nonParasiteNutritionTypeId,
              27, lateWeedGroupId));
      objects.put(37, new WeedObject(37, weedHarmfulObjectTypeId, "Спориш звичайний",
          nonParasiteNutritionTypeId, 17, lateWeedGroupId));
      objects.put(38,
          new WeedObject(38, weedHarmfulObjectTypeId, "Гірчак шорсткий", nonParasiteNutritionTypeId,
              17, lateWeedGroupId));
      objects.put(39, new WeedObject(39, weedHarmfulObjectTypeId, "Осот жовтий городній",
          nonParasiteNutritionTypeId, 7, lateWeedGroupId));
      objects.put(40, new WeedObject(40, weedHarmfulObjectTypeId, "Чорнощир звичайний",
          nonParasiteNutritionTypeId, 7, lateWeedGroupId));
      objects.put(41, new WeedObject(41, weedHarmfulObjectTypeId, "Соняшник смітний",
          nonParasiteNutritionTypeId, 7, lateWeedGroupId));
      objects.put(42, new WeedObject(42, weedHarmfulObjectTypeId, "Нетреба звичайна",
          nonParasiteNutritionTypeId, 7, lateWeedGroupId));
      objects.put(43,
          new WeedObject(43, weedHarmfulObjectTypeId, "Галінсога дрібноквіткова, або незбутниця",
              nonParasiteNutritionTypeId, 7, lateWeedGroupId));
      objects.put(44, new WeedObject(44, weedHarmfulObjectTypeId, "Амброзія трироздільна",
          nonParasiteNutritionTypeId, 7, lateWeedGroupId));
      objects.put(45, new WeedObject(45, weedHarmfulObjectTypeId, "Амброзія полинолиста",
          nonParasiteNutritionTypeId, 7, lateWeedGroupId));
      objects.put(46, new WeedObject(46, weedHarmfulObjectTypeId, "Хрінниця смердюча",
          nonParasiteNutritionTypeId, 3, winteringWeedGroupId));
      objects.put(47,
          new WeedObject(47, weedHarmfulObjectTypeId, "Хориспора ніжна", nonParasiteNutritionTypeId,
              3, winteringWeedGroupId));
      objects.put(48, new WeedObject(48, weedHarmfulObjectTypeId, "Сухоребрик льозеліїв",
          nonParasiteNutritionTypeId, 3, winteringWeedGroupId));
      objects.put(49, new WeedObject(49, weedHarmfulObjectTypeId, "Талабан польовий",
          nonParasiteNutritionTypeId, 3, winteringWeedGroupId));
      objects.put(50, new WeedObject(50, weedHarmfulObjectTypeId, "Кучерявець Софії",
          nonParasiteNutritionTypeId, 3, winteringWeedGroupId));
      objects.put(51, new WeedObject(51, weedHarmfulObjectTypeId, "Грицики звичайні",
          nonParasiteNutritionTypeId, 3, winteringWeedGroupId));
      objects.put(52, new WeedObject(52, weedHarmfulObjectTypeId, "Латук дикий, компасний",
          nonParasiteNutritionTypeId, 7, winteringWeedGroupId));
      objects.put(53, new WeedObject(53, weedHarmfulObjectTypeId, "Злинка канадська",
          nonParasiteNutritionTypeId, 7, winteringWeedGroupId));
      objects.put(54,
          new WeedObject(54, weedHarmfulObjectTypeId, "Триреберник непахучий, ромашка непахуча",
              nonParasiteNutritionTypeId, 7, winteringWeedGroupId));
      objects.put(55, new WeedObject(55, weedHarmfulObjectTypeId, "Жовтозілля весняне",
          nonParasiteNutritionTypeId, 7, winteringWeedGroupId));
      objects.put(56,
          new WeedObject(56, weedHarmfulObjectTypeId, "Волошка синя", nonParasiteNutritionTypeId, 7,
              winteringWeedGroupId));
      objects.put(57, new WeedObject(57, weedHarmfulObjectTypeId, "Фіалка триколірна",
          nonParasiteNutritionTypeId, 4, winteringWeedGroupId));
      objects.put(58,
          new WeedObject(58, weedHarmfulObjectTypeId, "Фіалка польова", nonParasiteNutritionTypeId,
              4, winteringWeedGroupId));
      objects.put(59, new WeedObject(59, weedHarmfulObjectTypeId, "Чистець однорічний",
          nonParasiteNutritionTypeId, 2, winteringWeedGroupId));
      objects.put(60, new WeedObject(60, weedHarmfulObjectTypeId, "Глуха кропива стеблеобгортаюча",
          nonParasiteNutritionTypeId, 2, winteringWeedGroupId));
      objects.put(61,
          new WeedObject(61, weedHarmfulObjectTypeId, "Мак дикий", nonParasiteNutritionTypeId, 5,
              winteringWeedGroupId));
      objects.put(62, new WeedObject(62, weedHarmfulObjectTypeId, "Грабельки звичайні",
          nonParasiteNutritionTypeId, 6, winteringWeedGroupId));
      objects.put(63, new WeedObject(63, weedHarmfulObjectTypeId, "Кривоцвіт польовий",
          nonParasiteNutritionTypeId, 38, winteringWeedGroupId));
      objects.put(64,
          new WeedObject(64, weedHarmfulObjectTypeId, "Сокирки польові", nonParasiteNutritionTypeId,
              9, winteringWeedGroupId));
      objects.put(65, new WeedObject(65, weedHarmfulObjectTypeId, "Чорнокорінь лікарський",
          nonParasiteNutritionTypeId, 38, twoYearWeedGroupId));
      objects.put(66,
          new WeedObject(66, weedHarmfulObjectTypeId, "Липучка їжакова", nonParasiteNutritionTypeId,
              38, twoYearWeedGroupId));
      objects.put(67, new WeedObject(67, weedHarmfulObjectTypeId, "Татарник звичайний",
          nonParasiteNutritionTypeId, 7, twoYearWeedGroupId));
      objects.put(68, new WeedObject(68, weedHarmfulObjectTypeId, "Будяк акантовидний",
          nonParasiteNutritionTypeId, 7, twoYearWeedGroupId));
      objects.put(69, new WeedObject(69, weedHarmfulObjectTypeId, "Скереда покрівельна",
          nonParasiteNutritionTypeId, 7, twoYearWeedGroupId));
      objects.put(70, new WeedObject(70, weedHarmfulObjectTypeId, "Суріпиця звичайна",
          nonParasiteNutritionTypeId, 3, twoYearWeedGroupId));
      objects.put(71,
          new WeedObject(71, weedHarmfulObjectTypeId, "Свербига східна", nonParasiteNutritionTypeId,
              3, twoYearWeedGroupId));
      objects.put(72,
          new WeedObject(72, weedHarmfulObjectTypeId, "Гикавка сіра", nonParasiteNutritionTypeId, 3,
              twoYearWeedGroupId));
      objects.put(73, new WeedObject(73, weedHarmfulObjectTypeId, "Петрушка собача звичайна",
          nonParasiteNutritionTypeId, 14, twoYearWeedGroupId));
      objects.put(74,
          new WeedObject(74, weedHarmfulObjectTypeId, "Морква дика", nonParasiteNutritionTypeId, 14,
              twoYearWeedGroupId));
      objects.put(75, new WeedObject(75, weedHarmfulObjectTypeId, "Болиголов плямистий",
          nonParasiteNutritionTypeId, 14, twoYearWeedGroupId));
      objects.put(76,
          new WeedObject(76, weedHarmfulObjectTypeId, "Куколиця біла", nonParasiteNutritionTypeId,
              10, twoYearWeedGroupId));
      objects.put(77, new WeedObject(77, weedHarmfulObjectTypeId, "Кропива глуха пурпурова",
          nonParasiteNutritionTypeId, 2, twoYearWeedGroupId));
      objects.put(78, new WeedObject(78, weedHarmfulObjectTypeId, "Енотера дворічна",
          nonParasiteNutritionTypeId, 31, twoYearWeedGroupId));
      objects.put(79, new WeedObject(79, weedHarmfulObjectTypeId, "Вероніка плющолиста",
          nonParasiteNutritionTypeId, 33, twoYearWeedGroupId));
      objects.put(80,
          new WeedObject(80, weedHarmfulObjectTypeId, "Блекота чорна", nonParasiteNutritionTypeId,
              21, twoYearWeedGroupId));
      objects.put(81,
          new WeedObject(81, weedHarmfulObjectTypeId, "Синяк звичайний", nonParasiteNutritionTypeId,
              38, twoYearWeedGroupId));
      objects.put(82, new WeedObject(82, weedHarmfulObjectTypeId, "Буркун лікарський",
          nonParasiteNutritionTypeId, 13, twoYearWeedGroupId));
      objects.put(83, new WeedObject(83, weedHarmfulObjectTypeId, "Тонконіг однорічний",
          nonParasiteNutritionTypeId, cerealWeedClassId, ephemeralWeedGroupId));
      objects.put(84, new WeedObject(84, weedHarmfulObjectTypeId, "Тонконіг однорічний",
          nonParasiteNutritionTypeId, cerealWeedClassId, earlyWeedGroupId));
      objects.put(85, new WeedObject(85, weedHarmfulObjectTypeId, "Пажитниця льонова",
          nonParasiteNutritionTypeId, cerealWeedClassId, earlyWeedGroupId));
      objects.put(86, new WeedObject(86, weedHarmfulObjectTypeId, "Вівсюг звичайний",
          nonParasiteNutritionTypeId, cerealWeedClassId, earlyWeedGroupId));
      objects.put(87, new WeedObject(87, weedHarmfulObjectTypeId, "Просо волосовидне",
          nonParasiteNutritionTypeId, cerealWeedClassId, lateWeedGroupId));
      objects.put(88, new WeedObject(88, weedHarmfulObjectTypeId, "Пальчатка кровоспиняюча",
          nonParasiteNutritionTypeId, cerealWeedClassId, lateWeedGroupId));
      objects.put(89, new WeedObject(89, weedHarmfulObjectTypeId, "Ценхрус якірцевий",
          nonParasiteNutritionTypeId, cerealWeedClassId, lateWeedGroupId));
      objects.put(90, new WeedObject(90, weedHarmfulObjectTypeId, "Плоскуха звичайна",
          nonParasiteNutritionTypeId, cerealWeedClassId, lateWeedGroupId));
      objects.put(91,
          new WeedObject(91, weedHarmfulObjectTypeId, "Мишій зелений", nonParasiteNutritionTypeId,
              cerealWeedClassId, lateWeedGroupId));
      objects.put(92,
          new WeedObject(92, weedHarmfulObjectTypeId, "Мишій сизий", nonParasiteNutritionTypeId,
              cerealWeedClassId, lateWeedGroupId));
      objects.put(93, new WeedObject(93, weedHarmfulObjectTypeId, "Метлюг звичайний",
          nonParasiteNutritionTypeId, cerealWeedClassId, winterWeedGroupId));
      objects.put(94, new WeedObject(94, weedHarmfulObjectTypeId, "Бромус житній, або стоколос",
          nonParasiteNutritionTypeId, cerealWeedClassId, winterWeedGroupId));
      objects.put(95, new WeedObject(95, weedHarmfulObjectTypeId, "Чистець болотний",
          nonParasiteNutritionTypeId, 2, rootWeedGroupId));
      objects.put(96, new WeedObject(96, weedHarmfulObjectTypeId, "Ластовень гострий",
          nonParasiteNutritionTypeId, 28, rootWeedGroupId));
      objects.put(97, new WeedObject(97, weedHarmfulObjectTypeId, "Кропива дводомна",
          nonParasiteNutritionTypeId, 23, rootWeedGroupId));
      objects.put(98, new WeedObject(98, weedHarmfulObjectTypeId, "Квасениця прямостояча",
          nonParasiteNutritionTypeId, 29, rootWeedGroupId));
      objects.put(99, new WeedObject(99, weedHarmfulObjectTypeId, "Деревій звичайний",
          nonParasiteNutritionTypeId, 7, rootWeedGroupId));
      objects.put(100, new WeedObject(100, weedHarmfulObjectTypeId, "Хрінниця крупковидна",
          nonParasiteNutritionTypeId, 3, rootSproutWeedGroupId));
      objects.put(101, new WeedObject(101, weedHarmfulObjectTypeId, "Хвилівник звичайний",
          nonParasiteNutritionTypeId, 30, rootSproutWeedGroupId));
      objects.put(102, new WeedObject(102, weedHarmfulObjectTypeId, "Хаменерій вузьколистий",
          nonParasiteNutritionTypeId, 31, rootSproutWeedGroupId));
      objects.put(103, new WeedObject(103, weedHarmfulObjectTypeId, "Молочай лозяний",
          nonParasiteNutritionTypeId, 32, rootSproutWeedGroupId));
      objects.put(104, new WeedObject(104, weedHarmfulObjectTypeId, "Льонок звичайний",
          nonParasiteNutritionTypeId, 33, rootSproutWeedGroupId));
      objects.put(105, new WeedObject(105, weedHarmfulObjectTypeId, "Щавель горобиний",
          nonParasiteNutritionTypeId, 17, rootSproutWeedGroupId));
      objects.put(106, new WeedObject(106, weedHarmfulObjectTypeId, "Осот рожевий польовий",
          nonParasiteNutritionTypeId, 7, rootSproutWeedGroupId));
      objects.put(107, new WeedObject(107, weedHarmfulObjectTypeId, "Осот жовтий польовий",
          nonParasiteNutritionTypeId, 7, rootSproutWeedGroupId));
      objects.put(108, new WeedObject(108, weedHarmfulObjectTypeId, "Гірчак степовий звичайний",
          nonParasiteNutritionTypeId, 7, rootSproutWeedGroupId));
      objects.put(109, new WeedObject(109, weedHarmfulObjectTypeId, "Березка польова",
          nonParasiteNutritionTypeId, 34, rootSproutWeedGroupId));
      objects.put(110, new WeedObject(110, weedHarmfulObjectTypeId, "Подорожник великий",
          nonParasiteNutritionTypeId, 35, rootFiberWeedGroupId));
      objects.put(111, new WeedObject(111, weedHarmfulObjectTypeId, "Щавель кінський",
          nonParasiteNutritionTypeId, 17, stemRootWeedGroupId));
      objects.put(112, new WeedObject(112, weedHarmfulObjectTypeId, "Чистотіл звичайний",
          nonParasiteNutritionTypeId, 5, stemRootWeedGroupId));
      objects.put(113, new WeedObject(113, weedHarmfulObjectTypeId, "Миколайчики польові",
          nonParasiteNutritionTypeId, 14, stemRootWeedGroupId));
      objects.put(114, new WeedObject(114, weedHarmfulObjectTypeId, "Гравілат міський",
          nonParasiteNutritionTypeId, 36, stemRootWeedGroupId));
      objects.put(115, new WeedObject(115, weedHarmfulObjectTypeId, "Подорожник ланцетолистий",
          nonParasiteNutritionTypeId, 35, stemRootWeedGroupId));
      objects.put(116,
          new WeedObject(116, weedHarmfulObjectTypeId, "Полин звичайний та полин гіркий",
              nonParasiteNutritionTypeId, 7, stemRootWeedGroupId));
      objects.put(117, new WeedObject(117, weedHarmfulObjectTypeId, "Хондрила ситниковидна",
          nonParasiteNutritionTypeId, 7, stemRootWeedGroupId));
      objects.put(118, new WeedObject(118, weedHarmfulObjectTypeId, "Кульбаба лікарська",
          nonParasiteNutritionTypeId, 7, stemRootWeedGroupId));
      objects.put(119, new WeedObject(119, weedHarmfulObjectTypeId, "Перстач гусячий",
          nonParasiteNutritionTypeId, 36, repentWeedGroupId));
      objects.put(120, new WeedObject(120, weedHarmfulObjectTypeId, "Жовтець повзучий",
          nonParasiteNutritionTypeId, 9, repentWeedGroupId));
      objects.put(121,
          new WeedObject(121, weedHarmfulObjectTypeId, "Чина бульбиста", nonParasiteNutritionTypeId,
              13, tuberousWeedGroupId));
      objects.put(122, new WeedObject(122, weedHarmfulObjectTypeId, "Цибуля Вальдштейна",
          nonParasiteNutritionTypeId, 37, onionWeedGroupId));
      objects.put(123, new WeedObject(123, weedHarmfulObjectTypeId, "Свинорий пальчастий",
          nonParasiteNutritionTypeId, cerealWeedClassId, rootWeedGroupId));
      objects.put(124, new WeedObject(124, weedHarmfulObjectTypeId, "Гумай, сорго алепське",
          nonParasiteNutritionTypeId, cerealWeedClassId, rootWeedGroupId));
      objects.put(125,
          new WeedObject(125, weedHarmfulObjectTypeId, "Пирій повзучий", nonParasiteNutritionTypeId,
              cerealWeedClassId, rootWeedGroupId));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putWeed(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      WeedEntity[] res = new WeedEntity[objects.size()];
      fillEntitiesArray(objects, res, new WeedObjectToWeedEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new WeedEntity[objects.size()],
          new WeedObjectToWeedEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, WeedEntity[].class);
    }

    public long[] getWeedIdsByGroupId(long weedGroupId) {
      long[] result = new long[objects.size()];

      int currentIndex = 0;
      for (int i = 0; i < objects.size(); i++) {
        if (objects.valueAt(i).getGroupId() == weedGroupId) {
          result[currentIndex] = objects.valueAt(i).getId();
          currentIndex++;
        }
      }

      if (currentIndex + 1 < objects.size()) {
        result = Arrays.copyOf(result, currentIndex + 1);
      }

      return result;
    }
  }

  private class PhaseFiller extends BaseFiller {

    private static final int CAPACITY = 19;

    private SparseArrayCompat<PhaseObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return PhaseEntity[].class.getName();
    }

    @Override void makeObjects() {
      CropObject cornCropObject = mCropFiller.objects.get(CropFiller.CORN_KEY);

      objects.put(1, new PhaseObject(1, "Фізично стиглий ґрунт", cornCropObject));
      objects.put(2, new PhaseObject(2, "До посіву", cornCropObject));
      objects.put(3, new PhaseObject(3, "Суха зернівка", cornCropObject));
      objects.put(4, new PhaseObject(4, "Протруєне насіння", cornCropObject));
      objects.put(5,
          new PhaseObject(5, "Після посіву - початок набубнявіння насіння", cornCropObject));
      objects.put(6, new PhaseObject(6, "Після сівби до появи сходів кукурудзи", cornCropObject));
      objects.put(7, new PhaseObject(7, "До появи сходів кукурудзи", cornCropObject));
      objects.put(8, new PhaseObject(8, "У фазі 2-3-х листків", cornCropObject));
      objects.put(9, new PhaseObject(9, "У фазу 4-5-х листків", cornCropObject));
      objects.put(10, new PhaseObject(10, "3-5 листків у кукурудзи", cornCropObject));
      objects.put(11, new PhaseObject(11, "4-6 листків у кукурудзи", cornCropObject));
      objects.put(12, new PhaseObject(12, "Від 5 до 7 листка", cornCropObject));
      objects.put(13, new PhaseObject(13, "4-8 до 10 листків", cornCropObject));
      objects.put(14, new PhaseObject(14, "Висота рослин 30-40см", cornCropObject));
      objects.put(15, new PhaseObject(15, "Початок викидання волоті", cornCropObject));
      objects.put(16,
          new PhaseObject(16, "Кінець викидання волоті - початок цвітіння", cornCropObject));
      objects.put(17, new PhaseObject(17, "Слідом за збиранням попередника ", cornCropObject));
      objects.put(18, new PhaseObject(18,
          "У фазі розетки у багаторічних дводольних та за висоти 10-20 см у багаторічних злакових",
          cornCropObject));
      objects.put(19, new PhaseObject(19, "Повна стиглість", cornCropObject));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putPhase(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      PhaseEntity[] res = new PhaseEntity[objects.size()];
      fillEntitiesArray(objects, res, new PhaseObjectToPhaseEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new PhaseEntity[objects.size()],
          new PhaseObjectToPhaseEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, PhaseEntity[].class);
    }
  }

  private class ClimateZoneFiller extends BaseFiller {

    private static final int ANY_KEY = 1;
    private static final int STEPPE_KEY = 2;
    private static final int FOREST_STEPPE_KEY = 3;
    private static final int WOODLAND_KEY = 4;
    private static final int CARPATHIAN_MOUNTAINS_KEY = 5;

    private static final int CAPACITY = 4;

    private SparseArrayCompat<ClimateZoneObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return ClimateZoneEntity[].class.getName();
    }

    @Override void makeObjects() {
      // TODO: add coordinates
      objects.put(ANY_KEY, new ClimateZoneObject(1, "Будь-яка", new ArrayList<>()));
      objects.put(STEPPE_KEY, new ClimateZoneObject(2, "Степ", new ArrayList<>()));
      objects.put(FOREST_STEPPE_KEY, new ClimateZoneObject(3, "Лісо-степ", new ArrayList<>()));
      objects.put(WOODLAND_KEY, new ClimateZoneObject(4, "Полісся", new ArrayList<>()));
      objects.put(CARPATHIAN_MOUNTAINS_KEY,
          new ClimateZoneObject(5, "Карпатські та Кримські гори", new ArrayList<>()));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putClimateZone(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      ClimateZoneEntity[] res = new ClimateZoneEntity[objects.size()];
      fillEntitiesArray(objects, res, new ClimateZoneObjectToClimateZoneEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new ClimateZoneEntity[objects.size()],
          new ClimateZoneObjectToClimateZoneEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, ClimateZoneEntity[].class);
    }
  }

  private class HarmfulObjectFiller extends BaseFiller {

    private static final int CAPACITY = WeedFiller.CAPACITY + PestFiller.CAPACITY/*TODO: + DiseaseFiller.CAPACITY*/;

    private SparseArrayCompat<HarmfulObjectObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return HarmfulObjectEntity[].class.getName();
    }

    @Override void makeObjects() {
      long weedHarmfulObjectTypeId =
          mHarmfulObjectTypeFiller.objects.get(HarmfulObjectTypeFiller.WEED_KEY).getId();
      long diseaseHarmfulObjectTypeId =
          mHarmfulObjectTypeFiller.objects.get(HarmfulObjectTypeFiller.DISEASE_KEY).getId();
      long pestHarmfulObjectTypeId =
          mHarmfulObjectTypeFiller.objects.get(HarmfulObjectTypeFiller.PEST_KEY).getId();

      int currentId = 1;

      // Weeds
      for (int i = 0; i < mWeedFiller.objects.size(); i++) {
        objects.put(currentId, new HarmfulObjectObject(currentId, weedHarmfulObjectTypeId,
            mWeedFiller.objects.valueAt(i).getId()));
        currentId++;
      }
      // TODO:
      /*// Diseases
      for (int i = 0; i < mDiseaseFiller.objects.size(); i++) {
        objects.put(currentId, new HarmfulObjectObject(currentId, diseaseHarmfulObjectTypeId,
            mDiseaseFiller.objects.valueAt(i).getId()));
        currentId++;
      }*/
      // Pests
      for (int i = 0; i < mPestFiller.objects.size(); i++) {
        objects.put(currentId, new HarmfulObjectObject(currentId, pestHarmfulObjectTypeId,
            mPestFiller.objects.valueAt(i).getId()));
        currentId++;
      }
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putHarmfulObject(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      HarmfulObjectEntity[] res = new HarmfulObjectEntity[objects.size()];
      fillEntitiesArray(objects, res, new HarmfulObjectObjectToHarmfulObjectEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new HarmfulObjectEntity[objects.size()],
          new HarmfulObjectObjectToHarmfulObjectEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, HarmfulObjectEntity[].class);
    }

    public ArrayList<HarmfulObjectObject> getWeedsByGroupId(long weedGroupId) {
      ArrayList<HarmfulObjectObject> result = new ArrayList();

      long weedHarmfulObjectTypeId =
          mHarmfulObjectTypeFiller.objects.get(HarmfulObjectTypeFiller.WEED_KEY).getId();

      long[] weedIds = mWeedFiller.getWeedIdsByGroupId(weedGroupId);

      for (int i = 0; i < objects.size(); i++) {
        if (objects.valueAt(i).getTypeId() == weedHarmfulObjectTypeId) {
          if (Arrays.binarySearch(weedIds, objects.valueAt(i).getValueId()) >= 0) {
            result.add(objects.valueAt(i));
          }
        }
      }

      return result;
    }

    public ArrayList<HarmfulObjectObject> getPestsByIds(long[] pestIds) {
      ArrayList<HarmfulObjectObject> result = new ArrayList();

      long pestHarmfulObjectTypeId =
          mHarmfulObjectTypeFiller.objects.get(HarmfulObjectTypeFiller.PEST_KEY).getId();

      for (int i = 0; i < objects.size(); i++) {
        if (objects.valueAt(i).getTypeId() == pestHarmfulObjectTypeId) {
          if (Arrays.binarySearch(pestIds, objects.valueAt(i).getValueId()) >= 0) {
            result.add(objects.valueAt(i));
          }
        }
      }

      return result;
    }

    public HarmfulObjectObject[] getWeedsByGroupAndClassIds(long[] weedGroupIds,
        long[] weedClassIds) {

      LongSparseArray<HarmfulObjectObject> harmfulObjects = new LongSparseArray<>();

      LongSparseArray<WeedObject> weeds = new LongSparseArray<>();

      for (int i = 0; i < mWeedFiller.objects.size(); i++) {
        if ((Arrays.binarySearch(weedGroupIds, mWeedFiller.objects.valueAt(i).getGroupId()) >= 0)
            && (Arrays.binarySearch(weedClassIds, mWeedFiller.objects.valueAt(i).getClassId())
            >= 0)) {
          weeds.put(mWeedFiller.objects.valueAt(i).getId(), mWeedFiller.objects.valueAt(i));
        }
      }

      long weedHarmfulObjectTypeId =
          mHarmfulObjectTypeFiller.objects.get(HarmfulObjectTypeFiller.WEED_KEY).getId();

      for (int i = 0; i < objects.size(); i++) {
        if ((objects.valueAt(i).getTypeId() == weedHarmfulObjectTypeId) && (weeds.indexOfKey(
            objects.valueAt(i).getValueId()) >= 0)) {
          harmfulObjects.put(objects.valueAt(i).getId(), objects.valueAt(i));
        }
      }

      if (harmfulObjects.size() == 0) {
        return new HarmfulObjectObject[0];
      }

      HarmfulObjectObject[] res = new HarmfulObjectObject[harmfulObjects.size()];
      for (int i = 0; i < harmfulObjects.size(); i++) {
        res[i] = harmfulObjects.valueAt(i); // this is slow and stupid, but IDGF
      }
      return res;
    }
  }

  private class HarmfulObjectPhaseFiller extends BaseFiller {

    private static final int CAPACITY = 16;

    private SparseArrayCompat<HarmfulObjectPhaseObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return HarmfulObjectPhaseEntity[].class.getName();
    }

    @Override void makeObjects() {
      objects.put(1, new HarmfulObjectPhaseObject(1, "Набубнявіння насіння"));
      objects.put(2, new HarmfulObjectPhaseObject(2, "Проростання насіння - сходи"));
      objects.put(3, new HarmfulObjectPhaseObject(3, "Біла ниточка"));
      objects.put(4, new HarmfulObjectPhaseObject(4, "Біла ниточка - сходи"));
      objects.put(5, new HarmfulObjectPhaseObject(5, "Сходи - 1-2 листка"));
      objects.put(6, new HarmfulObjectPhaseObject(6, "Сходи - 1-3 листка"));
      objects.put(7, new HarmfulObjectPhaseObject(7, "1-3 листка"));
      objects.put(8, new HarmfulObjectPhaseObject(8, "Висота 10-15 см"));
      objects.put(9, new HarmfulObjectPhaseObject(9, "Висота 10-20 см"));
      objects.put(10, new HarmfulObjectPhaseObject(10, "Розетка"));
      objects.put(11, new HarmfulObjectPhaseObject(11, "Личинка"));
      objects.put(12, new HarmfulObjectPhaseObject(12, "Імаго"));
      objects.put(13, new HarmfulObjectPhaseObject(13, "Імаго - початок відкладання яєць"));
      objects.put(14, new HarmfulObjectPhaseObject(14, "Імаго - масове відкладання яєць"));
      objects.put(15, new HarmfulObjectPhaseObject(15, "Гусениці - личинки 1-3 віку"));
      objects.put(16, new HarmfulObjectPhaseObject(16, "Спори грибів"));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putHarmfulObjectPhase(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      HarmfulObjectPhaseEntity[] res = new HarmfulObjectPhaseEntity[objects.size()];
      fillEntitiesArray(objects, res,
          new HarmfulObjectPhaseObjectToHarmfulObjectPhaseEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new HarmfulObjectPhaseEntity[objects.size()],
          new HarmfulObjectPhaseObjectToHarmfulObjectPhaseEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, HarmfulObjectPhaseEntity[].class);
    }
  }

  private class ProcessPeriodFiller extends BaseFiller {

    private static final int CAPACITY = 32;

    private SparseArrayCompat<ProcessPeriodObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return ProcessPeriodEntity[].class.getName();
    }

    @Override void makeObjects() {
      objects.put(1, new ProcessPeriodObject(1, 10, 20, 3, 3)); // 1
      objects.put(2, new ProcessPeriodObject(2, 23, 5, 3, 4)); // 2
      objects.put(3, new ProcessPeriodObject(3, 13, 15, 4, 4)); // 3
      objects.put(4, new ProcessPeriodObject(4, 18, 20, 4, 4));
      objects.put(5, new ProcessPeriodObject(5, 23, 25, 4, 4));
      objects.put(6, new ProcessPeriodObject(6, 15, 15, 4, 5)); // 4
      objects.put(7, new ProcessPeriodObject(7, 20, 15, 4, 5));
      objects.put(8, new ProcessPeriodObject(8, 25, 15, 4, 5));
      objects.put(9, new ProcessPeriodObject(9, 21, 21, 4, 5)); // 5a
      objects.put(10, new ProcessPeriodObject(10, 26, 21, 4, 5));
      objects.put(11, new ProcessPeriodObject(11, 1, 21, 5, 5));
      objects.put(12, new ProcessPeriodObject(12, 30, 15, 4, 6)); // 5a2
      objects.put(13, new ProcessPeriodObject(13, 5, 15, 5, 6));
      objects.put(14, new ProcessPeriodObject(14, 10, 15, 5, 6));
      objects.put(15, new ProcessPeriodObject(15, 10, 27, 5, 6));
      objects.put(16, new ProcessPeriodObject(16, 15, 27, 5, 6));
      objects.put(17, new ProcessPeriodObject(17, 20, 27, 5, 6));
      objects.put(18, new ProcessPeriodObject(18, 15, 15, 5, 6)); // 5б, 6
      objects.put(19, new ProcessPeriodObject(19, 20, 15, 5, 6));
      objects.put(20, new ProcessPeriodObject(20, 25, 15, 5, 6));
      objects.put(21, new ProcessPeriodObject(21, 1, 20, 6, 6)); // 7
      objects.put(22, new ProcessPeriodObject(22, 5, 25, 6, 6)); // 8
      objects.put(23, new ProcessPeriodObject(23, 10, 20, 6, 8)); // 9а
      objects.put(24, new ProcessPeriodObject(24, 25, 20, 6, 8));
      objects.put(25, new ProcessPeriodObject(25, 30, 20, 6, 8));
      objects.put(26, new ProcessPeriodObject(26, 20, 4, 6, 9)); // 9а2
      objects.put(27, new ProcessPeriodObject(27, 5, 4, 7, 9));
      objects.put(28, new ProcessPeriodObject(28, 10, 4, 7, 9));
      objects.put(29, new ProcessPeriodObject(29, 30, 30, 6, 9)); // 9b
      objects.put(30, new ProcessPeriodObject(30, 5, 30, 7, 9));
      objects.put(31, new ProcessPeriodObject(31, 10, 30, 7, 9));
      objects.put(32, new ProcessPeriodObject(32, 15, 15, 8, 10)); // 12
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putProcessPeriod(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      ProcessPeriodEntity[] res = new ProcessPeriodEntity[objects.size()];
      fillEntitiesArray(objects, res, new ProcessPeriodObjectToProcessPeriodEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new ProcessPeriodEntity[objects.size()],
          new ProcessPeriodObjectToProcessPeriodEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, ProcessPeriodEntity[].class);
    }
  }

  private class TechnologicalSolutionTypeFiller extends BaseFiller {

    static final int AGGREGATES_KEY = 1;
    static final int PRODUCTS_KEY = 2;
    static final int ACTIVE_COMPONENTS_KEY = 3;
    static final int INSECTS_KEY = 4;
    static final int OTHER_KEY = 5;

    private static final int CAPACITY = 5;

    private SparseArrayCompat<TechnologicalSolutionTypeObject> objects =
        new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return TechnologicalSolutionTypeEntity[].class.getName();
    }

    @Override void makeObjects() {
      objects.put(AGGREGATES_KEY, new TechnologicalSolutionTypeObject(1, "Агрегаты"));
      objects.put(PRODUCTS_KEY, new TechnologicalSolutionTypeObject(2, "Препараты"));
      objects.put(ACTIVE_COMPONENTS_KEY,
          new TechnologicalSolutionTypeObject(3, "Действующие вещества"));
      objects.put(INSECTS_KEY, new TechnologicalSolutionTypeObject(4, "Насекомые"));
      objects.put(OTHER_KEY, new TechnologicalSolutionTypeObject(5, "Другие решения"));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putTechnologicalSolutionType(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      TechnologicalSolutionTypeEntity[] res = new TechnologicalSolutionTypeEntity[objects.size()];
      fillEntitiesArray(objects, res,
          new TechnologicalSolutionTypeObjectToTechnologicalSolutionTypeEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new TechnologicalSolutionTypeEntity[objects.size()],
          new TechnologicalSolutionTypeObjectToTechnologicalSolutionTypeEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, TechnologicalSolutionTypeEntity[].class);
    }
  }

  private class ProductCategoryFiller extends BaseFiller {

    static final int HERBICIDES_KEY = 1;
    static final int FUNGICIDES_KEY = 2;
    static final int DISINFECTANTS_KEY = 3;
    static final int INSECTICIDES_KEY = 4;

    private static final int CAPACITY = 4;

    private SparseArrayCompat<ProductCategoryObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return ProductCategoryEntity[].class.getName();
    }

    @Override void makeObjects() {
      objects.put(HERBICIDES_KEY, new ProductCategoryObject(1, "Гербіциди"));
      objects.put(FUNGICIDES_KEY, new ProductCategoryObject(2, "Фунгiциди"));
      objects.put(DISINFECTANTS_KEY, new ProductCategoryObject(3, "Протруйники"));
      objects.put(INSECTICIDES_KEY, new ProductCategoryObject(4, "Iнсектициди"));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putProductCategory(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      ProductCategoryEntity[] res = new ProductCategoryEntity[objects.size()];
      fillEntitiesArray(objects, res, new ProductCategoryObjectToProductCategoryEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new ProductCategoryEntity[objects.size()],
          new ProductCategoryObjectToProductCategoryEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, ProductCategoryEntity[].class);
    }
  }

  private class ProductFiller extends BaseFiller {

    private static final int AGROSCHIT_KEY = 1;
    private static final int EXTRACORN_KEY = 2;
    private static final int KIANIT_KEY = 3;
    private static final int LAVINA_KEY = 4;
    private static final int RATNIK_KEY = 5;
    private static final int RIPIUS_KEY = 6;
    private static final int SATURN_KEY = 7;
    private static final int SKAT_KEY = 8;
    private static final int SOTEYRA_KEY = 9;
    private static final int AZIMUT_KEY = 10;
    private static final int ALIOT_KEY = 11;
    private static final int KARBENAZOL_KEY = 12;
    private static final int VERSHINA_KEY = 13;
    private static final int COYOT_KEY = 14;
    private static final int TAYMEN_KEY = 15;
    private static final int VELES_KEY = 16;
    private static final int VYRIY_KEY = 17;

    private static final int CAPACITY = 17;

    private SparseArrayCompat<ProductObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return ProductEntity[].class.getName();
    }

    @Override void makeObjects() {
      TechnologicalSolutionTypeObject techSolutionTypeProducts =
          mTechnologicalSolutionTypeFiller.objects.get(
              TechnologicalSolutionTypeFiller.PRODUCTS_KEY);

      ProductCategoryObject herbicideProductCategory =
          mProductCategoryFiller.objects.get(ProductCategoryFiller.HERBICIDES_KEY);
      ProductCategoryObject fungicideProductCategory =
          mProductCategoryFiller.objects.get(ProductCategoryFiller.FUNGICIDES_KEY);
      ProductCategoryObject disinfectantProductCategory =
          mProductCategoryFiller.objects.get(ProductCategoryFiller.DISINFECTANTS_KEY);
      ProductCategoryObject insecticideProductCategory =
          mProductCategoryFiller.objects.get(ProductCategoryFiller.INSECTICIDES_KEY);

      objects.put(AGROSCHIT_KEY, new ProductObject(1, "Агрощит Супер", techSolutionTypeProducts, 0,
          herbicideProductCategory));
      objects.put(EXTRACORN_KEY, new ProductObject(2, "Екстракорн", techSolutionTypeProducts, 0,
          herbicideProductCategory));
      objects.put(KIANIT_KEY,
          new ProductObject(3, "Кіаніт", techSolutionTypeProducts, 0, herbicideProductCategory));
      objects.put(LAVINA_KEY,
          new ProductObject(4, "Лавина", techSolutionTypeProducts, 0, herbicideProductCategory));
      objects.put(RATNIK_KEY,
          new ProductObject(5, "Ратник", techSolutionTypeProducts, 0, herbicideProductCategory));
      objects.put(RIPIUS_KEY,
          new ProductObject(6, "Ріпіус", techSolutionTypeProducts, 0, herbicideProductCategory));
      objects.put(SATURN_KEY,
          new ProductObject(7, "Сатурн", techSolutionTypeProducts, 0, herbicideProductCategory));
      objects.put(SKAT_KEY,
          new ProductObject(8, "Скат", techSolutionTypeProducts, 0, herbicideProductCategory));
      objects.put(SOTEYRA_KEY,
          new ProductObject(9, "Сотейра", techSolutionTypeProducts, 0, herbicideProductCategory));
      objects.put(AZIMUT_KEY,
          new ProductObject(10, "Азимут", techSolutionTypeProducts, 0, fungicideProductCategory));
      objects.put(ALIOT_KEY,
          new ProductObject(11, "Аліот", techSolutionTypeProducts, 0, fungicideProductCategory));
      objects.put(KARBENAZOL_KEY, new ProductObject(12, "Карбеназол", techSolutionTypeProducts, 0,
          fungicideProductCategory));
      objects.put(VERSHINA_KEY, new ProductObject(13, "Вершина", techSolutionTypeProducts, 0,
          disinfectantProductCategory));
      objects.put(COYOT_KEY,
          new ProductObject(14, "Койот", techSolutionTypeProducts, 0, disinfectantProductCategory));
      objects.put(TAYMEN_KEY, new ProductObject(15, "Таймень", techSolutionTypeProducts, 0,
          disinfectantProductCategory));
      objects.put(VELES_KEY,
          new ProductObject(16, "Велес", techSolutionTypeProducts, 0, insecticideProductCategory));
      objects.put(VYRIY_KEY,
          new ProductObject(17, "Вирій", techSolutionTypeProducts, 0, insecticideProductCategory));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putProduct(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      ProductEntity[] res = new ProductEntity[objects.size()];
      fillEntitiesArray(objects, res, new ProductObjectToProductEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new ProductEntity[objects.size()],
          new ProductObjectToProductEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, ProductEntity[].class);
    }
  }

  private class ActiveComponentFiller extends BaseFiller {

    private static final int GLIFOSAD_KALIY_SOL_KEY = 1;
    private static final int PROPIKONAZOL_KEY = 2;
    private static final int CYPROKONAZOL_KEY = 3;
    private static final int S_METOLACHLOR_KEY = 4;
    private static final int TERBUTILAZIN_KEY = 5;
    private static final int DESMEDIFAM_KEY = 6;
    private static final int FENMEDIFAM_KEY = 7;
    private static final int ETOFUMEZAT_KEY = 8;
    private static final int METAMITRON_KEY = 9;
    private static final int FLORASULAM_KEY = 10;
    private static final int METAZACHLOR_KEY = 11;
    private static final int NIKOSULPHURON_KEY = 12;
    private static final int HIZALOFOP_KEY = 13;
    private static final int IMAZAMOKS_KEY = 14;
    private static final int IMAZAPIR_KEY = 15;
    private static final int TEBUKONAZOL_KEY = 16;
    private static final int TRIADIMEFON_KEY = 17;
    private static final int KARBENDAZIM_KEY = 18;
    private static final int AZOKSISTROBIN_KEY = 19;
    private static final int IMIDAKLOPRID_KEY = 20;
    private static final int PROCHLORAZ_KEY = 21;
    private static final int TRITIKONAZOL_KEY = 22;
    private static final int TIKLOPRID_KEY = 23;
    private static final int DELTAMETRIN_KEY = 24;
    private static final int DIFENOKONAZOL_KEY = 25;
    private static final int EPOKSIKONAZOL_KEY = 26;
    private static final int DIFLUFENIKAN_KEY = 27;

    private static final int CAPACITY = 55;

    private SparseArrayCompat<ActiveComponentObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return ActiveComponentEntity[].class.getName();
    }

    @Override void makeObjects() {
      TechnologicalSolutionTypeObject activeComponentTechnologicalSolutionType =
          mTechnologicalSolutionTypeFiller.objects.get(
              TechnologicalSolutionTypeFiller.ACTIVE_COMPONENTS_KEY);

      objects.put(GLIFOSAD_KALIY_SOL_KEY, new ActiveComponentObject(1, "Гліфосату калійна сіль",
          activeComponentTechnologicalSolutionType));
      objects.put(PROPIKONAZOL_KEY,
          new ActiveComponentObject(2, "Пропіконазол", activeComponentTechnologicalSolutionType));
      objects.put(CYPROKONAZOL_KEY,
          new ActiveComponentObject(3, "Ципроконазол", activeComponentTechnologicalSolutionType));
      objects.put(S_METOLACHLOR_KEY,
          new ActiveComponentObject(4, "S-метолахлор", activeComponentTechnologicalSolutionType));
      objects.put(TERBUTILAZIN_KEY,
          new ActiveComponentObject(5, "Тербутилазин", activeComponentTechnologicalSolutionType));
      objects.put(DESMEDIFAM_KEY,
          new ActiveComponentObject(6, "Десмедифам", activeComponentTechnologicalSolutionType));
      objects.put(FENMEDIFAM_KEY,
          new ActiveComponentObject(7, "Фенмедифам", activeComponentTechnologicalSolutionType));
      objects.put(ETOFUMEZAT_KEY,
          new ActiveComponentObject(8, "Етофумезат", activeComponentTechnologicalSolutionType));
      objects.put(METAMITRON_KEY,
          new ActiveComponentObject(9, "Метамітрон", activeComponentTechnologicalSolutionType));
      objects.put(FLORASULAM_KEY,
          new ActiveComponentObject(10, "Флорасулам", activeComponentTechnologicalSolutionType));
      objects.put(METAZACHLOR_KEY,
          new ActiveComponentObject(11, "Метазахлор", activeComponentTechnologicalSolutionType));
      objects.put(NIKOSULPHURON_KEY,
          new ActiveComponentObject(12, "Нікосульфурон", activeComponentTechnologicalSolutionType));
      objects.put(HIZALOFOP_KEY, new ActiveComponentObject(13, "Хізалофоп-П-тефурил",
          activeComponentTechnologicalSolutionType));
      objects.put(IMAZAMOKS_KEY,
          new ActiveComponentObject(14, "Імазамокс", activeComponentTechnologicalSolutionType));
      objects.put(IMAZAPIR_KEY,
          new ActiveComponentObject(15, "Імазапір", activeComponentTechnologicalSolutionType));
      objects.put(TEBUKONAZOL_KEY,
          new ActiveComponentObject(16, "Тебуконазол", activeComponentTechnologicalSolutionType));
      objects.put(TRIADIMEFON_KEY,
          new ActiveComponentObject(17, "Триадимефон", activeComponentTechnologicalSolutionType));
      objects.put(KARBENDAZIM_KEY,
          new ActiveComponentObject(18, "Карбендазим", activeComponentTechnologicalSolutionType));
      objects.put(AZOKSISTROBIN_KEY,
          new ActiveComponentObject(19, "Азоксистробін", activeComponentTechnologicalSolutionType));
      objects.put(IMIDAKLOPRID_KEY,
          new ActiveComponentObject(20, "Імідаклоприд", activeComponentTechnologicalSolutionType));
      objects.put(PROCHLORAZ_KEY,
          new ActiveComponentObject(21, "Прохлораз", activeComponentTechnologicalSolutionType));
      objects.put(TRITIKONAZOL_KEY,
          new ActiveComponentObject(22, "Тритіконазол", activeComponentTechnologicalSolutionType));
      objects.put(TIKLOPRID_KEY,
          new ActiveComponentObject(23, "Тіклоприд", activeComponentTechnologicalSolutionType));
      objects.put(DELTAMETRIN_KEY,
          new ActiveComponentObject(24, "Дельтаметрин", activeComponentTechnologicalSolutionType));
      objects.put(DIFENOKONAZOL_KEY,
          new ActiveComponentObject(25, "Дифеноконазол", activeComponentTechnologicalSolutionType));
      objects.put(EPOKSIKONAZOL_KEY,
          new ActiveComponentObject(26, "Епоксіконазол", activeComponentTechnologicalSolutionType));
      objects.put(DIFLUFENIKAN_KEY,
          new ActiveComponentObject(27, "Дифлюфеникан", activeComponentTechnologicalSolutionType));
      objects.put(28, new ActiveComponentObject(28, "Піраклостробін",
          activeComponentTechnologicalSolutionType));
      objects.put(29,
          new ActiveComponentObject(29, "Тіаметоксам", activeComponentTechnologicalSolutionType));
      objects.put(30,
          new ActiveComponentObject(30, "Фіпроніл", activeComponentTechnologicalSolutionType));
      objects.put(31,
          new ActiveComponentObject(31, "Клотіанідин", activeComponentTechnologicalSolutionType));
      objects.put(32,
          new ActiveComponentObject(32, "Карбамід", activeComponentTechnologicalSolutionType));
      objects.put(33,
          new ActiveComponentObject(33, "Ацетохлор", activeComponentTechnologicalSolutionType));
      objects.put(34,
          new ActiveComponentObject(34, "Прометрин", activeComponentTechnologicalSolutionType));
      objects.put(35,
          new ActiveComponentObject(35, "Пендиметалін", activeComponentTechnologicalSolutionType));
      objects.put(36,
          new ActiveComponentObject(36, "Римсульфурон", activeComponentTechnologicalSolutionType));
      objects.put(37,
          new ActiveComponentObject(37, "Бентазон", activeComponentTechnologicalSolutionType));
      objects.put(38, new ActiveComponentObject(38, "Тифенсульфурон",
          activeComponentTechnologicalSolutionType));
      objects.put(39,
          new ActiveComponentObject(39, "Дикамба", activeComponentTechnologicalSolutionType));
      objects.put(40,
          new ActiveComponentObject(40, "Клопіралід", activeComponentTechnologicalSolutionType));
      objects.put(41, new ActiveComponentObject(41, "2-етилгексиловий ефір 2,4-Д",
          activeComponentTechnologicalSolutionType));
      objects.put(42,
          new ActiveComponentObject(42, "Тіаклоприд", activeComponentTechnologicalSolutionType));
      objects.put(43,
          new ActiveComponentObject(43, "Диметоат", activeComponentTechnologicalSolutionType));
      objects.put(44, new ActiveComponentObject(44, "Лямбда-цигалотрин",
          activeComponentTechnologicalSolutionType));
      objects.put(45,
          new ActiveComponentObject(45, "Хлорпірифос", activeComponentTechnologicalSolutionType));
      objects.put(46, new ActiveComponentObject(46, "Форамсульфурон",
          activeComponentTechnologicalSolutionType));
      objects.put(47, new ActiveComponentObject(47, "Йодсульфурон-метил",
          activeComponentTechnologicalSolutionType));
      objects.put(48, new ActiveComponentObject(48, "Антидот-ізоксадифенетил",
          activeComponentTechnologicalSolutionType));
      objects.put(49, new ActiveComponentObject(49, "Гідроксид амонію",
          activeComponentTechnologicalSolutionType));
      objects.put(50, new ActiveComponentObject(50, "Сульфат амонію",
          activeComponentTechnologicalSolutionType));
      objects.put(51, new ActiveComponentObject(51, "Нітрат кальцію",
          activeComponentTechnologicalSolutionType));
      objects.put(52,
          new ActiveComponentObject(52, "Нітрат натрію", activeComponentTechnologicalSolutionType));
      objects.put(53,
          new ActiveComponentObject(53, "Хлорид амонію", activeComponentTechnologicalSolutionType));
      objects.put(54, new ActiveComponentObject(54, "Аміачна селітра",
          activeComponentTechnologicalSolutionType));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putActiveComponent(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      ActiveComponentEntity[] res = new ActiveComponentEntity[objects.size()];
      fillEntitiesArray(objects, res, new ActiveComponentObjectToActiveComponentEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new ActiveComponentEntity[objects.size()],
          new ActiveComponentObjectToActiveComponentEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, ActiveComponentEntity[].class);
    }
  }

  private class ActiveComponentInProductFiller extends BaseFiller {

    private static final int CAPACITY = 27;

    private SparseArrayCompat<ActiveComponentInProductObject> objects =
        new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return ActiveComponentInProductEntity[].class.getName();
    }

    @Override void makeObjects() {
      // TODO: need to fill dozes
      objects.put(1, new ActiveComponentInProductObject(1,
          mProductFiller.objects.get(ProductFiller.AGROSCHIT_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.GLIFOSAD_KALIY_SOL_KEY).getId(),
          "0"));
      objects.put(2, new ActiveComponentInProductObject(2,
          mProductFiller.objects.get(ProductFiller.EXTRACORN_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.S_METOLACHLOR_KEY).getId(),
          "0"));
      objects.put(3, new ActiveComponentInProductObject(3,
          mProductFiller.objects.get(ProductFiller.EXTRACORN_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.TERBUTILAZIN_KEY).getId(), "0"));
      objects.put(4, new ActiveComponentInProductObject(4,
          mProductFiller.objects.get(ProductFiller.KIANIT_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.DESMEDIFAM_KEY).getId(), "0"));
      objects.put(5, new ActiveComponentInProductObject(5,
          mProductFiller.objects.get(ProductFiller.KIANIT_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.FENMEDIFAM_KEY).getId(), "0"));
      objects.put(6, new ActiveComponentInProductObject(6,
          mProductFiller.objects.get(ProductFiller.KIANIT_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.ETOFUMEZAT_KEY).getId(), "0"));
      objects.put(7, new ActiveComponentInProductObject(7,
          mProductFiller.objects.get(ProductFiller.LAVINA_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.METAMITRON_KEY).getId(), "0"));
      objects.put(8, new ActiveComponentInProductObject(8,
          mProductFiller.objects.get(ProductFiller.RATNIK_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.FLORASULAM_KEY).getId(), "0"));
      objects.put(9, new ActiveComponentInProductObject(9,
          mProductFiller.objects.get(ProductFiller.RIPIUS_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.METAZACHLOR_KEY).getId(), "0"));
      objects.put(10, new ActiveComponentInProductObject(10,
          mProductFiller.objects.get(ProductFiller.SATURN_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.NIKOSULPHURON_KEY).getId(),
          "0"));
      objects.put(11, new ActiveComponentInProductObject(11,
          mProductFiller.objects.get(ProductFiller.SKAT_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.HIZALOFOP_KEY).getId(), "0"));
      objects.put(12, new ActiveComponentInProductObject(12,
          mProductFiller.objects.get(ProductFiller.SOTEYRA_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.IMAZAMOKS_KEY).getId(), "0"));
      objects.put(13, new ActiveComponentInProductObject(13,
          mProductFiller.objects.get(ProductFiller.SOTEYRA_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.IMAZAPIR_KEY).getId(), "0"));
      objects.put(14, new ActiveComponentInProductObject(14,
          mProductFiller.objects.get(ProductFiller.AZIMUT_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.TEBUKONAZOL_KEY).getId(), "0"));
      objects.put(15, new ActiveComponentInProductObject(15,
          mProductFiller.objects.get(ProductFiller.AZIMUT_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.TRIADIMEFON_KEY).getId(), "0"));
      objects.put(16, new ActiveComponentInProductObject(16,
          mProductFiller.objects.get(ProductFiller.ALIOT_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.PROPIKONAZOL_KEY).getId(), "0"));
      objects.put(17, new ActiveComponentInProductObject(17,
          mProductFiller.objects.get(ProductFiller.ALIOT_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.CYPROKONAZOL_KEY).getId(), "0"));
      objects.put(18, new ActiveComponentInProductObject(18,
          mProductFiller.objects.get(ProductFiller.KARBENAZOL_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.CYPROKONAZOL_KEY).getId(), "0"));
      objects.put(19, new ActiveComponentInProductObject(19,
          mProductFiller.objects.get(ProductFiller.KARBENAZOL_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.KARBENDAZIM_KEY).getId(), "0"));
      objects.put(20, new ActiveComponentInProductObject(20,
          mProductFiller.objects.get(ProductFiller.VERSHINA_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.TEBUKONAZOL_KEY).getId(), "0"));
      objects.put(21, new ActiveComponentInProductObject(21,
          mProductFiller.objects.get(ProductFiller.VERSHINA_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.AZOKSISTROBIN_KEY).getId(),
          "0"));
      objects.put(22, new ActiveComponentInProductObject(22,
          mProductFiller.objects.get(ProductFiller.COYOT_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.IMIDAKLOPRID_KEY).getId(), "0"));
      objects.put(23, new ActiveComponentInProductObject(23,
          mProductFiller.objects.get(ProductFiller.TAYMEN_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.PROCHLORAZ_KEY).getId(), "0"));
      objects.put(24, new ActiveComponentInProductObject(24,
          mProductFiller.objects.get(ProductFiller.TAYMEN_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.TRITIKONAZOL_KEY).getId(), "0"));
      objects.put(25, new ActiveComponentInProductObject(25,
          mProductFiller.objects.get(ProductFiller.VELES_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.TIKLOPRID_KEY).getId(), "0"));
      objects.put(26, new ActiveComponentInProductObject(26,
          mProductFiller.objects.get(ProductFiller.VELES_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.DELTAMETRIN_KEY).getId(), "0"));
      objects.put(27, new ActiveComponentInProductObject(27,
          mProductFiller.objects.get(ProductFiller.VYRIY_KEY).getId(),
          mActiveComponentFiller.objects.get(ActiveComponentFiller.TIKLOPRID_KEY).getId(), "0"));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putActiveComponentInProduct(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      ActiveComponentInProductEntity[] res = new ActiveComponentInProductEntity[objects.size()];
      fillEntitiesArray(objects, res,
          new ActiveComponentInProductObjectToActiveComponentInProductEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new ActiveComponentInProductEntity[objects.size()],
          new ActiveComponentInProductObjectToActiveComponentInProductEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, ActiveComponentInProductEntity[].class);
    }
  }

  private class AggregateFiller extends BaseFiller {

    private static final int CAPACITY = 15;

    private SparseArrayCompat<AggregateObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return AggregateEntity[].class.getName();
    }

    @Override void makeObjects() {
      TechnologicalSolutionTypeObject aggregateTechSolutionType =
          mTechnologicalSolutionTypeFiller.objects.get(
              TechnologicalSolutionTypeFiller.AGGREGATES_KEY);

      objects.put(1, new AggregateObject(1, "Важка борона", aggregateTechSolutionType, 0));
      objects.put(2, new AggregateObject(2, "Волокуша-вирівнювач", aggregateTechSolutionType, 0));
      objects.put(3, new AggregateObject(3, "Культиватор", aggregateTechSolutionType, 0));
      objects.put(4, new AggregateObject(4, "Борона", aggregateTechSolutionType, 0));
      objects.put(5, new AggregateObject(5, "Сівалка", aggregateTechSolutionType, 0));
      objects.put(6,
          new AggregateObject(6, "Грунтообробний комбінований агрегат", aggregateTechSolutionType,
              0));
      objects.put(7, new AggregateObject(7, "Гладкорубчастий каток", aggregateTechSolutionType, 0));
      objects.put(8, new AggregateObject(8, "Легка борона", aggregateTechSolutionType, 0));
      objects.put(9, new AggregateObject(9, "Середня борона", aggregateTechSolutionType, 0));
      objects.put(10,
          new AggregateObject(10, "Стрільчаста лапа культиватора", aggregateTechSolutionType, 0));
      objects.put(11,
          new AggregateObject(11, "Лапа-бритва культиватора", aggregateTechSolutionType, 0));
      objects.put(12,
          new AggregateObject(12, "Лапа-підгортальник культиватора", aggregateTechSolutionType, 0));
      objects.put(13, new AggregateObject(13, "Дисковий лущильник", aggregateTechSolutionType, 0));
      objects.put(14, new AggregateObject(14, "Дискова борона", aggregateTechSolutionType, 0));
      objects.put(15, new AggregateObject(15, "Оприскувач навісний", aggregateTechSolutionType, 0));
      objects.put(16,
          new AggregateObject(16, "Оприскувач причіпний", aggregateTechSolutionType, 0));
      objects.put(17,
          new AggregateObject(17, "Кукурудзозбиральний комбайн", aggregateTechSolutionType, 0));
      objects.put(18,
          new AggregateObject(18, "Зернозбиральний комбайн", aggregateTechSolutionType, 0));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putAggregate(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      AggregateEntity[] res = new AggregateEntity[objects.size()];
      fillEntitiesArray(objects, res, new AggregateObjectToAggregateEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new AggregateEntity[objects.size()],
          new AggregateObjectToAggregateEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, AggregateEntity[].class);
    }
  }

  private class InsectFiller extends BaseFiller {

    private static final int CAPACITY = 1;

    private SparseArrayCompat<InsectObject> objects = new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return InsectEntity[].class.getName();
    }

    @Override void makeObjects() {
      TechnologicalSolutionTypeObject insectTechSolutionType =
          mTechnologicalSolutionTypeFiller.objects.get(TechnologicalSolutionTypeFiller.INSECTS_KEY);

      objects.put(1, new InsectObject(1, "Вогнівкова раса трихограми", insectTechSolutionType, 0));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putInsect(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      InsectEntity[] res = new InsectEntity[objects.size()];
      fillEntitiesArray(objects, res, new InsectObjectToInsectEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new InsectEntity[objects.size()],
          new InsectObjectToInsectEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, InsectEntity[].class);
    }
  }

  private class TechnologicalSolutionFiller extends BaseFiller {

    private static final int CAPACITY = AggregateFiller.CAPACITY
        + ProductFiller.CAPACITY
        + ActiveComponentFiller.CAPACITY
        + InsectFiller.CAPACITY;

    private SparseArrayCompat<TechnologicalSolutionObject> objects =
        new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return TechnologicalSolutionEntity[].class.getName();
    }

    @Override void makeObjects() {
      TechnologicalSolutionTypeObject aggregateTechnologicalSolutionType =
          mTechnologicalSolutionTypeFiller.objects.get(
              TechnologicalSolutionTypeFiller.AGGREGATES_KEY);
      TechnologicalSolutionTypeObject productTechnologicalSolutionType =
          mTechnologicalSolutionTypeFiller.objects.get(
              TechnologicalSolutionTypeFiller.PRODUCTS_KEY);
      TechnologicalSolutionTypeObject activeComponentTechnologicalSolutionType =
          mTechnologicalSolutionTypeFiller.objects.get(
              TechnologicalSolutionTypeFiller.ACTIVE_COMPONENTS_KEY);
      TechnologicalSolutionTypeObject insectTechnologicalSolutionType =
          mTechnologicalSolutionTypeFiller.objects.get(TechnologicalSolutionTypeFiller.INSECTS_KEY);

      int currentId = 1;

      // Aggregates
      for (int i = 0; i < mAggregateFiller.objects.size(); i++) {
        objects.put(currentId,
            new TechnologicalSolutionObject(currentId, aggregateTechnologicalSolutionType,
                mAggregateFiller.objects.valueAt(i)));
        currentId++;
      }
      // Products
      for (int i = 0; i < mProductFiller.objects.size(); i++) {
        objects.put(currentId,
            new TechnologicalSolutionObject(currentId, productTechnologicalSolutionType,
                mProductFiller.objects.valueAt(i)));
        currentId++;
      }
      // Active components
      for (int i = 0; i < mActiveComponentFiller.objects.size(); i++) {
        objects.put(currentId,
            new TechnologicalSolutionObject(currentId, activeComponentTechnologicalSolutionType,
                mActiveComponentFiller.objects.valueAt(i)));
        currentId++;
      }
      // Insects
      for (int i = 0; i < mInsectFiller.objects.size(); i++) {
        objects.put(currentId,
            new TechnologicalSolutionObject(currentId, insectTechnologicalSolutionType,
                mInsectFiller.objects.valueAt(i)));
        currentId++;
      }
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putTechnologicalSolution(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      TechnologicalSolutionEntity[] res = new TechnologicalSolutionEntity[objects.size()];
      fillEntitiesArray(objects, res,
          new TechnologicalSolutionObjectToTechnologicalSolutionEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new TechnologicalSolutionEntity[objects.size()],
          new TechnologicalSolutionObjectToTechnologicalSolutionEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, TechnologicalSolutionEntity[].class);
    }
  }

  private class TechnologicalProcessStateFiller extends BaseFiller {

    private static final int CAPACITY = 5;

    private SparseArrayCompat<TechnologicalProcessStateObject> objects =
        new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return TechnologicalProcessStateEntity[].class.getName();
    }

    @Override void makeObjects() {
      objects.put(1, new TechnologicalProcessStateObject(1, "В очереди", 0));
      objects.put(2, new TechnologicalProcessStateObject(2, "Актуален", 0));
      objects.put(3, new TechnologicalProcessStateObject(3, "Выполнен", 0));
      objects.put(4, new TechnologicalProcessStateObject(4, "Отменен", 0));
      objects.put(5, new TechnologicalProcessStateObject(5, "Пропущен", 0));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putTechnologicalProcessState(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      TechnologicalProcessStateEntity[] res = new TechnologicalProcessStateEntity[objects.size()];
      fillEntitiesArray(objects, res,
          new TechnologicalProcessStateObjectToTechnologicalProcessStateEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new TechnologicalProcessStateEntity[objects.size()],
          new TechnologicalProcessStateObjectToTechnologicalProcessStateEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, TechnologicalProcessStateEntity[].class);
    }
  }

  private class CropTechnologicalProcessFiller extends BaseFiller {

    private static final int CAPACITY = 21;

    private SparseArrayCompat<CropTechnologicalProcessObject> objects =
        new SparseArrayCompat<>(CAPACITY);

    @Override String getEntityKey() {
      return CropTechnologicalProcessEntity[].class.getName();
    }

    @Override void makeObjects() {
      CropObject cornCrop = mCropFiller.objects.get(CropFiller.CORN_KEY);

      ClimateZoneObject anyClimateZone = mClimateZoneFiller.objects.get(ClimateZoneFiller.ANY_KEY);
      ClimateZoneObject steppeClimateZone =
          mClimateZoneFiller.objects.get(ClimateZoneFiller.STEPPE_KEY);
      ClimateZoneObject forestSteppeClimateZone =
          mClimateZoneFiller.objects.get(ClimateZoneFiller.FOREST_STEPPE_KEY);
      ClimateZoneObject woodlandClimateZone =
          mClimateZoneFiller.objects.get(ClimateZoneFiller.WOODLAND_KEY);

      objects.put(1, new CropTechnologicalProcessObject(1, "Ранньовесняне боронування", 1, cornCrop,
          anyClimateZone, mPhaseFiller.objects.get(1), mProcessPeriodFiller.objects.get(1)));
      objects.put(2,
          new CropTechnologicalProcessObject(2, "Культивація з боронуванням", 2, cornCrop,
              anyClimateZone, mPhaseFiller.objects.get(2), mProcessPeriodFiller.objects.get(2)));
      objects.put(3, new CropTechnologicalProcessObject(3,
          "Протруювання насіння та обробка регуляторами росту, біологічно-активними речовинами", 3,
          cornCrop, steppeClimateZone, mPhaseFiller.objects.get(3),
          mProcessPeriodFiller.objects.get(3)));
      objects.put(4, new CropTechnologicalProcessObject(4,
          "Протруювання насіння та обробка регуляторами росту, біологічно-активними речовинами", 3,
          cornCrop, forestSteppeClimateZone, mPhaseFiller.objects.get(3),
          mProcessPeriodFiller.objects.get(4)));
      objects.put(5, new CropTechnologicalProcessObject(5,
          "Протруювання насіння та обробка регуляторами росту, біологічно-активними речовинами", 3,
          cornCrop, woodlandClimateZone, mPhaseFiller.objects.get(3),
          mProcessPeriodFiller.objects.get(5)));

      objects.put(6, new CropTechnologicalProcessObject(6,
          "Посів та припосівне внесення добрив. Передпосівний обробіток ґрунту з послідуючою сівбою",
          4, cornCrop, steppeClimateZone, mPhaseFiller.objects.get(4),
          mProcessPeriodFiller.objects.get(6)));
      objects.put(7, new CropTechnologicalProcessObject(7,
          "Посів та припосівне внесення добрив. Передпосівний обробіток ґрунту з послідуючою сівбою",
          4, cornCrop, forestSteppeClimateZone, mPhaseFiller.objects.get(4),
          mProcessPeriodFiller.objects.get(7)));
      objects.put(8, new CropTechnologicalProcessObject(8,
          "Посів та припосівне внесення добрив. Передпосівний обробіток ґрунту з послідуючою сівбою",
          4, cornCrop, woodlandClimateZone, mPhaseFiller.objects.get(4),
          mProcessPeriodFiller.objects.get(8)));

      objects.put(9,
          new CropTechnologicalProcessObject(9, "Коткування", 4, cornCrop, steppeClimateZone,
              mPhaseFiller.objects.get(5), mProcessPeriodFiller.objects.get(6)));
      objects.put(10,
          new CropTechnologicalProcessObject(10, "Коткування", 4, cornCrop, forestSteppeClimateZone,
              mPhaseFiller.objects.get(5), mProcessPeriodFiller.objects.get(7)));
      objects.put(11,
          new CropTechnologicalProcessObject(11, "Коткування", 4, cornCrop, woodlandClimateZone,
              mPhaseFiller.objects.get(5), mProcessPeriodFiller.objects.get(8)));
      objects.put(12,
          new CropTechnologicalProcessObject(12, "Внесення гербіциду ґрунтової дії", 4, cornCrop,
              steppeClimateZone, mPhaseFiller.objects.get(6), mProcessPeriodFiller.objects.get(6)));
      objects.put(13,
          new CropTechnologicalProcessObject(13, "Внесення гербіциду ґрунтової дії", 4, cornCrop,
              forestSteppeClimateZone, mPhaseFiller.objects.get(6),
              mProcessPeriodFiller.objects.get(7)));
      objects.put(14,
          new CropTechnologicalProcessObject(14, "Внесення гербіциду ґрунтової дії", 4, cornCrop,
              woodlandClimateZone, mPhaseFiller.objects.get(6),
              mProcessPeriodFiller.objects.get(8)));
      objects.put(15, new CropTechnologicalProcessObject(15, "Досходове боронування", 5, cornCrop,
          steppeClimateZone, mPhaseFiller.objects.get(7), mProcessPeriodFiller.objects.get(9)));
      objects.put(16, new CropTechnologicalProcessObject(16, "Досходове боронування", 5, cornCrop,
          forestSteppeClimateZone, mPhaseFiller.objects.get(7),
          mProcessPeriodFiller.objects.get(10)));
      objects.put(17, new CropTechnologicalProcessObject(17, "Досходове боронування", 5, cornCrop,
          woodlandClimateZone, mPhaseFiller.objects.get(7), mProcessPeriodFiller.objects.get(11)));
      objects.put(18,
          new CropTechnologicalProcessObject(18, "Післясходове боронування перше", 6, cornCrop,
              steppeClimateZone, mPhaseFiller.objects.get(8),
              mProcessPeriodFiller.objects.get(12)));
      objects.put(19,
          new CropTechnologicalProcessObject(19, "Післясходове боронування перше", 6, cornCrop,
              forestSteppeClimateZone, mPhaseFiller.objects.get(8),
              mProcessPeriodFiller.objects.get(13)));
      objects.put(20,
          new CropTechnologicalProcessObject(20, "Післясходове боронування перше", 6, cornCrop,
              woodlandClimateZone, mPhaseFiller.objects.get(8),
              mProcessPeriodFiller.objects.get(14)));
      objects.put(21,
          new CropTechnologicalProcessObject(21, "Післясходове боронування друге", 7, cornCrop,
              steppeClimateZone, mPhaseFiller.objects.get(9),
              mProcessPeriodFiller.objects.get(15)));
      objects.put(22,
          new CropTechnologicalProcessObject(22, "Післясходове боронування друге", 7, cornCrop,
              forestSteppeClimateZone, mPhaseFiller.objects.get(9),
              mProcessPeriodFiller.objects.get(16)));
      objects.put(23,
          new CropTechnologicalProcessObject(23, "Післясходове боронування друге", 7, cornCrop,
              woodlandClimateZone, mPhaseFiller.objects.get(9),
              mProcessPeriodFiller.objects.get(17)));

      objects.put(24,
          new CropTechnologicalProcessObject(24, "Внесення гербіциду по вегетуючій культурі", 5,
              cornCrop, steppeClimateZone, mPhaseFiller.objects.get(10),
              mProcessPeriodFiller.objects.get(18)));
      objects.put(25,
          new CropTechnologicalProcessObject(25, "Внесення гербіциду по вегетуючій культурі", 5,
              cornCrop, forestSteppeClimateZone, mPhaseFiller.objects.get(10),
              mProcessPeriodFiller.objects.get(19)));
      objects.put(26,
          new CropTechnologicalProcessObject(26, "Внесення гербіциду по вегетуючій культурі", 5,
              cornCrop, woodlandClimateZone, mPhaseFiller.objects.get(10),
              mProcessPeriodFiller.objects.get(20)));

      objects.put(27, new CropTechnologicalProcessObject(27,
          "Боротьба з шкідниками: обприскування посівів інсектицидами", 8, cornCrop,
          steppeClimateZone, mPhaseFiller.objects.get(11), mProcessPeriodFiller.objects.get(18)));
      objects.put(28, new CropTechnologicalProcessObject(28,
          "Боротьба з шкідниками: обприскування посівів інсектицидами", 8, cornCrop,
          forestSteppeClimateZone, mPhaseFiller.objects.get(11),
          mProcessPeriodFiller.objects.get(19)));
      objects.put(29, new CropTechnologicalProcessObject(29,
          "Боротьба з шкідниками: обприскування посівів інсектицидами", 8, cornCrop,
          woodlandClimateZone, mPhaseFiller.objects.get(11), mProcessPeriodFiller.objects.get(20)));
      objects.put(30,
          new CropTechnologicalProcessObject(30, "Міжрядний обробіток: перша культивація", 9,
              cornCrop, anyClimateZone, mPhaseFiller.objects.get(12),
              mProcessPeriodFiller.objects.get(21)));
      objects.put(31,
          new CropTechnologicalProcessObject(31, "Міжрядний обробіток: друга культивація", 10,
              cornCrop, anyClimateZone, mPhaseFiller.objects.get(12),
              mProcessPeriodFiller.objects.get(21)));
      objects.put(32,
          new CropTechnologicalProcessObject(32, "Внесення страхового гербіциду", 9, cornCrop,
              anyClimateZone, mPhaseFiller.objects.get(13), mProcessPeriodFiller.objects.get(21)));
      objects.put(33,
          new CropTechnologicalProcessObject(33, "Прикореневе підживлення кукурудзи", 11, cornCrop,
              anyClimateZone, mPhaseFiller.objects.get(14), mProcessPeriodFiller.objects.get(22)));
      objects.put(34, new CropTechnologicalProcessObject(34,
          "Біологічний  метод боротьби з шкідниками: перший випуск трихограми", 12, cornCrop,
          steppeClimateZone, mPhaseFiller.objects.get(15), mProcessPeriodFiller.objects.get(23)));
      objects.put(35, new CropTechnologicalProcessObject(35,
          "Біологічний  метод боротьби з шкідниками: перший випуск трихограми", 12, cornCrop,
          forestSteppeClimateZone, mPhaseFiller.objects.get(15),
          mProcessPeriodFiller.objects.get(24)));
      objects.put(36, new CropTechnologicalProcessObject(36,
          "Біологічний  метод боротьби з шкідниками: перший випуск трихограми", 12, cornCrop,
          woodlandClimateZone, mPhaseFiller.objects.get(15), mProcessPeriodFiller.objects.get(25)));
      objects.put(37, new CropTechnologicalProcessObject(37,
          "Біологічний  метод боротьби з шкідниками: другий випуск трихограми", 13, cornCrop,
          steppeClimateZone, mPhaseFiller.objects.get(16), mProcessPeriodFiller.objects.get(26)));
      objects.put(38, new CropTechnologicalProcessObject(38,
          "Біологічний  метод боротьби з шкідниками: другий випуск трихограми", 13, cornCrop,
          forestSteppeClimateZone, mPhaseFiller.objects.get(16),
          mProcessPeriodFiller.objects.get(27)));
      objects.put(39, new CropTechnologicalProcessObject(39,
          "Біологічний  метод боротьби з шкідниками: другий випуск трихограми", 13, cornCrop,
          woodlandClimateZone, mPhaseFiller.objects.get(16), mProcessPeriodFiller.objects.get(28)));
      objects.put(40,
          new CropTechnologicalProcessObject(40, "Обробка посівів інсектицидами", 13, cornCrop,
              steppeClimateZone, mPhaseFiller.objects.get(16),
              mProcessPeriodFiller.objects.get(29)));
      objects.put(41,
          new CropTechnologicalProcessObject(41, "Обробка посівів інсектицидами", 13, cornCrop,
              forestSteppeClimateZone, mPhaseFiller.objects.get(16),
              mProcessPeriodFiller.objects.get(30)));
      objects.put(42,
          new CropTechnologicalProcessObject(42, "Обробка посівів інсектицидами", 13, cornCrop,
              woodlandClimateZone, mPhaseFiller.objects.get(16),
              mProcessPeriodFiller.objects.get(31)));
      objects.put(43,
          new CropTechnologicalProcessObject(43, "Збір урожаю", 14, cornCrop, anyClimateZone,
              mPhaseFiller.objects.get(19), mProcessPeriodFiller.objects.get(32)));
    }

    @Override void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putCropTechnologicalProcess(objects.valueAt(i));
      }
    }

    @Override IEntity[] getEntitiesArray() {
      CropTechnologicalProcessEntity[] res = new CropTechnologicalProcessEntity[objects.size()];
      fillEntitiesArray(objects, res,
          new CropTechnologicalProcessObjectToCropTechnologicalProcessEntityMapper());
      return res;
    }

    @Override String convertObjectsToJson() {
      return toJsonConversion(objects, new CropTechnologicalProcessEntity[objects.size()],
          new CropTechnologicalProcessObjectToCropTechnologicalProcessEntityMapper());
    }

    @Override IEntity[] convertJsonToEntities(String json) {
      return mGson.fromJson(json, CropTechnologicalProcessEntity[].class);
    }
  }
}
