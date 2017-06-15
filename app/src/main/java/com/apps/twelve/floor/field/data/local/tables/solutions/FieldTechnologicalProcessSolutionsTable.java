package com.apps.twelve.floor.field.data.local.tables.solutions;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by Yaroslav on 31.05.2017.
 */

public class FieldTechnologicalProcessSolutionsTable {

  @NonNull public static final String TABLE = "FieldTechnologicalProcessSolutions";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_FIELD_TECH_PROCESS_ID = "process_id";
  @NonNull public static final String COLUMN_SOLUTION_TYPE_ID = "solution_type_id";
  @NonNull public static final String COLUMN_SOLUTION_VALUE_ID = "solution_value_id";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public FieldTechnologicalProcessSolutionsTable() {
    throw new IllegalStateException("No instances allowed");
  }

  @NonNull public static String getCreateTableQuery() {
    return "CREATE TABLE IF NOT EXISTS "
        + TABLE
        + " ("
        + COLUMN_ID
        + " INTEGER NOT NULL PRIMARY KEY, "
        + COLUMN_FIELD_TECH_PROCESS_ID + " INTEGER, "
        + COLUMN_SOLUTION_TYPE_ID + " INTEGER, "
        + COLUMN_SOLUTION_VALUE_ID + " INTEGER "
        + ");";
  }
}
