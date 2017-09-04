package com.apps.twelve.floor.field.data.local.objects.harmful_objects;

import android.os.Parcel;
import android.os.Parcelable;
import com.apps.twelve.floor.field.data.local.objects.IObject;

/**
 * Created by yarrick on 05.07.17.
 */

public class HarmfulObjectObject implements IObject, Parcelable {

  public static final Creator<HarmfulObjectObject> CREATOR = new Creator<HarmfulObjectObject>() {
    @Override public HarmfulObjectObject createFromParcel(Parcel in) {
      return new HarmfulObjectObject(in);
    }

    @Override public HarmfulObjectObject[] newArray(int size) {
      return new HarmfulObjectObject[size];
    }
  };

  private long mId;
  //private HarmfulObjectTypeObject mType;
  //private HarmfulObjectObject mValue;
  private long mTypeId; // TODO: here must be an Object
  private long mValueId; // TODO: here must be an Object

  public HarmfulObjectObject(long id, long typeId, long valueId) {
    this.mId = id;
    this.mTypeId = typeId;
    this.mValueId = valueId;
  }

  protected HarmfulObjectObject(Parcel in) {
    mId = in.readLong();
    mTypeId = in.readLong();
    mValueId = in.readLong();
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeLong(mTypeId);
    dest.writeLong(mValueId);
  }

  public long getId() {
    return mId;
  }

  public void setId(long id) {
    this.mId = id;
  }

  public long getTypeId() {
    return mTypeId;
  }

  public void setTypeId(long typeId) {
    this.mTypeId = typeId;
  }

  public long getValueId() {
    return mValueId;
  }

  public void setValueId(long valueId) {
    this.mValueId = valueId;
  }

  public String getValueRepresentation() {
    // TODO: when value will be an object - uncomment
    //return mValue.getRepresentation();

    // TODO: remove it
    return "TEST: harmful object representation";
  }
}
