package com.apps.twelve.floor.field.mvp.data.local.mappers;

import com.apps.twelve.floor.field.mvp.data.local.entities.CropEntity;
import com.apps.twelve.floor.field.mvp.data.local.entities.FieldCropClimateZoneEntity;
import com.apps.twelve.floor.field.mvp.data.local.entities.FieldEntity;
import com.apps.twelve.floor.field.mvp.data.local.objects.FieldObject;

/**
 * Created by Yaroslav on 13.05.2017.
 */

public class FieldCropClimateZoneEntityToFieldObject
    implements Mapper<FieldCropClimateZoneEntity, FieldObject> {

  @Override public FieldObject transform(FieldCropClimateZoneEntity entity)
      throws RuntimeException {

    FieldEntity fieldEntity = entity.getFieldEntity();
    CropEntity cropEntity = entity.getCropEntity();
    CropEntity prevCropEntity = entity.getPreviousCropEntity();

    CropEntityToCropObject cropEntityToCropObject = new CropEntityToCropObject();

    return new FieldObject(fieldEntity.getId(), fieldEntity.getName(),
        cropEntityToCropObject.transform(cropEntity),
        cropEntityToCropObject.transform(prevCropEntity), fieldEntity.getCoordinates(),
        fieldEntity.getArea(),
        new ClimateZoneEntityToClimateZoneObject().transform(entity.getClimateZoneEntity()));
  }
}
