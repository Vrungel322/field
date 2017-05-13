package com.apps.twelve.floor.field.mvp.data;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.mvp.data.local.DbHelper;
import com.apps.twelve.floor.field.mvp.data.local.entities.FieldEntity;
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

  public PutResult putField(FieldEntity fieldEntity) {
    return mDbHelper.putField(fieldEntity);
  }

  public DeleteResult deleteField(FieldObject fieldObject) {
    return mDbHelper.deleteField(new FieldObjectToFieldEntity().transform(fieldObject));
  }

  public Observable<List<CropObject>> getAllCrops() {
    return mDbHelper.getAllCrops()
        .concatMap(Observable::from)
        .map(cropModel -> new CropEntityToCropObject().transform(cropModel))
        .toList();
  }
}
