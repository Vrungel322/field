package com.apps.twelve.floor.field.data.local.mappers.harmful_objects;

import com.apps.twelve.floor.field.data.local.entities.harmful_objects.DiseasePathogenTypeEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.DiseasePathogenTypeObject;

/**
 * Created by yarrick on 05.09.17.
 */

public class DiseasePathogenTypeObjectToDiseasePathogenTypeEntityMapper
    implements Mapper<DiseasePathogenTypeObject, DiseasePathogenTypeEntity> {
  @Override public DiseasePathogenTypeEntity transform(DiseasePathogenTypeObject obj)
      throws RuntimeException {
    return new DiseasePathogenTypeEntity(obj.getId(), obj.getName());
  }
}
