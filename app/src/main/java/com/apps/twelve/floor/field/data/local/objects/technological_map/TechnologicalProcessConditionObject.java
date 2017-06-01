package com.apps.twelve.floor.field.data.local.objects.technological_map;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionObject;

/**
 * Created by Yaroslav on 01.06.2017.
 */

public class TechnologicalProcessConditionObject implements Parcelable {

  public static final Creator<TechnologicalProcessConditionObject> CREATOR =
      new Creator<TechnologicalProcessConditionObject>() {
        @Override public TechnologicalProcessConditionObject createFromParcel(Parcel in) {
          return new TechnologicalProcessConditionObject(in);
        }

        @Override public TechnologicalProcessConditionObject[] newArray(int size) {
          return new TechnologicalProcessConditionObject[size];
        }
      };

  private long mId;
  @NonNull private FieldCropTechnologicalProcessObject mProcess;
  @NonNull private ConditionObject mCondition;

  public TechnologicalProcessConditionObject(long id,
      @NonNull FieldCropTechnologicalProcessObject process, @NonNull ConditionObject condition) {
    this.mId = id;
    this.mProcess = process;
    this.mCondition = condition;
  }

  protected TechnologicalProcessConditionObject(Parcel in) {
    this.mId = in.readLong();
    this.mProcess = in.readParcelable(FieldCropTechnologicalProcessObject.class.getClassLoader());
    this.mCondition = in.readParcelable(ConditionObject.class.getClassLoader());
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeParcelable(mProcess, flags);
    dest.writeParcelable(mCondition, flags);
  }

  public long getId() {
    return mId;
  }

  public void setId(long id) {
    this.mId = id;
  }

  public FieldCropTechnologicalProcessObject getProcess() {
    return mProcess;
  }

  public void setProcess(@NonNull FieldCropTechnologicalProcessObject process) {
    this.mProcess = process;
  }

  public ConditionObject getCondition() {
    return mCondition;
  }

  public void setCondition(@NonNull ConditionObject condition) {
    this.mCondition = condition;
  }
}