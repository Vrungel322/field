package com.apps.twelve.floor.field.data.local.objects.solutions;

import android.os.Parcel;
import android.support.annotation.NonNull;

/**
 * Created by Yaroslav on 29.05.2017.
 */

public class ProductObject extends BaseTechnologicalSolutionObject {

  public static final Creator<ProductObject> CREATOR = new Creator<ProductObject>() {
    @Override public ProductObject createFromParcel(Parcel in) {
      return new ProductObject(in);
    }

    @Override public ProductObject[] newArray(int size) {
      return new ProductObject[size];
    }
  };

  private long mId;
  @NonNull private String mName;
  @NonNull private TechnologicalSolutionTypeObject mType;
  private long mPrice;
  // TODO: doze needed ???
  @NonNull private ProductCategoryObject mCategory;

  public ProductObject(long mId, @NonNull String mName,
      @NonNull TechnologicalSolutionTypeObject mType, long mPrice,
      @NonNull ProductCategoryObject category) {
    this.mId = mId;
    this.mName = mName;
    this.mType = mType;
    this.mPrice = mPrice;
    this.mCategory = category;
  }

  protected ProductObject(Parcel in) {
    this.mId = in.readLong();
    this.mName = in.readString();
    this.mType = in.readParcelable(TechnologicalSolutionTypeObject.class.getClassLoader());
    this.mPrice = in.readLong();
    this.mCategory = in.readParcelable(ProductCategoryObject.class.getClassLoader());
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeString(mName);
    dest.writeParcelable(mType, flags);
    dest.writeLong(mPrice);
    dest.writeParcelable(mCategory, flags);
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

  public ProductCategoryObject getCategory() {
    return mCategory;
  }

  public void setCategory(@NonNull ProductCategoryObject category) {
    this.mCategory = category;
  }

  public long getTypeId() {
    return mType.getId();
  }

  public long getCategoryId() {
    return mCategory.getId();
  }
}
