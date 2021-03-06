package com.apps.twelve.floor.field.data.local.resolvers;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.apps.twelve.floor.field.data.local.DbCombinedFieldRelationsHelper;
import com.apps.twelve.floor.field.data.local.entities.CombinedFieldEntity;
import com.apps.twelve.floor.field.data.local.entities.CropEntity;
import com.apps.twelve.floor.field.data.local.entities.FieldEntity;
import com.apps.twelve.floor.field.data.local.entities.SoilTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.process_time.ClimateZoneEntity;
import com.apps.twelve.floor.field.data.local.entities.process_time.PhaseEntity;
import com.pushtorefresh.storio.sqlite.operations.get.DefaultGetResolver;

/**
 * Created by Yaroslav on 13.05.2017.
 */

public class CombinedFieldGetResolver extends DefaultGetResolver<CombinedFieldEntity> {

  @NonNull @Override public CombinedFieldEntity mapFromCursor(@NonNull Cursor cursor) {
    return new CombinedFieldEntity(fieldEntityFromCursor(cursor), cropEntityFromCursor(cursor),
        previousCropEntityFromCursor(cursor), climateZoneEntityFromCursor(cursor),
        phaseEntityFromCursor(cursor), soilTypeEntityFromCursor(cursor));
  }

  ///////////////////////////////////////////////////////////////////////////
  // Private section
  ///////////////////////////////////////////////////////////////////////////

  @NonNull private FieldEntity fieldEntityFromCursor(@NonNull Cursor cursor) {
    return FieldEntity.newFieldEntity(cursor.getLong(
        cursor.getColumnIndexOrThrow(DbCombinedFieldRelationsHelper.QUERY_COLUMN_FIELD_ID)),
        cursor.getString(
            cursor.getColumnIndexOrThrow(DbCombinedFieldRelationsHelper.QUERY_COLUMN_FIELD_NAME)),
        cursor.getDouble(
            cursor.getColumnIndexOrThrow(DbCombinedFieldRelationsHelper.QUERY_COLUMN_FIELD_AREA)),
        cursor.getLong(
            cursor.getColumnIndexOrThrow(DbCombinedFieldRelationsHelper.QUERY_COLUMN_CROP_ID)),
        cursor.getLong(
            cursor.getColumnIndexOrThrow(DbCombinedFieldRelationsHelper.QUERY_COLUMN_PREV_CROP_ID)),
        cursor.getString(cursor.getColumnIndexOrThrow(
            DbCombinedFieldRelationsHelper.QUERY_COLUMN_FIELD_COORDINATES)), cursor.getLong(
            cursor.getColumnIndexOrThrow(
                DbCombinedFieldRelationsHelper.QUERY_COLUMN_CLIMATE_ZONE_ID)), cursor.getLong(
            cursor.getColumnIndexOrThrow(DbCombinedFieldRelationsHelper.QUERY_COLUMN_PHASE_ID)),
        cursor.getLong(
            cursor.getColumnIndexOrThrow(DbCombinedFieldRelationsHelper.QUERY_COLUMN_SOIL_TYPE_ID)),
        cursor.getLong(cursor.getColumnIndexOrThrow(
            DbCombinedFieldRelationsHelper.QUERY_COLUMN_FIELD_SOWING_DATE)));
  }

  @NonNull private CropEntity cropEntityFromCursor(@NonNull Cursor cursor) {
    return CropEntity.newCropEntity(cursor.getLong(
        cursor.getColumnIndexOrThrow(DbCombinedFieldRelationsHelper.QUERY_COLUMN_CROP_ID)),
        cursor.getString(
            cursor.getColumnIndexOrThrow(DbCombinedFieldRelationsHelper.QUERY_COLUMN_CROP_NAME)),
        cursor.getLong(cursor.getColumnIndexOrThrow(
            DbCombinedFieldRelationsHelper.QUERY_COLUMN_CROP_PARENT_ID)), (!TextUtils.isEmpty(
            cursor.getString(cursor.getColumnIndexOrThrow(
                DbCombinedFieldRelationsHelper.QUERY_COLUMN_CROP_IS_GROUP)))), (!TextUtils.isEmpty(
            cursor.getString(cursor.getColumnIndexOrThrow(
                DbCombinedFieldRelationsHelper.QUERY_COLUMN_CROP_IS_SUPPORTED)))));
  }

  @Nullable private CropEntity previousCropEntityFromCursor(@NonNull Cursor cursor) {
    return CropEntity.newCropEntity(cursor.getLong(
        cursor.getColumnIndexOrThrow(DbCombinedFieldRelationsHelper.QUERY_COLUMN_PREV_CROP_ID)),
        cursor.getString(cursor.getColumnIndexOrThrow(
            DbCombinedFieldRelationsHelper.QUERY_COLUMN_PREV_CROP_NAME)), cursor.getLong(
            cursor.getColumnIndexOrThrow(
                DbCombinedFieldRelationsHelper.QUERY_COLUMN_PREV_CROP_PARENT_ID)),
        (!TextUtils.isEmpty(cursor.getString(cursor.getColumnIndexOrThrow(
            DbCombinedFieldRelationsHelper.QUERY_COLUMN_PREV_CROP_IS_GROUP)))), (!TextUtils.isEmpty(
            cursor.getString(cursor.getColumnIndexOrThrow(
                DbCombinedFieldRelationsHelper.QUERY_COLUMN_PREV_CROP_IS_SUPPORTED)))));
  }

  @NonNull private ClimateZoneEntity climateZoneEntityFromCursor(@NonNull Cursor cursor) {
    return ClimateZoneEntity.newClimateZoneEntity(cursor.getLong(
        cursor.getColumnIndexOrThrow(DbCombinedFieldRelationsHelper.QUERY_COLUMN_CLIMATE_ZONE_ID)),
        cursor.getString(cursor.getColumnIndexOrThrow(
            DbCombinedFieldRelationsHelper.QUERY_COLUMN_CLIMATE_ZONE_NAME)), cursor.getString(
            cursor.getColumnIndexOrThrow(
                DbCombinedFieldRelationsHelper.QUERY_COLUMN_CLIMATE_ZONE_COORDINATES)));
  }

  @NonNull private PhaseEntity phaseEntityFromCursor(@NonNull Cursor cursor) {
    return PhaseEntity.newPhaseEntity(cursor.getLong(
        cursor.getColumnIndexOrThrow(DbCombinedFieldRelationsHelper.QUERY_COLUMN_PHASE_ID)),
        cursor.getString(
            cursor.getColumnIndexOrThrow(DbCombinedFieldRelationsHelper.QUERY_COLUMN_PHASE_NAME)),
        cursor.getLong(
            cursor.getColumnIndexOrThrow(DbCombinedFieldRelationsHelper.QUERY_COLUMN_CROP_ID)));
  }

  @NonNull private SoilTypeEntity soilTypeEntityFromCursor(Cursor cursor) {
    return SoilTypeEntity.newSoilTypeEntity(
        cursor.getLong(cursor.getColumnIndexOrThrow(DbCombinedFieldRelationsHelper.QUERY_COLUMN_SOIL_TYPE_ID)),
        cursor.getString(cursor.getColumnIndexOrThrow(DbCombinedFieldRelationsHelper.QUERY_COLUMN_SOIL_TYPE_NAME)),
        cursor.getString(cursor.getColumnIndexOrThrow(DbCombinedFieldRelationsHelper.QUERY_COLUMN_SOIL_TYPE_COORDINATES))
    );
  }
}
