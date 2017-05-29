package com.apps.twelve.floor.field.data.local.objects;

/**
 * Created by Yaroslav on 25.05.2017.
 */

// TODO: make it Parcelable
public class TechnologicalSolutionObject {

  private long mId;
  private FieldTechnologicalProcessObject mTechnologicalProcess;
  private TechnologicalSolutionTypeObject mType;
  private long mSolutionValueId;

  public TechnologicalSolutionObject(long id, FieldTechnologicalProcessObject technologicalProcess,
      TechnologicalSolutionTypeObject type, long solutionValueId) {
    this.mId = id;
    this.mTechnologicalProcess = technologicalProcess;
    this.mType = type;
    this.mSolutionValueId = solutionValueId;
  }

  public long getId() {
    return mId;
  }

  public void setId(long id) {
    this.mId = id;
  }

  public FieldTechnologicalProcessObject getTechnologicalProcess() {
    return mTechnologicalProcess;
  }

  public void setTechnologicalProcess(FieldTechnologicalProcessObject technologicalProcess) {
    this.mTechnologicalProcess = technologicalProcess;
  }

  public TechnologicalSolutionTypeObject getType() {
    return mType;
  }

  public void setType(TechnologicalSolutionTypeObject type) {
    this.mType = type;
  }

  public long getSolutionValueId() {
    return mSolutionValueId;
  }

  public void setSolutionValueId(long solutionValueId) {
    this.mSolutionValueId = solutionValueId;
  }
}
