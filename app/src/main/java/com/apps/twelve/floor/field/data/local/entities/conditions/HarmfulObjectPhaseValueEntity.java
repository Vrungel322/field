package com.apps.twelve.floor.field.data.local.entities.conditions;

import com.apps.twelve.floor.field.data.local.tables.conditions.HarmfulObjectPhaseValuesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by yarrick on 19.07.17.
 */

@StorIOSQLiteType(table = HarmfulObjectPhaseValuesTable.TABLE)
public class HarmfulObjectPhaseValueEntity {

  @StorIOSQLiteColumn(name = HarmfulObjectPhaseValuesTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = HarmfulObjectPhaseValuesTable.COLUMN_CONDITION_TYPE_ID) Long
      conditionTypeId;
  @StorIOSQLiteColumn(name = HarmfulObjectPhaseValuesTable.COLUMN_HARMFUL_OBJECT_PHASE_ID) Long
      harmfulObjectPhaseId;

  public HarmfulObjectPhaseValueEntity() {
  }

  public HarmfulObjectPhaseValueEntity(Long id, Long conditionTypeId, Long harmfulObjectPhaseId) {
    this.id = id;
    this.conditionTypeId = conditionTypeId;
    this.harmfulObjectPhaseId = harmfulObjectPhaseId;
  }

  public static HarmfulObjectPhaseValueEntity newHarmfulObjectPhaseValueEntity(Long id,
      Long conditionTypeId, Long harmfulObjectPhaseId) {
    return new HarmfulObjectPhaseValueEntity(id, conditionTypeId, harmfulObjectPhaseId);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    SoilTypeValueEntity that = (SoilTypeValueEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (conditionTypeId != null ? !conditionTypeId.equals(that.conditionTypeId)
        : that.conditionTypeId != null) {
      return false;
    }

    return harmfulObjectPhaseId != null ? harmfulObjectPhaseId.equals(that.soilTypeId)
        : that.soilTypeId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (conditionTypeId != null ? conditionTypeId.hashCode() : 0);
    result = 31 * result + (harmfulObjectPhaseId != null ? harmfulObjectPhaseId.hashCode() : 0);
    return result;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getConditionTypeId() {
    return conditionTypeId;
  }

  public void setConditionTypeId(Long conditionTypeId) {
    this.conditionTypeId = conditionTypeId;
  }

  public Long getHarmfulObjectPhaseId() {
    return harmfulObjectPhaseId;
  }

  public void setHarmfulObjectPhaseId(Long harmfulObjectPhaseId) {
    this.harmfulObjectPhaseId = harmfulObjectPhaseId;
  }
}
