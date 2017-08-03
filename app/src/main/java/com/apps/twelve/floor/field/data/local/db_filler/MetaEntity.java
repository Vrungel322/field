package com.apps.twelve.floor.field.data.local.db_filler;

/**
 * Created by yarrick on 01.08.17.
 */

public class MetaEntity {

  public String entityKey;
  public String entityJsonValue;
  //public IEntity[] entitiesArray;

  /*public MetaEntity(String entityKey, IEntity[] entitiesArray) {
    this.entityKey = entityKey;
    this.entitiesArray = entitiesArray;
  }*/

  public MetaEntity(String entityKey, String entityJsonValue) {
    this.entityKey = entityKey;
    this.entityJsonValue = entityJsonValue;
  }
}
