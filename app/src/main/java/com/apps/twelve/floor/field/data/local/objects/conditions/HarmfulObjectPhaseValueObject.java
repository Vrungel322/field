package com.apps.twelve.floor.field.data.local.objects.conditions;

import android.os.Parcel;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.HarmfulObjectPhaseObject;

/**
 * Created by yarrick on 19.07.17.
 */

public class HarmfulObjectPhaseValueObject extends BaseConditionValueObject {

  public static final Creator<HarmfulObjectPhaseValueObject> CREATOR =
      new Creator<HarmfulObjectPhaseValueObject>() {
        @Override public HarmfulObjectPhaseValueObject createFromParcel(Parcel in) {
          return new HarmfulObjectPhaseValueObject(in);
        }

        @Override public HarmfulObjectPhaseValueObject[] newArray(int size) {
          return new HarmfulObjectPhaseValueObject[size];
        }
      };

  private long mId;
  @NonNull private ConditionTypeObject mConditionType;
  @NonNull
  private HarmfulObjectPhaseObject mHarmfulObjectPhase;

  public HarmfulObjectPhaseValueObject(long id, @NonNull ConditionTypeObject conditionType, @NonNull
      HarmfulObjectPhaseObject harmfulObjectPhase) {
    this.mId = id;
    this.mConditionType = conditionType;
    this.mHarmfulObjectPhase = harmfulObjectPhase;
  }

  protected HarmfulObjectPhaseValueObject(Parcel in) {
    mId = in.readLong();
    mConditionType = in.readParcelable(ConditionTypeObject.class.getClassLoader());
    mHarmfulObjectPhase = in.readParcelable(HarmfulObjectPhaseObject.class.getClassLoader());
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeParcelable(mConditionType, flags);
    dest.writeParcelable(mHarmfulObjectPhase, flags);
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

  @NonNull
  public HarmfulObjectPhaseObject getHarmfulObjectPhase() {
    return mHarmfulObjectPhase;
  }

  public void setHarmfulObjectPhase(@NonNull HarmfulObjectPhaseObject harmfulObjectPhase) {
    this.mHarmfulObjectPhase = harmfulObjectPhase;
  }

  public long getConditionTypeId() {
    return mConditionType.getId();
  }

  public long getHarmfulObjectPhaseId() {
    return mHarmfulObjectPhase.getId();
  }
}
