package com.apps.twelve.floor.field.data.local.tables.solutions;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by Yaroslav on 30.05.2017.
 */

public class ProductsTable {

  @NonNull public static final String TABLE = "Products";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_NAME = "name";
  @NonNull public static final String COLUMN_TECHNOLOGICAL_SOLUTION_TYPE_ID =
      "technological_solution_type_id";
  @NonNull public static final String COLUMN_CATEGORY_ID = "category_id";
  @NonNull public static final String COLUMN_DOZE = "doze";
  @NonNull public static final String COLUMN_PRICE = "price";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public ProductsTable() {
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
        + COLUMN_TECHNOLOGICAL_SOLUTION_TYPE_ID
        + " TEXT NULL, "
        + COLUMN_CATEGORY_ID
        + " TEXT NULL, "
        + COLUMN_DOZE
        + " TEXT NULL, "
        + COLUMN_PRICE
        + " TEXT NULL "
        + ");";
  }
}
