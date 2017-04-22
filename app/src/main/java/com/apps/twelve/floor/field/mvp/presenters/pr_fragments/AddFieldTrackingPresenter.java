package com.apps.twelve.floor.field.mvp.presenters.pr_fragments;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.mvp.presenters.BasePresenter;
import com.apps.twelve.floor.field.mvp.views.IAddFieldTrackingFragmentView;
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
 * Created by Yaroslav on 20.04.2017.
 */

@InjectViewState public class AddFieldTrackingPresenter
    extends BasePresenter<IAddFieldTrackingFragmentView> {

  @Inject RxBus mRxBus;

  private boolean mIsTrackingMode = false;

  private List<LatLng> mPoints = new ArrayList<>();
  private CameraUpdate mCameraUpdate;

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    addEditFieldBottomSheet();
    subscribeToTrackingModeSwitcher();
    subscribeToTrackingLocation();
  }

  public void handleNewPoint(LatLng point) {
    if (!mIsTrackingMode) return;

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
    getViewState().addTrackingFieldFragment();
  }

  private boolean isOkIndex(int index) {
    if (index < 0 || mPoints.size() <= index) {
      Timber.e("Invalid point index");
      return false;
    }
    if (!mIsTrackingMode) {
      Timber.e("Invalid mode");
      return false;
    }

    return true;
  }

  private void subscribeToTrackingModeSwitcher() {
    Subscription subscription = mRxBus.filteredObservable(RxBusHelper.SwitchFieldTrackingMode.class)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(msg -> onTrackingModeSwitched(msg.isTrackingMode), Timber::e);
    addToUnsubscription(subscription);
  }

  private void subscribeToTrackingLocation() {
    Subscription subscription = mRxBus.filteredObservable(RxBusHelper.TrackingNewLocation.class)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(msg -> handleNewPoint(msg.locationPoint), Timber::e);
    addToUnsubscription(subscription);
  }

  private void onTrackingModeSwitched(boolean isTrackingMode) {
    this.mIsTrackingMode = isTrackingMode;
    getViewState().setMarkersAndPolylineVisible(mIsTrackingMode);
    getViewState().setPolygonVisibleAndClickable(!mIsTrackingMode);

    if (mIsTrackingMode) {
      clearPoints();
      getViewState().startTracking();
    } else {
      getViewState().stopTracking();
      calculateAreaAndSendResult();
    }
  }

  private void calculateAreaAndSendResult() {
    mRxBus.post(
        new RxBusHelper.HandlePolygonEditResult(mPoints, SphericalUtil.computeArea(mPoints)));
  }
}
