package com.apps.twelve.floor.field.data.local.entities.technological_map;

import com.apps.twelve.floor.field.data.local.entities.IEntity;
import com.apps.twelve.floor.field.data.local.tables.technological_map.FieldCropTechnologicalProcessesConditionsTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by yarrick on 16.08.17.
 */

@StorIOSQLiteType(table = FieldCropTechnologicalProcessesConditionsTable.TABLE)
public class FieldCropTechnologicalProcessConditionEntity implements IEntity {

  @StorIOSQLiteColumn(name = FieldCropTechnologicalProcessesConditionsTable.COLUMN_ID, key = true)
  Long id;
  @StorIOSQLiteColumn(name = FieldCropTechnologicalProcessesConditionsTable.COLUMN_PROCESS_ID) Long
      processId;
  @StorIOSQLiteColumn(name = FieldCropTechnologicalProcessesConditionsTable.COLUMN_CONDITION_ID)
  Long conditionId;
  @StorIOSQLiteColumn(name = FieldCropTechnologicalProcessesConditionsTable.COLUMN_IS_FULFILLED)
  Boolean isFulfilled;

  public FieldCropTechnologicalProcessConditionEntity() {
  }

  public FieldCropTechnologicalProcessConditionEntity(Long id, Long processId, Long conditionId,
      Boolean isFulfilled) {
    this.id = id;
    this.processId = processId;
    this.conditionId = conditionId;
    this.isFulfilled = isFulfilled;
  }

  public static FieldCropTechnologicalProcessConditionEntity newFieldCropTechnologicalProcessConditionEntity(
      Long id, Long processId, Long conditionId, Boolean isFulfilled) {
    if (id == 0) id = null;
    return new FieldCropTechnologicalProcessConditionEntity(id, processId, conditionId,
        isFulfilled);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    FieldCropTechnologicalProcessConditionEntity that =
        (FieldCropTechnologicalProcessConditionEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (isFulfilled != null ? !isFulfilled.equals(that.isFulfilled) : that.isFulfilled != null) {
      return false;
    }
    if (processId != null ? !processId.equals(that.processId) : that.processId != null) {
      return false;
    }

    return conditionId != null ? conditionId.equals(that.conditionId) : that.conditionId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (processId != null ? processId.hashCode() : 0);
    result = 31 * result + (conditionId != null ? conditionId.hashCode() : 0);
    result = 31 * result + (isFulfilled != null ? isFulfilled.hashCode() : 0);
    return result;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getProcessId() {
    return processId;
  }

  public void setProcessId(Long processId) {
    this.processId = processId;
  }

  public Long getConditionId() {
    return conditionId;
  }

  public void setConditionId(Long conditionId) {
    this.conditionId = conditionId;
  }

  public Boolean getFulfilled() {
    return isFulfilled;
  }

  public void setFulfilled(Boolean fulfilled) {
    isFulfilled = fulfilled;
  }
}
