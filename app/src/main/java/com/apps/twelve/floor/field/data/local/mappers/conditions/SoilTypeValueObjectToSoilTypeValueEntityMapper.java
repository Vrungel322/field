package com.apps.twelve.floor.field.data.local.mappers.conditions;

import com.apps.twelve.floor.field.data.local.entities.conditions.SoilTypeValueEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.conditions.SoilTypeValueObject;

/**
 * Created by yarrick on 07.07.17.
 */

public class SoilTypeValueObjectToSoilTypeValueEntityMapper
    implements Mapper<SoilTypeValueObject, SoilTypeValueEntity> {
  @Override public SoilTypeValueEntity transform(SoilTypeValueObject obj) throws RuntimeException {
    return SoilTypeValueEntity.newSoilTypeValueEntity(obj.getId(), obj.getTypeId(),
        obj.getSoilTypeId());
  }
}
