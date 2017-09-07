package com.apps.twelve.floor.field.feature.actual_processes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.adapters.FieldTechnologicalProcessesAdapter;
import com.apps.twelve.floor.field.base.BaseFragment;
import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessObject;
import com.apps.twelve.floor.field.feature.field_technological_process.FieldTechnologicalProcessFragment;
import com.apps.twelve.floor.field.utils.ItemClickSupport;
import com.arellomobile.mvp.presenter.InjectPresenter;
import java.util.List;

/**
 * Created by yarrick on 07.09.17.
 */

public class ActualTechnologicalProcessesFragment extends BaseFragment
    implements IActualTechnologicalProcessesFragmentView {

  @InjectPresenter ActualTechnologicalProcessesPresenter mActualTechnologicalProcessesPresenter;

  @BindView(R.id.recycler_view_tech_processes) RecyclerView mTechProcessesRecyclerView;

  FieldTechnologicalProcessesAdapter mFieldTechnologicalProcessesAdapter;

  public ActualTechnologicalProcessesFragment() {
    super(R.layout.fragment_actual_technological_processes, true, R.string.title_actual_processes);
  }

  public static ActualTechnologicalProcessesFragment newInstance() {
    return new ActualTechnologicalProcessesFragment();
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    setupRecyclerView();
  }

  @Override protected void updateActionBar(boolean mIsActionBarShown, String title) {
    mActualTechnologicalProcessesPresenter.updateActionBar(mIsActionBarShown, title);
  }

  @Override protected void restoreActionBar() {
    mActualTechnologicalProcessesPresenter.restoreActionBar();
  }

  ///////////////////////////////////////////////////////////////////////////
  // MVP methods
  ///////////////////////////////////////////////////////////////////////////
  @Override public void showTechnologicalProcesses(
      List<FieldCropTechnologicalProcessObject> technologicalProcessObjectList) {
    mFieldTechnologicalProcessesAdapter.addAllFieldTechnologicalProcesses(
        technologicalProcessObjectList);
  }

  @Override public void openTechnologicalProcessFragment(int position) {
    mNavigator.addFragmentBackStack(((AppCompatActivity) getActivity()), R.id.container_start,
        makeFieldTechnologicalProcessFragment(
            mFieldTechnologicalProcessesAdapter.getTechProcessAt(position)));
  }

  ///////////////////////////////////////////////////////////////////////////
  // Private section
  ///////////////////////////////////////////////////////////////////////////
  private void setupRecyclerView() {
    mFieldTechnologicalProcessesAdapter = new FieldTechnologicalProcessesAdapter();
    mTechProcessesRecyclerView.setAdapter(mFieldTechnologicalProcessesAdapter);
    mTechProcessesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    mTechProcessesRecyclerView.setItemAnimator(new DefaultItemAnimator());

    DividerItemDecoration dividerItemDecoration =
        new DividerItemDecoration(getContext(), RecyclerView.VERTICAL);
    dividerItemDecoration.setDrawable(
        ContextCompat.getDrawable(getContext(), R.drawable.shape_list_item_divider));
    mTechProcessesRecyclerView.addItemDecoration(dividerItemDecoration);

    ItemClickSupport.addTo(mTechProcessesRecyclerView)
        .setOnItemClickListener(
            (recyclerView, position, v) -> mActualTechnologicalProcessesPresenter.onTechProcessClickedAtPosition(
                position));
  }

  private Fragment makeFieldTechnologicalProcessFragment(
      @NonNull FieldCropTechnologicalProcessObject processObject) {
    return FieldTechnologicalProcessFragment.newInstance(processObject);
  }
}
