package com.apps.twelve.floor.field.feature.edit_field_technological_solution;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.TechnologicalSolutionValuesArrayAdapter;
import com.apps.twelve.floor.field.adapters.TechnologicalSolutionTypesArrayAdapter;
import com.apps.twelve.floor.field.base.BaseFragment;
import com.apps.twelve.floor.field.data.local.objects.solutions.BaseTechnologicalSolutionObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.TechnologicalSolutionObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.TechnologicalSolutionTypeObject;
import com.apps.twelve.floor.field.utils.Constants;
import com.apps.twelve.floor.field.utils.ViewUtil;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav on 29.05.2017.
 */

public class EditFieldTechnologicalSolutionFragment extends BaseFragment
    implements ITechnologicalSolutionFragmentView {

  @InjectPresenter EditFieldTechnologicalSolutionPresenter mEditFieldTechnologicalSolutionPresenter;

  // TODO: add adapters for solution types and values

  @BindView(R.id.spinner_tech_solution_type) Spinner mSpinnerTechSolutionType;
  @BindView(R.id.spinner_tech_solution) Spinner mSpinnerTechSolution;
  @BindView(R.id.ed_text_quantity) EditText mEditTextQuantity;
  @BindView(R.id.ed_text_price) EditText mEditTextPrice;
  @BindView(R.id.text_amount) TextView mTextAmount;
  @BindView(R.id.btn_ok) Button mBtnOk;
  @BindView(R.id.btn_cancel) Button mBtnCancel;

  private TechnologicalSolutionTypesArrayAdapter mSolutionTypeAdapter;
  private TechnologicalSolutionValuesArrayAdapter mSolutionValueAdapter;

  @ProvidePresenter
  EditFieldTechnologicalSolutionPresenter provideEditFieldTechnologicalSolutionPresenter() {
    return new EditFieldTechnologicalSolutionPresenter(getArguments().getParcelable(
        Constants.EditField.FIELD_TECHNOLOGICAL_PROCESS_SOLUTION_BUNDLE_KEY));
  }

  public EditFieldTechnologicalSolutionFragment() {
    super(R.layout.fragment_field_technological_solution, true, R.string.title_solution);
  }

  public static EditFieldTechnologicalSolutionFragment newInstance(
      TechnologicalSolutionObject solution) {
    Bundle args = new Bundle();
    EditFieldTechnologicalSolutionFragment fragment = new EditFieldTechnologicalSolutionFragment();
    args.putParcelable(Constants.EditField.FIELD_TECHNOLOGICAL_PROCESS_SOLUTION_BUNDLE_KEY,
        solution);
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    setupSpinnersAdapters();
  }

  ///////////////////////////////////////////////////////////////////////////
  // MVP methods
  ///////////////////////////////////////////////////////////////////////////

  @Override public void addSolutionTypesToSpinnerAdapter(
      List<TechnologicalSolutionTypeObject> solutionTypes) {
    mSolutionTypeAdapter.addAll(solutionTypes);
  }

  @Override public void addSolutionValuesToSpinnerAdapter(
      List<BaseTechnologicalSolutionObject> solutionValues) {
    mSolutionValueAdapter.addAll(solutionValues);
  }

  @Override public void setSelectedSolutionType(TechnologicalSolutionTypeObject solutionType) {
    int position = mSolutionTypeAdapter.getPosition(solutionType);
    mSpinnerTechSolutionType.setSelection(position < 0 ? 0 : position);
  }

  @Override public void setSelectedSolutionValue(BaseTechnologicalSolutionObject solutionValue) {
    int position = mSolutionValueAdapter.getPosition(solutionValue);
    mSpinnerTechSolution.setSelection(position < 0 ? 0 : position);
  }

  ///////////////////////////////////////////////////////////////////////////
  // UI events
  ///////////////////////////////////////////////////////////////////////////

  @Override protected void updateActionBar(boolean mIsActionBarShown, String title) {
    mEditFieldTechnologicalSolutionPresenter.updateActionBar(mIsActionBarShown, title);
  }

  @Override protected void restoreActionBar() {
    mEditFieldTechnologicalSolutionPresenter.restoreActionBar();
  }

  @OnClick({ R.id.btn_ok, R.id.btn_cancel }) public void onViewClicked(View view) {
    switch (view.getId()) {
      case R.id.btn_ok:
        // TODO: uncomment this
        /*updateTechnologicalSolutionData();
        mEditFieldTechnologicalSolutionPresenter.saveFieldTechnologicalSolution();*/
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
  // Private methods
  ///////////////////////////////////////////////////////////////////////////

  private void setupSpinnersAdapters() {
    setupSolutionTypeSpinnerAdapter();
    setupSolutionValueSpinnerAdapter();
  }

  private void setupSolutionTypeSpinnerAdapter() {
    mSolutionTypeAdapter = new TechnologicalSolutionTypesArrayAdapter(getContext(),
        android.R.layout.simple_spinner_item, new ArrayList<>());
    mSolutionTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    mSpinnerTechSolutionType.setAdapter(mSolutionTypeAdapter);
    mSpinnerTechSolutionType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mEditFieldTechnologicalSolutionPresenter.updateSolutionType(
            mSolutionTypeAdapter.getItem(position));
      }

      @Override public void onNothingSelected(AdapterView<?> parent) {
        mEditFieldTechnologicalSolutionPresenter.updateSolutionType(null);
      }
    });
  }

  private void setupSolutionValueSpinnerAdapter() {
    mSolutionValueAdapter = new TechnologicalSolutionValuesArrayAdapter(getContext(),
        android.R.layout.simple_spinner_item, new ArrayList<>());
    mSolutionValueAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    mSpinnerTechSolution.setAdapter(mSolutionValueAdapter);
    mSpinnerTechSolution.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mEditFieldTechnologicalSolutionPresenter.updateSolutionValue(
            mSolutionValueAdapter.getItem(position));
      }

      @Override public void onNothingSelected(AdapterView<?> parent) {
        mEditFieldTechnologicalSolutionPresenter.updateSolutionValue(null);
      }
    });
  }
}
