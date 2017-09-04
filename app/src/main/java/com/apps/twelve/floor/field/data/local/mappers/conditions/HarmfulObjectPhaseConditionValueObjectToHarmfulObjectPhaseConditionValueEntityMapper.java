package com.apps.twelve.floor.field.data.local.mappers.conditions;

import com.apps.twelve.floor.field.data.local.entities.conditions.HarmfulObjectPhaseConditionValueEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.conditions.HarmfulObjectPhaseConditionValueObject;

/**
 * Created by yarrick on 19.07.17.
 */

public class HarmfulObjectPhaseConditionValueObjectToHarmfulObjectPhaseConditionValueEntityMapper
    implements
    Mapper<HarmfulObjectPhaseConditionValueObject, HarmfulObjectPhaseConditionValueEntity> {
  @Override public HarmfulObjectPhaseConditionValueEntity transform(
      HarmfulObjectPhaseConditionValueObject obj)
      throws RuntimeException {
    return HarmfulObjectPhaseConditionValueEntity.newHarmfulObjectPhaseValueEntity(obj.getId(),
        obj.getConditionTypeId(), obj.getHarmfulObjectPhaseId());
  }
}
