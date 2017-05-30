package com.apps.twelve.floor.field.data.local.tables;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by Yaroslav on 30.05.2017.
 */

public class PestPhasesTable {

  @NonNull public static final String TABLE = "PestPhases";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_NAME = "name";
  @NonNull public static final String COLUMN_CONDITION_TYPE_ID = "condition_type_id";
  @NonNull public static final String COLUMN_PEST_ID = "pest_id";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public PestPhasesTable() {
    throw new IllegalStateException("No instances allowed");
  }

  @NonNull public static String getCreateTableQuery() {
    return "CREATE TABLE IF NOT EXISTS "
        + TABLE
        + " ("
        + COLUMN_ID
        + " INTEGER NOT NULL PRIMARY KEY, "
        + COLUMN_NAME
        + " TEXT NULL, "
        + COLUMN_CONDITION_TYPE_ID
        + " TEXT NULL, "
        + COLUMN_PEST_ID
        + " TEXT NULL "
        + ");";
  }
}
