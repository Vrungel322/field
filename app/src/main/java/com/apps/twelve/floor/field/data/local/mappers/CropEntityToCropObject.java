package com.apps.twelve.floor.field.data.local.mappers;

import android.support.annotation.Nullable;
import com.apps.twelve.floor.field.data.local.entities.CropEntity;
import com.apps.twelve.floor.field.data.local.objects.CropObject;

/**
 * Created by Yaroslav on 12.05.2017.
 */

public class CropEntityToCropObject implements Mapper<CropEntity, CropObject> {

  @Nullable @Override public CropObject transform(CropEntity entity) throws RuntimeException {
    if (entity == null) return null;
    return new CropObject(entity.getId(), entity.getName(), entity.getParentId(), entity.isGroup());
  }
}
