package com.apps.twelve.floor.field.data.local.objects.solutions;

import android.os.Parcel;
import android.support.annotation.NonNull;

/**
 * Created by yarrick on 06.07.17.
 */

public class ActiveComponentObject extends BaseTechnologicalSolutionObject{

  public static final Creator<ActiveComponentObject> CREATOR = new Creator<ActiveComponentObject>() {
    @Override public ActiveComponentObject createFromParcel(Parcel in) {
      return new ActiveComponentObject(in);
    }

    @Override public ActiveComponentObject[] newArray(int size) {
      return new ActiveComponentObject[size];
    }
  };

  private long mId;
  @NonNull private String mName;
  @NonNull private TechnologicalSolutionTypeObject mType;

  public ActiveComponentObject(long mId, @NonNull String mName,
      @NonNull TechnologicalSolutionTypeObject mType) {
    this.mId = mId;
    this.mName = mName;
    this.mType = mType;
  }

  protected ActiveComponentObject(Parcel in) {
    this.mId = in.readLong();
    this.mName = in.readString();
    this.mType = in.readParcelable(TechnologicalSolutionTypeObject.class.getClassLoader());
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeString(mName);
    dest.writeParcelable(mType, flags);
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

  // TODO: calculate price from associated product
  @Override public long getPrice() {
    return 0;
  }

  @Override public void setPrice(long price) {

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
