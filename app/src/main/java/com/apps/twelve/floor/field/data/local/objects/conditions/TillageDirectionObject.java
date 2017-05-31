package com.apps.twelve.floor.field.data.local.objects.conditions;

import android.os.Parcel;

/**
 * Created by Yaroslav on 31.05.2017.
 */

public class TillageDirectionObject extends BaseConditionValueObject {

  public static final Creator<TillageDirectionObject> CREATOR =
      new Creator<TillageDirectionObject>() {
        @Override public TillageDirectionObject createFromParcel(Parcel in) {
          return new TillageDirectionObject(in);
        }

        @Override public TillageDirectionObject[] newArray(int size) {
          return new TillageDirectionObject[size];
        }
      };

  private long mId;
  private String mName;
  private ConditionTypeObject mType;

  public TillageDirectionObject(long id, String name, ConditionTypeObject type) {
    this.mId = id;
    this.mName = name;
    this.mType = type;
  }

  protected TillageDirectionObject(Parcel in) {
    mId = in.readLong();
    mName = in.readString();
    mType = in.readParcelable(ConditionTypeObject.class.getClassLoader());
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeString(mName);
    dest.writeParcelable(mType, flags);
  }

  @Override public long getId() {
    return mId;
  }

  @Override public void setId(long id) {
    this.mId = id;
  }

  @Override public String getName() {
    return mName;
  }

  @Override public void setName(String name) {
    this.mName = name;
  }

  @Override public ConditionTypeObject getType() {
    return mType;
  }

  @Override public void setType(ConditionTypeObject type) {
    this.mType = type;
  }
}
