package com.apps.twelve.floor.field.data.local.objects.process_time;

import android.os.Parcel;
import android.os.Parcelable;
import com.apps.twelve.floor.field.data.local.objects.IObject;

/**
 * Created by Yaroslav on 23.05.2017.
 */

public class ProcessPeriodObject implements IObject, Parcelable {
  private long mId;
  private long mDateDayFrom;
  private long mDateDayTo;
  private long mDateMonthFrom;
  private long mDateMonthTo;

  public ProcessPeriodObject(long id, long dateDayFrom, long dateDayTo, long dateMonthFrom,
      long dateMonthTo) {
    mId = id;
    mDateDayFrom = dateDayFrom;
    mDateDayTo = dateDayTo;
    mDateMonthFrom = dateMonthFrom;
    mDateMonthTo = dateMonthTo;
  }

  protected ProcessPeriodObject(Parcel in) {
    mId = in.readLong();
    mDateDayFrom = in.readLong();
    mDateDayTo = in.readLong();
    mDateMonthFrom = in.readLong();
    mDateMonthTo = in.readLong();
  }

  public long getId() {
    return mId;
  }

  public void setId(long id) {
    mId = id;
  }

  public long getDateDayFrom() {
    return mDateDayFrom;
  }

  public void setDateDayFrom(long dateDayFrom) {
    mDateDayFrom = dateDayFrom;
  }

  public long getDateDayTo() {
    return mDateDayTo;
  }

  public void setDateDayTo(long dateDayTo) {
    mDateDayTo = dateDayTo;
  }

  public long getDateMonthFrom() {
    return mDateMonthFrom;
  }

  public void setDateMonthFrom(long dateMonthFrom) {
    mDateMonthFrom = dateMonthFrom;
  }

  public long getDateMonthTo() {
    return mDateMonthTo;
  }

  public void setDateMonthTo(long dateMonthTo) {
    mDateMonthTo = dateMonthTo;
  }

  public static Creator<ProcessPeriodObject> getCREATOR() {
    return CREATOR;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeLong(mDateDayFrom);
    dest.writeLong(mDateDayTo);
    dest.writeLong(mDateMonthFrom);
    dest.writeLong(mDateMonthTo);
  }

  @Override public int describeContents() {
    return 0;
  }

  public static final Creator<ProcessPeriodObject> CREATOR = new Creator<ProcessPeriodObject>() {
    @Override public ProcessPeriodObject createFromParcel(Parcel in) {
      return new ProcessPeriodObject(in);
    }

    @Override public ProcessPeriodObject[] newArray(int size) {
      return new ProcessPeriodObject[size];
    }
  };
}
