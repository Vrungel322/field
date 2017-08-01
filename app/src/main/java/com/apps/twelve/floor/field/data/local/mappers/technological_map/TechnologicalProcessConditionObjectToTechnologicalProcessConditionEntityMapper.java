package com.apps.twelve.floor.field.data.local.mappers.technological_map;

import com.apps.twelve.floor.field.data.local.entities.technological_map.TechnologicalProcessConditionEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.technological_map.TechnologicalProcessConditionObject;

/**
 * Created by yarrick on 27.07.17.
 */

public class TechnologicalProcessConditionObjectToTechnologicalProcessConditionEntityMapper
    implements Mapper<TechnologicalProcessConditionObject, TechnologicalProcessConditionEntity> {
  @Override
  public TechnologicalProcessConditionEntity transform(TechnologicalProcessConditionObject obj)
      throws RuntimeException {
    return TechnologicalProcessConditionEntity.newTechnologicalProcessesConditionEntity(obj.getId(),
        obj.getSetId(), obj.getProcessId(), obj.getConditionId());
  }
}
