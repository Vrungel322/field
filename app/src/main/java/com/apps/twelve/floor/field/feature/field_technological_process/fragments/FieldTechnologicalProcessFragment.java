package com.apps.twelve.floor.field.feature.field_technological_process.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.base.BaseFragment;
import com.apps.twelve.floor.field.data.local.objects.FieldTechnologicalProcessObject;
import com.apps.twelve.floor.field.data.local.objects.TechnologicalSolutionObject;
import com.apps.twelve.floor.field.feature.field_technological_process.adapters.TechnologicalSolutionAdapter;
import com.apps.twelve.floor.field.feature.field_technological_process.presenters.FieldTechnologicalProcessPresenter;
import com.apps.twelve.floor.field.feature.field_technological_process.views.ITechnologicalProcessFragmentView;
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

  @BindView(R.id.text_description) TextView textDescription;
  @BindView(R.id.spinner_tech_process_status) Spinner spinnerTechProcessStatus;
  @BindView(R.id.ed_text_done_date) EditText edTextDoneDate;
  @BindView(R.id.recycler_view_solutions) RecyclerView recyclerViewSolutions;
  @BindView(R.id.fab_add_new_solution) FloatingActionButton fabAddNewSolution;
  @BindView(R.id.text_total) TextView textTotal;
  @BindView(R.id.btn_ok) Button btnOk;
  @BindView(R.id.btn_cancel) Button btnCancel;
  Unbinder unbinder;

  @ProvidePresenter FieldTechnologicalProcessPresenter provideTechnologicalProcessPresenter() {
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
      List<TechnologicalSolutionObject> technologicalSolutionsObjectList) {
    mTechnologicalSolutionAdapter.addAllTechnologicalSolutions(technologicalSolutionsObjectList);
  }

  ///////////////////////////////////////////////////////////////////////////
  // UI events
  ///////////////////////////////////////////////////////////////////////////

  @OnClick({ R.id.btn_ok, R.id.btn_cancel }) public void onViewClicked(View view) {
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
      default:
        break;
    }
  }

  ///////////////////////////////////////////////////////////////////////////
  // Private section
  ///////////////////////////////////////////////////////////////////////////

  private void setupRecyclerView() {
    mTechnologicalSolutionAdapter = new TechnologicalSolutionAdapter();
    recyclerViewSolutions.setAdapter(mTechnologicalSolutionAdapter);
    recyclerViewSolutions.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerViewSolutions.setItemAnimator(new DefaultItemAnimator());

    DividerItemDecoration dividerItemDecoration =
        new DividerItemDecoration(getContext(), RecyclerView.VERTICAL);
    dividerItemDecoration.setDrawable(
        ContextCompat.getDrawable(getContext(), R.drawable.shape_list_item_divider));
    recyclerViewSolutions.addItemDecoration(dividerItemDecoration);

    ItemClickSupport.addTo(recyclerViewSolutions)
        .setOnItemClickListener(
            (recyclerView, position, v) -> mFieldTechnologicalProcessPresenter.onSolutionClickedAtPosition(
                position));
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // TODO: inflate a fragment view
    View rootView = super.onCreateView(inflater, container, savedInstanceState);
    unbinder = ButterKnife.bind(this, rootView);
    return rootView;
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }
}
