package com.apps.twelve.floor.field.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.apps.twelve.floor.field.data.local.tables.AggregatesTable;
import com.apps.twelve.floor.field.data.local.tables.ClimateZonesTable;
import com.apps.twelve.floor.field.data.local.tables.ConditionSpanValuesTable;
import com.apps.twelve.floor.field.data.local.tables.ConditionTypesTable;
import com.apps.twelve.floor.field.data.local.tables.ConditionsTable;
import com.apps.twelve.floor.field.data.local.tables.CropsTable;
import com.apps.twelve.floor.field.data.local.tables.DealersTable;
import com.apps.twelve.floor.field.data.local.tables.FieldCropTechnologicalProcessesTable;
import com.apps.twelve.floor.field.data.local.tables.FieldTechnologicalProcessSolutionsTable;
import com.apps.twelve.floor.field.data.local.tables.FieldsTable;
import com.apps.twelve.floor.field.data.local.tables.PestPhasesTable;
import com.apps.twelve.floor.field.data.local.tables.PestsTable;
import com.apps.twelve.floor.field.data.local.tables.PhasesTable;
import com.apps.twelve.floor.field.data.local.tables.PhenologicalCharacteristicsTable;
import com.apps.twelve.floor.field.data.local.tables.ProcessPeriodsTable;
import com.apps.twelve.floor.field.data.local.tables.ProductCategoriesTable;
import com.apps.twelve.floor.field.data.local.tables.ProductsPestsCropsTable;
import com.apps.twelve.floor.field.data.local.tables.ProductsTable;
import com.apps.twelve.floor.field.data.local.tables.SoilTypesTable;
import com.apps.twelve.floor.field.data.local.tables.TechnologicalProcessStatesTable;
import com.apps.twelve.floor.field.data.local.tables.TechnologicalSolutionTypesTable;
import com.apps.twelve.floor.field.data.local.tables.TillageDirectionsTable;

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
    db.execSQL(FieldsTable.getCreateTableQuery()); // create table for Fields
    db.execSQL(CropsTable.getCreateTableQuery()); // create table for Crops
    db.execSQL(ClimateZonesTable.getCreateTableQuery()); // create table for ClimateZones
    db.execSQL(PhasesTable.getCreateTableQuery()); // create table for Phases
    db.execSQL(PestsTable.getCreateTableQuery()); // create table for Pests
    db.execSQL(
        TechnologicalProcessStatesTable.getCreateTableQuery()); // create table for TechnologicalProcessStates
    db.execSQL(
        TechnologicalSolutionTypesTable.getCreateTableQuery()); // create table for TechnologicalSolutionTypes
    db.execSQL(ProductCategoriesTable.getCreateTableQuery()); // create table for ProductCategories
    db.execSQL(ProductsTable.getCreateTableQuery()); // create table for Products
    db.execSQL(AggregatesTable.getCreateTableQuery()); // create table for Aggregates
    db.execSQL(ProcessPeriodsTable.getCreateTableQuery()); // create table for ProcessPeriods
    db.execSQL(ConditionTypesTable.getCreateTableQuery()); // create table for ConditionTypes
    db.execSQL(
        ConditionSpanValuesTable.getCreateTableQuery()); // create table for ConditionSpanValues
    db.execSQL(SoilTypesTable.getCreateTableQuery()); // create table for SoilTypes
    db.execSQL(PestPhasesTable.getCreateTableQuery()); // create table for PestPhases
    db.execSQL(TillageDirectionsTable.getCreateTableQuery()); // create table for TillageDirections
    db.execSQL(
        PhenologicalCharacteristicsTable.getCreateTableQuery()); // create table for PhenologicalCharacteristics
    db.execSQL(ConditionsTable.getCreateTableQuery()); // create table for Conditions
    db.execSQL(DealersTable.getCreateTableQuery()); // create table for Dealers
    db.execSQL(
        FieldCropTechnologicalProcessesTable.getCreateTableQuery()); // create table for FieldCropTechnologicalProcesses
    db.execSQL(
        ProductsPestsCropsTable.getCreateTableQuery()); // create table for ProductsPestsCrops
    db.execSQL(
        FieldTechnologicalProcessSolutionsTable.getCreateTableQuery()); // create table for FieldTechnologicalProcessSolutions
  }
}
