package com.apps.twelve.floor.field.data.local.objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.utils.LatLngStringUtil;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav on 20.05.2017.
 */

public class SoilTypeObject implements IObject, Parcelable {

  public static final SoilTypeObject EMPTY;
  public static final Creator<SoilTypeObject> CREATOR = new Creator<SoilTypeObject>() {
    @Override public SoilTypeObject createFromParcel(Parcel in) {
      return new SoilTypeObject(in);
    }

    @Override public SoilTypeObject[] newArray(int size) {
      return new SoilTypeObject[size];
    }
  };

  static {
    EMPTY = new SoilTypeObject(0, "", "");
  }

  private long mId;
  @NonNull private String mName;
  @NonNull private List<LatLng> mPoints = new ArrayList<>();

  public SoilTypeObject(long id, @NonNull String name, @NonNull List<LatLng> points) {
    this.mId = id;
    this.mName = name;
    this.mPoints = points;
  }

  public SoilTypeObject(long id, @NonNull String name, @NonNull String coordinates) {
    this.mId = id;
    this.mName = name;
    mPoints.addAll(LatLngStringUtil.LatLngsFromString(coordinates));
  }

  protected SoilTypeObject(Parcel in) {
    this.mId = in.readLong();
    this.mName = in.readString();
    this.mPoints = in.createTypedArrayList(LatLng.CREATOR);
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
