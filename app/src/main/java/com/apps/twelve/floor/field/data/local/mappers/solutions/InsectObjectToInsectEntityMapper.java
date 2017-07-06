package com.apps.twelve.floor.field.data.local.mappers.solutions;

import com.apps.twelve.floor.field.data.local.entities.solutions.InsectEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.solutions.InsectObject;

/**
 * Created by Yaroslav on 22.06.2017.
 */

public class InsectObjectToInsectEntityMapper implements Mapper<InsectObject, InsectEntity> {
  @Override public InsectEntity transform(InsectObject obj) throws RuntimeException {
    return InsectEntity.newInsectEntity(obj.getId(), obj.getName(), obj.getType().getId(),
        obj.getPrice());
  }
}
