package com.apps.twelve.floor.field.data.local.mappers.conditions;

import com.apps.twelve.floor.field.data.local.entities.conditions.PhenologicalCharacteristicValueEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.conditions.PhenologicalCharacteristicValueObject;

/**
 * Created by yarrick on 07.07.17.
 */

public class PhenologicalCharacteristicValueObjectToPhenologicalCharacteristicValueEntityMapper
    implements
    Mapper<PhenologicalCharacteristicValueObject, PhenologicalCharacteristicValueEntity> {
  @Override
  public PhenologicalCharacteristicValueEntity transform(PhenologicalCharacteristicValueObject obj)
      throws RuntimeException {
    return PhenologicalCharacteristicValueEntity.newPhenologicalCharacteristicValueEntity(
        obj.getId(), obj.getTypeId(), obj.getPhenologicalCharacteristicId());
  }
}
