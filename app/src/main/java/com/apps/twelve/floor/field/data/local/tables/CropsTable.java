package com.apps.twelve.floor.field.data.local.tables;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by Yaroslav on 05.05.2017.
 */

public class CropsTable {

  @NonNull public static final String TABLE = "Crops";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_NAME = "name";
  @NonNull public static final String COLUMN_PARENT_ID = "parent_id";
  @NonNull public static final String COLUMN_IS_GROUP = "is_group";

  @NonNull public static final String COLUMN_ID_WITH_TABLE_PREFIX = TABLE + "." + COLUMN_ID;
  @NonNull public static final String COLUMN_NAME_WITH_TABLE_PREFIX = TABLE + "." + COLUMN_NAME;
  @NonNull public static final String COLUMN_PARENT_ID_WITH_TABLE_PREFIX =
      TABLE + "." + COLUMN_PARENT_ID;
  @NonNull public static final String COLUMN_IS_GROUP_WITH_TABLE_PREFIX =
      TABLE + "." + COLUMN_IS_GROUP;

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public CropsTable() {
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
        + COLUMN_PARENT_ID + " INTEGER, "
        + COLUMN_IS_GROUP
        + " TEXT NULL "
        + ");";
  }

  public static Query getCropByIdQuery(Long id) {
    return Query.builder().table(TABLE).where(COLUMN_ID).whereArgs(id).build();
  }
}
