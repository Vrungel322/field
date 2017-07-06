package com.apps.twelve.floor.field.data.local.tables;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by Yaroslav on 31.05.2017.
 */

public class CropsActiveComponentsHarmfulObjectsTable {

  @NonNull public static final String TABLE = "CropsActiveComponentsHarmfulObjects";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_CROP_ID = "crop_id";
  @NonNull public static final String COLUMN_ACTIVE_COMPONENT_ID = "active_component_id";
  @NonNull public static final String COLUMN_HARMFUL_OBJECT_ID = "harmful_object_id";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public CropsActiveComponentsHarmfulObjectsTable() {
    throw new IllegalStateException("No instances allowed");
  }

  @NonNull public static String getCreateTableQuery() {
    return "CREATE TABLE IF NOT EXISTS "
        + TABLE
        + " ("
        + COLUMN_ID
        + " INTEGER NOT NULL PRIMARY KEY, "
        + COLUMN_CROP_ID
        + " INTEGER, "
        + COLUMN_ACTIVE_COMPONENT_ID
        + " INTEGER, "
        + COLUMN_HARMFUL_OBJECT_ID
        + " INTEGER "
        + ");";
  }
}
