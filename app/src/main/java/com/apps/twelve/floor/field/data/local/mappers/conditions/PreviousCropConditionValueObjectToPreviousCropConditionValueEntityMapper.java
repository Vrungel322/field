package com.apps.twelve.floor.field.data.local.mappers.conditions;

import com.apps.twelve.floor.field.data.local.entities.conditions.PreviousCropConditionValueEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.conditions.PreviousCropConditionValueObject;

/**
 * Created by yarrick on 22.07.17.
 */
public class PreviousCropConditionValueObjectToPreviousCropConditionValueEntityMapper
    implements Mapper<PreviousCropConditionValueObject, PreviousCropConditionValueEntity> {
  @Override public PreviousCropConditionValueEntity transform(PreviousCropConditionValueObject obj)
      throws RuntimeException {
    return PreviousCropConditionValueEntity.newPreviousCropValueEntity(obj.getId(), obj.getTypeId(),
        obj.getCropId());
  }
}
