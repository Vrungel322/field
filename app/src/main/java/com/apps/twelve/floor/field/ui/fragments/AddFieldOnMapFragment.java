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
import com.apps.twelve.floor.field.mvp.presenters.pr_fragments.AddFieldOnMapFragmentPresenter;
import com.apps.twelve.floor.field.mvp.views.IAddFieldOnMapFragmentView;
import com.apps.twelve.floor.field.ui.base.BaseFragment;
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

public class AddFieldOnMapFragment extends BaseFragment
    implements IAddFieldOnMapFragmentView, OnMapReadyCallback, OnMapClickListener {

  @InjectPresenter AddFieldOnMapFragmentPresenter mAddFieldOnMapFragmentPresenter;

  @BindView(R.id.toggle_button_edit_mode) ToggleButton tglBtnEditMode;
  @BindView(R.id.ed_text_name) EditText edTextName;
  @BindView(R.id.ed_text_area) EditText edTextArea;
  @BindView(R.id.btn_edit_area) Button btnEditArea;
  @BindView(R.id.btn_ok) Button btnOk;

  private GoogleMap mMap;

  public AddFieldOnMapFragment() {
    super(R.layout.fragment_add_filed_on_map);
  }

  public static AddFieldOnMapFragment newInstance() {
    Bundle args = new Bundle();
    AddFieldOnMapFragment fragment = new AddFieldOnMapFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    obtainMap();
  }

  @Override public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;
    mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

    mMap.setOnMapClickListener(this);
    /*mMap.setOnMarkerClickListener(this);
    mMap.setOnMarkerDragListener(this);
    mMap.setOnPolygonClickListener(this);*/
    // TODO: set map listeners

    // TODO: send message to presenter, so it can show field or current location on the map
    mAddFieldOnMapFragmentPresenter.setMapReady(true);
  }

  @Override public void onMapClick(LatLng latLng) {
    mAddFieldOnMapFragmentPresenter.onMapClick(latLng);
  }

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
    mAddFieldOnMapFragmentPresenter.setEditMode(isChecked);
  }

  @Override public void addMarkerOnMap(LatLng latLng) {
    mAddFieldOnMapFragmentPresenter.addMarker(
        mMap.addMarker(new MarkerOptions().position(latLng).draggable(true)));
  }

  // Obtain the SupportMapFragment and get notified when the map is ready to be used.
  private void obtainMap() {
    mAddFieldOnMapFragmentPresenter.setMapReady(false);
    SupportMapFragment mapFragment =
        (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.fragment_map);
    mapFragment.getMapAsync(this);
  }
}
