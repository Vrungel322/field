package com.apps.twelve.floor.field.data.local.mappers.solutions;

import com.apps.twelve.floor.field.data.local.entities.solutions.ProductEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.solutions.ProductObject;

/**
 * Created by Yaroslav on 22.06.2017.
 */

public class ProductObjectToProductEntityMapper implements Mapper<ProductObject, ProductEntity> {
  @Override public ProductEntity transform(ProductObject obj) throws RuntimeException {
    // TODO: need doze for product
    return ProductEntity.newProductEntity(obj.getId(), obj.getName(), obj.getType().getId(),
        obj.getCategory().getId(), 0L /*TODO*/, obj.getPrice());
  }
}
