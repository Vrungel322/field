package com.apps.twelve.floor.field.utils;

import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.data.local.objects.CropObject;
import com.apps.twelve.floor.field.data.local.objects.FieldObject;
import com.apps.twelve.floor.field.data.local.objects.TillageDirectionObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.BaseConditionValueObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionNameObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionTypeObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.HarmfulObjectConditionValueObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.HarmfulObjectPhaseConditionValueObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.SpanConditionValueObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.TillageDirectionConditionValueObject;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.HarmfulObjectObject;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.HarmfulObjectPhaseObject;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.HarmfulObjectTypeObject;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.WeedClassObject;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.WeedGroupObject;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.WeedNutritionTypeObject;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.WeedObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.ClimateZoneObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.PhaseObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.ProcessPeriodObject;
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
import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessConditionObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.TechnologicalProcessConditionObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.TechnologicalProcessStateObject;
import java.util.ArrayList;

/**
 * Created by Yaroslav on 23.05.2017.
 */

public final class TestUtils {

  // Solution types
  private static ArrayList<TechnologicalSolutionTypeObject> technicalSolutionTypes;

  static {
    technicalSolutionTypes = new ArrayList<>();
    technicalSolutionTypes.add(new TechnologicalSolutionTypeObject(1, "(T): Агрегат"));
    technicalSolutionTypes.add(new TechnologicalSolutionTypeObject(2, "(T): Препарат"));
    technicalSolutionTypes.add(new TechnologicalSolutionTypeObject(3, "(T): Действующее вещество"));
    technicalSolutionTypes.add(new TechnologicalSolutionTypeObject(4, "(T): Насекомое"));
  }

  // Aggregates
  private static ArrayList<BaseTechnologicalSolutionObject> aggregateSolutionValues;

  static {
    TechnologicalSolutionTypeObject aggregateSolutionType = technicalSolutionTypes.get(0);

    aggregateSolutionValues = new ArrayList<>();
    aggregateSolutionValues.add(
        new AggregateObject(1, "(T): Легкая борона", aggregateSolutionType, 3000));
    aggregateSolutionValues.add(
        new AggregateObject(2, "(T): Тяжелая борона", aggregateSolutionType, 3000));
    aggregateSolutionValues.add(
        new AggregateObject(3, "(T): Севалка", aggregateSolutionType, 6000));
    aggregateSolutionValues.add(
        new AggregateObject(4, "(T): Комбайн", aggregateSolutionType, 150000));
  }

  // Product categories
  private static ArrayList<ProductCategoryObject> productCategories;

  static {
    productCategories = new ArrayList<>();
    productCategories.add(new ProductCategoryObject(1, "(T): Гербицид"));
  }

  // Products
  private static ArrayList<BaseTechnologicalSolutionObject> productSolutionValues;

  static {
    productSolutionValues = new ArrayList<>();

    TechnologicalSolutionTypeObject productSolutionType = technicalSolutionTypes.get(1);
    ProductCategoryObject herbicideProductCategory = productCategories.get(0);

    productSolutionValues.add(
        new ProductObject(1, "(T): Ратник", productSolutionType, 300, herbicideProductCategory));
    productSolutionValues.add(
        new ProductObject(2, "(T): Рипиус", productSolutionType, 200, herbicideProductCategory));
    productSolutionValues.add(
        new ProductObject(3, "(T): Сатурн", productSolutionType, 150, herbicideProductCategory));
    productSolutionValues.add(
        new ProductObject(4, "(T): Скат", productSolutionType, 480, herbicideProductCategory));
  }

  // Active components
  private static ArrayList<BaseTechnologicalSolutionObject> activeComponentSolutionValues;

