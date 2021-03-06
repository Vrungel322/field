package com.apps.twelve.floor.field.data.local.objects.conditions;

import android.os.Parcel;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.HarmfulObjectObject;

/**
 * Created by yarrick on 19.07.17.
 */

public class HarmfulObjectConditionValueObject extends BaseConditionValueObject {

  public static final Creator<HarmfulObjectConditionValueObject> CREATOR =
      new Creator<HarmfulObjectConditionValueObject>() {
        @Override public HarmfulObjectConditionValueObject createFromParcel(Parcel in) {
          return new HarmfulObjectConditionValueObject(in);
        }

        @Override public HarmfulObjectConditionValueObject[] newArray(int size) {
          return new HarmfulObjectConditionValueObject[size];
        }
      };

  private long mId;
  @NonNull private ConditionTypeObject mConditionType;
  @NonNull private HarmfulObjectObject mHarmfulObject;

  public HarmfulObjectConditionValueObject(long id, @NonNull ConditionTypeObject conditionType,
      @NonNull HarmfulObjectObject harmfulObject) {
    this.mId = id;
    this.mConditionType = conditionType;
    this.mHarmfulObject = harmfulObject;
  }

  protected HarmfulObjectConditionValueObject(Parcel in) {
    mId = in.readLong();
    mConditionType = in.readParcelable(ConditionTypeObject.class.getClassLoader());
    mHarmfulObject = in.readParcelable(HarmfulObjectObject.class.getClassLoader());
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeParcelable(mConditionType, flags);
    dest.writeParcelable(mHarmfulObject, flags);
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
    return mHarmfulObject.getValueRepresentation();
  }

  @NonNull public HarmfulObjectObject getHarmfulObject() {
    return mHarmfulObject;
  }

  public void setHarmfulObject(@NonNull HarmfulObjectObject harmfulObject) {
    this.mHarmfulObject = harmfulObject;
  }

  public long getTypeId() {
    return mConditionType.getId();
  }

  public long getHarmfulObjectId() {
    return mHarmfulObject.getId();
  }
}
