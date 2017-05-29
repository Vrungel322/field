package com.apps.twelve.floor.field.data.local.tables;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by Yaroslav on 11.05.2017.
 */

public class CropTechnologicalProcessesTable {

  @NonNull public static final String TABLE = "CropTechnologicalProcesses";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_NAME = "name";
  @NonNull public static final String COLUMN_ORDER = "order";
  @NonNull public static final String COLUMN_CROP_ID = "crop_id";
  @NonNull public static final String COLUMN_TECH_PROC_TIME_ID = "tech_process_time_id";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public CropTechnologicalProcessesTable() {
    throw new IllegalStateException("No instances allowed");
  }

  @NonNull public static String getCreateTableQuery() {
    return "CREATE TABLE IF NOT EXISTS "
        + TABLE
        + " ("
        + COLUMN_ID
        + " INTEGER NOT NULL PRIMARY KEY, "
        + COLUMN_NAME
        + " TEXT NULL "
        + COLUMN_ORDER
        + " TEXT NULL, "
        + COLUMN_CROP_ID
        + " TEXT NULL, "
        + COLUMN_TECH_PROC_TIME_ID
        + " TEXT NULL "
        + ");";
  }
}
