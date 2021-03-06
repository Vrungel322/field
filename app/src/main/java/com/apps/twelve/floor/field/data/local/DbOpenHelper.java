package com.apps.twelve.floor.field.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.apps.twelve.floor.field.data.local.tables.CropsActiveComponentsHarmfulObjectsTable;
import com.apps.twelve.floor.field.data.local.tables.CropsTable;
import com.apps.twelve.floor.field.data.local.tables.DealersTable;
import com.apps.twelve.floor.field.data.local.tables.FieldsTable;
import com.apps.twelve.floor.field.data.local.tables.PhenologicalCharacteristicsTable;
import com.apps.twelve.floor.field.data.local.tables.SoilTypesTable;
import com.apps.twelve.floor.field.data.local.tables.TillageDirectionsTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.ConditionNamesTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.ConditionTypesTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.ConditionsTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.HarmfulObjectConditionValuesTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.HarmfulObjectPhaseConditionValuesTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.PhenologicalCharacteristicConditionValuesTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.PreviousCropConditionValuesTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.SoilTypeConditionValuesTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.SpanConditionValuesTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.TillageDirectionConditionValuesTable;
import com.apps.twelve.floor.field.data.local.tables.harmful_objects.DiseasePathogenTypesTable;
import com.apps.twelve.floor.field.data.local.tables.harmful_objects.DiseasesTable;
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
import com.apps.twelve.floor.field.data.local.tables.solutions.ActiveComponentsInProductsTable;
import com.apps.twelve.floor.field.data.local.tables.solutions.ActiveComponentsTable;
import com.apps.twelve.floor.field.data.local.tables.solutions.AggregatesTable;
import com.apps.twelve.floor.field.data.local.tables.solutions.FieldTechnologicalProcessSolutionsTable;
import com.apps.twelve.floor.field.data.local.tables.solutions.InsectsTable;
import com.apps.twelve.floor.field.data.local.tables.solutions.ProductCategoriesTable;
import com.apps.twelve.floor.field.data.local.tables.solutions.ProductsTable;
import com.apps.twelve.floor.field.data.local.tables.solutions.TechnologicalSolutionTypesTable;
import com.apps.twelve.floor.field.data.local.tables.solutions.TechnologicalSolutionsTable;
import com.apps.twelve.floor.field.data.local.tables.technological_map.CropTechnologicalProcessesSequencesTable;
import com.apps.twelve.floor.field.data.local.tables.technological_map.CropTechnologicalProcessesTable;
import com.apps.twelve.floor.field.data.local.tables.technological_map.FieldCropTechnologicalProcessesTable;
import com.apps.twelve.floor.field.data.local.tables.technological_map.TechnologicalProcessStatesTable;
import com.apps.twelve.floor.field.data.local.tables.technological_map.TechnologicalProcessesConditionsTable;

/**
 * Created by Yaroslav on 11.04.2017.
 */

public class DbOpenHelper extends SQLiteOpenHelper {

  public static final String DB_NAME = "db_field";
  public static final int DB_VERSION = 1;

  public DbOpenHelper(Context context) {
    super(context, DB_NAME, null, DB_VERSION);
  }

  @Override public void onCreate(SQLiteDatabase db) {
    createDbTables(db);
  }

