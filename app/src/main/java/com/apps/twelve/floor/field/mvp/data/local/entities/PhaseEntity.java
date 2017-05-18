package com.apps.twelve.floor.field.mvp.data.local.entities;

import com.apps.twelve.floor.field.mvp.data.local.tables.PhasesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 05.05.2017.
 */

@StorIOSQLiteType(table = PhasesTable.TABLE) public class PhaseEntity {

  @StorIOSQLiteColumn(name = PhasesTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = PhasesTable.COLUMN_NAME) String name;
  @StorIOSQLiteColumn(name = PhasesTable.COLUMN_CROP_ID) Long cropId;

  public PhaseEntity() {
  }

  private PhaseEntity(Long id, String name, Long cropId) {
    this.id = id;
    this.name = name;
    this.cropId = cropId;
  }

  public static PhaseEntity newPhaseModel(Long id, String name, Long cropId) {
    if (id == 0) id = null;
    return new PhaseEntity(id, name, cropId);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    PhaseEntity that = (PhaseEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;

    return cropId != null ? cropId.equals(that.cropId) : that.cropId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (cropId != null ? cropId.hashCode() : 0);

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

  public Long getCropId() {
    return cropId;
  }

  public void setCropId(Long cropId) {
    this.cropId = cropId;
  }
}
