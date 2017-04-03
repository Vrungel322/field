package com.apps.twelve.floor.field.mvp.data.model;

import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 27.03.2017.
 */

public class Field {

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

  public void clearPoints() {
    mPoints.clear();
  }

  public String getCrop() {
    return mCrop;
  }

  public void setCrop(String crop) {
    this.mCrop = crop;
  }
}
