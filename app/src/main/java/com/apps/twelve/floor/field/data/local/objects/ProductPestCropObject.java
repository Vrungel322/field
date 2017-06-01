package com.apps.twelve.floor.field.data.local.objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.conditions.PestObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.ProductObject;

/**
 * Created by Yaroslav on 01.06.2017.
 */

public class ProductPestCropObject implements Parcelable {

  public static final Creator<ProductPestCropObject> CREATOR =
      new Creator<ProductPestCropObject>() {
        @Override public ProductPestCropObject createFromParcel(Parcel in) {
          return new ProductPestCropObject(in);
        }

        @Override public ProductPestCropObject[] newArray(int size) {
          return new ProductPestCropObject[size];
        }
      };

  private long mId;
  @NonNull private ProductObject mProduct;
  @NonNull private PestObject mPest;
  @NonNull private CropObject mCrop;

  public ProductPestCropObject(long mId, @NonNull ProductObject mProduct, @NonNull PestObject mPest,
      @NonNull CropObject mCrop) {
    this.mId = mId;
    this.mProduct = mProduct;
    this.mPest = mPest;
    this.mCrop = mCrop;
  }

  protected ProductPestCropObject(Parcel in) {
    this.mId = in.readLong();
    this.mProduct = in.readParcelable(ProductObject.class.getClassLoader());
    this.mPest = in.readParcelable(PestObject.class.getClassLoader());
    this.mCrop = in.readParcelable(CropObject.class.getClassLoader());
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeParcelable(mProduct, flags);
    dest.writeParcelable(mPest, flags);
    dest.writeParcelable(mCrop, flags);
  }

  public long getId() {
    return mId;
  }

  public void setId(long id) {
    this.mId = id;
  }

  @NonNull public ProductObject getProduct() {
    return mProduct;
  }

  public void setProduct(@NonNull ProductObject product) {
    this.mProduct = product;
  }

  @NonNull public PestObject getPest() {
    return mPest;
  }

  public void setPest(@NonNull PestObject pest) {
    this.mPest = pest;
  }

  @NonNull public CropObject getCrop() {
    return mCrop;
  }

  public void setCrop(@NonNull CropObject crop) {
    this.mCrop = crop;
  }
}
