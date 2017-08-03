package com.apps.twelve.floor.field.data.local.entities.conditions;

import com.apps.twelve.floor.field.data.local.entities.IEntity;
import com.apps.twelve.floor.field.data.local.tables.conditions.PhenologicalCharacteristicValuesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by yarrick on 07.07.17.
 */

@StorIOSQLiteType(table = PhenologicalCharacteristicValuesTable.TABLE)
public class PhenologicalCharacteristicValueEntity implements IEntity {

  @StorIOSQLiteColumn(name = PhenologicalCharacteristicValuesTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = PhenologicalCharacteristicValuesTable.COLUMN_CONDITION_TYPE_ID) Long
      conditionTypeId;
  @StorIOSQLiteColumn(name = PhenologicalCharacteristicValuesTable.COLUMN_PHENOLOGICAL_CHARACTERISTIC_ID)
  Long phenologicalCharacteristicId;

  public PhenologicalCharacteristicValueEntity() {
  }

  public PhenologicalCharacteristicValueEntity(Long id, Long conditionTypeId,
      Long phenologicalCharacteristicId) {
    this.id = id;
    this.conditionTypeId = conditionTypeId;
    this.phenologicalCharacteristicId = phenologicalCharacteristicId;
  }

  public static PhenologicalCharacteristicValueEntity newPhenologicalCharacteristicValueEntity(
      Long id, Long conditionTypeId, Long phenologicalCharacteristicId) {
    if (id == 0) id = null;
    return new PhenologicalCharacteristicValueEntity(id, conditionTypeId,
        phenologicalCharacteristicId);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    PhenologicalCharacteristicValueEntity that = (PhenologicalCharacteristicValueEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (conditionTypeId != conditionTypeId ? !conditionTypeId.equals(that.conditionTypeId)
        : that.conditionTypeId != null) {
      return false;
    }

    return phenologicalCharacteristicId != null ? phenologicalCharacteristicId.equals(
        that.phenologicalCharacteristicId) : that.phenologicalCharacteristicId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (conditionTypeId != null ? conditionTypeId.hashCode() : 0);
    result = 31 * result + (phenologicalCharacteristicId != null
        ? phenologicalCharacteristicId.hashCode() : 0);
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

  public Long getPhenologicalCharacteristicId() {
    return phenologicalCharacteristicId;
  }

  public void setPhenologicalCharacteristicId(Long phenologicalCharacteristicId) {
    this.phenologicalCharacteristicId = phenologicalCharacteristicId;
  }
}
