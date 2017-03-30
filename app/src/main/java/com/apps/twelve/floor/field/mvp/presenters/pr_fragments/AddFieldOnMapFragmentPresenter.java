package com.apps.twelve.floor.field.mvp.presenters.pr_fragments;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.mvp.data.DataManager;
import com.apps.twelve.floor.field.mvp.data.model.Field;
import com.apps.twelve.floor.field.mvp.presenters.BasePresenter;
import com.apps.twelve.floor.field.mvp.views.IAddFieldOnMapFragmentView;
import com.arellomobile.mvp.InjectViewState;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

/**
 * Created by Yaroslav on 30.03.2017.
 */

@InjectViewState public class AddFieldOnMapFragmentPresenter
    extends BasePresenter<IAddFieldOnMapFragmentView> {

  @Inject DataManager mDataManager;

  private boolean isMapReady = false;
  private boolean isEditMode = false;

  private List<LatLng> points = new ArrayList<>();
  private List<Marker> markers = new ArrayList<>();
  private Field field; // TODO: filed to edit or create

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    Timber.d("onFirstViewAttach");
  }

  @Override public void attachView(IAddFieldOnMapFragmentView view) {
    super.attachView(view);
    Timber.d("attachView");
  }

  public void setMapReady(boolean mapReady) {
    isMapReady = mapReady;
  }

  public void setEditMode(boolean editMode) {
    isEditMode = editMode;
  }

  public void onMapClick(LatLng latLng) {
    if (!isEditMode) return;

    points.add(latLng);

    //removeMarkers();
    getViewState().addMarkerOnMap(latLng);
  }

  private void removeMarkers() {
    markers.forEach(Marker::remove);
  }

  public void addMarker(Marker marker) {
    markers.add(marker);
  }
}
