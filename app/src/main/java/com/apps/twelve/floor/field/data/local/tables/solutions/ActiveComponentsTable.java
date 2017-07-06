package com.apps.twelve.floor.field.data.local.tables.solutions;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by yarrick on 06.07.17.
 */

public class ActiveComponentsTable {

  @NonNull public static final String TABLE = "ActiveComponents";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_TECHNOLOGICAL_SOLUTION_TYPE_ID = "solution_type_id";
  @NonNull public static final String COLUMN_NAME = "name";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public ActiveComponentsTable() {
    throw new IllegalStateException("No instances allowed");
  }

  @NonNull public static String getCreateTableQuery() {
    return "CREATE TABLE IF NOT EXISTS "
        + TABLE
        + " ("
        + COLUMN_ID
        + " INTEGER NOT NULL PRIMARY KEY, "
        + COLUMN_TECHNOLOGICAL_SOLUTION_TYPE_ID
        + " INTEGER, "
        + COLUMN_NAME
        + " TEXT NULL "
        + ");";
  }
}
