package com.apps.twelve.floor.field.data.local.objects.conditions;

import android.os.Parcel;
import android.support.annotation.NonNull;

/**
 * Created by Yaroslav on 31.05.2017.
 */

public class PhenologicalCharacteristicObject extends BaseConditionValueObject {

  public static final Creator<PhenologicalCharacteristicObject> CREATOR =
      new Creator<PhenologicalCharacteristicObject>() {
        @Override public PhenologicalCharacteristicObject createFromParcel(Parcel in) {
          return new PhenologicalCharacteristicObject(in);
        }

        @Override public PhenologicalCharacteristicObject[] newArray(int size) {
          return new PhenologicalCharacteristicObject[size];
        }
      };

  private long mId;
  @NonNull private String mName;
  @NonNull private ConditionTypeObject mType;

  public PhenologicalCharacteristicObject(long id, @NonNull String name,
      @NonNull ConditionTypeObject type) {
    this.mId = id;
    this.mName = name;
    this.mType = type;
  }

  protected PhenologicalCharacteristicObject(Parcel in) {
    this.mId = in.readLong();
    this.mName = in.readString();
    this.mType = in.readParcelable(ConditionTypeObject.class.getClassLoader());
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeString(mName);
    dest.writeParcelable(mType, flags);
  }

  @Override public long getId() {
    return mId;
  }

  @Override public void setId(long id) {
    this.mId = id;
  }

  @Override public ConditionTypeObject getType() {
    return mType;
  }

  @Override public void setType(@NonNull ConditionTypeObject type) {
    this.mType = type;
  }

  public String getName() {
    return mName;
  }

  public void setName(@NonNull String name) {
    this.mName = name;
  }
}
