package com.apps.twelve.floor.field.data.local.mappers.harmful_objects;

import com.apps.twelve.floor.field.data.local.entities.harmful_objects.WeedGroupEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.WeedGroupObject;

/**
 * Created by yarrick on 30.06.17.
 */

public class WeedGroupObjectToWeedGroupEntityMapper
    implements Mapper<WeedGroupObject, WeedGroupEntity> {
  @Override public WeedGroupEntity transform(WeedGroupObject obj) throws RuntimeException {
    return WeedGroupEntity.newWeedGroupEntity(obj.getId(), obj.getName(), obj.getParentId(),
        obj.isGroup());
  }
}
