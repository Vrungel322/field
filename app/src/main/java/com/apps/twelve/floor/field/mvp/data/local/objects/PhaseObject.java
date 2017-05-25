package com.apps.twelve.floor.field.mvp.data.local.objects;

/**
 * Created by Yaroslav on 23.05.2017.
 */

public class PhaseObject {

  private long mId;
  private String mName;
  private CropObject mCrop;

  public PhaseObject(long id, String name, CropObject crop) {
    this.mId = id;
    this.mName = name;
    this.mCrop = crop;
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

  public CropObject getCrop() {
    return mCrop;
  }

  public void setCrop(CropObject crop) {
    this.mCrop = crop;
  }
}
