package com.apps.twelve.floor.field.data.local.objects.conditions;

import android.os.Parcelable;
import com.apps.twelve.floor.field.data.local.objects.IObject;

/**
 * Created by Yaroslav on 31.05.2017.
 */

public abstract class BaseConditionValueObject implements IObject, Parcelable, Cloneable {

  abstract public long getId();

  abstract public void setId(long id);

  abstract public ConditionTypeObject getType();

  abstract public void setType(ConditionTypeObject type);

  abstract public String getRepresentation();
}
