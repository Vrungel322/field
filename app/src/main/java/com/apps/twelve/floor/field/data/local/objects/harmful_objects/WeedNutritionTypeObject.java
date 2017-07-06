package com.apps.twelve.floor.field.data.local.objects.harmful_objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by yarrick on 30.06.17.
 */

public class WeedNutritionTypeObject implements Parcelable {

  public static final Creator<WeedNutritionTypeObject> CREATOR =
      new Creator<WeedNutritionTypeObject>() {
        @Override public WeedNutritionTypeObject createFromParcel(Parcel in) {
          return new WeedNutritionTypeObject(in);
        }

        @Override public WeedNutritionTypeObject[] newArray(int size) {
          return new WeedNutritionTypeObject[size];
        }
      };

  private long mId;
  @NonNull private String mName;

  public WeedNutritionTypeObject(long id, @NonNull String name) {
    this.mId = id;
    this.mName = name;
  }

  protected WeedNutritionTypeObject(Parcel in) {
    mId = in.readLong();
    mName = in.readString();
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeString(mName);
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
}
