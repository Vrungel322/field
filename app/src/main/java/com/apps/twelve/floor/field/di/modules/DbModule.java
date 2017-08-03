package com.apps.twelve.floor.field.di.modules;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import com.apps.twelve.floor.field.data.local.DbCombinedFieldRelationsHelper;
import com.apps.twelve.floor.field.data.local.DbHelper;
import com.apps.twelve.floor.field.data.local.DbOpenHelper;
import com.apps.twelve.floor.field.data.local.db_filler.DbFillHelper;
import com.apps.twelve.floor.field.data.local.entities.CombinedFieldEntity;
import com.apps.twelve.floor.field.data.local.entities.CropActiveComponentHarmfulObjectEntity;
import com.apps.twelve.floor.field.data.local.entities.CropActiveComponentHarmfulObjectEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.CropEntity;
import com.apps.twelve.floor.field.data.local.entities.CropEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.DealerEntity;
import com.apps.twelve.floor.field.data.local.entities.DealerEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.FieldEntity;
import com.apps.twelve.floor.field.data.local.entities.FieldEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.PhenologicalCharacteristicEntity;
import com.apps.twelve.floor.field.data.local.entities.PhenologicalCharacteristicEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.SoilTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.SoilTypeEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.TillageDirectionEntity;
import com.apps.twelve.floor.field.data.local.entities.TillageDirectionEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionNameEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionNameEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionSpanValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionSpanValueEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionTypeEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.conditions.HarmfulObjectPhaseValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.HarmfulObjectPhaseValueEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.conditions.HarmfulObjectValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.HarmfulObjectValueEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.conditions.PhenologicalCharacteristicValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.PhenologicalCharacteristicValueEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.conditions.PreviousCropValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.PreviousCropValueEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.conditions.SoilTypeValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.SoilTypeValueEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.conditions.TillageDirectionValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.TillageDirectionValueEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.HarmfulObjectEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.HarmfulObjectEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.HarmfulObjectPhaseEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.HarmfulObjectPhaseEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.HarmfulObjectTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.HarmfulObjectTypeEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.PestClassEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.PestClassEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.PestEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.PestEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.PestOrderEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.PestOrderEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.WeedClassEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.WeedClassEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.WeedEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.WeedEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.WeedGroupEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.WeedGroupEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.WeedNutritionTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.WeedNutritionTypeEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.process_time.ClimateZoneEntity;
import com.apps.twelve.floor.field.data.local.entities.process_time.ClimateZoneEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.process_time.PhaseEntity;
import com.apps.twelve.floor.field.data.local.entities.process_time.PhaseEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.process_time.ProcessPeriodEntity;
import com.apps.twelve.floor.field.data.local.entities.process_time.ProcessPeriodEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.solutions.ActiveComponentEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.ActiveComponentEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.solutions.ActiveComponentInProductEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.ActiveComponentInProductEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.solutions.AggregateEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.AggregateEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.solutions.FieldTechnologicalProcessSolutionEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.FieldTechnologicalProcessSolutionEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.solutions.InsectEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.InsectEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.solutions.ProductCategoryEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.ProductCategoryEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.solutions.ProductEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.ProductEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.solutions.TechnologicalSolutionEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.TechnologicalSolutionEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.solutions.TechnologicalSolutionTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.TechnologicalSolutionTypeEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.technological_map.CropTechnologicalProcessEntity;
import com.apps.twelve.floor.field.data.local.entities.technological_map.CropTechnologicalProcessEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.technological_map.FieldCropTechnologicalProcessEntity;
import com.apps.twelve.floor.field.data.local.entities.technological_map.FieldCropTechnologicalProcessEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.technological_map.TechnologicalProcessConditionEntity;
import com.apps.twelve.floor.field.data.local.entities.technological_map.TechnologicalProcessConditionEntitySQLiteTypeMapping;
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

/**
 * Created by Yaroslav on 11.04.2017.
 *
 */

@Module public class DbModule {

  @Provides @AppScope DbFillHelper provideDbFillHelper() {
    return new DbFillHelper();
  }

  @Provides @AppScope DbHelper provideDbHelper() {
    return new DbHelper();
  }

