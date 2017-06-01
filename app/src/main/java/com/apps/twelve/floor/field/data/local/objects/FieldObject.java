package com.apps.twelve.floor.field.data.local.objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.apps.twelve.floor.field.data.local.objects.process_time.ClimateZoneObject;
import com.apps.twelve.floor.field.utils.LatLngStringUtil;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav on 12.05.2017.
 */

public class FieldObject implements Parcelable {

  public static final Creator<FieldObject> CREATOR = new Creator<FieldObject>() {
    @Override public FieldObject createFromParcel(Parcel in) {
      return new FieldObject(in);
    }

    @Override public FieldObject[] newArray(int size) {
      return new FieldObject[size];
    }
  };

  private long mId;
  @NonNull private String mName = "";
  @NonNull private CropObject mCrop;
  @Nullable private CropObject mPreviousCrop;
  @NonNull private List<LatLng> mPoints = new ArrayList<>();
  private double mArea;
  @NonNull private ClimateZoneObject mClimateZone;

  public FieldObject(long id, String name, CropObject crop, CropObject previousCrop,
      String coordinates, double area, ClimateZoneObject climateZone) {
    this(id, name, crop, previousCrop, new ArrayList<LatLng>(), area, climateZone);
    mPoints.clear();
    mPoints.addAll(LatLngStringUtil.LatLngsFromString(coordinates));
  }

  public FieldObject(long id, @NonNull String name, @NonNull CropObject crop,
      @Nullable CropObject previousCrop, @NonNull List<LatLng> points, double area,
      @NonNull ClimateZoneObject climateZone) {
    this.mId = id;
    this.mName = name;
    this.mCrop = crop;
    this.mPreviousCrop = previousCrop;
    this.mPoints = points;
    this.mArea = area;
    this.mClimateZone = climateZone;
  }

  protected FieldObject(Parcel in) {
    this.mId = in.readLong();
    this.mName = in.readString();
    this.mCrop = in.readParcelable(CropObject.class.getClassLoader());
    this.mPreviousCrop = in.readParcelable(CropObject.class.getClassLoader());
    this.mPoints = in.createTypedArrayList(LatLng.CREATOR);
    this.mArea = in.readDouble();
    this.mClimateZone = in.readParcelable(ClimateZoneObject.class.getClassLoader());
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeString(mName);
    dest.writeParcelable(mCrop, flags);
    dest.writeParcelable(mPreviousCrop, flags);
    dest.writeTypedList(mPoints);
    dest.writeDouble(mArea);
    dest.writeParcelable(mClimateZone, flags);
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

  public void setName(String name) {
    this.mName = name;
  }

  public CropObject getCrop() {
    return mCrop;
  }

  public void setCrop(CropObject crop) {
    this.mCrop = crop;
  }

  @Nullable public CropObject getPreviousCrop() {
    return mPreviousCrop;
  }

  public void setPreviousCrop(CropObject previousCrop) {
    this.mPreviousCrop = previousCrop;
  }

  public List<LatLng> getPoints() {
    return mPoints;
  }

  public void setPoints(List<LatLng> points) {
    this.mPoints = points;
  }

  public double getArea() {
    return mArea;
  }

  public void setArea(double area) {
    this.mArea = area;
  }

  public ClimateZoneObject getClimateZone() {
    return mClimateZone;
  }

  public void setClimateZone(ClimateZoneObject climateZone) {
    this.mClimateZone = climateZone;
  }

  public String getPointsAsCoordinatesString() {
    return LatLngStringUtil.stringFromLatLngs(mPoints);
  }

  public boolean hasPoints() {
    return mPoints != null && mPoints.size() > 0;
  }

  public void clearPoints() {
    mPoints.clear();
  }

  public void addAllPoints(List<LatLng> points) {
    mPoints.addAll(points);
  }
}