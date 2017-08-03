package com.apps.twelve.floor.field.data.local.entities.conditions;

import com.apps.twelve.floor.field.data.local.entities.IEntity;
import com.apps.twelve.floor.field.data.local.tables.conditions.PreviousCropValuesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by yarrick on 22.07.17.
 */
@StorIOSQLiteType(table = PreviousCropValuesTable.TABLE) public class PreviousCropValueEntity
    implements IEntity {

  @StorIOSQLiteColumn(name = PreviousCropValuesTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = PreviousCropValuesTable.COLUMN_CONDITION_TYPE_ID) Long conditionTypeId;
  @StorIOSQLiteColumn(name = PreviousCropValuesTable.COLUMN_CROP_ID) Long cropId;

  public PreviousCropValueEntity() {
  }

  public PreviousCropValueEntity(Long id, Long conditionTypeId, Long cropId) {
    this.id = id;
    this.conditionTypeId = conditionTypeId;
    this.cropId = cropId;
  }

  public static PreviousCropValueEntity newPreviousCropValueEntity(Long id, Long conditionTypeId,
      Long cropId) {
    return new PreviousCropValueEntity(id, conditionTypeId, cropId);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    PreviousCropValueEntity that = (PreviousCropValueEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (conditionTypeId != null ? !conditionTypeId.equals(that.conditionTypeId)
        : that.conditionTypeId != null) {
      return false;
    }

    return cropId != null ? cropId.equals(that.cropId) : that.cropId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (conditionTypeId != null ? conditionTypeId.hashCode() : 0);
    result = 31 * result + (cropId != null ? cropId.hashCode() : 0);
    return result;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getConditionTypeId() {
    return conditionTypeId;
  }

  public void setConditionTypeId(Long conditionTypeId) {
    this.conditionTypeId = conditionTypeId;
  }

  public Long getCropId() {
    return cropId;
  }

  public void setCropId(Long cropId) {
    this.cropId = cropId;
  }
}
