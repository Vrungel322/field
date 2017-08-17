package com.apps.twelve.floor.field.feature.field_technological_process_conditions;

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
import android.widget.Button;
import butterknife.BindView;
import butterknife.OnClick;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.adapters.FieldTechnologicalProcessConditionsAdapter;
import com.apps.twelve.floor.field.base.BaseFragment;
import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessConditionObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessObject;
import com.apps.twelve.floor.field.feature.field_technological_process.FieldTechnologicalProcessFragment;
import com.apps.twelve.floor.field.utils.Constants;
import com.apps.twelve.floor.field.utils.ItemClickSupport;
import com.apps.twelve.floor.field.utils.ViewUtil;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import java.util.List;

/**
 * Created by yarrick on 16.08.17.
 */

public class FieldTechnologicalProcessConditionsFragment extends BaseFragment
    implements ITechnologicalProcessConditionsFragmentView {

  @InjectPresenter FieldTechnologicalProcessConditionsPresenter
      mFieldTechnologicalProcessConditionsPresenter;

  @BindView(R.id.recycler_view_conditions) RecyclerView mConditionsRecyclerView;
  @BindView(R.id.btn_ok) Button mBtnOk;
  @BindView(R.id.btn_cancel) Button mBtnCancel;

  FieldTechnologicalProcessConditionsAdapter mFieldTechnologicalProcessConditionsAdapter;

  @ProvidePresenter
  FieldTechnologicalProcessConditionsPresenter provideTechnologicalProcessConditionsPresenter() {
    return new FieldTechnologicalProcessConditionsPresenter(
        getArguments().getParcelable(Constants.EditField.FIELD_TECHNOLOGICAL_PROCESS_BUNDLE_KEY));
  }

  public FieldTechnologicalProcessConditionsFragment() {
    super(R.layout.fragment_field_technological_process_conditions, true,
        R.string.title_technological_process_conditions);
  }

  public static FieldTechnologicalProcessConditionsFragment newInstance(
      FieldCropTechnologicalProcessObject processObject) {
    Bundle args = new Bundle();
    FieldTechnologicalProcessConditionsFragment fragment =
        new FieldTechnologicalProcessConditionsFragment();
    args.putParcelable(Constants.EditField.FIELD_TECHNOLOGICAL_PROCESS_BUNDLE_KEY, processObject);
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    setupRecyclerView();
  }

  ///////////////////////////////////////////////////////////////////////////
  // MVP methods
  ///////////////////////////////////////////////////////////////////////////
  @Override public void showConditions(
      List<FieldCropTechnologicalProcessConditionObject> conditions) {
    mFieldTechnologicalProcessConditionsAdapter.addAllConditions(conditions);
  }

  @Override public void updateCondition(FieldCropTechnologicalProcessConditionObject condition) {
    mFieldTechnologicalProcessConditionsAdapter.updateCondition(condition);
  }

  @Override
  public void openTechnologicalProcessFragment(FieldCropTechnologicalProcessObject process) {
    //mNavigator.addFragmentBackStack(((AppCompatActivity) getActivity()), R.id.container_start, makeFieldTechnologicalProcessFragment(process));
    mNavigator.replaceFragmentBackStack(((AppCompatActivity) getActivity()), R.id.container_start,
        makeFieldTechnologicalProcessFragment(process));
  }

  ///////////////////////////////////////////////////////////////////////////
  // UI events
  ///////////////////////////////////////////////////////////////////////////

  @Override protected void updateActionBar(boolean mIsActionBarShown, String title) {
    mFieldTechnologicalProcessConditionsPresenter.updateActionBar(mIsActionBarShown, title);
  }

  @Override protected void restoreActionBar() {
    mFieldTechnologicalProcessConditionsPresenter.restoreActionBar();
  }

  @OnClick({ R.id.btn_ok, R.id.btn_cancel }) public void onViewClicked(View view) {

    ViewUtil.hideKeyboard(getActivity());

    if (view.getId() == R.id.btn_ok) {
      // TODO: this is for tests
      showToastMessage("В тестовой версии изменения данных не сохраняются");
      // TODO: if all necessary are checked - open solution fragment
      mFieldTechnologicalProcessConditionsPresenter.onOkClicked();
    } else if (view.getId() == R.id.btn_cancel) {
      mNavigator.popBackStack((AppCompatActivity) getActivity());
    }
  }

  ///////////////////////////////////////////////////////////////////////////
  // Private methods
  ///////////////////////////////////////////////////////////////////////////

  private void setupRecyclerView() {
    mFieldTechnologicalProcessConditionsAdapter = new FieldTechnologicalProcessConditionsAdapter();
    mConditionsRecyclerView.setAdapter(mFieldTechnologicalProcessConditionsAdapter);
    mConditionsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    mConditionsRecyclerView.setItemAnimator(new DefaultItemAnimator());

    DividerItemDecoration dividerItemDecoration =
        new DividerItemDecoration(getContext(), RecyclerView.VERTICAL);
    dividerItemDecoration.setDrawable(
        ContextCompat.getDrawable(getContext(), R.drawable.shape_list_item_divider));
    mConditionsRecyclerView.addItemDecoration(dividerItemDecoration);

    // TODO: uncomment this
    // TODO: update condition in DB
    /*ItemClickSupport.addTo(mConditionsRecyclerView)
        .setOnItemClickListener(
            (recyclerView, position, v) -> mFieldTechnologicalProcessConditionsPresenter.onConditionClickedAtPosition(
                position));*/
    // TODO: remove this, tis for tests
    ItemClickSupport.addTo(mConditionsRecyclerView)
        .setOnItemClickListener(
            (recyclerView, position, v) -> mFieldTechnologicalProcessConditionsAdapter.updateConditionAtPosition(
                position));
  }

  private Fragment makeFieldTechnologicalProcessFragment(
      @NonNull FieldCropTechnologicalProcessObject processObject) {
    return FieldTechnologicalProcessFragment.newInstance(processObject);
  }
}
