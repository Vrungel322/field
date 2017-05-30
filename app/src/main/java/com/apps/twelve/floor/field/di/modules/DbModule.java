package com.apps.twelve.floor.field.di.modules;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import com.apps.twelve.floor.field.data.local.DbHelper;
import com.apps.twelve.floor.field.data.local.DbOpenHelper;
import com.apps.twelve.floor.field.data.local.DbRelationsHelper;
import com.apps.twelve.floor.field.data.local.entities.ClimateZoneEntity;
import com.apps.twelve.floor.field.data.local.entities.ClimateZoneEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.CombinedFieldEntity;
import com.apps.twelve.floor.field.data.local.entities.CropEntity;
import com.apps.twelve.floor.field.data.local.entities.CropEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.CropTechnologicalProcessesEntity;
import com.apps.twelve.floor.field.data.local.entities.CropTechnologicalProcessesEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.FieldEntity;
import com.apps.twelve.floor.field.data.local.entities.FieldEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.PestEntity;
import com.apps.twelve.floor.field.data.local.entities.PestEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.PhaseEntity;
import com.apps.twelve.floor.field.data.local.entities.PhaseEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.resolvers.CombinedFieldDeleteResolver;
import com.apps.twelve.floor.field.data.local.resolvers.CombinedFieldGetResolver;
import com.apps.twelve.floor.field.data.local.resolvers.CombinedFieldPutResolver;
import com.apps.twelve.floor.field.di.scopes.AppScope;
import com.pushtorefresh.storio.sqlite.SQLiteTypeMapping;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.impl.DefaultStorIOSQLite;
import dagger.Module;
import dagger.Provides;

// TODO: uncomment this when entities will be ready
/*import com.apps.twelve.floor.field.data.local.entities.TechnologicalProcessStateEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.TechnologicalSolutionTypeEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.ProductCategoryEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.ProductEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.AggregateEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.ProcessPeriodEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.ConditionTypeEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.ConditionSpanValueEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.SoilTypeEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.PestPhaseEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.TillageDirectionEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.PhenologicalCharacteristicEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.ConditionEntitySQLiteTypeMapping;*/

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

        // TODO: uncomment this when entities will be ready
        /*.addTypeMapping(TechnologicalProcessStateEntity.class,
            new TechnologicalProcessStateEntitySQLiteTypeMapping()) // for TechnologicalProcessStateEntity mapping
        .addTypeMapping(TechnologicalSolutionTypeEntity.class,
            new TechnologicalSolutionTypeEntitySQLiteTypeMapping()) // for TechnologicalSolutionTypeEntity mapping
        .addTypeMapping(ProductCategoryEntity.class,
            new ProductCategoryEntitySQLiteTypeMapping()) // for ProductCategoryEntity mapping
        .addTypeMapping(ProductEntity.class,
            new ProductEntitySQLiteTypeMapping()) // for ProductEntity mapping
        .addTypeMapping(AggregateEntity.class,
            new AggregateEntitySQLiteTypeMapping()) // for AggregateEntity mapping
        .addTypeMapping(ProcessPeriodEntity.class,
            new ProcessPeriodEntitySQLiteTypeMapping()) // for ProcessPeriodEntity mapping
        .addTypeMapping(ConditionTypeEntity.class,
            new ConditionTypeEntitySQLiteTypeMapping()) // for ConditionTypeEntity mapping
        .addTypeMapping(ConditionSpanValueEntity.class,
            new ConditionSpanValueEntitySQLiteTypeMapping()) // for ConditionSpanValueEntity mapping
        .addTypeMapping(SoilTypeEntity.class,
            new SoilTypeEntitySQLiteTypeMapping()) // for SoilTypeEntity mapping
        .addTypeMapping(PestPhaseEntity.class,
            new PestPhaseEntitySQLiteTypeMapping()) // for PestPhaseEntity mapping
        .addTypeMapping(TillageDirectionEntity.class,
            new TillageDirectionEntitySQLiteTypeMapping()) // for TillageDirectionEntity mapping
        .addTypeMapping(PhenologicalCharacteristicEntity.class,
            new PhenologicalCharacteristicEntitySQLiteTypeMapping()) // for PhenologicalCharacteristicEntity mapping
        .addTypeMapping(ConditionEntity.class,
            new ConditionEntitySQLiteTypeMapping()) // for ConditionEntity mapping
            */

        .addTypeMapping(CombinedFieldEntity.class,
            SQLiteTypeMapping.<CombinedFieldEntity>builder().putResolver(
                new CombinedFieldPutResolver())
                .getResolver(new CombinedFieldGetResolver())
                .deleteResolver(new CombinedFieldDeleteResolver())
                .build()) // for CombinedFieldEntity mapping
        // TODO: need mappers for all entities
        .build();
  }

  @Provides @AppScope SQLiteOpenHelper provideSqLiteOpenHelper(Context context) {
    return new DbOpenHelper(context);
  }
}
