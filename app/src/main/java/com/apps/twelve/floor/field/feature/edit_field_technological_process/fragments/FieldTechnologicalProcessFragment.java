package com.apps.twelve.floor.field.feature.edit_field_technological_process.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.base.BaseFragment;
import com.apps.twelve.floor.field.data.local.objects.FieldTechnologicalProcessObject;
import com.apps.twelve.floor.field.data.local.objects.TechnologicalProcessSolutionObject;
import com.apps.twelve.floor.field.feature.edit_field_technological_process.adapters.TechnologicalSolutionAdapter;
import com.apps.twelve.floor.field.feature.edit_field_technological_process.presenters.FieldTechnologicalProcessPresenter;
import com.apps.twelve.floor.field.feature.edit_field_technological_process.views.ITechnologicalProcessFragmentView;
import com.apps.twelve.floor.field.feature.edit_field_technological_solution.fragments.EditFieldTechnologicalSolutionFragment;
import com.apps.twelve.floor.field.utils.ItemClickSupport;
import com.apps.twelve.floor.field.utils.TestUtils;
import com.apps.twelve.floor.field.utils.ViewUtil;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import java.util.List;

/**
 * Created by Yaroslav on 25.05.2017.
 */

public class FieldTechnologicalProcessFragment extends BaseFragment
    implements ITechnologicalProcessFragmentView {

  @InjectPresenter FieldTechnologicalProcessPresenter mFieldTechnologicalProcessPresenter;

  TechnologicalSolutionAdapter mTechnologicalSolutionAdapter;

  @BindView(R.id.text_description) TextView mTextDescription;
  @BindView(R.id.spinner_tech_process_status) Spinner mSpinnerTechProcessStatus;
  @BindView(R.id.ed_text_done_date) EditText mEditTextDoneDate;
  @BindView(R.id.recycler_view_solutions) RecyclerView mRecyclerViewSolutions;
  @BindView(R.id.fab_add_new_solution) FloatingActionButton mFabAddNewSolution;
  @BindView(R.id.text_total) TextView mTextTotal;
  @BindView(R.id.btn_ok) Button mBtnOk;
  @BindView(R.id.btn_cancel) Button mBtnCancel;

  @ProvidePresenter FieldTechnologicalProcessPresenter provideTechnologicalProcessPresenter() {
    // TODO: uncomment this when TechnologicalProcessObject will be Parcelable
    return new FieldTechnologicalProcessPresenter(TestUtils.makeFieldTechnologicalProcessObject());
    /*
    return new FieldTechnologicalProcessPresenter(
        getArguments().getParcelable(Constants.EditField.FIELD_TECHNOLOGICAL_PROCESS_BUNDLE_KEY));*/
  }

  public FieldTechnologicalProcessFragment() {
    super(R.layout.fragment_field_technological_process);
  }

  public static FieldTechnologicalProcessFragment newInstance(
      FieldTechnologicalProcessObject processObject) {
    // TODO: uncomment this when TechnologicalProcessObject will be Parcelable
    //Bundle args = new Bundle();
    FieldTechnologicalProcessFragment fragment = new FieldTechnologicalProcessFragment();
    //args.putParcelable(Constants.EditField.FIELD_TECHNOLOGICAL_PROCESS_BUNDLE_KEY, processObject);
    //fragment.setArguments(args);
    return fragment;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    setupRecyclerView();
  }

  ///////////////////////////////////////////////////////////////////////////
  // MVP methods
  ///////////////////////////////////////////////////////////////////////////

  @Override public void showTechnologicalSolutions(
      List<TechnologicalProcessSolutionObject> technologicalSolutionsObjectList) {
    mTechnologicalSolutionAdapter.addAllTechnologicalSolutions(technologicalSolutionsObjectList);
  }

  @Override public void openEditFieldTechnologicalSolutionFragment(int position) {
    mNavigator.addFragmentBackStack(((AppCompatActivity) getActivity()), R.id.container_start,
        makeEditFieldTechnologicalSolutionFragment(
            mTechnologicalSolutionAdapter.getSolutionAt(position)));
  }

  private Fragment makeEditFieldTechnologicalSolutionFragment(
      @NonNull TechnologicalProcessSolutionObject solution) {
    return EditFieldTechnologicalSolutionFragment.newInstance(solution);
  }

  ///////////////////////////////////////////////////////////////////////////
  // UI events
  ///////////////////////////////////////////////////////////////////////////

  @OnClick({ R.id.fab_add_new_solution, R.id.btn_ok, R.id.btn_cancel })
  public void onViewClicked(View view) {
    switch (view.getId()) {
      case R.id.btn_ok:
        /*updateTechnologicalProcessData();
        mFieldTechnologicalProcessPresenter.saveFieldTechnologicalProcess();*/
        ViewUtil.hideKeyboard(getActivity());
        mNavigator.popBackStack((AppCompatActivity) getActivity());
        break;
      case R.id.btn_cancel:
        ViewUtil.hideKeyboard(getActivity());
        mNavigator.popBackStack((AppCompatActivity) getActivity());
        break;
      case R.id.fab_add_new_solution:
        mFieldTechnologicalProcessPresenter.onAddNewSolutionClicked();
        break;
      default:
        break;
    }
  }

  ///////////////////////////////////////////////////////////////////////////
  // Private section
  ///////////////////////////////////////////////////////////////////////////

  private void setupRecyclerView() {
    mTechnologicalSolutionAdapter = new TechnologicalSolutionAdapter();
    mRecyclerViewSolutions.setAdapter(mTechnologicalSolutionAdapter);
    mRecyclerViewSolutions.setLayoutManager(new LinearLayoutManager(getContext()));
    mRecyclerViewSolutions.setItemAnimator(new DefaultItemAnimator());

    DividerItemDecoration dividerItemDecoration =
        new DividerItemDecoration(getContext(), RecyclerView.VERTICAL);
    dividerItemDecoration.setDrawable(
        ContextCompat.getDrawable(getContext(), R.drawable.shape_list_item_divider));
    mRecyclerViewSolutions.addItemDecoration(dividerItemDecoration);

    ItemClickSupport.addTo(mRecyclerViewSolutions)
        .setOnItemClickListener(
            (recyclerView, position, v) -> mFieldTechnologicalProcessPresenter.onSolutionClickedAtPosition(
                position));
  }
}
