package com.apps.twelve.floor.field.data.local.tables.solutions;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by yarrick on 06.07.17.
 */

public class ActiveComponentsInProductsTable {

  @NonNull public static final String TABLE = "ActiveComponentsInProducts";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_PRODUCT_ID = "product_id";
  @NonNull public static final String COLUMN_ACTIVE_COMPONENT_ID = "active_component_id";
  @NonNull public static final String COLUMN_DOZE = "doze";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public ActiveComponentsInProductsTable() {
    throw new IllegalStateException("No instances allowed");
  }

  @NonNull public static String getCreateTableQuery() {
    return "CREATE TABLE IF NOT EXISTS "
        + TABLE
        + " ("
        + COLUMN_ID
        + " INTEGER NOT NULL PRIMARY KEY, "
        + COLUMN_PRODUCT_ID
        + " INTEGER, "
        + COLUMN_ACTIVE_COMPONENT_ID
        + " INTEGER, "
        + COLUMN_DOZE
        + " TEXT NULL "
        + ");";
  }
}
