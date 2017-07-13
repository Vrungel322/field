package com.apps.twelve.floor.field.data.local.entities.solutions;

import com.apps.twelve.floor.field.data.local.tables.solutions.FieldTechnologicalProcessSolutionsTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 02.06.2017.
 */

@StorIOSQLiteType(table = FieldTechnologicalProcessSolutionsTable.TABLE)
public class FieldTechnologicalProcessSolutionEntity {

  @StorIOSQLiteColumn(name = FieldTechnologicalProcessSolutionsTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = FieldTechnologicalProcessSolutionsTable.COLUMN_FIELD_TECH_PROCESS_ID)
  Long fieldTechProcessId;
  @StorIOSQLiteColumn(name = FieldTechnologicalProcessSolutionsTable.COLUMN_SOLUTION_ID) Long
      solutionId;

  public FieldTechnologicalProcessSolutionEntity() {
  }

  public FieldTechnologicalProcessSolutionEntity(Long id, Long fieldTechProcessId,
      Long solutionId) {
    this.id = id;
    this.fieldTechProcessId = fieldTechProcessId;
    this.solutionId = solutionId;
  }

  public static FieldTechnologicalProcessSolutionEntity newFieldTechnologicalProcessSolutionEntity(
      Long id, Long filedTechProcessId, Long solutionId) {
    if (id == 0) id = null;
    return new FieldTechnologicalProcessSolutionEntity(id, filedTechProcessId, solutionId);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    FieldTechnologicalProcessSolutionEntity that = (FieldTechnologicalProcessSolutionEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (fieldTechProcessId != null ? !fieldTechProcessId.equals(that.fieldTechProcessId)
        : that.fieldTechProcessId != null) {
      return false;
    }

    return solutionId != null ? solutionId.equals(that.solutionId) : that.solutionId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (fieldTechProcessId != null ? fieldTechProcessId.hashCode() : 0);
    result = 31 * result + (solutionId != null ? solutionId.hashCode() : 0);
    return result;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getFieldTechProcessId() {
    return fieldTechProcessId;
  }

  public void setFieldTechProcessId(Long fieldTechProcessId) {
    this.fieldTechProcessId = fieldTechProcessId;
  }

  public Long getSolutionId() {
    return solutionId;
  }

  public void setSolutionId(Long solutionId) {
    this.solutionId = solutionId;
  }
}
