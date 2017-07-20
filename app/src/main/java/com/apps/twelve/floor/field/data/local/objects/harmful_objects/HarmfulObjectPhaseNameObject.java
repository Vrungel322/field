package com.apps.twelve.floor.field.data.local.objects.harmful_objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by yarrick on 20.07.17.
 */

public class HarmfulObjectPhaseNameObject implements Parcelable {

  public static final Creator<HarmfulObjectPhaseNameObject> CREATOR =
      new Creator<HarmfulObjectPhaseNameObject>() {
        @Override public HarmfulObjectPhaseNameObject createFromParcel(Parcel in) {
          return new HarmfulObjectPhaseNameObject(in);
        }

        @Override public HarmfulObjectPhaseNameObject[] newArray(int size) {
          return new HarmfulObjectPhaseNameObject[size];
        }
      };

  private long mId;
  @NonNull private String mName;

  public HarmfulObjectPhaseNameObject(long id, @NonNull String name) {
    this.mId = id;
    this.mName = name;
  }

  protected HarmfulObjectPhaseNameObject(Parcel in) {
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
