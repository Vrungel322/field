package com.apps.twelve.floor.field.feature.field_technological_map.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.data.local.objects.FieldTechnologicalProcessObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav on 23.05.2017.
 */

public class FieldTechnologicalProcessesAdapter extends
    RecyclerView.Adapter<FieldTechnologicalProcessesAdapter.FieldTechnologicalProcessesViewHolder> {

  private ArrayList<FieldTechnologicalProcessObject> mTechProcessesList = new ArrayList<>();

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

  public void addAllFieldTechnologicalProcesses(List<FieldTechnologicalProcessObject> processes) {
    mTechProcessesList.addAll(processes);
    notifyDataSetChanged();
  }

  public void addFieldTechnologicalProcess(FieldTechnologicalProcessObject process) {
    mTechProcessesList.add(process);
    notifyItemInserted(mTechProcessesList.size() - 1);
  }

  public FieldTechnologicalProcessObject getTechProcessAt(int position) {
    return mTechProcessesList.get(position);
  }

  ///////////////////////////////////////////////////////////////////////////
  // Private section
  ///////////////////////////////////////////////////////////////////////////

  private void updateViewHolder(FieldTechnologicalProcessesViewHolder holder, int position) {
    FieldTechnologicalProcessObject fieldTechProcess = mTechProcessesList.get(position);

    // TODO: shorten method chains
    /*holder.mTextProcessName.setText(fieldTechProcess.getTechProcess().getName());
    holder.mTextProcessPeriod.setText(fieldTechProcess.getTechProcess()
        .getTime()
        .getPeriod()
        .getRepresentation(holder.mItemView.getContext()));
    holder.mImageStatus.setImageResource(fieldTechProcess.getStatus().getImageId());*/
  }

  static class FieldTechnologicalProcessesViewHolder extends RecyclerView.ViewHolder {

    private View mItemView;
    @BindView(R.id.text_process_name) TextView mTextProcessName;
    @BindView(R.id.text_process_period) TextView mTextProcessPeriod;
    @BindView(R.id.image_status) ImageView mImageStatus;

    FieldTechnologicalProcessesViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(itemView);
      this.mItemView = itemView;
    }
  }
}
