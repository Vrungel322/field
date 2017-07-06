package com.apps.twelve.floor.field.data.local.mappers.harmful_objects;

import com.apps.twelve.floor.field.data.local.entities.harmful_objects.WeedClassEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.harmful_objects.WeedClassObject;

/**
 * Created by yarrick on 30.06.17.
 */

public class WeedClassObjectToWeedClassEntityMapper
    implements Mapper<WeedClassObject, WeedClassEntity> {
  @Override public WeedClassEntity transform(WeedClassObject obj) throws RuntimeException {
    return WeedClassEntity.newWeedClassEntity(obj.getId(), obj.getName(), obj.getParentId(),
        obj.isGroup());
  }
}
