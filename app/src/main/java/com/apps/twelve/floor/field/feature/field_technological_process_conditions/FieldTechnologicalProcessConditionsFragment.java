package com.apps.twelve.floor.field.feature.field_technological_process_conditions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.OnClick;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.base.BaseFragment;
import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessObject;
import com.apps.twelve.floor.field.utils.Constants;
import com.apps.twelve.floor.field.utils.ViewUtil;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

/**
 * Created by yarrick on 16.08.17.
 */

public class FieldTechnologicalProcessConditionsFragment extends BaseFragment
    implements ITechnologicalProcessConditionsFragmentView {

  @InjectPresenter FieldTechnologicalProcessConditionsPresenter
      fieldTechnologicalProcessConditionsPresenter;

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
  // UI events
  ///////////////////////////////////////////////////////////////////////////

  @Override protected void updateActionBar(boolean mIsActionBarShown, String title) {
    // TODO
  }

  @Override protected void restoreActionBar() {
    // TODO
  }

  @OnClick({ R.id.btn_ok, R.id.btn_cancel }) public void onViewClicked(View view) {

    if (view.getId() == R.id.btn_ok) {
      // TODO: this is for tests
      showToastMessage("В тестовой версии изменения данных не сохраняются");
      // TODO: update conditions, if all necessary are checked - open solution fragment
    }

    ViewUtil.hideKeyboard(getActivity());
    mNavigator.popBackStack((AppCompatActivity) getActivity());
  }

  ///////////////////////////////////////////////////////////////////////////
  // Private methods
  ///////////////////////////////////////////////////////////////////////////

  private void setupRecyclerView() {
    // TODO: setup recycler view for conditions
  }
}
