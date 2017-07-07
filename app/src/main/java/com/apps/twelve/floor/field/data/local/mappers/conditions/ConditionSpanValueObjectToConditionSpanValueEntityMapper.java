package com.apps.twelve.floor.field.data.local.mappers.conditions;

import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionSpanValueEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionSpanValueObject;

/**
 * Created by Vrungel on 21.06.2017.
 */

public class ConditionSpanValueObjectToConditionSpanValueEntityMapper
    implements Mapper<ConditionSpanValueObject, ConditionSpanValueEntity> {
  @Override public ConditionSpanValueEntity transform(ConditionSpanValueObject obj)
      throws RuntimeException {
    return ConditionSpanValueEntity.newConditionSpanValueEntity(obj.getId(), obj.getTypeId(),
        obj.getValueFrom(), obj.getValueTo());
  }
}
