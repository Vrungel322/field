package com.apps.twelve.floor.field.mvp.presenters.pr_fragments;

import android.text.TextUtils;
import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.mvp.data.DataManager;
import com.apps.twelve.floor.field.mvp.data.model.Field;
import com.apps.twelve.floor.field.mvp.presenters.BasePresenter;
import com.apps.twelve.floor.field.mvp.views.IEditFieldFragmentView;
import com.apps.twelve.floor.field.utils.RxBus;
import com.apps.twelve.floor.field.utils.RxBusHelper;
import com.arellomobile.mvp.InjectViewState;
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

  private Field mField;

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    subscribeToPolygonEditResult();
  }

  public EditFieldPresenter(Field field) {
    if (field == null) {
      setField(new Field());
    } else {
      setField(field);
    }
  }

  public void setField(Field field) {
    this.mField = field;
    getViewState().setFieldNameText(mField.getName());
    getViewState().setFieldAreaText(
        mField.getArea() != null ? String.valueOf(mField.getArea()) : "");
    getViewState().setFieldCropText(mField.getCrop());
    if (field.hasPoints()) {
      // TODO: update markers, polyline and polygon on map
    }
  }

  public void updateFieldName(String name) {
    if (name.equals(mField.getName())) return;
    mField.setName(name);
    getViewState().setFieldNameText(name);
  }

  public void updateFieldArea(String area) {
    if (area.equals(String.valueOf(mField.getArea()))) return;
    if (TextUtils.isEmpty(area)) {
      mField.setArea(0);
    } else {
      mField.setArea(Double.valueOf(area));
    }

    getViewState().setFieldAreaText(area);
  }

  public void updateFieldArea(double area) {
    if (mField.getArea() == area) return;
    mField.setArea(area);
    getViewState().setFieldAreaText(String.valueOf(area));
  }

  public void updateFieldCrop(String crop) {
    if (crop.equals(mField.getCrop())) return;
    mField.setCrop(crop);
    getViewState().setFieldCropText(crop);
  }

  public void updateFieldPoints(List points) {
    mField.clearPoints();
    mField.addAllPoints(points);
  }

  public void saveField() {
    PutResult putResult = mDataManager.putField(mField);

    int changeId = -1;
    if (putResult.wasInserted()) {
      mField.setId(putResult.insertedId());
      changeId = RxBusHelper.FieldChangedInDb.CHANGE_INSERT;
    } else if (putResult.wasUpdated()) {
      changeId = RxBusHelper.FieldChangedInDb.CHANGE_UPDATE;
    }

    mRxBus.post(new RxBusHelper.FieldChangedInDb(mField, changeId));
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
