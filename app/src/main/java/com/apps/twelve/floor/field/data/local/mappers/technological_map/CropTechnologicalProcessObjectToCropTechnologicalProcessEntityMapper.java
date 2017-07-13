package com.apps.twelve.floor.field.data.local.mappers.technological_map;

import com.apps.twelve.floor.field.data.local.entities.technological_map.CropTechnologicalProcessEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.technological_map.CropTechnologicalProcessObject;

/**
 * Created by yarrick on 13.07.17.
 */

public class CropTechnologicalProcessObjectToCropTechnologicalProcessEntityMapper
    implements Mapper<CropTechnologicalProcessObject, CropTechnologicalProcessEntity> {
  @Override public CropTechnologicalProcessEntity transform(CropTechnologicalProcessObject obj)
      throws RuntimeException {
    return CropTechnologicalProcessEntity.newCropTechnologicalProcessesModel(obj.getId(),
        obj.getName(), obj.getOrder(), obj.getCropId(), obj.getClimateZoneId(), obj.getPeriodId(),
        obj.getPhaseId());
  }
}
