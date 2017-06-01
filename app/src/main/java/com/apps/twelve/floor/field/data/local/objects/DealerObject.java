package com.apps.twelve.floor.field.data.local.objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by Yaroslav on 01.06.2017.
 */

public class DealerObject implements Parcelable {

  public static final Creator<DealerObject> CREATOR = new Creator<DealerObject>() {
    @Override public DealerObject createFromParcel(Parcel in) {
      return new DealerObject(in);
    }

    @Override public DealerObject[] newArray(int size) {
      return new DealerObject[size];
    }
  };

  private long mId;
  @NonNull private String mName;

  public DealerObject(long id, @NonNull String name) {
    this.mId = id;
    this.mName = name;
  }

  protected DealerObject(Parcel in) {
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
