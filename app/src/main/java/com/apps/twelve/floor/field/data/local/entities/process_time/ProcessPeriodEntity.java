package com.apps.twelve.floor.field.data.local.entities.process_time;

import com.apps.twelve.floor.field.data.local.entities.IEntity;
import com.apps.twelve.floor.field.data.local.tables.process_time.ProcessPeriodsTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 01.06.2017.
 */

@StorIOSQLiteType(table = ProcessPeriodsTable.TABLE) public class ProcessPeriodEntity
    implements IEntity {

  @StorIOSQLiteColumn(name = ProcessPeriodsTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = ProcessPeriodsTable.COLUMN_DATE_DAY_FROM, key = true) Long dateDayFrom;
  @StorIOSQLiteColumn(name = ProcessPeriodsTable.COLUMN_DATE_DAY_TO, key = true) Long dateDayTo;
  @StorIOSQLiteColumn(name = ProcessPeriodsTable.COLUMN_DATE_MONTH_FROM, key = true) Long
      dateMonthFrom;
  @StorIOSQLiteColumn(name = ProcessPeriodsTable.COLUMN_DATE_MONTH_TO, key = true) Long dateMonthTo;

  public ProcessPeriodEntity() {
  }

  public ProcessPeriodEntity(Long id, Long dateDayFrom, Long dateDayTo, Long dateMonthFrom,
      Long dateMonthTo) {
    this.id = id;
    this.dateDayFrom = dateDayFrom;
    this.dateDayTo = dateDayTo;
    this.dateMonthFrom = dateMonthFrom;
    this.dateMonthTo = dateMonthTo;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getDateDayFrom() {
    return dateDayFrom;
  }

  public void setDateDayFrom(Long dateDayFrom) {
    this.dateDayFrom = dateDayFrom;
  }

  public Long getDateDayTo() {
    return dateDayTo;
  }

  public void setDateDayTo(Long dateDayTo) {
    this.dateDayTo = dateDayTo;
  }

  public Long getDateMonthFrom() {
    return dateMonthFrom;
  }

  public void setDateMonthFrom(Long dateMonthFrom) {
    this.dateMonthFrom = dateMonthFrom;
  }

  public Long getDateMonthTo() {
    return dateMonthTo;
  }

  public void setDateMonthTo(Long dateMonthTo) {
    this.dateMonthTo = dateMonthTo;
  }

  public static ProcessPeriodEntity newProcessPeriodEntity(Long id, Long dateDayFrom,
      Long dateDayTo, Long dateMonthFrom, Long dateMonthTo) {
    if (id == 0) id = null;
    return new ProcessPeriodEntity(id, dateDayFrom, dateDayTo, dateMonthFrom, dateMonthTo);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    ProcessPeriodEntity that = (ProcessPeriodEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (dateDayFrom != null ? !dateDayFrom.equals(that.dateDayFrom) : that.dateDayFrom != null) {
      return false;
    }
    if (dateDayTo != null ? !dateDayTo.equals(that.dateDayTo) : that.dateDayTo != null) {
      return false;
    }
    if (dateMonthFrom != null ? !dateMonthFrom.equals(that.dateMonthFrom)
        : that.dateMonthFrom != null) {
      return false;
    }

    return dateMonthTo != null ? dateMonthTo.equals(that.dateMonthTo) : that.dateMonthTo == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (dateDayFrom != null ? dateDayFrom.hashCode() : 0);
    result = 31 * result + (dateDayTo != null ? dateDayTo.hashCode() : 0);
    result = 31 * result + (dateMonthFrom != null ? dateMonthFrom.hashCode() : 0);
    result = 31 * result + (dateMonthTo != null ? dateMonthTo.hashCode() : 0);
    return result;
  }
}
