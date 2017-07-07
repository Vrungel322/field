package com.apps.twelve.floor.field.data.local.objects.harmful_objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionTypeObject;

/**
 * Created by Yaroslav on 31.05.2017.
 */

public class PestObject implements Parcelable {

  public static final Creator<PestObject> CREATOR = new Creator<PestObject>() {
    @Override public PestObject createFromParcel(Parcel in) {
      return new PestObject(in);
    }

    @Override public PestObject[] newArray(int size) {
      return new PestObject[size];
    }
  };

  private long mId;
  @NonNull private String mName;
  @NonNull private ConditionTypeObject mConditionType; // TODO: maybe we don't need this field
  private long mParentId;
  private boolean mIsGroup;

  public PestObject(long id, @NonNull String name, @NonNull ConditionTypeObject conditionType,
      long parentId, boolean isGroup) {
    this.mId = id;
    this.mName = name;
    this.mConditionType = conditionType;
    this.mParentId = parentId;
    this.mIsGroup = isGroup;
  }

  protected PestObject(Parcel in) {
    this.mId = in.readLong();
    this.mName = in.readString();
    this.mConditionType = in.readParcelable(ConditionTypeObject.class.getClassLoader());
    this.mParentId = in.readLong();
    this.mIsGroup = in.readByte() != 0;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeString(mName);
    dest.writeParcelable(mConditionType, flags);
    dest.writeLong(mParentId);
    dest.writeByte((byte) (mIsGroup ? 1 : 0));
  }

  public long getId() {
    return mId;
  }

  public void setId(long id) {
    this.mId = id;
  }

  public String getName() {
    return mName;
  }

  public void setName(@NonNull String name) {
    this.mName = name;
  }

  @NonNull public ConditionTypeObject getConditionType() {
    return mConditionType;
  }

  public void setConditionType(@NonNull ConditionTypeObject conditionType) {
    this.mConditionType = conditionType;
  }

  public long getParentId() {
    return mParentId;
  }

  public void setParentId(long parentId) {
    this.mParentId = parentId;
  }

  public boolean isGroup() {
    return mIsGroup;
  }

  public void setIsGroup(boolean isGroup) {
    this.mIsGroup = isGroup;
  }

  public long getConditionTypeId() {
    return mConditionType.getId();
  }
}
