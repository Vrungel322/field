package com.apps.twelve.floor.field.data.local.db_filler;

import com.apps.twelve.floor.field.data.local.entities.IEntity;

/**
 * Created by yarrick on 01.08.17.
 */

public class MetaEntity {
  private String entityKey;
  private IEntity[] entitiesArray;

  public MetaEntity(String entityKey, IEntity[] entitiesArray) {
    this.entityKey = entityKey;
    this.entitiesArray = entitiesArray;
  }

  public String getEntityKey() {
    return entityKey;
  }

  public void setEntityKey(String entityKey) {
    this.entityKey = entityKey;
  }

  public IEntity[] getEntitiesArray() {
    return entitiesArray;
  }

  public void setEntitiesArray(IEntity[] entitiesArray) {
    this.entitiesArray = entitiesArray;
  }
}
