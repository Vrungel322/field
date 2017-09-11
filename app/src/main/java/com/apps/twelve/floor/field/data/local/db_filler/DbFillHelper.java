package com.apps.twelve.floor.field.data.local.db_filler;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.data.local.DbHelper;
import com.apps.twelve.floor.field.data.local.entities.CropEntity;
import com.apps.twelve.floor.field.data.local.entities.FieldEntity;
import com.apps.twelve.floor.field.data.local.entities.IEntity;
import com.apps.twelve.floor.field.data.local.entities.PhenologicalCharacteristicEntity;
import com.apps.twelve.floor.field.data.local.entities.SoilTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.TillageDirectionEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionNameEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.HarmfulObjectConditionValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.HarmfulObjectPhaseConditionValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.PhenologicalCharacteristicConditionValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.PreviousCropConditionValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.SoilTypeConditionValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.SpanConditionValueEntity;
import com.apps.twelve.floor.field.data.local.entities.conditions.TillageDirectionConditionValueEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.DiseaseEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.DiseasePathogenTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.HarmfulObjectEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.HarmfulObjectPhaseEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.HarmfulObjectTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.PestClassEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.PestEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.PestOrderEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.WeedClassEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.WeedEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.WeedGroupEntity;
import com.apps.twelve.floor.field.data.local.entities.harmful_objects.WeedNutritionTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.process_time.ClimateZoneEntity;
import com.apps.twelve.floor.field.data.local.entities.process_time.PhaseEntity;
import com.apps.twelve.floor.field.data.local.entities.process_time.ProcessPeriodEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.ActiveComponentEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.ActiveComponentInProductEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.AggregateEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.InsectEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.ProductCategoryEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.ProductEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.TechnologicalSolutionEntity;
import com.apps.twelve.floor.field.data.local.entities.solutions.TechnologicalSolutionTypeEntity;
import com.apps.twelve.floor.field.data.local.entities.technological_map.CropTechnologicalProcessEntity;
import com.apps.twelve.floor.field.data.local.entities.technological_map.CropTechnologicalProcessesSequenceEntity;
import com.apps.twelve.floor.field.data.local.entities.technological_map.TechnologicalProcessConditionEntity;
import com.apps.twelve.floor.field.data.local.entities.technological_map.TechnologicalProcessStateEntity;
import com.google.gson.Gson;
import javax.inject.Inject;
import timber.log.Timber;

/**
 * Created by yarrick on 01.08.17.
 * A class to fill DB with initial data (from JSON-file in assets)
 */

public class DbFillHelper {
  @Inject Gson mGson;
  @Inject DbHelper mDbHelper;
  @Inject AssetHelper mAssetHelper;

  public DbFillHelper() {
    App.getAppComponent().inject(this);
  }

  public boolean fillDbWithInitialData() {
    String json = mAssetHelper.readStringFromAssetFile(AssetHelper.ASSET_INITIAL_DB_DATA_V1);
    boolean isOk = deserializeEntitiesFromJson(json);

    // TODO: this is for tests only - remove it
    fillDbWithTestData();

    return isOk;
  }

  /**
   * This is for tests only
   */
  //TODO: for tests only - remove after
  public boolean fillDbWithTestData() {
    String testJson = mAssetHelper.readStringFromAssetFile("test_db_data_v1.json");
    return deserializeEntitiesFromJson(testJson);
  }

  private boolean deserializeEntitiesFromJson(String json) {
    MetaEntity[] metaEntities = mGson.fromJson(json, MetaEntity[].class);

    DbHelperDelegate dbHelperDelegate = new DbHelperDelegate();
    for (int i = 0; i < metaEntities.length; i++) {
      dbHelperDelegate.putEntitiesInDb(metaEntities[i].getEntitiesArray());
    }

    return true;
  }

  private class DbHelperDelegate {

    private boolean putEntitiesInDb(IEntity[] entities) {
      if (entities == null) {
        Timber.e("Got null entities from json");
        return false;
      }
      for (IEntity entity : entities) {
        putEntityInDb(entity);
      }

      return true;
    }

