package com.apps.twelve.floor.field.mvp.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.apps.twelve.floor.field.mvp.data.local.tables.CropsTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 05.05.2017.
 */

@StorIOSQLiteType(table = CropsTable.TABLE) public class Crop implements Parcelable {

  public static final Creator<Crop> CREATOR = new Creator<Crop>() {
    @Override public Crop createFromParcel(Parcel in) {
      return new Crop(in);
    }

    @Override public Crop[] newArray(int size) {
      return new Crop[size];
    }
  };

  @StorIOSQLiteColumn(name = CropsTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = CropsTable.COLUMN_NAME) String mName;
  @StorIOSQLiteColumn(name = CropsTable.COLUMN_PARENT_ID) Integer mParentId;
  @StorIOSQLiteColumn(name = CropsTable.COLUMN_IS_GROUP) Integer mIsGroup;

  public Crop() {
    this("", null, null);
  }

  public Crop(String name) {
    this(name, null, null);
  }

  public Crop(String name, Integer parentId, Integer isGroup) {
    this.mName = name;
    this.mParentId = parentId;
    this.mIsGroup = isGroup;
  }

  protected Crop(Parcel in) {
    mName = in.readString();
    mParentId = in.readInt();
    mIsGroup = in.readInt();
  }

  public static Crop newCrop(String name) {
    return new Crop(name);
  }

  public static Crop newCrop(String name, Integer parentId) {
    return new Crop(name, parentId, null);
  }

  public static Crop newCrop(String name, Integer parentId, Integer isGroup) {
    return new Crop(name, parentId, isGroup);
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(mName);
    dest.writeInt(mParentId);
    dest.writeInt(mIsGroup);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    Crop that = (Crop) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (mName != null ? !mName.equals(that.mName) : that.mName != null) return false;
    if (mParentId != null ? !mParentId.equals(that.mParentId) : that.mParentId != null) {
      return false;
    }

    return mIsGroup != null ? mIsGroup.equals(that.mIsGroup) : that.mIsGroup == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (mName != null ? mName.hashCode() : 0);
    result = 31 * result + (mParentId != null ? mParentId.hashCode() : 0);
    result = 31 * result + (mIsGroup != null ? mIsGroup.hashCode() : 0);

    return result;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return mName;
  }

  public void setName(String mName) {
    this.mName = mName;
  }

  public Integer getParentId() {
    return mParentId;
  }

  public void setParentId(Integer mParentId) {
    this.mParentId = mParentId;
  }

  public Integer getIsGroup() {
    return mIsGroup;
  }

  public void setIsGroup(Integer mIsGroup) {
    this.mIsGroup = mIsGroup;
  }
}
