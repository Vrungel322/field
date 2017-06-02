package com.apps.twelve.floor.field.data.local.entities;

import com.apps.twelve.floor.field.data.local.tables.ProductsPestsCropsTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Yaroslav on 02.06.2017.
 */

@StorIOSQLiteType(table = ProductsPestsCropsTable.TABLE) public class ProductPestCropEntity {

  @StorIOSQLiteColumn(name = ProductsPestsCropsTable.COLUMN_ID, key = true) Long id;
  @StorIOSQLiteColumn(name = ProductsPestsCropsTable.COLUMN_PRODUCT_ID) Long productId;
  @StorIOSQLiteColumn(name = ProductsPestsCropsTable.COLUMN_PEST_ID) Long pestId;
  @StorIOSQLiteColumn(name = ProductsPestsCropsTable.COLUMN_CROP_ID) Long cropId;

  public ProductPestCropEntity() {
  }

  public ProductPestCropEntity(Long id, Long productId, Long pestId, Long cropId) {
    this.id = id;
    this.productId = productId;
    this.pestId = pestId;
    this.cropId = cropId;
  }

  public static ProductPestCropEntity newFieldEntityProductPestCropEntity(Long id, Long productId,
      Long pestId, Long cropId) {
    if (id == 0) id = null;
    return new ProductPestCropEntity(id, productId, pestId, cropId);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    ProductPestCropEntity that = (ProductPestCropEntity) obj;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (productId != null ? !productId.equals(that.productId) : that.productId != null) {
      return false;
    }
    if (pestId != null ? !pestId.equals(that.pestId) : that.pestId != null) return false;
    return cropId != null ? cropId.equals(that.cropId) : that.cropId == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (productId != null ? productId.hashCode() : 0);
    result = 31 * result + (pestId != null ? pestId.hashCode() : 0);
    result = 31 * result + (cropId != null ? cropId.hashCode() : 0);
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

  public Long getPestId() {
    return pestId;
  }

  public void setPestId(Long pestId) {
    this.pestId = pestId;
  }

  public Long getCropId() {
    return cropId;
  }

  public void setCropId(Long cropId) {
    this.cropId = cropId;
  }
}
