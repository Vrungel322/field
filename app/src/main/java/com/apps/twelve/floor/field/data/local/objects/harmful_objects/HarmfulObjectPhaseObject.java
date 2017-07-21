package com.apps.twelve.floor.field.data.local.objects.harmful_objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by Yaroslav on 31.05.2017.
 *
 */

public class HarmfulObjectPhaseObject implements Parcelable{

  public static final Creator<HarmfulObjectPhaseObject> CREATOR =
      new Creator<HarmfulObjectPhaseObject>() {
        @Override public HarmfulObjectPhaseObject createFromParcel(Parcel in) {
          return new HarmfulObjectPhaseObject(in);
        }

        @Override public HarmfulObjectPhaseObject[] newArray(int size) {
          return new HarmfulObjectPhaseObject[size];
        }
      };

  private long mId;
  @NonNull private String mName;

  public HarmfulObjectPhaseObject(long id, @NonNull String name) {
    this.mId = id;
    this.mName = name;
  }

  protected HarmfulObjectPhaseObject(Parcel in) {
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
