package com.apps.twelve.floor.field.data.local.objects.solutions;

import android.os.Parcelable;
import com.apps.twelve.floor.field.data.local.objects.IObject;

/**
 * Created by Yaroslav on 29.05.2017.
 */

public abstract class BaseTechnologicalSolutionObject implements IObject, Parcelable {

  abstract public long getId();

  abstract public void setId(long id);

  abstract public String getName();

  abstract public void setName(String name);

  abstract public long getPrice();

  abstract public void setPrice(long price);

  abstract public TechnologicalSolutionTypeObject getType();

  abstract public void setType(TechnologicalSolutionTypeObject type);
}
