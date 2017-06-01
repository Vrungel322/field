package com.apps.twelve.floor.field.data.local.objects.conditions;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by Yaroslav on 31.05.2017.
 */

public class PestObject implements Parcelable {

  public static final Creator<PestObject> CREATOR = new Creator<PestObject>() {
    @Override public PestObject createFromParcel(Parcel in) {
      return new PestObject(in);
    }

    @Override public PestObject[] newArray(int size) {
      return new PestObject[size];
    }
  };

  private long mId;
  @NonNull private String mName;
  private long mParentId;
  private boolean mIsGroup;

  public PestObject(long id, @NonNull String name, long parentId, boolean isGroup) {
    this.mId = id;
    this.mName = name;
    this.mParentId = parentId;
    this.mIsGroup = isGroup;
  }

  protected PestObject(Parcel in) {
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
    this.mIsGroup = isGroup;
  }
}
