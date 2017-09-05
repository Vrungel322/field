package com.apps.twelve.floor.field.data.local.tables.harmful_objects;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by yarrick on 05.09.17.
 */

public class DiseasesTable {
  @NonNull public static final String TABLE = "Diseases";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_HARMFUL_OBJ_TYPE_ID = "harmful_obj_type_id";
  @NonNull public static final String COLUMN_NAME = "name";
  @NonNull public static final String COLUMN_PATHOGEN_TYPE_ID = "pathogen_type_id";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public DiseasesTable() {
    throw new IllegalStateException("No instances allowed");
  }

  @NonNull public static String getCreateTableQuery() {
    return "CREATE TABLE IF NOT EXISTS "
        + TABLE
        + " ("
        + COLUMN_ID
        + " INTEGER NOT NULL PRIMARY KEY, "
        + COLUMN_HARMFUL_OBJ_TYPE_ID
        + " INTEGER, "
        + COLUMN_NAME
        + " TEXT, "
        + COLUMN_PATHOGEN_TYPE_ID
        + " INTEGER "
        + ");";
  }
}
