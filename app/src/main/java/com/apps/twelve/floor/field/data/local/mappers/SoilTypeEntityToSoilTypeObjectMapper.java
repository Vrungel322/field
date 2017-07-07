package com.apps.twelve.floor.field.data.local.mappers;

import com.apps.twelve.floor.field.data.local.entities.SoilTypeEntity;
import com.apps.twelve.floor.field.data.local.objects.SoilTypeObject;

/**
 * Created by Yaroslav on 14.06.2017.
 */

public class SoilTypeEntityToSoilTypeObjectMapper
    implements Mapper<SoilTypeEntity, SoilTypeObject> {
  @Override public SoilTypeObject transform(SoilTypeEntity entity) throws RuntimeException {
    return new SoilTypeObject(entity.getId(), entity.getName(), entity.getCoordinates());
  }
}
