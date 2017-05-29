package com.apps.twelve.floor.field.data.local.entities;

import com.apps.twelve.floor.field.data.local.tables.CropTechnologicalProcessesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 11.05.2017.
 */

@StorIOSQLiteType(table = CropTechnologicalProcessesTable.TABLE)
public class CropTechnologicalProcessesEntity {

  @StorIOSQLiteColumn(name = CropTechnologicalProcessesTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = CropTechnologicalProcessesTable.COLUMN_NAME) String name;
  @StorIOSQLiteColumn(name = CropTechnologicalProcessesTable.COLUMN_ORDER) int order;
  @StorIOSQLiteColumn(name = CropTechnologicalProcessesTable.COLUMN_CROP_ID) Long cropId;
  @StorIOSQLiteColumn(name = CropTechnologicalProcessesTable.COLUMN_TECH_PROC_TIME_ID) Long
      techProcessTimeId;

  public CropTechnologicalProcessesEntity() {
  }

  private CropTechnologicalProcessesEntity(Long id, String name, int order, Long cropId,
      Long techProcTimeId) {
    this.id = id;
    this.name = name;
    this.order = order;
    this.cropId = cropId;
    this.techProcessTimeId = techProcTimeId;
  }

  public static CropTechnologicalProcessesEntity newCropTechnologicalProcessesModel(Long id,
      String name, int order, Long cropId, Long techProcTimeId) {
    if (id == 0) id = null;
    return new CropTechnologicalProcessesEntity(id, name, order, cropId, techProcTimeId);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    CropTechnologicalProcessesEntity that = (CropTechnologicalProcessesEntity) obj;

    if (order != that.order) return false;
    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    if (cropId != null ? !cropId.equals(that.cropId) : that.cropId != null) return false;

    return techProcessTimeId != null ? techProcessTimeId.equals(that.techProcessTimeId)
        : that.techProcessTimeId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + order;
    result = 31 * result + (cropId != null ? cropId.hashCode() : 0);
    result = 31 * result + (techProcessTimeId != null ? techProcessTimeId.hashCode() : 0);

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

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public Long getCropId() {
    return cropId;
  }

  public void setCropId(Long cropId) {
    this.cropId = cropId;
  }

  public Long getTechProcessTimeId() {
    return techProcessTimeId;
  }

  public void setTechProcessTimeId(Long techProcessTimeId) {
    this.techProcessTimeId = techProcessTimeId;
  }
}
