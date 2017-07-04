package com.apps.twelve.floor.field.utils;

import android.util.SparseArray;
import com.apps.twelve.floor.field.data.DataManager;
import com.apps.twelve.floor.field.data.local.objects.CropObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionSpanValueObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionTypeObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.PestObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.PhenologicalCharacteristicObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.SoilTypeObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.TillageDirectionObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.WeedClassObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.WeedGroupObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.WeedNutritionTypeObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.ClimateZoneObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.PhaseObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.ProcessPeriodObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.AggregateObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.InsectObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.ProductCategoryObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.ProductObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.TechnologicalSolutionTypeObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.TechnologicalProcessStateObject;
import java.util.ArrayList;
import timber.log.Timber;

/**
 * Created by yarrick on 04.07.17.
 * Fills database with primary data
 * TODO: on release version primary data gonna be filled from *.json (in res) file by Retrofit
 * TODO: like it was received from server
 */

public final class PrimaryDataFiller {

  private DataManager mDataManager;

  private CropFiller mCropFiller;
  private ClimateZoneFiller mClimateZoneFiller;
  private PhaseFiller mPhaseFiller;
  private ConditionTypeFiller mConditionTypeFiller;
  private SpanValueFiller mSpanValueFiller;
  private SoilTypeFiller mSoilTypeFiller;
  private TechnologicalProcessStateFiller mTechnologicalProcessStateFiller;
  private PestFiller mPestFiller;
  private TillageDirectionFiller mTillageDirectionFiller;
  private PhenologicalCharacteristicFiller mPhenologicalCharacteristicFiller;
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

  public PrimaryDataFiller(DataManager dataManager) {
    this.mDataManager = dataManager;
  }

  public void addTestData() {

    initFillers();
    makeObjects();
    saveObjects();
    checkObjects();
  }

  private void initFillers() {
    mCropFiller = new CropFiller();
    mClimateZoneFiller = new ClimateZoneFiller();
    mPhaseFiller = new PhaseFiller();
    mConditionTypeFiller = new ConditionTypeFiller();
    mSpanValueFiller = new SpanValueFiller();
    mSoilTypeFiller = new SoilTypeFiller();
    mPestFiller = new PestFiller();
    mTillageDirectionFiller = new TillageDirectionFiller();
    mPhenologicalCharacteristicFiller = new PhenologicalCharacteristicFiller();
    mConditionsFiller = new ConditionsFiller();
    mTechnologicalProcessStateFiller = new TechnologicalProcessStateFiller();
    mTechnologicalSolutionTypeFiller = new TechnologicalSolutionTypeFiller();
    mAggregateFiller = new AggregateFiller();
    mInsectFiller = new InsectFiller();
    mProductCategoryFiller = new ProductCategoryFiller();
    mProductFiller = new ProductFiller();
    mWeedNutritionTypeFiller = new WeedNutritionTypeFiller();
    mWeedClassFiller = new WeedClassFiller();
    mWeedGroupFiller = new WeedGroupFiller();
    mProcessPeriodFiller = new ProcessPeriodFiller();
    // TODO
  }

  private void makeObjects() {
    mCropFiller.makeObjects();
    mClimateZoneFiller.makeObjects();
    mPhaseFiller.makeObjects();
    mConditionTypeFiller.makeObjects();
    mSpanValueFiller.makeObjects();
    mSoilTypeFiller.makeObjects();
    mPestFiller.makeObjects();
    mTillageDirectionFiller.makeObjects();
    mPhenologicalCharacteristicFiller.makeObjects();
    mConditionsFiller.makeObjects();
    mTechnologicalProcessStateFiller.makeObjects();
    mTechnologicalSolutionTypeFiller.makeObjects();
    mAggregateFiller.makeObjects();
    mInsectFiller.makeObjects();
    mProductCategoryFiller.makeObjects();
    mProductFiller.makeObjects();
    mWeedNutritionTypeFiller.makeObjects();
    mWeedClassFiller.makeObjects();
    mWeedGroupFiller.makeObjects();
    mProcessPeriodFiller.makeObjects();
    // TODO
  }

