package com.apps.twelve.floor.field.mvp.data.local;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.mvp.data.local.tables.CropsTable;
import com.apps.twelve.floor.field.mvp.data.local.tables.FieldsTable;
import com.apps.twelve.floor.field.mvp.data.model.Crop;
import com.apps.twelve.floor.field.mvp.data.model.Field;
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

  public Observable<List<Field>> getAllFields() {
    return mStorIOSQLite.get()
        .listOfObjects(Field.class)
        .withQuery(FieldsTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putField(Field field) {
    return mStorIOSQLite.put().object(field).prepare().executeAsBlocking();
  }

  public DeleteResult deleteField(Field field) {
    return mStorIOSQLite.delete().object(field).prepare().executeAsBlocking();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Crops
  ///////////////////////////////////////////////////////////////////////////

  public Observable<List<Crop>> getAllCrops() {
    return mStorIOSQLite.get()
        .listOfObjects(Crop.class)
        .withQuery(CropsTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public PutResult putCrop(Crop crop) {
    return mStorIOSQLite.put().object(crop).prepare().executeAsBlocking();
  }

  public DeleteResult deleteCrop(Crop crop) {
    return mStorIOSQLite.delete().object(crop).prepare().executeAsBlocking();
  }
}
