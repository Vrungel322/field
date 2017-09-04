package com.apps.twelve.floor.field.data.local.objects.conditions;

import android.os.Parcel;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.PhenologicalCharacteristicObject;

/**
 * Created by yarrick on 07.07.17.
 */

public class PhenologicalCharacteristicConditionValueObject extends BaseConditionValueObject {
  public static final Creator<PhenologicalCharacteristicConditionValueObject> CREATOR =
      new Creator<PhenologicalCharacteristicConditionValueObject>() {
        @Override
        public PhenologicalCharacteristicConditionValueObject createFromParcel(Parcel in) {
          return new PhenologicalCharacteristicConditionValueObject(in);
        }

        @Override public PhenologicalCharacteristicConditionValueObject[] newArray(int size) {
          return new PhenologicalCharacteristicConditionValueObject[size];
        }
      };

  private long mId;
  @NonNull private ConditionTypeObject mType;
  @NonNull private PhenologicalCharacteristicObject mPhenologicalCharacteristic;

  public PhenologicalCharacteristicConditionValueObject(long id, @NonNull ConditionTypeObject type,
      @NonNull PhenologicalCharacteristicObject phenologicalCharacteristic) {
    this.mId = id;
    this.mType = type;
    this.mPhenologicalCharacteristic = phenologicalCharacteristic;
  }

  protected PhenologicalCharacteristicConditionValueObject(Parcel in) {
    mId = in.readLong();
    mType = in.readParcelable(ConditionTypeObject.class.getClassLoader());
    mPhenologicalCharacteristic =
        in.readParcelable(PhenologicalCharacteristicObject.class.getClassLoader());
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeParcelable(mType, flags);
    dest.writeParcelable(mPhenologicalCharacteristic, flags);
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

  @Override public String getRepresentation() {
    return mPhenologicalCharacteristic.getName();
  }

  @NonNull public PhenologicalCharacteristicObject getPhenologicalCharacteristic() {
    return mPhenologicalCharacteristic;
  }

  public void setPhenologicalCharacteristic(
      @NonNull PhenologicalCharacteristicObject phenologicalCharacteristic) {
    this.mPhenologicalCharacteristic = phenologicalCharacteristic;
  }

  public long getTypeId() {
    return mType.getId();
  }

  public long getPhenologicalCharacteristicId() {
    return mPhenologicalCharacteristic.getId();
  }
}
