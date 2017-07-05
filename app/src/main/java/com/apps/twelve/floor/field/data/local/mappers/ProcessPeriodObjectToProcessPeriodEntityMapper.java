package com.apps.twelve.floor.field.data.local.mappers;

import com.apps.twelve.floor.field.data.local.entities.process_time.ProcessPeriodEntity;
import com.apps.twelve.floor.field.data.local.objects.process_time.ProcessPeriodObject;

/**
 * Created by yarrick on 05.07.17.
 */

public class ProcessPeriodObjectToProcessPeriodEntityMapper
    implements Mapper<ProcessPeriodObject, ProcessPeriodEntity> {
  @Override public ProcessPeriodEntity transform(ProcessPeriodObject obj) throws RuntimeException {
    return ProcessPeriodEntity.newProcessPeriodEntity(obj.getId(), obj.getDateDayFrom(),
        obj.getDateDayTo(), obj.getDateMonthFrom(), obj.getDateMonthTo());
  }
}
