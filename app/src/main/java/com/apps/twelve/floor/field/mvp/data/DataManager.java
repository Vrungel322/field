package com.apps.twelve.floor.field.mvp.data;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.mvp.data.local.DbHelper;
import com.apps.twelve.floor.field.mvp.data.local.DbRelationsHelper;
import com.apps.twelve.floor.field.mvp.data.local.mappers.ClimateZoneEntityToClimateZoneObject;
import com.apps.twelve.floor.field.mvp.data.local.mappers.ClimateZoneObjectToClimateZoneEntity;
import com.apps.twelve.floor.field.mvp.data.local.mappers.CropEntityToCropObject;
import com.apps.twelve.floor.field.mvp.data.local.mappers.CropObjectToCropEntity;
import com.apps.twelve.floor.field.mvp.data.local.mappers.FieldCropClimateZoneEntityToFieldObject;
import com.apps.twelve.floor.field.mvp.data.local.mappers.FieldObjectToFieldEntity;
import com.apps.twelve.floor.field.mvp.data.local.objects.ClimateZoneObject;
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
  @Inject DbRelationsHelper mDbRelationsHelper;

  public DataManager() {
    App.getAppComponent().inject(this);
  }

  ///////////////////////////////////////////////////////////////////////////
  // DB methods
  ///////////////////////////////////////////////////////////////////////////

  public Observable<List<FieldObject>> getAllFields() {
    return mDbRelationsHelper.getFieldCropClimateZoneEntities()
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

  public PutResult putCrop(CropObject cropObject) {
    return mDbHelper.putCrop(new CropObjectToCropEntity().transform(cropObject));
  }

  public PutResult putClimateZone(ClimateZoneObject climateZoneObject) {
    return mDbHelper.putClimateZone(
        new ClimateZoneObjectToClimateZoneEntity().transform(climateZoneObject));
  }

  public Observable<List<ClimateZoneObject>> getAllClimateZones() {
    return mDbHelper.getAllClimateZones()
        .concatMap(Observable::from)
        .map(climateZoneEntity -> new ClimateZoneEntityToClimateZoneObject().transform(
            climateZoneEntity))
        .toList();
  }
}
