package com.apps.twelve.floor.field.data.local.objects.conditions;

import android.os.Parcel;
import android.support.annotation.NonNull;

/**
 * Created by Yaroslav on 31.05.2017.
 */

public class ConditionSpanValueObject extends BaseConditionValueObject {

  public static final Creator<ConditionSpanValueObject> CREATOR =
      new Creator<ConditionSpanValueObject>() {
        @Override public ConditionSpanValueObject createFromParcel(Parcel in) {
          return new ConditionSpanValueObject(in);
        }

        @Override public ConditionSpanValueObject[] newArray(int size) {
          return new ConditionSpanValueObject[size];
        }
      };

  private long mId;
  @NonNull private ConditionTypeObject mType;
  private long mValueFrom;
  private long mValueTo;

  public ConditionSpanValueObject(long id, @NonNull ConditionTypeObject type, long valueFrom,
      long valueTo) {
    this.mId = id;
    this.mType = type;
    this.mValueFrom = valueFrom;
    this.mValueTo = valueTo;
  }

  protected ConditionSpanValueObject(Parcel in) {
    this.mId = in.readLong();
    this.mType = in.readParcelable(ConditionTypeObject.class.getClassLoader());
    this.mValueFrom = in.readLong();
    this.mValueTo = in.readLong();
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeParcelable(mType, flags);
    dest.writeLong(mValueFrom);
    dest.writeLong(mValueTo);
  }

  @Override public long getId() {
    return mId;
  }

  @Override public void setId(long id) {
    this.mId = id;
  }

  @Override public ConditionTypeObject getType() {
    return mType;
  }

  @Override public void setType(@NonNull ConditionTypeObject type) {
    this.mType = type;
  }

  public String getName() {
    return mValueFrom + " : " + mValueTo;
  }

  public void setName(String name) {
  }

  public long getValueFrom() {
    return mValueFrom;
  }

  public void setValueFrom(long valueFrom) {
    this.mValueFrom = valueFrom;
  }

  public long getValueTo() {
    return mValueTo;
  }

  public void setValueTo(long valueTo) {
    this.mValueTo = valueTo;
  }

  public long getTypeId() {
    return mType.getId();
  }
}
