package com.apps.twelve.floor.field.data.local.tables.technological_map;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by Yaroslav on 31.05.2017.
 */

public class FieldCropTechnologicalProcessesTable {

  @NonNull public static final String TABLE = "FieldCropTechnologicalProcesses";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_FIELD_ID = "field_id";
  @NonNull public static final String COLUMN_CROP_TECH_PROCESS_ID = "process_id";
  @NonNull public static final String COLUMN_TECH_PROCESS_STATE_ID = "state_id";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public FieldCropTechnologicalProcessesTable() {
    throw new IllegalStateException("No instances allowed");
  }

  @NonNull public static String getCreateTableQuery() {
    return "CREATE TABLE IF NOT EXISTS "
        + TABLE
        + " ("
        + COLUMN_ID
        + " INTEGER NOT NULL PRIMARY KEY, "
        + COLUMN_FIELD_ID + " INTEGER, "
        + COLUMN_CROP_TECH_PROCESS_ID + " INTEGER, "
        + COLUMN_TECH_PROCESS_STATE_ID + " INTEGER "
        + ");";
  }

  public static Query getDataByFieldIdQuery(Long fieldId) {
    return Query.builder().table(TABLE).where(COLUMN_FIELD_ID).whereArgs(fieldId).build();
  }
}
