package com.apps.twelve.floor.field.feature.edit_field;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.base.BaseManualAttachFragment;
import com.apps.twelve.floor.field.data.local.objects.FieldObject;
import com.apps.twelve.floor.field.utils.Constants;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnCameraIdleListener;
import com.google.android.gms.maps.GoogleMap.OnCameraMoveStartedListener;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerDragListener;
import com.google.android.gms.maps.GoogleMap.OnPolygonClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.maps.model.Dot;
import com.google.android.gms.maps.model.Gap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RoundCap;
import com.google.android.gms.maps.model.SquareCap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import timber.log.Timber;

/**
 * Created by Yaroslav on 30.03.2017.
 */

public class EditFieldOnMapFragment extends BaseManualAttachFragment
    implements IEditFieldOnMapFragmentView, OnMapReadyCallback, OnMapClickListener,
    OnCameraMoveStartedListener, OnCameraIdleListener, OnMarkerClickListener, OnMarkerDragListener,
    OnPolygonClickListener, ConnectionCallbacks, OnConnectionFailedListener {

  private static final int PATTERN_DASH_LENGTH_PX = 20;
  private static final int PATTERN_GAP_LENGTH_PX = 20;
  private static final PatternItem DOT = new Dot();
  private static final PatternItem DASH = new Dash(PATTERN_DASH_LENGTH_PX);
  private static final PatternItem GAP = new Gap(PATTERN_GAP_LENGTH_PX);

  @InjectPresenter MapPolygonEditPresenter mMapPolygonEditPresenter;

  private GoogleMap mMap;
  private List<Marker> mMarkers = new ArrayList<>();
  private Polyline mPolyline;
  private Polygon mPolygon;
  private boolean mIsCameraMovedByUser;

  public EditFieldOnMapFragment() {
    super(R.layout.fragment_edit_filed_on_map);
  }

  public static EditFieldOnMapFragment newInstance() {
    return newInstance(FieldObject.newInstance());
  }

  public static EditFieldOnMapFragment newInstance(FieldObject fieldObject) {
    Bundle args = new Bundle();
    EditFieldOnMapFragment fragment = new EditFieldOnMapFragment();
    args.putParcelable(Constants.EditField.FIELD_BUNDLE_KEY, fieldObject);
    fragment.setArguments(args);
    return fragment;
  }

  ///////////////////////////////////////////////////////////////////////////
  // Fragment events
  ///////////////////////////////////////////////////////////////////////////

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    obtainMap();
  }

  @Override public void onStart() {
    if (mGoogleApiClient != null) {
      mGoogleApiClient.registerConnectionCallbacks(this);
      mGoogleApiClient.registerConnectionFailedListener(this);
      mGoogleApiClient.connect();
    }
    if (mMap != null) attachToPresenter();
    super.onStart();
  }

  @Override public void onResume() {
    if (mMap != null) attachToPresenter();
    super.onResume();
  }

  @Override public void onStop() {
    cleanMapResources();
    super.onStop();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Map events
  ///////////////////////////////////////////////////////////////////////////

  @Override public void onMapReady(GoogleMap googleMap) {
    setupMap(googleMap);
    attachToPresenter();
    // map can become ready before ApiClient connects
    if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) moveCameraToCurrentLocation();
  }

  @Override public void onMapClick(LatLng latLng) {
    mMapPolygonEditPresenter.handleNewPoint(latLng);
  }

  @Override public boolean onMarkerClick(Marker marker) {
    return mMapPolygonEditPresenter.handlePointClicked(mMarkers.indexOf(marker),
        marker.getPosition());
  }

  @Override public void onMarkerDragStart(Marker marker) {
  }

  @Override public void onMarkerDrag(Marker marker) {
  }

  @Override public void onMarkerDragEnd(Marker marker) {
    mMapPolygonEditPresenter.handlePointChanged(mMarkers.indexOf(marker), marker.getPosition());
  }

  @Override public void onPolygonClick(Polygon polygon) {
    mMapPolygonEditPresenter.clearPoints();
  }

  @Override public void onCameraMoveStarted(int i) {
    mIsCameraMovedByUser = (i == OnCameraMoveStartedListener.REASON_GESTURE);
  }

  @Override public void onCameraIdle() {
    if (mIsCameraMovedByUser) {
      mMapPolygonEditPresenter.saveMapCameraUpdate(
          CameraUpdateFactory.newCameraPosition(mMap.getCameraPosition()));
    }
  }

  ///////////////////////////////////////////////////////////////////////////
  // GoogleApi events
  ///////////////////////////////////////////////////////////////////////////

  @Override public void onConnected(@Nullable Bundle bundle) {
    // ApiClient can connect before map is ready
    if (mMap != null) moveCameraToCurrentLocation();
  }

  @Override public void onConnectionSuspended(int i) {
  }

  @Override public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    Timber.e(new Throwable("Connection failed with result:\n" + connectionResult.toString()));
  }

  ///////////////////////////////////////////////////////////////////////////
  // MvpView methods
  ///////////////////////////////////////////////////////////////////////////

  @Override public void addEditFieldFragment() {
    mNavigator.addChildFragment(this, R.id.bottom_sheet_field_item_edition,
        EditFieldBottomSheetFragment.newInstance());
  }

  @Override public void addMarkerOnMap(LatLng latLng) {
    mMarkers.add(mMap.addMarker(new MarkerOptions().position(latLng).draggable(true)));
  }

  @Override public void removeMarkerAtIndex(int index) {
    mMarkers.get(index).remove();
    mMarkers.remove(index);
  }

  @Override public void updateMarkerAtIndex(int index, LatLng point) {
    mMarkers.get(index).setPosition(point);
  }

  @Override public void updatePolyline(List<LatLng> points) {
    if (points.size() < 2) {
      clearPolyline();
      return;
    }

    if (mPolyline == null) {
      mPolyline = makeAPolyline(points);
    } else {
      mPolyline.setPoints(points);
    }
  }

  @Override public void updatePolygon(List<LatLng> points) {
    if (points.size() < 3) {
      clearPolygon();
      return;
    }

    if (mPolygon == null) {
      mPolygon = makeAPolygon(points);
    } else {
      mPolygon.setPoints(points);
    }
  }

  @Override public void setMarkersAndPolylineVisible(boolean visible) {
    if (mMarkers != null && mMarkers.size() > 0) {
      for (Marker marker : mMarkers) {
        marker.setVisible(visible);
      }
    }

    if (mPolyline != null) mPolyline.setVisible(visible);
  }

  @Override public void setPolygonVisibleAndClickable(boolean mode) {
    if (mPolygon != null) {
      mPolygon.setVisible(mode);
      mPolygon.setClickable(mode);
    }
  }

  @Override public void clearObjects() {
    clearPolygon();
    clearPolyline();
    if (mMarkers.size() != 0) {
      //mMarkers.forEach(Marker::remove);
      for (int i = 0; i < mMarkers.size(); i++) {
        mMarkers.get(i).remove();
      }
      mMarkers.clear();
    }
  }

  @Override public void moveCamera(CameraUpdate cameraUpdate) {
    mMap.moveCamera(cameraUpdate);
  }

  ///////////////////////////////////////////////////////////////////////////
  // Private section
  ///////////////////////////////////////////////////////////////////////////

  // Obtain the SupportMapFragment and get notified when the map is ready to use.
  private void obtainMap() {
    mMapPolygonEditPresenter.setMapReady(false);
    SupportMapFragment mapFragment =
        (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.fragment_map);
    mapFragment.getMapAsync(this);
  }

  public void setupMap(GoogleMap googleMap) {
    mMap = googleMap;

    mMap.setOnMapClickListener(this);
    mMap.setOnMarkerClickListener(this);
    mMap.setOnMarkerDragListener(this);
    mMap.setOnPolygonClickListener(this);
    mMap.setOnCameraMoveStartedListener(this);
    mMap.setOnCameraIdleListener(this);

    mMapPolygonEditPresenter.setMapReady(true);
  }

  private void cleanMapResources() {
    if (mGoogleApiClient != null) {
      mGoogleApiClient.unregisterConnectionCallbacks(this);
      mGoogleApiClient.unregisterConnectionFailedListener(this);
      mGoogleApiClient.disconnect();
    }
    clearObjects();
    if (mMap != null) {
      mMap.clear();
    }
  }

  private void moveCameraToCurrentLocation() {
    // check components
    if (mGoogleApiClient == null || mMap == null || !mGoogleApiClient.isConnected()) return;

    // check permissions
    if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION)
        != PackageManager.PERMISSION_GRANTED
        /*&& ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION)
        != PackageManager.PERMISSION_GRANTED*/) {
      return;
    }

    mMap.setMyLocationEnabled(true);

    Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
    if (lastLocation != null) {
      float zoom = 17.0f;
      mMapPolygonEditPresenter.initMapCameraUpdate(CameraUpdateFactory.newLatLngZoom(
          new LatLng(lastLocation.getLatitude(), lastLocation.getLongitude()), zoom));
    }
  }

  // Make a new styled Polyline
  @NonNull private Polyline makeAPolyline(List<LatLng> points) {
    int polylineColor = 0xffF57F17; // orange
    List<PatternItem> polylinePattern = Arrays.asList(DOT, GAP, DASH, GAP);
    float polylineWidth = 10f;

    return mMap.addPolyline(new PolylineOptions().addAll(points)
        .color(polylineColor)
        .pattern(polylinePattern)
        .width(polylineWidth)
        .startCap(new SquareCap())
        .endCap(new RoundCap()));
  }

  // Make a new styled Polygon
  @NonNull private Polygon makeAPolygon(List<LatLng> points) {
    List<PatternItem> polygonStrokePattern = Arrays.asList(GAP, DASH);

    int polygonStrokeColor = 0xff388E3C; // green
    int polygonFillColor = 0x88F57F17; // orange 50% transparent
    float polygonStrokeWidth = 10f;

    return mMap.addPolygon(new PolygonOptions().clickable(true)
        .addAll(points)
        .strokeColor(polygonStrokeColor)
        .strokePattern(polygonStrokePattern)
        .strokeWidth(polygonStrokeWidth)
        .fillColor(polygonFillColor)
        .visible(false)
        .clickable(false));
  }

  private void clearPolyline() {
    if (mPolyline != null) {
      mPolyline.remove();
      mPolyline = null;
    }
  }

  private void clearPolygon() {
    if (mPolygon != null) {
      mPolygon.remove();
      mPolygon = null;
    }
  }
}
