package com.apps.twelve.floor.field.data.local.objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by Yaroslav on 31.05.2017.
 */

public class TillageDirectionObject implements Parcelable {

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
  @NonNull private String mName;

  public TillageDirectionObject(long id, @NonNull String name) {
    this.mId = id;
    this.mName = name;
  }

  protected TillageDirectionObject(Parcel in) {
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
