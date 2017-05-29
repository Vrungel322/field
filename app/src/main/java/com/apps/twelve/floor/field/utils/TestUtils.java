package com.apps.twelve.floor.field.utils;

import com.apps.twelve.floor.field.data.local.objects.ClimateZoneObject;
import com.apps.twelve.floor.field.data.local.objects.CropObject;
import com.apps.twelve.floor.field.data.local.objects.FieldObject;
import com.apps.twelve.floor.field.data.local.objects.FieldTechnologicalProcessObject;
import com.apps.twelve.floor.field.data.local.objects.PhaseObject;
import com.apps.twelve.floor.field.data.local.objects.ProcessPeriodObject;
import com.apps.twelve.floor.field.data.local.objects.TechnologicalProcessObject;
import com.apps.twelve.floor.field.data.local.objects.TechnologicalProcessStatusObject;
import com.apps.twelve.floor.field.data.local.objects.TechnologicalProcessTimeObject;
import com.apps.twelve.floor.field.data.local.objects.TechnologicalSolutionObject;
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

  public static ArrayList<TechnologicalSolutionObject> getTechnologicalSolutions() {

    ArrayList<TechnologicalSolutionObject> res = new ArrayList<>();

    res.add(new TechnologicalSolutionObject(1, null, null, 1));
    res.add(new TechnologicalSolutionObject(2, null, null, 1));
    res.add(new TechnologicalSolutionObject(3, null, null, 1));
    res.add(new TechnologicalSolutionObject(4, null, null, 1));
    res.add(new TechnologicalSolutionObject(5, null, null, 1));

    return res;
  }
}
