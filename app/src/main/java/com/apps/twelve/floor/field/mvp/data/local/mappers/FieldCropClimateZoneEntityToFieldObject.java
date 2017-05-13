package com.apps.twelve.floor.field.mvp.data.local.mappers;

import com.apps.twelve.floor.field.mvp.data.local.entities.FieldCropClimateZoneEntity;
import com.apps.twelve.floor.field.mvp.data.local.objects.FieldObject;

/**
 * Created by Yaroslav on 13.05.2017.
 */

public class FieldCropClimateZoneEntityToFieldObject
    implements Mapper<FieldCropClimateZoneEntity, FieldObject> {

  @Override public FieldObject transform(FieldCropClimateZoneEntity entity)
      throws RuntimeException {

    return new FieldObject(entity.getFieldEntity().getId(), entity.getFieldEntity().getName(),
        new CropEntityToCropObject().transform(entity.getCropEntity()),
        new CropEntityToCropObject().transform(entity.getCropEntity()),
        // TODO: need to get previous crop
        entity.getFieldEntity().getCoordinates(), entity.getFieldEntity().getArea(),
        new ClimateZoneEntityToClimateZoneObject().transform(entity.getClimateZoneEntity()));
  }
}
