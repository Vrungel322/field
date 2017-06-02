package com.apps.twelve.floor.field.feature.edit_field_technological_solution;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.apps.twelve.floor.field.data.local.objects.solutions.TechnologicalSolutionTypeObject;
import java.util.ArrayList;

/**
 * Created by Yaroslav on 29.05.2017.
 */

public class TechnologicalSolutionTypesArrayAdapter
    extends ArrayAdapter<TechnologicalSolutionTypeObject> {

  public TechnologicalSolutionTypesArrayAdapter(@NonNull Context context, @LayoutRes int resource,
      @NonNull ArrayList<TechnologicalSolutionTypeObject> objects) {
    super(context, resource, objects);
  }

  @NonNull @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    return super.getView(position, convertView, parent);
  }
}
