package com.apps.twelve.floor.field.data.local.objects;

import com.apps.twelve.floor.field.R;

/**
 * Created by Yaroslav on 23.05.2017.
 */

// TODO: make it Parcelable
public class TechnologicalProcessStatusObject {

  private long mId;
  private String mName;

  public TechnologicalProcessStatusObject(long mId, String mName) {
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

  // TODO: keep status images in resources, and their ids - in DB
  public int getImageId() {
    return R.mipmap.ic_launcher_round;
  }
}
