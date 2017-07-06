package com.apps.twelve.floor.field.data.local.mappers.conditions;

import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionTypeEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionTypeObject;

/**
 * Created by Yaroslav on 13.06.2017.
 */

public class ConditionTypeObjectToConditionTypeEntityMapper
    implements Mapper<ConditionTypeObject, ConditionTypeEntity> {
  @Override public ConditionTypeEntity transform(ConditionTypeObject obj) throws RuntimeException {
    return ConditionTypeEntity.newConditionTypeEntity(obj.getId(), obj.getName());
  }
}
