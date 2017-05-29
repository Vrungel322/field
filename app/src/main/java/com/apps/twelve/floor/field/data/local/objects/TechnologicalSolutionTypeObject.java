package com.apps.twelve.floor.field.data.local.objects;

/**
 * Created by Yaroslav on 25.05.2017.
 */

// TODO: make it Parcelable
public class TechnologicalSolutionTypeObject {

  private long mId;
  private String mName;

  public TechnologicalSolutionTypeObject(long id, String name) {
    this.mId = id;
    this.mName = name;
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
