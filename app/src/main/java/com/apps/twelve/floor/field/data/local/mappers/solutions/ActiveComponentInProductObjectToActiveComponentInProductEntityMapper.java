package com.apps.twelve.floor.field.data.local.mappers.solutions;

import com.apps.twelve.floor.field.data.local.entities.solutions.ActiveComponentInProductEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.solutions.ActiveComponentInProductObject;

/**
 * Created by yarrick on 06.07.17.
 */

public class ActiveComponentInProductObjectToActiveComponentInProductEntityMapper
    implements Mapper<ActiveComponentInProductObject, ActiveComponentInProductEntity> {
  @Override public ActiveComponentInProductEntity transform(ActiveComponentInProductObject obj)
      throws RuntimeException {
    return ActiveComponentInProductEntity.newActiveComponentInProductEntity(obj.getId(),
        obj.getProductId(), obj.getActiveComponentId(), obj.getDoze());
  }
}
