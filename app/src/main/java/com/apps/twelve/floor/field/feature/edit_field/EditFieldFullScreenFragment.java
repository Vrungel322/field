package com.apps.twelve.floor.field.feature.edit_field;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.base.BaseFragment;
import com.apps.twelve.floor.field.data.local.objects.CropObject;
import com.apps.twelve.floor.field.data.local.objects.FieldObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.ClimateZoneObject;
import com.apps.twelve.floor.field.utils.Constants;
import com.apps.twelve.floor.field.utils.ViewUtil;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav on 05.04.2017.
 */

public class EditFieldFullScreenFragment extends BaseFragment implements IEditFieldFragmentView {

  @InjectPresenter EditFieldPresenter mEditFieldPresenter;

  @ProvidePresenter EditFieldPresenter provideEditFieldPresenter() {
    return new EditFieldPresenter(
        getArguments().getParcelable(Constants.EditField.FIELD_BUNDLE_KEY));
  }

  @BindView(R.id.ed_text_name) EditText mEdTextName;
  @BindView(R.id.ed_text_area) EditText mEdTextArea;
  @BindView(R.id.ed_text_planned_yield) EditText mEdTextPlannedYield; // TODO
  @BindView(R.id.ed_text_sowing_date) EditText mEdTextSowingDate; // TODO
  @BindView(R.id.spinner_crop) Spinner mSpinnerCrop;
  @BindView(R.id.spinner_previous_crop) Spinner mSpinnerPreviousCrop;
  @BindView(R.id.spinner_climate_zone) Spinner mSpinnerClimateZone;
  @BindView(R.id.spinner_soil_type) Spinner mSpinnerSoilType;
  @BindView(R.id.spinner_phase) Spinner mSpinnerPhase; // TODO
  @BindView(R.id.btn_ok) Button mBtnOk;
  @BindView(R.id.btn_cancel) Button mBtnCancel;

  private CropsArrayAdapter mCropsAdapter;
  private CropsArrayAdapter mPreviousCropsAdapter;
  private ClimateZonesArrayAdapter mClimateZonesAdapter;
  private SoilTypesArrayAdapter mSoilTypesAdapter;

  public EditFieldFullScreenFragment() {
    super(R.layout.fragment_edit_field_full_screen);
  }

  public static EditFieldFullScreenFragment newInstance() {
    return newInstance(FieldObject.makeEmptyField());
  }

  public static EditFieldFullScreenFragment newInstance(FieldObject fieldObject) {
    Bundle args = new Bundle();
    EditFieldFullScreenFragment fragment = new EditFieldFullScreenFragment();
    args.putParcelable(Constants.EditField.FIELD_BUNDLE_KEY, fieldObject);
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    setupSpinnersAdapters();
  }

  ///////////////////////////////////////////////////////////////////////////
  // MvpView methods
  ///////////////////////////////////////////////////////////////////////////

  @Override public void setFieldNameText(String name) {
    mEdTextName.setText(name);
  }

  @Override public void setFieldAreaText(String area) {
    mEdTextArea.setText(area);
  }

  @Override public void setBtnOkEnabled(boolean isEnabled) {
    mBtnOk.setEnabled(isEnabled);
  }

  @Override public void addCropsToSpinnerAdapter(List<CropObject> crops) {
    mCropsAdapter.addAll(crops);
  }

  @Override public void addPreviousCropsToSpinnerAdapter(List<CropObject> crops) {
    mPreviousCropsAdapter.addAll(crops);
  }

  @Override public void addClimateZonesToSpinnerAdapter(List<ClimateZoneObject> climateZones) {
    mClimateZonesAdapter.addAll(climateZones);
  }

  @Override public void setSelectedCrop(CropObject cropObject) {
    int position = mCropsAdapter.getPosition(cropObject);
    mSpinnerCrop.setSelection(position < 0 ? 0 : position);
  }

  @Override public void setSelectedPreviousCrop(CropObject cropObject) {
    int position = mPreviousCropsAdapter.getPosition(cropObject);
    mSpinnerPreviousCrop.setSelection(position < 0 ? 0 : position);
  }

