package com.apps.twelve.floor.field.data.local.mappers;

import com.apps.twelve.floor.field.data.local.entities.conditions.SoilTypeEntity;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionTypeObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.SoilTypeObject;

/**
 * Created by Yaroslav on 14.06.2017.
 */

public class SoilTypeEntityToSoilTypeObject implements Mapper<SoilTypeEntity, SoilTypeObject> {
  @Override public SoilTypeObject transform(SoilTypeEntity entity) throws RuntimeException {
    return new SoilTypeObject(entity.getId(), entity.getName(), /*TODO: maybe we don't need this field*/
        new ConditionTypeObject(1, "Тип почвы"), entity.getCoordinates());
  }
}
