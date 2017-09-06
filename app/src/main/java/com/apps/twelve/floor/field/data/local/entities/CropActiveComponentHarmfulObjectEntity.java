package com.apps.twelve.floor.field.data.local.entities;

import com.apps.twelve.floor.field.data.local.tables.CropsActiveComponentsHarmfulObjectsTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 02.06.2017.
 */

@StorIOSQLiteType(table = CropsActiveComponentsHarmfulObjectsTable.TABLE)
public class CropActiveComponentHarmfulObjectEntity implements IEntity {

  @StorIOSQLiteColumn(name = CropsActiveComponentsHarmfulObjectsTable.COLUMN_ID, key = true) Long
      id;
  @StorIOSQLiteColumn(name = CropsActiveComponentsHarmfulObjectsTable.COLUMN_CROP_ID) Long cropId;
  @StorIOSQLiteColumn(name = CropsActiveComponentsHarmfulObjectsTable.COLUMN_ACTIVE_COMPONENT_ID)
  Long activeComponentId;
  @StorIOSQLiteColumn(name = CropsActiveComponentsHarmfulObjectsTable.COLUMN_HARMFUL_OBJECT_ID) Long
      harmfulObjectId;

  public CropActiveComponentHarmfulObjectEntity() {
  }

  public CropActiveComponentHarmfulObjectEntity(Long id, Long cropId, Long activeComponentId,
      Long harmfulObjectId) {
    this.id = id;
    this.cropId = cropId;
    this.activeComponentId = activeComponentId;
    this.harmfulObjectId = harmfulObjectId;
  }

  public static CropActiveComponentHarmfulObjectEntity newCropActiveComponentHarmfulObjectEntity(
      Long id, Long cropId, Long activeComponentId, Long harmfulObjectId) {
    if (id == 0) id = null;
    return new CropActiveComponentHarmfulObjectEntity(id, cropId, activeComponentId,
        harmfulObjectId);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    CropActiveComponentHarmfulObjectEntity that = (CropActiveComponentHarmfulObjectEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (cropId != null ? !cropId.equals(that.cropId) : that.cropId != null) {
      return false;
    }
    if (activeComponentId != null ? !activeComponentId.equals(that.activeComponentId)
        : that.activeComponentId != null) {
      return false;
    }
    return harmfulObjectId != null ? harmfulObjectId.equals(that.harmfulObjectId)
        : that.harmfulObjectId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (cropId != null ? cropId.hashCode() : 0);
    result = 31 * result + (activeComponentId != null ? activeComponentId.hashCode() : 0);
    result = 31 * result + (harmfulObjectId != null ? harmfulObjectId.hashCode() : 0);
    return result;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCropId() {
    return cropId;
  }

  public void setCropId(Long cropId) {
    this.cropId = cropId;
  }

  public Long getActiveComponentId() {
    return activeComponentId;
  }

  public void setActiveComponentId(Long activeComponentId) {
    this.activeComponentId = activeComponentId;
  }

  public Long getHarmfulObjectId() {
    return harmfulObjectId;
  }

  public void setHarmfulObjectId(Long harmfulObjectId) {
    this.harmfulObjectId = harmfulObjectId;
  }
}
