package com.apps.twelve.floor.field.data.local.mappers.harmful_objects;

import com.apps.twelve.floor.field.data.local.entities.harmful_objects.DiseaseEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.DiseaseObject;

/**
 * Created by yarrick on 05.09.17.
 */

public class DiseaseObjectToDiseaseEntityMapper implements Mapper<DiseaseObject, DiseaseEntity> {
  @Override public DiseaseEntity transform(DiseaseObject obj) throws RuntimeException {
    return new DiseaseEntity(obj.getId(), obj.getName(), obj.getTypeId(),
        obj.getDiseasePathogenTypeId());
  }
}
