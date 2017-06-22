package com.apps.twelve.floor.field.data.local;

import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.data.local.entities.CombinedFieldEntity;
import com.apps.twelve.floor.field.data.local.tables.CropsTable;
import com.apps.twelve.floor.field.data.local.tables.FieldsTable;
import com.apps.twelve.floor.field.data.local.tables.conditions.SoilTypesTable;
import com.apps.twelve.floor.field.data.local.tables.process_time.ClimateZonesTable;
import com.apps.twelve.floor.field.data.local.tables.process_time.PhasesTable;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.queries.RawQuery;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

/**
 * Created by Yaroslav on 12.05.2017.
 */

public class DbCombinedFieldRelationsHelper {

  public static final String QUERY_COLUMN_FIELD_ID = "field_id";
  public static final String QUERY_COLUMN_FIELD_NAME = "field_name";
  public static final String QUERY_COLUMN_FIELD_AREA = "field_area";
  public static final String QUERY_COLUMN_FIELD_COORDINATES = "field_coordinates";
  public static final String QUERY_COLUMN_CROP_ID = "crop_id";
  public static final String QUERY_COLUMN_CROP_NAME = "crop_name";
  public static final String QUERY_COLUMN_CROP_PARENT_ID = "crop_parent_id";
  public static final String QUERY_COLUMN_CROP_IS_GROUP = "crop_is_group";
  public static final String QUERY_COLUMN_CROP_IS_SUPPORTED = "crop_is_supported";
  public static final String QUERY_COLUMN_PREV_CROP_ID = "prev_crop_id";
  public static final String QUERY_COLUMN_PREV_CROP_NAME = "prev_crop_name";
  public static final String QUERY_COLUMN_PREV_CROP_PARENT_ID = "prev_crop_parent_id";
  public static final String QUERY_COLUMN_PREV_CROP_IS_GROUP = "prev_crop_is_group";
  public static final String QUERY_COLUMN_PREV_CROP_IS_SUPPORTED = "prev_crop_is_supported";
  public static final String QUERY_COLUMN_CLIMATE_ZONE_ID = "climate_zone_id";
  public static final String QUERY_COLUMN_CLIMATE_ZONE_NAME = "climate_zone_name";
  public static final String QUERY_COLUMN_CLIMATE_ZONE_COORDINATES = "climate_zone_coordinates";
  public static final String QUERY_COLUMN_PHASE_ID = "phase_id";
  public static final String QUERY_COLUMN_PHASE_NAME = "phase_name";

  public static final String QUERY_COLUMN_SOIL_TYPE_ID = "soil_type_id";
  public static final String QUERY_COLUMN_SOIL_TYPE_NAME = "soil_type_name";
  public static final String QUERY_COLUMN_SOIL_TYPE_CONDITION_TYPE_ID =
      "soil_type_condition_type_id";
  public static final String QUERY_COLUMN_SOIL_TYPE_COORDINATES = "soil_type_coordinates";

  public static final String QUERY_COMBINED_FIELD_SELECT_ALL = "SELECT "
      // Field data
      + FieldsTable.COLUMN_ID_WITH_TABLE_PREFIX
      + " AS "
      + QUERY_COLUMN_FIELD_ID
      + ", "
      + FieldsTable.COLUMN_NAME_WITH_TABLE_PREFIX
      + " AS "
      + QUERY_COLUMN_FIELD_NAME
      + ", "
      + FieldsTable.COLUMN_AREA_WITH_TABLE_PREFIX
      + " AS "
      + QUERY_COLUMN_FIELD_AREA
      + ", "
      + FieldsTable.COLUMN_COORDINATES_WITH_TABLE_PREFIX
      + " AS "
      + QUERY_COLUMN_FIELD_COORDINATES
      + ", "

      // Crop data
      + CropsTable.COLUMN_ID_WITH_TABLE_PREFIX
      + " AS "
      + QUERY_COLUMN_CROP_ID
      + ", "
      + CropsTable.COLUMN_NAME_WITH_TABLE_PREFIX
      + " AS "
      + QUERY_COLUMN_CROP_NAME
      + ", "
      + CropsTable.COLUMN_PARENT_ID_WITH_TABLE_PREFIX
      + " AS "
      + QUERY_COLUMN_CROP_PARENT_ID
      + ", "
      + CropsTable.COLUMN_IS_GROUP_WITH_TABLE_PREFIX
      + " AS "
      + QUERY_COLUMN_CROP_IS_GROUP
      + ", "
      + CropsTable.COLUMN_IS_SUPPORTED_WITH_TABLE_PREFIX
      + " AS "
      + QUERY_COLUMN_CROP_IS_SUPPORTED
      + ", "

