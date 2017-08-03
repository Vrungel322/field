package com.apps.twelve.floor.field.data.local.objects.conditions;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.IObject;

/**
 * Created by Vrungel on 05.07.2017.
 */

public class ConditionNameObject implements IObject, Parcelable {
  private long mId;
  @NonNull private String mName;

  public ConditionNameObject(long id, @NonNull String name) {
    mId = id;
    mName = name;
  }

  public long getId() {
    return mId;
  }

  public void setId(long id) {
    mId = id;
  }

  @NonNull public String getName() {
    return mName;
  }

  public void setName(@NonNull String name) {
    mName = name;
  }

  protected ConditionNameObject(Parcel in) {
    mId = in.readLong();
    mName = in.readString();
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeString(mName);
  }

  @Override public int describeContents() {
    return 0;
  }

  public static final Creator<ConditionNameObject> CREATOR = new Creator<ConditionNameObject>() {
    @Override public ConditionNameObject createFromParcel(Parcel in) {
      return new ConditionNameObject(in);
    }

    @Override public ConditionNameObject[] newArray(int size) {
      return new ConditionNameObject[size];
    }
  };
}
