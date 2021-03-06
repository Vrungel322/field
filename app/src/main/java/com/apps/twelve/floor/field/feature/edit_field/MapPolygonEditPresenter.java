package com.apps.twelve.floor.field.feature.edit_field;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.base.BasePresenter;
import com.apps.twelve.floor.field.utils.RxBus;
import com.apps.twelve.floor.field.utils.RxBusHelper;
import com.arellomobile.mvp.InjectViewState;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.SphericalUtil;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

/**
 * Created by Yaroslav on 30.03.2017.
 */

@InjectViewState public class MapPolygonEditPresenter
    extends BasePresenter<IEditFieldOnMapFragmentView> {

  @Inject RxBus mRxBus;

  private boolean mIsMapReady = false;
  private boolean mIsEditMode = false;

  private List<LatLng> mPoints = new ArrayList<>();
  private CameraUpdate mCameraUpdate;

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    addEditFieldBottomSheet();
    subscribeToEditModeSwitcher();
  }

  public void setMapReady(boolean mapReady) {
    mIsMapReady = mapReady;
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

  public void clearPoints() {
    mPoints.clear();
    getViewState().clearObjects();
  }

  public void initMapCameraUpdate(CameraUpdate cameraUpdate) {
    if (mCameraUpdate == null) saveMapCameraUpdate(cameraUpdate);
  }

  public void saveMapCameraUpdate(CameraUpdate cameraUpdate) {
    this.mCameraUpdate = cameraUpdate;
    getViewState().moveCamera(mCameraUpdate);
  }

  private void addEditFieldBottomSheet() {
    getViewState().addEditFieldFragment();
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

  private void subscribeToEditModeSwitcher() {
    Subscription subscription = mRxBus.filteredObservable(RxBusHelper.SwitchFieldEditMode.class)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(msg -> onEditModeSwitched(msg.isEditMode), Timber::e);
    addToUnsubscription(subscription);
  }

  private void onEditModeSwitched(boolean isEditMode) {
    this.mIsEditMode = isEditMode;
    getViewState().setMarkersAndPolylineVisible(mIsEditMode);
    getViewState().setPolygonVisibleAndClickable(!mIsEditMode);

    if (!mIsEditMode) calculateAreaAndSendResult();
  }

  private void calculateAreaAndSendResult() {
    mRxBus.post(
        new RxBusHelper.HandlePolygonEditResult(mPoints, SphericalUtil.computeArea(mPoints)));
  }
}
