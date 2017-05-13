package com.apps.twelve.floor.field.mvp.data.local.mappers;

import com.apps.twelve.floor.field.mvp.data.local.entities.ClimateZoneEntity;
import com.apps.twelve.floor.field.mvp.data.local.objects.ClimateZoneObject;

/**
 * Created by Yaroslav on 13.05.2017.
 */

public class ClimateZoneEntityToClimateZoneObject
    implements Mapper<ClimateZoneEntity, ClimateZoneObject> {

  @Override public ClimateZoneObject transform(ClimateZoneEntity entity) throws RuntimeException {
    return new ClimateZoneObject(entity.getId(), entity.getName(), entity.getCoordinates());
  }
}
