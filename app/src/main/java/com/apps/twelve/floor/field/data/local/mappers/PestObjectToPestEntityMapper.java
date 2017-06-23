package com.apps.twelve.floor.field.data.local.mappers;

import com.apps.twelve.floor.field.data.local.entities.conditions.PestEntity;
import com.apps.twelve.floor.field.data.local.objects.conditions.PestObject;

/**
 * Created by Yaroslav on 20.06.2017.
 */

public class PestObjectToPestEntityMapper implements Mapper<PestObject, PestEntity> {
  @Override public PestEntity transform(PestObject obj) throws RuntimeException {
    return new PestEntity(obj.getId(), obj.getName(), obj.getConditionType().getId(),
        obj.getParentId(), obj.isGroup());
  }
}