  private void saveObjects() {
    mCropFiller.saveObjects();
    mClimateZoneFiller.saveObjects();
    mPhaseFiller.saveObjects();
    mConditionTypeFiller.saveObjects();
    mSpanValueFiller.saveObjects();
    mSoilTypeFiller.saveObjects();
    mPestFiller.saveObjects();
    mTillageDirectionFiller.saveObjects();
    mPhenologicalCharacteristicFiller.saveObjects();
    mConditionsFiller.saveObjects();
    mTechnologicalProcessStateFiller.saveObjects();
    mTechnologicalSolutionTypeFiller.saveObjects();
    mAggregateFiller.saveObjects();
    mInsectFiller.saveObjects();
    mProductCategoryFiller.saveObjects();
    mProductFiller.saveObjects();
    mWeedNutritionTypeFiller.saveObjects();
    mWeedClassFiller.saveObjects();
    mWeedGroupFiller.saveObjects();
    mProcessPeriodFiller.saveObjects();
    // TODO
  }

  private void checkObjects() {
    Timber.e(String.valueOf(mDataManager.getAllProcessPeriodEntitiesAsList().size()));
    // TODO
  }

  ///////////////////////////////////////////////////////////////////////////
  // Fillers
  ///////////////////////////////////////////////////////////////////////////

  private class CropFiller {

    static final int CORN_KEY = 1;

    private static final int CAPACITY = 6;

    private SparseArray<CropObject> objects = new SparseArray<>(CAPACITY);

    void makeObjects() {
      objects.put(CORN_KEY, new CropObject(1, "Кукуруза", 0, false, true));
      objects.put(2, new CropObject(2, "Картошка", 0, false, false));
      objects.put(3, new CropObject(3, "Свекла", 0, false, false));
      objects.put(4, new CropObject(4, "Пшеница", 0, false, false));
      objects.put(5, new CropObject(5, "Виноград", 0, false, false));
      objects.put(6, new CropObject(6, "Лен", 0, false, false));
    }

