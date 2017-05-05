package com.apps.twelve.floor.field.ui.fragments;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;
import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.mvp.data.model.Field;
import com.apps.twelve.floor.field.mvp.presenters.pr_fragments.EditFieldPresenter;
import com.apps.twelve.floor.field.mvp.views.IEditFieldFragmentView;
import com.apps.twelve.floor.field.ui.base.BaseFragment;
import com.apps.twelve.floor.field.utils.Constants;
import com.apps.twelve.floor.field.utils.ViewUtil;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

/**
 * Created by Yaroslav on 20.04.2017.
 */

public class AddFieldTrackingBottomSheetFragment extends BaseFragment
    implements IEditFieldFragmentView {

  @InjectPresenter EditFieldPresenter mEditFieldPresenter;

  @ProvidePresenter EditFieldPresenter provideEditFieldPresenter() {
    return new EditFieldPresenter(
        getArguments().getParcelable(Constants.EditField.FIELD_BUNDLE_KEY));
  }

  @BindView(R.id.constraint_layout_root) ConstraintLayout mConstraintLayoutRoot;
  @BindView(R.id.toggle_button_tracking_mode) ToggleButton mTglBtnTrackingMode;
  @BindView(R.id.ed_text_name) EditText mEdTextName;
  @BindView(R.id.ed_text_area) EditText mEdTextArea;
  @BindView(R.id.ed_text_crop) EditText mEdTextCrop;
  @BindView(R.id.btn_edit_area) Button mBtnEditArea;
  @BindView(R.id.btn_ok) Button mBtnOk;
  @BindView(R.id.btn_cancel) Button mBtnCancel;

  public AddFieldTrackingBottomSheetFragment() {
    super(R.layout.fragment_tracking_field_bottom_sheet);
  }

  public static AddFieldTrackingBottomSheetFragment newInstance() {
    return newInstance(new Field());
  }

  public static AddFieldTrackingBottomSheetFragment newInstance(Field field) {
    Bundle args = new Bundle();
    args.putParcelable(Constants.EditField.FIELD_BUNDLE_KEY, field);
    AddFieldTrackingBottomSheetFragment fragment = new AddFieldTrackingBottomSheetFragment();
    fragment.setArguments(args);
    return fragment;
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

  @Override public void setFieldCropText(String crop) {
    mEdTextCrop.setText(crop);
  }

  @Override public void setBtnOkEnabled(boolean isEnabled) {
    mBtnOk.setEnabled(isEnabled);
  }

  ///////////////////////////////////////////////////////////////////////////
  // UI events
  ///////////////////////////////////////////////////////////////////////////

  @OnClick({ R.id.btn_edit_area, R.id.btn_ok, R.id.btn_cancel })
  public void onViewClicked(View view) {
    switch (view.getId()) {
      case R.id.btn_edit_area:
        // TODO: send message to presenter
        showToastMessage("onEdit");
        break;
      case R.id.btn_ok:
        updateFieldData();
        mEditFieldPresenter.saveField();
        mNavigator.popBackStack((AppCompatActivity) getActivity());
        break;
      case R.id.btn_cancel:
        showToastMessage("onCancel");
        mNavigator.popBackStack((AppCompatActivity) getActivity());
        break;
    }
  }

  // when finished editing text - clear EditText's focus
  @OnEditorAction({ R.id.ed_text_area, R.id.ed_text_name, R.id.ed_text_crop })
  public boolean onEditorAction(EditText editText, int actionId, KeyEvent event) {
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

  private void updateFieldData() {
    mEditFieldPresenter.updateFieldName(mEdTextName.getText().toString());
    mEditFieldPresenter.updateFieldArea(mEdTextArea.getText().toString());
    // TODO: get crop name by id
    //mEditFieldPresenter.updateFieldCrop(mEdTextCrop.getText().toString());
  }
}
