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
  @NonNull private TechnologicalSolutionObject mSolution;

  public FieldTechnologicalProcessSolutionObject(long id,
      @NonNull FieldCropTechnologicalProcessObject technologicalProcess,
      @NonNull TechnologicalSolutionObject solution) {
    this.mId = id;
    this.mTechnologicalProcess = technologicalProcess;
    this.mSolution = solution;
  }

  protected FieldTechnologicalProcessSolutionObject(Parcel in) {
    this.mId = in.readLong();
    this.mTechnologicalProcess =
        in.readParcelable(FieldCropTechnologicalProcessObject.class.getClassLoader());
    this.mSolution = in.readParcelable(TechnologicalSolutionObject.class.getClassLoader());
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeParcelable(mTechnologicalProcess, flags);
    dest.writeParcelable(mSolution, flags);
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

  public TechnologicalSolutionObject getSolution() {
    return mSolution;
  }

  public void setSolution(@NonNull TechnologicalSolutionObject solution) {
    this.mSolution = solution;
  }

  public String getSolutionName() {
    return mSolution.getSolutionValue().getName();
  }

  public long getSolutionPrice() {
    return mSolution.getSolutionValue().getPrice();
  }

  public long calculateSolutionQuantity() {
    // TODO: calculate real quantity, depending on TP needs
    return 20;
  }

  public long calculateSolutionAmount() {
    return getSolutionPrice() * calculateSolutionQuantity();
  }
}
