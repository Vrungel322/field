package com.apps.twelve.floor.field.mvp.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.apps.twelve.floor.field.mvp.data.local.tables.FieldsTable;
import com.apps.twelve.floor.field.utils.Constants.StringSeparators;
import com.google.android.gms.maps.model.LatLng;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;
import java.util.ArrayList;
import java.util.List;
import timber.log.Timber;

/**
 * Created by John on 27.03.2017.
 */

@StorIOSQLiteType(table = FieldsTable.TABLE) public class Field implements Parcelable {

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
  @StorIOSQLiteColumn(name = FieldsTable.COLUMN_CROP_ID) Integer mCropId;
  @StorIOSQLiteColumn(name = FieldsTable.COLUMN_PREV_CROP_ID) Integer mPreviousCropId;
  @StorIOSQLiteColumn(name = FieldsTable.COLUMN_COORDINATES) String mCoordinates;
  @StorIOSQLiteColumn(name = FieldsTable.COLUMN_CLIMATE_ZONE_ID) Integer mClimateZoneId;

  private List<LatLng> mPoints = new ArrayList<>();
  //private Crop mCrop;

  public Field() {
    this("", null, null, 0.0D);
  }

  public Field(String name, Integer cropId, Integer previousCropId, Double area) {
    this(name, cropId, previousCropId, area, "");
  }

  public Field(String name, Integer cropId, Integer previousCropId, Double area,
      String coordinates) {
    this.mName = name;
    this.mCropId = cropId;
    this.mPreviousCropId = previousCropId;
    this.mArea = area;
    this.mCoordinates = coordinates;
  }

  public static Field newField(String name, Integer cropId, Integer previousCropId, Double area) {
    return new Field(name, cropId, previousCropId, area);
  }

  protected Field(Parcel in) {
    mName = in.readString();
    mArea = in.readDouble();
    mCropId = in.readInt();
    mPreviousCropId = in.readInt();
    mCoordinates = in.readString();
    mClimateZoneId = in.readInt();
    mPoints = in.createTypedArrayList(LatLng.CREATOR);
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(mName);
    dest.writeDouble(mArea);
    dest.writeInt(mCropId);
    dest.writeInt(mPreviousCropId);
    dest.writeString(mCoordinates);
    dest.writeInt(mClimateZoneId);
    dest.writeTypedList(mPoints);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    Field that = (Field) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (mName != null ? !mName.equals(that.mName) : that.mName != null) return false;
    if (mArea != null ? !mArea.equals(that.mArea) : that.mArea != null) return false;
    if (mCropId != null ? !mCropId.equals(that.mCropId) : that.mCropId != null) return false;
    if (mPreviousCropId != null ? !mPreviousCropId.equals(that.mPreviousCropId)
        : that.mPreviousCropId != null) {
      return false;
    }
    if (mCoordinates != null ? !mCoordinates.equals(that.mCoordinates)
        : that.mCoordinates != null) {
      return false;
    }
    if (mClimateZoneId != null ? !mClimateZoneId.equals(that.mClimateZoneId)
        : that.mClimateZoneId != null) {
      return false;
    }

    return mPoints != null ? mPoints.equals(that.mPoints) : that.mPoints == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (mName != null ? mName.hashCode() : 0);
    result = 31 * result + (mArea != null ? mArea.hashCode() : 0);
    result = 31 * result + (mCropId != null ? mCropId.hashCode() : 0);
    result = 31 * result + (mPreviousCropId != null ? mPreviousCropId.hashCode() : 0);
    result = 31 * result + (mCoordinates != null ? mCoordinates.hashCode() : 0);
    result = 31 * result + (mClimateZoneId != null ? mClimateZoneId.hashCode() : 0);
    result = 31 * result + (mPoints != null ? mPoints.hashCode() : 0);
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

  public void setName(String name) {
    this.mName = name;
  }

  public Double getArea() {
    return mArea;
  }

  public void setArea(double area) {
    this.mArea = area;
  }

  public Integer getCropId() {
    return mCropId;
  }

  public void setCropId(Integer cropId) {
    this.mCropId = cropId;
  }

  public Integer getPreviousCropId() {
    return mPreviousCropId;
  }

  public void setPreviousCropId(Integer cropId) {
    this.mPreviousCropId = cropId;
  }

  /*public Crop getCrop() {
    return mCrop;
  }

  public void setCrop(Crop mCrop) {
    this.mCrop = mCrop;
  }*/

  public String getCoordinates() {
    return mCoordinates;
  }

  public void setCoordinates(String mCoordinates) {
    this.mCoordinates = mCoordinates;
    saveStringCoordinatesToArray();
  }

  public Integer getClimateZoneId() {
    return mClimateZoneId;
  }

  public void setClimateZoneId(Integer mClimateZoneId) {
    this.mClimateZoneId = mClimateZoneId;
  }

  public List<LatLng> getPoints() {
    return mPoints;
  }

  public void addAllPoints(List<LatLng> points) {
    this.mPoints.addAll(points);
    saveCoordinatesArrayToString();
  }

  public void addPoint(LatLng point) {
    this.mPoints.add(point);
    saveCoordinatesArrayToString();
  }

  public void updatePoint(int index, LatLng point) {
    if (!isOkIndex(index)) return;
    this.mPoints.set(index, point);
    saveCoordinatesArrayToString();
  }

  public void removePoint(int index, LatLng point) {
    if (!isOkIndex(index)) return;
    this.mPoints.remove(point);
    saveCoordinatesArrayToString();
  }

  public void clearPoints() {
    mPoints.clear();
    mCoordinates = "";
  }

  public boolean hasPoints() {
    return mPoints != null && mPoints.size() > 0;
  }

  private void saveStringCoordinatesToArray() {

    String[] latLngs;
    String[] coords = mCoordinates.split(StringSeparators.SEPARATOR_OUTER);

    List<LatLng> points = new ArrayList<>(coords.length);

    for (String coord : coords) {
      latLngs = coord.split(StringSeparators.SEPARATOR_INNER);
      points.add(new LatLng(Double.valueOf(latLngs[0]), Double.valueOf(latLngs[1])));
    }

    clearPoints();
    this.mPoints.addAll(points);
  }

  private void saveCoordinatesArrayToString() {
    String res = "";

    for (int i = 0; i < mPoints.size(); i++) {
      res +=
          mPoints.get(i).latitude + StringSeparators.SEPARATOR_INNER + mPoints.get(i).longitude + (
              (i < mPoints.size() - 1) ? StringSeparators.SEPARATOR_OUTER : "");
    }

    this.mCoordinates = res;
  }

  private boolean isOkIndex(int index) {
    if (index < 0 || mPoints.size() <= index) {
      Timber.e("Invalid point index");
      return false;
    }

    return true;
  }
}
