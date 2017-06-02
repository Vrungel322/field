package com.apps.twelve.floor.field.data.local.entities.solutions;

import com.apps.twelve.floor.field.data.local.tables.solutions.AggregatesTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 02.06.2017.
 */

@StorIOSQLiteType(table = AggregatesTable.TABLE) public class AggregateEntity {

  @StorIOSQLiteColumn(name = AggregatesTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = AggregatesTable.COLUMN_NAME) Long name;
  @StorIOSQLiteColumn(name = AggregatesTable.COLUMN_TECHNOLOGICAL_SOLUTION_TYPE_ID) Long
      solutionTypeId;
  @StorIOSQLiteColumn(name = AggregatesTable.COLUMN_PRICE) Long price;

  public AggregateEntity() {
  }

  public AggregateEntity(Long id, Long name, Long solutionTypeId, Long price) {
    this.id = id;
    this.name = name;
    this.solutionTypeId = solutionTypeId;
    this.price = price;
  }

  public static AggregateEntity newAggregateEntity(Long id, Long name, Long solutionTypeId,
      Long price) {
    if (id == 0) id = null;
    return new AggregateEntity(id, name, solutionTypeId, price);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    AggregateEntity that = (AggregateEntity) obj;

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

  public Long getName() {
    return name;
  }

  public void setName(Long name) {
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
