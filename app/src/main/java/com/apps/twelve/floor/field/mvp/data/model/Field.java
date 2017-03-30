package com.apps.twelve.floor.field.mvp.data.model;

import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 27.03.2017.
 */

public class Field {

  private String name;
  private float area;
  private List<LatLng> points = new ArrayList<>();

  public Field() {
  }

  public Field(String name, float area) {
    this.name = name;
    this.area = area;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getArea() {
    return area;
  }

  public void setArea(float area) {
    this.area = area;
  }

  public List<LatLng> getPoints() {
    return points;
  }

  public void addAllPoints(List<LatLng> points) {
    points.addAll(points);
  }

  public void addPoint(LatLng point) {
    points.add(point);
  }

  public void clearPoints() {
    points.clear();
  }
}
