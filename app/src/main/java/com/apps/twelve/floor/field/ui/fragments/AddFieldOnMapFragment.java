package com.apps.twelve.floor.field.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.mvp.presenters.pr_fragments.AddFieldOnMapFragmentPresenter;
import com.apps.twelve.floor.field.mvp.views.IAddFieldOnMapFragmentView;
import com.apps.twelve.floor.field.ui.base.BaseFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by Yaroslav on 30.03.2017.
 */

public class AddFieldOnMapFragment extends BaseFragment
    implements IAddFieldOnMapFragmentView, OnMapReadyCallback {

  @InjectPresenter AddFieldOnMapFragmentPresenter mAddFieldOnMapFragmentPresenter;

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

    // TODO: set map type

    // TODO: set map listeners

    // TODO: send message to presenter, so it can show field or current location on the map
  }

  private void obtainMap() {
    // Obtain the SupportMapFragment and get notified when the map is ready to be used.
    SupportMapFragment mapFragment =
        (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.fragment_map);
    mapFragment.getMapAsync(this);
  }
}
