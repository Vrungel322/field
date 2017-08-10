package com.apps.twelve.floor.field.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.apps.twelve.floor.field.data.local.objects.process_time.PhaseObject;
import java.util.ArrayList;

/**
 * Created by Yaroslav on 08.06.2017.
 */

public class PhasesArrayAdapter extends ArrayAdapter<PhaseObject> {

  public PhasesArrayAdapter(@NonNull Context context, @LayoutRes int resource,
      @NonNull ArrayList<PhaseObject> objects) {
    super(context, resource, objects);
  }

  @NonNull @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    return super.getView(position, convertView, parent);
  }
}
