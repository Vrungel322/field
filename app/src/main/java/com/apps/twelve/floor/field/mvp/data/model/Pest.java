package com.apps.twelve.floor.field.mvp.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.apps.twelve.floor.field.mvp.data.local.tables.PestsTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 10.05.2017.
 */

@StorIOSQLiteType(table = PestsTable.TABLE) public class Pest implements Parcelable {

  public static final Creator<Pest> CREATOR = new Creator<Pest>() {
    @Override public Pest createFromParcel(Parcel in) {
      return new Pest(in);
    }

    @Override public Pest[] newArray(int size) {
      return new Pest[size];
    }
  };

  @StorIOSQLiteColumn(name = PestsTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = PestsTable.COLUMN_NAME) String mName;
  @StorIOSQLiteColumn(name = PestsTable.COLUMN_PARENT_ID) Integer mParentId;
  @StorIOSQLiteColumn(name = PestsTable.COLUMN_IS_GROUP) Integer mIsGroup;

  public Pest() {
    this("", null, null);
  }

  public Pest(String name) {
    this(name, null, null);
  }

  public Pest(String name, Integer parentId, Integer isGroup) {
    this.mName = name;
    this.mParentId = parentId;
    this.mIsGroup = isGroup;
  }

  protected Pest(Parcel in) {
    mName = in.readString();
  }

  public static Pest newPest(String name) {
    return new Pest(name);
  }

  public static Pest newPest(String name, Integer parentId) {
    return new Pest(name, parentId, null);
  }

  public static Pest newPest(String name, Integer parentId, Integer isGroup) {
    return new Pest(name, parentId, isGroup);
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(mName);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    Pest that = (Pest) obj;

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
