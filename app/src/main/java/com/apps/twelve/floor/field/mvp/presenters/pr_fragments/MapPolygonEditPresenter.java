package com.apps.twelve.floor.field.mvp.presenters.pr_fragments;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.mvp.presenters.BasePresenter;
import com.apps.twelve.floor.field.mvp.views.IEditFieldOnMapFragmentView;
import com.arellomobile.mvp.InjectViewState;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;
import timber.log.Timber;

/**
 * Created by Yaroslav on 30.03.2017.
 */

@InjectViewState public class MapPolygonEditPresenter
    extends BasePresenter<IEditFieldOnMapFragmentView> {

  //@Inject DataManager mDataManager;

  private boolean mIsMapReady = false;
  private boolean mIsEditMode = false;

  private List<LatLng> mPoints = new ArrayList<>();

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
    mIsMapReady = mapReady;
  }

  public void setEditMode(boolean editMode) {
    mIsEditMode = editMode && mIsMapReady;
    onEditModeSwitched();
  }

  public void handleNewPoint(LatLng point) {
    if (!mIsEditMode) return;

    mPoints.add(point);
    getViewState().addMarkerOnMap(point);
    getViewState().updatePolyline(mPoints);
    getViewState().updatePolygon(mPoints);
  }

  public boolean handlePointClicked(int index, LatLng point) {
    if (!isOkIndex(index)) return false;

    mPoints.remove(index);
    getViewState().removeMarkerAtIndex(index);
    getViewState().updatePolyline(mPoints);
    getViewState().updatePolygon(mPoints);

    return true;
  }

  public void handlePointChanged(int index, LatLng point) {
    if (!isOkIndex(index)) return;

    mPoints.set(index, point);
    getViewState().updateMarkerAtIndex(index, point);
    getViewState().updatePolyline(mPoints);
    getViewState().updatePolygon(mPoints);
  }

  private boolean isOkIndex(int index) {
    if (index < 0 || mPoints.size() <= index) {
      Timber.e("Invalid point index");
      return false;
    }

    if (!mIsEditMode) {
      Timber.e("Invalid mode");
      return false;
    }

    return true;
  }

  private void onEditModeSwitched() {
    getViewState().setMarkersAndPolylineVisible(mIsEditMode);
    getViewState().setPolygonVisibleAndClickable(!mIsEditMode);

    // TODO: calculate area
  }
}
