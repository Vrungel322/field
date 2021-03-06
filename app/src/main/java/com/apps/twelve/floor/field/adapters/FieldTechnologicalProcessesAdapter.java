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

public class FieldTechnologicalProcessesAdapter extends
    RecyclerView.Adapter<FieldTechnologicalProcessesAdapter.FieldTechnologicalProcessesViewHolder> {

  private ArrayList<FieldCropTechnologicalProcessObject> mTechProcessesList = new ArrayList<>();

  public FieldTechnologicalProcessesAdapter() {
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

    // TODO: shorten method chains
    holder.mTextProcessName.setText(fieldTechProcess.getTechProcessName());
    holder.mTextProcessPeriod.setText(
        fieldTechProcess.getTechProcessPeriodRepresentation(holder.mItemView.getContext()));
    holder.mImageStatus.setImageResource(fieldTechProcess.getStatusImageId());
    // TODO: status id is from test data
    holder.mImageFrame.setVisibility(
        (fieldTechProcess.getState().getId() == 2) ? View.VISIBLE : View.INVISIBLE);
  }

  static class FieldTechnologicalProcessesViewHolder extends RecyclerView.ViewHolder {

    private View mItemView;
    @BindView(R.id.text_process_name) TextView mTextProcessName;
    @BindView(R.id.text_process_period) TextView mTextProcessPeriod;
    @BindView(R.id.image_status) ImageView mImageStatus;
    @BindView(R.id.image_frame) ImageView mImageFrame;

    FieldTechnologicalProcessesViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
      this.mItemView = itemView;
    }
  }
}
