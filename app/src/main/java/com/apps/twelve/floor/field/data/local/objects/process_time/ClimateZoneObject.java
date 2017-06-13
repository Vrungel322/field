package com.apps.twelve.floor.field.data.local.objects.process_time;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.utils.LatLngStringUtil;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav on 12.05.2017.
 */

public class ClimateZoneObject implements Parcelable, Cloneable {

  public static final ClimateZoneObject EMPTY;

  static {
    EMPTY = new ClimateZoneObject(0, "", "");
  }

  public static final Creator<ClimateZoneObject> CREATOR = new Creator<ClimateZoneObject>() {
    @Override public ClimateZoneObject createFromParcel(Parcel in) {
      return new ClimateZoneObject(in);
    }

    @Override public ClimateZoneObject[] newArray(int size) {
      return new ClimateZoneObject[size];
    }
  };

  private long mId;
  @NonNull private String mName;
  @NonNull private List<LatLng> mPoints = new ArrayList<>();

  public ClimateZoneObject(long id, @NonNull String name, @NonNull List<LatLng> points) {
    this.mId = id;
    this.mName = name;
    this.mPoints = points;
  }

  public ClimateZoneObject(long id, @NonNull String name, @NonNull String coordinates) {
    this(id, name, new ArrayList<>());
    mPoints.clear();
    mPoints.addAll(LatLngStringUtil.LatLngsFromString(coordinates));
  }

  protected ClimateZoneObject(Parcel in) {
    this.mId = in.readLong();
    this.mName = in.readString();
    this.mPoints = in.createTypedArrayList(LatLng.CREATOR);
  }

  public static ClimateZoneObject newInstance() {
    return new ClimateZoneObject(0, "", "");
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeString(mName);
    dest.writeTypedList(mPoints);
  }

  // TODO: don't override this method - change adapter instead
  @Override public String toString() {
    return mName;
  }

  public long getId() {
    return mId;
  }

  public void setId(long id) {
    this.mId = id;
  }

  public String getName() {
    return mName;
  }

  public void setName(@NonNull String name) {
    this.mName = name;
  }

  public List<LatLng> getPoints() {
    return mPoints;
  }

  public void setPoints(@NonNull List<LatLng> points) {
    this.mPoints = points;
  }

  public String getPointsAsCoordinatesString() {
    return LatLngStringUtil.stringFromLatLngs(mPoints);
  }
}