  static {
    activeComponentSolutionValues = new ArrayList<>();

    TechnologicalSolutionTypeObject activeComponentSolutionType = technicalSolutionTypes.get(2);

    activeComponentSolutionValues.add(
        new ActiveComponentObject(1, "(T): Ципроконазол", activeComponentSolutionType));
    activeComponentSolutionValues.add(
        new ActiveComponentObject(2, "(T): S-метолахлор", activeComponentSolutionType));
    activeComponentSolutionValues.add(
        new ActiveComponentObject(3, "(T): Тербутилазин", activeComponentSolutionType));
    activeComponentSolutionValues.add(
        new ActiveComponentObject(4, "(T): Метазахлор", activeComponentSolutionType));
  }

  // Insects
  private static ArrayList<BaseTechnologicalSolutionObject> insectSolutionValues;

  static {
    insectSolutionValues = new ArrayList<>();

    TechnologicalSolutionTypeObject insectSolutionType = technicalSolutionTypes.get(3);

    new InsectObject(1, "Огневковая раса трихограммы", insectSolutionType, 150);
  }

  // Technological process states
  private static ArrayList<TechnologicalProcessStateObject> technologicalProcessStates;

  static {
    technologicalProcessStates = new ArrayList<>();

    technologicalProcessStates.add(
        new TechnologicalProcessStateObject(1, "(T): Выполнен", R.drawable.ic_done_24dp));
    technologicalProcessStates.add(
        new TechnologicalProcessStateObject(2, "(T): Актуален", R.drawable.ic_actual_24dp));
    technologicalProcessStates.add(
        new TechnologicalProcessStateObject(3, "(T): Запланирован", R.drawable.ic_future_24dp));
  }

  // Process periods
  private static ArrayList<ProcessPeriodObject> processPeriods;

  static {
    processPeriods = new ArrayList<>();
    processPeriods.add(new ProcessPeriodObject(1, 1, 30, 3, 3));
    processPeriods.add(new ProcessPeriodObject(1, 30, 15, 4, 5));
    processPeriods.add(new ProcessPeriodObject(1, 10, 25, 8, 9));
    processPeriods.add(new ProcessPeriodObject(1, 1, 25, 10, 10));
  }

  // Crop technological processes
  private static ArrayList<CropTechnologicalProcessObject> cropTechnologicalProcesses;

  static {
    CropObject crop = CropObject.EMPTY;
    ClimateZoneObject climateZone = ClimateZoneObject.EMPTY;
    PhaseObject phase = PhaseObject.EMPTY;
    cropTechnologicalProcesses = new ArrayList<>();
    cropTechnologicalProcesses.add(
        new CropTechnologicalProcessObject(1, "(T): Посев", 1, crop, climateZone, phase,
            processPeriods.get(0)));
    cropTechnologicalProcesses.add(
        new CropTechnologicalProcessObject(2, "(T): Гербицидная обработка", 2, crop, climateZone,
            phase, processPeriods.get(1)));
    cropTechnologicalProcesses.add(
        new CropTechnologicalProcessObject(3, "(T): Инсектицидная обработка", 3, crop, climateZone,
            phase, processPeriods.get(2)));
    cropTechnologicalProcesses.add(
        new CropTechnologicalProcessObject(4, "(T): Сбор урожая", 4, crop, climateZone, phase,
            processPeriods.get(3)));
  }

  // Field technological processes
  private static ArrayList<FieldCropTechnologicalProcessObject> fieldTechnologicalProcesses;

  static {
    FieldObject field = FieldObject.EMPTY;
    fieldTechnologicalProcesses = new ArrayList<>();
    fieldTechnologicalProcesses.add(
        new FieldCropTechnologicalProcessObject(1, field, cropTechnologicalProcesses.get(0),
            technologicalProcessStates.get(0)));
    fieldTechnologicalProcesses.add(
        new FieldCropTechnologicalProcessObject(2, field, cropTechnologicalProcesses.get(1),
            technologicalProcessStates.get(1)));
    fieldTechnologicalProcesses.add(
        new FieldCropTechnologicalProcessObject(3, field, cropTechnologicalProcesses.get(2),
            technologicalProcessStates.get(2)));
    fieldTechnologicalProcesses.add(
        new FieldCropTechnologicalProcessObject(4, field, cropTechnologicalProcesses.get(3),
            technologicalProcessStates.get(2)));
  }

