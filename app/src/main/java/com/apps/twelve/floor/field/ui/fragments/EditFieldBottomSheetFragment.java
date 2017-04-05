package com.apps.twelve.floor.field.ui.fragments;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
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
 * Created by Yaroslav on 04.04.2017.
 */

public class EditFieldBottomSheetFragment extends BaseFragment implements IEditFieldFragmentView {

  /*@IntDef(flag = true, value = { Mode.MODE_NO_MAP, Mode.MODE_WITH_MAP })
  @Retention(RetentionPolicy.SOURCE) public @interface Mode {
    int MODE_NO_MAP = 10;
    int MODE_WITH_MAP = 20;
  }

  ;*/

  @InjectPresenter EditFieldPresenter mEditFieldPresenter;

  @ProvidePresenter EditFieldPresenter provideEditFieldPresenter() {
    return new EditFieldPresenter(
        getArguments().getParcelable(Constants.EditField.FIELD_BUNDLE_KEY));
  }

  @BindView(R.id.constraint_layout_root) ConstraintLayout mConstraintLayoutRoot;
  @BindView(R.id.toggle_button_edit_mode) ToggleButton mTglBtnEditMode;
  @BindView(R.id.ed_text_name) EditText mEdTextName;
  @BindView(R.id.ed_text_area) EditText mEdTextArea;
  @BindView(R.id.ed_text_crop) EditText mEdTextCrop;
  @BindView(R.id.btn_edit_area) Button mBtnEditArea;
  @BindView(R.id.btn_ok) Button mBtnOk;
  @BindView(R.id.btn_cancel) Button mBtnCancel;

  //private int mMode = Mode.MODE_NO_MAP;

  public EditFieldBottomSheetFragment() {
    super(R.layout.fragment_edit_field_bottom_sheet);
  }

  public static EditFieldBottomSheetFragment newInstance() {
    return newInstance(new Field());
  }

  /*public static EditFieldBottomSheetFragment newInstance(Field field) {
    return newInstance(field, Mode.MODE_NO_MAP);
  }

  public static EditFieldBottomSheetFragment newInstance(@Mode int mode) {
    return newInstance(new Field(), mode);
  }*/

  public static EditFieldBottomSheetFragment newInstance(Field field/*, @Mode int mode*/) {
    Bundle args = new Bundle();
    args.putParcelable(Constants.EditField.FIELD_BUNDLE_KEY, field);
    /*args.putInt(Constants.EditField.FIELD_EDIT_MODE, mode);*/
    EditFieldBottomSheetFragment fragment = new EditFieldBottomSheetFragment();
    fragment.setArguments(args);
    return fragment;
  }

  // MVP View methods ================================================================

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

  @OnClick({ R.id.btn_edit_area, R.id.btn_ok, R.id.btn_cancel })
  public void onViewClicked(View view) {
    switch (view.getId()) {
      case R.id.btn_edit_area:
        // TODO: send message to presenter
        showToastMessage("onEdit");
        break;
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

  @OnCheckedChanged(R.id.toggle_button_edit_mode)
  public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    // TODO: maybe block edTexts and btnOk
    mEditFieldPresenter.setEditMode(isChecked);
  }
}
