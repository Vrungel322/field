package com.apps.twelve.floor.field.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
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
import com.arellomobile.mvp.presenter.InjectPresenter;
import java.util.List;

/**
 * Created by John on 28.03.2017.
 */

public class StartFragment extends BaseFragment implements IStartFragmentView {

  @InjectPresenter StartFragmentPresenter mStartFragmentPresenter;

  @BindView(R.id.fields_recycler_view) RecyclerView fieldsRecyclerView;
  @BindView(R.id.no_data_text) TextView noDataText;
  @BindView(R.id.add_new_field_fab) FloatingActionButton addNewFieldFab;
  private FieldsAdapter fieldsAdapter;

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

    fieldsAdapter = new FieldsAdapter();
    fieldsRecyclerView.setAdapter(fieldsAdapter);
    fieldsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    fieldsRecyclerView.setItemAnimator(new DefaultItemAnimator());
  }

  @OnClick(R.id.add_new_field_fab) public void onViewClicked() {
    // TODO: select field adding variant, and open field selection screen
  }

  @Override public void showFields(List<Field> fields) {
    noDataText.setVisibility(fields.size() > 0 ? View.GONE : View.VISIBLE);
    fieldsAdapter.addAllFileds(fields);
  }
}