  // Condition names
  private static ArrayList<ConditionNameObject> conditionNames;

  static {
    conditionNames = new ArrayList<>();
    conditionNames.add(new ConditionNameObject(1, "(T): Фаза вредного объекта"));
    conditionNames.add(new ConditionNameObject(2, "(T): Влажность почвы"));
    conditionNames.add(new ConditionNameObject(3, "(T): t⁰ почвы"));
    conditionNames.add(new ConditionNameObject(4, "(T): Планируемая урожайность, т/га"));
    conditionNames.add(new ConditionNameObject(5, "(T): Вредный объект"));
    conditionNames.add(new ConditionNameObject(6, "(T): t⁰ воздуха"));
    conditionNames.add(new ConditionNameObject(7, "(T): Влажность воздуха"));
    conditionNames.add(
        new ConditionNameObject(8, "(T): Направление обработки почвы, посева, опрыскивания"));
    conditionNames.add(new ConditionNameObject(9, "(T): Глубина обработки почвы, посева"));
  }

  // Condition types
  private static ArrayList<ConditionTypeObject> conditionTypes;

  static {
    conditionTypes = new ArrayList<>();
    conditionTypes.add(new ConditionTypeObject(1, "(T): Фаза вредного объекта"));
    conditionTypes.add(new ConditionTypeObject(2, "(T): Числовой диапазон"));
    conditionTypes.add(new ConditionTypeObject(3, "(T): Вредный объект"));
    conditionTypes.add(new ConditionTypeObject(4, "(T): Направление обработки"));
  }

  // Harmful object types
  private static ArrayList<HarmfulObjectTypeObject> harmfulObjectTypes;

  static {
    harmfulObjectTypes = new ArrayList<>();

    harmfulObjectTypes.add(new HarmfulObjectTypeObject(1, "(T): Сорняк"));
    harmfulObjectTypes.add(new HarmfulObjectTypeObject(2, "(T): Вредитель"));
    harmfulObjectTypes.add(new HarmfulObjectTypeObject(3, "(T): Болезнь"));
  }

  // Weeds
  private static ArrayList<WeedObject> weeds;

  static {
    weeds = new ArrayList<>();
    weeds.add(new WeedObject(1, "(T): Одногодичные ярые дводольные и злаковые сорняки",
        harmfulObjectTypes.get(0), new WeedNutritionTypeObject(1, "(T): Непаразит"),
        new WeedClassObject(1, "(T): Дводольные", 0, true),
        new WeedGroupObject(2, "(T): Одногодичные ярые", 1, true)));
  }

  // Conditions
  private static ArrayList<ConditionObject> conditions;

  static {
    conditions = new ArrayList<>();

    // HO phases
    HarmfulObjectPhaseConditionValueObject hoPhase =
        new HarmfulObjectPhaseConditionValueObject(1, conditionTypes.get(0),
            new HarmfulObjectPhaseObject(1, "(T): Белая ниточка"));

    // HO values
    HarmfulObjectConditionValueObject ho =
        new HarmfulObjectConditionValueObject(1, conditionTypes.get(2),
            new HarmfulObjectObject(1, harmfulObjectTypes.get(0), weeds.get(0)));

    // Span values
    SpanConditionValueObject span30_40 =
        new SpanConditionValueObject(1, conditionTypes.get(1), 30, 40);
    SpanConditionValueObject span8_10 =
        new SpanConditionValueObject(2, conditionTypes.get(1), 8, 10);
    SpanConditionValueObject span30_50 =
        new SpanConditionValueObject(3, conditionTypes.get(1), 30, 50);
    SpanConditionValueObject span2_4 = new SpanConditionValueObject(4, conditionTypes.get(1), 2, 4);

    // Tillage dir
    TillageDirectionConditionValueObject tillageDir =
        new TillageDirectionConditionValueObject(1, conditionTypes.get(3),
            new TillageDirectionObject(1, "(T): челноковый или диагональный"));

    ArrayList<BaseConditionValueObject> conditionValues = new ArrayList<>();

    conditions.add(
        new ConditionObject(1, 1, conditionNames.get(0), conditionTypes.get(0), hoPhase));
    conditions.add(
        new ConditionObject(2, 1, conditionNames.get(1), conditionTypes.get(1), span30_40));
    conditions.add(
        new ConditionObject(3, 1, conditionNames.get(2), conditionTypes.get(1), span8_10));
    conditions.add(
        new ConditionObject(4, 1, conditionNames.get(3), conditionTypes.get(1), span8_10));
    conditions.add(new ConditionObject(5, 1, conditionNames.get(4), conditionTypes.get(2), ho));
    conditions.add(
        new ConditionObject(6, 1, conditionNames.get(5), conditionTypes.get(1), span8_10));
    conditions.add(
        new ConditionObject(7, 1, conditionNames.get(6), conditionTypes.get(1), span30_50));
    conditions.add(
        new ConditionObject(8, 1, conditionNames.get(7), conditionTypes.get(3), tillageDir));
    conditions.add(
        new ConditionObject(9, 1, conditionNames.get(8), conditionTypes.get(1), span2_4));
  }

