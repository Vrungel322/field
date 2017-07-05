package com.apps.twelve.floor.field.data.local.mappers;

import com.apps.twelve.floor.field.data.local.entities.conditions.HarmfulObjectTypeEntity;
import com.apps.twelve.floor.field.data.local.objects.conditions.HarmfulObjectTypeObject;

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
