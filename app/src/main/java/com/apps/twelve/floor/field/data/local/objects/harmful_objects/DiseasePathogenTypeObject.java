package com.apps.twelve.floor.field.data.local.objects.harmful_objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.IObject;

/**
 * Created by yarrick on 05.09.17.
 */

public class DiseasePathogenTypeObject implements IObject, Parcelable {
  public static final Creator<DiseasePathogenTypeObject> CREATOR =
      new Creator<DiseasePathogenTypeObject>() {
        @Override public DiseasePathogenTypeObject createFromParcel(Parcel in) {
          return new DiseasePathogenTypeObject(in);
        }

        @Override public DiseasePathogenTypeObject[] newArray(int size) {
          return new DiseasePathogenTypeObject[size];
        }
      };

  private long mId;
  @NonNull private String mName;

  public DiseasePathogenTypeObject(long id, @NonNull String name) {
    this.mId = id;
    this.mName = name;
  }

  protected DiseasePathogenTypeObject(Parcel in) {
    mId = in.readLong();
    mName = in.readString();
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeString(mName);
  }

  @Override public int describeContents() {
    return 0;
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
