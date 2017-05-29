package com.apps.twelve.floor.field.data.local.objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Yaroslav on 20.05.2017.
 */

public class ConditionTypeObject implements Parcelable {

  private long mId;
  private String mName;

  public ConditionTypeObject(long mId, String mName) {
    this.mId = mId;
    this.mName = mName;
  }

  protected ConditionTypeObject(Parcel in) {
    mId = in.readLong();
    mName = in.readString();
  }

  public static final Creator<ConditionTypeObject> CREATOR = new Creator<ConditionTypeObject>() {
    @Override public ConditionTypeObject createFromParcel(Parcel in) {
      return new ConditionTypeObject(in);
    }

    @Override public ConditionTypeObject[] newArray(int size) {
      return new ConditionTypeObject[size];
    }
  };

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeString(mName);
  }

  public long getId() {
    return mId;
  }

  public void setId(long id) {
    this.mId = id;
  }

  public String getName() {
    return mName;
  }

  public void setName(String name) {
    this.mName = name;
  }
}
