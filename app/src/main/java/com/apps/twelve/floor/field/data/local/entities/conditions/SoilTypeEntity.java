package com.apps.twelve.floor.field.data.local.entities.conditions;

import com.apps.twelve.floor.field.data.local.tables.conditions.SoilTypesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 02.06.2017.
 */

@StorIOSQLiteType(table = SoilTypesTable.TABLE) public class SoilTypeEntity {

  @StorIOSQLiteColumn(name = SoilTypesTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = SoilTypesTable.COLUMN_NAME) String name;
  @StorIOSQLiteColumn(name = SoilTypesTable.COLUMN_CONDITION_TYPE_ID) Long conditionTypeId;
  @StorIOSQLiteColumn(name = SoilTypesTable.COLUMN_COORDINATES) String coordinates;

  public SoilTypeEntity() {
  }

  public SoilTypeEntity(Long id, String name, Long conditionTypeId, String coordinates) {
    this.id = id;
    this.name = name;
    this.conditionTypeId = conditionTypeId;
    this.coordinates = coordinates;
  }

  public static SoilTypeEntity newSoilTypeEntity(Long id, String name, Long conditionTypeId,
      String coordinates) {
    if (id == 0) id = null;
    return new SoilTypeEntity(id, name, conditionTypeId, coordinates);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    SoilTypeEntity that = (SoilTypeEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    if (conditionTypeId != null ? !conditionTypeId.equals(that.conditionTypeId)
        : that.conditionTypeId != null) {
      return false;
    }

    return coordinates != null ? coordinates.equals(that.coordinates) : that.coordinates == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (conditionTypeId != null ? conditionTypeId.hashCode() : 0);
    result = 31 * result + (coordinates != null ? coordinates.hashCode() : 0);
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

  public String getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(String coordinates) {
    this.coordinates = coordinates;
  }
}
