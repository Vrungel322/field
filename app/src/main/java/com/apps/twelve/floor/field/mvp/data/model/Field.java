package com.apps.twelve.floor.field.mvp.data.model;

/**
 * Created by John on 27.03.2017.
 */

public class Field {

  private String name;
  private float area;

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
}
