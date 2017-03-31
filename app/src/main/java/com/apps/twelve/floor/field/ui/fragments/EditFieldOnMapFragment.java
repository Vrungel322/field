package com.apps.twelve.floor.field.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;
import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.mvp.presenters.pr_fragments.MapPolygonEditPresenter;
import com.apps.twelve.floor.field.mvp.views.IEditFieldOnMapFragmentView;
import com.apps.twelve.floor.field.ui.base.ManualAttachBaseFragment;
import com.apps.twelve.floor.field.utils.ViewUtil;
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

public class EditFieldOnMapFragment extends ManualAttachBaseFragment
    implements IEditFieldOnMapFragmentView, OnMapReadyCallback, OnMapClickListener,
    OnMarkerClickListener, OnMarkerDragListener, OnPolygonClickListener {
  
  private static final int PATTERN_DASH_LENGTH_PX = 20;
  private static final int PATTERN_GAP_LENGTH_PX = 20;
  private static final PatternItem DOT = new Dot();
  private static final PatternItem DASH = new Dash(PATTERN_DASH_LENGTH_PX);
  private static final PatternItem GAP = new Gap(PATTERN_GAP_LENGTH_PX);

  @InjectPresenter MapPolygonEditPresenter mMapPolygonEditPresenter;

  @BindView(R.id.toggle_button_edit_mode) ToggleButton mTglBtnEditMode;
  @BindView(R.id.ed_text_name) EditText mEdTextName;
  @BindView(R.id.ed_text_area) EditText mEdTextArea;
  @BindView(R.id.btn_edit_area) Button mBtnEditArea;
  @BindView(R.id.btn_ok) Button mBtnOk;

  private GoogleMap mMap;
  private List<Marker> mMarkers = new ArrayList<>();
  private Polyline mPolyline;
  private Polygon mPolygon;

  public EditFieldOnMapFragment() {
    super(R.layout.fragment_edit_filed_on_map);
  }

  public static EditFieldOnMapFragment newInstance() {
    Bundle args = new Bundle();
    EditFieldOnMapFragment fragment = new EditFieldOnMapFragment();
    fragment.setArguments(args);
    return fragment;
  }

  // Fragment events ================================================

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    obtainMap();
    mMapPolygonEditPresenter.setEditMode(mTglBtnEditMode.isChecked());
  }

  // Map events ================================================

  @Override public void onMapReady(GoogleMap googleMap) {

    mMap = googleMap;
    mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

    mMap.setOnMapClickListener(this);
    mMap.setOnMarkerClickListener(this);
    mMap.setOnMarkerDragListener(this);
    mMap.setOnPolygonClickListener(this);

    // TODO: send message to presenter, so it can show polygon or current location on the map
    mMapPolygonEditPresenter.setMapReady(true);

    attachViews();
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

  // Bottom sheet events ================================================

  @OnClick({ R.id.btn_edit_area, R.id.btn_ok }) public void onViewClicked(View view) {
    switch (view.getId()) {
      case R.id.btn_edit_area:
        // TODO: send message to presenter
        showToastMessage("onEdit");
        break;
      case R.id.btn_ok:
        // TODO: send message to presenter
        showToastMessage("onOK");
        break;
    }
  }

  // when finished editing text - clear EditText's focus
  @OnEditorAction({ R.id.ed_text_area, R.id.ed_text_name }) public boolean onEditorAction(
      EditText editText, int actionId, KeyEvent event) {
    if (actionId == EditorInfo.IME_ACTION_DONE) {
      // the user is done typing.
      editText.clearFocus();
      ViewUtil.hideKeyboard(getActivity());
    }
    return false; // pass on to other listeners.
  }

  @OnCheckedChanged(R.id.toggle_button_edit_mode)
  public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    mMapPolygonEditPresenter.setEditMode(isChecked);
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

    int polygonStrokeColor = 0xff388E3C;
    int polygonFillColor = 0x88F57F17;
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
