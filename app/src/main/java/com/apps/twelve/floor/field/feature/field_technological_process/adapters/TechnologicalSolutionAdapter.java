package com.apps.twelve.floor.field.feature.field_technological_process.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.data.local.objects.TechnologicalSolutionObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav on 25.05.2017.
 */

public class TechnologicalSolutionAdapter
    extends RecyclerView.Adapter<TechnologicalSolutionAdapter.TechnologicalSolutionViewHolder> {

  private ArrayList<TechnologicalSolutionObject> mTechnologicalSolutionObjectsList =
      new ArrayList<>();

  public TechnologicalSolutionAdapter() {
    super();
  }

  @Override
  public TechnologicalSolutionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_solution, parent, false);
    return new TechnologicalSolutionViewHolder(view);
  }

  @Override public void onBindViewHolder(TechnologicalSolutionViewHolder holder, int position) {
    updateViewHolder(holder, position);
  }

  @Override public int getItemCount() {
    return mTechnologicalSolutionObjectsList.size();
  }

  public void addAllTechnologicalSolutions(List<TechnologicalSolutionObject> solutions) {
    mTechnologicalSolutionObjectsList.addAll(solutions);
    notifyDataSetChanged();
  }

  public void addTechnologicalSolution(TechnologicalSolutionObject solution) {
    mTechnologicalSolutionObjectsList.add(solution);
    notifyItemInserted(mTechnologicalSolutionObjectsList.size() - 1);
  }

  public TechnologicalSolutionObject getSolutionAt(int position) {
    return mTechnologicalSolutionObjectsList.get(position);
  }

  ///////////////////////////////////////////////////////////////////////////
  // Private section
  ///////////////////////////////////////////////////////////////////////////

  private void updateViewHolder(TechnologicalSolutionViewHolder holder, int position) {
    TechnologicalSolutionObject technologicalSolution =
        mTechnologicalSolutionObjectsList.get(position);

    // TODO: update view holder
  }

  static class TechnologicalSolutionViewHolder extends RecyclerView.ViewHolder {

    private View mItemView;

    TechnologicalSolutionViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(itemView);
      this.mItemView = itemView;
    }
  }
}
