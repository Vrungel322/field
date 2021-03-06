package com.apps.twelve.floor.field.data.local.mappers.conditions;

import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionObject;

/**
 * Created by Vrungel on 21.06.2017.
 */

public class ConditionObjectToConditionEntityMapper
    implements Mapper<ConditionObject, ConditionEntity> {
  @Override public ConditionEntity transform(ConditionObject obj) throws RuntimeException {
    return ConditionEntity.newConditionEntity(obj.getId(), obj.getPriority(), obj.getNameId(),
        obj.getConditionTypeId(), obj.getConditionValueId());
  }
}

