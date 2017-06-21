package com.apps.twelve.floor.field.di.modules;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import com.apps.twelve.floor.field.data.local.DbCombinedFieldRelationsHelper;
import com.apps.twelve.floor.field.data.local.DbHelper;
import com.apps.twelve.floor.field.data.local.DbOpenHelper;
import com.apps.twelve.floor.field.data.local.entities.CombinedFieldEntity;
import com.apps.twelve.floor.field.data.local.entities.CropEntity;
import com.apps.twelve.floor.field.data.local.entities.CropEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.FieldEntity;
import com.apps.twelve.floor.field.data.local.entities.FieldEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionSpanValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionSpanValueEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionTypeEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.conditions.PestEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.PestEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.conditions.PhenologicalCharacteristicEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.PhenologicalCharacteristicEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.conditions.SoilTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.SoilTypeEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.conditions.TillageDirectionEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.TillageDirectionEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.process_time.ClimateZoneEntity;
import com.apps.twelve.floor.field.data.local.entities.process_time.ClimateZoneEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.process_time.PhaseEntity;
import com.apps.twelve.floor.field.data.local.entities.process_time.PhaseEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.technological_map.CropTechnologicalProcessEntity;
import com.apps.twelve.floor.field.data.local.entities.technological_map.CropTechnologicalProcessEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.technological_map.TechnologicalProcessStateEntity;
import com.apps.twelve.floor.field.data.local.entities.technological_map.TechnologicalProcessStateEntitySQLiteTypeMapping;
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
import com.apps.twelve.floor.field.data.local.entities.ConditionEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.DealerEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.FieldCropTechnologicalProcessEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.ProductPestCropEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.FieldTechnologicalProcessSolutionEntitySQLiteTypeMapping;*/

/**
 * Created by Yaroslav on 11.04.2017.
 */

@Module public class DbModule {

  @Provides @AppScope DbHelper provideDbHelper() {
    return new DbHelper();
  }

  @Provides @AppScope DbCombinedFieldRelationsHelper provideCombinedFieldRelationsHelper() {
    return new DbCombinedFieldRelationsHelper();
  }

  @Provides @AppScope StorIOSQLite provideStorIOSQLite(SQLiteOpenHelper sqliteOpenHelper) {
    return DefaultStorIOSQLite.builder().sqliteOpenHelper(sqliteOpenHelper)
        // FieldEntity mapping
        .addTypeMapping(FieldEntity.class, new FieldEntitySQLiteTypeMapping())
        // ClimateZoneEntity mapping
        .addTypeMapping(ClimateZoneEntity.class, new ClimateZoneEntitySQLiteTypeMapping())
        // CropEntity mapping
        .addTypeMapping(CropEntity.class, new CropEntitySQLiteTypeMapping())
        // CropTechnologicalProcessEntity  mapping
        .addTypeMapping(CropTechnologicalProcessEntity.class,
            new CropTechnologicalProcessEntitySQLiteTypeMapping())
        // PestEntity mapping
        .addTypeMapping(PestEntity.class, new PestEntitySQLiteTypeMapping())
        // PhaseEntity mapping
        .addTypeMapping(PhaseEntity.class, new PhaseEntitySQLiteTypeMapping())
        // ConditionTypeEntity mapping
        .addTypeMapping(ConditionTypeEntity.class, new ConditionTypeEntitySQLiteTypeMapping())
        // SoilTypeEntity mapping
        .addTypeMapping(SoilTypeEntity.class, new SoilTypeEntitySQLiteTypeMapping())
        // TechnologicalProcessStateEntity mapping
        .addTypeMapping(TechnologicalProcessStateEntity.class,
            new TechnologicalProcessStateEntitySQLiteTypeMapping())
        // TillageDirectionEntity mapping
        .addTypeMapping(TillageDirectionEntity.class, new TillageDirectionEntitySQLiteTypeMapping())
        // PhenologicalCharacteristicEntity mapping
        .addTypeMapping(PhenologicalCharacteristicEntity.class,
            new PhenologicalCharacteristicEntitySQLiteTypeMapping())
        // ConditionSpanValueEntity mapping
        .addTypeMapping(ConditionSpanValueEntity.class,
            new ConditionSpanValueEntitySQLiteTypeMapping())
        // ConditionEntity mapping
        .addTypeMapping(ConditionEntity.class, new ConditionEntitySQLiteTypeMapping())

        // TODO: uncomment this when entities will be ready
        // TODO: for some entities custom resolvers needed
        /*

        // TechnologicalSolutionTypeEntity mapping
        .addTypeMapping(TechnologicalSolutionTypeEntity.class, new TechnologicalSolutionTypeEntitySQLiteTypeMapping())
        // ProductCategoryEntity mapping
        .addTypeMapping(ProductCategoryEntity.class, new ProductCategoryEntitySQLiteTypeMapping())
        // ProductEntity mapping
        .addTypeMapping(ProductEntity.class, new ProductEntitySQLiteTypeMapping())
        // AggregateEntity mapping
        .addTypeMapping(AggregateEntity.class, new AggregateEntitySQLiteTypeMapping())
        // ProcessPeriodEntity mapping
        .addTypeMapping(ProcessPeriodEntity.class, new ProcessPeriodEntitySQLiteTypeMapping())
        // ConditionSpanValueEntity mapping
        .addTypeMapping(ConditionSpanValueEntity.class, new ConditionSpanValueEntitySQLiteTypeMapping())
        // PestPhaseEntity mapping
        .addTypeMapping(PestPhaseEntity.class, new PestPhaseEntitySQLiteTypeMapping())
        // ConditionEntity mapping
        .addTypeMapping(ConditionEntity.class, new ConditionEntitySQLiteTypeMapping())
        // DealerEntity mapping
        .addTypeMapping(DealerEntity.class, new DealerEntitySQLiteTypeMapping())
        // FieldCropTechnologicalProcessEntity mapping
        .addTypeMapping(FieldCropTechnologicalProcessEntity.class, new FieldCropTechnologicalProcessEntitySQLiteTypeMapping())
        // ProductPestCropEntity mapping
        .addTypeMapping(ProductPestCropEntity.class, new ProductPestCropEntitySQLiteTypeMapping())
        // FieldTechnologicalProcessSolutionEntity mapping
        .addTypeMapping(FieldTechnologicalProcessSolutionEntity.class, new FieldTechnologicalProcessSolutionEntitySQLiteTypeMapping())
        */

        // CombinedFieldEntity mapping
        .addTypeMapping(CombinedFieldEntity.class,
            SQLiteTypeMapping.<CombinedFieldEntity>builder().putResolver(
                new CombinedFieldPutResolver())
                .getResolver(new CombinedFieldGetResolver())
                .deleteResolver(new CombinedFieldDeleteResolver())
                .build())
        // TODO: need mappers for all entities
        .build();
  }

  @Provides @AppScope SQLiteOpenHelper provideSqLiteOpenHelper(Context context) {
    return new DbOpenHelper(context);
  }
}