      // Previous crop data
      + CropsTable.TABLE
      + "_PREV."
      + CropsTable.COLUMN_ID
      + " AS "
      + QUERY_COLUMN_PREV_CROP_ID
      + ", "
      + CropsTable.TABLE
      + "_PREV."
      + CropsTable.COLUMN_NAME
      + " AS "
      + QUERY_COLUMN_PREV_CROP_NAME
      + ", "
      + CropsTable.TABLE
      + "_PREV."
      + CropsTable.COLUMN_PARENT_ID
      + " AS "
      + QUERY_COLUMN_PREV_CROP_PARENT_ID
      + ", "
      + CropsTable.TABLE
      + "_PREV."
      + CropsTable.COLUMN_IS_GROUP
      + " AS "
      + QUERY_COLUMN_PREV_CROP_IS_GROUP
      + ", "
      + CropsTable.TABLE
      + "_PREV."
      + CropsTable.COLUMN_IS_SUPPORTED
      + " AS "
      + QUERY_COLUMN_PREV_CROP_IS_SUPPORTED
      + ", "

      // Climate zone data
      + ClimateZonesTable.COLUMN_ID_WITH_TABLE_PREFIX
      + " AS "
      + QUERY_COLUMN_CLIMATE_ZONE_ID
      + ", "
      + ClimateZonesTable.COLUMN_NAME_WITH_TABLE_PREFIX
      + " AS "
      + QUERY_COLUMN_CLIMATE_ZONE_NAME
      + ", "
      + ClimateZonesTable.COLUMN_COORDINATES_WITH_TABLE_PREFIX
      + " AS "
      + QUERY_COLUMN_CLIMATE_ZONE_COORDINATES
      + ", "

      // Phase data
      + PhasesTable.COLUMN_ID_WITH_TABLE_PREFIX
      + " AS "
      + QUERY_COLUMN_PHASE_ID
      + ", "
      + PhasesTable.COLUMN_NAME_WITH_TABLE_PREFIX
      + " AS "
      + QUERY_COLUMN_PHASE_NAME
      + ", "

      // Soil type data
      + SoilTypesTable.COLUMN_ID_WITH_TABLE_PREFIX
      + " AS "
      + QUERY_COLUMN_SOIL_TYPE_ID
      + ", "
      + SoilTypesTable.COLUMN_NAME_WITH_TABLE_PREFIX
      + " AS "
      + QUERY_COLUMN_SOIL_TYPE_NAME
      + ", "
      + SoilTypesTable.COLUMN_CONDITION_TYPE_ID_WITH_TABLE_PREFIX
      + " AS "
      + QUERY_COLUMN_SOIL_TYPE_CONDITION_TYPE_ID
      + ", "
      + SoilTypesTable.COLUMN_COORDINATES_WITH_TABLE_PREFIX
      + " AS "
      + QUERY_COLUMN_SOIL_TYPE_COORDINATES
      + ""

      + " FROM "
      + FieldsTable.TABLE
      + " INNER JOIN "
      + CropsTable.TABLE
      + " ON "
      + FieldsTable.COLUMN_CROP_ID_WITH_TABLE_PREFIX
      + " = "
      + CropsTable.COLUMN_ID_WITH_TABLE_PREFIX
      + " INNER JOIN "
      + CropsTable.TABLE + " AS "
      + CropsTable.TABLE
      + "_PREV"
      + " ON "
      + FieldsTable.COLUMN_PREV_CROP_ID_WITH_TABLE_PREFIX
      + " = "
      + CropsTable.TABLE
      + "_PREV"
      + "."
      + CropsTable.COLUMN_ID
      + " INNER JOIN "
      + ClimateZonesTable.TABLE
      + " ON "
      + FieldsTable.COLUMN_CLIMATE_ZONE_ID_WITH_TABLE_PREFIX
      + " = "
      + ClimateZonesTable.COLUMN_ID_WITH_TABLE_PREFIX
      + " INNER JOIN "
      + PhasesTable.TABLE
      + " ON "
      + FieldsTable.COLUMN_PHASE_ID_WITH_TABLE_PREFIX
      + " = "
      + PhasesTable.COLUMN_ID_WITH_TABLE_PREFIX
      + " AND "
      + FieldsTable.COLUMN_CROP_ID_WITH_TABLE_PREFIX
      + " = "
      + PhasesTable.COLUMN_CROP_ID_WITH_TABLE_PREFIX
      + " INNER JOIN "
      + SoilTypesTable.TABLE
      + " ON "
      + FieldsTable.COLUMN_SOIL_TYPE_ID_WITH_TABLE_PREFIX
      + " = "
      + SoilTypesTable.COLUMN_ID_WITH_TABLE_PREFIX;

  @Inject StorIOSQLite mStorIOSQLite;

  public DbCombinedFieldRelationsHelper() {
    App.getAppComponent().inject(this);
  }

  public @NonNull Observable<List<CombinedFieldEntity>> getCombinedFieldEntitiesAsync() {
    return mStorIOSQLite.get().listOfObjects(CombinedFieldEntity.class)
        .withQuery(RawQuery.builder().query(QUERY_COMBINED_FIELD_SELECT_ALL).build())
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public @NonNull List<CombinedFieldEntity> getCombinedFieldEntitiesBlocking() {
    return mStorIOSQLite.get().listOfObjects(CombinedFieldEntity.class)
        .withQuery(RawQuery.builder().query(QUERY_COMBINED_FIELD_SELECT_ALL).build())
        .prepare()
        .executeAsBlocking();
  }
}
