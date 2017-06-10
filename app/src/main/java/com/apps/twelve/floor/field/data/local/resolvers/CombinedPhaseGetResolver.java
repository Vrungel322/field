package com.apps.twelve.floor.field.data.local.resolvers;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.apps.twelve.floor.field.data.local.DbCombinedPhaseRelationsHelper;
import com.apps.twelve.floor.field.data.local.entities.CropEntity;
import com.apps.twelve.floor.field.data.local.entities.process_time.CombinedPhaseEntity;
import com.apps.twelve.floor.field.data.local.entities.process_time.PhaseEntity;
import com.pushtorefresh.storio.sqlite.operations.get.DefaultGetResolver;

/**
 * Created by Yaroslav on 09.06.2017.
 */

public class CombinedPhaseGetResolver extends DefaultGetResolver<CombinedPhaseEntity> {

  @NonNull @Override public CombinedPhaseEntity mapFromCursor(@NonNull Cursor cursor) {

    return new CombinedPhaseEntity(phaseEntityFromCursor(cursor), cropEntityFromCursor(cursor));
  }

  ///////////////////////////////////////////////////////////////////////////
  // Private section
  ///////////////////////////////////////////////////////////////////////////

  @NonNull private PhaseEntity phaseEntityFromCursor(@NonNull Cursor cursor) {

    return PhaseEntity.newPhaseEntity(cursor.getLong(
        cursor.getColumnIndexOrThrow(DbCombinedPhaseRelationsHelper.QUERY_COLUMN_PHASE_ID)),
        cursor.getString(
            cursor.getColumnIndexOrThrow(DbCombinedPhaseRelationsHelper.QUERY_COLUMN_PHASE_NAME)),
        cursor.getLong(
            cursor.getColumnIndexOrThrow(DbCombinedPhaseRelationsHelper.QUERY_COLUMN_CROP_ID)));
  }

  @NonNull private CropEntity cropEntityFromCursor(@NonNull Cursor cursor) {
    return CropEntity.newCropEntity(cursor.getLong(
        cursor.getColumnIndexOrThrow(DbCombinedPhaseRelationsHelper.QUERY_COLUMN_CROP_ID)),
        cursor.getString(
            cursor.getColumnIndexOrThrow(DbCombinedPhaseRelationsHelper.QUERY_COLUMN_CROP_NAME)),
        cursor.getLong(cursor.getColumnIndexOrThrow(
            DbCombinedPhaseRelationsHelper.QUERY_COLUMN_CROP_PARENT_ID)), (!TextUtils.isEmpty(
            cursor.getString(cursor.getColumnIndexOrThrow(
                DbCombinedPhaseRelationsHelper.QUERY_COLUMN_CROP_IS_GROUP)))));
  }
}
