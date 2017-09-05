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
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionTypeEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.conditions.HarmfulObjectConditionValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.HarmfulObjectConditionValueEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.conditions.HarmfulObjectPhaseConditionValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.HarmfulObjectPhaseConditionValueEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.conditions.PhenologicalCharacteristicConditionValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.PhenologicalCharacteristicConditionValueEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.conditions.PreviousCropConditionValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.PreviousCropConditionValueEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.conditions.SoilTypeConditionValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.SoilTypeConditionValueEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.conditions.SpanConditionValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.SpanConditionValueEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.conditions.TillageDirectionConditionValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.TillageDirectionConditionValueEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.DiseaseEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.DiseaseEntitySQLiteTypeMapping;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.DiseasePathogenTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.DiseasePathogenTypeEntitySQLiteTypeMapping;
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
        // SpanConditionValueEntity mapping
        .addTypeMapping(SpanConditionValueEntity.class,
            new SpanConditionValueEntitySQLiteTypeMapping())
        // ConditionTypeEntity mapping
        .addTypeMapping(ConditionTypeEntity.class, new ConditionTypeEntitySQLiteTypeMapping())
        // HarmfulObjectPhaseConditionValueEntity mapping
        .addTypeMapping(HarmfulObjectPhaseConditionValueEntity.class,
            new HarmfulObjectPhaseConditionValueEntitySQLiteTypeMapping())
        // HarmfulObjectConditionValueEntity mapping
        .addTypeMapping(HarmfulObjectConditionValueEntity.class,
            new HarmfulObjectConditionValueEntitySQLiteTypeMapping())
        // PhenologicalCharacteristicConditionValueEntity mapping
        .addTypeMapping(PhenologicalCharacteristicConditionValueEntity.class,
            new PhenologicalCharacteristicConditionValueEntitySQLiteTypeMapping())
        // SoilTypeConditionValueEntity mapping
        .addTypeMapping(SoilTypeConditionValueEntity.class,
            new SoilTypeConditionValueEntitySQLiteTypeMapping())
        // TillageDirectionConditionValueEntity mapping
        .addTypeMapping(TillageDirectionConditionValueEntity.class,
            new TillageDirectionConditionValueEntitySQLiteTypeMapping())
        // PreviousCropConditionValueEntity mapping
        .addTypeMapping(PreviousCropConditionValueEntity.class,
            new PreviousCropConditionValueEntitySQLiteTypeMapping())

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
        // DiseasePathogenTypeEntity mapping
        .addTypeMapping(DiseasePathogenTypeEntity.class,
            new DiseasePathogenTypeEntitySQLiteTypeMapping())
        // DiseaseEntity mapping
        .addTypeMapping(DiseaseEntity.class, new DiseaseEntitySQLiteTypeMapping())

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
    // TODO: 05.07.2017 need to remove deletion, tis just for test
    context.deleteDatabase(DbOpenHelper.DB_NAME);
    return new DbOpenHelper(context);
  }
}
