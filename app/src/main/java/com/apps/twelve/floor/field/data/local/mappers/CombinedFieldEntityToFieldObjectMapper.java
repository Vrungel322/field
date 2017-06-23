package com.apps.twelve.floor.field.data.local.mappers;

import com.apps.twelve.floor.field.data.local.entities.CombinedFieldEntity;
import com.apps.twelve.floor.field.data.local.entities.CropEntity;
import com.apps.twelve.floor.field.data.local.entities.FieldEntity;
import com.apps.twelve.floor.field.data.local.objects.FieldObject;

/**
 * Created by Yaroslav on 13.05.2017.
 */

public class CombinedFieldEntityToFieldObjectMapper
    implements Mapper<CombinedFieldEntity, FieldObject> {

  @Override public FieldObject transform(CombinedFieldEntity entity)
      throws RuntimeException {

    FieldEntity fieldEntity = entity.getFieldEntity();
    CropEntity cropEntity = entity.getCropEntity();
    CropEntity prevCropEntity = entity.getPreviousCropEntity();

    CropEntityToCropObjectMapper cropMapperEO =
        new CropEntityToCropObjectMapper(); // entity to object

    return new FieldObject(fieldEntity.getId(), fieldEntity.getName(),
        cropMapperEO.transform(cropEntity), cropMapperEO.transform(prevCropEntity),
        fieldEntity.getCoordinates(),
        fieldEntity.getArea(),
        new ClimateZoneEntityToClimateZoneObjectMapper().transform(entity.getClimateZoneEntity()),
        new PhaseEntityToPhaseObjectMapper().transform(entity.getPhaseEntity()),
        new SoilTypeEntityToSoilTypeObjectMapper().transform(entity.getSoilTypeEntity()));
  }
}
