package com.apps.twelve.floor.field.data.local.entities.harmful_objects;

import com.apps.twelve.floor.field.data.local.tables.harmful_objects.WeedClassesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by yarrick on 30.06.17.
 */

@StorIOSQLiteType(table = WeedClassesTable.TABLE) public class WeedClassEntity {

  @StorIOSQLiteColumn(name = WeedClassesTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = WeedClassesTable.COLUMN_NAME) String name;
  @StorIOSQLiteColumn(name = WeedClassesTable.COLUMN_PARENT_ID) Long parentId;
  @StorIOSQLiteColumn(name = WeedClassesTable.COLUMN_IS_PARENT) boolean isParent;

  public WeedClassEntity() {
  }

  public WeedClassEntity(Long id, String name, Long parentId, boolean isParent) {
    this.id = id;
    this.name = name;
    this.parentId = parentId;
    this.isParent = isParent;
  }

  public static WeedClassEntity newWeedClassEntity(Long id, String name, Long parentId,
      boolean isParent) {
    if (id == 0) id = null;
    return new WeedClassEntity(id, name, parentId, isParent);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    WeedClassEntity that = (WeedClassEntity) obj;

    if (isParent != that.isParent) return false;
    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;

    return parentId != null ? parentId.equals(that.parentId) : that.parentId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
    result = 31 * result + (isParent ? 1 : 0);

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

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  public boolean isParent() {
    return isParent;
  }

  public void setIsParent(boolean isParent) {
    this.isParent = isParent;
  }
}
