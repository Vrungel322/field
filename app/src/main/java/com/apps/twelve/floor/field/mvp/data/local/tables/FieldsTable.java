package com.apps.twelve.floor.field.mvp.data.local.tables;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by Yaroslav on 11.04.2017.
 */

public class FieldsTable {

  public FieldsTable() {
    throw new IllegalStateException("No instances allowed");
  }

  @NonNull public static final String TABLE = "Fields";

  @NonNull public static final String COLUMN_ID = "id";

  @NonNull public static final String COLUMN_NAME = "name";

  @NonNull public static final String COLUMN_AREA = "area";

  @NonNull public static final String COLUMN_CROP = "crop";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  @NonNull public static String getCreateTableQuery() {
    return "CREATE TABLE "
        + TABLE
        + " ("
        + COLUMN_ID
        + " INTEGER NOT NULL PRIMARY KEY, "
        + COLUMN_NAME
        + " TEXT NULL, "
        + COLUMN_AREA
        + " REAL NULL, "
        + COLUMN_CROP
        + " TEXT NULL "
        + ");";
  }
}
