package com.apps.twelve.floor.field.data.local.tables.conditions;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by Yaroslav on 30.05.2017.
 */

public class HarmfulObjectPhasesTable {

  @NonNull public static final String TABLE = "PestPhases";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_NAME = "name";
  @NonNull public static final String COLUMN_HARMFUL_OBJECT_ID = "harmful_object_id";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public HarmfulObjectPhasesTable() {
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
        + COLUMN_HARMFUL_OBJECT_ID
        + " INTEGER "
        + ");";
  }
}
