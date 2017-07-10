package com.apps.twelve.floor.field.data.local.tables.harmful_objects;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by yarrick on 10.07.17.
 */

public class PestOrdersTable {

  @NonNull public static final String TABLE = "PestOrders";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_NAME = "name";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public PestOrdersTable() {
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
