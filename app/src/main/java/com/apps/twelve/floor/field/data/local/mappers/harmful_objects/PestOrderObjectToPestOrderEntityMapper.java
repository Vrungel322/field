package com.apps.twelve.floor.field.data.local.mappers.harmful_objects;

import com.apps.twelve.floor.field.data.local.entities.harmful_objects.PestOrderEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.PestOrderObject;

/**
 * Created by yarrick on 10.07.17.
 */

public class PestOrderObjectToPestOrderEntityMapper
    implements Mapper<PestOrderObject, PestOrderEntity> {
  @Override public PestOrderEntity transform(PestOrderObject obj) throws RuntimeException {
    return PestOrderEntity.newPestOrderEntity(obj.getId(), obj.getName());
  }
}
