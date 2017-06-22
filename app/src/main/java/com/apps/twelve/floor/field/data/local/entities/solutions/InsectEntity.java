package com.apps.twelve.floor.field.data.local.entities.solutions;

import com.apps.twelve.floor.field.data.local.tables.solutions.InsectsTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 22.06.2017.
 */

@StorIOSQLiteType(table = InsectsTable.TABLE) public class InsectEntity {

  @StorIOSQLiteColumn(name = InsectsTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = InsectsTable.COLUMN_NAME) String name;
  @StorIOSQLiteColumn(name = InsectsTable.COLUMN_TECHNOLOGICAL_SOLUTION_TYPE_ID) Long
      solutionTypeId;
  @StorIOSQLiteColumn(name = InsectsTable.COLUMN_PRICE) Long price;

  public InsectEntity() {
  }

  public InsectEntity(Long id, String name, Long solutionTypeId, Long price) {
    this.id = id;
    this.name = name;
    this.solutionTypeId = solutionTypeId;
    this.price = price;
  }

  public static InsectEntity newInsectEntity(Long id, String name, Long solutionTypeId,
      Long price) {
    if (id == 0) id = null;
    return new InsectEntity(id, name, solutionTypeId, price);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    InsectEntity that = (InsectEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    if (solutionTypeId != null ? !solutionTypeId.equals(that.solutionTypeId)
        : that.solutionTypeId != null) {
      return false;
    }

    return price != null ? price.equals(that.price) : that.price == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (solutionTypeId != null ? solutionTypeId.hashCode() : 0);
    result = 31 * result + (price != null ? price.hashCode() : 0);
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

  public Long getSolutionTypeId() {
    return solutionTypeId;
  }

  public void setSolutionTypeId(Long solutionTypeId) {
    this.solutionTypeId = solutionTypeId;
  }

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }
}
