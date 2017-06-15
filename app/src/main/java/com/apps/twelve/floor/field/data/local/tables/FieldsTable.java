package com.apps.twelve.floor.field.data.local.tables;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by Yaroslav on 11.04.2017.
 */

public class FieldsTable {

  @NonNull public static final String TABLE = "Fields";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_NAME = "name";
  @NonNull public static final String COLUMN_AREA = "area";
  @NonNull public static final String COLUMN_CROP_ID = "crop_id";
  @NonNull public static final String COLUMN_PREV_CROP_ID = "previous_crop_id";
  @NonNull public static final String COLUMN_COORDINATES = "coordinates";
  @NonNull public static final String COLUMN_CLIMATE_ZONE_ID = "climate_zone_id";
  @NonNull public static final String COLUMN_PHASE_ID = "phase_id";
  @NonNull public static final String COLUMN_SOIL_TYPE_ID = "soil_type_id";

  @NonNull public static final String COLUMN_ID_WITH_TABLE_PREFIX = TABLE + "." + COLUMN_ID;
  @NonNull public static final String COLUMN_NAME_WITH_TABLE_PREFIX = TABLE + "." + COLUMN_NAME;
  @NonNull public static final String COLUMN_AREA_WITH_TABLE_PREFIX = TABLE + "." + COLUMN_AREA;
  @NonNull public static final String COLUMN_CROP_ID_WITH_TABLE_PREFIX =
      TABLE + "." + COLUMN_CROP_ID;
  @NonNull public static final String COLUMN_PREV_CROP_ID_WITH_TABLE_PREFIX =
      TABLE + "." + COLUMN_PREV_CROP_ID;
  @NonNull public static final String COLUMN_COORDINATES_WITH_TABLE_PREFIX =
      TABLE + "." + COLUMN_COORDINATES;
  @NonNull public static final String COLUMN_CLIMATE_ZONE_ID_WITH_TABLE_PREFIX =
      TABLE + "." + COLUMN_CLIMATE_ZONE_ID;
  @NonNull public static final String COLUMN_PHASE_ID_WITH_TABLE_PREFIX =
      TABLE + "." + COLUMN_PHASE_ID;
  @NonNull public static final String COLUMN_SOIL_TYPE_ID_WITH_TABLE_PREFIX =
      TABLE + "." + COLUMN_SOIL_TYPE_ID;

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public FieldsTable() {
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
        + COLUMN_AREA
        + " TEXT NULL, "
        + COLUMN_CROP_ID + " INTEGER, "
        + COLUMN_PREV_CROP_ID + " INTEGER, "
        + COLUMN_COORDINATES
        + " TEXT NULL, "
        + COLUMN_CLIMATE_ZONE_ID + " INTEGER, "
        + COLUMN_PHASE_ID + " INTEGER, "
        + COLUMN_SOIL_TYPE_ID + " INTEGER"
        + ");";
  }
}
