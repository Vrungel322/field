package com.apps.twelve.floor.field.data.local.entities.conditions;

import com.apps.twelve.floor.field.data.local.tables.conditions.PestPhasesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 02.06.2017.
 */

@StorIOSQLiteType(table = PestPhasesTable.TABLE) public class PestPhaseEntity {

  @StorIOSQLiteColumn(name = PestPhasesTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = PestPhasesTable.COLUMN_NAME) String name;
  @StorIOSQLiteColumn(name = PestPhasesTable.COLUMN_CONDITION_TYPE_ID) Long conditionTypeId;
  @StorIOSQLiteColumn(name = PestPhasesTable.COLUMN_PEST_ID) Long pestId;

  public PestPhaseEntity() {
  }

  public PestPhaseEntity(Long id, String name, Long conditionTypeId, Long pestId) {
    this.id = id;
    this.name = name;
    this.conditionTypeId = conditionTypeId;
    this.pestId = pestId;
  }

  public static PestPhaseEntity newPestPhaseEntity(Long id, String name, Long conditionTypeId,
      Long pestId) {
    if (id == 0) id = null;
    return new PestPhaseEntity(id, name, conditionTypeId, pestId);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    PestPhaseEntity that = (PestPhaseEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    if (conditionTypeId != null ? !conditionTypeId.equals(that.conditionTypeId)
        : that.conditionTypeId != null) {
      return false;
    }

    return pestId != null ? pestId.equals(that.pestId) : that.pestId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (conditionTypeId != null ? conditionTypeId.hashCode() : 0);
    result = 31 * result + (pestId != null ? pestId.hashCode() : 0);
    return result;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getConditionTypeId() {
    return conditionTypeId;
  }

  public void setConditionTypeId(Long conditionTypeId) {
    this.conditionTypeId = conditionTypeId;
  }

  public Long getPestId() {
    return pestId;
  }

  public void setPestId(Long pestId) {
    this.pestId = pestId;
  }
}
