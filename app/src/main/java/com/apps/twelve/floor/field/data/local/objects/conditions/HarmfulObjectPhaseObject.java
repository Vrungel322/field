package com.apps.twelve.floor.field.data.local.objects.conditions;

import android.support.annotation.NonNull;

/**
 * Created by Yaroslav on 31.05.2017.
 */

public class HarmfulObjectPhaseObject {

  private long mId;
  @NonNull private String mName;
  @NonNull private HarmfulObjectObject mHarmfulObject;

  public HarmfulObjectPhaseObject(long id, @NonNull String name,
      @NonNull HarmfulObjectObject harmfulObject) {
    this.mId = id;
    this.mName = name;
    this.mHarmfulObject = harmfulObject;
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

  @NonNull public HarmfulObjectObject getHarmfulObject() {
    return mHarmfulObject;
  }

  public void setHarmfulObject(@NonNull HarmfulObjectObject harmfulObject) {
    this.mHarmfulObject = harmfulObject;
  }

  public long getHarmfulObjectId() {
    return (mHarmfulObject == null) ? 0 : mHarmfulObject.getId();
  }
}
