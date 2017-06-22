package com.apps.twelve.floor.field.data.local.entities.conditions;

import com.apps.twelve.floor.field.data.local.tables.conditions.ConditionsTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 02.06.2017.
 */

@StorIOSQLiteType(table = ConditionsTable.TABLE) public class ConditionEntity {

  @StorIOSQLiteColumn(name = ConditionsTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = ConditionsTable.COLUMN_NAME) String name;
  @StorIOSQLiteColumn(name = ConditionsTable.COLUMN_PRIORITY) Integer priority;
  @StorIOSQLiteColumn(name = ConditionsTable.COLUMN_CONDITION_TYPE_ID) Long conditionTypeId;
  @StorIOSQLiteColumn(name = ConditionsTable.COLUMN_CONDITION_VALUE_ID) Long conditionValueId;

  public ConditionEntity() {
  }

  public ConditionEntity(Long id, String name, Integer priority, Long conditionTypeId,
      Long conditionValueId) {
    this.id = id;
    this.name = name;
    this.priority = priority;
    this.conditionTypeId = conditionTypeId;
    this.conditionValueId = conditionValueId;
  }

  public static ConditionEntity newConditionEntity(Long id, String name, Integer priority,
      Long conditionTypeId, Long conditionValueId) {
    if (id == 0) id = null;
    return new ConditionEntity(id, name, priority, conditionTypeId, conditionValueId);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    ConditionEntity that = (ConditionEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    if (priority != null ? !priority.equals(that.priority) : that.priority != null) return false;
    if (conditionTypeId != null ? !conditionTypeId.equals(that.conditionTypeId)
        : that.conditionTypeId != null) {
      return false;
    }

    return conditionValueId != null ? conditionValueId.equals(that.conditionValueId)
        : that.conditionValueId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (priority != null ? priority.hashCode() : 0);
    result = 31 * result + (conditionTypeId != null ? conditionTypeId.hashCode() : 0);
    result = 31 * result + (conditionValueId != null ? conditionValueId.hashCode() : 0);
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

  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public Long getConditionTypeId() {
    return conditionTypeId;
  }

  public void setConditionTypeId(Long conditionTypeId) {
    this.conditionTypeId = conditionTypeId;
  }

  public Long getConditionValueId() {
    return conditionValueId;
  }

  public void setConditionValueId(Long conditionValueId) {
    this.conditionValueId = conditionValueId;
  }
}
