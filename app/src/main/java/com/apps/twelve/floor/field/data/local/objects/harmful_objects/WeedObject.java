package com.apps.twelve.floor.field.data.local.objects.harmful_objects;

import android.os.Parcel;
import android.support.annotation.NonNull;

/**
 * Created by Vrungel on 04.07.2017.
 */

public class WeedObject extends BaseHarmfulObjectObject {
  public static final Creator<WeedObject> CREATOR = new Creator<WeedObject>() {
    @Override public WeedObject createFromParcel(Parcel in) {
      return new WeedObject(in);
    }

    @Override public WeedObject[] newArray(int size) {
      return new WeedObject[size];
    }
  };
  private long mId;
  @NonNull private String mName;
  @NonNull private HarmfulObjectTypeObject mHarmfulObjectType;
  @NonNull private WeedNutritionTypeObject mWeedNutritionType;
  @NonNull private WeedClassObject mWeedClass;
  @NonNull private WeedGroupObject mWeedGroup;

  public WeedObject(long id, @NonNull String name, @NonNull HarmfulObjectTypeObject harmfulObjType,
      @NonNull WeedNutritionTypeObject nutritionType, @NonNull WeedClassObject weedClass,
      @NonNull WeedGroupObject weedGroup) {
    mId = id;
    mName = name;
    mHarmfulObjectType = harmfulObjType;
    mWeedNutritionType = nutritionType;
    mWeedClass = weedClass;
    mWeedGroup = weedGroup;
  }

  protected WeedObject(Parcel in) {
    mId = in.readLong();
    mName = in.readString();
    mHarmfulObjectType = in.readParcelable(HarmfulObjectTypeObject.class.getClassLoader());
    mWeedNutritionType = in.readParcelable(WeedNutritionTypeObject.class.getClassLoader());
    mWeedClass = in.readParcelable(WeedClassObject.class.getClassLoader());
    mWeedGroup = in.readParcelable(WeedGroupObject.class.getClassLoader());
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeString(mName);
    dest.writeParcelable(mHarmfulObjectType, flags);
    dest.writeParcelable(mWeedNutritionType, flags);
    dest.writeParcelable(mWeedClass, flags);
    dest.writeParcelable(mWeedGroup, flags);
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public long getId() {
    return mId;
  }

  @Override public void setId(long id) {
    mId = id;
  }

  @NonNull @Override public String getName() {
    return mName;
  }

  @Override public void setName(@NonNull String name) {
    mName = name;
  }

  @NonNull @Override public HarmfulObjectTypeObject getType() {
    return mHarmfulObjectType;
  }

  @Override public void setType(@NonNull HarmfulObjectTypeObject type) {
    this.mHarmfulObjectType = type;
  }

  @NonNull @Override public String getRepresentation() {
    return mName;
  }

  @NonNull public WeedNutritionTypeObject getNutritionType() {
    return mWeedNutritionType;
  }

  public void setNutritionType(@NonNull WeedNutritionTypeObject nutritionType) {
    this.mWeedNutritionType = nutritionType;
  }

  @NonNull public WeedClassObject getWeedClass() {
    return mWeedClass;
  }

  public void setWeedClass(@NonNull WeedClassObject weedClass) {
    mWeedClass = weedClass;
  }

  @NonNull public WeedGroupObject getWeedGroup() {
    return mWeedGroup;
  }

  public void setWeedGroup(@NonNull WeedGroupObject weedGroup) {
    mWeedGroup = weedGroup;
  }

  public long getHarmfulObjTypeId() {
    return mHarmfulObjectType.getId();
  }

  public long getNutritionTypeId() {
    return mWeedNutritionType.getId();
  }

  public long getClassId() {
    return mWeedClass.getId();
  }

  public long getGroupId() {
    return mWeedGroup.getId();
  }
}
