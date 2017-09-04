package com.apps.twelve.floor.field.data.local.objects.harmful_objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
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
  @NonNull private HarmfulObjectTypeObject mType;
  @NonNull private BaseHarmfulObjectObject mValue;

  public HarmfulObjectObject(long id, @NonNull HarmfulObjectTypeObject type,
      @NonNull BaseHarmfulObjectObject value) {
    this.mId = id;
    this.mType = type;
    this.mValue = value;
  }

  protected HarmfulObjectObject(Parcel in) {
    mId = in.readLong();
    mType = in.readParcelable(HarmfulObjectTypeObject.class.getClassLoader());
    mValue = in.readParcelable(BaseHarmfulObjectObject.class.getClassLoader());
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeParcelable(mType, flags);
    dest.writeParcelable(mValue, flags);
  }

  public long getId() {
    return mId;
  }

  public void setId(long id) {
    this.mId = id;
  }

  @NonNull public HarmfulObjectTypeObject getType() {
    return mType;
  }

  public void setType(@NonNull HarmfulObjectTypeObject type) {
    this.mType = type;
  }

  @NonNull public BaseHarmfulObjectObject getValue() {
    return mValue;
  }

  public void setValue(@NonNull BaseHarmfulObjectObject value) {
    this.mValue = value;
  }

  @NonNull public String getValueRepresentation() {
    return mValue.getRepresentation();
  }

  public long getTypeId() {
    return mType.getId();
  }

  public long getValueId() {
    return mValue.getId();
  }
}
