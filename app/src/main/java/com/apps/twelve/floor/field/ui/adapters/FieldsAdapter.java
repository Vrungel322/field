package com.apps.twelve.floor.field.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.mvp.data.model.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav on 28 03 2017.
 */

public class FieldsAdapter extends RecyclerView.Adapter<FieldsAdapter.FieldViewHolder> {

  private ArrayList<Field> fieldsList = new ArrayList<>();

  @Override public FieldViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.filed_list_item, parent, false);
    return new FieldViewHolder(view);
  }

  @Override public void onBindViewHolder(FieldViewHolder holder, int position) {
    Field field = fieldsList.get(position);
    holder.nameText.setText(field.getName());
    holder.areaText.setText(String.valueOf((int)field.getArea()));
  }

  @Override public int getItemCount() {
    return fieldsList.size();
  }

  public void addAllFileds(List<Field> fields) {
    fieldsList.clear();
    fieldsList.addAll(fields);
    notifyDataSetChanged();
  }

  public static class FieldViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.name_text) TextView nameText;
    @BindView(R.id.area_text) TextView areaText;

    public FieldViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
