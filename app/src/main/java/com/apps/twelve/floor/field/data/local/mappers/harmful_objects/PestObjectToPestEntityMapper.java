package com.apps.twelve.floor.field.data.local.mappers.harmful_objects;

import com.apps.twelve.floor.field.data.local.entities.harmful_objects.PestEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.PestObject;

/**
 * Created by Yaroslav on 20.06.2017.
 */

public class PestObjectToPestEntityMapper implements Mapper<PestObject, PestEntity> {
  @Override public PestEntity transform(PestObject obj) throws RuntimeException {
    return new PestEntity(obj.getId(), obj.getName(), obj.getConditionType().getId(),
        obj.getParentId(), obj.isGroup());
  }
}
