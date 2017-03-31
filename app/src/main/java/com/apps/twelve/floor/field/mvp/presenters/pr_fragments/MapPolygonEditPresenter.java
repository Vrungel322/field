package com.apps.twelve.floor.field.mvp.presenters.pr_fragments;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.mvp.presenters.BasePresenter;
import com.apps.twelve.floor.field.mvp.views.IEditFieldOnMapFragmentView;
import com.arellomobile.mvp.InjectViewState;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav on 30.03.2017.
 */

@InjectViewState public class MapPolygonEditPresenter
    extends BasePresenter<IEditFieldOnMapFragmentView> {

  //@Inject DataManager mDataManager;

  private boolean isMapReady = false;
  private boolean isEditMode = false;

  private List<LatLng> points = new ArrayList<>();

  //private Field field; // TODO: filed to edit or create (give it to FieldEditPresenter)

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
  }

  @Override public void attachView(IEditFieldOnMapFragmentView view) {
    super.attachView(view);
  }

  public void setMapReady(boolean mapReady) {
    isMapReady = mapReady;
  }

  public void setEditMode(boolean editMode) {
    isEditMode = editMode && isMapReady;
  }

  public void handleNewCoordinates(LatLng latLng) {
    if (!isEditMode) return;

    points.add(latLng);
    getViewState().addMarkerOnMap(latLng);
  }
}
