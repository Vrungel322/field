package com.apps.twelve.floor.field.data.local.entities.technological_map;

import com.apps.twelve.floor.field.data.local.entities.IEntity;
import com.apps.twelve.floor.field.data.local.tables.technological_map.CropTechnologicalProcessesSequencesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by yarrick on 11.09.17.
 */

@StorIOSQLiteType(table = CropTechnologicalProcessesSequencesTable.TABLE)
public class CropTechnologicalProcessesSequenceEntity implements IEntity {

  @StorIOSQLiteColumn(name = CropTechnologicalProcessesSequencesTable.COLUMN_ID, key = true) Long
      id;
  @StorIOSQLiteColumn(name = CropTechnologicalProcessesSequencesTable.COLUMN_CROP_TECHNOLOGICAL_PROCESS_ID)
  Long cropTechnologicalProcessId;
  @StorIOSQLiteColumn(name = CropTechnologicalProcessesSequencesTable.COLUMN_NEXT_CROP_TECHNOLOGICAL_PROCESS_ID)
  Long nextCropTechnologicalProcessId;

  public CropTechnologicalProcessesSequenceEntity() {
  }

  public CropTechnologicalProcessesSequenceEntity(Long id, Long cropTechnologicalProcessId,
      Long nextCropTechnologicalProcessId) {
    this.id = id;
    this.cropTechnologicalProcessId = cropTechnologicalProcessId;
    this.nextCropTechnologicalProcessId = nextCropTechnologicalProcessId;
  }

  public static CropTechnologicalProcessesSequenceEntity newCropTechnologicalProcessesSequenceEntity(
      Long id, Long cropTechnologicalProcessId, Long nextCropTechnologicalProcessId) {
    if (id == 0) id = null;
    return new CropTechnologicalProcessesSequenceEntity(id, cropTechnologicalProcessId,
        nextCropTechnologicalProcessId);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    CropTechnologicalProcessesSequenceEntity that = (CropTechnologicalProcessesSequenceEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (cropTechnologicalProcessId != null ? !cropTechnologicalProcessId.equals(
        that.cropTechnologicalProcessId) : that.cropTechnologicalProcessId != null) {
      return false;
    }

    return nextCropTechnologicalProcessId != null ? nextCropTechnologicalProcessId.equals(
        that.nextCropTechnologicalProcessId) : that.nextCropTechnologicalProcessId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result =
        31 * result + (cropTechnologicalProcessId != null ? cropTechnologicalProcessId.hashCode()
            : 0);
    result = 31 * result + (nextCropTechnologicalProcessId != null
        ? nextCropTechnologicalProcessId.hashCode() : 0);
    return result;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCropTechnologicalProcessId() {
    return cropTechnologicalProcessId;
  }

  public void setCropTechnologicalProcessId(Long cropTechnologicalProcessId) {
    this.cropTechnologicalProcessId = cropTechnologicalProcessId;
  }

  public Long getNextCropTechnologicalProcessId() {
    return nextCropTechnologicalProcessId;
  }

  public void setNextCropTechnologicalProcessId(Long nextCropTechnologicalProcessId) {
    this.nextCropTechnologicalProcessId = nextCropTechnologicalProcessId;
  }
}
