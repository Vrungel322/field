package com.apps.twelve.floor.field.data.local.objects.conditions;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.IObject;

/**
 * Created by Yaroslav on 20.05.2017.
 */

public class ConditionTypeObject implements IObject, Parcelable {

  public static final Creator<ConditionTypeObject> CREATOR = new Creator<ConditionTypeObject>() {
    @Override public ConditionTypeObject createFromParcel(Parcel in) {
      return new ConditionTypeObject(in);
    }

    @Override public ConditionTypeObject[] newArray(int size) {
      return new ConditionTypeObject[size];
    }
  };

  private long mId;
  @NonNull private String mName;

  public ConditionTypeObject(long mId, @NonNull String mName) {
    this.mId = mId;
    this.mName = mName;
  }

  protected ConditionTypeObject(Parcel in) {
    this.mId = in.readLong();
    this.mName = in.readString();
  }

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

  public void setName(@NonNull String name) {
    this.mName = name;
  }
}
