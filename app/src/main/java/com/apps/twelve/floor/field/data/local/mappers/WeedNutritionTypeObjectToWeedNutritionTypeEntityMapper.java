package com.apps.twelve.floor.field.data.local.mappers;

import com.apps.twelve.floor.field.data.local.entities.conditions.WeedNutritionTypeEntity;
import com.apps.twelve.floor.field.data.local.objects.conditions.WeedNutritionTypeObject;

/**
 * Created by yarrick on 30.06.17.
 */

public class WeedNutritionTypeObjectToWeedNutritionTypeEntityMapper
    implements Mapper<WeedNutritionTypeObject, WeedNutritionTypeEntity> {
  @Override public WeedNutritionTypeEntity transform(WeedNutritionTypeObject obj)
      throws RuntimeException {
    return WeedNutritionTypeEntity.newWeedNutritionTypeEntity(obj.getId(), obj.getName());
  }
}
