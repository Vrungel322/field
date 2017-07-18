package com.apps.twelve.floor.field.data.local.objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by Yaroslav on 12.05.2017.
 */

public class CropObject implements Parcelable, Cloneable {

  public static final CropObject EMPTY;
  public static final Creator<CropObject> CREATOR = new Creator<CropObject>() {
    @Override public CropObject createFromParcel(Parcel in) {
      return new CropObject(in);
    }

    @Override public CropObject[] newArray(int size) {
      return new CropObject[size];
    }
  };

  static {
    EMPTY = new CropObject(0, "", 0, false, false);
  }

  private long mId;
  @NonNull private String mName;
  private long mParentId;
  private boolean mIsParent;
  private boolean mIsSupported;

  public CropObject(long id, @NonNull String name, long parentId, boolean isParent,
      boolean isSupported) {
    this.mId = id;
    this.mName = name;
    this.mParentId = parentId;
    this.mIsParent = isParent;
    this.mIsSupported = isSupported;
  }

  protected CropObject(Parcel in) {
    this.mId = in.readLong();
    this.mName = in.readString();
    this.mParentId = in.readLong();
    this.mIsParent = in.readByte() != 0;
    this.mIsSupported = in.readByte() != 0;
  }

  public static CropObject newInstance() {
    return new CropObject(0, "", 0, false, false);
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeString(mName);
    dest.writeLong(mParentId);
    dest.writeByte((byte) (mIsParent ? 1 : 0));
    dest.writeByte((byte) (mIsSupported ? 1 : 0));
  }

  // TODO: don't override this method - change adapter instead
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

  public boolean isParent() {
    return mIsParent;
  }

  public void setIsParent(boolean isParent) {
    this.mIsParent = isParent;
  }

  public boolean isSupported() {
    return mIsSupported;
  }

  public void setIsSupported(boolean isSupported) {
    this.mIsSupported = isSupported;
  }
}
