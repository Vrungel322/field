package com.apps.twelve.floor.field.data.local.entities.harmful_objects;

import com.apps.twelve.floor.field.data.local.tables.harmful_objects.PestClassesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by yarrick on 10.07.17.
 */

@StorIOSQLiteType(table = PestClassesTable.TABLE) public class PestClassEntity {

  @StorIOSQLiteColumn(name = PestClassesTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = PestClassesTable.COLUMN_NAME) String name;

  public PestClassEntity() {
  }

  public PestClassEntity(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public static PestClassEntity newPestClassEntity(Long id, String name) {
    if (id == 0) id = null;
    return new PestClassEntity(id, name);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    PestClassEntity that = (PestClassEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;

    return name != null ? name.equals(that.name) : that.name == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
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
}
