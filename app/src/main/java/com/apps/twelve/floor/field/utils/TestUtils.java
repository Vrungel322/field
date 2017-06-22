package com.apps.twelve.floor.field.utils;

import com.apps.twelve.floor.field.data.local.objects.CropObject;
import com.apps.twelve.floor.field.data.local.objects.FieldObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionTypeObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.SoilTypeObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.ClimateZoneObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.PhaseObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.ProcessPeriodObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.AggregateObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.BaseTechnologicalSolutionObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.FieldTechnologicalProcessSolutionObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.TechnologicalSolutionTypeObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.CropTechnologicalProcessObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.TechnologicalProcessStateObject;
import java.util.ArrayList;

/**
 * Created by Yaroslav on 23.05.2017.
 */

public final class TestUtils {

  public static CropObject makeCropObject(long id, String name, long parentId, boolean isGroup,
      boolean isSupported) {
    return new CropObject(id, name, parentId, isGroup, isSupported);
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

    CropObject crop = new CropObject(1, "Тестовая культура", 0, false, false);
    ClimateZoneObject climateZone = new ClimateZoneObject(1, "Тестовая климатическая зона", "");
    PhaseObject phase = new PhaseObject(1, "Тестовая фаза", crop);
    SoilTypeObject soilType = new SoilTypeObject(1, "Тестовый тип почвы",
        new ConditionTypeObject(1, "Тестовый тип условия"), "");
    FieldObject field =
        new FieldObject(1, "Тестовое поле", crop, crop, "", 11111D, climateZone, phase, soilType);
    ProcessPeriodObject period =
        new ProcessPeriodObject(1, System.currentTimeMillis(), System.currentTimeMillis());
    CropTechnologicalProcessObject cropTp =
        new CropTechnologicalProcessObject(1, "Тестовый тех процесс", 1, crop, climateZone, phase,
            period);
    TechnologicalProcessStateObject status =
        new TechnologicalProcessStateObject(1, "Тестовое состояние", -1);

    FieldCropTechnologicalProcessObject fieldTechProcess =
        new FieldCropTechnologicalProcessObject(1, field, cropTp, status);

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
