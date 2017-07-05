package com.apps.twelve.floor.field.data.local.tables.conditions;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by yarrick on 05.07.17.
 */

public class HarmfulObjectsTable {

  @NonNull public static final String TABLE = "HarmfulObjects";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_TYPE_ID = "type_id";
  @NonNull public static final String COLUMN_VALUE_ID = "value_id";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public HarmfulObjectsTable() {
    throw new IllegalStateException("No instances allowed");
  }

  @NonNull public static String getCreateTableQuery() {
    return "CREATE TABLE IF NOT EXISTS "
        + TABLE
        + " ("
        + COLUMN_ID
        + " INTEGER NOT NULL PRIMARY KEY, "
        + COLUMN_TYPE_ID
        + " INTEGER, "
        + COLUMN_VALUE_ID
        + " INTEGER "
        + ");";
  }
}
