package com.apps.twelve.floor.field.data.local.mappers;

import com.apps.twelve.floor.field.data.local.entities.TillageDirectionEntity;
import com.apps.twelve.floor.field.data.local.objects.TillageDirectionObject;

/**
 * Created by Yaroslav on 20.06.2017.
 */

public class TillageDirectionObjectToTillageDirectionEntityMapper
    implements Mapper<TillageDirectionObject, TillageDirectionEntity> {
  @Override public TillageDirectionEntity transform(TillageDirectionObject obj)
      throws RuntimeException {
    return new TillageDirectionEntity(obj.getId(), obj.getName());
  }
}
