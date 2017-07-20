package com.apps.twelve.floor.field.data.local.mappers.harmful_objects;

import com.apps.twelve.floor.field.data.local.entities.harmful_objects.HarmfulObjectPhaseNameEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.HarmfulObjectPhaseNameObject;

/**
 * Created by yarrick on 20.07.17.
 */

public class HarmfulObjectPhaseNameObjectToHarmfulObjectPhaseNameEntityMapper
    implements Mapper<HarmfulObjectPhaseNameObject, HarmfulObjectPhaseNameEntity> {
  @Override public HarmfulObjectPhaseNameEntity transform(HarmfulObjectPhaseNameObject obj)
      throws RuntimeException {
    return HarmfulObjectPhaseNameEntity.newHarmfulObjectPhaseNameEntity(obj.getId(), obj.getName());
  }
}
