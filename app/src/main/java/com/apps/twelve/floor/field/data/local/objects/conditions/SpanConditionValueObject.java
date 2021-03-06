package com.apps.twelve.floor.field.data.local.objects.conditions;

import android.os.Parcel;
import android.support.annotation.NonNull;

/**
 * Created by Yaroslav on 31.05.2017.
 */

public class SpanConditionValueObject extends BaseConditionValueObject {

  public static final Creator<SpanConditionValueObject> CREATOR =
      new Creator<SpanConditionValueObject>() {
        @Override public SpanConditionValueObject createFromParcel(Parcel in) {
          return new SpanConditionValueObject(in);
        }

        @Override public SpanConditionValueObject[] newArray(int size) {
          return new SpanConditionValueObject[size];
        }
      };

  private long mId;
  @NonNull private ConditionTypeObject mType;
  private long mValueFrom;
  private long mValueTo;

  public SpanConditionValueObject(long id, @NonNull ConditionTypeObject type, long valueFrom,
      long valueTo) {
    this.mId = id;
    this.mType = type;
    this.mValueFrom = valueFrom;
    this.mValueTo = valueTo;
  }

  protected SpanConditionValueObject(Parcel in) {
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

  @Override public String getRepresentation() {
    return mValueFrom + " - " + mValueTo;
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
