package com.apps.twelve.floor.field.utils;

import com.apps.twelve.floor.field.data.local.objects.CropObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.AggregateObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.BaseTechnologicalSolutionObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.FieldTechnologicalProcessSolutionObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.TechnologicalSolutionTypeObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessObject;
import java.util.ArrayList;

/**
 * Created by Yaroslav on 23.05.2017.
 */

public final class TestUtils {

  public static CropObject makeCropObject(long id, String name, long parentId, boolean isGroup) {
    return new CropObject(id, name, parentId, isGroup);
  }

  public static FieldCropTechnologicalProcessObject makeFieldTechnologicalProcessObject() {
    /*CropObject crop = new CropObject(1, "Crop 1", 0, false);
    CropObject prevCrop = new CropObject(2, "Crop 2", 0, false);
    ClimateZoneObject climateZone = new ClimateZoneObject(1, "Climate zone", "");
    PhaseObject phase = new PhaseObject(1, "Phase 1", crop);
    ProcessPeriodObject period =
        new ProcessPeriodObject(1, System.currentTimeMillis(), System.currentTimeMillis());
    TechnologicalProcessTimeObject time =
        new TechnologicalProcessTimeObject(1, "Time 1", climateZone, phase, period);
    CropTechnologicalProcessObject technologicalProcess =
        new CropTechnologicalProcessObject(1, "Tech process", 1, crop, time);
    TechnologicalProcessStateObject technologicalProcessStatus =
        new TechnologicalProcessStateObject(1, "Current");

    FieldObject field = new FieldObject(1, "Field 1", crop, prevCrop, "", 11111D, climateZone);

    return new FieldCropTechnologicalProcessObject(4, field, technologicalProcess,
        technologicalProcessStatus);*/
    return null;
  }

  public static ArrayList<FieldCropTechnologicalProcessObject> getFieldTechnologicalProcesses() {
    ArrayList<FieldCropTechnologicalProcessObject> list = new ArrayList<>();

    /*CropObject crop = new CropObject(1, "Crop 1", 0, false);
    CropObject prevCrop = new CropObject(2, "Crop 2", 0, false);
    ClimateZoneObject climateZone = new ClimateZoneObject(1, "Climate zone", "");
    PhaseObject phase = new PhaseObject(1, "Phase 1", crop);
    ProcessPeriodObject period =
        new ProcessPeriodObject(1, System.currentTimeMillis(), System.currentTimeMillis());
    TechnologicalProcessTimeObject time =
        new TechnologicalProcessTimeObject(1, "Time 1", climateZone, phase, period);
    CropTechnologicalProcessObject technologicalProcess =
        new CropTechnologicalProcessObject(1, "Tech process", 1, crop, time);
    TechnologicalProcessStateObject technologicalProcessStatus =
        new TechnologicalProcessStateObject(1, "Current");

    FieldObject field = null;
    FieldCropTechnologicalProcessObject fieldTechProcess = null;

    field = new FieldObject(1, "Field 1", crop, prevCrop, "", 11111D, climateZone);
    fieldTechProcess = new FieldCropTechnologicalProcessObject(1, field, technologicalProcess,
        technologicalProcessStatus);
    list.add(fieldTechProcess);

    field = new FieldObject(2, "Field 2", crop, prevCrop, "", 22222D, climateZone);
    fieldTechProcess = new FieldCropTechnologicalProcessObject(2, field, technologicalProcess,
        technologicalProcessStatus);
    list.add(fieldTechProcess);

    field = new FieldObject(3, "Field 3", crop, prevCrop, "", 33333D, climateZone);
    fieldTechProcess = new FieldCropTechnologicalProcessObject(3, field, technologicalProcess,
        technologicalProcessStatus);
    list.add(fieldTechProcess);

    field = new FieldObject(4, "Field 4", crop, prevCrop, "", 44444D, climateZone);
    fieldTechProcess = new FieldCropTechnologicalProcessObject(4, field, technologicalProcess,
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
    list.add(fieldTechProcess);*/

    return list;
  }

  public static ArrayList<FieldTechnologicalProcessSolutionObject> getTechnologicalSolutions() {

    ArrayList<FieldTechnologicalProcessSolutionObject> res = new ArrayList<>();

    res.add(makeTechnologicalProcessSolutionObject(1, null, null, null));
    res.add(makeTechnologicalProcessSolutionObject(2, null, null, null));
    res.add(makeTechnologicalProcessSolutionObject(3, null, null, null));
    res.add(makeTechnologicalProcessSolutionObject(4, null, null, null));
    res.add(makeTechnologicalProcessSolutionObject(5, null, null, null));

    return res;
  }

  public static FieldTechnologicalProcessSolutionObject makeTechnologicalProcessSolutionObject(
      long id, FieldCropTechnologicalProcessObject process, TechnologicalSolutionTypeObject type,
      BaseTechnologicalSolutionObject value) {
    return new FieldTechnologicalProcessSolutionObject(id, process, type, value);
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
