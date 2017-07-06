package com.apps.twelve.floor.field.data.local.mappers.harmful_objects;

import com.apps.twelve.floor.field.data.local.entities.harmful_objects.WeedNutritionTypeEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.WeedNutritionTypeObject;

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