  // Technological process conditions
  private static ArrayList<TechnologicalProcessConditionObject> technologicalProcessConditions;

  static {
    technologicalProcessConditions = new ArrayList<>();

    technologicalProcessConditions.add(
        new TechnologicalProcessConditionObject(1, 1, cropTechnologicalProcesses.get(1),
            conditions.get(0)));
    technologicalProcessConditions.add(
        new TechnologicalProcessConditionObject(2, 1, cropTechnologicalProcesses.get(1),
            conditions.get(1)));
    technologicalProcessConditions.add(
        new TechnologicalProcessConditionObject(3, 1, cropTechnologicalProcesses.get(1),
            conditions.get(2)));
    technologicalProcessConditions.add(
        new TechnologicalProcessConditionObject(4, 1, cropTechnologicalProcesses.get(1),
            conditions.get(3)));
    technologicalProcessConditions.add(
        new TechnologicalProcessConditionObject(5, 1, cropTechnologicalProcesses.get(1),
            conditions.get(4)));
    technologicalProcessConditions.add(
        new TechnologicalProcessConditionObject(6, 1, cropTechnologicalProcesses.get(1),
            conditions.get(5)));
    technologicalProcessConditions.add(
        new TechnologicalProcessConditionObject(7, 1, cropTechnologicalProcesses.get(1),
            conditions.get(6)));
    technologicalProcessConditions.add(
        new TechnologicalProcessConditionObject(8, 1, cropTechnologicalProcesses.get(1),
            conditions.get(7)));
    technologicalProcessConditions.add(
        new TechnologicalProcessConditionObject(9, 1, cropTechnologicalProcesses.get(1),
            conditions.get(8)));
  }

  // Filed crop technological processes conditions
  private static ArrayList<FieldCropTechnologicalProcessConditionObject>
      fieldCropTechnologicalProcessSolutions;

  static {
    fieldCropTechnologicalProcessSolutions = new ArrayList<>();

    fieldCropTechnologicalProcessSolutions.add(
        new FieldCropTechnologicalProcessConditionObject(1, fieldTechnologicalProcesses.get(1),
            technologicalProcessConditions.get(0), false));
    fieldCropTechnologicalProcessSolutions.add(
        new FieldCropTechnologicalProcessConditionObject(2, fieldTechnologicalProcesses.get(1),
            technologicalProcessConditions.get(1), false));
    fieldCropTechnologicalProcessSolutions.add(
        new FieldCropTechnologicalProcessConditionObject(3, fieldTechnologicalProcesses.get(1),
            technologicalProcessConditions.get(2), false));
    fieldCropTechnologicalProcessSolutions.add(
        new FieldCropTechnologicalProcessConditionObject(4, fieldTechnologicalProcesses.get(1),
            technologicalProcessConditions.get(3), false));
    fieldCropTechnologicalProcessSolutions.add(
        new FieldCropTechnologicalProcessConditionObject(5, fieldTechnologicalProcesses.get(1),
            technologicalProcessConditions.get(4), false));
    fieldCropTechnologicalProcessSolutions.add(
        new FieldCropTechnologicalProcessConditionObject(6, fieldTechnologicalProcesses.get(1),
            technologicalProcessConditions.get(5), false));
    fieldCropTechnologicalProcessSolutions.add(
        new FieldCropTechnologicalProcessConditionObject(7, fieldTechnologicalProcesses.get(1),
            technologicalProcessConditions.get(6), false));
    fieldCropTechnologicalProcessSolutions.add(
        new FieldCropTechnologicalProcessConditionObject(8, fieldTechnologicalProcesses.get(1),
            technologicalProcessConditions.get(7), false));
    fieldCropTechnologicalProcessSolutions.add(
        new FieldCropTechnologicalProcessConditionObject(9, fieldTechnologicalProcesses.get(1),
            technologicalProcessConditions.get(8), false));
  }

