package com.apps.twelve.floor.field.data.local.objects.conditions;

import android.os.Parcelable;

/**
 * Created by Yaroslav on 31.05.2017.
 */

public abstract class BaseConditionValueObject implements Parcelable, Cloneable {

  abstract public long getId();

  abstract public void setId(long id);

  abstract public String getName();

  abstract public void setName(String name);

  abstract public ConditionTypeObject getType();

  abstract public void setType(ConditionTypeObject type);
}
