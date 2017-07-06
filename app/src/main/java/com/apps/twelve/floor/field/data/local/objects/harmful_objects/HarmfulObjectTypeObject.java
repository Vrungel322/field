package com.apps.twelve.floor.field.data.local.objects.harmful_objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by yarrick on 04.07.17.
 */

public class HarmfulObjectTypeObject implements Parcelable {

  public static final Creator<HarmfulObjectTypeObject> CREATOR =
      new Creator<HarmfulObjectTypeObject>() {
        @Override public HarmfulObjectTypeObject createFromParcel(Parcel in) {
          return new HarmfulObjectTypeObject(in);
        }

        @Override public HarmfulObjectTypeObject[] newArray(int size) {
          return new HarmfulObjectTypeObject[size];
        }
      };

  private long mId;
  @NonNull private String mName;

  public HarmfulObjectTypeObject(long mId, @NonNull String mName) {
    this.mId = mId;
    this.mName = mName;
  }

  protected HarmfulObjectTypeObject(Parcel in) {
    mId = in.readLong();
    mName = in.readString();
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

  @NonNull public String getName() {
    return mName;
  }

  public void setName(@NonNull String name) {
    this.mName = name;
  }
}
