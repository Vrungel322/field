package com.apps.twelve.floor.field.data.local.entities.process_time;

import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.entities.CropEntity;

/**
 * Created by Yaroslav on 09.06.2017.
 */

public class CombinedPhaseEntity {

  @NonNull private final PhaseEntity mPhaseEntity;
  @NonNull private final CropEntity mCropEntity;

  public CombinedPhaseEntity(@NonNull PhaseEntity mPhaseEntity, @NonNull CropEntity mCropEntity) {
    this.mPhaseEntity = mPhaseEntity;
    this.mCropEntity = mCropEntity;
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    CombinedPhaseEntity that = (CombinedPhaseEntity) obj;

    if (!mPhaseEntity.equals(that.mPhaseEntity)) return false;

    return mCropEntity.equals(that.mCropEntity);
  }

  @Override public int hashCode() {
    int result = mPhaseEntity.hashCode();
    result = 31 * result + mCropEntity.hashCode();
    return result;
  }

  @NonNull public PhaseEntity getPhaseEntity() {
    return mPhaseEntity;
  }

  @NonNull public CropEntity getCropEntity() {
    return mCropEntity;
  }
}