    void putEntityInDb(IEntity entity) {
      if (entity instanceof TechnologicalSolutionTypeEntity) {
        mDbHelper.putTechnologicalSolutionType((TechnologicalSolutionTypeEntity) entity);
      } else if (entity instanceof ProductCategoryEntity) {
        mDbHelper.putProductCategory((ProductCategoryEntity) entity);
      } else if (entity instanceof ProductEntity) {
        mDbHelper.putProduct((ProductEntity) entity);
      } else if (entity instanceof AggregateEntity) {
        mDbHelper.putAggregate((AggregateEntity) entity);
      } else if (entity instanceof ActiveComponentEntity) {
        mDbHelper.putActiveComponent((ActiveComponentEntity) entity);
      } else if (entity instanceof InsectEntity) {
        mDbHelper.putInsect((InsectEntity) entity);
      } else if (entity instanceof ActiveComponentInProductEntity) {
        mDbHelper.putActiveComponentInProduct((ActiveComponentInProductEntity) entity);
      } else if (entity instanceof TechnologicalSolutionEntity) {
        mDbHelper.putTechnologicalSolution((TechnologicalSolutionEntity) entity);
      } else if (entity instanceof HarmfulObjectTypeEntity) {
        mDbHelper.putHarmfulObjectType((HarmfulObjectTypeEntity) entity);
      } else if (entity instanceof WeedNutritionTypeEntity) {
        mDbHelper.putWeedNutritionType((WeedNutritionTypeEntity) entity);
      } else if (entity instanceof WeedClassEntity) {
        mDbHelper.putWeedClass((WeedClassEntity) entity);
      } else if (entity instanceof WeedGroupEntity) {
        mDbHelper.putWeedGroup((WeedGroupEntity) entity);
      } else if (entity instanceof WeedEntity) {
        mDbHelper.putWeed((WeedEntity) entity);
      } else if (entity instanceof PestClassEntity) {
        mDbHelper.putPestClass((PestClassEntity) entity);
      } else if (entity instanceof PestOrderEntity) {
        mDbHelper.putPestOrder((PestOrderEntity) entity);
      } else if (entity instanceof PestEntity) {
        mDbHelper.putPest((PestEntity) entity);
      } else if (entity instanceof HarmfulObjectEntity) {
        mDbHelper.putHarmfulObject((HarmfulObjectEntity) entity);
      } else if (entity instanceof HarmfulObjectPhaseEntity) {
        mDbHelper.putHarmfulObjectPhase((HarmfulObjectPhaseEntity) entity);
      } else if (entity instanceof CropEntity) {
        mDbHelper.putCrop((CropEntity) entity);
      } else if (entity instanceof SoilTypeEntity) {
        mDbHelper.putSoilType((SoilTypeEntity) entity);
      } else if (entity instanceof TillageDirectionEntity) {
        mDbHelper.putTillageDirection((TillageDirectionEntity) entity);
      } else if (entity instanceof PhenologicalCharacteristicEntity) {
        mDbHelper.putPhenologicalCharacteristic((PhenologicalCharacteristicEntity) entity);
      } else if (entity instanceof ClimateZoneEntity) {
        mDbHelper.putClimateZone((ClimateZoneEntity) entity);
      } else if (entity instanceof PhaseEntity) {
        mDbHelper.putPhase((PhaseEntity) entity);
      } else if (entity instanceof ProcessPeriodEntity) {
        mDbHelper.putProcessPeriod((ProcessPeriodEntity) entity);
      } else if (entity instanceof ConditionNameEntity) {
        mDbHelper.putConditionName((ConditionNameEntity) entity);
      } else if (entity instanceof ConditionTypeEntity) {
        mDbHelper.putConditionType((ConditionTypeEntity) entity);
      } else if (entity instanceof PreviousCropConditionValueEntity) {
        mDbHelper.putPreviousCropValue((PreviousCropConditionValueEntity) entity);
      } else if (entity instanceof SpanConditionValueEntity) {
        mDbHelper.putConditionSpanValue((SpanConditionValueEntity) entity);
      } else if (entity instanceof SoilTypeConditionValueEntity) {
        mDbHelper.putSoilTypeValue((SoilTypeConditionValueEntity) entity);
      } else if (entity instanceof HarmfulObjectConditionValueEntity) {
        mDbHelper.putHarmfulObjectValue((HarmfulObjectConditionValueEntity) entity);
      } else if (entity instanceof HarmfulObjectPhaseConditionValueEntity) {
        mDbHelper.putHarmfulObjectPhaseValue((HarmfulObjectPhaseConditionValueEntity) entity);
      } else if (entity instanceof TillageDirectionConditionValueEntity) {
        mDbHelper.putTillageDirectionValue((TillageDirectionConditionValueEntity) entity);
      } else if (entity instanceof PhenologicalCharacteristicConditionValueEntity) {
        mDbHelper.putPhenologicalCharacteristicValue(
            (PhenologicalCharacteristicConditionValueEntity) entity);
      } else if (entity instanceof ConditionEntity) {
        mDbHelper.putCondition((ConditionEntity) entity);
      } else if (entity instanceof TechnologicalProcessStateEntity) {
        mDbHelper.putTechnologicalProcessState((TechnologicalProcessStateEntity) entity);
      } else if (entity instanceof CropTechnologicalProcessEntity) {
        mDbHelper.putCropTechnologicalProcess((CropTechnologicalProcessEntity) entity);
      } else if (entity instanceof TechnologicalProcessConditionEntity) {
        mDbHelper.putTechnologicalProcessesCondition((TechnologicalProcessConditionEntity) entity);
      } else if (entity instanceof CropTechnologicalProcessesSequenceEntity) {
        mDbHelper.putCropTechnologicalProcessesSequence(
            (CropTechnologicalProcessesSequenceEntity) entity);
      } else if (entity instanceof DiseasePathogenTypeEntity) {
        mDbHelper.putDiseasePathogenType((DiseasePathogenTypeEntity) entity);
      } else if (entity instanceof DiseaseEntity) {
        mDbHelper.putDisease((DiseaseEntity) entity);
      } else if (entity instanceof FieldEntity) {
        mDbHelper.putField((FieldEntity) entity);
      } else {
        Timber.e("Got unknown entity: " + entity.getClass().getSimpleName());
      }
    }
  }
}
