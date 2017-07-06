package com.apps.twelve.floor.field.data.local.mappers.harmful_objects;

import com.apps.twelve.floor.field.data.local.entities.harmful_objects.HarmfulObjectTypeEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.HarmfulObjectTypeObject;

/**
 * Created by yarrick on 04.07.17.
 */

public class HarmfulObjectTypeObjectToHarmfulObjectTypeEntityMapper
    implements Mapper<HarmfulObjectTypeObject, HarmfulObjectTypeEntity> {
  @Override public HarmfulObjectTypeEntity transform(HarmfulObjectTypeObject obj)
      throws RuntimeException {
    return HarmfulObjectTypeEntity.newHarmfulObjectTypeEntity(obj.getId(), obj.getName());
  }
}