  // Technological solutions
  private static ArrayList<TechnologicalSolutionObject> technologicalSolutions;

  static {
    TechnologicalSolutionTypeObject solutionType = technicalSolutionTypes.get(1);
    technologicalSolutions = new ArrayList<>();
    technologicalSolutions.add(
        new TechnologicalSolutionObject(1, solutionType, productSolutionValues.get(0)));
    technologicalSolutions.add(
        new TechnologicalSolutionObject(2, solutionType, productSolutionValues.get(1)));
    technologicalSolutions.add(
        new TechnologicalSolutionObject(3, solutionType, productSolutionValues.get(2)));
    technologicalSolutions.add(
        new TechnologicalSolutionObject(4, solutionType, productSolutionValues.get(3)));
  }

  // Technological process solutions
  private static ArrayList<FieldTechnologicalProcessSolutionObject> technologicalProcessSolutions;

  static {
    FieldCropTechnologicalProcessObject fieldCropProcess = fieldTechnologicalProcesses.get(1);
    technologicalProcessSolutions = new ArrayList<>();
    technologicalProcessSolutions.add(
        new FieldTechnologicalProcessSolutionObject(1, fieldCropProcess,
            technologicalSolutions.get(0)));
    technologicalProcessSolutions.add(
        new FieldTechnologicalProcessSolutionObject(2, fieldCropProcess,
            technologicalSolutions.get(1)));
    technologicalProcessSolutions.add(
        new FieldTechnologicalProcessSolutionObject(3, fieldCropProcess,
            technologicalSolutions.get(2)));
    technologicalProcessSolutions.add(
        new FieldTechnologicalProcessSolutionObject(4, fieldCropProcess,
            technologicalSolutions.get(3)));
  }

  ///////////////////////////////////////////////////////////////////////////
  // Methods
  ///////////////////////////////////////////////////////////////////////////

  public static ArrayList<BaseTechnologicalSolutionObject> getAggregates() {
    return aggregateSolutionValues;
  }

  public static ArrayList<BaseTechnologicalSolutionObject> getProducts() {
    return productSolutionValues;
  }

  public static ArrayList<BaseTechnologicalSolutionObject> getActiveComponents() {
    return activeComponentSolutionValues;
  }

  public static ArrayList<BaseTechnologicalSolutionObject> getInsects() {
    return insectSolutionValues;
  }

  public static ArrayList<TechnologicalProcessStateObject> getAllTechnologicalProcessStates() {
    return technologicalProcessStates;
  }

  public static ArrayList<FieldCropTechnologicalProcessObject> getFieldTechnologicalProcesses() {
    return fieldTechnologicalProcesses;
  }

  public static ArrayList<FieldTechnologicalProcessSolutionObject> getTechnologicalProcessSolutions() {
    return technologicalProcessSolutions;
  }

  public static ArrayList<TechnologicalSolutionTypeObject> getAllTechnologicalSolutionTypes() {
    return technicalSolutionTypes;
  }

  public static ArrayList<FieldCropTechnologicalProcessConditionObject> getFieldCropTechnologicalProcessConditions() {
    return fieldCropTechnologicalProcessSolutions;
  }
}
