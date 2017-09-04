package com.apps.twelve.floor.field.data.local.mappers.conditions;

import com.apps.twelve.floor.field.data.local.entities.conditions.SpanConditionValueEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.conditions.SpanConditionValueObject;

/**
 * Created by Vrungel on 21.06.2017.
 */

public class SpanConditionConditionValueObjectToSpanConditionConditionValueEntityMapper
    implements Mapper<SpanConditionValueObject, SpanConditionValueEntity> {
  @Override public SpanConditionValueEntity transform(SpanConditionValueObject obj)
      throws RuntimeException {
    return SpanConditionValueEntity.newConditionSpanValueEntity(obj.getId(), obj.getTypeId(),
        obj.getValueFrom(), obj.getValueTo());
  }
}
