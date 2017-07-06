package com.apps.twelve.floor.field.data.local.objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.HarmfulObjectObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.ActiveComponentObject;

/**
 * Created by Yaroslav on 01.06.2017.
 */

public class CropActiveComponentHarmfulObjectObject implements Parcelable {

  public static final Creator<CropActiveComponentHarmfulObjectObject> CREATOR =
      new Creator<CropActiveComponentHarmfulObjectObject>() {
        @Override public CropActiveComponentHarmfulObjectObject createFromParcel(Parcel in) {
          return new CropActiveComponentHarmfulObjectObject(in);
        }

        @Override public CropActiveComponentHarmfulObjectObject[] newArray(int size) {
          return new CropActiveComponentHarmfulObjectObject[size];
        }
      };

  private long mId;
  @NonNull private CropObject mCrop;
  @NonNull private ActiveComponentObject mActiveComponent;
  @NonNull private HarmfulObjectObject mHarmfulObject;

  public CropActiveComponentHarmfulObjectObject(long id, @NonNull CropObject crop,
      @NonNull ActiveComponentObject activeComponent, @NonNull HarmfulObjectObject harmfulObject) {
    this.mId = id;
    this.mCrop = crop;
    this.mActiveComponent = activeComponent;
    this.mHarmfulObject = harmfulObject;
  }

  protected CropActiveComponentHarmfulObjectObject(Parcel in) {
    this.mId = in.readLong();
    this.mCrop = in.readParcelable(CropObject.class.getClassLoader());
    this.mActiveComponent = in.readParcelable(ActiveComponentObject.class.getClassLoader());
    this.mHarmfulObject = in.readParcelable(HarmfulObjectObject.class.getClassLoader());
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeParcelable(mCrop, flags);
    dest.writeParcelable(mActiveComponent, flags);
    dest.writeParcelable(mHarmfulObject, flags);
  }

  public long getId() {
    return mId;
  }

  public void setId(long id) {
    this.mId = id;
  }

  @NonNull public CropObject getCrop() {
    return mCrop;
  }

  public void setCrop(@NonNull CropObject crop) {
    this.mCrop = crop;
  }

  @NonNull public ActiveComponentObject getActiveComponent() {
    return mActiveComponent;
  }

  public void setActiveComponent(@NonNull ActiveComponentObject activeComponent) {
    this.mActiveComponent = activeComponent;
  }

  @NonNull public HarmfulObjectObject getHarmfulObject() {
    return mHarmfulObject;
  }

  public void setHarmfulObject(@NonNull HarmfulObjectObject harmfulObject) {
    this.mHarmfulObject = harmfulObject;
  }
}
