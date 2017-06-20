package com.apps.twelve.floor.field.data.local.entities.conditions;

import com.apps.twelve.floor.field.data.local.tables.conditions.PestsTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 10.05.2017.
 */

@StorIOSQLiteType(table = PestsTable.TABLE) public class PestEntity {

  @StorIOSQLiteColumn(name = PestsTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = PestsTable.COLUMN_NAME) String name;
  @StorIOSQLiteColumn(name = PestsTable.COLUMN_PARENT_ID) Long parentId;
  @StorIOSQLiteColumn(name = PestsTable.COLUMN_IS_GROUP) boolean isGroup;

  public PestEntity() {
  }

  public PestEntity(Long id, String name, Long parentId, boolean isGroup) {
    this.id = id;
    this.name = name;
    this.parentId = parentId;
    this.isGroup = isGroup;
  }

  public static PestEntity newPestEntity(Long id, String name, Long parentId, boolean isGroup) {
    if (id == 0) id = null;
    return new PestEntity(id, name, parentId, isGroup);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    PestEntity that = (PestEntity) obj;

    if (isGroup != that.isGroup) return false;
    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) return false;

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
