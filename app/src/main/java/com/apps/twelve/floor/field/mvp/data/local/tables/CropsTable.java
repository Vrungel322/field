package com.apps.twelve.floor.field.mvp.data.local.tables;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by Yaroslav on 05.05.2017.
 */

public class CropsTable {

  @NonNull public static final String TABLE = "CropsTable";

  @NonNull public static final String COLUMN_ID = "id";

  @NonNull public static final String COLUMN_NAME = "name";

  @NonNull public static final String COLUMN_PARENT_ID = "parent_id";

  @NonNull public static final String COLUMN_IS_GROUP = "is_group";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public CropsTable() {
    throw new IllegalStateException("No instances allowed");
  }

  @NonNull public static String getCreateTableQuery() {
    return "CREATE TABLE "
        + TABLE
        + " ("
        + COLUMN_ID
        + " INTEGER NOT NULL PRIMARY KEY, "
        + COLUMN_NAME
        + " TEXT NULL, "
        + COLUMN_PARENT_ID
        + " INTEGER NULL, "
        + COLUMN_IS_GROUP
        + " INTEGER NULL "
        + ");";
  }

  // TODO: for tests - remove after
  @NonNull public static String getFillTableQuery() {
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= 10; i++) {
      sb.append("INSERT OR REPLACE INTO "
          + TABLE
          + " ("
          + COLUMN_ID
          + " , "
          + COLUMN_NAME
          + " , "
          + COLUMN_PARENT_ID
          + " , "
          + COLUMN_IS_GROUP
          + ") "
          + " VALUES ("
          + i
          + ", 'crop "
          + i
          + "', 0, 0)"
          + ";");
    }

    return sb.toString();
  }
}
