package com.apps.twelve.floor.field.ui.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.apps.twelve.floor.field.mvp.data.local.objects.SoilTypeObject;
import java.util.ArrayList;

/**
 * Created by Yaroslav on 20.05.2017.
 */

public class SoilTypesArrayAdapter extends ArrayAdapter<SoilTypeObject> {

  public SoilTypesArrayAdapter(@NonNull Context context, @LayoutRes int resource,
      @NonNull ArrayList<SoilTypeObject> objects) {
    super(context, resource, objects);
  }

  @NonNull @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    return super.getView(position, convertView, parent);
  }
}
