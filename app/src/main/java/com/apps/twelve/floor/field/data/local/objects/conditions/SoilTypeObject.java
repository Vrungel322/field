package com.apps.twelve.floor.field.data.local.objects.conditions;

import android.os.Parcel;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.utils.LatLngStringUtil;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav on 20.05.2017.
 */

public class SoilTypeObject extends BaseConditionValueObject {

  public static final SoilTypeObject EMPTY;

  static {
    EMPTY = new SoilTypeObject(0, "", new ConditionTypeObject(1, "Тип почвы"), "");
  }

  public static final Creator<SoilTypeObject> CREATOR = new Creator<SoilTypeObject>() {
    @Override public SoilTypeObject createFromParcel(Parcel in) {
      return new SoilTypeObject(in);
    }

    @Override public SoilTypeObject[] newArray(int size) {
      return new SoilTypeObject[size];
    }
  };

  private long mId;
  @NonNull private String mName;
  @NonNull private ConditionTypeObject mConditionType; // TODO: maybe we don't need this field
  @NonNull private List<LatLng> mPoints = new ArrayList<>();

  public SoilTypeObject(long mId, @NonNull String mName, @NonNull ConditionTypeObject conditionType,
      @NonNull List<LatLng> mPoints) {
    this.mId = mId;
    this.mName = mName;
    this.mConditionType = conditionType;
    this.mPoints = mPoints;
  }

  public SoilTypeObject(long mId, @NonNull String mName, @NonNull ConditionTypeObject conditionType,
      @NonNull String coordinates) {
    this.mId = mId;
    this.mName = mName;
    this.mConditionType = conditionType;
    mPoints.addAll(LatLngStringUtil.LatLngsFromString(coordinates));
  }

  protected SoilTypeObject(Parcel in) {
    this.mId = in.readLong();
    this.mName = in.readString();
    this.mConditionType = in.readParcelable(ConditionTypeObject.class.getClassLoader());
    this.mPoints = in.createTypedArrayList(LatLng.CREATOR);
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

  // TODO: don't override this method - change adapter instead
  @Override public String toString() {
    return mName;
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

  @Override public void setName(@NonNull String name) {
    this.mName = name;
  }

  @Override public ConditionTypeObject getType() {
    return mConditionType;
  }

  @Override public void setType(@NonNull ConditionTypeObject type) {
    this.mConditionType = type;
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
