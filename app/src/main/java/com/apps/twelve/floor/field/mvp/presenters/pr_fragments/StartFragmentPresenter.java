package com.apps.twelve.floor.field.mvp.presenters.pr_fragments;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.mvp.data.DataManager;
import com.apps.twelve.floor.field.mvp.data.local.objects.CropObject;
import com.apps.twelve.floor.field.mvp.data.local.objects.FieldObject;
import com.apps.twelve.floor.field.mvp.presenters.BasePresenter;
import com.apps.twelve.floor.field.mvp.views.IStartFragmentView;
import com.apps.twelve.floor.field.utils.RxBus;
import com.apps.twelve.floor.field.utils.RxBusHelper;
import com.apps.twelve.floor.field.utils.ThreadSchedulers;
import com.arellomobile.mvp.InjectViewState;
import com.pushtorefresh.storio.sqlite.operations.delete.DeleteResult;
import javax.inject.Inject;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

/**
 * Created by John on 28.03.2017.
 */

@InjectViewState public class StartFragmentPresenter extends BasePresenter<IStartFragmentView> {

  @Inject DataManager mDataManager;
  @Inject RxBus mRxBus;

  private int mFieldTypePosition = -1;

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    getAllFields();

    subscribeToFieldsDbChanges();
    subscribeToFieldsListChanges();
  }

  public void showFieldTypeDialog() {
    getViewState().showFieldAddTypeDialog();
  }

  public void hideFieldTypeDialog() {
    mFieldTypePosition = -1;
    getViewState().hideFieldAddTypeDialog();
  }

  public void setFieldTypePosition(int position) {
    mFieldTypePosition = position;
  }

  public int getFieldTypePosition() {
    return mFieldTypePosition;
  }

  private void getAllFields() {
    Subscription subscription = mDataManager.getAllFields()
        .compose(ThreadSchedulers.applySchedulers())
        .subscribe(fields -> getViewState().showFields(fields), Timber::e);

    // TODO: this is for test - remove
    mDataManager.putCrop(new CropObject(1, "Кукуруза", 0, false));
    mDataManager.putCrop(new CropObject(2, "Картошка", 0, false));

    addToUnsubscription(subscription);
  }

  private void subscribeToFieldsListChanges() {
    Subscription subscription = mRxBus.filteredObservable(RxBusHelper.FieldDeletedFromList.class)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(msg -> onFieldDeletedFromList(msg.field, msg.position), Timber::e);
    addToUnsubscription(subscription);
  }

  private void onFieldDeletedFromList(FieldObject field, int position) {
    DeleteResult deleteResult = mDataManager.deleteField(field);

    if (deleteResult.numberOfRowsDeleted() > 0) {
      getViewState().deleteFieldAtPosition(field, position);
    }
  }

  private void subscribeToFieldsDbChanges() {
    Subscription subscription = mRxBus.filteredObservable(RxBusHelper.FieldChangedInDb.class)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(msg -> onFieldChanged(msg.fieldObject, msg.change), Timber::e);
    addToUnsubscription(subscription);
  }

  private void onFieldChanged(FieldObject fieldObject, int change) {
    switch (change) {
      case RxBusHelper.FieldChangedInDb.CHANGE_INSERT:
        getViewState().addField(fieldObject);
        break;
      case RxBusHelper.FieldChangedInDb.CHANGE_UPDATE:
        getViewState().updateField(fieldObject);
        break;
      default:
        break;
    }
  }

  public void onFieldTypeDialogPositiveButton(int which) {
    switch (which) {
      case 0:
        getViewState().showEditFieldOnMapFragment();
        break;
      case 1:
        getViewState().showEditFieldTrackingFragment();
        break;
      case 2:
        getViewState().showEditFieldFullScreenFragment();
        break;
      default:
        break;
    }
  }

  public void onFiledClickedAtPosition(int position) {
    getViewState().openEditFieldFragment(position);
  }
}
