package com.apps.twelve.floor.field.data.local.entities;

import com.apps.twelve.floor.field.data.local.tables.CropsTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 05.05.2017.
 */

@StorIOSQLiteType(table = CropsTable.TABLE) public class CropEntity {

  @StorIOSQLiteColumn(name = CropsTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = CropsTable.COLUMN_NAME) String name;
  @StorIOSQLiteColumn(name = CropsTable.COLUMN_PARENT_ID) Long parentId;
  @StorIOSQLiteColumn(name = CropsTable.COLUMN_IS_PARENT) boolean isParent;
  @StorIOSQLiteColumn(name = CropsTable.COLUMN_IS_SUPPORTED) boolean isSupported;

  public CropEntity() {
  }

  private CropEntity(Long id, String name, Long parentId, boolean isParent, boolean isSupported) {
    this.id = id;
    this.name = name;
    this.parentId = parentId;
    this.isParent = isParent;
    this.isSupported = isSupported;
  }

  public static CropEntity newCropEntity(Long id, String name, Long parentId, boolean isParent,
      boolean isSupported) {
    if (id == 0) id = null;
    return new CropEntity(id, name, parentId, isParent, isSupported);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    CropEntity that = (CropEntity) obj;

    if (isParent != that.isParent) return false;
    if (isSupported != that.isSupported) return false;
    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;

    return parentId != null ? parentId.equals(that.parentId) : that.parentId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
    result = 31 * result + (isParent ? 1 : 0);
    result = 31 * result + (isSupported ? 1 : 0);

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

  public boolean isSupported() {
    return isSupported;
  }

  public void setSupported(boolean supported) {
    isSupported = supported;
  }
}
