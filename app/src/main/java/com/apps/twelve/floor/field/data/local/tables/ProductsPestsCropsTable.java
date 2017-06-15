package com.apps.twelve.floor.field.data.local.tables;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by Yaroslav on 31.05.2017.
 */

public class ProductsPestsCropsTable {

  @NonNull public static final String TABLE = "ProductsPestsCrops";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_PRODUCT_ID = "product_id";
  @NonNull public static final String COLUMN_PEST_ID = "pest_id";
  @NonNull public static final String COLUMN_CROP_ID = "crop_id";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public ProductsPestsCropsTable() {
    throw new IllegalStateException("No instances allowed");
  }

  @NonNull public static String getCreateTableQuery() {
    return "CREATE TABLE IF NOT EXISTS "
        + TABLE
        + " ("
        + COLUMN_ID
        + " INTEGER NOT NULL PRIMARY KEY, "
        + COLUMN_PRODUCT_ID + " INTEGER, "
        + COLUMN_PEST_ID + " INTEGER, "
        + COLUMN_CROP_ID + " INTEGER "
        + ");";
  }
}
