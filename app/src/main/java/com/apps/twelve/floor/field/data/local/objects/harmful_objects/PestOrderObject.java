package com.apps.twelve.floor.field.data.local.objects.harmful_objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by yarrick on 10.07.17.
 */

public class PestOrderObject implements Parcelable {
  public static final Creator<PestOrderObject> CREATOR = new Creator<PestOrderObject>() {
    @Override public PestOrderObject createFromParcel(Parcel in) {
      return new PestOrderObject(in);
    }

    @Override public PestOrderObject[] newArray(int size) {
      return new PestOrderObject[size];
    }
  };

  private long mId;
  @NonNull private String mName;

  public PestOrderObject(long id, @NonNull String name) {
    this.mId = id;
    this.mName = name;
  }

  protected PestOrderObject(Parcel in) {
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
