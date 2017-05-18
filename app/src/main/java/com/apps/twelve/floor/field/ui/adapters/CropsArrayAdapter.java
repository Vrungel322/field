package com.apps.twelve.floor.field.ui.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.apps.twelve.floor.field.mvp.data.local.objects.CropObject;
import java.util.ArrayList;

/**
 * Created by Yaroslav on 16.05.2017.
 */

public class CropsArrayAdapter extends ArrayAdapter<CropObject> {

  public CropsArrayAdapter(@NonNull Context context, @LayoutRes int resource,
      @NonNull ArrayList<CropObject> objects) {
    super(context, resource, objects);
  }

  @NonNull @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    return super.getView(position, convertView, parent);
  }
}
