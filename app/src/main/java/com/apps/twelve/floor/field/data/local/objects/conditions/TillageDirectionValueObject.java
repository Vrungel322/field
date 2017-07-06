package com.apps.twelve.floor.field.data.local.objects.conditions;

import android.os.Parcel;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.TillageDirectionObject;

/**
 * Created by yarrick on 06.07.17.
 */

public class TillageDirectionValueObject extends BaseConditionValueObject {
  public static final Creator<TillageDirectionValueObject> CREATOR =
      new Creator<TillageDirectionValueObject>() {
        @Override public TillageDirectionValueObject createFromParcel(Parcel in) {
          return new TillageDirectionValueObject(in);
        }

        @Override public TillageDirectionValueObject[] newArray(int size) {
          return new TillageDirectionValueObject[size];
        }
      };

  private long mId;
  @NonNull private ConditionTypeObject mType;
  @NonNull private TillageDirectionObject mTillageDirection;

  public TillageDirectionValueObject(long id, @NonNull ConditionTypeObject type,
      @NonNull TillageDirectionObject tillageDirection) {
    this.mId = id;
    this.mType = type;
    this.mTillageDirection = tillageDirection;
  }

  protected TillageDirectionValueObject(Parcel in) {
    mId = in.readLong();
    mType = in.readParcelable(ConditionTypeObject.class.getClassLoader());
    mTillageDirection = in.readParcelable(TillageDirectionObject.class.getClassLoader());
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeParcelable(mType, flags);
    dest.writeParcelable(mTillageDirection, flags);
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

  @NonNull public TillageDirectionObject getTillageDirection() {
    return mTillageDirection;
  }

  public void setTillageDirection(@NonNull TillageDirectionObject tillageDirection) {
    this.mTillageDirection = tillageDirection;
  }

  public long getTypeId() {
    return mType.getId();
  }

  public long getTillageDirectionId() {
    return mTillageDirection.getId();
  }
}
