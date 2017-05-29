package com.apps.twelve.floor.field.data.local.objects;

import android.os.Parcel;
import android.os.Parcelable;
import com.apps.twelve.floor.field.utils.LatLngStringUtil;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav on 12.05.2017.
 */

public class ClimateZoneObject implements Parcelable {

  private long mId;
  private String mName;
  private List<LatLng> mPoints;

  public ClimateZoneObject(long id, String name, List<LatLng> points) {
    this.mId = id;
    this.mName = name;
    this.mPoints = points;
  }

  public ClimateZoneObject(long id, String name, String coordinates) {
    this(id, name, new ArrayList<LatLng>());
    mPoints.clear();
    mPoints.addAll(LatLngStringUtil.LatLngsFromString(coordinates));
  }

  protected ClimateZoneObject(Parcel in) {
    mId = in.readLong();
    mName = in.readString();
    mPoints = in.createTypedArrayList(LatLng.CREATOR);
  }

  public static final Creator<ClimateZoneObject> CREATOR = new Creator<ClimateZoneObject>() {
    @Override public ClimateZoneObject createFromParcel(Parcel in) {
      return new ClimateZoneObject(in);
    }

    @Override public ClimateZoneObject[] newArray(int size) {
      return new ClimateZoneObject[size];
    }
  };

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeString(mName);
    dest.writeTypedList(mPoints);
  }

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

  public void setName(String name) {
    this.mName = name;
  }

  public List<LatLng> getPoints() {
    return mPoints;
  }

  public void setPoints(List<LatLng> points) {
    this.mPoints = points;
  }

  public String getPointsAsCoordinatesString() {
    return LatLngStringUtil.stringFromLatLngs(mPoints);
  }
}
