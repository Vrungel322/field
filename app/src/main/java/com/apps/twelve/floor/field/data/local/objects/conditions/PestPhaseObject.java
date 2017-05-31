package com.apps.twelve.floor.field.data.local.objects.conditions;

import android.os.Parcel;

/**
 * Created by Yaroslav on 31.05.2017.
 */

public class PestPhaseObject extends BaseConditionValueObject {

  public static final Creator<PestPhaseObject> CREATOR = new Creator<PestPhaseObject>() {
    @Override public PestPhaseObject createFromParcel(Parcel in) {
      return new PestPhaseObject(in);
    }

    @Override public PestPhaseObject[] newArray(int size) {
      return new PestPhaseObject[size];
    }
  };

  private long mId;
  private String mName;
  private ConditionTypeObject mType;
  private PestObject mPest;

  public PestPhaseObject(long id, String name, ConditionTypeObject type, PestObject pest) {
    this.mId = id;
    this.mName = name;
    this.mType = type;
    this.mPest = pest;
  }

  protected PestPhaseObject(Parcel in) {
    mId = in.readLong();
    mName = in.readString();
    mType = in.readParcelable(ConditionTypeObject.class.getClassLoader());
    mPest = in.readParcelable(PestObject.class.getClassLoader());
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeString(mName);
    dest.writeParcelable(mType, flags);
    dest.writeParcelable(mPest, flags);
  }

  @Override public long getId() {
    return mId;
  }

  @Override public void setId(long id) {
    this.mId = id;
  }

  @Override public String getName() {
    return mName;
  }

  @Override public void setName(String name) {
    this.mName = name;
  }

  @Override public ConditionTypeObject getType() {
    return mType;
  }

  @Override public void setType(ConditionTypeObject type) {
    this.mType = type;
  }

  public PestObject getPest() {
    return mPest;
  }

  public void setPest(PestObject pest) {
    this.mPest = pest;
  }
}
