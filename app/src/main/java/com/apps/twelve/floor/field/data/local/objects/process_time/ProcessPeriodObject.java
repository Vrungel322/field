package com.apps.twelve.floor.field.data.local.objects.process_time;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;

/**
 * Created by Yaroslav on 23.05.2017.
 */

public class ProcessPeriodObject implements Parcelable {

  public static final Creator<ProcessPeriodObject> CREATOR = new Creator<ProcessPeriodObject>() {
    @Override public ProcessPeriodObject createFromParcel(Parcel in) {
      return new ProcessPeriodObject(in);
    }

    @Override public ProcessPeriodObject[] newArray(int size) {
      return new ProcessPeriodObject[size];
    }
  };

  private long mId;
  private long mDateFrom;
  private long mDateTo;

  public ProcessPeriodObject(long id, long dateFrom, long dateTo) {
    this.mId = id;
    this.mDateFrom = dateFrom;
    this.mDateTo = dateTo;
  }

  protected ProcessPeriodObject(Parcel in) {
    this.mId = in.readLong();
    this.mDateFrom = in.readLong();
    this.mDateTo = in.readLong();
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeLong(mDateFrom);
    dest.writeLong(mDateTo);
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
