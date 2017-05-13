package com.apps.twelve.floor.field.mvp.data.local.objects;

import com.apps.twelve.floor.field.utils.Constants.StringSeparators;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav on 12.05.2017.
 */

public class FieldObject {

  private Long mId;
  private String mName;
  private CropObject mCrop;
  private CropObject mPreviousCrop;
  private List<LatLng> mPoints;
  private Double mArea;
  private ClimateZoneObject mClimateZone;

  public FieldObject(Long id, String name, CropObject crop, CropObject previousCrop,
      String coordinates, Double area, ClimateZoneObject climateZone) {
    this(id, name, crop, previousCrop, new ArrayList<LatLng>(), area, climateZone);
    transformStringToPoints(coordinates);
  }

  public FieldObject(Long id, String name, CropObject crop, CropObject previousCrop,
      List<LatLng> points, Double area, ClimateZoneObject climateZone) {
    this.mId = id;
    this.mName = name;
    this.mCrop = crop;
    this.mPreviousCrop = previousCrop;
    this.mPoints = points;
    this.mArea = area;
    this.mClimateZone = climateZone;
  }

  public Long getId() {
    return mId;
  }

  public void setId(Long id) {
    this.mId = id;
  }

  public String getName() {
    return mName;
  }

  public void setName(String name) {
    this.mName = name;
  }

  public CropObject getCrop() {
    return mCrop;
  }

  public void setCrop(CropObject crop) {
    this.mCrop = crop;
  }

  public CropObject getPreviousCrop() {
    return mPreviousCrop;
  }

  public void setPreviousCrop(CropObject previousCrop) {
    this.mPreviousCrop = previousCrop;
  }

  public List<LatLng> getPoints() {
    return mPoints;
  }

  public void setPoints(List<LatLng> points) {
    this.mPoints = points;
  }

  public Double getArea() {
    return mArea;
  }

  public void setArea(Double area) {
    this.mArea = area;
  }

  public ClimateZoneObject getClimateZone() {
    return mClimateZone;
  }

  public void setClimateZone(ClimateZoneObject climateZone) {
    this.mClimateZone = climateZone;
  }

  public String getPointsAsCoordinatesString() {
    return transformPointsToString();
  }

  private void transformStringToPoints(String coordinates) {
    String[] latLngs;
    String[] coords = coordinates.split(StringSeparators.SEPARATOR_OUTER);

    List<LatLng> points = new ArrayList<>(coords.length);

    for (String coord : coords) {
      latLngs = coord.split(StringSeparators.SEPARATOR_INNER);
      points.add(new LatLng(Double.valueOf(latLngs[0]), Double.valueOf(latLngs[1])));
    }

    mPoints.clear();
    mPoints.addAll(points);
  }

  private String transformPointsToString() {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < mPoints.size(); i++) {
      sb.append(mPoints.get(i).latitude)
          .append(StringSeparators.SEPARATOR_INNER)
          .append(mPoints.get(i).longitude)
          .append((i < mPoints.size() - 1) ? StringSeparators.SEPARATOR_OUTER : "");
    }

    return sb.toString();
  }
}