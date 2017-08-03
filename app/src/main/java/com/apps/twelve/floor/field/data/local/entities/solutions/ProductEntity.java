package com.apps.twelve.floor.field.data.local.entities.solutions;

import com.apps.twelve.floor.field.data.local.entities.IEntity;
import com.apps.twelve.floor.field.data.local.tables.solutions.ProductsTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 02.06.2017.
 */

@StorIOSQLiteType(table = ProductsTable.TABLE) public class ProductEntity implements IEntity {

  @StorIOSQLiteColumn(name = ProductsTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = ProductsTable.COLUMN_NAME) String name;
  @StorIOSQLiteColumn(name = ProductsTable.COLUMN_TECHNOLOGICAL_SOLUTION_TYPE_ID) Long
      solutionTypeId;
  @StorIOSQLiteColumn(name = ProductsTable.COLUMN_CATEGORY_ID) Long categoryId;
  @StorIOSQLiteColumn(name = ProductsTable.COLUMN_DOZE) Long doze;
  @StorIOSQLiteColumn(name = ProductsTable.COLUMN_PRICE) Long price;

  public ProductEntity() {
  }

  public ProductEntity(Long id, String name, Long solutionTypeId, Long categoryId, Long doze,
      Long price) {
    this.id = id;
    this.name = name;
    this.solutionTypeId = solutionTypeId;
    this.categoryId = categoryId;
    this.doze = doze;
    this.price = price;
  }

  public static ProductEntity newProductEntity(Long id, String name, Long solutionTypeId,
      Long categoryId, Long doze, Long price) {
    if (id == 0) id = null;
    return new ProductEntity(id, name, solutionTypeId, categoryId, doze, price);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    ProductEntity that = (ProductEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    if (solutionTypeId != null ? !solutionTypeId.equals(that.solutionTypeId)
        : that.solutionTypeId != null) {
      return false;
    }
    if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) {
      return false;
    }
    if (doze != null ? !doze.equals(that.doze) : that.doze != null) return false;

    return price != null ? price.equals(that.price) : that.price == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (solutionTypeId != null ? solutionTypeId.hashCode() : 0);
    result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
    result = 31 * result + (doze != null ? doze.hashCode() : 0);
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

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public Long getDoze() {
    return doze;
  }

  public void setDoze(Long doze) {
    this.doze = doze;
  }

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }
}
