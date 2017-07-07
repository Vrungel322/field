package com.apps.twelve.floor.field.data.local.objects.solutions;

import android.os.Parcel;
import android.support.annotation.NonNull;

/**
 * Created by Yaroslav on 22.06.2017.
 */

public class InsectObject extends BaseTechnologicalSolutionObject {

  public static final Creator<InsectObject> CREATOR = new Creator<InsectObject>() {
    @Override public InsectObject createFromParcel(Parcel in) {
      return new InsectObject(in);
    }

    @Override public InsectObject[] newArray(int size) {
      return new InsectObject[size];
    }
  };

  private long mId;
  @NonNull private String mName;
  @NonNull private TechnologicalSolutionTypeObject mType;
  private long mPrice;

  public InsectObject(long mId, @NonNull String mName,
      @NonNull TechnologicalSolutionTypeObject mType, long mPrice) {
    this.mId = mId;
    this.mName = mName;
    this.mType = mType;
    this.mPrice = mPrice;
  }

  protected InsectObject(Parcel in) {
    this.mId = in.readLong();
    this.mName = in.readString();
    this.mType = in.readParcelable(TechnologicalSolutionTypeObject.class.getClassLoader());
    this.mPrice = in.readLong();
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeString(mName);
    dest.writeParcelable(mType, flags);
    dest.writeLong(mPrice);
  }

  @Override public long getId() {
    return mId;
  }

  @Override public void setId(long id) {
    this.mId = id;
  }

  @Override public String getName() {
    return mName;
  }

  @Override public void setName(@NonNull String name) {
    this.mName = name;
  }

  @Override public long getPrice() {
    return mPrice;
  }

  @Override public void setPrice(long price) {
    this.mPrice = price;
  }

  @Override public TechnologicalSolutionTypeObject getType() {
    return mType;
  }

  @Override public void setType(@NonNull TechnologicalSolutionTypeObject type) {
    this.mType = type;
  }

  public long getTypeId() {
    return mType.getId();
  }
}
