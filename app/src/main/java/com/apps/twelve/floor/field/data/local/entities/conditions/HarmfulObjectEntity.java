package com.apps.twelve.floor.field.data.local.entities.conditions;

import com.apps.twelve.floor.field.data.local.tables.conditions.HarmfulObjectsTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by yarrick on 05.07.17.
 */

@StorIOSQLiteType(table = HarmfulObjectsTable.TABLE) public class HarmfulObjectEntity {

  @StorIOSQLiteColumn(name = HarmfulObjectsTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = HarmfulObjectsTable.COLUMN_TYPE_ID) Long typeId;
  @StorIOSQLiteColumn(name = HarmfulObjectsTable.COLUMN_VALUE_ID) Long valueId;

  public HarmfulObjectEntity() {
  }

  public HarmfulObjectEntity(Long id, Long typeId, Long valueId) {
    this.id = id;
    this.typeId = typeId;
    this.valueId = valueId;
  }

  public static HarmfulObjectEntity newHarmfulObjectEntity(Long id, Long typeId, Long valueId) {
    if (id == 0) id = null;
    return new HarmfulObjectEntity(id, typeId, valueId);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    HarmfulObjectEntity that = (HarmfulObjectEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (typeId != null ? !typeId.equals(that.typeId) : that.typeId != null) return false;

    return valueId != null ? valueId.equals(that.valueId) : that.valueId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
    result = 31 * result + (valueId != null ? valueId.hashCode() : 0);
    return result;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getTypeId() {
    return typeId;
  }

  public void setTypeId(Long typeId) {
    this.typeId = typeId;
  }

  public Long getValueId() {
    return valueId;
  }

  public void setValueId(Long valueId) {
    this.valueId = valueId;
  }
}
