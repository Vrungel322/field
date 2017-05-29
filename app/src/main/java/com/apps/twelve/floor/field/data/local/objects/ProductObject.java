package com.apps.twelve.floor.field.data.local.objects;

/**
 * Created by Yaroslav on 29.05.2017.
 */

public class ProductObject extends BaseTechnologicalSolutionObject {

  private long mId;
  private String mName;
  private TechnologicalSolutionTypeObject mType;
  private long mPrice;
  private ProductCategoryObject mCategory;

  public ProductObject(long mId, String mName, TechnologicalSolutionTypeObject mType, long mPrice,
      ProductCategoryObject category) {
    this.mId = mId;
    this.mName = mName;
    this.mType = mType;
    this.mPrice = mPrice;
    this.mCategory = category;
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

  @Override public void setName(String name) {
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

  @Override public void setType(TechnologicalSolutionTypeObject type) {
    this.mType = type;
  }

  public ProductCategoryObject getCategory() {
    return mCategory;
  }

  public void setCategory(ProductCategoryObject category) {
    this.mCategory = category;
  }
}
