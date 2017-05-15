package com.apps.twelve.floor.field.mvp.presenters.pr_fragments;

import android.text.TextUtils;
import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.mvp.data.DataManager;
import com.apps.twelve.floor.field.mvp.data.local.objects.CropObject;
import com.apps.twelve.floor.field.mvp.data.local.objects.FieldObject;
import com.apps.twelve.floor.field.mvp.presenters.BasePresenter;
import com.apps.twelve.floor.field.mvp.views.IEditFieldFragmentView;
import com.apps.twelve.floor.field.utils.RxBus;
import com.apps.twelve.floor.field.utils.RxBusHelper;
import com.arellomobile.mvp.InjectViewState;
import com.google.android.gms.maps.model.LatLng;
import com.pushtorefresh.storio.sqlite.operations.put.PutResult;
import java.util.List;
import javax.inject.Inject;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

/**
 * Created by Yaroslav on 03.04.2017.
 */

@InjectViewState public class EditFieldPresenter extends BasePresenter<IEditFieldFragmentView> {

  @Inject DataManager mDataManager;
  @Inject RxBus mRxBus;

  private FieldObject mFieldObject;

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    subscribeToPolygonEditResult();
  }

  public EditFieldPresenter(FieldObject fieldObject) {
    if (fieldObject == null) {
      setField(new FieldObject());
    } else {
      setField(fieldObject);
    }
  }

  public void setField(FieldObject fieldObject) {
    this.mFieldObject = fieldObject;
    getViewState().setFieldNameText(mFieldObject.getName());
    getViewState().setFieldAreaText(String.valueOf(mFieldObject.getArea()));
    getViewState().setFieldCropText(mFieldObject.getCrop().getName());

    if (mFieldObject.hasPoints()) {
      // TODO: update markers, polyline and polygon on map
    }
  }

  public void updateFieldName(String name) {
    if (name.equals(mFieldObject.getName())) return;
    mFieldObject.setName(name);
    getViewState().setFieldNameText(name);
  }

  public void updateFieldArea(String area) {
    double dArea = 0;
    if (!TextUtils.isEmpty(area)) {
      try {
        dArea = Double.parseDouble(area);
      } catch (NumberFormatException e) {
        Timber.e(e);
        dArea = 0;
      }
    }

    mFieldObject.setArea(dArea);
    getViewState().setFieldAreaText(String.valueOf(dArea));
  }

  public void updateFieldArea(double area) {
    if (area == mFieldObject.getArea()) return;

    mFieldObject.setArea(area);
    getViewState().setFieldAreaText(String.valueOf(area));
  }

  public void updateFieldCrop(CropObject cropObject) {
    mFieldObject.setCrop(cropObject);
    getViewState().setFieldCropText(cropObject.getName());
  }

  public void updateFieldPoints(List<LatLng> points) {
    mFieldObject.clearPoints();
    mFieldObject.addAllPoints(points);
  }

  public void saveField() {
    PutResult putResult = mDataManager.putField(mFieldObject);

    int changeId = -1;
    if (putResult.wasInserted()) {
      if (putResult.insertedId() != null) {
        //noinspection ConstantConditions
        mFieldObject.setId(putResult.insertedId());
        changeId = RxBusHelper.FieldChangedInDb.CHANGE_INSERT;
      } else {
        Timber.e("Incorrect Field id after DB put");
        return;
      }
    } else if (putResult.wasUpdated()) {
      changeId = RxBusHelper.FieldChangedInDb.CHANGE_UPDATE;
    }

    mRxBus.post(new RxBusHelper.FieldChangedInDb(mFieldObject, changeId));
  }

  public void setEditMode(boolean isEditMode) {
    mRxBus.post(new RxBusHelper.SwitchFieldEditMode(isEditMode));
    getViewState().setBtnOkEnabled(!isEditMode);
  }

  public void setTrackingMode(boolean isTrackingMode) {
    mRxBus.post(new RxBusHelper.SwitchFieldTrackingMode(isTrackingMode));
    getViewState().setBtnOkEnabled(!isTrackingMode);
  }

  private void subscribeToPolygonEditResult() {
    Subscription subscription = mRxBus.filteredObservable(RxBusHelper.HandlePolygonEditResult.class)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(msg -> {
          updateFieldPoints(msg.points);
          updateFieldArea(msg.area);
        }, Timber::e);
    addToUnsubscription(subscription);
  }
}
