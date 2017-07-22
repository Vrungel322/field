package com.apps.twelve.floor.field.data.local.mappers.conditions;

import com.apps.twelve.floor.field.data.local.entities.conditions.PreviousCropValueEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.conditions.PreviousCropValueObject;

/**
 * Created by yarrick on 22.07.17.
 */
public class PreviousCropValueObjectToPreviousCropValueEntityMapper
    implements Mapper<PreviousCropValueObject, PreviousCropValueEntity> {
  @Override public PreviousCropValueEntity transform(PreviousCropValueObject obj)
      throws RuntimeException {
    return PreviousCropValueEntity.newPreviousCropValueEntity(obj.getId(), obj.getTypeId(),
        obj.getCropId());
  }
}
