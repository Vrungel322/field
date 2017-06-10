package com.apps.twelve.floor.field.data.local.mappers;

import com.apps.twelve.floor.field.data.local.entities.CropEntity;
import com.apps.twelve.floor.field.data.local.entities.process_time.CombinedPhaseEntity;
import com.apps.twelve.floor.field.data.local.entities.process_time.PhaseEntity;
import com.apps.twelve.floor.field.data.local.objects.process_time.PhaseObject;

/**
 * Created by Yaroslav on 09.06.2017.
 */

public class CombinedPhaseEntityToPhaseObject implements Mapper<CombinedPhaseEntity, PhaseObject> {
  @Override public PhaseObject transform(CombinedPhaseEntity obj) throws RuntimeException {

    PhaseEntity phaseEntity = obj.getPhaseEntity();
    CropEntity cropEntity = obj.getCropEntity();

    CropEntityToCropObject cropEntityToCropObject = new CropEntityToCropObject();

    return new PhaseObject(phaseEntity.getId(), phaseEntity.getName(),
        cropEntityToCropObject.transform(cropEntity));
  }
}
