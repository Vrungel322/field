package com.apps.twelve.floor.field.mvp.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.apps.twelve.floor.field.mvp.data.local.tables.FieldsTable;
import com.google.android.gms.maps.model.LatLng;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;
import java.util.ArrayList;
import java.util.List;
import timber.log.Timber;

/**
 * Created by John on 27.03.2017.
 */

@StorIOSQLiteType(table = FieldsTable.TABLE)
public class Field implements Parcelable {

  public static final Creator<Field> CREATOR = new Creator<Field>() {
    @Override public Field createFromParcel(Parcel in) {
      return new Field(in);
    }

    @Override public Field[] newArray(int size) {
      return new Field[size];
    }
  };

  @StorIOSQLiteColumn(name = FieldsTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = FieldsTable.COLUMN_NAME) String mName;
  @StorIOSQLiteColumn(name = FieldsTable.COLUMN_AREA) Double mArea;
  @StorIOSQLiteColumn(name = FieldsTable.COLUMN_CROP) String mCrop;

  private List<LatLng> mPoints = new ArrayList<>();
      // TODO: got to keep these in own tbl and get here

  public Field() {
  }

  public Field(String name, String crop, Double area) {
    this.mName = name;
    this.mCrop = crop;
    this.mArea = area;
  }

  public static Field newField(String name, String crop, Double area) {
    return new Field(name, crop, area);
  }

  protected Field(Parcel in) {
    mName = in.readString();
    mArea = in.readDouble();
    mCrop = in.readString();
    mPoints = in.createTypedArrayList(LatLng.CREATOR);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    Field that = (Field) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (mName != null ? !mName.equals(that.mName) : that.mName != null) return false;
    if (mArea != null ? !mArea.equals(that.mArea) : that.mArea != null) return false;
    if (mCrop != null ? !mCrop.equals(that.mCrop) : that.mCrop != null) return false;

    return mPoints != null ? mPoints.equals(that.mPoints) : that.mPoints == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (mName != null ? mName.hashCode() : 0);
    result = 31 * result + (mCrop != null ? mCrop.hashCode() : 0);
    result = 31 * result + (mArea != null ? mArea.hashCode() : 0);
    result = 31 * result + (mPoints != null ? mPoints.hashCode() : 0);
    return result;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(mName);
    dest.writeDouble(mArea);
    dest.writeString(mCrop);
    dest.writeTypedList(mPoints);
  }

  public String getName() {
    return mName;
  }

  public void setName(String name) {
    this.mName = name;
  }

  public Double getArea() {
    return mArea;
  }

  public void setArea(double area) {
    this.mArea = area;
  }

  public List<LatLng> getPoints() {
    return mPoints;
  }

  public void addAllPoints(List<LatLng> points) {
    this.mPoints.addAll(points);
  }

  public void addPoint(LatLng point) {
    this.mPoints.add(point);
  }

  public void updatePoint(int index, LatLng point) {
    if (!isOkIndex(index)) return;
    this.mPoints.set(index, point);
  }

  public void removePoint(int index, LatLng point) {
    if (!isOkIndex(index)) return;
    this.mPoints.remove(point);
  }

  public void clearPoints() {
    mPoints.clear();
  }

  public String getCrop() {
    return mCrop;
  }

  public void setCrop(String crop) {
    this.mCrop = crop;
  }

  public boolean hasPoints() {
    return mPoints != null && mPoints.size() > 0;
  }

  private boolean isOkIndex(int index) {
    if (index < 0 || mPoints.size() <= index) {
      Timber.e("Invalid point index");
      return false;
    }

    return true;
  }
}
