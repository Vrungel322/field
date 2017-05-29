package com.apps.twelve.floor.field.data.local.objects;

/**
 * Created by Yaroslav on 23.05.2017.
 */

// TODO: make it Parcelable
public class TechnologicalProcessTimeObject {

  private long mId;
  private String mName;
  private ClimateZoneObject mClimateZone;
  private PhaseObject mPhase;
  private ProcessPeriodObject mPeriod;

  public TechnologicalProcessTimeObject(long mId, String mName, ClimateZoneObject mClimateZone,
      PhaseObject mPhase, ProcessPeriodObject mPeriod) {
    this.mId = mId;
    this.mName = mName;
    this.mClimateZone = mClimateZone;
    this.mPhase = mPhase;
    this.mPeriod = mPeriod;
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

  public ClimateZoneObject getClimateZone() {
    return mClimateZone;
  }

  public void setClimateZone(ClimateZoneObject climateZone) {
    this.mClimateZone = climateZone;
  }

  public PhaseObject getPhase() {
    return mPhase;
  }

  public void setPhase(PhaseObject phase) {
    this.mPhase = phase;
  }

  public ProcessPeriodObject getPeriod() {
    return mPeriod;
  }

  public void setPeriod(ProcessPeriodObject period) {
    this.mPeriod = period;
  }
}
