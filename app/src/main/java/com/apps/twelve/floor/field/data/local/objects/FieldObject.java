package com.apps.twelve.floor.field.data.local.objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.apps.twelve.floor.field.data.local.objects.process_time.ClimateZoneObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.PhaseObject;
import com.apps.twelve.floor.field.utils.LatLngStringUtil;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav on 12.05.2017.
 */

public class FieldObject implements Parcelable, Cloneable {

  public static final FieldObject EMPTY;

  static {
    EMPTY = new FieldObject(0, "", CropObject.EMPTY, null, "", 0, ClimateZoneObject.EMPTY,
        PhaseObject.EMPTY);
  }

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
  @NonNull private PhaseObject mPhase;

  public FieldObject(long id, @NonNull String name, @NonNull CropObject crop,
      @Nullable CropObject previousCrop, @NonNull String coordinates, double area,
      @NonNull ClimateZoneObject climateZone, @NonNull PhaseObject phase) {
    this(id, name, crop, previousCrop, new ArrayList<LatLng>(), area, climateZone, phase);
    mPoints.clear();
    mPoints.addAll(LatLngStringUtil.LatLngsFromString(coordinates));
  }

  public FieldObject(long id, @NonNull String name, @NonNull CropObject crop,
      @Nullable CropObject previousCrop, @NonNull List<LatLng> points, double area,
      @NonNull ClimateZoneObject climateZone, @NonNull PhaseObject phase) {
    this.mId = id;
    this.mName = name;
    this.mCrop = crop;
    this.mPreviousCrop = previousCrop;
    this.mPoints = points;
    this.mArea = area;
    this.mClimateZone = climateZone;
    this.mPhase = phase;
  }

  protected FieldObject(Parcel in) {
    this.mId = in.readLong();
    this.mName = in.readString();
    this.mCrop = in.readParcelable(CropObject.class.getClassLoader());
    this.mPreviousCrop = in.readParcelable(CropObject.class.getClassLoader());
    this.mPoints = in.createTypedArrayList(LatLng.CREATOR);
    this.mArea = in.readDouble();
    this.mClimateZone = in.readParcelable(ClimateZoneObject.class.getClassLoader());
    this.mPhase = in.readParcelable(PhaseObject.class.getClassLoader());
  }

  public static FieldObject newInstance() {
    return new FieldObject(0, "", CropObject.EMPTY, null, "", 0, ClimateZoneObject.EMPTY,
        PhaseObject.EMPTY);
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
    dest.writeParcelable(mPhase, flags);
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

  @NonNull public CropObject getCrop() {
    return mCrop;
  }

  public void setCrop(@NonNull CropObject crop) {
    this.mCrop = crop;
  }

  @Nullable public CropObject getPreviousCrop() {
    return mPreviousCrop;
  }

  public void setPreviousCrop(@Nullable CropObject previousCrop) {
    this.mPreviousCrop = previousCrop;
  }

  @NonNull public List<LatLng> getPoints() {
    return mPoints;
  }

  public void setPoints(@NonNull List<LatLng> points) {
    this.mPoints = points;
  }

  public double getArea() {
    return mArea;
  }

  public void setArea(double area) {
    this.mArea = area;
  }

  @NonNull public ClimateZoneObject getClimateZone() {
    return mClimateZone;
  }

  public void setClimateZone(@NonNull ClimateZoneObject climateZone) {
    this.mClimateZone = climateZone;
  }

  @NonNull public PhaseObject getPhase() {
    return mPhase;
  }

  public void setPhase(@NonNull PhaseObject phase) {
    this.mPhase = phase;
  }

  @NonNull public String getPointsAsCoordinatesString() {
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