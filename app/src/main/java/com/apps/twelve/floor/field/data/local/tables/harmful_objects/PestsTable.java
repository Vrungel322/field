package com.apps.twelve.floor.field.data.local.tables.harmful_objects;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by Yaroslav on 10.05.2017.
 */

public class PestsTable {

  @NonNull public static final String TABLE = "Pests";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_HARMFUL_OBJ_TYPE_ID = "harmful_obj_type_id";
  @NonNull public static final String COLUMN_NAME = "name";
  @NonNull public static final String COLUMN_CLASS_ID = "class_id";
  @NonNull public static final String COLUMN_ORDER_ID = "order_id";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public PestsTable() {
    throw new IllegalStateException("No instances allowed");
  }

  @NonNull public static String getCreateTableQuery() {
    return "CREATE TABLE IF NOT EXISTS "
        + TABLE
        + " ("
        + COLUMN_ID
        + " INTEGER NOT NULL PRIMARY KEY, "
        + COLUMN_HARMFUL_OBJ_TYPE_ID
        + " INTEGER, "
        + COLUMN_NAME
        + " TEXT NULL, "
        + COLUMN_CLASS_ID
        + " INTEGER, "
        + COLUMN_ORDER_ID
        + " INTEGER "
        + ");";
  }
}
