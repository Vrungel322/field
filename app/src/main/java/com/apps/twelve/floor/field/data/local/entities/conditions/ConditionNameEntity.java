package com.apps.twelve.floor.field.data.local.entities.conditions;

import com.apps.twelve.floor.field.data.local.tables.conditions.ConditionNamesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Vrungel on 05.07.2017.
 */
@StorIOSQLiteType(table = ConditionNamesTable.TABLE)
public class ConditionNameEntity {
  @StorIOSQLiteColumn(name = ConditionNamesTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = ConditionNamesTable.COLUMN_NAME) String name;

  public ConditionNameEntity() {
  }

  public ConditionNameEntity(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public static ConditionNameEntity newConditionNameEntity(Long id, String name) {
    if (id == 0) id = null;
    return new ConditionNameEntity(id, name);
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

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    ConditionNameEntity that = (ConditionNameEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;

    return name != null ? name.equals(that.name) : that.name == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);

    return result;
  }
}
