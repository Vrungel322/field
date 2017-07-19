package com.apps.twelve.floor.field.data.local.mappers.conditions;

import com.apps.twelve.floor.field.data.local.entities.conditions.HarmfulObjectPhaseValueEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.conditions.HarmfulObjectPhaseValueObject;

/**
 * Created by yarrick on 19.07.17.
 */

public class HarmfulObjectPhaseValueObjectToHarmfulObjectPhaseValueEntityMapper
    implements Mapper<HarmfulObjectPhaseValueObject, HarmfulObjectPhaseValueEntity> {
  @Override public HarmfulObjectPhaseValueEntity transform(HarmfulObjectPhaseValueObject obj)
      throws RuntimeException {
    return HarmfulObjectPhaseValueEntity.newHarmfulObjectPhaseValueEntity(obj.getId(),
        obj.getConditionTypeId(), obj.getHarmfulObjectPhaseId());
  }
}
