package com.apps.twelve.floor.field.feature.fields_list;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.adapters.FieldsAdapter;
import com.apps.twelve.floor.field.base.BaseFragment;
import com.apps.twelve.floor.field.data.local.objects.FieldObject;
import com.apps.twelve.floor.field.feature.add_field.AddFieldTrackingFragment;
import com.apps.twelve.floor.field.feature.edit_field.EditFieldFullScreenFragment;
import com.apps.twelve.floor.field.feature.edit_field.EditFieldOnMapFragment;
import com.apps.twelve.floor.field.feature.field_technological_map.FieldTechnologicalMapFragment;
import com.apps.twelve.floor.field.utils.DialogFactory;
import com.apps.twelve.floor.field.utils.ItemClickSupport;
import com.arellomobile.mvp.presenter.InjectPresenter;
import java.util.List;

/**
 * Created by John on 28.03.2017.
 */

public class FieldsListFragment extends BaseFragment implements IFieldsListFragmentView {

  @InjectPresenter FieldsListFragmentPresenter mFieldsListFragmentPresenter;

  @BindView(R.id.recycler_view_fields) RecyclerView mFieldsRecyclerView;
  @BindView(R.id.text_no_data) TextView mNoDataText;
  @BindView(R.id.fab_add_new_field) FloatingActionButton mAddNewFieldFab;

  private FieldsAdapter mFieldsAdapter;

  private AlertDialog mFieldAddTypeDialog;

  public FieldsListFragment() {
    super(R.layout.fragment_fields_list, true, R.string.title_fields_list);
  }

  public static FieldsListFragment newInstance() {
    Bundle args = new Bundle();
    FieldsListFragment fragment = new FieldsListFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    setupRecyclerView();
  }

  @Override public void onDestroy() {
    super.onDestroy();
    hideFieldAddTypeDialog();
  }

  @OnClick(R.id.fab_add_new_field) public void onViewClicked() {
    mFieldsListFragmentPresenter.showFieldTypeDialog();
  }

  ///////////////////////////////////////////////////////////////////////////
  // MVP methods
  ///////////////////////////////////////////////////////////////////////////

  @Override public void showFields(List<FieldObject> fieldObjects) {
    mFieldsAdapter.addAllFields(fieldObjects);
    updateTextNoDataVisibility();
  }

  @Override public void showFieldAddTypeDialog() {
    Context context = getActivity();
    String[] fieldAddTypes = getResources().getStringArray(R.array.dialog_field_add_types);

    mFieldAddTypeDialog =
        DialogFactory.createAlertDialogBuilder(context, getString(R.string.dialog_title_add_field))
            .setSingleChoiceItems(fieldAddTypes,
                mFieldsListFragmentPresenter.getFieldTypePosition(),
                (dialog, which) -> mFieldsListFragmentPresenter.setFieldTypePosition(which))
            .setPositiveButton(R.string.dialog_action_ok, null)
            .setNegativeButton(R.string.dialog_action_cancel,
                (dialog, which) -> mFieldsListFragmentPresenter.hideFieldTypeDialog())
            .setCancelable(false)
            .create();

    mFieldAddTypeDialog.show();

    // this is kind of workaround to keep dialog on screen when ok clicked with no type is selected
    mFieldAddTypeDialog.getButton(AlertDialog.BUTTON_POSITIVE)
        .setOnClickListener(button -> onDialogPositiveButtonClicked(fieldAddTypes));
  }

  @Override public void hideFieldAddTypeDialog() {
    if (mFieldAddTypeDialog != null) mFieldAddTypeDialog.dismiss();
  }

  @Override public void addField(FieldObject fieldObject) {
    mFieldsAdapter.addField(fieldObject);
    updateTextNoDataVisibility();
  }

  @Override public void updateField(FieldObject fieldObject) {
    mFieldsAdapter.updateField(fieldObject);
  }

  @Override public void deleteFieldAtPosition(FieldObject fieldObject, int position) {
    mFieldsAdapter.removeField(fieldObject, position);
    updateTextNoDataVisibility();
  }

  @Override public void showEditFieldOnMapFragment() {
    mNavigator.addFragmentBackStack(((AppCompatActivity) getActivity()), R.id.container_start,
        EditFieldOnMapFragment.newInstance());
  }

  @Override public void showEditFieldTrackingFragment() {
    mNavigator.addFragmentBackStack(((AppCompatActivity) getActivity()), R.id.container_start,
        AddFieldTrackingFragment.newInstance());
  }

  @Override public void showEditFieldFullScreenFragment() {
    mNavigator.addFragmentBackStack(((AppCompatActivity) getActivity()), R.id.container_start,
        EditFieldFullScreenFragment.newInstance());
  }

  @Override public void openFieldTechnologicalMapFragment(int position) {
    mNavigator.addFragmentBackStack(((AppCompatActivity) getActivity()), R.id.container_start,
        makeFieldTechnologicalMapFragment(mFieldsAdapter.getFieldAt(position)));
  }

  @Override protected void updateActionBar(boolean mIsActionBarShown, String title) {
    //mFieldsListFragmentPresenter.updateActionBar(mIsActionBarShown, title);
  }

  @Override protected void restoreActionBar() {
    //mFieldsListFragmentPresenter.restoreActionBar();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Private section
  ///////////////////////////////////////////////////////////////////////////

  private void setupRecyclerView() {
    mFieldsAdapter = new FieldsAdapter();
    mFieldsRecyclerView.setAdapter(mFieldsAdapter);
    mFieldsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    mFieldsRecyclerView.setItemAnimator(new DefaultItemAnimator());

    DividerItemDecoration dividerItemDecoration =
        new DividerItemDecoration(getContext(), RecyclerView.VERTICAL);
    dividerItemDecoration.setDrawable(
        ContextCompat.getDrawable(getContext(), R.drawable.shape_list_item_divider));
    mFieldsRecyclerView.addItemDecoration(dividerItemDecoration);

    // TODO: open fieldEntity editing screen (give it to mNavigator)
    ItemClickSupport.addTo(mFieldsRecyclerView)
        .setOnItemClickListener(
            (recyclerView, position, v) -> mFieldsListFragmentPresenter.onFiledClickedAtPosition(
                position));
  }

  private void onDialogPositiveButtonClicked(String[] fieldAddTypes) {
    int which = mFieldsListFragmentPresenter.getFieldTypePosition();

    if (which < 0) {
      showToastMessage(R.string.dialog_error_add_field);
      return;
    }

    mFieldsListFragmentPresenter.onFieldTypeDialogPositiveButton(which);
    mFieldsListFragmentPresenter.hideFieldTypeDialog();
  }

  private Fragment makeFieldTechnologicalMapFragment(@NonNull FieldObject fieldObject) {
    return FieldTechnologicalMapFragment.newInstance(fieldObject);
  }

  private void updateTextNoDataVisibility() {
    mNoDataText.setVisibility(mFieldsAdapter.getItemCount() > 0 ? View.GONE : View.VISIBLE);
  }
}
