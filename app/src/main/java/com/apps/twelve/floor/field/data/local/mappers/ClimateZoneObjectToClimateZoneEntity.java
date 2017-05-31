package com.apps.twelve.floor.field.data.local.mappers;

import com.apps.twelve.floor.field.data.local.entities.ClimateZoneEntity;
import com.apps.twelve.floor.field.data.local.objects.process_time.ClimateZoneObject;

/**
 * Created by Yaroslav on 16.05.2017.
 */

public class ClimateZoneObjectToClimateZoneEntity
    implements Mapper<ClimateZoneObject, ClimateZoneEntity> {
  @Override public ClimateZoneEntity transform(ClimateZoneObject obj) throws RuntimeException {
    return ClimateZoneEntity.newClimateZoneEntity(obj.getId(), obj.getName(),
        obj.getPointsAsCoordinatesString());
  }
}
