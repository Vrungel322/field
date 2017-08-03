package com.apps.twelve.floor.field.data.local.entities.conditions;

import com.apps.twelve.floor.field.data.local.entities.IEntity;
import com.apps.twelve.floor.field.data.local.tables.conditions.HarmfulObjectValuesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by yarrick on 19.07.17.
 */

@StorIOSQLiteType(table = HarmfulObjectValuesTable.TABLE) public class HarmfulObjectValueEntity
    implements IEntity {

  @StorIOSQLiteColumn(name = HarmfulObjectValuesTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = HarmfulObjectValuesTable.COLUMN_CONDITION_TYPE_ID) Long
      conditionTypeId;
  @StorIOSQLiteColumn(name = HarmfulObjectValuesTable.COLUMN_HARMFUL_OBJECT_ID) Long
      harmfulObjectId;

  public HarmfulObjectValueEntity() {
  }

  public HarmfulObjectValueEntity(Long id, Long conditionTypeId, Long harmfulObjectId) {
    this.id = id;
    this.conditionTypeId = conditionTypeId;
    this.harmfulObjectId = harmfulObjectId;
  }

  public static HarmfulObjectValueEntity newHarmfulObjectValueEntity(Long id, Long conditionTypeId,
      Long harmfulObjectId) {
    return new HarmfulObjectValueEntity(id, conditionTypeId, harmfulObjectId);
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

    return harmfulObjectId != null ? harmfulObjectId.equals(that.soilTypeId)
        : that.soilTypeId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (conditionTypeId != null ? conditionTypeId.hashCode() : 0);
    result = 31 * result + (harmfulObjectId != null ? harmfulObjectId.hashCode() : 0);
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

  public Long getHarmfulObjectId() {
    return harmfulObjectId;
  }

  public void setHarmfulObjectId(Long harmfulObjectId) {
    this.harmfulObjectId = harmfulObjectId;
  }
}
