package com.apps.twelve.floor.field.data.local.tables.technological_map;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by yarrick on 16.08.17.
 */

public class FieldCropTechnologicalProcessesConditionsTable {

  @NonNull public static final String TABLE = "FieldCropTechnologicalProcessesConditions";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_PROCESS_ID = "field_crop_technological_process_id";
  @NonNull public static final String COLUMN_CONDITION_ID = "technological_process_condition_id";
  @NonNull public static final String COLUMN_IS_FULFILLED = "is_fulfilled";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public FieldCropTechnologicalProcessesConditionsTable() {
    throw new IllegalStateException("No instances allowed");
  }

  @NonNull public static String getCreateTableQuery() {
    return "CREATE TABLE IF NOT EXISTS "
        + TABLE
        + " ("
        + COLUMN_ID
        + " INTEGER NOT NULL PRIMARY KEY, "
        + COLUMN_PROCESS_ID
        + " INTEGER, "
        + COLUMN_CONDITION_ID
        + " INTEGER, "
        + COLUMN_IS_FULFILLED
        + " INTEGER "
        + ");";
  }
}
