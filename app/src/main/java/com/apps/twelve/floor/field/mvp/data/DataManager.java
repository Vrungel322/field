package com.apps.twelve.floor.field.mvp.data;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.mvp.data.local.DbHelper;
import com.apps.twelve.floor.field.mvp.data.model.Field;
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

  public Observable<List<Field>> getAllFields() {
    return mDbHelper.getAllFields();
  }

  public PutResult putField(Field field) {
    return mDbHelper.putField(field);
  }

  public DeleteResult deleteField(Field field) {
    return mDbHelper.deleteField(field);
  }
}
