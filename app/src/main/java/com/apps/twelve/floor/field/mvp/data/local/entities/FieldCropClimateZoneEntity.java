package com.apps.twelve.floor.field.mvp.data.local.entities;

import android.support.annotation.NonNull;

/**
 * Created by Yaroslav on 12.05.2017.
 */

public class FieldCropClimateZoneEntity {

  @NonNull private final FieldEntity mFieldEntity;
  @NonNull private final CropEntity mCropEntity;
  @NonNull private final ClimateZoneEntity mClimateZoneEntity;

  public FieldCropClimateZoneEntity(@NonNull FieldEntity mFieldEntity,
      @NonNull CropEntity mCropEntity, @NonNull ClimateZoneEntity mClimateZoneEntity) {
    this.mFieldEntity = mFieldEntity;
    this.mCropEntity = mCropEntity;
    this.mClimateZoneEntity = mClimateZoneEntity;
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    FieldCropClimateZoneEntity that = (FieldCropClimateZoneEntity) obj;

    if (!mFieldEntity.equals(that.mFieldEntity)) return false;
    if (!mCropEntity.equals(that.mCropEntity)) return false;
    return mClimateZoneEntity.equals(that.mClimateZoneEntity);
  }

  @Override public int hashCode() {
    int result = mFieldEntity.hashCode();
    result = 31 * result + mCropEntity.hashCode();
    result = 31 * result + mClimateZoneEntity.hashCode();
    return result;
  }

  @NonNull public FieldEntity getFieldEntity() {
    return mFieldEntity;
  }

  @NonNull public CropEntity getCropEntity() {
    return mCropEntity;
  }

  @NonNull public ClimateZoneEntity getClimateZoneEntity() {
    return mClimateZoneEntity;
  }
}
