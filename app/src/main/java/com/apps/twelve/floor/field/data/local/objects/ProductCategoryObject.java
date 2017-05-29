package com.apps.twelve.floor.field.data.local.objects;

/**
 * Created by Yaroslav on 29.05.2017.
 */

public class ProductCategoryObject {

  private long mId;
  private String mName;

  public ProductCategoryObject(long mId, String mName) {
    this.mId = mId;
    this.mName = mName;
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

  public void setName(String name) {
    this.mName = name;
  }
}
