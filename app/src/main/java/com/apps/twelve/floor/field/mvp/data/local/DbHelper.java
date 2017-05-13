package com.apps.twelve.floor.field.mvp.data.local;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.mvp.data.local.entities.CropEntity;
import com.apps.twelve.floor.field.mvp.data.local.entities.FieldCropClimateZoneEntity;
import com.apps.twelve.floor.field.mvp.data.local.entities.FieldEntity;
import com.apps.twelve.floor.field.mvp.data.local.tables.CropsTable;
import com.apps.twelve.floor.field.mvp.data.local.tables.FieldsTable;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.operations.delete.DeleteResult;
import com.pushtorefresh.storio.sqlite.operations.put.PutResult;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

/**
 * Created by Yaroslav on 11.04.2017.
 */

public class DbHelper {

  @Inject StorIOSQLite mStorIOSQLite;

  public DbHelper() {
    App.getAppComponent().inject(this);
  }

  ///////////////////////////////////////////////////////////////////////////
  // Fields
  ///////////////////////////////////////////////////////////////////////////

  public Observable<List<FieldCropClimateZoneEntity>> getAllFields() {
    return mStorIOSQLite.get().listOfObjects(FieldCropClimateZoneEntity.class)
        .withQuery(FieldsTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putField(FieldEntity fieldEntity) {
    return mStorIOSQLite.put().object(fieldEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteField(FieldEntity fieldEntity) {
    return mStorIOSQLite.delete().object(fieldEntity).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Crops
  ///////////////////////////////////////////////////////////////////////////

  public Observable<List<CropEntity>> getAllCrops() {
    return mStorIOSQLite.get().listOfObjects(CropEntity.class)
        .withQuery(CropsTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public Observable<CropEntity> getCropById(Long id) {
    return mStorIOSQLite.get()
        .object(CropEntity.class)
        .withQuery(CropsTable.getCropByIdQuery(id))
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putCrop(CropEntity cropEntity) {
    return mStorIOSQLite.put().object(cropEntity).prepare().executeAsBlocking();
  }

  public DeleteResult deleteCrop(CropEntity cropEntity) {
    return mStorIOSQLite.delete().object(cropEntity).prepare().executeAsBlocking();
  }
}
