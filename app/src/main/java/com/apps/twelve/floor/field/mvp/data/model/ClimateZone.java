package com.apps.twelve.floor.field.mvp.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.apps.twelve.floor.field.mvp.data.local.tables.ClimateZonesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 04.05.2017.
 */

@StorIOSQLiteType(table = ClimateZonesTable.TABLE) public class ClimateZone implements Parcelable {

  public static final Creator<ClimateZone> CREATOR = new Creator<ClimateZone>() {
    @Override public ClimateZone createFromParcel(Parcel in) {
      return new ClimateZone(in);
    }

    @Override public ClimateZone[] newArray(int size) {
      return new ClimateZone[size];
    }
  };

  @StorIOSQLiteColumn(name = ClimateZonesTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = ClimateZonesTable.COLUMN_NAME) String mName;
  @StorIOSQLiteColumn(name = ClimateZonesTable.COLUMN_COORDINATES) String mCoordinates;

  public ClimateZone() {
    this("", "");
  }

  public ClimateZone(String name) {
    this(name, "");
  }

  public ClimateZone(String mName, String coordinates) {
    this.mName = mName;
    this.mCoordinates = coordinates;
  }

  protected ClimateZone(Parcel in) {
    mName = in.readString();
    mCoordinates = in.readString();
  }

  public ClimateZone newClimateZone(String name) {
    return new ClimateZone(name);
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(mName);
    dest.writeString(mCoordinates);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    ClimateZone that = (ClimateZone) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (mName != null ? !mName.equals(that.mName) : that.mName != null) return false;

    return mCoordinates != null ? mCoordinates.equals(that.mCoordinates)
        : that.mCoordinates == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (mName != null ? mName.hashCode() : 0);
    result = 31 * result + (mCoordinates != null ? mCoordinates.hashCode() : 0);
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

  public String getCoordinates() {
    return mCoordinates;
  }

  public void setCoordinates(String mCoordinates) {
    this.mCoordinates = mCoordinates;
  }
}
