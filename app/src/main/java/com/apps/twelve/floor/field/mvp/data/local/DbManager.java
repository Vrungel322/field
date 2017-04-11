package com.apps.twelve.floor.field.mvp.data.local;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.mvp.data.local.tables.FieldsTable;
import com.apps.twelve.floor.field.mvp.data.model.Field;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

/**
 * Created by Yaroslav on 11.04.2017.
 */

public class DbManager {

  @Inject StorIOSQLite mStorIOSQLite;

  public DbManager() {
    App.getAppComponent().inject(this);
  }

  public Observable<List<Field>> getAllFields() {
    return mStorIOSQLite.get()
        .listOfObjects(Field.class)
        .withQuery(FieldsTable.QUERY_ALL)
        .prepare()
        .asRxObservable()
        .take(1);
  }
}
