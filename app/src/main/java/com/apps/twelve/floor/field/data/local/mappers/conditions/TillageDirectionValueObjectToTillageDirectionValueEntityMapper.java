package com.apps.twelve.floor.field.data.local.mappers.conditions;

import com.apps.twelve.floor.field.data.local.entities.conditions.TillageDirectionValueEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.conditions.TillageDirectionValueObject;

/**
 * Created by yarrick on 06.07.17.
 */

public class TillageDirectionValueObjectToTillageDirectionValueEntityMapper
    implements Mapper<TillageDirectionValueObject, TillageDirectionValueEntity> {
  @Override public TillageDirectionValueEntity transform(TillageDirectionValueObject obj)
      throws RuntimeException {
    return TillageDirectionValueEntity.newTillageDirectionValueEntity(obj.getId(), obj.getTypeId(),
        obj.getTillageDirectionId());
  }
}
