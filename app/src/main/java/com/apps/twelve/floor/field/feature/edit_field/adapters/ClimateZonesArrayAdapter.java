package com.apps.twelve.floor.field.feature.edit_field.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.apps.twelve.floor.field.data.local.objects.ClimateZoneObject;
import java.util.ArrayList;

/**
 * Created by Yaroslav on 17.05.2017.
 */

public class ClimateZonesArrayAdapter extends ArrayAdapter<ClimateZoneObject> {

  public ClimateZonesArrayAdapter(@NonNull Context context, @LayoutRes int resource,
      @NonNull ArrayList<ClimateZoneObject> objects) {
    super(context, resource, objects);
  }

  @NonNull @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    return super.getView(position, convertView, parent);
  }
}
