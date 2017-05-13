package com.apps.twelve.floor.field.mvp.data.local.mappers;

import com.apps.twelve.floor.field.mvp.data.local.entities.FieldEntity;
import com.apps.twelve.floor.field.mvp.data.local.objects.FieldObject;

/**
 * Created by Yaroslav on 12.05.2017.
 */

public class FieldObjectToFieldEntity implements Mapper<FieldObject, FieldEntity> {

  @Override public FieldEntity transform(FieldObject obj) throws RuntimeException {

    return FieldEntity.newFieldEntity(obj.getId(), obj.getName(), obj.getCrop().getId(),
        obj.getPreviousCrop().getId(), obj.getPointsAsCoordinatesString(), obj.getArea(),
        obj.getClimateZone().getId());
  }
}
