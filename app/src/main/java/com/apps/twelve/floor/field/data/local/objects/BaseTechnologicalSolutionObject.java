package com.apps.twelve.floor.field.data.local.objects;

/*import android.os.Parcelable;*/

/**
 * Created by Yaroslav on 29.05.2017.
 */

// TODO: implement Parcelable - for children-objects
public abstract class BaseTechnologicalSolutionObject /*implements Parcelable*/ {

  abstract public long getId();

  abstract public void setId(long id);

  abstract public String getName();

  abstract public void setName(String name);

  abstract public long getPrice();

  abstract public void setPrice(long price);

  abstract public TechnologicalSolutionTypeObject getType();

  abstract public void setType(TechnologicalSolutionTypeObject type);
}