    void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putCrop(objects.valueAt(i));
      }
    }
  }

  private class ClimateZoneFiller {

    private static final int CAPACITY = 4;

    private SparseArray<ClimateZoneObject> objects = new SparseArray<>(CAPACITY);

    void makeObjects() {
      objects.put(1, new ClimateZoneObject(1, "Степ", new ArrayList<>()));
      objects.put(2, new ClimateZoneObject(2, "Лісо-степ", new ArrayList<>()));
      objects.put(3, new ClimateZoneObject(3, "Полісся", new ArrayList<>()));
      objects.put(4, new ClimateZoneObject(4, "Карпатські та Кримські гори", new ArrayList<>()));
    }

    void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putClimateZone(objects.valueAt(i));
      }
    }
  }

  private class PhaseFiller {

    private static final int CAPACITY = 18;

    private SparseArray<PhaseObject> objects = new SparseArray<>(CAPACITY);

    void makeObjects() {
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
    }

    void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putPhase(objects.valueAt(i));
      }
    }
  }

  private class ConditionTypeFiller {

    static final int SOIL_TYPE_KEY = 1;
    static final int TILLAGE_DIRECTION_KEY = 3;
    static final int PHENOLOGICAL_CHARACTERISTIC_KEY = 4;
    static final int SPAN_VALUE_KEY = 5;
    static final int PEST_KEY = 7;

    private static final int CAPACITY = 7;

    private SparseArray<ConditionTypeObject> objects = new SparseArray<>(CAPACITY);

    void makeObjects() {

      objects.put(SOIL_TYPE_KEY, new ConditionTypeObject(1, "Тип почвы"));
      objects.put(2, new ConditionTypeObject(2, "Фаза развития вредного объекта"));
      objects.put(TILLAGE_DIRECTION_KEY,
          new ConditionTypeObject(3, "Направление обработки почвы, посева, опрыскивания"));
      objects.put(PHENOLOGICAL_CHARACTERISTIC_KEY,
          new ConditionTypeObject(4, "Фенологическая характеристика"));
      objects.put(SPAN_VALUE_KEY, new ConditionTypeObject(5, "Числовой диапазон"));
      objects.put(6, new ConditionTypeObject(6, "Число"));
      objects.put(PEST_KEY, new ConditionTypeObject(7, "Вредный объект"));
    }

    void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putConditionType(objects.valueAt(i));
      }
    }
  }

  private class SoilTypeFiller {

    private static final int CAPACITY = 6;

    private SparseArray<SoilTypeObject> objects = new SparseArray<>(CAPACITY);

    void makeObjects() {

      ConditionTypeObject soilTypeConditionTypeObject =
          mConditionTypeFiller.objects.get(ConditionTypeFiller.SOIL_TYPE_KEY);

      objects.put(1,
          new SoilTypeObject(1, "Піщані, або легкі грунти", soilTypeConditionTypeObject, ""));
      objects.put(2,
          new SoilTypeObject(2, "Глинисті, або важкі грунти ", soilTypeConditionTypeObject, ""));
      objects.put(3, new SoilTypeObject(3, "Кам'янисті грунти", soilTypeConditionTypeObject, ""));
      objects.put(4,
          new SoilTypeObject(4, "Торф'яно-болотні грунти", soilTypeConditionTypeObject, ""));
      objects.put(5, new SoilTypeObject(5, "Супіщані грунти", soilTypeConditionTypeObject, ""));
      objects.put(6,
          new SoilTypeObject(6, "Суглинні, або середні грунти", soilTypeConditionTypeObject, ""));
    }

    void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putSoilType(objects.valueAt(i));
      }
    }
  }

  private class SpanValueFiller {

    static final int SPAN_0_10_KEY = 1;
    static final int SPAN_10_300_KEY = 2;
    static final int SPAN_12_20_KEY = 3;
    static final int SPAN_8_10_KEY = 4;
    static final int SPAN_0_25_KEY = 5;

    private static final int CAPACITY = 5;

    private SparseArray<ConditionSpanValueObject> objects = new SparseArray<>(CAPACITY);

    void makeObjects() {

      ConditionTypeObject spanValueConditionTypeObject =
          mConditionTypeFiller.objects.get(ConditionTypeFiller.SPAN_VALUE_KEY);

      objects.put(SPAN_0_10_KEY,
          new ConditionSpanValueObject(1, spanValueConditionTypeObject, 0, 10));
      objects.put(SPAN_10_300_KEY,
          new ConditionSpanValueObject(2, spanValueConditionTypeObject, 10, 300));
      objects.put(SPAN_12_20_KEY,
          new ConditionSpanValueObject(3, spanValueConditionTypeObject, 12, 20));
      objects.put(SPAN_8_10_KEY,
          new ConditionSpanValueObject(4, spanValueConditionTypeObject, 8, 10));
      objects.put(SPAN_0_25_KEY,
          new ConditionSpanValueObject(5, spanValueConditionTypeObject, 0, 25));
    }

    void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putSpanValue(objects.valueAt(i));
      }
    }
  }

  private class PestFiller {

    private static final int CAPACITY = 22;

    private SparseArray<PestObject> objects = new SparseArray<>(CAPACITY);

    void makeObjects() {

      ConditionTypeObject pestConditionTypeObject =
          mConditionTypeFiller.objects.get(ConditionTypeFiller.PEST_KEY);

      objects.put(1, new PestObject(1, "злакові бур’яни", pestConditionTypeObject, 0, false));
      objects.put(2, new PestObject(2, "ярі дводольні бур’яни", pestConditionTypeObject, 0, false));
      objects.put(3,
          new PestObject(3, "Однорічні зимуючі бур’яни", pestConditionTypeObject, 0, false));
      objects.put(4,
          new PestObject(4, "Збудники пліснявіння  насіння", pestConditionTypeObject, 0, false));
      objects.put(5, new PestObject(5, "Збудники фузаріозу", pestConditionTypeObject, 0, false));
      objects.put(6, new PestObject(6, "Дротяники", pestConditionTypeObject, 0, false));
      objects.put(7, new PestObject(7, "ківсяки", pestConditionTypeObject, 0, false));
      objects.put(8, new PestObject(8, "личинки хрущів", pestConditionTypeObject, 0, false));
      objects.put(9, new PestObject(9, "личинки хлібних жуків", pestConditionTypeObject, 0, false));
      objects.put(10,
          new PestObject(10, "ярі дводольні бур’яни", pestConditionTypeObject, 0, false));
      objects.put(11, new PestObject(11, "ярі злакові бур’яни", pestConditionTypeObject, 0, false));
      objects.put(12,
          new PestObject(12, "Однорічні ярі дводольні бур’яни", pestConditionTypeObject, 0, false));
      objects.put(13,
          new PestObject(13, "Однорічні ярі злакові бур’яни", pestConditionTypeObject, 0, false));
      objects.put(14,
          new PestObject(14, "Однорічні дводольні бур’яни", pestConditionTypeObject, 0, false));
      objects.put(15,
          new PestObject(15, "Однорічні злакові бур’яни", pestConditionTypeObject, 0, false));
      objects.put(16,
          new PestObject(16, "багаторічні дводольні бур’яни", pestConditionTypeObject, 0, false));
      objects.put(17,
          new PestObject(17, "багаторічні злакові бур’яни", pestConditionTypeObject, 0, false));
      objects.put(18, new PestObject(18, "Шведська муха", pestConditionTypeObject, 0, false));
      objects.put(19, new PestObject(19, "попелиці", pestConditionTypeObject, 0, false));
      objects.put(20,
          new PestObject(20, "кукурудзяний метелик", pestConditionTypeObject, 0, false));
      objects.put(21, new PestObject(21, "лучний метелик", pestConditionTypeObject, 0, false));
      objects.put(22, new PestObject(22, "бавовникова совка", pestConditionTypeObject, 0, false));
    }

    void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putPest(objects.valueAt(i));
      }
    }
  }

  private class TillageDirectionFiller {

    private static final int CAPACITY = 4;

    private SparseArray<TillageDirectionObject> objects = new SparseArray<>(CAPACITY);

    void makeObjects() {

      ConditionTypeObject tillageDirectionConditionTypeObject =
          mConditionTypeFiller.objects.get(ConditionTypeFiller.TILLAGE_DIRECTION_KEY);

      objects.put(1, new TillageDirectionObject(1, "під кутом 45⁰ до напряму оранки",
          tillageDirectionConditionTypeObject));
      objects.put(2, new TillageDirectionObject(2, "Човнико-вий або діагональ-ний",
          tillageDirectionConditionTypeObject));
      objects.put(3, new TillageDirectionObject(3, "міжряддя вздовж рядків",
          tillageDirectionConditionTypeObject));
      objects.put(4, new TillageDirectionObject(4, "суцільний обробіток",
          tillageDirectionConditionTypeObject));
    }

    void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putTillageDirection(objects.valueAt(i));
      }
    }
  }

  private class PhenologicalCharacteristicFiller {

    private static final int CAPACITY = 8;

    private SparseArray<PhenologicalCharacteristicObject> objects = new SparseArray<>(CAPACITY);

    void makeObjects() {

      ConditionTypeObject phenologicalCharacteristicConditionTypeObject =
          mConditionTypeFiller.objects.get(ConditionTypeFiller.PHENOLOGICAL_CHARACTERISTIC_KEY);

      objects.put(1, new PhenologicalCharacteristicObject(1, "Цвітіння черемухи",
          phenologicalCharacteristicConditionTypeObject));
      objects.put(2, new PhenologicalCharacteristicObject(2, "Цвітіння черешні",
          phenologicalCharacteristicConditionTypeObject));
      objects.put(3, new PhenologicalCharacteristicObject(3,
          "Активна вегетація. Рослини не повинні перебувати в стресовому стані",
          phenologicalCharacteristicConditionTypeObject));
      objects.put(4, new PhenologicalCharacteristicObject(4,
          "Початок масового льоту кукурудзяного метелика -визначається за допомогою феромонних пасток. ",
          phenologicalCharacteristicConditionTypeObject));
      objects.put(5,
          new PhenologicalCharacteristicObject(5, "масове відкладання яєць кукурудзяним метеликом",
              phenologicalCharacteristicConditionTypeObject));
      objects.put(6, new PhenologicalCharacteristicObject(6, "проникнення перших гусениць у стебла",
          phenologicalCharacteristicConditionTypeObject));
      objects.put(7, new PhenologicalCharacteristicObject(7, "Активна вегетація бур’янів",
          phenologicalCharacteristicConditionTypeObject));
      objects.put(8, new PhenologicalCharacteristicObject(8,
          "Візуально визначається по наявності чор-ного прошарку (чорної точки) між зерном і місцем прикріплення його до качана",
          phenologicalCharacteristicConditionTypeObject));
    }

    void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putPhenologicalCharacteristic(objects.valueAt(i));
      }
    }
  }

  private class ConditionsFiller {

    private static final int CAPACITY = 5;

    private SparseArray<ConditionObject> objects = new SparseArray<>(CAPACITY);

    void makeObjects() {

      ConditionTypeObject spanValueConditionType =
          mConditionTypeFiller.objects.get(ConditionTypeFiller.SPAN_VALUE_KEY);

      // air temperatures
      String airTemperatureConditionName = "t⁰ повітря"; // TODO: this must be in a different table
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

      // air temperatures
      objects.put(1,
          new ConditionObject(1, airTemperatureConditionName, ConditionObject.LOWEST_PRIORITY,
              spanValueConditionType, temperature0to10));
      objects.put(2,
          new ConditionObject(2, airTemperatureConditionName, ConditionObject.LOWEST_PRIORITY,
              spanValueConditionType, temperature10to300));
      objects.put(3,
          new ConditionObject(3, airTemperatureConditionName, ConditionObject.LOWEST_PRIORITY,
              spanValueConditionType, temperature12to20));
      objects.put(4,
          new ConditionObject(4, airTemperatureConditionName, ConditionObject.LOWEST_PRIORITY,
              spanValueConditionType, temperature8to10));
      objects.put(5,
          new ConditionObject(5, airTemperatureConditionName, ConditionObject.LOWEST_PRIORITY,
              spanValueConditionType, temperature0to25));
    }

    void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putCondition(objects.valueAt(i));
      }
    }
  }

  private class TechnologicalProcessStateFiller {

    private static final int CAPACITY = 5;

    private SparseArray<TechnologicalProcessStateObject> objects = new SparseArray<>(CAPACITY);

    void makeObjects() {
      objects.put(1, new TechnologicalProcessStateObject(1, "В очереди", 0));
      objects.put(2, new TechnologicalProcessStateObject(2, "Актуален", 0));
      objects.put(3, new TechnologicalProcessStateObject(3, "Выполнен", 0));
      objects.put(4, new TechnologicalProcessStateObject(4, "Отменен", 0));
      objects.put(5, new TechnologicalProcessStateObject(5, "Пропущен", 0));
    }

    void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putTechnologicalProcessState(objects.valueAt(i));
      }
    }
  }

  private class TechnologicalSolutionTypeFiller {

    static final int AGGREGATES_KEY = 1;
    static final int PRODUCTS_KEY = 2;
    static final int INSECTS_KEY = 3;
    static final int OTHER_KEY = 4;

    private static final int CAPACITY = 4;

    private SparseArray<TechnologicalSolutionTypeObject> objects = new SparseArray<>(CAPACITY);

    void makeObjects() {
      objects.put(AGGREGATES_KEY, new TechnologicalSolutionTypeObject(1, "Агрегаты"));
      objects.put(PRODUCTS_KEY, new TechnologicalSolutionTypeObject(2, "Препараты"));
      objects.put(INSECTS_KEY, new TechnologicalSolutionTypeObject(3, "Насекомые"));
      objects.put(OTHER_KEY, new TechnologicalSolutionTypeObject(4, "Другие решения"));
    }

    void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putTechnologicalSolutionType(objects.valueAt(i));
      }
    }
  }

  private class AggregateFiller {

    private static final int CAPACITY = 15;

    private SparseArray<AggregateObject> objects = new SparseArray<>(CAPACITY);

    void makeObjects() {
      TechnologicalSolutionTypeObject aggregateTechSolutionType =
          mTechnologicalSolutionTypeFiller.objects.get(
              TechnologicalSolutionTypeFiller.AGGREGATES_KEY);

      // TODO: need to change - we wouldn't use specified aggregates - only their groups
      objects.put(1, new AggregateObject(1, "Важка борона", aggregateTechSolutionType, 0));
      objects.put(2, new AggregateObject(2, "Волокуша-вирівнювач", aggregateTechSolutionType, 0));
      objects.put(3, new AggregateObject(3, "Культиватор", aggregateTechSolutionType, 0));
      objects.put(4, new AggregateObject(4, "Гладкорубчасті котки", aggregateTechSolutionType, 0));
      objects.put(5, new AggregateObject(5, "Кільчасті котки", aggregateTechSolutionType, 0));
      objects.put(6, new AggregateObject(6, "Борона ЗБП-0.6", aggregateTechSolutionType, 0));
      objects.put(7, new AggregateObject(7, "Борона БЗСС-1", aggregateTechSolutionType, 0));
      objects.put(8, new AggregateObject(8, "Культиватор КРН-4.2", aggregateTechSolutionType, 0));
      objects.put(9, new AggregateObject(9, "Культиватор КРН-5.6", aggregateTechSolutionType, 0));
      objects.put(11, new AggregateObject(11, "Дисковий лущильник", aggregateTechSolutionType, 0));
      objects.put(12, new AggregateObject(12, "Оприскувачі навісні", aggregateTechSolutionType, 0));
      objects.put(13,
          new AggregateObject(13, "Оприскувачі причіпні", aggregateTechSolutionType, 0));
      objects.put(14,
          new AggregateObject(14, "Кукурудзозбиральні комбайни", aggregateTechSolutionType, 0));
      objects.put(15,
          new AggregateObject(15, "Зернозбиральні комбайни", aggregateTechSolutionType, 0));
    }

    void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putAggregate(objects.valueAt(i));
      }
    }
  }

  private class InsectFiller {

    private static final int CAPACITY = 1;

    private SparseArray<InsectObject> objects = new SparseArray<>(CAPACITY);

    void makeObjects() {
      TechnologicalSolutionTypeObject insectTechSolutionType =
          mTechnologicalSolutionTypeFiller.objects.get(TechnologicalSolutionTypeFiller.INSECTS_KEY);

      objects.put(1, new InsectObject(1, "Вогнівкова раса трихограми", insectTechSolutionType, 0));
    }

    void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putInsect(objects.valueAt(i));
      }
    }
  }

  private class ProductCategoryFiller {

    static final int HERBICIDES_KEY = 1;
    static final int FUNGICIDES_KEY = 2;
    static final int DISINFECTANTS_KEY = 3;
    static final int INSECTICIDES_KEY = 4;

    private static final int CAPACITY = 4;

    private SparseArray<ProductCategoryObject> objects = new SparseArray<>(CAPACITY);

    void makeObjects() {
      objects.put(HERBICIDES_KEY, new ProductCategoryObject(1, "Гербіциди"));
      objects.put(FUNGICIDES_KEY, new ProductCategoryObject(2, "Фунгiциди"));
      objects.put(DISINFECTANTS_KEY, new ProductCategoryObject(3, "Протруйники"));
      objects.put(INSECTICIDES_KEY, new ProductCategoryObject(4, "Iнсектициди"));
    }

    void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putProductCategory(objects.valueAt(i));
      }
    }
  }

  private class ProductFiller {

    private static final int CAPACITY = 17;

    private SparseArray<ProductObject> objects = new SparseArray<>(CAPACITY);

    void makeObjects() {

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

      objects.put(1, new ProductObject(1, "Агрощит Супер", techSolutionTypeProducts, 0,
          herbicideProductCategory));
      objects.put(2, new ProductObject(2, "Екстракорн", techSolutionTypeProducts, 0,
          herbicideProductCategory));
      objects.put(3,
          new ProductObject(3, "Кіаніт", techSolutionTypeProducts, 0, herbicideProductCategory));
      objects.put(4,
          new ProductObject(4, "Лавина", techSolutionTypeProducts, 0, herbicideProductCategory));
      objects.put(5,
          new ProductObject(5, "Ратник", techSolutionTypeProducts, 0, herbicideProductCategory));
      objects.put(6,
          new ProductObject(6, "Ріпіус", techSolutionTypeProducts, 0, herbicideProductCategory));
      objects.put(7,
          new ProductObject(7, "Сатурн", techSolutionTypeProducts, 0, herbicideProductCategory));
      objects.put(8,
          new ProductObject(8, "Скат", techSolutionTypeProducts, 0, herbicideProductCategory));
      objects.put(9,
          new ProductObject(9, "Сотейра", techSolutionTypeProducts, 0, herbicideProductCategory));
      objects.put(10,
          new ProductObject(10, "Азимут", techSolutionTypeProducts, 0, fungicideProductCategory));
      objects.put(11,
          new ProductObject(11, "Аліот", techSolutionTypeProducts, 0, fungicideProductCategory));
      objects.put(12, new ProductObject(12, "Карбеназол", techSolutionTypeProducts, 0,
          fungicideProductCategory));
      objects.put(13, new ProductObject(13, "Вершина", techSolutionTypeProducts, 0,
          disinfectantProductCategory));
      objects.put(14,
          new ProductObject(14, "Койот", techSolutionTypeProducts, 0, disinfectantProductCategory));
      objects.put(15, new ProductObject(15, "Таймень", techSolutionTypeProducts, 0,
          disinfectantProductCategory));
      objects.put(16,
          new ProductObject(16, "Велес", techSolutionTypeProducts, 0, insecticideProductCategory));
      objects.put(17,
          new ProductObject(17, "Вирій", techSolutionTypeProducts, 0, insecticideProductCategory));
    }

    void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putProduct(objects.valueAt(i));
      }
    }
  }

  private class ProcessPeriodFiller {

    private static final int CAPACITY = 32;

    private SparseArray<ProcessPeriodObject> objects = new SparseArray<>(CAPACITY);

    void makeObjects() {

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

    void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        // TODO: dataManager must take Objects not Entities
        //mDataManager.putProcessPeriod(objects.valueAt(i));
      }
    }
  }

  private class WeedNutritionTypeFiller {

    private static final int CAPACITY = 3;

    private SparseArray<WeedNutritionTypeObject> objects = new SparseArray<>(CAPACITY);

    void makeObjects() {

      objects.put(1, new WeedNutritionTypeObject(1, "Непаразити"));
      objects.put(2, new WeedNutritionTypeObject(2, "Напівпаразити"));
      objects.put(3, new WeedNutritionTypeObject(3, "Паразити"));
    }

    void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putWeedNutritionType(objects.valueAt(i));
      }
    }
  }

  private class WeedClassFiller {

    private static final int CAPACITY = 41;

    private SparseArray<WeedClassObject> objects = new SparseArray<>(CAPACITY);

    void makeObjects() {
      objects.put(1, new WeedClassObject(1, "Дводольні", 0, true));
      objects.put(2, new WeedClassObject(2, "Губоцвіті ", 1, false));
      objects.put(3, new WeedClassObject(3, "Капустяні", 1, false));
      objects.put(4, new WeedClassObject(4, "Фіалкові", 1, false));
      objects.put(5, new WeedClassObject(5, "Макові", 1, false));
      objects.put(6, new WeedClassObject(6, "Геранієві", 1, false));
      objects.put(7, new WeedClassObject(7, "Айстрові", 1, false));
      objects.put(8, new WeedClassObject(8, "Бурачникові", 1, false));
      objects.put(9, new WeedClassObject(9, "Жовтецеві", 1, false));
      objects.put(10, new WeedClassObject(10, "Гвоздикові", 1, false));
      objects.put(11, new WeedClassObject(11, "Лободові", 1, false));
      objects.put(12, new WeedClassObject(12, "Мальвові", 1, false));
      objects.put(13, new WeedClassObject(13, "Бобові", 1, false));
      objects.put(14, new WeedClassObject(14, "Зонтичні", 1, false));
      objects.put(15, new WeedClassObject(15, "Паролистові", 1, false));
      objects.put(16, new WeedClassObject(16, "Маренові", 1, false));
      objects.put(17, new WeedClassObject(17, "Гречкові", 1, false));
      objects.put(18, new WeedClassObject(18, "Резедові", 1, false));
      objects.put(19, new WeedClassObject(19, "Амарантові", 1, false));
      objects.put(20, new WeedClassObject(20, "Складноцвіті", 1, false));
      objects.put(21, new WeedClassObject(21, "Пасльонові", 1, false));
      objects.put(22, new WeedClassObject(22, "Первоцвітові", 1, false));
      objects.put(23, new WeedClassObject(23, "Кропивні", 1, false));
      objects.put(24, new WeedClassObject(24, "Конопляні", 1, false));
      objects.put(25, new WeedClassObject(25, "Камелінові", 1, false));
      objects.put(26, new WeedClassObject(26, "Портулакові", 1, false));
      objects.put(27, new WeedClassObject(27, "Щирицеві", 1, false));
      objects.put(28, new WeedClassObject(28, "Барвінкові", 1, false));
      objects.put(29, new WeedClassObject(29, "Квасеницюваті", 1, false));
      objects.put(30, new WeedClassObject(30, "Хвилівникові", 1, false));
      objects.put(31, new WeedClassObject(31, "Онагрові", 1, false));
      objects.put(32, new WeedClassObject(32, "Молочайні", 1, false));
      objects.put(33, new WeedClassObject(33, "Ранникові", 1, false));
      objects.put(34, new WeedClassObject(34, "Березкові", 1, false));
      objects.put(35, new WeedClassObject(35, "Подорожникові", 1, false));
      objects.put(36, new WeedClassObject(36, "Розові", 1, false));
      objects.put(37, new WeedClassObject(37, "Лілійні", 1, false));
      objects.put(38, new WeedClassObject(38, "Шорстколисті", 1, false));
      objects.put(39, new WeedClassObject(39, "Однодольні", 0, true));
      objects.put(40, new WeedClassObject(40, "Злакові (тонконогові)", 39, false));
      objects.put(41, new WeedClassObject(41, "Хвощовидні (спорові)", 0, true));
    }

    void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putWeedClass(objects.valueAt(i));
      }
    }
  }

  private class WeedGroupFiller {

    private static final int CAPACITY = 16;

    private SparseArray<WeedGroupObject> objects = new SparseArray<>(CAPACITY);

    void makeObjects() {
      objects.put(1, new WeedGroupObject(1, "Малорічні", 0, true));
      objects.put(2, new WeedGroupObject(2, "Ярі", 1, true));
      objects.put(3, new WeedGroupObject(3, "Ефемери", 2, false));
      objects.put(4, new WeedGroupObject(4, "Ранні", 2, false));
      objects.put(5, new WeedGroupObject(5, "Пізні", 2, false));
      objects.put(6, new WeedGroupObject(6, "Озимі", 1, false));
      objects.put(7, new WeedGroupObject(7, "Зимуючі", 1, false));
      objects.put(8, new WeedGroupObject(8, "Дворічні", 1, false));
      objects.put(9, new WeedGroupObject(9, "Багаторічні", 0, true));
      objects.put(10, new WeedGroupObject(10, "Кореневищні", 9, false));
      objects.put(11, new WeedGroupObject(11, "Коренепаросткові", 9, false));
      objects.put(12, new WeedGroupObject(12, "Коренемичкуваті", 9, false));
      objects.put(13, new WeedGroupObject(13, "Стрижнекореневі", 9, false));
      objects.put(14, new WeedGroupObject(14, "Повзучі", 9, false));
      objects.put(15, new WeedGroupObject(15, "Бульбові", 9, false));
      objects.put(16, new WeedGroupObject(16, "Цибулинні", 9, false));
    }

    void saveObjects() {
      for (int i = 0; i < objects.size(); i++) {
        mDataManager.putWeedGroup(objects.valueAt(i));
      }
    }
  }

}
