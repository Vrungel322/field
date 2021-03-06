package com.apps.twelve.floor.field.data.local.objects.harmful_objects;

import android.os.Parcel;
import android.support.annotation.NonNull;

/**
 * Created by Yaroslav on 31.05.2017.
 */

public class PestObject extends BaseHarmfulObjectObject {

  public static final Creator<PestObject> CREATOR = new Creator<PestObject>() {
    @Override public PestObject createFromParcel(Parcel in) {
      return new PestObject(in);
    }

    @Override public PestObject[] newArray(int size) {
      return new PestObject[size];
    }
  };

  private long mId;
  @NonNull private HarmfulObjectTypeObject mHarmfulObjectType;
  @NonNull private String mName;
  @NonNull private PestClassObject mPestClass;
  @NonNull private PestOrderObject mPestOrder;

  public PestObject(long id, @NonNull HarmfulObjectTypeObject harmfulObjectType,
      @NonNull String name, @NonNull PestClassObject pestClass,
      @NonNull PestOrderObject pestOrder) {
    this.mId = id;
    this.mHarmfulObjectType = harmfulObjectType;
    this.mName = name;
    this.mPestClass = pestClass;
    this.mPestOrder = pestOrder;
  }

  protected PestObject(Parcel in) {
    this.mId = in.readLong();
    this.mHarmfulObjectType = in.readParcelable(HarmfulObjectTypeObject.class.getClassLoader());
    this.mName = in.readString();
    this.mPestClass = in.readParcelable(PestClassObject.class.getClassLoader());
    this.mPestOrder = in.readParcelable(PestOrderObject.class.getClassLoader());
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeParcelable(mHarmfulObjectType, flags);
    dest.writeString(mName);
    dest.writeParcelable(mPestClass, flags);
    dest.writeParcelable(mPestOrder, flags);
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public long getId() {
    return mId;
  }

  @Override public void setId(long id) {
    this.mId = id;
  }

  @NonNull @Override public String getName() {
    return mName;
  }

  @Override public void setName(@NonNull String name) {
    this.mName = name;
  }

  @NonNull @Override public HarmfulObjectTypeObject getType() {
    return mHarmfulObjectType;
  }

  @Override public void setType(@NonNull HarmfulObjectTypeObject type) {
    this.mHarmfulObjectType = type;
  }

  @NonNull @Override public String getRepresentation() {
    return mName;
  }

  @NonNull public PestClassObject getPestClass() {
    return mPestClass;
  }

  public void setPestClass(@NonNull PestClassObject pestClass) {
    this.mPestClass = pestClass;
  }

  @NonNull public PestOrderObject getPestOrder() {
    return mPestOrder;
  }

  public void setPestOrder(@NonNull PestOrderObject pestOrder) {
    this.mPestOrder = pestOrder;
  }

  public Long getHarmfulObjectTypeId() {
    return mHarmfulObjectType.getId();
  }

  public Long getPestClassId() {
    return mPestClass.getId();
  }

  public Long getPestOrderId() {
    return mPestOrder.getId();
  }
}
