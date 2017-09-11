package com.apps.twelve.floor.field.data.local.tables.technological_map;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by yarrick on 11.09.17.
 */

public class CropTechnologicalProcessesSequencesTable {
  @NonNull public static final String TABLE = "CropTechnologicalProcessesSequences";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_CROP_TECHNOLOGICAL_PROCESS_ID =
      "crop_technological_process_id";
  @NonNull public static final String COLUMN_NEXT_CROP_TECHNOLOGICAL_PROCESS_ID =
      "next_crop_technological_process_id";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public CropTechnologicalProcessesSequencesTable() {
    throw new IllegalStateException("No instances allowed");
  }

  @NonNull public static String getCreateTableQuery() {
    return "CREATE TABLE IF NOT EXISTS "
        + TABLE
        + " ("
        + COLUMN_ID
        + " INTEGER NOT NULL PRIMARY KEY, "
        + COLUMN_CROP_TECHNOLOGICAL_PROCESS_ID
        + " INTEGER, "
        + COLUMN_NEXT_CROP_TECHNOLOGICAL_PROCESS_ID
        + " INTEGER "
        + ");";
  }
}
