package com.apps.twelve.floor.field.data.local.mappers;

import com.apps.twelve.floor.field.data.local.entities.conditions.PhenologicalCharacteristicEntity;
import com.apps.twelve.floor.field.data.local.objects.conditions.PhenologicalCharacteristicObject;

/**
 * Created by Yaroslav on 20.06.2017.
 */

public class PhenologicalCharacteristicObjectToPhenologicalCharacteristicEntityMapper
    implements Mapper<PhenologicalCharacteristicObject, PhenologicalCharacteristicEntity> {
  @Override public PhenologicalCharacteristicEntity transform(PhenologicalCharacteristicObject obj)
      throws RuntimeException {
    return new PhenologicalCharacteristicEntity(obj.getId(), obj.getName(), obj.getType().getId());
  }
}
