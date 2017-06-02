package com.apps.twelve.floor.field.data.local.entities.solutions;

import com.apps.twelve.floor.field.data.local.tables.solutions.TechnologicalSolutionTypesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 02.06.2017.
 */

@StorIOSQLiteType(table = TechnologicalSolutionTypesTable.TABLE)
public class TechnologicalSolutionTypeEntity {

  @StorIOSQLiteColumn(name = TechnologicalSolutionTypesTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = TechnologicalSolutionTypesTable.COLUMN_NAME) String name;

  public TechnologicalSolutionTypeEntity() {
  }

  public TechnologicalSolutionTypeEntity(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public static TechnologicalSolutionTypeEntity newTechnologicalSolutionTypeEntity(Long id,
      String name) {
    if (id == 0) id = null;
    return new TechnologicalSolutionTypeEntity(id, name);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    TechnologicalSolutionTypeEntity that = (TechnologicalSolutionTypeEntity) obj;

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
