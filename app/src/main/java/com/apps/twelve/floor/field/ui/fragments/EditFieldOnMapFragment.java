package com.apps.twelve.floor.field.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;
import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.mvp.presenters.pr_fragments.MapPolygonEditPresenter;
import com.apps.twelve.floor.field.mvp.views.IEditFieldOnMapFragmentView;
import com.apps.twelve.floor.field.ui.base.ManualAttachBaseFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Yaroslav on 30.03.2017.
 */

public class EditFieldOnMapFragment extends ManualAttachBaseFragment
    implements IEditFieldOnMapFragmentView, OnMapReadyCallback, OnMapClickListener {

  @InjectPresenter MapPolygonEditPresenter mMapPolygonEditPresenter;

  @BindView(R.id.toggle_button_edit_mode) ToggleButton tglBtnEditMode;
  @BindView(R.id.ed_text_name) EditText edTextName;
  @BindView(R.id.ed_text_area) EditText edTextArea;
  @BindView(R.id.btn_edit_area) Button btnEditArea;
  @BindView(R.id.btn_ok) Button btnOk;

  private GoogleMap mMap;

  public EditFieldOnMapFragment() {
    super(R.layout.fragment_add_filed_on_map);
  }

  public static EditFieldOnMapFragment newInstance() {
    Bundle args = new Bundle();
    EditFieldOnMapFragment fragment = new EditFieldOnMapFragment();
    fragment.setArguments(args);
    return fragment;
  }

  // Fragment events

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    obtainMap();
  }

  // Map events

  @Override public void onMapReady(GoogleMap googleMap) {

    mMap = googleMap;
    mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

    mMap.setOnMapClickListener(this);
    /*mMap.setOnMarkerClickListener(this);
    mMap.setOnMarkerDragListener(this);
    mMap.setOnPolygonClickListener(this);*/
    // TODO: set map listeners

    // TODO: send message to presenter, so it can show field or current location on the map
    mMapPolygonEditPresenter.setMapReady(true);

    attachViews();
  }

  @Override public void onMapClick(LatLng latLng) {
    mMapPolygonEditPresenter.handleNewCoordinates(latLng);
  }

  // Bottom sheet events

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

  // TODO: when finished editing text - clear EditText's focus (!!! keyboard doesn't go off !!!)
  /*@OnEditorAction({R.id.ed_text_area, R.id.ed_text_name}) public boolean onEditorAction(EditText v, int actionId, KeyEvent event) {
    if (actionId == EditorInfo.IME_ACTION_DONE) {
      // the user is done typing.
      v.clearFocus();
    }
    return false; // pass on to other listeners.
  }*/

  @OnCheckedChanged(R.id.toggle_button_edit_mode)
  public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    mMapPolygonEditPresenter.setEditMode(isChecked);
  }

  // MvpView events

  @Override public void addMarkerOnMap(LatLng latLng) {
    //mMapPolygonEditPresenter.addMarker();
    mMap.addMarker(new MarkerOptions().position(latLng).draggable(true));
  }

  // Private section

  // Obtain the SupportMapFragment and get notified when the map is ready to use.
  private void obtainMap() {
    mMapPolygonEditPresenter.setMapReady(false);
    SupportMapFragment mapFragment =
        (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.fragment_map);
    mapFragment.getMapAsync(this);
  }
}
