package com.apps.twelve.floor.field.data.local.objects.solutions;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessObject;

/**
 * Created by Yaroslav on 25.05.2017.
 */

public class FieldTechnologicalProcessSolutionObject implements Parcelable {

  public static final Creator<FieldTechnologicalProcessSolutionObject> CREATOR =
      new Creator<FieldTechnologicalProcessSolutionObject>() {
        @Override public FieldTechnologicalProcessSolutionObject createFromParcel(Parcel in) {
          return new FieldTechnologicalProcessSolutionObject(in);
        }

        @Override public FieldTechnologicalProcessSolutionObject[] newArray(int size) {
          return new FieldTechnologicalProcessSolutionObject[size];
        }
      };

  private long mId;
  @NonNull private FieldCropTechnologicalProcessObject mTechnologicalProcess;
  @NonNull private TechnologicalSolutionTypeObject mType;
  @NonNull private BaseTechnologicalSolutionObject mSolutionValue;

  public FieldTechnologicalProcessSolutionObject(long id,
      @NonNull FieldCropTechnologicalProcessObject technologicalProcess,
      @NonNull TechnologicalSolutionTypeObject type,
      @NonNull BaseTechnologicalSolutionObject solutionValue) {
    this.mId = id;
    this.mTechnologicalProcess = technologicalProcess;
    this.mType = type;
    this.mSolutionValue = solutionValue;
  }

  protected FieldTechnologicalProcessSolutionObject(Parcel in) {
    this.mId = in.readLong();
    this.mTechnologicalProcess =
        in.readParcelable(FieldCropTechnologicalProcessObject.class.getClassLoader());
    this.mType = in.readParcelable(TechnologicalSolutionTypeObject.class.getClassLoader());
    this.mSolutionValue = in.readParcelable(BaseTechnologicalSolutionObject.class.getClassLoader());
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeParcelable(mTechnologicalProcess, flags);
    dest.writeParcelable(mType, flags);
    dest.writeParcelable(mSolutionValue, flags);
  }

  public long getId() {
    return mId;
  }

  public void setId(long id) {
    this.mId = id;
  }

  public FieldCropTechnologicalProcessObject getTechnologicalProcess() {
    return mTechnologicalProcess;
  }

  public void setTechnologicalProcess(
      @NonNull FieldCropTechnologicalProcessObject technologicalProcess) {
    this.mTechnologicalProcess = technologicalProcess;
  }

  public TechnologicalSolutionTypeObject getType() {
    return mType;
  }

  public void setType(@NonNull TechnologicalSolutionTypeObject type) {
    this.mType = type;
  }

  public BaseTechnologicalSolutionObject getSolutionValue() {
    return mSolutionValue;
  }

  public void setSolutionValue(@NonNull BaseTechnologicalSolutionObject solutionValue) {
    this.mSolutionValue = solutionValue;
  }
}
