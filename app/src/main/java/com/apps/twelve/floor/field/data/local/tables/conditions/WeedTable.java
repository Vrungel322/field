package com.apps.twelve.floor.field.data.local.tables.conditions;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by Vrungel on 04.07.2017.
 */

public class WeedTable {
  @NonNull public static final String TABLE = "WeedTable";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_HARMFUL_OBJ_TYPE_ID = "harmful_obj_type_id";
  @NonNull public static final String COLUMN_NAME = "name";
  @NonNull public static final String COLUMN_NUTRITION_TYPE_ID = "nutrition_type_id";
  @NonNull public static final String COLUMN_CLASS_ID = "class_id";
  @NonNull public static final String COLUMN_GROUP_ID = "group_id";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public WeedTable() {
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
        + COLUMN_NUTRITION_TYPE_ID
        + " INTEGER,"
        + COLUMN_CLASS_ID
        + " INTEGER, "
        + COLUMN_GROUP_ID
        + " INTEGER "
        + ");";
  }
}
