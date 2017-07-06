package com.apps.twelve.floor.field.data.local.mappers.harmful_objects;

import com.apps.twelve.floor.field.data.local.entities.harmful_objects.HarmfulObjectEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.HarmfulObjectObject;

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
