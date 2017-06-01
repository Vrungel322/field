package com.apps.twelve.floor.field.data.local.entities.process_time;

import com.apps.twelve.floor.field.data.local.tables.process_time.ProcessPeriodsTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 01.06.2017.
 */

@StorIOSQLiteType(table = ProcessPeriodsTable.TABLE) public class ProcessPeriodEntity {

  @StorIOSQLiteColumn(name = ProcessPeriodsTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = ProcessPeriodsTable.COLUMN_DATE_FROM, key = true) Long dateFrom;
  @StorIOSQLiteColumn(name = ProcessPeriodsTable.COLUMN_DATE_TO, key = true) Long dateTo;

  public ProcessPeriodEntity() {
  }

  public ProcessPeriodEntity(Long id, Long dateFrom, Long dateTo) {
    this.id = id;
    this.dateFrom = dateFrom;
    this.dateTo = dateTo;
  }

  public static ProcessPeriodEntity newProcessPeriodEntity(Long id, Long dateFrom, Long dateTo) {
    if (id == 0) id = null;
    return new ProcessPeriodEntity(id, dateFrom, dateTo);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    ProcessPeriodEntity that = (ProcessPeriodEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (dateFrom != null ? !dateFrom.equals(that.dateFrom) : that.dateFrom != null) return false;

    return dateTo != null ? dateTo.equals(that.dateTo) : that.dateTo == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (dateFrom != null ? dateFrom.hashCode() : 0);
    result = 31 * result + (dateTo != null ? dateTo.hashCode() : 0);
    return result;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getDateFrom() {
    return dateFrom;
  }

  public void setDateFrom(Long dateFrom) {
    this.dateFrom = dateFrom;
  }

  public Long getDateTo() {
    return dateTo;
  }

  public void setDateTo(Long dateTo) {
    this.dateTo = dateTo;
  }
}
