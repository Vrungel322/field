package com.apps.twelve.floor.field.data.local.entities.harmful_objects;

import com.apps.twelve.floor.field.data.local.tables.harmful_objects.HarmfulObjectPhasesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 02.06.2017.
 *
 */

@StorIOSQLiteType(table = HarmfulObjectPhasesTable.TABLE) public class HarmfulObjectPhaseEntity {

  @StorIOSQLiteColumn(name = HarmfulObjectPhasesTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = HarmfulObjectPhasesTable.COLUMN_NAME) String name;

  public HarmfulObjectPhaseEntity() {
  }

  public HarmfulObjectPhaseEntity(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public static HarmfulObjectPhaseEntity newHarmfulObjectPhaseEntity(Long id, String name) {
    if (id == 0) id = null;
    return new HarmfulObjectPhaseEntity(id, name);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    HarmfulObjectPhaseEntity that = (HarmfulObjectPhaseEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;

    return name != null ? name.equals(that.name) : that.name == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
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
}
