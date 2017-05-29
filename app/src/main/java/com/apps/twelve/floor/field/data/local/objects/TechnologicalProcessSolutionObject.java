package com.apps.twelve.floor.field.data.local.objects;

/**
 * Created by Yaroslav on 25.05.2017.
 */

// TODO: make it Parcelable
public class TechnologicalProcessSolutionObject {

  private long mId;
  private FieldTechnologicalProcessObject mTechnologicalProcess;
  private TechnologicalSolutionTypeObject mType;
  private BaseTechnologicalSolutionObject mSolutionValue;

  public TechnologicalProcessSolutionObject(long id,
      FieldTechnologicalProcessObject technologicalProcess, TechnologicalSolutionTypeObject type,
      BaseTechnologicalSolutionObject solutionValue) {
    this.mId = id;
    this.mTechnologicalProcess = technologicalProcess;
    this.mType = type;
    this.mSolutionValue = solutionValue;
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

  public BaseTechnologicalSolutionObject getmSolutionValue() {
    return mSolutionValue;
  }

  public void setSolutionValue(BaseTechnologicalSolutionObject solutionValue) {
    this.mSolutionValue = solutionValue;
  }
}
