package com.apps.twelve.floor.field.data.local.entities.conditions;

import com.apps.twelve.floor.field.data.local.entities.IEntity;
import com.apps.twelve.floor.field.data.local.tables.conditions.SoilTypeConditionValuesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by yarrick on 07.07.17.
 */

@StorIOSQLiteType(table = SoilTypeConditionValuesTable.TABLE)
public class SoilTypeConditionValueEntity
    implements IEntity {

  @StorIOSQLiteColumn(name = SoilTypeConditionValuesTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = SoilTypeConditionValuesTable.COLUMN_CONDITION_TYPE_ID) Long
      conditionTypeId;
  @StorIOSQLiteColumn(name = SoilTypeConditionValuesTable.COLUMN_SOIL_TYPE_ID) Long soilTypeId;

  public SoilTypeConditionValueEntity() {
  }

  public SoilTypeConditionValueEntity(Long id, Long conditionTypeId, Long soilTypeId) {
    this.id = id;
    this.conditionTypeId = conditionTypeId;
    this.soilTypeId = soilTypeId;
  }

  public static SoilTypeConditionValueEntity newSoilTypeValueEntity(Long id, Long conditionTypeId,
      Long soilTypeId) {
    return new SoilTypeConditionValueEntity(id, conditionTypeId, soilTypeId);
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

    return soilTypeId != null ? soilTypeId.equals(that.soilTypeId) : that.soilTypeId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (conditionTypeId != null ? conditionTypeId.hashCode() : 0);
    result = 31 * result + (soilTypeId != null ? soilTypeId.hashCode() : 0);
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

  public Long getSoilTypeId() {
    return soilTypeId;
  }

  public void setSoilTypeId(Long soilTypeId) {
    this.soilTypeId = soilTypeId;
  }
}
