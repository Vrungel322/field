package com.apps.twelve.floor.field.data.local.tables.conditions;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by Yaroslav on 30.05.2017.
 */

public class ConditionSpanValuesTable {

  @NonNull public static final String TABLE = "ConditionSpanValues";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_CONDITION_TYPE_ID = "condition_type_id";
  @NonNull public static final String COLUMN_VALUE_FROM = "value_from";
  @NonNull public static final String COLUMN_VALUE_TO = "value_to";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public ConditionSpanValuesTable() {
    throw new IllegalStateException("No instances allowed");
  }

  @NonNull public static String getCreateTableQuery() {
    return "CREATE TABLE IF NOT EXISTS "
        + TABLE
        + " ("
        + COLUMN_ID
        + " INTEGER NOT NULL PRIMARY KEY, "
        + COLUMN_CONDITION_TYPE_ID
        + " TEXT NULL, "
        + COLUMN_VALUE_FROM
        + " TEXT NULL, "
        + COLUMN_VALUE_TO
        + " TEXT NULL "
        + ");";
  }
}
