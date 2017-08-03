package com.apps.twelve.floor.field.data.local.entities.solutions;

import com.apps.twelve.floor.field.data.local.entities.IEntity;
import com.apps.twelve.floor.field.data.local.tables.solutions.ActiveComponentsInProductsTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by yarrick on 06.07.17.
 */

@StorIOSQLiteType(table = ActiveComponentsInProductsTable.TABLE)
public class ActiveComponentInProductEntity implements IEntity {

  @StorIOSQLiteColumn(name = ActiveComponentsInProductsTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = ActiveComponentsInProductsTable.COLUMN_PRODUCT_ID) Long productId;
  @StorIOSQLiteColumn(name = ActiveComponentsInProductsTable.COLUMN_ACTIVE_COMPONENT_ID) Long
      activeComponentId;
  @StorIOSQLiteColumn(name = ActiveComponentsInProductsTable.COLUMN_DOZE) String doze;

  public ActiveComponentInProductEntity() {
  }

  public ActiveComponentInProductEntity(Long id, Long productId, Long activeComponentId,
      String doze) {
    this.id = id;
    this.productId = productId;
    this.activeComponentId = activeComponentId;
    this.doze = doze;
  }

  public static ActiveComponentInProductEntity newActiveComponentInProductEntity(Long id,
      Long productId, Long activeComponentId, String doze) {
    if (id == 0) id = null;
    return new ActiveComponentInProductEntity(id, productId, activeComponentId, doze);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    ActiveComponentInProductEntity that = (ActiveComponentInProductEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (productId != null ? !productId.equals(that.productId) : that.productId != null) {
      return false;
    }
    if (activeComponentId != null ? !activeComponentId.equals(that.activeComponentId)
        : that.activeComponentId != null) {
      return false;
    }

    return doze != null ? doze.equals(that.doze) : that.doze == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (productId != null ? productId.hashCode() : 0);
    result = 31 * result + (activeComponentId != null ? activeComponentId.hashCode() : 0);
    result = 31 * result + (doze != null ? doze.hashCode() : 0);
    return result;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public Long getActiveComponentId() {
    return activeComponentId;
  }

  public void setActiveComponentId(Long activeComponentId) {
    this.activeComponentId = activeComponentId;
  }

  public String getDoze() {
    return doze;
  }

  public void setDoze(String doze) {
    this.doze = doze;
  }
}
