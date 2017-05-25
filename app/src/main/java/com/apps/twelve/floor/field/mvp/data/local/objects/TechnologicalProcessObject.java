package com.apps.twelve.floor.field.mvp.data.local.objects;

/**
 * Created by Yaroslav on 23.05.2017.
 */

public class TechnologicalProcessObject {

  private long mId;
  private String mName;
  private int mOrder;
  private CropObject mCrop;
  private TechnologicalProcessTimeObject mTime;

  public TechnologicalProcessObject(long id, String name, int order, CropObject crop,
      TechnologicalProcessTimeObject time) {
    this.mId = id;
    this.mName = name;
    this.mOrder = order;
    this.mCrop = crop;
    this.mTime = time;
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

  public int getOrder() {
    return mOrder;
  }

  public void setOrder(int order) {
    this.mOrder = order;
  }

  public CropObject getCrop() {
    return mCrop;
  }

  public void setCrop(CropObject crop) {
    this.mCrop = crop;
  }

  public TechnologicalProcessTimeObject getTime() {
    return mTime;
  }

  public void setTime(TechnologicalProcessTimeObject time) {
    this.mTime = time;
  }
}
