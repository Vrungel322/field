package com.apps.twelve.floor.field.data.local.mappers.process_time;

import com.apps.twelve.floor.field.data.local.entities.process_time.PhaseEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.CropObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.PhaseObject;

/**
 * Created by Yaroslav on 09.06.2017.
 */

public class PhaseEntityToPhaseObjectMapper implements Mapper<PhaseEntity, PhaseObject> {
  @Override public PhaseObject transform(PhaseEntity phaseEntity) throws RuntimeException {
    // TODO: for now we don't need crop object, maybe there is no need to keep it in PhaseObject at all
    return new PhaseObject(phaseEntity.getId(), phaseEntity.getName(), CropObject.EMPTY);
  }
}
