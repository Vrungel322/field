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
import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessConditionObject;
import java.util.ArrayList;
import java.util.List;
import timber.log.Timber;

/**
 * Created by yarrick on 16.08.17.
 */

public class FieldTechnologicalProcessConditionsAdapter
    extends RecyclerView.Adapter<FieldTechnologicalProcessConditionsAdapter.ConditionViewHolder> {

  private ArrayList<FieldCropTechnologicalProcessConditionObject> mConditionList =
      new ArrayList<>();

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

  public void addAllConditions(List<FieldCropTechnologicalProcessConditionObject> conditions) {
    mConditionList.addAll(conditions);
    notifyDataSetChanged();
  }

  public void addCondition(FieldCropTechnologicalProcessConditionObject condition) {
    mConditionList.add(condition);
    notifyItemInserted(mConditionList.size() - 1);
  }

  public FieldCropTechnologicalProcessConditionObject getConditionAt(int position) {
    return mConditionList.get(position);
  }

  public void updateConditionAtPosition(int position) {
    FieldCropTechnologicalProcessConditionObject cond = mConditionList.get(position);
    cond.setIsFulfilled(!cond.isFulfilled());
    updateCondition(cond);
  }

  public void updateCondition(FieldCropTechnologicalProcessConditionObject condition) {
    int position = mConditionList.indexOf(condition);
    if (position >= 0) {
      mConditionList.set(position, condition);
      notifyItemChanged(position);
    }
  }

  public void removeCondition(FieldCropTechnologicalProcessConditionObject condition,
      int position) {
    if (position < 0 && condition == null) {
      Timber.e(new Throwable("Trying to remove incorrect fieldObject"));
      return;
    }
    if (position < 0) position = mConditionList.indexOf(condition);

    if (position >= 0) {
      mConditionList.remove(position);
      notifyItemRemoved(position);
      notifyItemRangeChanged(position, mConditionList.size());
    }
  }

  private void updateHolder(ConditionViewHolder holder, int position) {
    FieldCropTechnologicalProcessConditionObject condition = mConditionList.get(position);

    holder.mConditionCheckedText.setText(condition.getConditionName());
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
