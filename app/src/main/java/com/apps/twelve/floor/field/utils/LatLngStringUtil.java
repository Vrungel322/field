package com.apps.twelve.floor.field.utils;

import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav on 15.05.2017.
 */

public final class LatLngStringUtil {

  public static final String SEPARATOR_OUTER = "\u16DD";
  public static final String SEPARATOR_INNER = "\u16DC";

  public static List<LatLng> LatLngsFromString(String coordinates) {
    String[] latLngs;
    String[] coords = coordinates.split(SEPARATOR_OUTER);

    List<LatLng> points = new ArrayList<>(coords.length);

    for (String coord : coords) {
      latLngs = coord.split(SEPARATOR_INNER);
      points.add(new LatLng(Double.valueOf(latLngs[0]), Double.valueOf(latLngs[1])));
    }

    return points;
  }

  public static String stringFromLatLngs(List<LatLng> points) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < points.size(); i++) {
      sb.append(points.get(i).latitude)
          .append(SEPARATOR_INNER)
          .append(points.get(i).longitude)
          .append((i < points.size() - 1) ? SEPARATOR_OUTER : "");
    }

    return sb.toString();
  }
}
