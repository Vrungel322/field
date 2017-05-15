package com.apps.twelve.floor.field.mvp.data;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.mvp.data.local.DbHelper;
import com.apps.twelve.floor.field.mvp.data.local.mappers.CropEntityToCropObject;
import com.apps.twelve.floor.field.mvp.data.local.mappers.FieldCropClimateZoneEntityToFieldObject;
import com.apps.twelve.floor.field.mvp.data.local.mappers.FieldObjectToFieldEntity;
import com.apps.twelve.floor.field.mvp.data.local.objects.CropObject;
import com.apps.twelve.floor.field.mvp.data.local.objects.FieldObject;
import com.pushtorefresh.storio.sqlite.operations.delete.DeleteResult;
import com.pushtorefresh.storio.sqlite.operations.put.PutResult;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

/**
 * Created by John on 27.03.2017.
 */

public class DataManager {

  //@Inject RestApi mRestApi;
  @Inject DbHelper mDbHelper;

  public DataManager() {
    App.getAppComponent().inject(this);
  }

  ///////////////////////////////////////////////////////////////////////////
  // DB methods
  ///////////////////////////////////////////////////////////////////////////

  public Observable<List<FieldObject>> getAllFields() {
    return mDbHelper.getAllFields()
        .concatMap(Observable::from)
        .map(fieldCropClimateZoneEntity -> new FieldCropClimateZoneEntityToFieldObject().transform(
            fieldCropClimateZoneEntity))
        .toList();
  }

  public PutResult putField(FieldObject fieldObject) {
    return mDbHelper.putField(new FieldObjectToFieldEntity().transform(fieldObject));
  }

  public DeleteResult deleteField(FieldObject fieldObject) {
    return mDbHelper.deleteField(new FieldObjectToFieldEntity().transform(fieldObject));
  }

  public Observable<List<CropObject>> getAllCrops() {
    return mDbHelper.getAllCrops()
        .concatMap(Observable::from)
        .map(cropEntity -> new CropEntityToCropObject().transform(cropEntity))
        .toList();
  }

  public Observable<CropObject> getCropById(long id) {
    return mDbHelper.getCropById(id)
        .map(cropEntity -> new CropEntityToCropObject().transform(cropEntity))
        .take(1);
  }
}
