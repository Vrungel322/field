package com.apps.twelve.floor.field.data.local.entities.harmful_objects;

import com.apps.twelve.floor.field.data.local.entities.IEntity;
import com.apps.twelve.floor.field.data.local.tables.harmful_objects.DiseasePathogenTypesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by yarrick on 05.09.17.
 */

@StorIOSQLiteType(table = DiseasePathogenTypesTable.TABLE) public class DiseasePathogenTypeEntity
    implements IEntity {

  @StorIOSQLiteColumn(name = DiseasePathogenTypesTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = DiseasePathogenTypesTable.COLUMN_NAME) String name;

  public DiseasePathogenTypeEntity() {
  }

  public DiseasePathogenTypeEntity(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public static DiseasePathogenTypeEntity newDiseasePathogenTypeEntity(Long id, String name) {
    return new DiseasePathogenTypeEntity(id, name);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    DiseasePathogenTypeEntity that = (DiseasePathogenTypeEntity) obj;

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
