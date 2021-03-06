package com.apps.twelve.floor.field.data.local.mappers.harmful_objects;

import com.apps.twelve.floor.field.data.local.entities.harmful_objects.HarmfulObjectPhaseEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.HarmfulObjectPhaseObject;

/**
 * Created by yarrick on 06.07.17.
 *
 */

public class HarmfulObjectPhaseObjectToHarmfulObjectPhaseEntityMapper
    implements Mapper<HarmfulObjectPhaseObject, HarmfulObjectPhaseEntity> {

  @Override public HarmfulObjectPhaseEntity transform(HarmfulObjectPhaseObject obj)
      throws RuntimeException {
    return HarmfulObjectPhaseEntity.newHarmfulObjectPhaseEntity(obj.getId(), obj.getName());
  }
}
