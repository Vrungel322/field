package com.apps.twelve.floor.field.mvp.presenters.pr_fragments;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.mvp.data.DataManager;
import com.apps.twelve.floor.field.mvp.presenters.BasePresenter;
import com.apps.twelve.floor.field.mvp.views.IEditFieldFragmentView;
import com.apps.twelve.floor.field.utils.RxBus;
import com.apps.twelve.floor.field.utils.RxBusHelper;
import com.arellomobile.mvp.InjectViewState;
import com.google.android.gms.maps.model.LatLng;
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

  //private FieldEntity mFieldModel;

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    subscribeToPolygonEditResult();
  }

  public EditFieldPresenter(FieldEntity fieldEntity) {
    if (fieldEntity == null) {
      setField(new FieldEntity());
    } else {
      setField(fieldEntity);
    }
  }

  public void setField(FieldEntity fieldEntity) {
    /*this.mFieldModel = fieldEntity;
    getViewState().setFieldNameText(mFieldModel.getName());
    getViewState().setFieldAreaText(
        mFieldModel.getArea() != null ? String.valueOf(mFieldModel.getArea()) : "");*/
    // TODO: get crop name by id
    //getViewState().setFieldCropText(mFieldModel.getCrop().getmName());

    // TODO: update markers, polyline and polygon on map
    /*if (fieldEntity.hasPoints()) {

    }*/
  }

  public void updateFieldName(String name) {
    /*if (name.equals(mFieldModel.getName())) return;
    mFieldModel.setName(name);
    getViewState().setFieldNameText(name);*/
  }

  public void updateFieldArea(String area) {
    /*if (area.equals(String.valueOf(mFieldModel.getArea()))) return;
    if (TextUtils.isEmpty(area)) {
      mFieldModel.setArea(Double.valueOf(0));
    } else {
      mFieldModel.setArea(Double.valueOf(area));
    }

    getViewState().setFieldAreaText(area);*/
  }

  public void updateFieldArea(double area) {
    /*if (mFieldModel.getArea() == area) return;
    mFieldModel.setArea(area);
    getViewState().setFieldAreaText(String.valueOf(area));*/
  }

  public void updateFieldCrop(Long cropId) {
    /*if (cropId.equals(mFieldModel.getCropId())) return;
    mFieldModel.setCropId(cropId);*/
    // TODO: get crop name by id
    //getViewState().setFieldCropText(cropId);
  }

  public void updateFieldPoints(List<LatLng> points) {
    /*mFieldModel.clearPoints();
    mFieldModel.addAllPoints(points);*/
  }

  public void saveField() {
    /*PutResult putResult = mDataManager.putField(mFieldModel);

    int changeId = -1;
    if (putResult.wasInserted()) {
      mFieldModel.setId(putResult.insertedId());
      changeId = RxBusHelper.FieldChangedInDb.CHANGE_INSERT;
    } else if (putResult.wasUpdated()) {
      changeId = RxBusHelper.FieldChangedInDb.CHANGE_UPDATE;
    }

    mRxBus.post(new RxBusHelper.FieldChangedInDb(mFieldModel, changeId));*/
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
