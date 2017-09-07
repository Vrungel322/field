package com.apps.twelve.floor.field.feature.field_technological_solution;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.adapters.TechnologicalSolutionTypesArrayAdapter;
import com.apps.twelve.floor.field.adapters.TechnologicalSolutionValuesArrayAdapter;
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

public class FieldTechnologicalSolutionFragment extends BaseFragment
    implements ITechnologicalSolutionFragmentView {

  @InjectPresenter FieldTechnologicalSolutionPresenter mFieldTechnologicalSolutionPresenter;

  // TODO: add adapters for solution types and values

  @BindView(R.id.spinner_tech_solution_type) Spinner mSpinnerTechSolutionType;
  @BindView(R.id.spinner_tech_solution) Spinner mSpinnerTechSolution;
  @BindView(R.id.ed_text_quantity) EditText mEditTextQuantity;
  @BindView(R.id.ed_text_price) EditText mEditTextPrice;
  @BindView(R.id.text_sum) TextView mTextSum;
  @BindView(R.id.btn_ok) Button mBtnOk;
  @BindView(R.id.btn_cancel) Button mBtnCancel;

  private TechnologicalSolutionTypesArrayAdapter mSolutionTypeAdapter;
  private TechnologicalSolutionValuesArrayAdapter mSolutionValueAdapter;

  @ProvidePresenter
  FieldTechnologicalSolutionPresenter provideEditFieldTechnologicalSolutionPresenter() {
    return new FieldTechnologicalSolutionPresenter(getArguments().getParcelable(
        Constants.EditField.FIELD_TECHNOLOGICAL_PROCESS_SOLUTION_BUNDLE_KEY));
  }

  public FieldTechnologicalSolutionFragment() {
    super(R.layout.fragment_field_technological_solution, true, R.string.title_solution);
  }

  public static FieldTechnologicalSolutionFragment newInstance(
      TechnologicalSolutionObject solution) {
    Bundle args = new Bundle();
    FieldTechnologicalSolutionFragment fragment = new FieldTechnologicalSolutionFragment();
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
    mSolutionValueAdapter.clear();
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

  @Override public void updateTextQuantity(String quantity) {
    mEditTextQuantity.setText(quantity);
  }

  @Override public void updateTextPrice(String price) {
    mEditTextPrice.setText(price);
  }

  @Override public void updateTextSum(String sum) {
    mTextSum.setText(
        String.format(getString(R.string.text_technological_process_solution_sum), sum));
  }

  ///////////////////////////////////////////////////////////////////////////
  // UI events
  ///////////////////////////////////////////////////////////////////////////

  @Override protected void updateActionBar(boolean mIsActionBarShown, String title) {
    mFieldTechnologicalSolutionPresenter.updateActionBar(mIsActionBarShown, title);
  }

  @Override protected void restoreActionBar() {
    mFieldTechnologicalSolutionPresenter.restoreActionBar();
  }

  @OnClick({ R.id.btn_ok, R.id.btn_cancel }) public void onViewClicked(View view) {

    if (view.getId() == R.id.btn_ok) {
      // TODO: this is for tests
      showToastMessage("В тестовой версии изменения данных не сохраняются");
      // TODO: uncomment this
        /*updateTechnologicalSolutionData();
        mFieldTechnologicalSolutionPresenter.saveFieldTechnologicalSolution();*/
    }

    ViewUtil.hideKeyboard(getActivity());
    mNavigator.popBackStack((AppCompatActivity) getActivity());
  }

  // when finished editing text - clear EditText's focus
  @OnEditorAction({ R.id.ed_text_quantity, R.id.ed_text_price }) public boolean onEditorAction(
      EditText editText, int actionId, KeyEvent event) {
    if (actionId == EditorInfo.IME_ACTION_DONE) {
      // user has done typing.
      editText.clearFocus();
      ViewUtil.hideKeyboard(getActivity());
    }

    if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_NEXT) {
      if (editText.getId() == R.id.ed_text_quantity) {
        mFieldTechnologicalSolutionPresenter.updateQuantity(
            Long.parseLong(editText.getText().toString()));
      } else if (editText.getId() == R.id.ed_text_price) {
        mFieldTechnologicalSolutionPresenter.updatePrice(
            Long.parseLong(editText.getText().toString()));
      }
    }

    return false; // pass on to other listeners.
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
        mFieldTechnologicalSolutionPresenter.updateSolutionType(
            mSolutionTypeAdapter.getItem(position));
      }

      @Override public void onNothingSelected(AdapterView<?> parent) {
        mFieldTechnologicalSolutionPresenter.updateSolutionType(null);
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
        mFieldTechnologicalSolutionPresenter.updateSolutionValue(
            mSolutionValueAdapter.getItem(position));
      }

      @Override public void onNothingSelected(AdapterView<?> parent) {
        mFieldTechnologicalSolutionPresenter.updateSolutionValue(null);
      }
    });
  }
}
