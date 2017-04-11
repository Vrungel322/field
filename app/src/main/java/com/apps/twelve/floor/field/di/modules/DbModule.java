package com.apps.twelve.floor.field.di.modules;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import com.apps.twelve.floor.field.di.scopes.AppScope;
import com.apps.twelve.floor.field.mvp.data.local.DbManager;
import com.apps.twelve.floor.field.mvp.data.local.DbOpenHelper;
import com.apps.twelve.floor.field.mvp.data.model.Field;
import com.apps.twelve.floor.field.mvp.data.model.FieldSQLiteTypeMapping;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.impl.DefaultStorIOSQLite;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Yaroslav on 11.04.2017.
 */

@Module public class DbModule {

  @Provides @AppScope DbManager provideDbManager() {
    return new DbManager();
  }

  @Provides @AppScope StorIOSQLite provideStorIOSQLite(SQLiteOpenHelper sqliteOpenHelper) {
    return DefaultStorIOSQLite.builder()
        .sqliteOpenHelper(sqliteOpenHelper)
        .addTypeMapping(Field.class, new FieldSQLiteTypeMapping()) // for Field mapping
        .build();
  }

  @Provides @AppScope SQLiteOpenHelper provideSqLiteOpenHelper(Context context) {
    return new DbOpenHelper(context);
  }
}