  @Override public void setSelectedClimateZone(ClimateZoneObject climateZoneObject) {
    int position = mClimateZonesAdapter.getPosition(climateZoneObject);
    mSpinnerClimateZone.setSelection(position < 0 ? 0 : position);
  }

  ///////////////////////////////////////////////////////////////////////////
  // UI events
  ///////////////////////////////////////////////////////////////////////////

  @OnClick({ R.id.btn_ok, R.id.btn_cancel }) public void onViewClicked(View view) {
    switch (view.getId()) {
      case R.id.btn_ok:
        updateFieldData();
        mEditFieldPresenter.saveField();
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

  // when finished editing text - clear EditText's focus
  @OnEditorAction({ R.id.ed_text_area, R.id.ed_text_name }) public boolean onEditorAction(
      EditText editText, int actionId, KeyEvent event) {
    if (actionId == EditorInfo.IME_ACTION_DONE) {
      // user has done typing.
      editText.clearFocus();
      ViewUtil.hideKeyboard(getActivity());
    }

    return false; // pass on to other listeners.
  }

  ///////////////////////////////////////////////////////////////////////////
  // Private section
  ///////////////////////////////////////////////////////////////////////////

  private void setupSpinnersAdapters() {
    setupCropsSpinnerAdapter();
    setupPreviousCropsSpinnerAdapter();
    setupClimateZonesSpinnerAdapter();
    setupSoilTypesSpinnerAdapter();
  }

  private void setupCropsSpinnerAdapter() {
    mCropsAdapter = new CropsArrayAdapter(getContext(), android.R.layout.simple_spinner_item,
        new ArrayList<>());
    mCropsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    mSpinnerCrop.setAdapter(mCropsAdapter);
    mSpinnerCrop.setOnItemSelectedListener(new OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mEditFieldPresenter.updateFieldCrop(mCropsAdapter.getItem(position));
      }

      @Override public void onNothingSelected(AdapterView<?> parent) {
        mEditFieldPresenter.updateFieldCrop(null);
      }
    });
  }

  private void setupPreviousCropsSpinnerAdapter() {
    mPreviousCropsAdapter =
        new CropsArrayAdapter(getContext(), android.R.layout.simple_spinner_item,
            new ArrayList<>());
    mPreviousCropsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    mSpinnerPreviousCrop.setAdapter(mPreviousCropsAdapter);
    mSpinnerPreviousCrop.setOnItemSelectedListener(new OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mEditFieldPresenter.updateFieldPreviousCrop(mPreviousCropsAdapter.getItem(position));
      }

      @Override public void onNothingSelected(AdapterView<?> parent) {
        mEditFieldPresenter.updateFieldPreviousCrop(null);
      }
    });
  }

  private void setupClimateZonesSpinnerAdapter() {
    mClimateZonesAdapter =
        new ClimateZonesArrayAdapter(getContext(), android.R.layout.simple_spinner_item,
            new ArrayList<>());
    mClimateZonesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    mSpinnerClimateZone.setAdapter(mClimateZonesAdapter);
    mSpinnerClimateZone.setOnItemSelectedListener(new OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mEditFieldPresenter.updateFieldClimateZone(mClimateZonesAdapter.getItem(position));
      }

      @Override public void onNothingSelected(AdapterView<?> parent) {
        mEditFieldPresenter.updateFieldClimateZone(null);
      }
    });
  }

  private void setupSoilTypesSpinnerAdapter() {
    mSoilTypesAdapter =
        new SoilTypesArrayAdapter(getContext(), android.R.layout.simple_spinner_item,
            new ArrayList<>());
    mSoilTypesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    mSpinnerSoilType.setAdapter(mSoilTypesAdapter);
    mSpinnerSoilType.setOnItemSelectedListener(new OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mEditFieldPresenter.updateFieldSoilType(mSoilTypesAdapter.getItem(position));
      }

      @Override public void onNothingSelected(AdapterView<?> parent) {
        mEditFieldPresenter.updateFieldSoilType(null);
      }
    });
  }

  private void updateFieldData() {
    mEditFieldPresenter.updateFieldName(mEdTextName.getText().toString());
    mEditFieldPresenter.updateFieldArea(mEdTextArea.getText().toString());
    // TODO: Crop must be selected from list
    //mEditFieldPresenter.updateFieldCrop(selectedCropObject);
  }
}
