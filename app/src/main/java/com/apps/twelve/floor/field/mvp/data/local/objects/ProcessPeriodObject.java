package com.apps.twelve.floor.field.mvp.data.local.objects;

import android.content.Context;
import android.text.format.DateUtils;

/**
 * Created by Yaroslav on 23.05.2017.
 */

// TODO: make it Parcelable
public class ProcessPeriodObject {

  private long mId;
  private long mDateFrom;
  private long mDateTo;

  public ProcessPeriodObject(long id, long dateFrom, long dateTo) {
    this.mId = id;
    this.mDateFrom = dateFrom;
    this.mDateTo = dateTo;
  }

  public long getId() {
    return mId;
  }

  public void setId(long id) {
    this.mId = id;
  }

  public long getDateFrom() {
    return mDateFrom;
  }

  public void setDateFrom(long dateFrom) {
    this.mDateFrom = dateFrom;
  }

  public long getDateTo() {
    return mDateTo;
  }

  public void setDateTo(long dateTo) {
    this.mDateTo = dateTo;
  }

  public String getRepresentation(Context context) {
    return DateUtils.formatDateRange(context, mDateFrom, mDateTo, DateUtils.FORMAT_SHOW_DATE);
  }
}
