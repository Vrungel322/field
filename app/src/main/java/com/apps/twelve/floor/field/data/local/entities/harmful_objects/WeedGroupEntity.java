package com.apps.twelve.floor.field.data.local.entities.harmful_objects;

import com.apps.twelve.floor.field.data.local.tables.harmful_objects.WeedGroupsTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by yarrick on 30.06.17.
 */

@StorIOSQLiteType(table = WeedGroupsTable.TABLE) public class WeedGroupEntity {

  @StorIOSQLiteColumn(name = WeedGroupsTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = WeedGroupsTable.COLUMN_NAME) String name;
  @StorIOSQLiteColumn(name = WeedGroupsTable.COLUMN_PARENT_ID) Long parentId;
  @StorIOSQLiteColumn(name = WeedGroupsTable.COLUMN_IS_GROUP) boolean isGroup;

  public WeedGroupEntity() {
  }

  public WeedGroupEntity(Long id, String name, Long parentId, boolean isGroup) {
    this.id = id;
    this.name = name;
    this.parentId = parentId;
    this.isGroup = isGroup;
  }

  public static WeedGroupEntity newWeedGroupEntity(Long id, String name, Long parentId,
      boolean isGroup) {
    if (id == 0) id = null;
    return new WeedGroupEntity(id, name, parentId, isGroup);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    WeedGroupEntity that = (WeedGroupEntity) obj;

    if (isGroup != that.isGroup) return false;
    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;

    return parentId != null ? parentId.equals(that.parentId) : that.parentId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
    result = 31 * result + (isGroup ? 1 : 0);

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

  public boolean isGroup() {
    return isGroup;
  }

  public void setGroup(boolean group) {
    isGroup = group;
  }
}
