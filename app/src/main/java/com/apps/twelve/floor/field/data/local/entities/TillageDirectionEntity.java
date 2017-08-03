package com.apps.twelve.floor.field.data.local.entities;

import com.apps.twelve.floor.field.data.local.tables.TillageDirectionsTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 02.06.2017.
 */

@StorIOSQLiteType(table = TillageDirectionsTable.TABLE) public class TillageDirectionEntity
    implements IEntity {

  @StorIOSQLiteColumn(name = TillageDirectionsTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = TillageDirectionsTable.COLUMN_NAME) String name;

  public TillageDirectionEntity() {
  }

  public TillageDirectionEntity(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public static TillageDirectionEntity newTillageDirectionEntity(Long id, String name) {
    if (id == 0) id = null;
    return new TillageDirectionEntity(id, name);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    TillageDirectionEntity that = (TillageDirectionEntity) obj;

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
