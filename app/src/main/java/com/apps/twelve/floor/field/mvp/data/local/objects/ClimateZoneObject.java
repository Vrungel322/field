package com.apps.twelve.floor.field.mvp.data.local.objects;

import com.apps.twelve.floor.field.utils.Constants;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav on 12.05.2017.
 */

public class ClimateZoneObject {

  private Long mId;
  private String mName;
  private List<LatLng> mPoints;

  public ClimateZoneObject(Long id, String name, List<LatLng> points) {
    this.mId = id;
    this.mName = name;
    this.mPoints = points;
  }

  public ClimateZoneObject(Long id, String name, String coordinates) {
    this(id, name, new ArrayList<LatLng>());
    transformStringToPoints(coordinates);
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

  public List<LatLng> getPoints() {
    return mPoints;
  }

  public void setPoints(List<LatLng> points) {
    this.mPoints = points;
  }

  private void transformStringToPoints(String coordinates) {
    String[] latLngs;
    String[] coords = coordinates.split(Constants.StringSeparators.SEPARATOR_OUTER);

    List<LatLng> points = new ArrayList<>(coords.length);

    for (String coord : coords) {
      latLngs = coord.split(Constants.StringSeparators.SEPARATOR_INNER);
      points.add(new LatLng(Double.valueOf(latLngs[0]), Double.valueOf(latLngs[1])));
    }

    mPoints.clear();
    mPoints.addAll(points);
  }

  private String transformPointsToString() {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < mPoints.size(); i++) {
      sb.append(mPoints.get(i).latitude)
          .append(Constants.StringSeparators.SEPARATOR_INNER)
          .append(mPoints.get(i).longitude)
          .append((i < mPoints.size() - 1) ? Constants.StringSeparators.SEPARATOR_OUTER : "");
    }

    return sb.toString();
  }
}
