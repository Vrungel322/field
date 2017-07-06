package com.apps.twelve.floor.field.data.local.objects.harmful_objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by yarrick on 30.06.17.
 */

public class WeedClassObject implements Parcelable {

  public static final Creator<WeedClassObject> CREATOR = new Creator<WeedClassObject>() {
    @Override public WeedClassObject createFromParcel(Parcel in) {
      return new WeedClassObject(in);
    }

    @Override public WeedClassObject[] newArray(int size) {
      return new WeedClassObject[size];
    }
  };

  private long mId;
  @NonNull private String mName;
  private long mParentId;
  private boolean mIsGroup;

  public WeedClassObject(long id, @NonNull String name, long parentId, boolean isGroup) {
    this.mId = id;
    this.mName = name;
    this.mParentId = parentId;
    this.mIsGroup = isGroup;
  }

  protected WeedClassObject(Parcel in) {
    mId = in.readLong();
    mName = in.readString();
    mParentId = in.readLong();
    mIsGroup = in.readByte() != 0;
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

  public boolean isGroup() {
    return mIsGroup;
  }

  public void setIsGroup(boolean isGroup) {
    this.mIsGroup = isGroup;
  }
}
