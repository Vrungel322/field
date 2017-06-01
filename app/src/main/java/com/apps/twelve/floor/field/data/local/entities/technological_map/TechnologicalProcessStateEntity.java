package com.apps.twelve.floor.field.data.local.entities.technological_map;

import com.apps.twelve.floor.field.data.local.tables.technological_map.TechnologicalProcessStatesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 01.06.2017.
 */

@StorIOSQLiteType(table = TechnologicalProcessStatesTable.TABLE)
public class TechnologicalProcessStateEntity {

  @StorIOSQLiteColumn(name = TechnologicalProcessStatesTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = TechnologicalProcessStatesTable.COLUMN_NAME) String name;
  @StorIOSQLiteColumn(name = TechnologicalProcessStatesTable.COLUMN_IMAGE_RESOURCE_ID) Integer
      imageResourceId;

  public TechnologicalProcessStateEntity() {
  }

  public TechnologicalProcessStateEntity(Long id, String name, Integer imageResourceId) {
    this.id = id;
    this.name = name;
    this.imageResourceId = imageResourceId;
  }

  public static TechnologicalProcessStateEntity newTechnologicalProcessStateEntity(Long id,
      String name, Integer imageResourceId) {
    if (id == 0) id = null;
    return new TechnologicalProcessStateEntity(id, name, imageResourceId);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    TechnologicalProcessStateEntity that = (TechnologicalProcessStateEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;

    return imageResourceId != null ? imageResourceId.equals(that.imageResourceId)
        : that.imageResourceId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (imageResourceId != null ? imageResourceId.hashCode() : 0);
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

  public Integer getImageResourceId() {
    return imageResourceId;
  }

  public void setImageResourceId(Integer imageResourceId) {
    this.imageResourceId = imageResourceId;
  }
}
