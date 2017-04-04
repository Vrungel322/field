package com.apps.twelve.floor.field.mvp.presenters.pr_fragments;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.mvp.data.model.Field;
import com.apps.twelve.floor.field.mvp.presenters.BasePresenter;
import com.apps.twelve.floor.field.mvp.views.IEditFieldFragmentView;
import com.apps.twelve.floor.field.utils.RxBus;
import com.apps.twelve.floor.field.utils.RxBusHelper;
import com.arellomobile.mvp.InjectViewState;
import java.util.List;
import javax.inject.Inject;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

/**
 * Created by Yaroslav on 03.04.2017.
 */

@InjectViewState public class EditFieldPresenter extends BasePresenter<IEditFieldFragmentView> {

  //@Inject DataManager mDataManager;
  @Inject RxBus mRxBus;

  private Field mField;

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    subscribeToPlygonEditResult();
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
    getViewState().setFieldAreaText(String.valueOf(mField.getArea()));
    getViewState().setFieldCropText(mField.getCrop());
  }

  public void updateFieldName(String name) {
    mField.setName(name);
    getViewState().setFieldNameText(name);
  }

  public void updateFieldArea(String area) {
    mField.setArea(Float.valueOf(area));
    getViewState().setFieldAreaText(area);
  }

  public void updateFieldArea(double area) {
    mField.setArea(area);
    getViewState().setFieldAreaText(String.valueOf(area));
  }

  public void updateFieldCrop(String crop) {
    mField.setCrop(crop);
    getViewState().setFieldCropText(crop);
  }

  public void updateFieldPoints(List points) {
    mField.clearPoints();
    mField.addAllPoints(points);
  }

  public void saveField() {
    // TODO: save field to BD
    String msg = "Saving field:"
        + "\nname: "
        + mField.getName()
        + "\narea: "
        + mField.getArea()
        + "\ncrop:"
        + mField.getCrop()
        + "\npoints: "
        + mField.getPoints();
    Timber.d(msg);
  }

  public void setEditMode(boolean isEditMode) {
    mRxBus.post(new RxBusHelper.SwitchFieldEditMode(isEditMode));
  }

  private void subscribeToPlygonEditResult() {
    Subscription subscription = mRxBus.filteredObservable(RxBusHelper.HandlePolygonEditResult.class)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(msg -> {
          updateFieldPoints(msg.points);
          updateFieldArea(msg.area);
        });
    addToUnsubscription(subscription);
  }
}
