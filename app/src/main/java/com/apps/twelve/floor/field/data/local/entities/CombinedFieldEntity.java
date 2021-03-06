package com.apps.twelve.floor.field.data.local.entities;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.apps.twelve.floor.field.data.local.entities.process_time.ClimateZoneEntity;
import com.apps.twelve.floor.field.data.local.entities.process_time.PhaseEntity;

/**
 * Created by Yaroslav on 12.05.2017.
 */

public class CombinedFieldEntity implements IEntity {

  @NonNull private final FieldEntity mFieldEntity;
  @NonNull private final CropEntity mCropEntity;
  @Nullable private final CropEntity mPreviousCropEntity;
  @NonNull private final ClimateZoneEntity mClimateZoneEntity;
  @NonNull private final PhaseEntity mPhaseEntity;
  @NonNull private final SoilTypeEntity mSoilTypeEntity;

  public CombinedFieldEntity(@NonNull FieldEntity fieldEntity, @NonNull CropEntity cropEntity,
      @Nullable CropEntity previousCropEntity, @NonNull ClimateZoneEntity climateZoneEntity,
      @NonNull PhaseEntity phaseEntity, @NonNull SoilTypeEntity soilTypeEntity) {
    this.mFieldEntity = fieldEntity;
    this.mCropEntity = cropEntity;
    this.mPreviousCropEntity = previousCropEntity;
    this.mClimateZoneEntity = climateZoneEntity;
    this.mPhaseEntity = phaseEntity;
    this.mSoilTypeEntity = soilTypeEntity;
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    CombinedFieldEntity that = (CombinedFieldEntity) obj;

    if (!mFieldEntity.equals(that.mFieldEntity)) return false;
    if (!mCropEntity.equals(that.mCropEntity)) return false;
    if (mPreviousCropEntity != null ? !mPreviousCropEntity.equals(that.mPreviousCropEntity)
        : that.mPreviousCropEntity != null) {
      return false;
    }
    if (mClimateZoneEntity != null ? !mClimateZoneEntity.equals(that.mClimateZoneEntity)
        : that.mClimateZoneEntity != null) {
      return false;
    }
    if (mPhaseEntity != null ? !mPhaseEntity.equals(that.mPhaseEntity)
        : that.mPhaseEntity != null) {
      return false;
    }

    return mSoilTypeEntity.equals(that.mSoilTypeEntity);
  }

  @Override public int hashCode() {
    int result = mFieldEntity.hashCode();
    result = 31 * result + mCropEntity.hashCode();
    result = 31 * result + (mPreviousCropEntity != null ? mPreviousCropEntity.hashCode() : 0);
    result = 31 * result + mClimateZoneEntity.hashCode();
    result = 31 * result + mPhaseEntity.hashCode();
    result = 31 * result + mSoilTypeEntity.hashCode();
    return result;
  }

  @NonNull public FieldEntity getFieldEntity() {
    return mFieldEntity;
  }

  @NonNull public CropEntity getCropEntity() {
    return mCropEntity;
  }

  @Nullable public CropEntity getPreviousCropEntity() {
    return mPreviousCropEntity;
  }

  @NonNull public ClimateZoneEntity getClimateZoneEntity() {
    return mClimateZoneEntity;
  }

  @NonNull public PhaseEntity getPhaseEntity() {
    return mPhaseEntity;
  }

  @NonNull public SoilTypeEntity getSoilTypeEntity() {
    return mSoilTypeEntity;
  }
}
