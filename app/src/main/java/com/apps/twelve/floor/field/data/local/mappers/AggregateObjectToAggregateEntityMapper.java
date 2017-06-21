package com.apps.twelve.floor.field.data.local.mappers;

import com.apps.twelve.floor.field.data.local.entities.solutions.AggregateEntity;
import com.apps.twelve.floor.field.data.local.objects.solutions.AggregateObject;

/**
 * Created by Yaroslav on 21.06.2017.
 */

public class AggregateObjectToAggregateEntityMapper
    implements Mapper<AggregateObject, AggregateEntity> {
  @Override public AggregateEntity transform(AggregateObject obj) throws RuntimeException {
    return AggregateEntity.newAggregateEntity(obj.getId(), obj.getName(), obj.getType().getId(),
        obj.getPrice());
  }
}
