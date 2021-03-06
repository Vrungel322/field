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
  public static final Creator<FieldObject> CREATOR = new Creator<FieldObject>() {
    @Override public FieldObject createFromParcel(Parcel in) {
      return new FieldObject(in);
    }

    @Override public FieldObject[] newArray(int size) {
      return new FieldObject[size];
    }
  };

  static {
    EMPTY = new FieldObject(0, "", CropObject.EMPTY, null, "", 0, ClimateZoneObject.EMPTY,
        PhaseObject.EMPTY, SoilTypeObject.EMPTY, 0);
  }

  private long mId;
  @NonNull private String mName = "";
  @NonNull private CropObject mCrop;
  @Nullable private CropObject mPreviousCrop;
  @NonNull private List<LatLng> mPoints = new ArrayList<>();
  private double mArea;
  @NonNull private ClimateZoneObject mClimateZone;
  @NonNull private PhaseObject mPhase;
  @NonNull private SoilTypeObject mSoilType;
  private long mSowingDate;

  public FieldObject(long id, @NonNull String name, @NonNull CropObject crop,
      @Nullable CropObject previousCrop, @NonNull String coordinates, double area,
      @NonNull ClimateZoneObject climateZone, @NonNull PhaseObject phase,
      @NonNull SoilTypeObject soilType, long sowingDate) {
    this(id, name, crop, previousCrop, new ArrayList<LatLng>(), area, climateZone, phase, soilType,
        sowingDate);
    mPoints.clear();
    mPoints.addAll(LatLngStringUtil.LatLngsFromString(coordinates));
  }

  public FieldObject(long id, @NonNull String name, @NonNull CropObject crop,
      @Nullable CropObject previousCrop, @NonNull List<LatLng> points, double area,
      @NonNull ClimateZoneObject climateZone, @NonNull PhaseObject phase,
      @NonNull SoilTypeObject soilType, long sowingDate) {
    this.mId = id;
    this.mName = name;
    this.mCrop = crop;
    this.mPreviousCrop = previousCrop;
    this.mPoints = points;
    this.mArea = area;
    this.mClimateZone = climateZone;
    this.mPhase = phase;
    this.mSoilType = soilType;
    this.mSowingDate = sowingDate;
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
    this.mSoilType = in.readParcelable(SoilTypeObject.class.getClassLoader());
    this.mSowingDate = in.readLong();
  }

  public static FieldObject newInstance() {
    return new FieldObject(0, "", CropObject.EMPTY, null, "", 0, ClimateZoneObject.EMPTY,
        PhaseObject.EMPTY, SoilTypeObject.EMPTY, 0);
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
    dest.writeParcelable(mSoilType, flags);
    dest.writeLong(mSowingDate);
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

  @NonNull public SoilTypeObject getSoilType() {
    return mSoilType;
  }

  public void setSoilType(@NonNull SoilTypeObject soilType) {
    this.mSoilType = soilType;
  }

  @NonNull public String getPointsAsCoordinatesString() {
    return LatLngStringUtil.stringFromLatLngs(mPoints);
  }

  public boolean hasPoints() {
    return mPoints.size() > 0;
  }

  public void clearPoints() {
    mPoints.clear();
  }

  public void addAllPoints(List<LatLng> points) {
    mPoints.addAll(points);
  }

  public long getCropId() {
    return mCrop.getId();
  }

  public long getPreviousCropId() {
    if ((mPreviousCrop == null)) {
      return 0;
    }

    return mPreviousCrop.getId();
  }

  public long getClimateZoneId() {
    return mClimateZone.getId();
  }

  public long getPhaseId() {
    return mPhase.getId();
  }

  public long getSoilTypeId() {
    return mSoilType.getId();
  }

  public long getSowingDate() {
    return mSowingDate;
  }

  public void setSowingDate(long sowingDate) {
    this.mSowingDate = sowingDate;
  }

  public String getCropName() {
    return mCrop.getName();
  }

  public String getPhaseName() {
    return mPhase.getName();
  }
}