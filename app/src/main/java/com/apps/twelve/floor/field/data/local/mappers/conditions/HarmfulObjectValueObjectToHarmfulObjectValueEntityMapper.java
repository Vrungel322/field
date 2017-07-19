package com.apps.twelve.floor.field.data.local.mappers.conditions;

import com.apps.twelve.floor.field.data.local.entities.conditions.HarmfulObjectValueEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.conditions.HarmfulObjectValueObject;

/**
 * Created by yarrick on 19.07.17.
 */

public class HarmfulObjectValueObjectToHarmfulObjectValueEntityMapper
    implements Mapper<HarmfulObjectValueObject, HarmfulObjectValueEntity> {
  @Override public HarmfulObjectValueEntity transform(HarmfulObjectValueObject obj)
      throws RuntimeException {
    return HarmfulObjectValueEntity.newHarmfulObjectValueEntity(obj.getId(), obj.getTypeId(),
        obj.getHarmfulObjectId());
  }
}
