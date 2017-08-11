package com.apps.twelve.floor.field.data.local.objects.solutions;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.IObject;

/**
 * Created by Yaroslav on 25.05.2017.
 */

public class TechnologicalSolutionTypeObject implements IObject, Parcelable {

  public static final Creator<TechnologicalSolutionTypeObject> CREATOR =
      new Creator<TechnologicalSolutionTypeObject>() {
        @Override public TechnologicalSolutionTypeObject createFromParcel(Parcel in) {
          return new TechnologicalSolutionTypeObject(in);
        }

        @Override public TechnologicalSolutionTypeObject[] newArray(int size) {
          return new TechnologicalSolutionTypeObject[size];
        }
      };

  private long mId;
  @NonNull private String mName;

  public TechnologicalSolutionTypeObject(long id, @NonNull String name) {
    this.mId = id;
    this.mName = name;
  }

  protected TechnologicalSolutionTypeObject(Parcel in) {
    this.mId = in.readLong();
    this.mName = in.readString();
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeString(mName);
  }

  // TODO: get name in adapter, not here
  @Override public String toString() {
    return mName;
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
}
