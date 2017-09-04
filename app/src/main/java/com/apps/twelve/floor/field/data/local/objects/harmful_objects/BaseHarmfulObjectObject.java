package com.apps.twelve.floor.field.data.local.objects.harmful_objects;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.objects.IObject;

/**
 * Created by yarrick on 04.09.17.
 */

public abstract class BaseHarmfulObjectObject implements IObject, Parcelable, Cloneable {

  abstract public long getId();

  abstract public void setId(long id);

  @NonNull abstract public String getName();

  abstract public void setName(@NonNull String name);

  @NonNull abstract public HarmfulObjectTypeObject getType();

  abstract public void setType(@NonNull HarmfulObjectTypeObject type);

  @NonNull abstract public String getRepresentation();
}
