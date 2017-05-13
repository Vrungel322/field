package com.apps.twelve.floor.field.mvp.data.local.mappers;

import com.apps.twelve.floor.field.mvp.data.local.entities.CropEntity;
import com.apps.twelve.floor.field.mvp.data.local.objects.CropObject;

/**
 * Created by Yaroslav on 12.05.2017.
 */

public class CropEntityToCropObject implements Mapper<CropEntity, CropObject> {

  @Override public CropObject transform(CropEntity entity) throws RuntimeException {
    return new CropObject(entity.getId(), entity.getName(), entity.getParentId(), entity.isGroup());
  }
}
