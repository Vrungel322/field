package com.apps.twelve.floor.field.data.local.entities;

import com.apps.twelve.floor.field.data.local.tables.technological_map.CropTechnologicalProcessesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 11.05.2017.
 */

@StorIOSQLiteType(table = CropTechnologicalProcessesTable.TABLE)
public class CropTechnologicalProcessesEntity {

  @StorIOSQLiteColumn(name = CropTechnologicalProcessesTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = CropTechnologicalProcessesTable.COLUMN_NAME) String name;
  @StorIOSQLiteColumn(name = CropTechnologicalProcessesTable.COLUMN_ORDER) int order;
  @StorIOSQLiteColumn(name = CropTechnologicalProcessesTable.COLUMN_CROP_ID) Long cropId;
  @StorIOSQLiteColumn(name = CropTechnologicalProcessesTable.COLUMN_CLIMATE_ZONE_ID) Long
      climateZoneId;
  @StorIOSQLiteColumn(name = CropTechnologicalProcessesTable.COLUMN_PROCESS_PERIOD_ID) Long
      processPeriodId;
  @StorIOSQLiteColumn(name = CropTechnologicalProcessesTable.COLUMN_PHASE_ID) Long phaseId;

  public CropTechnologicalProcessesEntity() {
  }

  private CropTechnologicalProcessesEntity(Long id, String name, int order, Long cropId,
      Long climateZoneId, Long processPeriodId, Long phaseId) {
    this.id = id;
    this.name = name;
    this.order = order;
    this.cropId = cropId;
    this.climateZoneId = climateZoneId;
    this.processPeriodId = processPeriodId;
    this.phaseId = phaseId;
  }

  public static CropTechnologicalProcessesEntity newCropTechnologicalProcessesModel(Long id,
      String name, int order, Long cropId, Long climateZoneId, Long processPeriodId, Long phaseId) {
    if (id == 0) id = null;
    return new CropTechnologicalProcessesEntity(id, name, order, cropId, climateZoneId,
        processPeriodId, phaseId);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    CropTechnologicalProcessesEntity that = (CropTechnologicalProcessesEntity) obj;

    if (order != that.order) return false;
    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    if (cropId != null ? !cropId.equals(that.cropId) : that.cropId != null) return false;
    if (climateZoneId != null ? !climateZoneId.equals(that.climateZoneId)
        : that.climateZoneId != null) {
      return false;
    }
    if (processPeriodId != null ? !processPeriodId.equals(that.processPeriodId)
        : that.processPeriodId != null) {
      return false;
    }

    return phaseId != null ? phaseId.equals(that.phaseId) : that.phaseId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + order;
    result = 31 * result + (cropId != null ? cropId.hashCode() : 0);
    result = 31 * result + (climateZoneId != null ? climateZoneId.hashCode() : 0);
    result = 31 * result + (processPeriodId != null ? processPeriodId.hashCode() : 0);
    result = 31 * result + (phaseId != null ? phaseId.hashCode() : 0);

    return result;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public Long getCropId() {
    return cropId;
  }

  public void setCropId(Long cropId) {
    this.cropId = cropId;
  }

  public Long getClimateZoneId() {
    return climateZoneId;
  }

  public void setClimateZoneId(Long climateZoneId) {
    this.climateZoneId = climateZoneId;
  }

  public Long getProcessPeriodId() {
    return processPeriodId;
  }

  public void setProcessPeriodId(Long processPeriodId) {
    this.processPeriodId = processPeriodId;
  }

  public Long getPhaseId() {
    return phaseId;
  }

  public void setPhaseId(Long phaseId) {
    this.phaseId = phaseId;
  }
}
