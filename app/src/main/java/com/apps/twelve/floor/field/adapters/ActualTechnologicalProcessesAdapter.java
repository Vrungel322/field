package com.apps.twelve.floor.field.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav on 23.05.2017.
 */

public class ActualTechnologicalProcessesAdapter extends
    RecyclerView.Adapter<ActualTechnologicalProcessesAdapter.FieldTechnologicalProcessesViewHolder> {

  private ArrayList<FieldCropTechnologicalProcessObject> mTechProcessesList = new ArrayList<>();

  public ActualTechnologicalProcessesAdapter() {
    super();
  }

  @Override
  public FieldTechnologicalProcessesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_technological_process, parent, false);
    return new FieldTechnologicalProcessesViewHolder(view);
  }

  @Override
  public void onBindViewHolder(FieldTechnologicalProcessesViewHolder holder, int position) {
    updateViewHolder(holder, position);
  }

  @Override public int getItemCount() {
    return mTechProcessesList.size();
  }

  public void addAllFieldTechnologicalProcesses(
      List<FieldCropTechnologicalProcessObject> processes) {
    mTechProcessesList.addAll(processes);
    notifyDataSetChanged();
  }

  public void addFieldTechnologicalProcess(FieldCropTechnologicalProcessObject process) {
    mTechProcessesList.add(process);
    notifyItemInserted(mTechProcessesList.size() - 1);
  }

  public FieldCropTechnologicalProcessObject getTechProcessAt(int position) {
    return mTechProcessesList.get(position);
  }

  ///////////////////////////////////////////////////////////////////////////
  // Private section
  ///////////////////////////////////////////////////////////////////////////

  private void updateViewHolder(FieldTechnologicalProcessesViewHolder holder, int position) {
    FieldCropTechnologicalProcessObject fieldTechProcess = mTechProcessesList.get(position);

    holder.mTextProcessName.setText(fieldTechProcess.getTechProcessName());
    holder.mTextProcessField.setText(
        holder.mTextProcessField.getHint() + fieldTechProcess.getTechProcessFieldRepresentation());
    holder.mTextProcessPeriod.setText(
        fieldTechProcess.getTechProcessPeriodRepresentation(holder.mItemView.getContext()));
    holder.mImageStatus.setImageResource(fieldTechProcess.getStatusImageId());

    holder.mTextProcessField.setVisibility(View.VISIBLE);
  }

  static class FieldTechnologicalProcessesViewHolder extends RecyclerView.ViewHolder {

    private View mItemView;
    @BindView(R.id.text_process_name) TextView mTextProcessName;
    @BindView(R.id.text_process_field) TextView mTextProcessField;
    @BindView(R.id.text_process_period) TextView mTextProcessPeriod;
    @BindView(R.id.image_status) ImageView mImageStatus;

    FieldTechnologicalProcessesViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
      this.mItemView = itemView;
    }
  }
}
