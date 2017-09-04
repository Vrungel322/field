package com.apps.twelve.floor.field.data.local.mappers.conditions;

import com.apps.twelve.floor.field.data.local.entities.conditions.SoilTypeConditionValueEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.conditions.SoilTypeConditionValueObject;

/**
 * Created by yarrick on 07.07.17.
 */

public class SoilTypeConditionValueObjectToSoilTypeConditionValueEntityMapper
    implements Mapper<SoilTypeConditionValueObject, SoilTypeConditionValueEntity> {
  @Override public SoilTypeConditionValueEntity transform(SoilTypeConditionValueObject obj)
      throws RuntimeException {
    return SoilTypeConditionValueEntity.newSoilTypeValueEntity(obj.getId(), obj.getTypeId(),
        obj.getSoilTypeId());
  }
}
