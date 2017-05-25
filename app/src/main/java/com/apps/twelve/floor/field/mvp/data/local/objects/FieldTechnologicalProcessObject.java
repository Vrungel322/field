package com.apps.twelve.floor.field.mvp.data.local.objects;

/**
 * Created by Yaroslav on 23.05.2017.
 */

public class FieldTechnologicalProcessObject {

  private long mId;
  private FieldObject mField;
  private TechnologicalProcessObject mTechProcess;
  private TechnologicalProcessStatusObject mStatus;

  public FieldTechnologicalProcessObject(long id, FieldObject field,
      TechnologicalProcessObject techProcess, TechnologicalProcessStatusObject status) {
    this.mId = id;
    this.mField = field;
    this.mTechProcess = techProcess;
    this.mStatus = status;
  }

  public long getId() {
    return mId;
  }

  public void setId(long id) {
    this.mId = id;
  }

  public FieldObject getField() {
    return mField;
  }

  public void setField(FieldObject field) {
    this.mField = field;
  }

  public TechnologicalProcessObject getTechProcess() {
    return mTechProcess;
  }

  public void setTechProcess(TechnologicalProcessObject techProcess) {
    this.mTechProcess = techProcess;
  }

  public TechnologicalProcessStatusObject getStatus() {
    return mStatus;
  }

  public void setStatus(TechnologicalProcessStatusObject status) {
    this.mStatus = status;
  }
}
