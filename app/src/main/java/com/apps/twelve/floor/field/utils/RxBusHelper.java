package com.apps.twelve.floor.field.utils;

import com.apps.twelve.floor.field.mvp.data.model.Field;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

/**
 * Created by John on 27.03.2017.
 */

public final class RxBusHelper {

  // Field list events =====================================================================

  public static class FieldDeletedFromList {
    public Field field;
    public int position;

    public FieldDeletedFromList(Field field, int position) {
      this.field = field;
      this.position = position;
    }
  }

  // Field edit events =====================================================================

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

  // Field tracking events =====================================================================

  public static class SwitchFieldTrackingMode {
    public boolean isTrackingMode;

    public SwitchFieldTrackingMode(boolean isTrackingMode) {
      this.isTrackingMode = isTrackingMode;
    }
  }

  public static class TrackingNewLocation {
    public LatLng locationPoint;

    public TrackingNewLocation(LatLng locationPoint) {
      this.locationPoint = locationPoint;
    }
  }

  // DataBase events  =====================================================================

  public static class FieldChangedInDb {
    public static final int CHANGE_INSERT = 20;
    public static final int CHANGE_UPDATE = 30;
    public static final int CHANGE_DELETE = 40;

    public Field field;
    public int change;

    public FieldChangedInDb(Field field, int change) {
      this.field = field;
      this.change = change;
    }
  }
}
