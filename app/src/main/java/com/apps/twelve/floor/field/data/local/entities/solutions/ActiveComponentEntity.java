package com.apps.twelve.floor.field.data.local.entities.solutions;

import com.apps.twelve.floor.field.data.local.tables.solutions.ActiveComponentsTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by yarrick on 06.07.17.
 */

@StorIOSQLiteType(table = ActiveComponentsTable.TABLE) public class ActiveComponentEntity {

  @StorIOSQLiteColumn(name = ActiveComponentsTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = ActiveComponentsTable.COLUMN_NAME) String name;
  @StorIOSQLiteColumn(name = ActiveComponentsTable.COLUMN_TECHNOLOGICAL_SOLUTION_TYPE_ID) Long
      solutionTypeId;

  public ActiveComponentEntity() {
  }

  public ActiveComponentEntity(Long id, String name, Long solutionTypeId) {
    this.id = id;
    this.name = name;
    this.solutionTypeId = solutionTypeId;
  }

  public static ActiveComponentEntity newActiveComponentEntity(Long id, String name,
      Long solutionTypeId) {
    if (id == 0) id = null;
    return new ActiveComponentEntity(id, name, solutionTypeId);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    InsectEntity that = (InsectEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;

    return solutionTypeId != null ? solutionTypeId.equals(that.price) : that.price == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (solutionTypeId != null ? solutionTypeId.hashCode() : 0);
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

  public Long getSolutionTypeId() {
    return solutionTypeId;
  }

  public void setSolutionTypeId(Long solutionTypeId) {
    this.solutionTypeId = solutionTypeId;
  }
}
