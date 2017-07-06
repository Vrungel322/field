package com.apps.twelve.floor.field.data.local.mappers.solutions;

import com.apps.twelve.floor.field.data.local.entities.solutions.ActiveComponentEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.solutions.ActiveComponentObject;

/**
 * Created by yarrick on 06.07.17.
 */

public class ActiveComponentObjectToActiveComponentEntityMapper
    implements Mapper<ActiveComponentObject, ActiveComponentEntity> {
  @Override public ActiveComponentEntity transform(ActiveComponentObject obj)
      throws RuntimeException {
    return ActiveComponentEntity.newActiveComponentEntity(obj.getId(), obj.getName(),
        obj.getTypeId());
  }
}
