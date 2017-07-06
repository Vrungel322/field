package com.apps.twelve.floor.field.data.local.mappers.conditions;

import com.apps.twelve.floor.field.data.local.entities.conditions.ConditionNameEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionNameObject;

/**
 * Created by Vrungel on 05.07.2017.
 */

public class ConditionNameObjectToConditionNameEntityMapper
    implements Mapper<ConditionNameObject, ConditionNameEntity> {
  @Override public ConditionNameEntity transform(ConditionNameObject obj) throws RuntimeException {
    return ConditionNameEntity.newConditionNameEntity(obj.getId(), obj.getName());
  }
}
