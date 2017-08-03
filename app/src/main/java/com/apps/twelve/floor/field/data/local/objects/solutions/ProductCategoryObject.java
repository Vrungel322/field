package com.apps.twelve.floor.field.data.local.objects.solutions;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.IObject;

/**
 * Created by Yaroslav on 29.05.2017.
 */

public class ProductCategoryObject implements IObject, Parcelable {

  public static final Creator<ProductCategoryObject> CREATOR =
      new Creator<ProductCategoryObject>() {
        @Override public ProductCategoryObject createFromParcel(Parcel in) {
          return new ProductCategoryObject(in);
        }

        @Override public ProductCategoryObject[] newArray(int size) {
          return new ProductCategoryObject[size];
        }
      };

  private long mId;
  @NonNull private String mName;

  public ProductCategoryObject(long mId, @NonNull String mName) {
    this.mId = mId;
    this.mName = mName;
  }

  protected ProductCategoryObject(Parcel in) {
    this.mId = in.readLong();
    this.mName = in.readString();
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeString(mName);
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
}
