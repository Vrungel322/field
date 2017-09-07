package com.apps.twelve.floor.field.data.local.objects.technological_map;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.FieldObject;

/**
 * Created by Yaroslav on 23.05.2017.
 */

public class FieldCropTechnologicalProcessObject implements Parcelable {

  public static final Creator<FieldCropTechnologicalProcessObject> CREATOR =
      new Creator<FieldCropTechnologicalProcessObject>() {
        @Override public FieldCropTechnologicalProcessObject createFromParcel(Parcel in) {
          return new FieldCropTechnologicalProcessObject(in);
        }

        @Override public FieldCropTechnologicalProcessObject[] newArray(int size) {
          return new FieldCropTechnologicalProcessObject[size];
        }
      };

  private long mId;
  @NonNull private FieldObject mField;
  @NonNull private CropTechnologicalProcessObject mTechProcess;
  @NonNull private TechnologicalProcessStateObject mState;

  public FieldCropTechnologicalProcessObject(long id, @NonNull FieldObject field,
      @NonNull CropTechnologicalProcessObject techProcess,
      @NonNull TechnologicalProcessStateObject status) {
    this.mId = id;
    this.mField = field;
    this.mTechProcess = techProcess;
    this.mState = status;
  }

  protected FieldCropTechnologicalProcessObject(Parcel in) {
    this.mId = in.readLong();
    this.mField = in.readParcelable(FieldObject.class.getClassLoader());
    this.mTechProcess = in.readParcelable(CropTechnologicalProcessObject.class.getClassLoader());
    this.mState = in.readParcelable(TechnologicalProcessStateObject.class.getClassLoader());
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeParcelable(mField, flags);
    dest.writeParcelable(mTechProcess, flags);
    dest.writeParcelable(mState, flags);
  }

  public long getId() {
    return mId;
  }

  public void setId(long id) {
    this.mId = id;
  }

  public FieldObject getField() {
    return mField;
  }

  public void setField(@NonNull FieldObject field) {
    this.mField = field;
  }

  public CropTechnologicalProcessObject getTechProcess() {
    return mTechProcess;
  }

  public void setTechProcess(@NonNull CropTechnologicalProcessObject techProcess) {
    this.mTechProcess = techProcess;
  }

  public TechnologicalProcessStateObject getState() {
    return mState;
  }

  public void setState(@NonNull TechnologicalProcessStateObject state) {
    this.mState = state;
  }

  public String getTechProcessName() {
    return mTechProcess.getName();
  }

  public String getTechProcessPeriodRepresentation(Context context) {
    return mTechProcess.getPeriod().getRepresentation(context);
  }

  @DrawableRes public int getStatusImageId() {
    return mState.getImageId();
  }

  public String getTechProcessFieldRepresentation() {
    return mField.getName();
  }
}
