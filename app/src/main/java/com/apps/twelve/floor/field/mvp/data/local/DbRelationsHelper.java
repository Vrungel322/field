package com.apps.twelve.floor.field.mvp.data.local;

import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.mvp.data.local.entities.FieldCropClimateZoneEntity;
import com.apps.twelve.floor.field.mvp.data.local.tables.ClimateZonesTable;
import com.apps.twelve.floor.field.mvp.data.local.tables.CropsTable;
import com.apps.twelve.floor.field.mvp.data.local.tables.FieldsTable;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.queries.RawQuery;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

/**
 * Created by Yaroslav on 12.05.2017.
 */

public class DbRelationsHelper {

  public static final String QUERY_COLUMN_FIELD_ID = "field_id";
  public static final String QUERY_COLUMN_FIELD_NAME = "field_name";
  public static final String QUERY_COLUMN_FIELD_AREA = "field_area";
  public static final String QUERY_COLUMN_FIELD_COORDINATES = "field_coordinates";
  public static final String QUERY_COLUMN_CROP_ID = "crop_id";
  public static final String QUERY_COLUMN_CROP_NAME = "crop_name";
  public static final String QUERY_COLUMN_CROP_PARENT_ID = "crop_parent_id";
  public static final String QUERY_COLUMN_CROP_IS_GROUP = "crop_is_group";
  public static final String QUERY_COLUMN_PREV_CROP_ID = "prev_crop_id";
  public static final String QUERY_COLUMN_PREV_CROP_NAME = "prev_crop_name";
  public static final String QUERY_COLUMN_PREV_CROP_PARENT_ID = "prev_crop_parent_id";
  public static final String QUERY_COLUMN_PREV_CROP_IS_GROUP = "prev_crop_is_group";
  public static final String QUERY_COLUMN_CLIMATE_ZONE_ID = "climate_zone_id";
  public static final String QUERY_COLUMN_CLIMATE_ZONE_NAME = "climate_zone_name";
  public static final String QUERY_COLUMN_CLIMATE_ZONE_COORDINATES = "climate_zone_coordinates";

  public static final String QUERY_FIELD_CROP_CLIMATE_ZONE_ALL = "SELECT "
      + FieldsTable.COLUMN_ID_WITH_TABLE_PREFIX
      + " AS \""
      + QUERY_COLUMN_FIELD_ID
      + "\", "
      + FieldsTable.COLUMN_NAME_WITH_TABLE_PREFIX
      + " AS \""
      + QUERY_COLUMN_FIELD_NAME
      + "\", "
      + FieldsTable.COLUMN_AREA_WITH_TABLE_PREFIX
      + " AS \""
      + QUERY_COLUMN_FIELD_AREA
      + "\", "
      + FieldsTable.COLUMN_COORDINATES_WITH_TABLE_PREFIX
      + " AS \""
      + QUERY_COLUMN_FIELD_COORDINATES
      + "\", "
      + CropsTable.COLUMN_ID_WITH_TABLE_PREFIX
      + " AS \""
      + QUERY_COLUMN_CROP_ID
      + "\", "
      + CropsTable.COLUMN_NAME_WITH_TABLE_PREFIX
      + " AS \""
      + QUERY_COLUMN_CROP_NAME
      + "\", "
      + CropsTable.COLUMN_PARENT_ID_WITH_TABLE_PREFIX
      + " AS \""
      + QUERY_COLUMN_CROP_PARENT_ID
      + "\", "
      + CropsTable.COLUMN_IS_GROUP_WITH_TABLE_PREFIX
      + " AS \""
      + QUERY_COLUMN_CROP_IS_GROUP
      + "\", "
      + CropsTable.TABLE + "_PREV."
      + CropsTable.COLUMN_ID
      + " AS \""
      + QUERY_COLUMN_PREV_CROP_ID
      + "\", "
      + CropsTable.TABLE + "_PREV."
      + CropsTable.COLUMN_NAME
      + " AS \""
      + QUERY_COLUMN_PREV_CROP_NAME
      + "\", "
      + CropsTable.TABLE + "_PREV."
      + CropsTable.COLUMN_PARENT_ID
      + " AS \""
      + QUERY_COLUMN_PREV_CROP_PARENT_ID
      + "\", "
      + CropsTable.TABLE + "_PREV."
      + CropsTable.COLUMN_IS_GROUP
      + " AS \""
      + QUERY_COLUMN_PREV_CROP_IS_GROUP
      + "\", "
      + ClimateZonesTable.COLUMN_ID_WITH_TABLE_PREFIX
      + " AS \""
      + QUERY_COLUMN_CLIMATE_ZONE_ID
      + "\", "
      + ClimateZonesTable.COLUMN_NAME_WITH_TABLE_PREFIX
      + " AS \""
      + QUERY_COLUMN_CLIMATE_ZONE_NAME
      + "\", "
      + ClimateZonesTable.COLUMN_COORDINATES_WITH_TABLE_PREFIX
      + " AS \""
      + QUERY_COLUMN_CLIMATE_ZONE_COORDINATES
      + "\""
      + " FROM "
      + FieldsTable.TABLE
      + " JOIN "
      + CropsTable.TABLE
      + " ON "
      + FieldsTable.COLUMN_CROP_ID_WITH_TABLE_PREFIX
      + " = "
      + CropsTable.COLUMN_ID_WITH_TABLE_PREFIX
      + " JOIN "
      + CropsTable.TABLE
      + " "
      + CropsTable.TABLE
      + "_PREV"
      + " ON "
      + FieldsTable.COLUMN_PREV_CROP_ID_WITH_TABLE_PREFIX
      + " = "
      + CropsTable.TABLE
      + "_PREV"
      + "."
      + CropsTable.COLUMN_ID
      + " JOIN "
      + ClimateZonesTable.TABLE
      + " ON "
      + FieldsTable.COLUMN_CLIMATE_ZONE_ID_WITH_TABLE_PREFIX
      + " = "
      + ClimateZonesTable.COLUMN_ID_WITH_TABLE_PREFIX;

  @Inject StorIOSQLite mStorIOSQLite;

  public DbRelationsHelper() {
    App.getAppComponent().inject(this);
  }

  public @NonNull Observable<List<FieldCropClimateZoneEntity>> getFieldCropClimateZoneEntities() {
    return mStorIOSQLite.get()
        .listOfObjects(FieldCropClimateZoneEntity.class)
        .withQuery(RawQuery.builder().query(QUERY_FIELD_CROP_CLIMATE_ZONE_ALL).build())
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public @NonNull List<FieldCropClimateZoneEntity> getFieldCropClimateZoneEntitiesAsList() {
    return mStorIOSQLite.get()
        .listOfObjects(FieldCropClimateZoneEntity.class)
        .withQuery(RawQuery.builder().query(QUERY_FIELD_CROP_CLIMATE_ZONE_ALL).build())
        .prepare()
        .executeAsBlocking();
  }
}
