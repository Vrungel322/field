package com.apps.twelve.floor.field.data.local.objects.technological_map;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.IObject;

/**
 * Created by yarrick on 11.09.17.
 */

public class CropTechnologicalProcessesSequenceObject implements IObject, Parcelable {
  public static final Creator<CropTechnologicalProcessesSequenceObject> CREATOR =
      new Creator<CropTechnologicalProcessesSequenceObject>() {
        @Override public CropTechnologicalProcessesSequenceObject createFromParcel(Parcel in) {
          return new CropTechnologicalProcessesSequenceObject(in);
        }

        @Override public CropTechnologicalProcessesSequenceObject[] newArray(int size) {
          return new CropTechnologicalProcessesSequenceObject[size];
        }
      };

  private long mId;
  @NonNull CropTechnologicalProcessObject mCropTechnologicalProcessObject;
  @NonNull CropTechnologicalProcessObject mNextCropTechnologicalProcessObject;

  public CropTechnologicalProcessesSequenceObject(long id,
      @NonNull CropTechnologicalProcessObject cropTechnologicalProcessObject,
      @NonNull CropTechnologicalProcessObject nextCropTechnologicalProcessObject) {
    this.mId = id;
    this.mCropTechnologicalProcessObject = cropTechnologicalProcessObject;
    this.mNextCropTechnologicalProcessObject = nextCropTechnologicalProcessObject;
  }

  protected CropTechnologicalProcessesSequenceObject(Parcel in) {
    mId = in.readLong();
    mCropTechnologicalProcessObject =
        in.readParcelable(CropTechnologicalProcessObject.class.getClassLoader());
    mNextCropTechnologicalProcessObject =
        in.readParcelable(CropTechnologicalProcessObject.class.getClassLoader());
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeParcelable(mCropTechnologicalProcessObject, flags);
    dest.writeParcelable(mNextCropTechnologicalProcessObject, flags);
  }

  public long getId() {
    return mId;
  }

  public void setId(long id) {
    this.mId = id;
  }

  @NonNull public CropTechnologicalProcessObject getCropTechnologicalProcessObject() {
    return mCropTechnologicalProcessObject;
  }

  public void setCropTechnologicalProcessObject(
      @NonNull CropTechnologicalProcessObject cropTechnologicalProcessObject) {
    this.mCropTechnologicalProcessObject = cropTechnologicalProcessObject;
  }

  @NonNull public CropTechnologicalProcessObject getNextCropTechnologicalProcessObject() {
    return mNextCropTechnologicalProcessObject;
  }

  public void setNextCropTechnologicalProcessObject(
      @NonNull CropTechnologicalProcessObject nextCropTechnologicalProcessObject) {
    this.mNextCropTechnologicalProcessObject = nextCropTechnologicalProcessObject;
  }

  public long getCropTechnologicalProcessObjectId() {
    return mCropTechnologicalProcessObject.getId();
  }

  public long getNextCropTechnologicalProcessObjectId() {
    return mNextCropTechnologicalProcessObject.getId();
  }
}
