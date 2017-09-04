package com.apps.twelve.floor.field.data.local.mappers.conditions;

import com.apps.twelve.floor.field.data.local.entities.conditions.PhenologicalCharacteristicConditionValueEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.conditions.PhenologicalCharacteristicConditionValueObject;

/**
 * Created by yarrick on 07.07.17.
 */

public class PhenologicalCharacteristicConditionValueObjectToPhenologicalCharacteristicConditionValueEntityMapper
    implements
    Mapper<PhenologicalCharacteristicConditionValueObject, PhenologicalCharacteristicConditionValueEntity> {
  @Override public PhenologicalCharacteristicConditionValueEntity transform(
      PhenologicalCharacteristicConditionValueObject obj)
      throws RuntimeException {
    return PhenologicalCharacteristicConditionValueEntity.newPhenologicalCharacteristicValueEntity(
        obj.getId(), obj.getTypeId(), obj.getPhenologicalCharacteristicId());
  }
}
