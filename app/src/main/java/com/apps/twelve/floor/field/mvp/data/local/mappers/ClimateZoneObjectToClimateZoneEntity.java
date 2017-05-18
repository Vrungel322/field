package com.apps.twelve.floor.field.mvp.data.local.mappers;

import com.apps.twelve.floor.field.mvp.data.local.entities.ClimateZoneEntity;
import com.apps.twelve.floor.field.mvp.data.local.objects.ClimateZoneObject;

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
