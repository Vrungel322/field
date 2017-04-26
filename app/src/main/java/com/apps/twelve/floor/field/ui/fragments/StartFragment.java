package com.apps.twelve.floor.field.ui.fragments;

import android.content.Context;
import android.os.Bundle;
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
import com.apps.twelve.floor.field.mvp.data.model.Field;
import com.apps.twelve.floor.field.mvp.presenters.pr_fragments.StartFragmentPresenter;
import com.apps.twelve.floor.field.mvp.views.IStartFragmentView;
import com.apps.twelve.floor.field.ui.adapters.FieldsAdapter;
import com.apps.twelve.floor.field.ui.base.BaseFragment;
import com.apps.twelve.floor.field.utils.DialogFactory;
import com.apps.twelve.floor.field.utils.ItemClickSupport;
import com.arellomobile.mvp.presenter.InjectPresenter;
import java.util.List;

/**
 * Created by John on 28.03.2017.
 */

public class StartFragment extends BaseFragment implements IStartFragmentView {

  @InjectPresenter StartFragmentPresenter mStartFragmentPresenter;

  @BindView(R.id.recycler_view_fields) RecyclerView mFieldsRecyclerView;
  @BindView(R.id.text_no_data) TextView mNoDataText;
  @BindView(R.id.fab_add_new_field) FloatingActionButton mAddNewFieldFab;

  private FieldsAdapter mFieldsAdapter;

  private AlertDialog mFieldAddTypeDialog;

  public StartFragment() {
    super(R.layout.fragment_start);
  }

  public static StartFragment newInstance() {
    Bundle args = new Bundle();
    StartFragment fragment = new StartFragment();
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
    mStartFragmentPresenter.showFieldTypeDialog();
  }

  @Override public void showFields(List<Field> fields) {
    mFieldsAdapter.addAllFields(fields);
    updateTextNoDataVisibility();
  }

  @Override public void showFieldAddTypeDialog() {
    Context context = getActivity();
    String[] fieldAddTypes = getResources().getStringArray(R.array.dialog_field_add_types);

    mFieldAddTypeDialog =
        DialogFactory.createAlertDialogBuilder(context, getString(R.string.dialog_title_add_field))
            .setSingleChoiceItems(fieldAddTypes, mStartFragmentPresenter.getFieldTypePosition(),
                (dialog, which) -> mStartFragmentPresenter.setFieldTypePosition(which))
            .setPositiveButton(R.string.dialog_action_ok, null)
            .setNegativeButton(R.string.dialog_action_cancel,
                (dialog, which) -> mStartFragmentPresenter.hideFieldTypeDialog())
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

  @Override public void addField(Field field) {
    mFieldsAdapter.addField(field);
    updateTextNoDataVisibility();
  }

  @Override public void updateField(Field field) {
    mFieldsAdapter.updateField(field);
  }

  @Override public void deleteFieldAtPosition(Field field, int position) {
    mFieldsAdapter.removeField(field, position);
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

  @Override public void openEditFieldFragment(int position) {
    mNavigator.addFragmentBackStack(((AppCompatActivity) getActivity()), R.id.container_start,
        makeEditFieldFragment(mFieldsAdapter.getFieldAt(position)));
  }

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

    // TODO: open field editing screen (give it to mNavigator)
    ItemClickSupport.addTo(mFieldsRecyclerView)
        .setOnItemClickListener(
            (recyclerView, position, v) -> mStartFragmentPresenter.onFiledClickedAtPosition(
                position));
  }

  private void onDialogPositiveButtonClicked(String[] fieldAddTypes) {
    int which = mStartFragmentPresenter.getFieldTypePosition();

    if (which < 0) {
      showToastMessage(R.string.dialog_error_add_field);
      return;
    }

    mStartFragmentPresenter.onFieldTypeDialogPositiveButton(which);
    mStartFragmentPresenter.hideFieldTypeDialog();
  }

  private Fragment makeEditFieldFragment(Field field) {
    if (field.hasPoints()) {
      return EditFieldOnMapFragment.newInstance(field);
    } else {
      return EditFieldFullScreenFragment.newInstance(field);
    }
  }

  private void updateTextNoDataVisibility() {
    mNoDataText.setVisibility(mFieldsAdapter.getItemCount() > 0 ? View.GONE : View.VISIBLE);
  }
}
