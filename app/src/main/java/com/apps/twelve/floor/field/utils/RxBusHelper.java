package com.apps.twelve.floor.field.utils;

import com.apps.twelve.floor.field.data.local.objects.FieldObject;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

/**
 * Created by John on 27.03.2017.
 */

public final class RxBusHelper {

  ///////////////////////////////////////////////////////////////////////////
  // UI events
  ///////////////////////////////////////////////////////////////////////////
  public static class FragmentChangedOnScreen {
    public boolean isActionbarShown;
    public String title;
    public boolean isRestoring;

    public FragmentChangedOnScreen(boolean isActionbarShown, String title, boolean isRestoring) {
      this.isActionbarShown = isActionbarShown;
      this.title = title;
      this.isRestoring = isRestoring;
    }
  }

  ///////////////////////////////////////////////////////////////////////////
  // Field list events
  ///////////////////////////////////////////////////////////////////////////

  public static class FieldDeletedFromList {
    public FieldObject field;
    public int position;

    public FieldDeletedFromList(FieldObject field, int position) {
      this.field = field;
      this.position = position;
    }
  }

  ///////////////////////////////////////////////////////////////////////////
  // Field edit on map events
  ///////////////////////////////////////////////////////////////////////////

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

  ///////////////////////////////////////////////////////////////////////////
  // Field tracking events
  ///////////////////////////////////////////////////////////////////////////

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

  ///////////////////////////////////////////////////////////////////////////
  // DataBase events
  ///////////////////////////////////////////////////////////////////////////

  public static class DbActualised {

    public static final int EVENT_TYPE_DB_FILLED = 10;

    public static final int EVENT_STATUS_OK = 1;
    public static final int EVENT_STATUS_FAIL = 2;

    public int eventType;
    public int eventStatus;

    public DbActualised(int eventType, int eventStatus) {
      this.eventType = eventType;
      this.eventStatus = eventStatus;
    }
  }

  public static class FieldChangedInDb {
    public static final int CHANGE_INSERT = 20;
    public static final int CHANGE_UPDATE = 30;
    public static final int CHANGE_DELETE = 40;

    public FieldObject fieldObject;
    public int change;

    public FieldChangedInDb(FieldObject fieldObject, int change) {
      this.fieldObject = fieldObject;
      this.change = change;
    }
  }
}
