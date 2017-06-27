package com.apps.twelve.floor.field.data.local.mappers;

import com.apps.twelve.floor.field.data.local.entities.process_time.ProcessPeriodEntity;
import com.apps.twelve.floor.field.data.local.objects.process_time.ProcessPeriodObject;

/**
 * Created by Vrungel on 27.06.2017.
 */

public class ProcessPeriodObjectToProcessPeriodEntity
    implements Mapper<ProcessPeriodObject, ProcessPeriodEntity> {
  @Override public ProcessPeriodEntity transform(ProcessPeriodObject obj) throws RuntimeException {
    return new ProcessPeriodEntity(obj.getId(), obj.getDateDayFrom(), obj.getDateDayTo(),
        obj.getDateMonthFrom(), obj.getDateMonthTo());
  }
}
