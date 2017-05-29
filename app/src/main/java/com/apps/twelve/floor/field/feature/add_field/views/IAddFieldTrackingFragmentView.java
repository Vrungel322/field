package com.apps.twelve.floor.field.feature.add_field.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

/**
 * Created by Yaroslav on 20.04.2017.
 */

@StateStrategyType(AddToEndSingleStrategy.class) public interface IAddFieldTrackingFragmentView
    extends MvpView {

  @StateStrategyType(SkipStrategy.class) void addTrackingFieldFragment();

  @StateStrategyType(AddToEndStrategy.class) void addMarkerOnMap(LatLng point);

  @StateStrategyType(AddToEndStrategy.class) void removeMarkerAtIndex(int index);

  @StateStrategyType(AddToEndStrategy.class) void updateMarkerAtIndex(int index, LatLng point);

  void updatePolyline(List<LatLng> points);

  void updatePolygon(List<LatLng> points);

  void setMarkersAndPolylineVisible(boolean visible);

  void setPolygonVisibleAndClickable(boolean mode);

  @StateStrategyType(SingleStateStrategy.class) void clearObjects();

  void moveCamera(CameraUpdate cameraUpdate);

  void startTracking();

  void stopTracking();
}
