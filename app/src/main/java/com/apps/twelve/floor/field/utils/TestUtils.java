package com.apps.twelve.floor.field.utils;

import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.data.local.objects.CropObject;
import com.apps.twelve.floor.field.data.local.objects.FieldObject;
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
import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessObject;
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
    technicalSolutionTypes.add(new TechnologicalSolutionTypeObject(1, "ТЕСТ: Агрегат"));
    technicalSolutionTypes.add(new TechnologicalSolutionTypeObject(2, "ТЕСТ: Препарат"));
    technicalSolutionTypes.add(
        new TechnologicalSolutionTypeObject(3, "ТЕСТ: Действующее вещество"));
    technicalSolutionTypes.add(new TechnologicalSolutionTypeObject(4, "ТЕСТ: Насекомое"));
  }

  // Aggregates
  private static ArrayList<BaseTechnologicalSolutionObject> aggregateSolutionValues;

  static {
    TechnologicalSolutionTypeObject aggregateSolutionType = technicalSolutionTypes.get(0);

    aggregateSolutionValues = new ArrayList<>();
    aggregateSolutionValues.add(
        new AggregateObject(1, "ТЕСТ: Легкая борона", aggregateSolutionType, 3000));
    aggregateSolutionValues.add(
        new AggregateObject(2, "ТЕСТ: Тяжелая борона", aggregateSolutionType, 3000));
    aggregateSolutionValues.add(
        new AggregateObject(3, "ТЕСТ: Севалка", aggregateSolutionType, 6000));
    aggregateSolutionValues.add(
        new AggregateObject(4, "ТЕСТ: Комбайн", aggregateSolutionType, 150000));
  }

  // Product categories
  private static ArrayList<ProductCategoryObject> productCategories;

  static {
    productCategories = new ArrayList<>();
    productCategories.add(new ProductCategoryObject(1, "ТЕСТ: Гербицид"));
  }

  // Products
  private static ArrayList<BaseTechnologicalSolutionObject> productSolutionValues;

  static {
    productSolutionValues = new ArrayList<>();

    TechnologicalSolutionTypeObject productSolutionType = technicalSolutionTypes.get(1);
    ProductCategoryObject herbicideProductCategory = productCategories.get(0);

    productSolutionValues.add(
        new ProductObject(1, "ТЕСТ: Ратник", productSolutionType, 300, herbicideProductCategory));
    productSolutionValues.add(
        new ProductObject(2, "ТЕСТ: Рипиус", productSolutionType, 200, herbicideProductCategory));
    productSolutionValues.add(
        new ProductObject(3, "ТЕСТ: Сатурн", productSolutionType, 150, herbicideProductCategory));
    productSolutionValues.add(
        new ProductObject(4, "ТЕСТ: Скат", productSolutionType, 480, herbicideProductCategory));
  }

  // Active components
  private static ArrayList<BaseTechnologicalSolutionObject> activeComponentSolutionValues;

  static {
    activeComponentSolutionValues = new ArrayList<>();

    TechnologicalSolutionTypeObject activeComponentSolutionType = technicalSolutionTypes.get(2);

    activeComponentSolutionValues.add(
        new ActiveComponentObject(1, "ТЕСТ: Ципроконазол", activeComponentSolutionType));
    activeComponentSolutionValues.add(
        new ActiveComponentObject(2, "ТЕСТ: S-метолахлор", activeComponentSolutionType));
    activeComponentSolutionValues.add(
        new ActiveComponentObject(3, "ТЕСТ: Тербутилазин", activeComponentSolutionType));
    activeComponentSolutionValues.add(
        new ActiveComponentObject(4, "ТЕСТ: Метазахлор", activeComponentSolutionType));
  }

  // Insects
  private static ArrayList<BaseTechnologicalSolutionObject> insectSolutionValues;

  static {
    insectSolutionValues = new ArrayList<>();

    TechnologicalSolutionTypeObject insectSolutionType = technicalSolutionTypes.get(3);

    new InsectObject(1, "Огневковая раса трихограммы", insectSolutionType, 150);
  }

  // Tecnological process states
  private static ArrayList<TechnologicalProcessStateObject> technologicalProcessStates;

  static {
    technologicalProcessStates = new ArrayList<>();

    technologicalProcessStates.add(
        new TechnologicalProcessStateObject(1, "ТЕСТ: Выполнен", R.drawable.ic_done_24dp));
    technologicalProcessStates.add(
        new TechnologicalProcessStateObject(2, "ТЕСТ: Актуален", R.drawable.ic_actual_24dp));
    technologicalProcessStates.add(
        new TechnologicalProcessStateObject(3, "ТЕСТ: Запланирован", R.drawable.ic_future_24dp));
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
        new CropTechnologicalProcessObject(1, "ТЕСТ: Посев", 1, crop, climateZone, phase,
            processPeriods.get(0)));
    cropTechnologicalProcesses.add(
        new CropTechnologicalProcessObject(2, "ТЕСТ: Гербицидная обработка", 2, crop, climateZone,
            phase, processPeriods.get(1)));
    cropTechnologicalProcesses.add(
        new CropTechnologicalProcessObject(3, "ТЕСТ: Инсектицидная обработка", 3, crop, climateZone,
            phase, processPeriods.get(2)));
    cropTechnologicalProcesses.add(
        new CropTechnologicalProcessObject(4, "ТЕСТ: Сбор урожая", 4, crop, climateZone, phase,
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
}
