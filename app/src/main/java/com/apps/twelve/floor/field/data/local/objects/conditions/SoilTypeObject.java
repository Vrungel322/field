package com.apps.twelve.floor.field.data.local.objects.conditions;

import android.os.Parcel;
import com.apps.twelve.floor.field.utils.LatLngStringUtil;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

/**
 * Created by Yaroslav on 20.05.2017.
 */

public class SoilTypeObject extends BaseConditionValueObject {

  public static final Creator<SoilTypeObject> CREATOR = new Creator<SoilTypeObject>() {
    @Override public SoilTypeObject createFromParcel(Parcel in) {
      return new SoilTypeObject(in);
    }

    @Override public SoilTypeObject[] newArray(int size) {
      return new SoilTypeObject[size];
    }
  };

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

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(mId);
    dest.writeString(mName);
    dest.writeParcelable(mConditionType, flags);
    dest.writeTypedList(mPoints);
  }

  @Override public long getId() {
    return mId;
  }

  @Override public void setId(long id) {
    this.mId = id;
  }

  @Override public String getName() {
    return mName;
  }

  @Override public void setName(String name) {
    this.mName = name;
  }

  @Override public ConditionTypeObject getType() {
    return mConditionType;
  }

  @Override public void setType(ConditionTypeObject type) {
    this.mConditionType = type;
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
