package com.apps.twelve.floor.field.utils;

import com.apps.twelve.floor.field.data.local.objects.AggregateObject;
import com.apps.twelve.floor.field.data.local.objects.BaseTechnologicalSolutionObject;
import com.apps.twelve.floor.field.data.local.objects.ClimateZoneObject;
import com.apps.twelve.floor.field.data.local.objects.CropObject;
import com.apps.twelve.floor.field.data.local.objects.FieldObject;
import com.apps.twelve.floor.field.data.local.objects.FieldTechnologicalProcessObject;
import com.apps.twelve.floor.field.data.local.objects.PhaseObject;
import com.apps.twelve.floor.field.data.local.objects.ProcessPeriodObject;
import com.apps.twelve.floor.field.data.local.objects.TechnologicalProcessObject;
import com.apps.twelve.floor.field.data.local.objects.TechnologicalProcessSolutionObject;
import com.apps.twelve.floor.field.data.local.objects.TechnologicalProcessStatusObject;
import com.apps.twelve.floor.field.data.local.objects.TechnologicalProcessTimeObject;
import com.apps.twelve.floor.field.data.local.objects.TechnologicalSolutionTypeObject;
import java.util.ArrayList;

/**
 * Created by Yaroslav on 23.05.2017.
 */

public final class TestUtils {

  public static CropObject makeCropObject(long id, String name, long parentId, boolean isGroup) {
    return new CropObject(id, name, parentId, isGroup);
  }

  public static FieldTechnologicalProcessObject makeFieldTechnologicalProcessObject() {
    CropObject crop = new CropObject(1, "Crop 1", 0, false);
    CropObject prevCrop = new CropObject(2, "Crop 2", 0, false);
    ClimateZoneObject climateZone = new ClimateZoneObject(1, "Climate zone", "");
    PhaseObject phase = new PhaseObject(1, "Phase 1", crop);
    ProcessPeriodObject period =
        new ProcessPeriodObject(1, System.currentTimeMillis(), System.currentTimeMillis());
    TechnologicalProcessTimeObject time =
        new TechnologicalProcessTimeObject(1, "Time 1", climateZone, phase, period);
    TechnologicalProcessObject technologicalProcess =
        new TechnologicalProcessObject(1, "Tech process", 1, crop, time);
    TechnologicalProcessStatusObject technologicalProcessStatus =
        new TechnologicalProcessStatusObject(1, "Current");

    FieldObject field = new FieldObject(1, "Field 1", crop, prevCrop, "", 11111D, climateZone);

    return new FieldTechnologicalProcessObject(4, field, technologicalProcess,
        technologicalProcessStatus);
  }

  public static ArrayList<FieldTechnologicalProcessObject> getFieldTechnologicalProcesses() {
    ArrayList<FieldTechnologicalProcessObject> list = new ArrayList<>();

    CropObject crop = new CropObject(1, "Crop 1", 0, false);
    CropObject prevCrop = new CropObject(2, "Crop 2", 0, false);
    ClimateZoneObject climateZone = new ClimateZoneObject(1, "Climate zone", "");
    PhaseObject phase = new PhaseObject(1, "Phase 1", crop);
    ProcessPeriodObject period =
        new ProcessPeriodObject(1, System.currentTimeMillis(), System.currentTimeMillis());
    TechnologicalProcessTimeObject time =
        new TechnologicalProcessTimeObject(1, "Time 1", climateZone, phase, period);
    TechnologicalProcessObject technologicalProcess =
        new TechnologicalProcessObject(1, "Tech process", 1, crop, time);
    TechnologicalProcessStatusObject technologicalProcessStatus =
        new TechnologicalProcessStatusObject(1, "Current");

    FieldObject field = null;
    FieldTechnologicalProcessObject fieldTechProcess = null;

    field = new FieldObject(1, "Field 1", crop, prevCrop, "", 11111D, climateZone);
    fieldTechProcess = new FieldTechnologicalProcessObject(1, field, technologicalProcess,
        technologicalProcessStatus);
    list.add(fieldTechProcess);

    field = new FieldObject(2, "Field 2", crop, prevCrop, "", 22222D, climateZone);
    fieldTechProcess = new FieldTechnologicalProcessObject(2, field, technologicalProcess,
        technologicalProcessStatus);
    list.add(fieldTechProcess);

    field = new FieldObject(3, "Field 3", crop, prevCrop, "", 33333D, climateZone);
    fieldTechProcess = new FieldTechnologicalProcessObject(3, field, technologicalProcess,
        technologicalProcessStatus);
    list.add(fieldTechProcess);

    field = new FieldObject(4, "Field 4", crop, prevCrop, "", 44444D, climateZone);
    fieldTechProcess = new FieldTechnologicalProcessObject(4, field, technologicalProcess,
        technologicalProcessStatus);
    list.add(fieldTechProcess);

    list.add(fieldTechProcess);
    list.add(fieldTechProcess);
    list.add(fieldTechProcess);
    list.add(fieldTechProcess);
    list.add(fieldTechProcess);
    list.add(fieldTechProcess);
    list.add(fieldTechProcess);
    list.add(fieldTechProcess);
    list.add(fieldTechProcess);
    list.add(fieldTechProcess);

    return list;
  }

  public static ArrayList<TechnologicalProcessSolutionObject> getTechnologicalSolutions() {

    ArrayList<TechnologicalProcessSolutionObject> res = new ArrayList<>();

    res.add(makeTechnologicalProcessSolutionObject(1, null, null, null));
    res.add(makeTechnologicalProcessSolutionObject(2, null, null, null));
    res.add(makeTechnologicalProcessSolutionObject(3, null, null, null));
    res.add(makeTechnologicalProcessSolutionObject(4, null, null, null));
    res.add(makeTechnologicalProcessSolutionObject(5, null, null, null));

    return res;
  }

  public static TechnologicalProcessSolutionObject makeTechnologicalProcessSolutionObject(long id,
      FieldTechnologicalProcessObject process, TechnologicalSolutionTypeObject type,
      BaseTechnologicalSolutionObject value) {
    return new TechnologicalProcessSolutionObject(id, process, type, value);
  }

  public static ArrayList<TechnologicalSolutionTypeObject> getAllTechnologicalSolutionTypes() {
    ArrayList<TechnologicalSolutionTypeObject> res = new ArrayList<>();

    res.add(makeTechnologicalSolutionTypeObject(1, "Агрегат"));
    res.add(makeTechnologicalSolutionTypeObject(2, "Препарат"));

    return res;
  }

  public static TechnologicalSolutionTypeObject makeTechnologicalSolutionTypeObject(long id,
      String name) {
    return new TechnologicalSolutionTypeObject(id, name);
  }

  public static AggregateObject makeAggregateObject(long id, String name,
      TechnologicalSolutionTypeObject type, long price) {
    return new AggregateObject(id, name, type, price);
  }
}
