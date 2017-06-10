package com.apps.twelve.floor.field.data.local.tables.technological_map;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by Yaroslav on 11.05.2017.
 */

public class CropTechnologicalProcessesTable {

  @NonNull public static final String TABLE = "CropTechnologicalProcesses";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_NAME = "name";
  @NonNull public static final String COLUMN_ORDER = "order_val";
  @NonNull public static final String COLUMN_CROP_ID = "crop_id";
  @NonNull public static final String COLUMN_CLIMATE_ZONE_ID = "climate_zone_id";
  @NonNull public static final String COLUMN_PROCESS_PERIOD_ID = "period_id";
  @NonNull public static final String COLUMN_PHASE_ID = "phase_id";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public CropTechnologicalProcessesTable() {
    throw new IllegalStateException("No instances allowed");
  }

  @NonNull public static String getCreateTableQuery() {
    return "CREATE TABLE IF NOT EXISTS "
        + TABLE
        + " ("
        + COLUMN_ID
        + " INTEGER NOT NULL PRIMARY KEY, "
        + COLUMN_NAME + " TEXT NULL, "
        + COLUMN_ORDER
        + " TEXT NULL, "
        + COLUMN_CROP_ID
        + " TEXT NULL, "
        + COLUMN_CLIMATE_ZONE_ID
        + " TEXT NULL, "
        + COLUMN_PROCESS_PERIOD_ID
        + " TEXT NULL, "
        + COLUMN_PHASE_ID
        + " TEXT NULL "
        + ");";
  }
}
