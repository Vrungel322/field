package com.apps.twelve.floor.field.data.local.mappers;

import com.apps.twelve.floor.field.data.local.entities.conditions.WeedEntity;
import com.apps.twelve.floor.field.data.local.objects.conditions.WeedObject;

/**
 * Created by Vrungel on 04.07.2017.
 */

public class WeedObjectToWeedEntityMapper implements Mapper<WeedObject, WeedEntity> {
  @Override public WeedEntity transform(WeedObject obj) throws RuntimeException {
    return WeedEntity.newWeedEntity(obj.getId(), obj.getHarmfulObjTypeId(), obj.getName(),
        obj.getNutritionTypeId(), obj.getClassId(), obj.getGroupId());
  }
}
