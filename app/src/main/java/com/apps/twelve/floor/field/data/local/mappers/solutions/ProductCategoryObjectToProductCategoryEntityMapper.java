package com.apps.twelve.floor.field.data.local.mappers.solutions;

import com.apps.twelve.floor.field.data.local.entities.solutions.ProductCategoryEntity;
import com.apps.twelve.floor.field.data.local.mappers.Mapper;
import com.apps.twelve.floor.field.data.local.objects.solutions.ProductCategoryObject;

/**
 * Created by Yaroslav on 21.06.2017.
 */

public class ProductCategoryObjectToProductCategoryEntityMapper
    implements Mapper<ProductCategoryObject, ProductCategoryEntity> {
  @Override public ProductCategoryEntity transform(ProductCategoryObject obj)
      throws RuntimeException {
    return ProductCategoryEntity.newProductCategoryEntity(obj.getId(), obj.getName());
  }
}
