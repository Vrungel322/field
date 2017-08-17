package com.apps.twelve.floor.field.data.local.mappers.technological_map;

import com.apps.twelve.floor.field.data.local.entities.technological_map.FieldCropTechnologicalProcessConditionEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessConditionObject;

/**
 * Created by yarrick on 16.08.17.
 */

public class FieldCropTechnologicalProcessConditionObjectToFieldCropTechnologicalProcessConditionEntityMapper
    implements
    Mapper<FieldCropTechnologicalProcessConditionObject, FieldCropTechnologicalProcessConditionEntity> {
  @Override public FieldCropTechnologicalProcessConditionEntity transform(
      FieldCropTechnologicalProcessConditionObject obj) throws RuntimeException {
    return new FieldCropTechnologicalProcessConditionEntity(obj.getId(),
        obj.getTechnologicalProcessId(), obj.getConditionId(), obj.isFulfilled());
  }
}
