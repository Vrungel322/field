package com.apps.twelve.floor.field.data.local.mappers;

import com.apps.twelve.floor.field.data.local.entities.technological_map.TechnologicalProcessStateEntity;
import com.apps.twelve.floor.field.data.local.objects.technological_map.TechnologicalProcessStateObject;

/**
 * Created by Yaroslav on 20.06.2017.
 */

public class TechnologicalProcessStateObjectToTechnologicalProcessStateEntity
    implements Mapper<TechnologicalProcessStateObject, TechnologicalProcessStateEntity> {
  @Override public TechnologicalProcessStateEntity transform(TechnologicalProcessStateObject obj)
      throws RuntimeException {
    return new TechnologicalProcessStateEntity(obj.getId(), obj.getName(), obj.getImageId());
  }
}
