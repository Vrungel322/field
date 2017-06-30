package com.apps.twelve.floor.field.data.local.mappers;

import com.apps.twelve.floor.field.data.local.entities.conditions.WeedGroupEntity;
import com.apps.twelve.floor.field.data.local.objects.conditions.WeedGroupObject;

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
