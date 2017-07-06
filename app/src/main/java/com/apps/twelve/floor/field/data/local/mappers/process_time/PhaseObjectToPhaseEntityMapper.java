package com.apps.twelve.floor.field.data.local.mappers.process_time;

import com.apps.twelve.floor.field.data.local.entities.process_time.PhaseEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.process_time.PhaseObject;

/**
 * Created by Yaroslav on 08.06.2017.
 */

public class PhaseObjectToPhaseEntityMapper implements Mapper<PhaseObject, PhaseEntity> {

  @Override public PhaseEntity transform(PhaseObject obj) throws RuntimeException {
    return PhaseEntity.newPhaseEntity(obj.getId(), obj.getName(), obj.getCrop().getId());
  }
}
