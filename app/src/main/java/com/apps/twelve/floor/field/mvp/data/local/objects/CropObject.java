package com.apps.twelve.floor.field.mvp.data.local.objects;

import android.os.Parcel;
import android.os.Parcelable;

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

  private long id;
  private String name;
  private long parentId;
  private boolean isGroup;

  public CropObject(long id, String name, long parentId, boolean isGroup) {
    this.id = id;
    this.name = name;
    this.parentId = parentId;
    this.isGroup = isGroup;
  }

  protected CropObject(Parcel in) {
    id = in.readLong();
    name = in.readString();
    parentId = in.readLong();
    isGroup = in.readByte() != 0;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(id);
    dest.writeString(name);
    dest.writeLong(parentId);
    dest.writeByte((byte) (isGroup ? 1 : 0));
  }

  @Override public String toString() {
    return name;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getParentId() {
    return parentId;
  }

  public void setParentId(long parentId) {
    this.parentId = parentId;
  }

  public boolean isGroup() {
    return isGroup;
  }

  public void setIsGroup(boolean isGroup) {
    isGroup = isGroup;
  }
}
