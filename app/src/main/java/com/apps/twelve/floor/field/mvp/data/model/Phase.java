package com.apps.twelve.floor.field.mvp.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.apps.twelve.floor.field.mvp.data.local.tables.PhasesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 05.05.2017.
 */

@StorIOSQLiteType(table = PhasesTable.TABLE) public class Phase implements Parcelable {

  public static final Creator<Phase> CREATOR = new Creator<Phase>() {
    @Override public Phase createFromParcel(Parcel in) {
      return new Phase(in);
    }

    @Override public Phase[] newArray(int size) {
      return new Phase[size];
    }
  };

  @StorIOSQLiteColumn(name = PhasesTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = PhasesTable.COLUMN_NAME) String mName;

  @StorIOSQLiteColumn(name = PhasesTable.COLUMN_CROP_ID) Integer mCropId;

  public Phase() {
    this("", null);
  }

  public Phase(String name, Integer cropId) {
    this.mName = name;
    this.mCropId = cropId;
  }

  protected Phase(Parcel in) {
    mName = in.readString();
    mCropId = in.readInt();
  }

  public static Phase newPhase() {
    return new Phase();
  }

  public static Phase newPhase(String name, Integer cropId) {
    return new Phase(name, cropId);
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(mName);
    dest.writeInt(mCropId);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    Phase that = (Phase) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (mName != null ? !mName.equals(that.mName) : that.mName != null) return false;

    return mCropId != null ? mCropId.equals(that.mCropId) : that.mCropId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (mName != null ? mName.hashCode() : 0);
    result = 31 * result + (mCropId != null ? mCropId.hashCode() : 0);

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

  public Integer getCropId() {
    return mCropId;
  }

  public void setCropId(Integer mCropId) {
    this.mCropId = mCropId;
  }
}
