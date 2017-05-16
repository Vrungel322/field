package com.apps.twelve.floor.field.mvp.data.local.mappers;

import com.apps.twelve.floor.field.mvp.data.local.entities.CropEntity;
import com.apps.twelve.floor.field.mvp.data.local.objects.CropObject;

/**
 * Created by Yaroslav on 16.05.2017.
 */

public class CropObjectToCropEntity implements Mapper<CropObject, CropEntity> {
  @Override public CropEntity transform(CropObject obj) throws RuntimeException {
    return CropEntity.newCropEntity(obj.getId(), obj.getName(), obj.getParentId(), obj.isGroup());
  }
}
