package com.apps.twelve.floor.field.data.local.mappers;

import com.apps.twelve.floor.field.data.local.entities.FieldEntity;
import com.apps.twelve.floor.field.data.local.objects.FieldObject;

/**
 * Created by Yaroslav on 12.05.2017.
 */

public class FieldObjectToFieldEntity implements Mapper<FieldObject, FieldEntity> {

  @Override public FieldEntity transform(FieldObject obj) throws RuntimeException {

    return FieldEntity.newFieldEntity(obj.getId(), obj.getName(), obj.getArea(),
        obj.getCrop().getId(),
        (obj.getPreviousCrop() != null ? obj.getPreviousCrop().getId() : null),
        obj.getPointsAsCoordinatesString(), obj.getClimateZone().getId());
  }
}
