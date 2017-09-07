package com.apps.twelve.floor.field.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.apps.twelve.floor.field.data.local.objects.solutions.BaseTechnologicalSolutionObject;
import java.util.ArrayList;

/**
 * Created by yarrick on 10.08.17.
 */

public class TechnologicalSolutionValuesArrayAdapter
    extends ArrayAdapter<BaseTechnologicalSolutionObject> {

  public TechnologicalSolutionValuesArrayAdapter(@NonNull Context context, @LayoutRes int resource,
      @NonNull ArrayList<BaseTechnologicalSolutionObject> objects) {
    super(context, resource, objects);
  }

  @NonNull @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    return super.getView(position, convertView, parent);
  }
}
