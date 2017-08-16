package com.apps.twelve.floor.field.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.R;
import java.util.ArrayList;

/**
 * Created by yarrick on 16.08.17.
 */

public class FieldTechnologicalProcessConditionsAdapter
    extends RecyclerView.Adapter<FieldTechnologicalProcessConditionsAdapter.ConditionViewHolder> {

  private ArrayList<FieldTechnologicalProcessConditionObject> mConditionList = new ArrayList<>();

  public FieldTechnologicalProcessConditionsAdapter() {
    super();
    App.getAppComponent().inject(this);
  }

  @Override public ConditionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_technological_process_condition, parent, false);
    return new ConditionViewHolder(view);
  }

  @Override public void onBindViewHolder(ConditionViewHolder holder, int position) {
    updateHolder(holder, position);
  }

  @Override public int getItemCount() {
    return mConditionList.size();
  }

  private void updateHolder(ConditionViewHolder holder, int position) {
    FieldTechnologicalProcessConditionObject condition = mConditionList.get(position);

    holder.mConditionCheckedText.setText(condition.getName());
    holder.mConditionCheckedText.setChecked(condition.isFulfilled());
  }

  static class ConditionViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.checked_text_condition) CheckedTextView mConditionCheckedText;

    public ConditionViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
