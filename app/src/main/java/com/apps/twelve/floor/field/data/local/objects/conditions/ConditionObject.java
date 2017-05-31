package com.apps.twelve.floor.field.data.local.objects.conditions;

import android.os.Parcel;
import android.os.Parcelable;
import com.apps.twelve.floor.field.data.local.objects.CropObject;

/**
 * Created by Yaroslav on 31.05.2017.
 */

public class ConditionObject implements Parcelable {

  public static final Creator<ConditionObject> CREATOR = new Creator<ConditionObject>() {
    @Override public ConditionObject createFromParcel(Parcel in) {
      return new ConditionObject(in);
    }

    @Override public ConditionObject[] newArray(int size) {
      return new ConditionObject[size];
    }
  };

  private long mId;
  private CropObject mCrop;
  private int mPriority;
  private ConditionTypeObject mConditionType;
  private BaseConditionValueObject mConditionValue;

  public ConditionObject(long id, CropObject crop, int priority, ConditionTypeObject conditionType,
      BaseConditionValueObject conditionValue) {
    this.mId = id;
    this.mCrop = crop;
    this.mPriority = priority;
    this.mConditionType = conditionType;
    this.mConditionValue = conditionValue;
  }

  protected ConditionObject(Parcel in) {
    mId = in.readLong();
    mCrop = in.readParcelable(CropObject.class.getClassLoader());
    mPriority = in.readInt();
    mConditionType = in.readParcelable(ConditionTypeObject.class.getClassLoader());
    mConditionValue = in.readParcelable(BaseConditionValueObject.class.getClassLoader());
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeParcelable(mCrop, flags);
    dest.writeInt(mPriority);
    dest.writeParcelable(mConditionType, flags);
    dest.writeParcelable(mConditionValue, flags);
  }

  public long getId() {
    return mId;
  }

  public void setId(long id) {
    this.mId = id;
  }

  public CropObject getCrop() {
    return mCrop;
  }

  public void setCrop(CropObject crop) {
    this.mCrop = crop;
  }

  public int getPriority() {
    return mPriority;
  }

  public void setPriority(int priority) {
    this.mPriority = priority;
  }

  public ConditionTypeObject getConditionType() {
    return mConditionType;
  }

  public void setConditionType(ConditionTypeObject conditionType) {
    this.mConditionType = conditionType;
  }

  public BaseConditionValueObject getConditionValue() {
    return mConditionValue;
  }

  public void setConditionValue(BaseConditionValueObject conditionValue) {
    this.mConditionValue = conditionValue;
  }
}
