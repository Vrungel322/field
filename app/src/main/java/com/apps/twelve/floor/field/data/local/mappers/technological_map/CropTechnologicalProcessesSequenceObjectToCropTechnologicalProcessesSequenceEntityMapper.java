package com.apps.twelve.floor.field.data.local.mappers.technological_map;

import com.apps.twelve.floor.field.data.local.entities.technological_map.CropTechnologicalProcessesSequenceEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.technological_map.CropTechnologicalProcessesSequenceObject;

/**
 * Created by yarrick on 11.09.17.
 */

public class CropTechnologicalProcessesSequenceObjectToCropTechnologicalProcessesSequenceEntityMapper
    implements
    Mapper<CropTechnologicalProcessesSequenceObject, CropTechnologicalProcessesSequenceEntity> {
  @Override public CropTechnologicalProcessesSequenceEntity transform(
      CropTechnologicalProcessesSequenceObject obj) throws RuntimeException {
    return new CropTechnologicalProcessesSequenceEntity(obj.getId(),
        obj.getCropTechnologicalProcessObjectId(), obj.getNextCropTechnologicalProcessObjectId());
  }
}
