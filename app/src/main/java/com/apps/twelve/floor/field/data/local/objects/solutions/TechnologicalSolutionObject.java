package com.apps.twelve.floor.field.data.local.objects.solutions;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.IObject;

/**
 * Created by yarrick on 12.07.17.
 */

public class TechnologicalSolutionObject implements IObject, Parcelable {
  public static final Creator<TechnologicalSolutionObject> CREATOR =
      new Creator<TechnologicalSolutionObject>() {
        @Override public TechnologicalSolutionObject createFromParcel(Parcel in) {
          return new TechnologicalSolutionObject(in);
        }

        @Override public TechnologicalSolutionObject[] newArray(int size) {
          return new TechnologicalSolutionObject[size];
        }
      };

  private long mId;
  @NonNull private TechnologicalSolutionTypeObject mSolutionType;
  @NonNull private BaseTechnologicalSolutionObject mSolutionValue;

  public TechnologicalSolutionObject(long id, @NonNull TechnologicalSolutionTypeObject solutionType,
      @NonNull BaseTechnologicalSolutionObject solutionValue) {
    this.mId = id;
    this.mSolutionType = solutionType;
    this.mSolutionValue = solutionValue;
  }

  protected TechnologicalSolutionObject(Parcel in) {
    mId = in.readLong();
    mSolutionType = in.readParcelable(TechnologicalSolutionTypeObject.class.getClassLoader());
    mSolutionValue = in.readParcelable(BaseTechnologicalSolutionObject.class.getClassLoader());
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeParcelable(mSolutionType, flags);
    dest.writeParcelable(mSolutionValue, flags);
  }

  public long getId() {
    return mId;
  }

  public void setId(long id) {
    this.mId = id;
  }

  @NonNull public TechnologicalSolutionTypeObject getSolutionType() {
    return mSolutionType;
  }

  public void setSolutionType(@NonNull TechnologicalSolutionTypeObject solutionType) {
    this.mSolutionType = solutionType;
  }

  @NonNull public BaseTechnologicalSolutionObject getSolutionValue() {
    return mSolutionValue;
  }

  public void setSolutionValue(@NonNull BaseTechnologicalSolutionObject solutionValue) {
    this.mSolutionValue = solutionValue;
  }

  public long getSolutionTypeId() {
    return mSolutionType.getId();
  }

  public long getSolutionValueId() {
    return mSolutionValue.getId();
  }

  public String getSolutionValueName() {
    return mSolutionValue.getName();
  }
}
