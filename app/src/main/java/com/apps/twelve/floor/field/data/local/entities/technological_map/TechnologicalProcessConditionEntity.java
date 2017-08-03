package com.apps.twelve.floor.field.data.local.entities.technological_map;

import com.apps.twelve.floor.field.data.local.entities.IEntity;
import com.apps.twelve.floor.field.data.local.tables.technological_map.TechnologicalProcessesConditionsTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 01.06.2017.
 */

@StorIOSQLiteType(table = TechnologicalProcessesConditionsTable.TABLE)
public class TechnologicalProcessConditionEntity implements IEntity {

  @StorIOSQLiteColumn(name = TechnologicalProcessesConditionsTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = TechnologicalProcessesConditionsTable.COLUMN_SET_ID) Long setId;
  @StorIOSQLiteColumn(name = TechnologicalProcessesConditionsTable.COLUMN_CROP_TECH_PROCESS_ID) Long
      cropTechnologicalProcessId;
  @StorIOSQLiteColumn(name = TechnologicalProcessesConditionsTable.COLUMN_CONDITION_ID) Long
      conditionId;

  public TechnologicalProcessConditionEntity() {
  }

  public TechnologicalProcessConditionEntity(Long id, Long setId, Long cropTechnologicalProcessId,
      Long conditionId) {
    this.id = id;
    this.setId = setId;
    this.cropTechnologicalProcessId = cropTechnologicalProcessId;
    this.conditionId = conditionId;
  }

  public static TechnologicalProcessConditionEntity newTechnologicalProcessesConditionEntity(
      Long id, Long setId, Long cropTechnologicalProcessId, Long conditionId) {
    if (id == 0) id = null;
    return new TechnologicalProcessConditionEntity(id, setId, cropTechnologicalProcessId,
        conditionId);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    TechnologicalProcessConditionEntity that = (TechnologicalProcessConditionEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (setId != null ? !setId.equals(that.setId) : that.setId != null) return false;
    if (cropTechnologicalProcessId != null ? !cropTechnologicalProcessId.equals(
        that.cropTechnologicalProcessId) : that.cropTechnologicalProcessId != null) {
      return false;
    }

    return conditionId != null ? conditionId.equals(that.conditionId) : that.conditionId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (setId != null ? setId.hashCode() : 0);
    result =
        31 * result + (cropTechnologicalProcessId != null ? cropTechnologicalProcessId.hashCode()
            : 0);
    result = 31 * result + (conditionId != null ? conditionId.hashCode() : 0);
    return result;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getSetId() {
    return setId;
  }

  public void setSetId(Long setId) {
    this.setId = setId;
  }

  public Long getCropTechnologicalProcessId() {
    return cropTechnologicalProcessId;
  }

  public void setCropTechnologicalProcessId(Long cropTechnologicalProcessId) {
    this.cropTechnologicalProcessId = cropTechnologicalProcessId;
  }

  public Long getConditionId() {
    return conditionId;
  }

  public void setConditionId(Long conditionId) {
    this.conditionId = conditionId;
  }
}
