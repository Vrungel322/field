package com.apps.twelve.floor.field.data.local.db_filler;

import com.apps.twelve.floor.field.data.local.entities.IEntity;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import timber.log.Timber;

/**
 * Created by yarrick on 15.08.17.
 */

public class MetaEntityDeserializer implements JsonDeserializer<MetaEntity> {

  private static final String KEY_ENTITY_CLASS_NAME = "EntityKey";
  private static final String KEY_ENTITIES_ARRAY = "EntitiesArray";

  @Override
  public MetaEntity deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {

    JsonObject jsonObject = json.getAsJsonObject();

    String entityClassName = jsonObject.get(KEY_ENTITY_CLASS_NAME).getAsString();
    JsonArray entitiesAsJson = jsonObject.getAsJsonArray(KEY_ENTITIES_ARRAY);

    Class<?> entityClass;
    try {
      entityClass = Class.forName(entityClassName);
    } catch (ClassNotFoundException e) {
      Timber.e(e);
      return null;
    }

    IEntity[] entities = new IEntity[entitiesAsJson.size()];
    for (int i = 0; i < entitiesAsJson.size(); i++) {
      entities[i] = context.deserialize(entitiesAsJson.get(i), entityClass);
    }

    return new MetaEntity(entityClassName, entities);
  }
}