  @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

  }

  private void createDbTables(SQLiteDatabase db) {
    createConditionsTables(db);
    createHarmfulObjectsTables(db);
    createProcessTimeTables(db);
    createSolutionsTables(db);
    createTechnologicalMapTables(db);
    createOtherTables(db);
  }

  private void createConditionsTables(SQLiteDatabase db) {
    // ConditionSpanValues
    db.execSQL(SpanConditionValuesTable.getCreateTableQuery());
    // Conditions
    db.execSQL(ConditionsTable.getCreateTableQuery());
    // ConditionTypes
    db.execSQL(ConditionTypesTable.getCreateTableQuery());
    // PhenologicalCharacteristicValues
    db.execSQL(PhenologicalCharacteristicConditionValuesTable.getCreateTableQuery());
    // SoilTypeValues
    db.execSQL(SoilTypeConditionValuesTable.getCreateTableQuery());
    // TillageDirectionValues
    db.execSQL(TillageDirectionConditionValuesTable.getCreateTableQuery());
    // ConditionNames
    db.execSQL(ConditionNamesTable.getCreateTableQuery());
    // HarmfulObjectValues
    db.execSQL(HarmfulObjectConditionValuesTable.getCreateTableQuery());
    // HarmfulObjectPhaseValues
    db.execSQL(HarmfulObjectPhaseConditionValuesTable.getCreateTableQuery());
    // PreviousCropValues
    db.execSQL(PreviousCropConditionValuesTable.getCreateTableQuery());
  }

  private void createHarmfulObjectsTables(SQLiteDatabase db) {
    // HarmfulObjectTypes
    db.execSQL(HarmfulObjectTypesTable.getCreateTableQuery());
    // HarmfulObjects
    db.execSQL(HarmfulObjectsTable.getCreateTableQuery());
    // HarmfulObjectPhases
    db.execSQL(HarmfulObjectPhasesTable.getCreateTableQuery());
    // PestClasses
    db.execSQL(PestClassesTable.getCreateTableQuery());
    // PestOrders
    db.execSQL(PestOrdersTable.getCreateTableQuery());
    // Pests
    db.execSQL(PestsTable.getCreateTableQuery());
    // WeedNutritionTypes
    db.execSQL(WeedNutritionTypesTable.getCreateTableQuery());
    // WeedClasses
    db.execSQL(WeedClassesTable.getCreateTableQuery());
    // WeedGroups
    db.execSQL(WeedGroupsTable.getCreateTableQuery());
    // Weeds
    db.execSQL(WeedsTable.getCreateTableQuery());
    // DiseasePathogenTypes
    db.execSQL(DiseasePathogenTypesTable.getCreateTableQuery());
    // Diseases
    db.execSQL(DiseasesTable.getCreateTableQuery());
  }

  private void createProcessTimeTables(SQLiteDatabase db) {
    // ClimateZones
    db.execSQL(ClimateZonesTable.getCreateTableQuery());
    // Phases
    db.execSQL(PhasesTable.getCreateTableQuery());
    // ProcessPeriods
    db.execSQL(ProcessPeriodsTable.getCreateTableQuery());
  }

  private void createSolutionsTables(SQLiteDatabase db) {
    // Aggregates
    db.execSQL(AggregatesTable.getCreateTableQuery());
    // Insects
    db.execSQL(InsectsTable.getCreateTableQuery());
    // ActiveComponents
    db.execSQL(ActiveComponentsTable.getCreateTableQuery());
    // FieldTechnologicalProcessSolutions
    db.execSQL(FieldTechnologicalProcessSolutionsTable.getCreateTableQuery());
    // ProductCategories
    db.execSQL(ProductCategoriesTable.getCreateTableQuery());
    // Products
    db.execSQL(ProductsTable.getCreateTableQuery());
    // TechnologicalSolutionTypes
    db.execSQL(TechnologicalSolutionTypesTable.getCreateTableQuery());
    // TechnologicalSolutions
    db.execSQL(TechnologicalSolutionsTable.getCreateTableQuery());
    // ActiveComponentsInProducts
    db.execSQL(ActiveComponentsInProductsTable.getCreateTableQuery());
  }

  private void createTechnologicalMapTables(SQLiteDatabase db) {
    // FieldCropTechnologicalProcesses
    db.execSQL(FieldCropTechnologicalProcessesTable.getCreateTableQuery());
    // CropTechnologicalProcesses
    db.execSQL(CropTechnologicalProcessesTable.getCreateTableQuery());
    // CropTechnologicalProcessesSequencesTable
    db.execSQL(CropTechnologicalProcessesSequencesTable.getCreateTableQuery());
    // TechnologicalProcessesConditions
    db.execSQL(TechnologicalProcessesConditionsTable.getCreateTableQuery());
    // TechnologicalProcessStates
    db.execSQL(TechnologicalProcessStatesTable.getCreateTableQuery());
  }

  private void createOtherTables(SQLiteDatabase db) {
    // Fields
    db.execSQL(FieldsTable.getCreateTableQuery());
    // Crops
    db.execSQL(CropsTable.getCreateTableQuery());
    // Dealers
    db.execSQL(DealersTable.getCreateTableQuery());
    // CropsActiveComponentsHarmfulObjects
    db.execSQL(CropsActiveComponentsHarmfulObjectsTable.getCreateTableQuery());
    // TillageDirections
    db.execSQL(TillageDirectionsTable.getCreateTableQuery());
    // PhenologicalCharacteristics
    db.execSQL(PhenologicalCharacteristicsTable.getCreateTableQuery());
    // SoilTypes
    db.execSQL(SoilTypesTable.getCreateTableQuery());
  }
}
