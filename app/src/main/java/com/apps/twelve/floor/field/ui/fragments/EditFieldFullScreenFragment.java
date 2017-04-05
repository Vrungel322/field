package com.apps.twelve.floor.field.ui.fragments;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import butterknife.BindView;
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
  @BindView(R.id.ed_text_crop) EditText mEdTextCrop;
  @BindView(R.id.btn_ok) Button mBtnOk;
  @BindView(R.id.btn_cancel) Button mBtnCancel;

  public EditFieldFullScreenFragment() {
    super(R.layout.fragment_edit_field_full_screen);
  }

  public static EditFieldFullScreenFragment newInstance() {
    return newInstance(new Field());
  }

  public static EditFieldFullScreenFragment newInstance(Field field) {
    Bundle args = new Bundle();
    args.putParcelable(Constants.EditField.FIELD_BUNDLE_KEY, field);
    EditFieldFullScreenFragment fragment = new EditFieldFullScreenFragment();
    fragment.setArguments(args);
    return fragment;
  }

  // MvpView methods ========================================================

  @Override public void setFieldNameText(String name) {
    mEdTextName.setText(name);
  }

  @Override public void setFieldAreaText(String area) {
    mEdTextArea.setText(area);
  }

  @Override public void setFieldCropText(String crop) {
    mEdTextCrop.setText(crop);
  }

  // UI events ================================================================

  @OnClick({ R.id.btn_ok, R.id.btn_cancel }) public void onViewClicked(View view) {
    switch (view.getId()) {
      case R.id.btn_ok:
        // TODO: save data and replace this fragment (if mode == MODE_WITH_MAP - send msg to OnMapPresenter)
        showToastMessage("onOK");
        mEditFieldPresenter.saveField();
        break;
      case R.id.btn_cancel:
        showToastMessage("onCancel");
        // TODO: replace this fragment (if mode == MODE_WITH_MAP - send msg to OnMapPresenter)
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

    switch (editText.getId()) {
      case R.id.ed_text_name:
        mEditFieldPresenter.updateFieldName(editText.getText().toString());
        break;
      case R.id.ed_text_area:
        mEditFieldPresenter.updateFieldArea(editText.getText().toString());
        break;
      case R.id.ed_text_crop:
        mEditFieldPresenter.updateFieldCrop(editText.getText().toString());
        break;
      default:
        break;
    }

    return false; // pass on to other listeners.
  }
}
