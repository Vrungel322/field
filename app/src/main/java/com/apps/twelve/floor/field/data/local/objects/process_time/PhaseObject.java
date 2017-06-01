package com.apps.twelve.floor.field.data.local.objects.process_time;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.CropObject;

/**
 * Created by Yaroslav on 23.05.2017.
 */

public class PhaseObject implements Parcelable {

  public static final Creator<PhaseObject> CREATOR = new Creator<PhaseObject>() {
    @Override public PhaseObject createFromParcel(Parcel in) {
      return new PhaseObject(in);
    }

    @Override public PhaseObject[] newArray(int size) {
      return new PhaseObject[size];
    }
  };

  private long mId;
  @NonNull private String mName;
  @NonNull private CropObject mCrop;

  public PhaseObject(long id, @NonNull String name, @NonNull CropObject crop) {
    this.mId = id;
    this.mName = name;
    this.mCrop = crop;
  }

  protected PhaseObject(Parcel in) {
    this.mId = in.readLong();
    this.mName = in.readString();
    this.mCrop = in.readParcelable(CropObject.class.getClassLoader());
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeString(mName);
    dest.writeParcelable(mCrop, flags);
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

  public void setName(@NonNull String name) {
    this.mName = name;
  }

  public CropObject getCrop() {
    return mCrop;
  }

  public void setCrop(@NonNull CropObject crop) {
    this.mCrop = crop;
  }
}
