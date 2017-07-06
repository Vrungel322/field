package com.apps.twelve.floor.field.data.local.mappers.solutions;

import com.apps.twelve.floor.field.data.local.entities.solutions.TechnologicalSolutionTypeEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.solutions.TechnologicalSolutionTypeObject;

/**
 * Created by Yaroslav on 21.06.2017.
 */

public class TechnologicalSolutionTypeObjectToTechnologicalSolutionTypeEntityMapper
    implements Mapper<TechnologicalSolutionTypeObject, TechnologicalSolutionTypeEntity> {
  @Override public TechnologicalSolutionTypeEntity transform(TechnologicalSolutionTypeObject obj)
      throws RuntimeException {
    return TechnologicalSolutionTypeEntity.newTechnologicalSolutionTypeEntity(obj.getId(),
        obj.getName());
  }
}
