package com.apps.twelve.floor.field.data.local.entities;

import com.apps.twelve.floor.field.data.local.tables.FieldsTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by John on 27.03.2017.
 */

@StorIOSQLiteType(table = FieldsTable.TABLE) public class FieldEntity {

  @StorIOSQLiteColumn(name = FieldsTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = FieldsTable.COLUMN_NAME) String name;
  @StorIOSQLiteColumn(name = FieldsTable.COLUMN_AREA) Double area;
  @StorIOSQLiteColumn(name = FieldsTable.COLUMN_CROP_ID) Long cropId;
  @StorIOSQLiteColumn(name = FieldsTable.COLUMN_PREV_CROP_ID) Long previousCropId;
  @StorIOSQLiteColumn(name = FieldsTable.COLUMN_COORDINATES) String coordinates;
  @StorIOSQLiteColumn(name = FieldsTable.COLUMN_CLIMATE_ZONE_ID) Long climateZoneId;

  public FieldEntity() {
  }

  private FieldEntity(Long id, String name, Double area, Long cropId, Long previousCropId,
      String coordinates, Long climateZoneId) {
    this.id = id;
    this.name = name;
    this.area = area;
    this.cropId = cropId;
    this.previousCropId = previousCropId;
    this.coordinates = coordinates;
    this.climateZoneId = climateZoneId;
  }

  public static FieldEntity newFieldEntity(Long id, String name, Double area, Long cropId,
      Long previousCropId, String coordinates, Long climateZoneId) {
    if (id == 0) id = null;
    return new FieldEntity(id, name, area, cropId, previousCropId, coordinates, climateZoneId);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    FieldEntity that = (FieldEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    if (area != null ? !area.equals(that.area) : that.area != null) return false;
    if (cropId != null ? !cropId.equals(that.cropId) : that.cropId != null) return false;
    if (previousCropId != null ? !previousCropId.equals(that.previousCropId)
        : that.previousCropId != null) {
      return false;
    }
    if (coordinates != null ? !coordinates.equals(that.coordinates) : that.coordinates != null) {
      return false;
    }
    return climateZoneId != null ? climateZoneId.equals(that.climateZoneId)
        : that.climateZoneId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (area != null ? area.hashCode() : 0);
    result = 31 * result + (cropId != null ? cropId.hashCode() : 0);
    result = 31 * result + (previousCropId != null ? previousCropId.hashCode() : 0);
    result = 31 * result + (coordinates != null ? coordinates.hashCode() : 0);
    result = 31 * result + (climateZoneId != null ? climateZoneId.hashCode() : 0);
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

  public Double getArea() {
    return area;
  }

  public void setArea(Double area) {
    this.area = area;
  }

  public Long getCropId() {
    return cropId;
  }

  public void setCropId(Long cropId) {
    this.cropId = cropId;
  }

  public Long getPreviousCropId() {
    return previousCropId;
  }

  public void setPreviousCropId(Long previousCropId) {
    this.previousCropId = previousCropId;
  }

  public String getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(String coordinates) {
    this.coordinates = coordinates;
  }

  public Long getClimateZoneId() {
    return climateZoneId;
  }

  public void setClimateZoneId(Long climateZoneId) {
    this.climateZoneId = climateZoneId;
  }
}
