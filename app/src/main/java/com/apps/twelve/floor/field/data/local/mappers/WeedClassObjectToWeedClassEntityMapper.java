package com.apps.twelve.floor.field.data.local.mappers;

import com.apps.twelve.floor.field.data.local.entities.conditions.WeedClassEntity;
import com.apps.twelve.floor.field.data.local.objects.conditions.WeedClassObject;

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
