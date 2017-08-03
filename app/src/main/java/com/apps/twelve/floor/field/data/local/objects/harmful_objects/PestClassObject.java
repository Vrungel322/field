package com.apps.twelve.floor.field.data.local.objects.harmful_objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.IObject;

/**
 * Created by yarrick on 10.07.17.
 */

public class PestClassObject implements IObject, Parcelable {

  public static final Creator<PestClassObject> CREATOR = new Creator<PestClassObject>() {
    @Override public PestClassObject createFromParcel(Parcel in) {
      return new PestClassObject(in);
    }

    @Override public PestClassObject[] newArray(int size) {
      return new PestClassObject[size];
    }
  };

  private long mId;
  @NonNull private String mName;

  public PestClassObject(long id, @NonNull String name) {
    this.mId = id;
    this.mName = name;
  }

  protected PestClassObject(Parcel in) {
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
