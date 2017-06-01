package com.apps.twelve.floor.field.data.local.objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by Yaroslav on 12.05.2017.
 */

public class CropObject implements Parcelable {

  public static final Creator<CropObject> CREATOR = new Creator<CropObject>() {
    @Override public CropObject createFromParcel(Parcel in) {
      return new CropObject(in);
    }

    @Override public CropObject[] newArray(int size) {
      return new CropObject[size];
    }
  };

  private long mId;
  @NonNull private String mName;
  private long mParentId;
  private boolean mIsGroup;

  public CropObject(long id, @NonNull String name, long parentId, boolean isGroup) {
    this.mId = id;
    this.mName = name;
    this.mParentId = parentId;
    this.mIsGroup = isGroup;
  }

  protected CropObject(Parcel in) {
    this.mId = in.readLong();
    this.mName = in.readString();
    this.mParentId = in.readLong();
    this.mIsGroup = in.readByte() != 0;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeString(mName);
    dest.writeLong(mParentId);
    dest.writeByte((byte) (mIsGroup ? 1 : 0));
  }

  @Override public String toString() {
    return mName;
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

  public long getParentId() {
    return mParentId;
  }

  public void setParentId(long parentId) {
    this.mParentId = parentId;
  }

  public boolean isGroup() {
    return mIsGroup;
  }

  public void setIsGroup(boolean isGroup) {
    isGroup = isGroup;
  }
}
