package com.apps.twelve.floor.field.data.local.entities.conditions;

import com.apps.twelve.floor.field.data.local.entities.IEntity;
import com.apps.twelve.floor.field.data.local.tables.conditions.SpanConditionValuesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 02.06.2017.
 */

@StorIOSQLiteType(table = SpanConditionValuesTable.TABLE) public class SpanConditionValueEntity
    implements IEntity {

  @StorIOSQLiteColumn(name = SpanConditionValuesTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = SpanConditionValuesTable.COLUMN_CONDITION_TYPE_ID) Long
      conditionTypeId;
  @StorIOSQLiteColumn(name = SpanConditionValuesTable.COLUMN_VALUE_FROM) Long valueFrom;
  @StorIOSQLiteColumn(name = SpanConditionValuesTable.COLUMN_VALUE_TO) Long valueTo;

  public SpanConditionValueEntity() {
  }

  public SpanConditionValueEntity(Long id, Long conditionTypeId, Long valueFrom, Long valueTo) {
    this.id = id;
    this.conditionTypeId = conditionTypeId;
    this.valueFrom = valueFrom;
    this.valueTo = valueTo;
  }

  public static SpanConditionValueEntity newConditionSpanValueEntity(Long id, Long conditionTypeId,
      Long valueFrom, Long valueTo) {
    if (id == 0) id = null;
    return new SpanConditionValueEntity(id, conditionTypeId, valueFrom, valueTo);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    SpanConditionValueEntity that = (SpanConditionValueEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (conditionTypeId != null ? !conditionTypeId.equals(that.conditionTypeId)
        : that.conditionTypeId != null) {
      return false;
    }
    if (valueFrom != null ? !valueFrom.equals(that.valueFrom) : that.valueFrom != null) {
      return false;
    }

    return valueTo != null ? valueTo.equals(that.valueTo) : that.valueTo == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (conditionTypeId != null ? conditionTypeId.hashCode() : 0);
    result = 31 * result + (valueFrom != null ? valueFrom.hashCode() : 0);
    result = 31 * result + (valueTo != null ? valueTo.hashCode() : 0);
    return result;
  }
}
