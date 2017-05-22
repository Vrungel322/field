package com.apps.twelve.floor.field.mvp.data.local.objects;

import android.os.Parcel;
import android.os.Parcelable;
import com.apps.twelve.floor.field.utils.LatLngStringUtil;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

/**
 * Created by Yaroslav on 20.05.2017.
 */

public class SoilTypeObject implements Parcelable {

  private long mId;
  private String mName;
  private ConditionTypeObject mConditionType;
  private List<LatLng> mPoints;

  public SoilTypeObject(long mId, String mName, ConditionTypeObject conditionType,
      List<LatLng> mPoints) {
    this.mId = mId;
    this.mName = mName;
    this.mConditionType = conditionType;
    this.mPoints = mPoints;
  }

  public SoilTypeObject(long mId, String mName, ConditionTypeObject conditionType,
      String coordinates) {
    this.mId = mId;
    this.mName = mName;
    this.mConditionType = conditionType;
    mPoints.addAll(LatLngStringUtil.LatLngsFromString(coordinates));
  }

  protected SoilTypeObject(Parcel in) {
    mId = in.readLong();
    mName = in.readString();
    mConditionType = in.readParcelable(ConditionTypeObject.class.getClassLoader());
    mPoints = in.createTypedArrayList(LatLng.CREATOR);
  }

  public static final Creator<SoilTypeObject> CREATOR = new Creator<SoilTypeObject>() {
    @Override public SoilTypeObject createFromParcel(Parcel in) {
      return new SoilTypeObject(in);
    }

    @Override public SoilTypeObject[] newArray(int size) {
      return new SoilTypeObject[size];
    }
  };

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeString(mName);
    dest.writeParcelable(mConditionType, flags);
    dest.writeTypedList(mPoints);
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

  public ConditionTypeObject getmConditionType() {
    return mConditionType;
  }

  public void setConditionType(ConditionTypeObject conditionType) {
    this.mConditionType = conditionType;
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
