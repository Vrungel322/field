package com.apps.twelve.floor.field.data.local.tables.conditions;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by yarrick on 07.07.17.
 */

public class PhenologicalCharacteristicValuesTable {

  @NonNull public static final String TABLE = "PhenologicalCharacteristicValues";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_CONDITION_TYPE_ID = "condition_type_id";
  @NonNull public static final String COLUMN_PHENOLOGICAL_CHARACTERISTIC_ID =
      "phenological_characteristic_id";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public PhenologicalCharacteristicValuesTable() {
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
        + COLUMN_PHENOLOGICAL_CHARACTERISTIC_ID
        + " INTEGER "
        + ");";
  }
}
