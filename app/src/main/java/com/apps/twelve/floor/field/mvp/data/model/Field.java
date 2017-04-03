package com.apps.twelve.floor.field.mvp.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;
import timber.log.Timber;

/**
 * Created by John on 27.03.2017.
 */

public class Field implements Parcelable {

  public static final Creator<Field> CREATOR = new Creator<Field>() {
    @Override public Field createFromParcel(Parcel in) {
      return new Field(in);
    }

    @Override public Field[] newArray(int size) {
      return new Field[size];
    }
  };

  private String mName;
  private float mArea;
  private String mCrop;
  private List<LatLng> mPoints = new ArrayList<>();

  public Field() {
  }

  public Field(String name, String crop, float area) {
    this.mName = name;
    this.mCrop = crop;
    this.mArea = area;
  }

  protected Field(Parcel in) {
    mName = in.readString();
    mArea = in.readFloat();
    mCrop = in.readString();
    mPoints = in.createTypedArrayList(LatLng.CREATOR);
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(mName);
    dest.writeFloat(mArea);
    dest.writeString(mCrop);
    dest.writeTypedList(mPoints);
  }

  public String getName() {
    return mName;
  }

  public void setName(String name) {
    this.mName = name;
  }

  public float getArea() {
    return mArea;
  }

  public void setArea(float area) {
    this.mArea = area;
  }

  public List<LatLng> getPoints() {
    return mPoints;
  }

  public void addAllPoints(List<LatLng> points) {
    this.mPoints.addAll(points);
  }

  public void addPoint(LatLng point) {
    this.mPoints.add(point);
  }

  public void updatePoint(int index, LatLng point) {
    if (!isOkIndex(index)) return;
    this.mPoints.set(index, point);
  }

  public void removePoint(int index, LatLng point) {
    if (!isOkIndex(index)) return;
    this.mPoints.remove(point);
  }

  public void clearPoints() {
    mPoints.clear();
  }

  public String getCrop() {
    return mCrop;
  }

  public void setCrop(String crop) {
    this.mCrop = crop;
  }

  private boolean isOkIndex(int index) {
    if (index < 0 || mPoints.size() <= index) {
      Timber.e("Invalid point index");
      return false;
    }

    return true;
  }
}
