package com.apps.twelve.floor.field.data.local.mappers.conditions;

import com.apps.twelve.floor.field.data.local.entities.conditions.HarmfulObjectConditionValueEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.conditions.HarmfulObjectConditionValueObject;

/**
 * Created by yarrick on 19.07.17.
 */

public class HarmfulObjectConditionValueObjectToHarmfulObjectConditionValueEntityMapper
    implements Mapper<HarmfulObjectConditionValueObject, HarmfulObjectConditionValueEntity> {
  @Override
  public HarmfulObjectConditionValueEntity transform(HarmfulObjectConditionValueObject obj)
      throws RuntimeException {
    return HarmfulObjectConditionValueEntity.newHarmfulObjectValueEntity(obj.getId(),
        obj.getTypeId(),
        obj.getHarmfulObjectId());
  }
}
