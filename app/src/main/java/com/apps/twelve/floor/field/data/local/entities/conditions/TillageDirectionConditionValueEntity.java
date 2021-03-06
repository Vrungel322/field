package com.apps.twelve.floor.field.data.local.entities.conditions;

import com.apps.twelve.floor.field.data.local.entities.IEntity;
import com.apps.twelve.floor.field.data.local.tables.conditions.TillageDirectionConditionValuesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by yarrick on 06.07.17.
 */

@StorIOSQLiteType(table = TillageDirectionConditionValuesTable.TABLE)
public class TillageDirectionConditionValueEntity implements IEntity {

  @StorIOSQLiteColumn(name = TillageDirectionConditionValuesTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = TillageDirectionConditionValuesTable.COLUMN_CONDITION_TYPE_ID) Long
      conditionTypeId;
  @StorIOSQLiteColumn(name = TillageDirectionConditionValuesTable.COLUMN_TILLAGE_DIRECTION_ID) Long
      tillageDirectionId;

  public TillageDirectionConditionValueEntity() {
  }

  public TillageDirectionConditionValueEntity(Long id, Long conditionTypeId,
      Long tillageDirectionId) {
    this.id = id;
    this.conditionTypeId = conditionTypeId;
    this.tillageDirectionId = tillageDirectionId;
  }

  public static TillageDirectionConditionValueEntity newTillageDirectionValueEntity(Long id,
      Long conditionTypeId, Long tillageDirectionId) {
    if (id == 0) id = null;
    return new TillageDirectionConditionValueEntity(id, conditionTypeId, tillageDirectionId);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    TillageDirectionConditionValueEntity that = (TillageDirectionConditionValueEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (conditionTypeId != conditionTypeId ? !conditionTypeId.equals(that.conditionTypeId)
        : that.conditionTypeId != null) {
      return false;
    }

    return tillageDirectionId != null ? tillageDirectionId.equals(that.tillageDirectionId)
        : that.tillageDirectionId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (conditionTypeId != null ? conditionTypeId.hashCode() : 0);
    result = 31 * result + (tillageDirectionId != null ? tillageDirectionId.hashCode() : 0);
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

  public Long getTillageDirectionId() {
    return tillageDirectionId;
  }

  public void setTillageDirectionId(Long tillageDirectionId) {
    this.tillageDirectionId = tillageDirectionId;
  }
}
