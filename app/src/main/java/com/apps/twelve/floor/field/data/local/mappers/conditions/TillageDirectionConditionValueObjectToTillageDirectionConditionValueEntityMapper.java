package com.apps.twelve.floor.field.data.local.mappers.conditions;

import com.apps.twelve.floor.field.data.local.entities.conditions.TillageDirectionConditionValueEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.conditions.TillageDirectionConditionValueObject;

/**
 * Created by yarrick on 06.07.17.
 */

public class TillageDirectionConditionValueObjectToTillageDirectionConditionValueEntityMapper
    implements Mapper<TillageDirectionConditionValueObject, TillageDirectionConditionValueEntity> {
  @Override
  public TillageDirectionConditionValueEntity transform(TillageDirectionConditionValueObject obj)
      throws RuntimeException {
    return TillageDirectionConditionValueEntity.newTillageDirectionValueEntity(obj.getId(),
        obj.getTypeId(),
        obj.getTillageDirectionId());
  }
}
