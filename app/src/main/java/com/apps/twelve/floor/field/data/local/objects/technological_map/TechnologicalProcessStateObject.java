package com.apps.twelve.floor.field.data.local.objects.technological_map;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.R;

/**
 * Created by Yaroslav on 23.05.2017.
 */

public class TechnologicalProcessStateObject implements Parcelable {

  public static final Creator<TechnologicalProcessStateObject> CREATOR =
      new Creator<TechnologicalProcessStateObject>() {
        @Override public TechnologicalProcessStateObject createFromParcel(Parcel in) {
          return new TechnologicalProcessStateObject(in);
        }

        @Override public TechnologicalProcessStateObject[] newArray(int size) {
          return new TechnologicalProcessStateObject[size];
        }
      };

  private long mId;
  @NonNull private String mName;
  private int mImageResourceId;

  public TechnologicalProcessStateObject(long mId, @NonNull String mName, int imageResourceId) {
    this.mId = mId;
    this.mName = mName;
    this.mImageResourceId = imageResourceId;
  }

  protected TechnologicalProcessStateObject(Parcel in) {
    this.mId = in.readLong();
    this.mName = in.readString();
    this.mImageResourceId = in.readInt();
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeString(mName);
    dest.writeInt(mImageResourceId);
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

  // TODO: keep status images in resources, and their ids - in DB
  public int getImageId() {
    return R.mipmap.ic_launcher_round;
    //return mImageResourceId;
  }

  public void setImageId(int imageId) {
    this.mImageResourceId = imageId;
  }
}
