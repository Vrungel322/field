package com.apps.twelve.floor.field.data.local.entities.conditions;

import com.apps.twelve.floor.field.data.local.tables.conditions.WeedTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Vrungel on 04.07.2017.
 */
@StorIOSQLiteType(table = WeedTable.TABLE) public class WeedEntity {

  @StorIOSQLiteColumn(name = WeedTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = WeedTable.COLUMN_HARMFUL_OBJ_TYPE_ID) Long harmfulObjTypeId;
  @StorIOSQLiteColumn(name = WeedTable.COLUMN_NAME) String name;
  @StorIOSQLiteColumn(name = WeedTable.COLUMN_NUTRITION_TYPE_ID) Long nutritionTypeId;
  @StorIOSQLiteColumn(name = WeedTable.COLUMN_CLASS_ID) Long classId;
  @StorIOSQLiteColumn(name = WeedTable.COLUMN_GROUP_ID) Long groupId;

  public WeedEntity() {
  }

  public WeedEntity(Long id, Long harmfulObjTypeId, String name, Long nutritionTypeId, Long classId,
      Long groupId) {
    this.id = id;
    this.harmfulObjTypeId = harmfulObjTypeId;
    this.name = name;
    this.nutritionTypeId = nutritionTypeId;
    this.classId = classId;
    this.groupId = groupId;
  }

  public static WeedEntity newWeedEntity(Long id, Long harmfulObjTypeId, String name,
      Long nutritionTypeId, Long classId, Long groupId) {
    if (id == 0) id = null;
    return new WeedEntity(id, harmfulObjTypeId, name, nutritionTypeId, classId, groupId);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    WeedEntity that = (WeedEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (harmfulObjTypeId != null ? !harmfulObjTypeId.equals(that.harmfulObjTypeId)
        : that.harmfulObjTypeId != null) {
      return false;
    }
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    if (nutritionTypeId != null ? !nutritionTypeId.equals(that.nutritionTypeId)
        : that.nutritionTypeId != null) {
      return false;
    }
    if (classId != null ? !classId.equals(that.classId) : that.classId != null) return false;

    return groupId != null ? groupId.equals(that.groupId) : that.groupId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (harmfulObjTypeId != null ? harmfulObjTypeId.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (nutritionTypeId != null ? nutritionTypeId.hashCode() : 0);
    result = 31 * result + (classId != null ? classId.hashCode() : 0);
    result = 31 * result + (groupId != null ? groupId.hashCode() : 0);

    return result;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getHarmfulObjTypeId() {
    return harmfulObjTypeId;
  }

  public void setHarmfulObjTypeId(Long harmfulObjTypeId) {
    this.harmfulObjTypeId = harmfulObjTypeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getNutritionTypeId() {
    return nutritionTypeId;
  }

  public void setNutritionTypeId(Long nutritionTypeId) {
    this.nutritionTypeId = nutritionTypeId;
  }

  public Long getClassId() {
    return classId;
  }

  public void setClassId(Long classId) {
    this.classId = classId;
  }

  public Long getGroupId() {
    return groupId;
  }

  public void setGroupId(Long groupId) {
    this.groupId = groupId;
  }
}
