package com.apps.twelve.floor.field.data.local.mappers;

import com.apps.twelve.floor.field.data.local.entities.conditions.SoilTypeEntity;
import com.apps.twelve.floor.field.data.local.objects.conditions.SoilTypeObject;

/**
 * Created by Yaroslav on 13.06.2017.
 */

public class SoilTypeObjectToSoilTypeEntityMapper
    implements Mapper<SoilTypeObject, SoilTypeEntity> {
  @Override public SoilTypeEntity transform(SoilTypeObject obj) throws RuntimeException {
    return SoilTypeEntity.newSoilTypeEntity(obj.getId(), obj.getName(), obj.getType().getId(),
        obj.getPointsAsCoordinatesString());
  }
}
