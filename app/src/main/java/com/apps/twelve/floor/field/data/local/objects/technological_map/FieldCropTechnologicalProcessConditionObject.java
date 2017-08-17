package com.apps.twelve.floor.field.data.local.objects.technological_map;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by yarrick on 16.08.17.
 */

public class FieldCropTechnologicalProcessConditionObject implements Parcelable {
  public static final Creator<FieldCropTechnologicalProcessConditionObject> CREATOR =
      new Creator<FieldCropTechnologicalProcessConditionObject>() {
        @Override public FieldCropTechnologicalProcessConditionObject createFromParcel(Parcel in) {
          return new FieldCropTechnologicalProcessConditionObject(in);
        }

        @Override public FieldCropTechnologicalProcessConditionObject[] newArray(int size) {
          return new FieldCropTechnologicalProcessConditionObject[size];
        }
      };

  private long mId;
  @NonNull private FieldCropTechnologicalProcessObject mTechnologicalProcess;
  @NonNull private TechnologicalProcessConditionObject mCondition;
  private boolean mIsFulfilled;

  public FieldCropTechnologicalProcessConditionObject(long id,
      @NonNull FieldCropTechnologicalProcessObject technologicalProcess,
      @NonNull TechnologicalProcessConditionObject condition, boolean isFulfilled) {
    this.mId = id;
    this.mTechnologicalProcess = technologicalProcess;
    this.mCondition = condition;
    this.mIsFulfilled = isFulfilled;
  }

  protected FieldCropTechnologicalProcessConditionObject(Parcel in) {
    mId = in.readLong();
    mTechnologicalProcess =
        in.readParcelable(FieldCropTechnologicalProcessObject.class.getClassLoader());
    mCondition = in.readParcelable(TechnologicalProcessConditionObject.class.getClassLoader());
    mIsFulfilled = in.readByte() != 0;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeParcelable(mTechnologicalProcess, flags);
    dest.writeParcelable(mCondition, flags);
    dest.writeByte((byte) (mIsFulfilled ? 1 : 0));
  }

  public long getId() {
    return mId;
  }

  public void setId(long id) {
    this.mId = id;
  }

  @NonNull public FieldCropTechnologicalProcessObject getTechnologicalProcess() {
    return mTechnologicalProcess;
  }

  public void setTechnologicalProcess(
      @NonNull FieldCropTechnologicalProcessObject technologicalProcess) {
    this.mTechnologicalProcess = technologicalProcess;
  }

  @NonNull public TechnologicalProcessConditionObject getCondition() {
    return mCondition;
  }

  public void setCondition(@NonNull TechnologicalProcessConditionObject condition) {
    this.mCondition = condition;
  }

  public boolean isFulfilled() {
    return mIsFulfilled;
  }

  public void setIsFulfilled(boolean isFulfilled) {
    this.mIsFulfilled = isFulfilled;
  }

  public String getConditionName() {
    return mCondition.getConditionName();
  }

  public Long getTechnologicalProcessId() {
    return mTechnologicalProcess.getId();
  }

  public Long getConditionId() {
    return mCondition.getConditionId();
  }
}
