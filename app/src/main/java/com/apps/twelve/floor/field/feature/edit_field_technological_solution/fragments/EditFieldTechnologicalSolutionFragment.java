package com.apps.twelve.floor.field.feature.edit_field_technological_solution.fragments;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.base.BaseFragment;
import com.apps.twelve.floor.field.data.local.objects.TechnologicalProcessSolutionObject;
import com.apps.twelve.floor.field.data.local.objects.TechnologicalSolutionTypeObject;
import com.apps.twelve.floor.field.feature.edit_field_technological_solution.presenters.EditFieldTechnologicalSolutionPresenter;
import com.apps.twelve.floor.field.feature.edit_field_technological_solution.views.ITechnologicalSolutionFragmentView;
import com.apps.twelve.floor.field.utils.TestUtils;
import com.apps.twelve.floor.field.utils.ViewUtil;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
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
  @BindView(R.id.text_total) TextView mTextTotal;
  @BindView(R.id.btn_ok) Button mBtnOk;
  @BindView(R.id.btn_cancel) Button mBtnCancel;

  @ProvidePresenter
  EditFieldTechnologicalSolutionPresenter provideEditFieldTechnologicalSolutionPresenter() {
    // TODO: uncomment this when TechnologicalSolutionObject will be Parcelable
    return new EditFieldTechnologicalSolutionPresenter(
        TestUtils.makeAggregateObject(1, "Plow", null, 100500L));
    /*
    return new EditFieldTechnologicalSolutionPresenter(
        getArguments().getParcelable(Constants.EditField.FIELD_TECHNOLOGICAL_PROCESS_SOLUTION_BUNDLE_KEY));*/
  }

  public EditFieldTechnologicalSolutionFragment() {
    super(R.layout.fragment_field_technological_solution);
  }

  public static EditFieldTechnologicalSolutionFragment newInstance(
      TechnologicalProcessSolutionObject solution) {
    // TODO: uncomment this when TechnologicalProcessSolutionObject will be Parcelable
    //Bundle args = new Bundle();
    EditFieldTechnologicalSolutionFragment fragment = new EditFieldTechnologicalSolutionFragment();
    //args.putParcelable(Constants.EditField.FIELD_TECHNOLOGICAL_SOLUTION_BUNDLE_KEY, solution);
    //fragment.setArguments(args);
    return fragment;
  }

  ///////////////////////////////////////////////////////////////////////////
  // MVP methods
  ///////////////////////////////////////////////////////////////////////////

  @Override public void addSolutionTypesToSpinnerAdapter(
      List<TechnologicalSolutionTypeObject> solutionTypes) {
    // TODO: make adapter and add values to it
  }

  @Override public void setSelectedSolutionType(TechnologicalSolutionTypeObject type) {
    // TODO: make adapter and set selected value
  }

  ///////////////////////////////////////////////////////////////////////////
  // UI events
  ///////////////////////////////////////////////////////////////////////////

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
}
