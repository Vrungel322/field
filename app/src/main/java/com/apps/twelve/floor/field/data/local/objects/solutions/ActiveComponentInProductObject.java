package com.apps.twelve.floor.field.data.local.objects.solutions;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.IObject;

/**
 * Created by yarrick on 06.07.17.
 */

public class ActiveComponentInProductObject implements IObject, Parcelable {
  public static final Creator<ActiveComponentInProductObject> CREATOR =
      new Creator<ActiveComponentInProductObject>() {
        @Override public ActiveComponentInProductObject createFromParcel(Parcel in) {
          return new ActiveComponentInProductObject(in);
        }

        @Override public ActiveComponentInProductObject[] newArray(int size) {
          return new ActiveComponentInProductObject[size];
        }
      };

  private long mId;
  private long mProductId;
  private long mActiveComponentId;
  @NonNull private String mDoze;

  public ActiveComponentInProductObject(long id, long productId, long activeComponentId,
      @NonNull String doze) {
    this.mId = id;
    this.mProductId = productId;
    this.mActiveComponentId = activeComponentId;
    this.mDoze = doze;
  }

  protected ActiveComponentInProductObject(Parcel in) {
    mId = in.readLong();
    mProductId = in.readLong();
    mActiveComponentId = in.readLong();
    mDoze = in.readString();
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeLong(mProductId);
    dest.writeLong(mActiveComponentId);
    dest.writeString(mDoze);
  }

  public long getId() {
    return mId;
  }

  public void setId(long id) {
    this.mId = id;
  }

  public long getProductId() {
    return mProductId;
  }

  public void setProductId(long productId) {
    this.mProductId = productId;
  }

  public long getActiveComponentId() {
    return mActiveComponentId;
  }

  public void setActiveComponentId(long activeComponentId) {
    this.mActiveComponentId = activeComponentId;
  }

  public String getDoze() {
    return mDoze;
  }

  public void setDoze(@NonNull String doze) {
    this.mDoze = doze;
  }
}
