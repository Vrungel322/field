package com.apps.twelve.floor.field.data.local.entities.technological_map;

import com.apps.twelve.floor.field.data.local.entities.IEntity;
import com.apps.twelve.floor.field.data.local.tables.technological_map.FieldCropTechnologicalProcessesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 01.06.2017.
 */

@StorIOSQLiteType(table = FieldCropTechnologicalProcessesTable.TABLE)
public class FieldCropTechnologicalProcessEntity implements IEntity {

  @StorIOSQLiteColumn(name = FieldCropTechnologicalProcessesTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = FieldCropTechnologicalProcessesTable.COLUMN_FIELD_ID) Long fieldId;
  @StorIOSQLiteColumn(name = FieldCropTechnologicalProcessesTable.COLUMN_CROP_TECH_PROCESS_ID) Long
      cropTechnologicalProcessId;
  @StorIOSQLiteColumn(name = FieldCropTechnologicalProcessesTable.COLUMN_TECH_PROCESS_STATE_ID) Long
      technologicalProcessStateId;

  public FieldCropTechnologicalProcessEntity() {
  }

  public FieldCropTechnologicalProcessEntity(Long id, Long fieldId, Long cropTechnologicalProcessId,
      Long technologicalProcessStateId) {
    this.id = id;
    this.fieldId = fieldId;
    this.cropTechnologicalProcessId = cropTechnologicalProcessId;
    this.technologicalProcessStateId = technologicalProcessStateId;
  }

  public static FieldCropTechnologicalProcessEntity newFieldCropTechnologicalProcessEntity(Long id,
      Long fieldId, Long cropTechnologicalProcessId, Long technologicalProcessStateId) {
    if (id == 0) id = null;
    return new FieldCropTechnologicalProcessEntity(id, fieldId, cropTechnologicalProcessId,
        technologicalProcessStateId);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    FieldCropTechnologicalProcessEntity that = (FieldCropTechnologicalProcessEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (fieldId != null ? !fieldId.equals(that.fieldId) : that.fieldId != null) return false;
    if (cropTechnologicalProcessId != null ? !cropTechnologicalProcessId.equals(
        that.cropTechnologicalProcessId) : that.cropTechnologicalProcessId != null) {
      return false;
    }

    return technologicalProcessStateId != null ? technologicalProcessStateId.equals(
        that.technologicalProcessStateId) : that.technologicalProcessStateId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (fieldId != null ? fieldId.hashCode() : 0);
    result =
        31 * result + (cropTechnologicalProcessId != null ? cropTechnologicalProcessId.hashCode()
            : 0);
    result =
        31 * result + (technologicalProcessStateId != null ? technologicalProcessStateId.hashCode()
            : 0);
    return result;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getFieldId() {
    return fieldId;
  }

  public void setFieldId(Long fieldId) {
    this.fieldId = fieldId;
  }

  public Long getCropTechnologicalProcessId() {
    return cropTechnologicalProcessId;
  }

  public void setCropTechnologicalProcessId(Long cropTechnologicalProcessId) {
    this.cropTechnologicalProcessId = cropTechnologicalProcessId;
  }

  public Long getTechnologicalProcessStateId() {
    return technologicalProcessStateId;
  }

  public void setTechnologicalProcessStateId(Long technologicalProcessStateId) {
    this.technologicalProcessStateId = technologicalProcessStateId;
  }
}
