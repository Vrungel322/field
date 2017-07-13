package com.apps.twelve.floor.field.data.local.objects.technological_map;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.CropObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.ClimateZoneObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.PhaseObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.ProcessPeriodObject;

/**
 * Created by Yaroslav on 23.05.2017.
 */

public class CropTechnologicalProcessObject implements Parcelable {

  public static final Creator<CropTechnologicalProcessObject> CREATOR =
      new Creator<CropTechnologicalProcessObject>() {
        @Override public CropTechnologicalProcessObject createFromParcel(Parcel in) {
          return new CropTechnologicalProcessObject(in);
        }

        @Override public CropTechnologicalProcessObject[] newArray(int size) {
          return new CropTechnologicalProcessObject[size];
        }
      };

  private long mId;
  @NonNull private String mName;
  private int mOrder;
  @NonNull private CropObject mCrop;
  @NonNull private ClimateZoneObject mClimateZone;
  @NonNull private PhaseObject mPhase;
  @NonNull private ProcessPeriodObject mPeriod;

  public CropTechnologicalProcessObject(long id, @NonNull String name, int order,
      @NonNull CropObject crop, @NonNull ClimateZoneObject climateZone, @NonNull PhaseObject phase,
      @NonNull ProcessPeriodObject period) {
    this.mId = id;
    this.mName = name;
    this.mOrder = order;
    this.mCrop = crop;
    this.mClimateZone = climateZone;
    this.mPhase = phase;
    this.mPeriod = period;
  }

  protected CropTechnologicalProcessObject(Parcel in) {
    this.mId = in.readLong();
    this.mName = in.readString();
    this.mOrder = in.readInt();
    this.mCrop = in.readParcelable(CropObject.class.getClassLoader());
    this.mClimateZone = in.readParcelable(ClimateZoneObject.class.getClassLoader());
    this.mPhase = in.readParcelable(PhaseObject.class.getClassLoader());
    this.mPeriod = in.readParcelable(ProcessPeriodObject.class.getClassLoader());
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeString(mName);
    dest.writeInt(mOrder);
    dest.writeParcelable(mCrop, flags);
    dest.writeParcelable(mClimateZone, flags);
    dest.writeParcelable(mPhase, flags);
    dest.writeParcelable(mPeriod, flags);
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

  public int getOrder() {
    return mOrder;
  }

  public void setOrder(int order) {
    this.mOrder = order;
  }

  public CropObject getCrop() {
    return mCrop;
  }

  public void setCrop(CropObject crop) {
    this.mCrop = crop;
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

  @NonNull public ProcessPeriodObject getPeriod() {
    return mPeriod;
  }

  public void setPeriod(@NonNull ProcessPeriodObject period) {
    this.mPeriod = period;
  }

  public long getCropId() {
    return mCrop.getId();
  }

  public long getClimateZoneId() {
    return mClimateZone.getId();
  }

  public long getPeriodId() {
    return mPeriod.getId();
  }

  public long getPhaseId() {
    return mPhase.getId();
  }
}
