package com.apps.twelve.floor.field.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
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

    mFieldsAdapter = new FieldsAdapter();
    mFieldsRecyclerView.setAdapter(mFieldsAdapter);
    mFieldsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    mFieldsRecyclerView.setItemAnimator(new DefaultItemAnimator());
    // TODO: open field editing screen (give it to mNavigator)
    ItemClickSupport.addTo(mFieldsRecyclerView)
        .setOnItemClickListener((recyclerView, position, v) -> showToastMessage("" + position));
  }

  @Override public void onDestroy() {
    super.onDestroy();
    hideFieldAddTypeDialog();
  }

  @OnClick(R.id.fab_add_new_field) public void onViewClicked() {
    mStartFragmentPresenter.showFieldTypeDialog();
  }

  @Override public void showFields(List<Field> fields) {
    mNoDataText.setVisibility(fields.size() > 0 ? View.GONE : View.VISIBLE);
    mFieldsAdapter.addAllFields(fields);
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
    mFieldAddTypeDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(button -> {
      int which = mStartFragmentPresenter.getFieldTypePosition();
      if (which < 0) {
        showToastMessage(R.string.dialog_error_add_field);
      } else {
        // open field editing screen (give it to mNavigator)
        // TODO: replace literals with IDs
        switch (which) {
          case 0:
            mNavigator.addFragmentBackStack(((AppCompatActivity) getActivity()),
                R.id.container_start, AddFieldOnMapFragment.newInstance());
            break;
          case 1:
            showToastMessage("Add Field type: " + fieldAddTypes[which]);
            break;
          case 2:
            showToastMessage("Add Field type: " + fieldAddTypes[which]);
            break;
          default:
            break;
        }
        mStartFragmentPresenter.hideFieldTypeDialog();
      }
    });
  }

  @Override public void hideFieldAddTypeDialog() {
    if (mFieldAddTypeDialog != null) mFieldAddTypeDialog.dismiss();
  }
}
