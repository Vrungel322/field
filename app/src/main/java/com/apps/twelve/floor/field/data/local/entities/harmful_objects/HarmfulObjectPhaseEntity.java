package com.apps.twelve.floor.field.data.local.entities.harmful_objects;

import com.apps.twelve.floor.field.data.local.tables.harmful_objects.HarmfulObjectPhasesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 02.06.2017.
 */

@StorIOSQLiteType(table = HarmfulObjectPhasesTable.TABLE) public class HarmfulObjectPhaseEntity {

  @StorIOSQLiteColumn(name = HarmfulObjectPhasesTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = HarmfulObjectPhasesTable.COLUMN_NAME_ID) Long nameId;
  @StorIOSQLiteColumn(name = HarmfulObjectPhasesTable.COLUMN_HARMFUL_OBJECT_ID) Long
      harmfulObjectId;

  public HarmfulObjectPhaseEntity() {
  }

  public HarmfulObjectPhaseEntity(Long id, Long nameId, Long harmfulObjectId) {
    this.id = id;
    this.nameId = nameId;
    this.harmfulObjectId = harmfulObjectId;
  }

  public static HarmfulObjectPhaseEntity newHarmfulObjectPhaseEntity(Long id, Long nameId,
      Long harmfulObjectId) {
    if (id == 0) id = null;
    return new HarmfulObjectPhaseEntity(id, nameId, harmfulObjectId);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    HarmfulObjectPhaseEntity that = (HarmfulObjectPhaseEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (nameId != null ? !nameId.equals(that.nameId) : that.nameId != null) return false;

    return harmfulObjectId != null ? harmfulObjectId.equals(that.harmfulObjectId)
        : that.harmfulObjectId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (nameId != null ? nameId.hashCode() : 0);
    result = 31 * result + (harmfulObjectId != null ? harmfulObjectId.hashCode() : 0);
    return result;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getNameId() {
    return nameId;
  }

  public void setNameId(Long nameId) {
    this.nameId = nameId;
  }

  public Long getHarmfulObjectId() {
    return harmfulObjectId;
  }

  public void setHarmfulObjectId(Long harmfulObjectId) {
    this.harmfulObjectId = harmfulObjectId;
  }
}
