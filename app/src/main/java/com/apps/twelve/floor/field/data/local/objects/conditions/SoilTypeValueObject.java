package com.apps.twelve.floor.field.data.local.objects.conditions;

import android.os.Parcel;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.SoilTypeObject;

/**
 * Created by yarrick on 07.07.17.
 *
 */

public class SoilTypeValueObject extends BaseConditionValueObject {

  public static final Creator<SoilTypeValueObject> CREATOR = new Creator<SoilTypeValueObject>() {
    @Override public SoilTypeValueObject createFromParcel(Parcel in) {
      return new SoilTypeValueObject(in);
    }

    @Override public SoilTypeValueObject[] newArray(int size) {
      return new SoilTypeValueObject[size];
    }
  };

  private long mId;
  @NonNull private ConditionTypeObject mConditionType;
  @NonNull private SoilTypeObject mSoilType;

  public SoilTypeValueObject(long id, @NonNull ConditionTypeObject conditionType,
      @NonNull SoilTypeObject soilType) {
    this.mId = id;
    this.mConditionType = conditionType;
    this.mSoilType = soilType;
  }

  protected SoilTypeValueObject(Parcel in) {
    mId = in.readLong();
    mConditionType = in.readParcelable(ConditionTypeObject.class.getClassLoader());
    mSoilType = in.readParcelable(SoilTypeObject.class.getClassLoader());
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeParcelable(mConditionType, flags);
    dest.writeParcelable(mSoilType, flags);
  }

  @Override public long getId() {
    return mId;
  }

  @Override public void setId(long id) {
    this.mId = id;
  }

  @Override @NonNull public ConditionTypeObject getType() {
    return mConditionType;
  }

  @Override public void setType(@NonNull ConditionTypeObject conditionType) {
    this.mConditionType = conditionType;
  }

  @Override public String getRepresentation() {
    return mSoilType.getName();
  }

  @NonNull public SoilTypeObject getSoilType() {
    return mSoilType;
  }

  public void setSoilType(@NonNull SoilTypeObject soilType) {
    this.mSoilType = soilType;
  }

  public long getTypeId() {
    return mConditionType.getId();
  }

  public long getSoilTypeId() {
    return mSoilType.getId();
  }
}