  @Provides @AppScope DbCombinedFieldRelationsHelper provideCombinedFieldRelationsHelper() {
    return new DbCombinedFieldRelationsHelper();
  }

  @Provides @AppScope StorIOSQLite provideStorIOSQLite(SQLiteOpenHelper sqliteOpenHelper) {
    return DefaultStorIOSQLite.builder().sqliteOpenHelper(sqliteOpenHelper)

        // CONDITIONS
        // ConditionEntity mapping
        .addTypeMapping(ConditionEntity.class, new ConditionEntitySQLiteTypeMapping())
        // ConditionNames mapping
        .addTypeMapping(ConditionNameEntity.class, new ConditionNameEntitySQLiteTypeMapping())
        // ConditionSpanValueEntity mapping
        .addTypeMapping(ConditionSpanValueEntity.class,
            new ConditionSpanValueEntitySQLiteTypeMapping())
        // ConditionTypeEntity mapping
        .addTypeMapping(ConditionTypeEntity.class, new ConditionTypeEntitySQLiteTypeMapping())
        // HarmfulObjectPhaseValueEntity mapping
        .addTypeMapping(HarmfulObjectPhaseValueEntity.class,
            new HarmfulObjectPhaseValueEntitySQLiteTypeMapping())
        // HarmfulObjectValueEntity mapping
        .addTypeMapping(HarmfulObjectValueEntity.class,
            new HarmfulObjectValueEntitySQLiteTypeMapping())
        // PhenologicalCharacteristicValueEntity mapping
        .addTypeMapping(PhenologicalCharacteristicValueEntity.class,
            new PhenologicalCharacteristicValueEntitySQLiteTypeMapping())
        // SoilTypeValueEntity mapping
        .addTypeMapping(SoilTypeValueEntity.class, new SoilTypeValueEntitySQLiteTypeMapping())
        // TillageDirectionValueEntity mapping
        .addTypeMapping(TillageDirectionValueEntity.class,
            new TillageDirectionValueEntitySQLiteTypeMapping())
        // PreviousCropValueEntity mapping
        .addTypeMapping(PreviousCropValueEntity.class,
            new PreviousCropValueEntitySQLiteTypeMapping())

        // HARMFUL OBJECTS
        // HarmfulObjectEntity mapping
        .addTypeMapping(HarmfulObjectEntity.class, new HarmfulObjectEntitySQLiteTypeMapping())
        // HarmfulObjectPhaseEntity mapping
        .addTypeMapping(HarmfulObjectPhaseEntity.class,
            new HarmfulObjectPhaseEntitySQLiteTypeMapping())
        // HarmfulObjectTypeEntity mapping
        .addTypeMapping(HarmfulObjectTypeEntity.class,
            new HarmfulObjectTypeEntitySQLiteTypeMapping())
        // PestClassEntity mapping
        .addTypeMapping(PestClassEntity.class, new PestClassEntitySQLiteTypeMapping())
        // PestEntity mapping
        .addTypeMapping(PestEntity.class, new PestEntitySQLiteTypeMapping())
        // PestOrderEntity mapping
        .addTypeMapping(PestOrderEntity.class, new PestOrderEntitySQLiteTypeMapping())
        // WeedClassEntity mapping
        .addTypeMapping(WeedClassEntity.class, new WeedClassEntitySQLiteTypeMapping())
        // WeedEntity mapping
        .addTypeMapping(WeedEntity.class, new WeedEntitySQLiteTypeMapping())
        // WeedGroupEntity mapping
        .addTypeMapping(WeedGroupEntity.class, new WeedGroupEntitySQLiteTypeMapping())
        // WeedNutritionTypeEntity mapping
        .addTypeMapping(WeedNutritionTypeEntity.class,
            new WeedNutritionTypeEntitySQLiteTypeMapping())

        // PROCESS TIME
        // ClimateZoneEntity mapping
        .addTypeMapping(ClimateZoneEntity.class, new ClimateZoneEntitySQLiteTypeMapping())
        // PhaseEntity mapping
        .addTypeMapping(PhaseEntity.class, new PhaseEntitySQLiteTypeMapping())
        // ProcessPeriodEntity mapping
        .addTypeMapping(ProcessPeriodEntity.class, new ProcessPeriodEntitySQLiteTypeMapping())

        // SOLUTIONS
        // ActiveComponentEntity mapping
        .addTypeMapping(ActiveComponentEntity.class, new ActiveComponentEntitySQLiteTypeMapping())
        // ActiveComponentInProductEntity mapping
        .addTypeMapping(ActiveComponentInProductEntity.class,
            new ActiveComponentInProductEntitySQLiteTypeMapping())
        // AggregateEntity mapping
        .addTypeMapping(AggregateEntity.class, new AggregateEntitySQLiteTypeMapping())
        // FieldTechnologicalProcessSolutionEntity mapping
        .addTypeMapping(FieldTechnologicalProcessSolutionEntity.class,
            new FieldTechnologicalProcessSolutionEntitySQLiteTypeMapping())
        // InsectEntity mapping
        .addTypeMapping(InsectEntity.class, new InsectEntitySQLiteTypeMapping())
        // ProductCategoryEntity mapping
        .addTypeMapping(ProductCategoryEntity.class, new ProductCategoryEntitySQLiteTypeMapping())
        // ProductEntity mapping
        .addTypeMapping(ProductEntity.class, new ProductEntitySQLiteTypeMapping())
        // TechnologicalSolutionEntity mapping
        .addTypeMapping(TechnologicalSolutionEntity.class,
            new TechnologicalSolutionEntitySQLiteTypeMapping())
        // TechnologicalSolutionTypeEntity mapping
        .addTypeMapping(TechnologicalSolutionTypeEntity.class,
            new TechnologicalSolutionTypeEntitySQLiteTypeMapping())

        // TECHNOLOGICAL MAP
        // CropTechnologicalProcessEntity  mapping
        .addTypeMapping(CropTechnologicalProcessEntity.class,
            new CropTechnologicalProcessEntitySQLiteTypeMapping())
        // FieldCropTechnologicalProcessEntity mapping
        .addTypeMapping(FieldCropTechnologicalProcessEntity.class,
            new FieldCropTechnologicalProcessEntitySQLiteTypeMapping())
        // TechnologicalProcessConditionEntity mapping
        .addTypeMapping(TechnologicalProcessConditionEntity.class,
            new TechnologicalProcessConditionEntitySQLiteTypeMapping())
        // TechnologicalProcessStateEntity mapping
        .addTypeMapping(TechnologicalProcessStateEntity.class,
            new TechnologicalProcessStateEntitySQLiteTypeMapping())

        // OTHER
        // CropActiveComponentHarmfulObjectEntity mapping
        .addTypeMapping(CropActiveComponentHarmfulObjectEntity.class,
            new CropActiveComponentHarmfulObjectEntitySQLiteTypeMapping())
        // CropEntity mapping
        .addTypeMapping(CropEntity.class, new CropEntitySQLiteTypeMapping())
        // DealerEntity mapping
        .addTypeMapping(DealerEntity.class, new DealerEntitySQLiteTypeMapping())
        // FieldEntity mapping
        .addTypeMapping(FieldEntity.class, new FieldEntitySQLiteTypeMapping())
        // PhenologicalCharacteristicEntity mapping
        .addTypeMapping(PhenologicalCharacteristicEntity.class,
            new PhenologicalCharacteristicEntitySQLiteTypeMapping())
        // SoilTypeEntity mapping
        .addTypeMapping(SoilTypeEntity.class, new SoilTypeEntitySQLiteTypeMapping())
        // TillageDirectionEntity mapping
        .addTypeMapping(TillageDirectionEntity.class, new TillageDirectionEntitySQLiteTypeMapping())

        // CombinedFieldEntity mapping
        .addTypeMapping(CombinedFieldEntity.class,
            SQLiteTypeMapping.<CombinedFieldEntity>builder().putResolver(
                new CombinedFieldPutResolver())
                .getResolver(new CombinedFieldGetResolver())
                .deleteResolver(new CombinedFieldDeleteResolver())
                .build()).build();
  }

  @Provides @AppScope SQLiteOpenHelper provideSqLiteOpenHelper(Context context) {
    // TODO: 05.07.2017 need to remove deletion, tis just for test, a to ya zaebalsya 
    context.deleteDatabase(DbOpenHelper.DB_NAME);
    return new DbOpenHelper(context);
  }
}
