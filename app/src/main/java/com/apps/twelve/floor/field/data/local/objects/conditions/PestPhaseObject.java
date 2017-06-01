package com.apps.twelve.floor.field.data.local.objects.conditions;

import android.os.Parcel;
import android.support.annotation.NonNull;

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
  @NonNull private String mName;
  @NonNull private ConditionTypeObject mType;
  @NonNull private PestObject mPest;

  public PestPhaseObject(long id, @NonNull String name, @NonNull ConditionTypeObject type,
      @NonNull PestObject pest) {
    this.mId = id;
    this.mName = name;
    this.mType = type;
    this.mPest = pest;
  }

  protected PestPhaseObject(Parcel in) {
    this.mId = in.readLong();
    this.mName = in.readString();
    this.mType = in.readParcelable(ConditionTypeObject.class.getClassLoader());
    this.mPest = in.readParcelable(PestObject.class.getClassLoader());
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

  @Override public void setName(@NonNull String name) {
    this.mName = name;
  }

  @Override public ConditionTypeObject getType() {
    return mType;
  }

  @Override public void setType(@NonNull ConditionTypeObject type) {
    this.mType = type;
  }

  public PestObject getPest() {
    return mPest;
  }

  public void setPest(@NonNull PestObject pest) {
    this.mPest = pest;
  }
}
