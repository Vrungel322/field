package com.apps.twelve.floor.field.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.mvp.data.model.Field;
import com.apps.twelve.floor.field.mvp.presenters.pr_fragments.MapPolygonEditPresenter;
import com.apps.twelve.floor.field.mvp.views.IEditFieldOnMapFragmentView;
import com.apps.twelve.floor.field.ui.base.BaseManualAttachFragment;
import com.apps.twelve.floor.field.utils.Constants;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.google.android.gms.maps.GoogleMap;
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

/**
 * Created by Yaroslav on 30.03.2017.
 */

public class EditFieldOnMapFragment extends BaseManualAttachFragment
    implements IEditFieldOnMapFragmentView, OnMapReadyCallback, OnMapClickListener,
    OnMarkerClickListener, OnMarkerDragListener, OnPolygonClickListener {

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

  public EditFieldOnMapFragment() {
    super(R.layout.fragment_edit_filed_on_map);
  }

  public static EditFieldOnMapFragment newInstance() {
    return newInstance(new Field());
  }

  public static EditFieldOnMapFragment newInstance(Field field) {
    Bundle args = new Bundle();
    args.putParcelable(Constants.EditField.FIELD_BUNDLE_KEY, field);
    EditFieldOnMapFragment fragment = new EditFieldOnMapFragment();
    fragment.setArguments(args);
    return fragment;
  }

  // Fragment events ================================================

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    obtainMap();
    showEditFieldFragment();
    //mMapPolygonEditPresenter.setEditMode(mTglBtnEditMode.isChecked());
  }

  @Override public void onStart() {
    super.onStart();
    if (mMap != null) attachToPresenter();
  }

  @Override public void onResume() {
    super.onResume();
    if (mMap != null) attachToPresenter();
  }

  // Map events ================================================

  @Override public void onMapReady(GoogleMap googleMap) {

    mMap = googleMap;
    mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

    mMap.setOnMapClickListener(this);
    mMap.setOnMarkerClickListener(this);
    mMap.setOnMarkerDragListener(this);
    mMap.setOnPolygonClickListener(this);

    mMapPolygonEditPresenter.setMapReady(true);

    attachToPresenter();
  }

  @Override public void onMapClick(LatLng latLng) {
    //mEditFieldPresenter.addNewPoint(latLng);
    mMapPolygonEditPresenter.handleNewPoint(latLng);
  }

  @Override public boolean onMarkerClick(Marker marker) {
    //mEditFieldPresenter.removePoint(mMarkers.indexOf(marker), marker.getPosition());
    return mMapPolygonEditPresenter.handlePointClicked(mMarkers.indexOf(marker),
        marker.getPosition());
  }

  @Override public void onMarkerDragStart(Marker marker) {
  }

  @Override public void onMarkerDrag(Marker marker) {
  }

  @Override public void onMarkerDragEnd(Marker marker) {
    //mEditFieldPresenter.updatePoint(mMarkers.indexOf(marker), marker.getPosition());
    mMapPolygonEditPresenter.handlePointChanged(mMarkers.indexOf(marker), marker.getPosition());
  }

  @Override public void onPolygonClick(Polygon polygon) {
    //mEditFieldPresenter.clearPoints();
    mMapPolygonEditPresenter.clearPoints();
  }

  // MvpView methods ================================================

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

  // Private section ================================================

  // Obtain the SupportMapFragment and get notified when the map is ready to use.
  private void obtainMap() {
    mMapPolygonEditPresenter.setMapReady(false);
    SupportMapFragment mapFragment =
        (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.fragment_map);
    mapFragment.getMapAsync(this);
  }

  private void showEditFieldFragment() {
    mNavigator.addChildFragment(this, R.id.bottom_sheet_field_item_edition,
        EditFieldBottomSheetFragment.newInstance());
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
