package com.apps.twelve.floor.field.ui.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.mvp.data.model.Field;
import com.apps.twelve.floor.field.mvp.presenters.pr_fragments.AddFieldTrackingPresenter;
import com.apps.twelve.floor.field.mvp.views.IAddFieldTrackingFragmentView;
import com.apps.twelve.floor.field.ui.base.BaseManualAttachFragment;
import com.apps.twelve.floor.field.utils.Constants;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnCameraIdleListener;
import com.google.android.gms.maps.GoogleMap.OnCameraMoveStartedListener;
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
 * Created by Yaroslav on 20.04.2017.
 */

public class AddFieldTrackingFragment extends BaseManualAttachFragment
    implements IAddFieldTrackingFragmentView, OnMapReadyCallback, OnCameraMoveStartedListener,
    OnCameraIdleListener, OnMarkerClickListener, OnMarkerDragListener, OnPolygonClickListener,
    ConnectionCallbacks, OnConnectionFailedListener, LocationListener {

  private static final int PATTERN_DASH_LENGTH_PX = 20;
  private static final int PATTERN_GAP_LENGTH_PX = 20;
  private static final PatternItem DOT = new Dot();
  private static final PatternItem DASH = new Dash(PATTERN_DASH_LENGTH_PX);
  private static final PatternItem GAP = new Gap(PATTERN_GAP_LENGTH_PX);

  public static final long TRACKING_INTERVAL = 10000L;
  public static final long TRACKING_FASTEST_INTERVAL = 5000L;
  public static final float TRACKING_SMALLEST_DISPLACEMENT = 0f;

  @InjectPresenter AddFieldTrackingPresenter mAddFieldTrackingPresenter;

  private GoogleMap mMap;
  private List<Marker> mMarkers = new ArrayList<>();
  private Polyline mPolyline;
  private Polygon mPolygon;
  private boolean mIsCameraMovedByUser;

  private boolean mIsTrackingMode = false;
  private boolean mIsTrackingInitiated = false;
  private boolean mIsTrackingNow = false;

  private LocationRequest mLocationRequest = new LocationRequest().setInterval(TRACKING_INTERVAL)
      .setFastestInterval(TRACKING_FASTEST_INTERVAL)
      .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
      .setSmallestDisplacement(TRACKING_SMALLEST_DISPLACEMENT);

  public AddFieldTrackingFragment() {
    super(R.layout.fragment_edit_filed_on_map);
  }

  public static AddFieldTrackingFragment newInstance() {
    return newInstance(new Field());
  }

  public static AddFieldTrackingFragment newInstance(Field field) {
    Bundle args = new Bundle();
    args.putParcelable(Constants.EditField.FIELD_BUNDLE_KEY, field);
    AddFieldTrackingFragment fragment = new AddFieldTrackingFragment();
    fragment.setArguments(args);
    return fragment;
  }

  // Fragment events ================================================

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (mGoogleApiClient != null) {
      mGoogleApiClient.registerConnectionCallbacks(this);
      mGoogleApiClient.registerConnectionFailedListener(this);
    }
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    obtainMap();
  }

  @Override public void onStart() {
    if (mGoogleApiClient != null) {
      mGoogleApiClient.connect();
      initTrackingLocation();
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

  // Mvp events ================================================

  @Override public void addTrackingFieldFragment() {
    mNavigator.addChildFragment(this, R.id.bottom_sheet_field_item_edition,
        AddFieldTrackingBottomSheetFragment.newInstance());
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
    mMarkers.forEach(Marker::remove);
    mMarkers.clear();
  }

  @Override public void moveCamera(CameraUpdate cameraUpdate) {
    mMap.moveCamera(cameraUpdate);
  }

  @Override public void startTracking() {
    // TODO
    mIsTrackingMode = true;
    startLocationUpdates();
  }

  @Override public void stopTracking() {
    mIsTrackingMode = false;
    stopLocationUpdates();
  }

  // Map events ================================================

  @Override public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;

    mMap.setOnMarkerClickListener(this);
    mMap.setOnMarkerDragListener(this);
    mMap.setOnPolygonClickListener(this);
    mMap.setOnCameraMoveStartedListener(this);
    mMap.setOnCameraIdleListener(this);

    attachToPresenter();

    // map can become ready before ApiClient connects
    if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
      moveCameraToCurrentLocation();
    }
  }

  @Override public boolean onMarkerClick(Marker marker) {
    return mAddFieldTrackingPresenter.handlePointClicked(mMarkers.indexOf(marker),
        marker.getPosition());
  }

  @Override public void onMarkerDragStart(Marker marker) {
  }

  @Override public void onMarkerDrag(Marker marker) {
  }

  @Override public void onMarkerDragEnd(Marker marker) {
    mAddFieldTrackingPresenter.handlePointChanged(mMarkers.indexOf(marker), marker.getPosition());
  }

  @Override public void onPolygonClick(Polygon polygon) {
    mAddFieldTrackingPresenter.clearPoints();
  }

  @Override public void onCameraMoveStarted(int i) {
    mIsCameraMovedByUser = (i == GoogleMap.OnCameraMoveStartedListener.REASON_GESTURE);
  }

  @Override public void onCameraIdle() {
    if (mIsCameraMovedByUser) {
      mAddFieldTrackingPresenter.saveMapCameraUpdate(
          CameraUpdateFactory.newCameraPosition(mMap.getCameraPosition()));
    }
  }

  // GoogleApi events ===========================================================

  @Override public void onConnected(@Nullable Bundle bundle) {
    // ApiClient can connect before map is ready
    if (mMap != null) moveCameraToCurrentLocation();
    if (mIsTrackingMode && mIsTrackingInitiated) {
      startLocationUpdates();
    }
  }

  @Override public void onConnectionSuspended(int i) {
  }

  @Override public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    Timber.e(new Throwable("Connection failed with result:\n" + connectionResult.toString()));
  }

  // Location events ======================================================================

  @Override public void onLocationChanged(Location location) {

    mAddFieldTrackingPresenter.handleNewPoint(
        new LatLng(location.getLatitude(), location.getLongitude()));
  }

  // Private section ================================================

  // Obtain the SupportMapFragment and get notified when the map is ready to use.
  private void obtainMap() {
    SupportMapFragment mapFragment =
        (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.fragment_map);
    mapFragment.getMapAsync(this);
  }

  private void moveCameraToCurrentLocation() {
    // check components
    if (mGoogleApiClient == null || mMap == null || !mGoogleApiClient.isConnected()) return;

    // check permissions
    if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION)
        != PackageManager.PERMISSION_GRANTED
        && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION)
        != PackageManager.PERMISSION_GRANTED) {
      return;
    }

    mMap.setMyLocationEnabled(true);

    Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
    if (lastLocation != null) {
      float zoom = 17.0f;
      mAddFieldTrackingPresenter.initMapCameraUpdate(CameraUpdateFactory.newLatLngZoom(
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

  private void initTrackingLocation() {
    if (mIsTrackingInitiated) {
      return;
    }

    PendingResult<LocationSettingsResult> result =
        LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient,
            (new LocationSettingsRequest.Builder().addLocationRequest(mLocationRequest)).build());

    result.setResultCallback(locationSettingsResult -> {
      switch (locationSettingsResult.getStatus().getStatusCode()) {
        case LocationSettingsStatusCodes.SUCCESS:
          // TODO: init location request
          mIsTrackingInitiated = true;
          break;
        case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
          // TODO: request resolution in dialog
          requestLocationResolution();
          break;
        case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
          Timber.e("Can not init location tracking: setting change unavailable");
          mIsTrackingInitiated = false;
          break;
        default:
          mIsTrackingInitiated = false;
          break;
      }
    });
  }

  private void requestLocationResolution() {
    showToastMessage("request location resolution");
    // Location settings are not satisfied, but this can be fixed
    // by showing the user a dialog.
    /*try {
      // Show the dialog by calling startResolutionForResult(),
      // and check the result in onActivityResult().
      status.startResolutionForResult(
          OuterClass.this,
          REQUEST_CHECK_SETTINGS);
    } catch (SendIntentException e) {
      // Ignore the error.
    }*/
  }

  private void startLocationUpdates() {
    if (!mIsTrackingInitiated || mIsTrackingNow) {
      return;
    }

    if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION)
        != PackageManager.PERMISSION_GRANTED
        && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION)
        != PackageManager.PERMISSION_GRANTED) {
      return;
    }

    LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest,
        this);

    mIsTrackingNow = true;
  }

  private void stopLocationUpdates() {
    if (mGoogleApiClient == null || !mGoogleApiClient.isConnected()) {
      return;
    }

    LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
    mIsTrackingNow = false;
  }

  private void cleanMapResources() {
    if (mGoogleApiClient != null) {
      stopLocationUpdates();
      mGoogleApiClient.unregisterConnectionCallbacks(this);
      mGoogleApiClient.unregisterConnectionFailedListener(this);
      mGoogleApiClient.disconnect();
    }
    clearObjects();
    if (mMap != null) {
      mMap.clear();
    }
  }
}
