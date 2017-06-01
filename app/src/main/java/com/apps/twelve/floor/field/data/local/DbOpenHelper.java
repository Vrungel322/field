package com.apps.twelve.floor.field.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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
    // for Fields
    db.execSQL(FieldsTable.getCreateTableQuery());
    // for Crops
    db.execSQL(CropsTable.getCreateTableQuery());
    // for ClimateZones
    db.execSQL(ClimateZonesTable.getCreateTableQuery());
    // for Phases
    db.execSQL(PhasesTable.getCreateTableQuery());
    // for Pests
    db.execSQL(PestsTable.getCreateTableQuery());
    // for TechnologicalProcessStates
    db.execSQL(TechnologicalProcessStatesTable.getCreateTableQuery());
    // for TechnologicalSolutionTypes
    db.execSQL(TechnologicalSolutionTypesTable.getCreateTableQuery());
    // for ProductCategories
    db.execSQL(ProductCategoriesTable.getCreateTableQuery());
    // for Products
    db.execSQL(ProductsTable.getCreateTableQuery());
    // for Aggregates
    db.execSQL(AggregatesTable.getCreateTableQuery());
    // for ProcessPeriods
    db.execSQL(ProcessPeriodsTable.getCreateTableQuery());
    // for ConditionTypes
    db.execSQL(ConditionTypesTable.getCreateTableQuery());
    //for ConditionSpanValues
    db.execSQL(ConditionSpanValuesTable.getCreateTableQuery());
    // for SoilTypes
    db.execSQL(SoilTypesTable.getCreateTableQuery());
    // for PestPhases
    db.execSQL(PestPhasesTable.getCreateTableQuery());
    // for TillageDirections
    db.execSQL(TillageDirectionsTable.getCreateTableQuery());
    // for PhenologicalCharacteristics
    db.execSQL(PhenologicalCharacteristicsTable.getCreateTableQuery());
    // for Conditions
    db.execSQL(ConditionsTable.getCreateTableQuery());
    // for Dealers
    db.execSQL(DealersTable.getCreateTableQuery());
    // for FieldCropTechnologicalProcesses
    db.execSQL(FieldCropTechnologicalProcessesTable.getCreateTableQuery());
    // for ProductsPestsCrops
    db.execSQL(ProductsPestsCropsTable.getCreateTableQuery());
    // for FieldTechnologicalProcessSolutions
    db.execSQL(FieldTechnologicalProcessSolutionsTable.getCreateTableQuery());
    // for TechnologicalProcessesConditions
    db.execSQL(TechnologicalProcessesConditionsTable.getCreateTableQuery());
  }
}
