package com.apps.twelve.floor.field.mvp.data.local.mappers;

import com.apps.twelve.floor.field.mvp.data.local.entities.CombinedFieldEntity;
import com.apps.twelve.floor.field.mvp.data.local.entities.CropEntity;
import com.apps.twelve.floor.field.mvp.data.local.entities.FieldEntity;
import com.apps.twelve.floor.field.mvp.data.local.objects.FieldObject;

/**
 * Created by Yaroslav on 13.05.2017.
 */

public class CombinedFieldEntityToFieldObject implements Mapper<CombinedFieldEntity, FieldObject> {

  @Override public FieldObject transform(CombinedFieldEntity entity)
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
