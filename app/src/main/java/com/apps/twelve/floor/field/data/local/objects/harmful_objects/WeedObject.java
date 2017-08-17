package com.apps.twelve.floor.field.data.local.objects.harmful_objects;

import android.os.Parcel;
import android.os.Parcelable;
import com.apps.twelve.floor.field.data.local.objects.IObject;

/**
 * Created by Vrungel on 04.07.2017.
 */

public class WeedObject implements IObject, Parcelable {
  public static final Creator<WeedObject> CREATOR = new Creator<WeedObject>() {
    @Override public WeedObject createFromParcel(Parcel in) {
      return new WeedObject(in);
    }

    @Override public WeedObject[] newArray(int size) {
      return new WeedObject[size];
    }
  };
  private long mId;
  private long mHarmfulObjTypeId; // TODO: must be an object
  private String mName;
  private long mNutritionTypeId; // TODO: must be an object
  private long mClassId; // TODO: must be an object
  private long mGroupId; // TODO: must be an object

  public WeedObject(long id, long harmfulObjTypeId, String name, long nutritionTypeId, long classId,
      long groupId) {
    mId = id;
    mHarmfulObjTypeId = harmfulObjTypeId;
    mName = name;
    mNutritionTypeId = nutritionTypeId;
    mClassId = classId;
    mGroupId = groupId;
  }

  protected WeedObject(Parcel in) {
    mId = in.readLong();
    mHarmfulObjTypeId = in.readLong();
    mName = in.readString();
    mNutritionTypeId = in.readLong();
    mClassId = in.readLong();
    mGroupId = in.readLong();
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeLong(mHarmfulObjTypeId);
    dest.writeString(mName);
    dest.writeLong(mNutritionTypeId);
    dest.writeLong(mClassId);
    dest.writeLong(mGroupId);
  }

  @Override public int describeContents() {
    return 0;
  }

  public long getId() {
    return mId;
  }

  public void setId(long id) {
    mId = id;
  }

  public long getHarmfulObjTypeId() {
    return mHarmfulObjTypeId;
  }

  public void setHarmfulObjTypeId(long harmfulObjTypeId) {
    mHarmfulObjTypeId = harmfulObjTypeId;
  }

  public String getName() {
    return mName;
  }

  public void setName(String name) {
    mName = name;
  }

  public long getNutritionTypeId() {
    return mNutritionTypeId;
  }

  public void setNutritionTypeId(long nutritionTypeId) {
    mNutritionTypeId = nutritionTypeId;
  }

  public long getClassId() {
    return mClassId;
  }

  public void setClassId(long classId) {
    mClassId = classId;
  }

  public long getGroupId() {
    return mGroupId;
  }

  public void setGroupId(long groupId) {
    mGroupId = groupId;
  }
}
