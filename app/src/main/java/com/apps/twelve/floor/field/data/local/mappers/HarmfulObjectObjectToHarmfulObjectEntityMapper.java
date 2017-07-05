package com.apps.twelve.floor.field.data.local.mappers;

import com.apps.twelve.floor.field.data.local.entities.conditions.HarmfulObjectEntity;
import com.apps.twelve.floor.field.data.local.objects.conditions.HarmfulObjectObject;

/**
 * Created by yarrick on 05.07.17.
 */

public class HarmfulObjectObjectToHarmfulObjectEntityMapper
    implements Mapper<HarmfulObjectObject, HarmfulObjectEntity> {
  @Override public HarmfulObjectEntity transform(HarmfulObjectObject obj) throws RuntimeException {
    return HarmfulObjectEntity.newHarmfulObjectEntity(obj.getId(), obj.getTypeId(),
        obj.getValueId());
  }
}
