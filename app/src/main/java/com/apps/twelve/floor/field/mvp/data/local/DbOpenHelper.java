package com.apps.twelve.floor.field.mvp.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.apps.twelve.floor.field.mvp.data.local.tables.ClimateZonesTable;
import com.apps.twelve.floor.field.mvp.data.local.tables.CropsTable;
import com.apps.twelve.floor.field.mvp.data.local.tables.FieldsTable;
import com.apps.twelve.floor.field.mvp.data.local.tables.PestsTable;
import com.apps.twelve.floor.field.mvp.data.local.tables.PhasesTable;

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
  }
}
