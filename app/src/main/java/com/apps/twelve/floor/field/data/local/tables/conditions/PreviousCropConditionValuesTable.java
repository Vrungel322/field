package com.apps.twelve.floor.field.data.local.tables.conditions;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by yarrick on 22.07.17.
 */
public class PreviousCropConditionValuesTable {

  @NonNull public static final String TABLE = "PreviousCropValues";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_CONDITION_TYPE_ID = "condition_type_id";
  @NonNull public static final String COLUMN_CROP_ID = "crop_id";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public PreviousCropConditionValuesTable() {
    throw new IllegalStateException("No instances allowed");
  }

  @NonNull public static String getCreateTableQuery() {
    return "CREATE TABLE IF NOT EXISTS "
        + TABLE
        + " ("
        + COLUMN_ID
        + " INTEGER NOT NULL PRIMARY KEY, "
        + COLUMN_CONDITION_TYPE_ID
        + " INTEGER, "
        + COLUMN_CROP_ID
        + " INTEGER "
        + ");";
  }
}
