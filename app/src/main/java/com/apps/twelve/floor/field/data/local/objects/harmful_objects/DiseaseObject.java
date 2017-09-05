package com.apps.twelve.floor.field.data.local.objects.harmful_objects;

import android.os.Parcel;
import android.support.annotation.NonNull;

/**
 * Created by yarrick on 05.09.17.
 */

public class DiseaseObject extends BaseHarmfulObjectObject {
  public static final Creator<DiseaseObject> CREATOR = new Creator<DiseaseObject>() {
    @Override public DiseaseObject createFromParcel(Parcel in) {
      return new DiseaseObject(in);
    }

    @Override public DiseaseObject[] newArray(int size) {
      return new DiseaseObject[size];
    }
  };

  private long mId;
  @NonNull private HarmfulObjectTypeObject mHarmfulObjectType;
  @NonNull private String mName;
  @NonNull private DiseasePathogenTypeObject mDiseasePathogenType;

  public DiseaseObject(long id, @NonNull HarmfulObjectTypeObject harmfulObjectType,
      @NonNull String name, @NonNull DiseasePathogenTypeObject diseasePathogenType) {
    this.mId = id;
    this.mHarmfulObjectType = harmfulObjectType;
    this.mName = name;
    this.mDiseasePathogenType = diseasePathogenType;
  }

  protected DiseaseObject(Parcel in) {
    mId = in.readLong();
    mHarmfulObjectType = in.readParcelable(HarmfulObjectTypeObject.class.getClassLoader());
    mName = in.readString();
    mDiseasePathogenType = in.readParcelable(DiseasePathogenTypeObject.class.getClassLoader());
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeParcelable(mHarmfulObjectType, flags);
    dest.writeString(mName);
    dest.writeParcelable(mDiseasePathogenType, flags);
  }

  @Override public long getId() {
    return mId;
  }

  @Override public void setId(long id) {
    this.mId = id;
  }

  @NonNull @Override public String getName() {
    return mName;
  }

  @Override public void setName(@NonNull String name) {
    this.mName = name;
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

  @NonNull public DiseasePathogenTypeObject getDiseasePathogenType() {
    return mDiseasePathogenType;
  }

  public void setDiseasePathogenType(@NonNull DiseasePathogenTypeObject diseasePathogenType) {
    this.mDiseasePathogenType = diseasePathogenType;
  }

  public long getTypeId() {
    return mHarmfulObjectType.getId();
  }

  public long getDiseasePathogenTypeId() {
    return mDiseasePathogenType.getId();
  }
}
