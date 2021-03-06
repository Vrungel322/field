package com.apps.twelve.floor.field.data.local.objects.conditions;

import android.os.Parcel;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.TillageDirectionObject;

/**
 * Created by yarrick on 06.07.17.
 */

public class TillageDirectionConditionValueObject extends BaseConditionValueObject {
  public static final Creator<TillageDirectionConditionValueObject> CREATOR =
      new Creator<TillageDirectionConditionValueObject>() {
        @Override public TillageDirectionConditionValueObject createFromParcel(Parcel in) {
          return new TillageDirectionConditionValueObject(in);
        }

        @Override public TillageDirectionConditionValueObject[] newArray(int size) {
          return new TillageDirectionConditionValueObject[size];
        }
      };

  private long mId;
  @NonNull private ConditionTypeObject mType;
  @NonNull private TillageDirectionObject mTillageDirection;

  public TillageDirectionConditionValueObject(long id, @NonNull ConditionTypeObject type,
      @NonNull TillageDirectionObject tillageDirection) {
    this.mId = id;
    this.mType = type;
    this.mTillageDirection = tillageDirection;
  }

  protected TillageDirectionConditionValueObject(Parcel in) {
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

  @Override public String getRepresentation() {
    return mTillageDirection.getName();
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
