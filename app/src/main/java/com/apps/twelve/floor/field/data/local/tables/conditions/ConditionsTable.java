package com.apps.twelve.floor.field.data.local.tables.conditions;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by Yaroslav on 30.05.2017.
 */

public class ConditionsTable {

  @NonNull public static final String TABLE = "Conditions";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_CROP_NAME = "name";
  @NonNull public static final String COLUMN_PRIORITY = "priority";
  @NonNull public static final String COLUMN_CONDITION_TYPE_ID = "condition_type_id";
  @NonNull public static final String COLUMN_CONDITION_VALUE_ID = "condition_value_id";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public ConditionsTable() {
    throw new IllegalStateException("No instances allowed");
  }

  @NonNull public static String getCreateTableQuery() {
    return "CREATE TABLE IF NOT EXISTS "
        + TABLE
        + " ("
        + COLUMN_ID
        + " INTEGER NOT NULL PRIMARY KEY, "
        + COLUMN_CROP_NAME
        + " TEXT, "
        + COLUMN_PRIORITY
        + " TEXT NULL, "
        + COLUMN_CONDITION_TYPE_ID
        + " INTEGER, "
        + COLUMN_CONDITION_VALUE_ID
        + " INTEGER "
        + ");";
  }
}
