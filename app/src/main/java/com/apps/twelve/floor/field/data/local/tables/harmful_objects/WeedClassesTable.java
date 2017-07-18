package com.apps.twelve.floor.field.data.local.tables.harmful_objects;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by yarrick on 30.06.17.
 */

public class WeedClassesTable {

  @NonNull public static final String TABLE = "WeedClasses";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_NAME = "name";
  @NonNull public static final String COLUMN_PARENT_ID = "parent_id";
  @NonNull public static final String COLUMN_IS_PARENT = "is_parent";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public WeedClassesTable() {
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
        + COLUMN_PARENT_ID
        + " INTEGER, "
        + COLUMN_IS_PARENT
        + " TEXT NULL "
        + ");";
  }
}
