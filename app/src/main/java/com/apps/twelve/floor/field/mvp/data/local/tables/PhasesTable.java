package com.apps.twelve.floor.field.mvp.data.local.tables;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by Yaroslav on 05.05.2017.
 */

public class PhasesTable {

  @NonNull public static final String TABLE = "Phases";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_NAME = "name";
  @NonNull public static final String COLUMN_CROP_ID = "crop_id";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public PhasesTable() {
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
        + COLUMN_CROP_ID + " TEXT NULL "
        + ");";
  }
}
