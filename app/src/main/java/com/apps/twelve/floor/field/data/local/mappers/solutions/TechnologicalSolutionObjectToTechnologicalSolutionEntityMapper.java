package com.apps.twelve.floor.field.data.local.mappers.solutions;

import com.apps.twelve.floor.field.data.local.entities.solutions.TechnologicalSolutionEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.solutions.TechnologicalSolutionObject;

/**
 * Created by yarrick on 12.07.17.
 */

public class TechnologicalSolutionObjectToTechnologicalSolutionEntityMapper
    implements Mapper<TechnologicalSolutionObject, TechnologicalSolutionEntity> {
  @Override public TechnologicalSolutionEntity transform(TechnologicalSolutionObject obj)
      throws RuntimeException {
    return TechnologicalSolutionEntity.newTechnologicalSolutionEntity(obj.getId(), obj.getName(),
        obj.getSolutionTypeId(), obj.getSolutionValueId());
  }
}
