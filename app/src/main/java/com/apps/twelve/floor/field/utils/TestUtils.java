package com.apps.twelve.floor.field.utils;

import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.data.local.objects.CropObject;
import com.apps.twelve.floor.field.data.local.objects.FieldObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.ClimateZoneObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.PhaseObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.ProcessPeriodObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.AggregateObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.FieldTechnologicalProcessSolutionObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.TechnologicalSolutionObject;
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

    FieldObject field = FieldObject.EMPTY;

    ProcessPeriodObject processPeriod1 = new ProcessPeriodObject(1, 1, 30, 3, 3);
    ProcessPeriodObject processPeriod2 = new ProcessPeriodObject(1, 30, 15, 4, 5);
    ProcessPeriodObject processPeriod3 = new ProcessPeriodObject(1, 10, 25, 8, 9);
    ProcessPeriodObject processPeriod4 = new ProcessPeriodObject(1, 1, 25, 10, 10);

    CropTechnologicalProcessObject cropTechProcess1 =
        new CropTechnologicalProcessObject(1, "ТЕСТ: Посев", 1, CropObject.EMPTY,
            ClimateZoneObject.EMPTY, PhaseObject.EMPTY, processPeriod1);
    CropTechnologicalProcessObject cropTechProcess2 =
        new CropTechnologicalProcessObject(2, "ТЕСТ: Гербицидная обработка", 2, CropObject.EMPTY,
            ClimateZoneObject.EMPTY, PhaseObject.EMPTY, processPeriod2);
    CropTechnologicalProcessObject cropTechProcess3 =
        new CropTechnologicalProcessObject(3, "ТЕСТ: Инсектицидная обработка", 3, CropObject.EMPTY,
            ClimateZoneObject.EMPTY, PhaseObject.EMPTY, processPeriod3);
    CropTechnologicalProcessObject cropTechProcess4 =
        new CropTechnologicalProcessObject(4, "ТЕСТ: Сбор урожая", 4, CropObject.EMPTY,
            ClimateZoneObject.EMPTY, PhaseObject.EMPTY, processPeriod4);

    TechnologicalProcessStateObject stateDone =
        new TechnologicalProcessStateObject(1, "Выполнен", R.drawable.ic_done_24dp);
    TechnologicalProcessStateObject stateActual =
        new TechnologicalProcessStateObject(2, "Актуален", R.drawable.ic_actual_24dp);
    TechnologicalProcessStateObject stateFuture =
        new TechnologicalProcessStateObject(3, "Запланирован", R.drawable.ic_future_24dp);

    list.add(new FieldCropTechnologicalProcessObject(1, field, cropTechProcess1, stateDone));
    list.add(new FieldCropTechnologicalProcessObject(2, field, cropTechProcess2, stateActual));
    list.add(new FieldCropTechnologicalProcessObject(3, field, cropTechProcess3, stateFuture));
    list.add(new FieldCropTechnologicalProcessObject(4, field, cropTechProcess4, stateFuture));

    return list;
  }

  public static ArrayList<FieldTechnologicalProcessSolutionObject> getTechnologicalSolutions() {

    ArrayList<FieldTechnologicalProcessSolutionObject> res = new ArrayList<>();

    res.add(makeTechnologicalProcessSolutionObject(1, null, null));
    res.add(makeTechnologicalProcessSolutionObject(2, null, null));
    res.add(makeTechnologicalProcessSolutionObject(3, null, null));
    res.add(makeTechnologicalProcessSolutionObject(4, null, null));
    res.add(makeTechnologicalProcessSolutionObject(5, null, null));

    return res;
  }

  public static FieldTechnologicalProcessSolutionObject makeTechnologicalProcessSolutionObject(
      long id, FieldCropTechnologicalProcessObject process, TechnologicalSolutionObject solution) {
    return new FieldTechnologicalProcessSolutionObject(id, process, solution);
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
