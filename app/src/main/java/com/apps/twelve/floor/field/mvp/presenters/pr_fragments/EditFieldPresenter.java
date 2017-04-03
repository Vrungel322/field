package com.apps.twelve.floor.field.mvp.presenters.pr_fragments;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.mvp.data.model.Field;
import com.apps.twelve.floor.field.mvp.presenters.BasePresenter;
import com.apps.twelve.floor.field.mvp.views.IEditFieldFragmentView;
import com.arellomobile.mvp.InjectViewState;
import com.google.android.gms.maps.model.LatLng;
import timber.log.Timber;

/**
 * Created by Yaroslav on 03.04.2017.
 */

@InjectViewState public class EditFieldPresenter extends BasePresenter<IEditFieldFragmentView> {

  //@Inject DataManager mDataManager;

  private Field mField;

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override public void attachView(IEditFieldFragmentView view) {
    super.attachView(view);
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

  public void updateFieldCrop(String crop) {
    mField.setCrop(crop);
    getViewState().setFieldCropText(crop);
  }

  public void addNewPoint(LatLng point) {
    this.mField.addPoint(point);
  }

  public void removePoint(int index, LatLng point) {
    mField.removePoint(index, point);
  }

  public void updatePoint(int index, LatLng point) {
    mField.updatePoint(index, point);
  }

  public void clearPoints() {
    mField.clearPoints();
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
}
