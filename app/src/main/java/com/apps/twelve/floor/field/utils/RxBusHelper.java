package com.apps.twelve.floor.field.utils;

import com.google.android.gms.maps.model.LatLng;
import java.util.List;

/**
 * Created by John on 27.03.2017.
 */

public final class RxBusHelper {

  public static class SwitchFieldEditMode {
    public boolean isEditMode;

    public SwitchFieldEditMode(boolean isEditMode) {
      this.isEditMode = isEditMode;
    }
  }

  public static class HandlePolygonEditResult {
    public List<LatLng> points;
    public double area;

    public HandlePolygonEditResult(List<LatLng> points, double area) {
      this.points = points;
      this.area = area;
    }
  }
}
