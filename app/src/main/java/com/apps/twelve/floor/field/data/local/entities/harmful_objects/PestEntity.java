package com.apps.twelve.floor.field.data.local.entities.harmful_objects;

import com.apps.twelve.floor.field.data.local.tables.harmful_objects.PestsTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 10.05.2017.
 */

@StorIOSQLiteType(table = PestsTable.TABLE) public class PestEntity {

  @StorIOSQLiteColumn(name = PestsTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = PestsTable.COLUMN_HARMFUL_OBJ_TYPE_ID) Long harmfulObjectTypeId;
  @StorIOSQLiteColumn(name = PestsTable.COLUMN_NAME) String name;
  @StorIOSQLiteColumn(name = PestsTable.COLUMN_CLASS_ID) Long classId;
  @StorIOSQLiteColumn(name = PestsTable.COLUMN_ORDER_ID) Long orderId;

  public PestEntity() {
  }

  public PestEntity(Long id, Long harmfulObjectTypeId, String name, Long classId, Long orderId) {
    this.id = id;
    this.harmfulObjectTypeId = harmfulObjectTypeId;
    this.name = name;
    this.classId = classId;
    this.orderId = orderId;
  }

  public static PestEntity newPestEntity(Long id, Long harmfulObjectTypeId, String name,
      Long classId, Long orderId) {
    if (id == 0) id = null;
    return new PestEntity(id, harmfulObjectTypeId, name, classId, orderId);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    PestEntity that = (PestEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (harmfulObjectTypeId != null ? !harmfulObjectTypeId.equals(that.harmfulObjectTypeId)
        : that.harmfulObjectTypeId != null) {
      return false;
    }
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    if (classId != null ? !classId.equals(that.classId) : that.classId != null) return false;

    return orderId != null ? orderId.equals(that.orderId) : that.orderId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (harmfulObjectTypeId != null ? harmfulObjectTypeId.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (classId != null ? classId.hashCode() : 0);
    result = 31 * result + (orderId != null ? orderId.hashCode() : 0);

    return result;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getHarmfulObjectTypeId() {
    return harmfulObjectTypeId;
  }

  public void setHarmfulObjectTypeId(Long harmfulObjectTypeId) {
    this.harmfulObjectTypeId = harmfulObjectTypeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getClassId() {
    return classId;
  }

  public void setClassId(Long classId) {
    this.classId = classId;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }
}
