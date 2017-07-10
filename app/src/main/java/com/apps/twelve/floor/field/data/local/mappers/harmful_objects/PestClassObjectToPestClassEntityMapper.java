package com.apps.twelve.floor.field.data.local.mappers.harmful_objects;

import com.apps.twelve.floor.field.data.local.entities.harmful_objects.PestClassEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.PestClassObject;

/**
 * Created by yarrick on 10.07.17.
 */

public class PestClassObjectToPestClassEntityMapper
    implements Mapper<PestClassObject, PestClassEntity> {
  @Override public PestClassEntity transform(PestClassObject obj) throws RuntimeException {
    return PestClassEntity.newPestClassEntity(obj.getId(), obj.getName());
  }
}
