package com.apps.twelve.floor.field.data.local.entities.harmful_objects;

import com.apps.twelve.floor.field.data.local.entities.IEntity;
import com.apps.twelve.floor.field.data.local.tables.harmful_objects.DiseasesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by yarrick on 05.09.17.
 */

@StorIOSQLiteType(table = DiseasesTable.TABLE) public class DiseaseEntity implements IEntity {

  @StorIOSQLiteColumn(name = DiseasesTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = DiseasesTable.COLUMN_NAME) String name;
  @StorIOSQLiteColumn(name = DiseasesTable.COLUMN_HARMFUL_OBJ_TYPE_ID) Long harmfulObjTypeId;
  @StorIOSQLiteColumn(name = DiseasesTable.COLUMN_PATHOGEN_TYPE_ID) Long pathogenTypeId;

  public DiseaseEntity() {
  }

  public DiseaseEntity(Long id, String name, Long harmfulObjTypeId, Long pathogenTypeId) {
    this.id = id;
    this.name = name;
    this.harmfulObjTypeId = harmfulObjTypeId;
    this.pathogenTypeId = pathogenTypeId;
  }

  public static DiseaseEntity newDiseaseEntity(Long id, String name, Long harmfulObjTypeId,
      Long pathogenTypeId) {
    return new DiseaseEntity(id, name, harmfulObjTypeId, pathogenTypeId);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    DiseaseEntity that = (DiseaseEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (harmfulObjTypeId != null ? !harmfulObjTypeId.equals(that.harmfulObjTypeId)
        : that.harmfulObjTypeId != null) {
      return false;
    }
    if (name != null ? !name.equals(that.name) : that.name != null) return false;

    return pathogenTypeId != null ? pathogenTypeId.equals(that.pathogenTypeId)
        : that.pathogenTypeId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (harmfulObjTypeId != null ? harmfulObjTypeId.hashCode() : 0);
    result = 31 * result + (pathogenTypeId != null ? pathogenTypeId.hashCode() : 0);

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

  public Long getHarmfulObjTypeId() {
    return harmfulObjTypeId;
  }

  public void setHarmfulObjTypeId(Long harmfulObjTypeId) {
    this.harmfulObjTypeId = harmfulObjTypeId;
  }

  public Long getPathogenTypeId() {
    return pathogenTypeId;
  }

  public void setPathogenTypeId(Long pathogenTypeId) {
    this.pathogenTypeId = pathogenTypeId;
  }
}
