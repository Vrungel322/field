package com.apps.twelve.floor.field.data.local.objects.conditions;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.IObject;
import timber.log.Timber;

/**
 * Created by Yaroslav on 31.05.2017.
 */

public class ConditionObject implements IObject, Parcelable {

  public static final Creator<ConditionObject> CREATOR = new Creator<ConditionObject>() {
    @Override public ConditionObject createFromParcel(Parcel in) {
      return new ConditionObject(in);
    }

    @Override public ConditionObject[] newArray(int size) {
      return new ConditionObject[size];
    }
  };

  public static final int HIGHEST_PRIORITY = 1;
  public static final int LOWEST_PRIORITY = 999;

  private long mId;
  private int mPriority;
  @NonNull private ConditionNameObject mName;
  @NonNull private ConditionTypeObject mConditionType;
  @NonNull private BaseConditionValueObject mConditionValue;

  public ConditionObject(long id, int priority, @NonNull ConditionNameObject name,
      @NonNull ConditionTypeObject conditionType,
      @NonNull BaseConditionValueObject conditionValue) {
    this.mId = id;
    this.mPriority = priority;
    this.mName = name;
    this.mConditionType = conditionType;
    this.mConditionValue = conditionValue;

    valueChecker();
  }

  // TODO: this is for tests
  private void valueChecker() {
    boolean isOk = ((mName != null) && (mConditionType != null) && (mConditionValue != null));

    if (!isOk) {
      String errMsg = "ERROR: Invalid ConditionObject: \n"
          + "\t id: "
          + mId
          + "\t prior: "
          + mPriority
          + "\t name: "
          + mName.getId()
          + ", "
          + mName.getName()
          + "\t cond type: "
          + mConditionType.getId()
          + ", "
          + mConditionType.getName()
          + "\t cond value: "
          + mConditionValue.getId()
          + ", "
          + mConditionValue.getType().getName();

      Timber.e(errMsg);
    }
  }

  protected ConditionObject(Parcel in) {
    mId = in.readLong();
    mPriority = in.readInt();
    mName = in.readParcelable(ConditionNameObject.class.getClassLoader());
    mConditionType = in.readParcelable(ConditionTypeObject.class.getClassLoader());
    mConditionValue = in.readParcelable(BaseConditionValueObject.class.getClassLoader());
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeInt(mPriority);
    dest.writeParcelable(mName, flags);
    dest.writeParcelable(mConditionType, flags);
    dest.writeParcelable(mConditionValue, flags);
  }

  @Override public int describeContents() {
    return 0;
  }

  public long getId() {
    return mId;
  }

  public void setId(long id) {
    this.mId = id;
  }

  public int getPriority() {
    return mPriority;
  }

  public void setPriority(int priority) {
    this.mPriority = priority;
  }

  public ConditionNameObject getConditionName() {
    return mName;
  }

  public void setName(@NonNull ConditionNameObject name) {
    this.mName = name;
  }

  public ConditionTypeObject getConditionType() {
    return mConditionType;
  }

  public void setConditionType(@NonNull ConditionTypeObject conditionType) {
    this.mConditionType = conditionType;
  }

  public BaseConditionValueObject getConditionValue() {
    return mConditionValue;
  }

  public void setConditionValue(@NonNull BaseConditionValueObject conditionValue) {
    this.mConditionValue = conditionValue;
  }

  public long getNameId() {
    return mName.getId();
  }

  public long getConditionTypeId() {
    return mConditionType.getId();
  }

  public long getConditionValueId() {
    return mConditionValue.getId();
  }

  public String getRepresentation() {
    return mName.getName() + ": " + mConditionValue.getRepresentation();
  }

  public String getConditionNameName() {
    return mName.getName();
  }
}
