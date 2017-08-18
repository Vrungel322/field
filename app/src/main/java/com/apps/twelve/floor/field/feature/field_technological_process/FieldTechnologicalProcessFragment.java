package com.apps.twelve.floor.field.feature.field_technological_process;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.adapters.TechnologicalProcessStateArrayAdapter;
import com.apps.twelve.floor.field.adapters.TechnologicalSolutionAdapter;
import com.apps.twelve.floor.field.base.BaseFragment;
import com.apps.twelve.floor.field.data.local.objects.solutions.FieldTechnologicalProcessSolutionObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.TechnologicalProcessStateObject;
import com.apps.twelve.floor.field.feature.field_technological_solution.FieldTechnologicalSolutionFragment;
import com.apps.twelve.floor.field.utils.Constants;
import com.apps.twelve.floor.field.utils.ItemClickSupport;
import com.apps.twelve.floor.field.utils.ViewUtil;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Yaroslav on 25.05.2017.
 */

public class FieldTechnologicalProcessFragment extends BaseFragment
    implements ITechnologicalProcessFragmentView {

  @InjectPresenter FieldTechnologicalProcessPresenter mFieldTechnologicalProcessPresenter;

  @BindView(R.id.text_description) TextView mTextDescription;
  @BindView(R.id.spinner_tech_process_state) Spinner mSpinnerTechProcessState;

  @BindView(R.id.checked_text_show_conditions) CheckedTextView mCheckedTextShowConditions;
  @BindView(R.id.scroll_view_conditions) NestedScrollView mScrollViewConditions;
  @BindView(R.id.recycler_view_conditions) RecyclerView mRecyclerViewConditions;

  @BindView(R.id.recycler_view_solutions) RecyclerView mRecyclerViewSolutions;
  @BindView(R.id.fab_add_new_solution) FloatingActionButton mFabAddNewSolution;
  @BindView(R.id.text_total_amount) TextView mTextTotalAmount;
  @BindView(R.id.ed_text_done_date) EditText mEditTextDoneDate;
  @BindView(R.id.btn_ok) Button mBtnOk;
  @BindView(R.id.btn_cancel) Button mBtnCancel;

  TechnologicalSolutionAdapter mTechnologicalSolutionAdapter;
  TechnologicalProcessStateArrayAdapter mTechnologicalProcessStateAdapter;

  private ConstraintSet mShowConditionsConstraintSet;
  private ConstraintSet mHideConditionsConstraintSet;
  private ConstraintLayout mRootConstraintLayout;

  @ProvidePresenter FieldTechnologicalProcessPresenter provideTechnologicalProcessPresenter() {
    return new FieldTechnologicalProcessPresenter(
        getArguments().getParcelable(Constants.EditField.FIELD_TECHNOLOGICAL_PROCESS_BUNDLE_KEY));
  }

  public FieldTechnologicalProcessFragment() {
    super(R.layout.fragment_field_technological_process, true,
        R.string.title_technological_process);
  }

  public static FieldTechnologicalProcessFragment newInstance(
      FieldCropTechnologicalProcessObject processObject) {
    Bundle args = new Bundle();
    FieldTechnologicalProcessFragment fragment = new FieldTechnologicalProcessFragment();
    args.putParcelable(Constants.EditField.FIELD_TECHNOLOGICAL_PROCESS_BUNDLE_KEY, processObject);
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mShowConditionsConstraintSet = new ConstraintSet();
    mHideConditionsConstraintSet = new ConstraintSet();
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    mRootConstraintLayout =
        (ConstraintLayout) super.onCreateView(inflater, container, savedInstanceState);

    mShowConditionsConstraintSet.clone(mRootConstraintLayout);
    mHideConditionsConstraintSet.clone(mShowConditionsConstraintSet);
    mHideConditionsConstraintSet.clear(R.id.scroll_view_conditions, ConstraintSet.BOTTOM);

    return mRootConstraintLayout;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    setupRecyclerViews();
    setupSpinnersAdapters();
  }

  ///////////////////////////////////////////////////////////////////////////
  // MVP methods
  ///////////////////////////////////////////////////////////////////////////

  @Override public void showTechnologicalSolutions(
      List<FieldTechnologicalProcessSolutionObject> technologicalSolutionsObjectList) {
    mTechnologicalSolutionAdapter.addAllTechnologicalSolutions(technologicalSolutionsObjectList);
  }

  @Override public void openEditFieldTechnologicalSolutionFragment(int position) {
    mNavigator.addFragmentBackStack(((AppCompatActivity) getActivity()), R.id.container_start,
        makeEditFieldTechnologicalSolutionFragment(
            mTechnologicalSolutionAdapter.getSolutionAt(position)));
  }

  @Override
  public void setSelectedTechnologicalProcessState(TechnologicalProcessStateObject state) {
    int position = mTechnologicalProcessStateAdapter.getPosition(state);
    mSpinnerTechProcessState.setSelection(position < 0 ? 0 : position);
  }

  @Override public void addTechnologicalProcessStatesToSpinnerAdapter(
      List<TechnologicalProcessStateObject> states) {
    mTechnologicalProcessStateAdapter.addAll(states);
  }

  @Override public void updateDoneDate(long doneDate) {
    SimpleDateFormat df =
        new SimpleDateFormat("dd.MM.yyyy", new Locale("uk") /*TODO: keep locale in App*/);
    mEditTextDoneDate.setText(df.format(new Date(doneDate)));
  }

  private Fragment makeEditFieldTechnologicalSolutionFragment(
      @NonNull FieldTechnologicalProcessSolutionObject solution) {
    return FieldTechnologicalSolutionFragment.newInstance(solution.getSolution());
  }

  ///////////////////////////////////////////////////////////////////////////
  // UI events
  ///////////////////////////////////////////////////////////////////////////

  @Override protected void updateActionBar(boolean mIsActionBarShown, String title) {
    mFieldTechnologicalProcessPresenter.updateActionBar(mIsActionBarShown, title);
  }

  @Override protected void restoreActionBar() {
    mFieldTechnologicalProcessPresenter.restoreActionBar();
  }

  @OnClick({
      R.id.checked_text_show_conditions, R.id.fab_add_new_solution, R.id.btn_ok, R.id.btn_cancel
  })
  public void onViewClicked(View view) {

    if (view.getId() == R.id.btn_ok) {
      /*updateTechnologicalProcessData();
        mFieldTechnologicalProcessPresenter.saveFieldTechnologicalProcess();*/
      ViewUtil.hideKeyboard(getActivity());
      mNavigator.popBackStack((AppCompatActivity) getActivity());
    } else if (view.getId() == R.id.btn_cancel) {
      ViewUtil.hideKeyboard(getActivity());
      mNavigator.popBackStack((AppCompatActivity) getActivity());
    } else if (view.getId() == R.id.fab_add_new_solution) {
      // TODO: this is for tests
      showToastMessage("Пока нельзя добавлять новые решения");

      // TODO: uncomment this
      //mFieldTechnologicalProcessPresenter.onAddNewSolutionClicked();
    } else if (view.getId() == R.id.checked_text_show_conditions) {
      showHideConditions();
    }
  }

  ///////////////////////////////////////////////////////////////////////////
  // Private section
  ///////////////////////////////////////////////////////////////////////////

  private void showHideConditions() {
    // TODO: need to fix this for low SDK
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
      return;
    }

    // TODO: pass this to presenter
    boolean isChecked = mCheckedTextShowConditions.isChecked();
    TransitionManager.beginDelayedTransition(mRootConstraintLayout);
    if (isChecked) {
      mHideConditionsConstraintSet.applyTo(mRootConstraintLayout);
    } else {
      mShowConditionsConstraintSet.applyTo(mRootConstraintLayout);
    }
    mCheckedTextShowConditions.setChecked(!isChecked);
  }

  private void setupRecyclerViews() {
    setupConditionsRecyclerView();
    setupSolutionsRecyclerView();
  }

  private void setupConditionsRecyclerView() {
    // TODO: setup adapter and other stuff to conditions
  }

  private void setupSolutionsRecyclerView() {
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

  private void setupSpinnersAdapters() {
    setupStateSpinnerAdapter();
  }

  private void setupStateSpinnerAdapter() {
    mTechnologicalProcessStateAdapter = new TechnologicalProcessStateArrayAdapter(getContext(),
        android.R.layout.simple_spinner_item,
            new ArrayList<>());
    mTechnologicalProcessStateAdapter.setDropDownViewResource(
        android.R.layout.simple_spinner_dropdown_item);

    mSpinnerTechProcessState.setAdapter(mTechnologicalProcessStateAdapter);
    mSpinnerTechProcessState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mFieldTechnologicalProcessPresenter.updateTechnologicalProcessState(
            mTechnologicalProcessStateAdapter.getItem(position));
      }

      @Override public void onNothingSelected(AdapterView<?> parent) {
        mFieldTechnologicalProcessPresenter.updateTechnologicalProcessState(null);
      }
    });
  }
}
