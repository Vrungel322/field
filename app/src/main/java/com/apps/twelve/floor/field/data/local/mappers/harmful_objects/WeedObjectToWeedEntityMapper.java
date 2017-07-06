package com.apps.twelve.floor.field.data.local.mappers.harmful_objects;

import com.apps.twelve.floor.field.data.local.entities.harmful_objects.WeedEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.WeedObject;

/**
 * Created by Vrungel on 04.07.2017.
 */

public class WeedObjectToWeedEntityMapper implements Mapper<WeedObject, WeedEntity> {
  @Override public WeedEntity transform(WeedObject obj) throws RuntimeException {
    return WeedEntity.newWeedEntity(obj.getId(), obj.getHarmfulObjTypeId(), obj.getName(),
        obj.getNutritionTypeId(), obj.getClassId(), obj.getGroupId());
  }
}
