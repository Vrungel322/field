package com.apps.twelve.floor.field.data.local.objects.harmful_objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.IObject;

/**
 * Created by yarrick on 30.06.17.
 */

public class WeedGroupObject implements IObject, Parcelable {

  public static final Creator<WeedGroupObject> CREATOR = new Creator<WeedGroupObject>() {
    @Override public WeedGroupObject createFromParcel(Parcel in) {
      return new WeedGroupObject(in);
    }

    @Override public WeedGroupObject[] newArray(int size) {
      return new WeedGroupObject[size];
    }
  };

  private long mId;
  @NonNull private String mName;
  private long mParentId;
  private boolean mIsParent;

  public WeedGroupObject(long id, @NonNull String name, long parentId, boolean isParent) {
    this.mId = id;
    this.mName = name;
    this.mParentId = parentId;
    this.mIsParent = isParent;
  }

  protected WeedGroupObject(Parcel in) {
    mId = in.readLong();
    mName = in.readString();
    mParentId = in.readLong();
    mIsParent = in.readByte() != 0;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeString(mName);
    dest.writeLong(mParentId);
    dest.writeByte((byte) (mIsParent ? 1 : 0));
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
}
