package com.apps.twelve.floor.field.data.local.tables.technological_map;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by Yaroslav on 30.05.2017.
 */

public class TechnologicalProcessStatesTable {

  @NonNull public static final String TABLE = "TechnologicalProcessStates";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_NAME = "name";
  @NonNull public static final String COLUMN_IMAGE_RESOURCE_ID = "image_resource_id";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public TechnologicalProcessStatesTable() {
    throw new IllegalStateException("No instances allowed");
  }

  @NonNull public static String getCreateTableQuery() {
    return "CREATE TABLE IF NOT EXISTS "
        + TABLE
        + " ("
        + COLUMN_ID
        + " INTEGER NOT NULL PRIMARY KEY, "
        + COLUMN_NAME + " TEXT NULL, " + COLUMN_IMAGE_RESOURCE_ID
        + " TEXT NULL "
        + ");";
  }
}
