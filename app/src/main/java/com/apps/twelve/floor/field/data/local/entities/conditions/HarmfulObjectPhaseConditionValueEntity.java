package com.apps.twelve.floor.field.data.local.entities.conditions;

import com.apps.twelve.floor.field.data.local.entities.IEntity;
import com.apps.twelve.floor.field.data.local.tables.conditions.HarmfulObjectPhaseConditionValuesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by yarrick on 19.07.17.
 */

@StorIOSQLiteType(table = HarmfulObjectPhaseConditionValuesTable.TABLE)
public class HarmfulObjectPhaseConditionValueEntity implements IEntity {

  @StorIOSQLiteColumn(name = HarmfulObjectPhaseConditionValuesTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = HarmfulObjectPhaseConditionValuesTable.COLUMN_CONDITION_TYPE_ID) Long
      conditionTypeId;
  @StorIOSQLiteColumn(name = HarmfulObjectPhaseConditionValuesTable.COLUMN_HARMFUL_OBJECT_PHASE_ID)
  Long
      harmfulObjectPhaseId;

  public HarmfulObjectPhaseConditionValueEntity() {
  }

  public HarmfulObjectPhaseConditionValueEntity(Long id, Long conditionTypeId,
      Long harmfulObjectPhaseId) {
    this.id = id;
    this.conditionTypeId = conditionTypeId;
    this.harmfulObjectPhaseId = harmfulObjectPhaseId;
  }

  public static HarmfulObjectPhaseConditionValueEntity newHarmfulObjectPhaseValueEntity(Long id,
      Long conditionTypeId, Long harmfulObjectPhaseId) {
    return new HarmfulObjectPhaseConditionValueEntity(id, conditionTypeId, harmfulObjectPhaseId);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    SoilTypeConditionValueEntity that = (SoilTypeConditionValueEntity) obj;

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
