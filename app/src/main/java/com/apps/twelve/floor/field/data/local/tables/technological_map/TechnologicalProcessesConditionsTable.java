package com.apps.twelve.floor.field.data.local.tables.technological_map;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by Yaroslav on 01.06.2017.
 */

public class TechnologicalProcessesConditionsTable {

  @NonNull public static final String TABLE = "TechnologicalProcessesConditions";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_CROP_TECH_PROCESS_ID = "crop_technological_process_id";
  @NonNull public static final String COLUMN_CONDITION_ID = "condition_id";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public TechnologicalProcessesConditionsTable() {
    throw new IllegalStateException("No instances allowed");
  }

  @NonNull public static String getCreateTableQuery() {
    return "CREATE TABLE IF NOT EXISTS "
        + TABLE
        + " ("
        + COLUMN_ID
        + " INTEGER NOT NULL PRIMARY KEY, "
        + COLUMN_CROP_TECH_PROCESS_ID
        + " TEXT NULL, "
        + COLUMN_CONDITION_ID
        + " TEXT NULL "
        + ");";
  }
}
