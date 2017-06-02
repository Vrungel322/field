package com.apps.twelve.floor.field.data.local.entities.conditions;

import com.apps.twelve.floor.field.data.local.tables.conditions.TillageDirectionsTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 02.06.2017.
 */

@StorIOSQLiteType(table = TillageDirectionsTable.TABLE) public class TillageDirectionEntity {

  @StorIOSQLiteColumn(name = TillageDirectionsTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = TillageDirectionsTable.COLUMN_NAME) String name;
  @StorIOSQLiteColumn(name = TillageDirectionsTable.COLUMN_CONDITION_TYPE_ID) Long conditionTypeId;

  public TillageDirectionEntity() {
  }

  public TillageDirectionEntity(Long id, String name, Long conditionTypeId) {
    this.id = id;
    this.name = name;
    this.conditionTypeId = conditionTypeId;
  }

  public static TillageDirectionEntity newTillageDirectionEntity(Long id, String name,
      Long conditioTypeId) {
    if (id == 0) id = null;
    return new TillageDirectionEntity(id, name, conditioTypeId);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    TillageDirectionEntity that = (TillageDirectionEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;

    return conditionTypeId != null ? conditionTypeId.equals(that.conditionTypeId)
        : that.conditionTypeId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (conditionTypeId != null ? conditionTypeId.hashCode() : 0);
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
}
