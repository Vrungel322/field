package com.apps.twelve.floor.field.data.local.tables.conditions;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by yarrick on 04.07.17.
 */

public class HarmfulObjectTypesTable {

  @NonNull public static final String TABLE = "HarmfulObjectTypes";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_NAME = "name";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public HarmfulObjectTypesTable() {
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
        + ");";
  }
}
