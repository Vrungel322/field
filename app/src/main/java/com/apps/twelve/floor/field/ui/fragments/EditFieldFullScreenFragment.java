package com.apps.twelve.floor.field.ui.fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.mvp.data.local.objects.FieldObject;
import com.apps.twelve.floor.field.mvp.presenters.pr_fragments.EditFieldPresenter;
import com.apps.twelve.floor.field.mvp.views.IEditFieldFragmentView;
import com.apps.twelve.floor.field.ui.base.BaseFragment;
import com.apps.twelve.floor.field.utils.Constants;
import com.apps.twelve.floor.field.utils.ViewUtil;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

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
  @BindView(R.id.ed_text_crop) EditText mEdTextCrop; // TODO: this must be a list
  @BindView(R.id.btn_ok) Button mBtnOk;
  @BindView(R.id.btn_cancel) Button mBtnCancel;

  public EditFieldFullScreenFragment() {
    super(R.layout.fragment_edit_field_full_screen);
  }

  public static EditFieldFullScreenFragment newInstance() {
    return newInstance(new FieldObject());
  }

  public static EditFieldFullScreenFragment newInstance(FieldObject fieldObject) {
    Bundle args = new Bundle();
    EditFieldFullScreenFragment fragment = new EditFieldFullScreenFragment();
    args.putParcelable(Constants.EditField.FIELD_BUNDLE_KEY, fieldObject);
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

  @OnClick({ R.id.btn_ok, R.id.btn_cancel }) public void onViewClicked(View view) {
    switch (view.getId()) {
      case R.id.btn_ok:
        updateFieldData();
        mEditFieldPresenter.saveField();
        ViewUtil.hideKeyboard(getActivity());
        mNavigator.popBackStack((AppCompatActivity) getActivity());
        break;
      case R.id.btn_cancel:
        showToastMessage("onCancel");
        ViewUtil.hideKeyboard(getActivity());
        mNavigator.popBackStack((AppCompatActivity) getActivity());
        break;
      default:
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

  private void updateFieldData() {
    mEditFieldPresenter.updateFieldName(mEdTextName.getText().toString());
    mEditFieldPresenter.updateFieldArea(mEdTextArea.getText().toString());
    // TODO: Crop must be selected from list
    //mEditFieldPresenter.updateFieldCrop(selectedCropObject);
  }
}
