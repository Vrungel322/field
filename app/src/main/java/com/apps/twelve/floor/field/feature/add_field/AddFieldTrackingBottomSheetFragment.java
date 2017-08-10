package com.apps.twelve.floor.field.feature.add_field;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ToggleButton;
import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.adapters.ClimateZonesArrayAdapter;
import com.apps.twelve.floor.field.adapters.CropsArrayAdapter;
import com.apps.twelve.floor.field.adapters.PhasesArrayAdapter;
import com.apps.twelve.floor.field.adapters.SoilTypesArrayAdapter;
import com.apps.twelve.floor.field.base.BaseFragment;
import com.apps.twelve.floor.field.data.local.objects.CropObject;
import com.apps.twelve.floor.field.data.local.objects.SoilTypeObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.ClimateZoneObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.PhaseObject;
import com.apps.twelve.floor.field.feature.edit_field.EditFieldPresenter;
import com.apps.twelve.floor.field.feature.edit_field.IEditFieldFragmentView;
import com.apps.twelve.floor.field.utils.Constants;
import com.apps.twelve.floor.field.utils.ViewUtil;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav on 20.04.2017.
 */

public class AddFieldTrackingBottomSheetFragment extends BaseFragment
    implements IEditFieldFragmentView {

  @InjectPresenter EditFieldPresenter mEditFieldPresenter;
  @BindView(R.id.toggle_button_tracking_mode) ToggleButton mTglBtnTrackingMode;
  @BindView(R.id.ed_text_name) EditText mEdTextName;
  @BindView(R.id.ed_text_area) EditText mEdTextArea;
  @BindView(R.id.spinner_crop) Spinner mSpinnerCrop;
  @BindView(R.id.spinner_previous_crop) Spinner mSpinnerPreviousCrop;
  @BindView(R.id.spinner_climate_zone) Spinner mSpinnerClimateZone;
  @BindView(R.id.spinner_soil_type) Spinner mSpinnerSoilType;
  @BindView(R.id.spinner_phase) Spinner mSpinnerPhase;
  @BindView(R.id.btn_ok) Button mBtnOk;
  @BindView(R.id.btn_cancel) Button mBtnCancel;
  private CropsArrayAdapter mCropsAdapter;
  private CropsArrayAdapter mPreviousCropsAdapter;
  private ClimateZonesArrayAdapter mClimateZonesAdapter;
  private SoilTypesArrayAdapter mSoilTypesAdapter;
  private PhasesArrayAdapter mPhasesAdapter;
  public AddFieldTrackingBottomSheetFragment() {
    super(R.layout.fragment_tracking_field_bottom_sheet, true, R.string.title_new_field);
  }

  public static AddFieldTrackingBottomSheetFragment newInstance() {
    Bundle args = new Bundle();
    AddFieldTrackingBottomSheetFragment fragment = new AddFieldTrackingBottomSheetFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @ProvidePresenter EditFieldPresenter provideEditFieldPresenter() {
    return new EditFieldPresenter(
        getArguments().getParcelable(Constants.EditField.FIELD_BUNDLE_KEY));
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    setupSpinnersAdapters();
  }

  @Override protected void updateActionBar(boolean mIsActionBarShown, String title) {
    // do nothing - this fragment is additional
  }

  @Override protected void restoreActionBar() {
    // do nothing - this fragment is additional
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

  @Override public void addPhasesToSpinnerAdapter(List<PhaseObject> phases) {
    mPhasesAdapter.addAll(phases);
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

  @Override public void setSelectedPhase(PhaseObject phase) {
    int position = mPhasesAdapter.getPosition(phase);
    mSpinnerPhase.setSelection(position < 0 ? 0 : position);
  }

  @Override public void addSoilTypesToSpinnerAdapter(List<SoilTypeObject> soilTypes) {
    mSoilTypesAdapter.addAll(soilTypes);
  }

  @Override public void setSelectedSoilType(SoilTypeObject soilType) {
    int position = mSoilTypesAdapter.getPosition(soilType);
    mSpinnerSoilType.setSelection(position);
  }

  ///////////////////////////////////////////////////////////////////////////
  // UI events
  ///////////////////////////////////////////////////////////////////////////

  @OnClick({ R.id.btn_ok, R.id.btn_cancel }) public void onViewClicked(View view) {
    switch (view.getId()) {
      case R.id.btn_ok:
        updateFieldData();
        mEditFieldPresenter.saveField();
        mNavigator.popBackStack((AppCompatActivity) getActivity());
        break;
      case R.id.btn_cancel:
        mNavigator.popBackStack((AppCompatActivity) getActivity());
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

  @OnCheckedChanged(R.id.toggle_button_tracking_mode)
  public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    // TODO: maybe block edTexts
    mEditFieldPresenter.setTrackingMode(isChecked);
  }

  ///////////////////////////////////////////////////////////////////////////
  // Private section
  ///////////////////////////////////////////////////////////////////////////

  private void setupSpinnersAdapters() {
    setupCropsSpinnerAdapter();
    setupPreviousCropsSpinnerAdapter();
    setupClimateZonesSpinnerAdapter();
    setupSoilTypesSpinnerAdapter();
    setupPhasesSpinnerAdapter();
  }

  private void setupCropsSpinnerAdapter() {
    mCropsAdapter = new CropsArrayAdapter(getContext(), android.R.layout.simple_spinner_item,
        new ArrayList<>());
    mCropsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    mSpinnerCrop.setAdapter(mCropsAdapter);
    mSpinnerCrop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
    mSpinnerPreviousCrop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
    mSpinnerClimateZone.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
    mSpinnerSoilType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mEditFieldPresenter.updateFieldSoilType(mSoilTypesAdapter.getItem(position));
      }

      @Override public void onNothingSelected(AdapterView<?> parent) {
        mEditFieldPresenter.updateFieldSoilType(null);
      }
    });
  }

  private void setupPhasesSpinnerAdapter() {
    mPhasesAdapter = new PhasesArrayAdapter(getContext(), android.R.layout.simple_spinner_item,
        new ArrayList<>());
    mPhasesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    mSpinnerPhase.setAdapter(mPhasesAdapter);
    mSpinnerPhase.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mEditFieldPresenter.updateFieldPhase(mPhasesAdapter.getItem(position));
      }

      @Override public void onNothingSelected(AdapterView<?> parent) {
        mEditFieldPresenter.updateFieldPhase(null);
      }
    });
  }

  private void updateFieldData() {
    mEditFieldPresenter.updateFieldName(mEdTextName.getText().toString());
    mEditFieldPresenter.updateFieldArea(mEdTextArea.getText().toString());
  }
}
