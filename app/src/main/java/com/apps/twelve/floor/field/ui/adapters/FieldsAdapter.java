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

  private ArrayList<Field> mFieldsList = new ArrayList<>();

  @Override public FieldViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filed_list, parent, false);
    return new FieldViewHolder(view);
  }

  @Override public void onBindViewHolder(FieldViewHolder holder, int position) {
    Field field = mFieldsList.get(position);
    holder.mNameText.setText(field.getName());
    holder.mAreaText.setText(String.valueOf((int) field.getArea()));
  }

  @Override public int getItemCount() {
    return mFieldsList.size();
  }

  public void addAllFields(List<Field> fields) {
    mFieldsList.addAll(fields);
    notifyDataSetChanged();
  }

  public static class FieldViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.textViewName) TextView mNameText;
    @BindView(R.id.textViewArea) TextView mAreaText;

    public FieldViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
