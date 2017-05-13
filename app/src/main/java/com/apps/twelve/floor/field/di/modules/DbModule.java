package com.apps.twelve.floor.field.di.modules;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import com.apps.twelve.floor.field.di.scopes.AppScope;
import com.apps.twelve.floor.field.mvp.data.local.DbHelper;
import com.apps.twelve.floor.field.mvp.data.local.DbOpenHelper;
import com.apps.twelve.floor.field.mvp.data.local.DbRelationsHelper;
import com.apps.twelve.floor.field.mvp.data.local.entities.ClimateZoneEntity;
import com.apps.twelve.floor.field.mvp.data.local.entities.ClimateZoneEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.mvp.data.local.entities.CropEntity;
import com.apps.twelve.floor.field.mvp.data.local.entities.CropEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.mvp.data.local.entities.CropTechnologicalProcessesEntity;
import com.apps.twelve.floor.field.mvp.data.local.entities.CropTechnologicalProcessesEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.mvp.data.local.entities.FieldCropClimateZoneEntity;
import com.apps.twelve.floor.field.mvp.data.local.entities.FieldEntity;
import com.apps.twelve.floor.field.mvp.data.local.entities.FieldEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.mvp.data.local.entities.PestEntity;
import com.apps.twelve.floor.field.mvp.data.local.entities.PestEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.mvp.data.local.entities.PhaseEntity;
import com.apps.twelve.floor.field.mvp.data.local.entities.PhaseEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.mvp.data.local.resolvers.FieldCropClimateZoneDeleteResolver;
import com.apps.twelve.floor.field.mvp.data.local.resolvers.FieldCropClimateZoneGetResolver;
import com.apps.twelve.floor.field.mvp.data.local.resolvers.FieldCropClimateZonePutResolver;
import com.pushtorefresh.storio.sqlite.SQLiteTypeMapping;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.impl.DefaultStorIOSQLite;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Yaroslav on 11.04.2017.
 */

@Module public class DbModule {

  @Provides @AppScope DbHelper provideDbHelper() {
    return new DbHelper();
  }

  @Provides @AppScope DbRelationsHelper provideDbRelationsHelper() {
    return new DbRelationsHelper();
  }

  @Provides @AppScope StorIOSQLite provideStorIOSQLite(SQLiteOpenHelper sqliteOpenHelper) {
    return DefaultStorIOSQLite.builder()
        .sqliteOpenHelper(sqliteOpenHelper)
        .addTypeMapping(FieldEntity.class,
            new FieldEntitySQLiteTypeMapping()) // for FieldEntity mapping
        .addTypeMapping(ClimateZoneEntity.class,
            new ClimateZoneEntitySQLiteTypeMapping()) // for ClimateZoneEntity mapping
        .addTypeMapping(CropEntity.class,
            new CropEntitySQLiteTypeMapping()) // for CropEntity mapping
        .addTypeMapping(CropTechnologicalProcessesEntity.class,
            new CropTechnologicalProcessesEntitySQLiteTypeMapping()) // for CropTechnologicalProcessesEntity  mapping
        .addTypeMapping(PestEntity.class,
            new PestEntitySQLiteTypeMapping()) // for PestEntity mapping
        .addTypeMapping(PhaseEntity.class,
            new PhaseEntitySQLiteTypeMapping()) // for PhaseEntity mapping
        .addTypeMapping(FieldCropClimateZoneEntity.class,
            SQLiteTypeMapping.<FieldCropClimateZoneEntity>builder().putResolver(
                new FieldCropClimateZonePutResolver())
                .getResolver(new FieldCropClimateZoneGetResolver())
                .deleteResolver(new FieldCropClimateZoneDeleteResolver())
                .build()) // for FieldCropClimateZoneEntity mapping
        // TODO: need mappers for all entities
        .build();
  }

  @Provides @AppScope SQLiteOpenHelper provideSqLiteOpenHelper(Context context) {
    return new DbOpenHelper(context);
  }
}
