package com.apps.twelve.floor.field.data.local.entities;

import com.apps.twelve.floor.field.data.local.tables.DealersTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 01.06.2017.
 */

@StorIOSQLiteType(table = DealersTable.TABLE) public class DealerEntity {

  @StorIOSQLiteColumn(name = DealersTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = DealersTable.COLUMN_NAME) String name;

  public DealerEntity() {
  }

  public DealerEntity(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public static DealerEntity newDealerEntity(Long id, String name) {
    if (id == 0) id = null;
    return new DealerEntity(id, name);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    DealerEntity that = (DealerEntity) obj;

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
