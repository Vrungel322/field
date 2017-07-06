package com.apps.twelve.floor.field.data.local.mappers;

import com.apps.twelve.floor.field.data.local.entities.conditions.HarmfulObjectPhaseEntity;
import com.apps.twelve.floor.field.data.local.objects.conditions.HarmfulObjectPhaseObject;

/**
 * Created by yarrick on 06.07.17.
 */

public class HarmfulObjectPhaseObjectToHarmfulObjectPhaseEntityMapper
    implements Mapper<HarmfulObjectPhaseObject, HarmfulObjectPhaseEntity> {
  @Override public HarmfulObjectPhaseEntity transform(HarmfulObjectPhaseObject obj)
      throws RuntimeException {
    return HarmfulObjectPhaseEntity.newHarmfulObjectPhaseEntity(obj.getId(), obj.getName(),
        obj.getHarmfulObjectId());
  }
}
