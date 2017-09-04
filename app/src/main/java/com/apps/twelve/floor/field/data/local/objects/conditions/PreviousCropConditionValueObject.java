package com.apps.twelve.floor.field.data.local.objects.conditions;

import android.os.Parcel;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.CropObject;

/**
 * Created by yarrick on 22.07.17..
 */
public class PreviousCropConditionValueObject extends BaseConditionValueObject {

  public static final Creator<PreviousCropConditionValueObject> CREATOR =
      new Creator<PreviousCropConditionValueObject>() {
        @Override public PreviousCropConditionValueObject createFromParcel(Parcel in) {
          return new PreviousCropConditionValueObject(in);
        }

        @Override public PreviousCropConditionValueObject[] newArray(int size) {
          return new PreviousCropConditionValueObject[size];
        }
      };

  private long mId;
  @NonNull private ConditionTypeObject mConditionType;
  @NonNull private CropObject mCrop;

  public PreviousCropConditionValueObject(long id, @NonNull ConditionTypeObject conditionType,
      @NonNull CropObject crop) {
    this.mId = id;
    this.mConditionType = conditionType;
    this.mCrop = crop;
  }

  public PreviousCropConditionValueObject(Parcel in) {
    mId = in.readLong();
    mConditionType = in.readParcelable(ConditionTypeObject.class.getClassLoader());
    mCrop = in.readParcelable(CropObject.class.getClassLoader());
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeParcelable(mConditionType, flags);
    dest.writeParcelable(mCrop, flags);
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
    return mCrop.getName();
  }

  @NonNull public CropObject getCrop() {
    return mCrop;
  }

  public void setCrop(@NonNull CropObject crop) {
    this.mCrop = crop;
  }

  public long getTypeId() {
    return mConditionType.getId();
  }

  public long getCropId() {
    return mCrop.getId();
  }
}
