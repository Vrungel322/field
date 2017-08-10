package com.apps.twelve.floor.field.feature.field_technological_map;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.adapters.FieldTechnologicalProcessesAdapter;
import com.apps.twelve.floor.field.base.BaseFragment;
import com.apps.twelve.floor.field.data.local.objects.FieldObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessObject;
import com.apps.twelve.floor.field.feature.edit_field_technological_process.FieldTechnologicalProcessFragment;
import com.apps.twelve.floor.field.utils.Constants;
import com.apps.twelve.floor.field.utils.ItemClickSupport;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Yaroslav on 23.05.2017.
 */

public class FieldTechnologicalMapFragment extends BaseFragment
    implements IFieldTechnologicalMapFragmentView {

  @InjectPresenter FieldTechnologicalMapPresenter mFieldTechnologicalMapPresenter;

  @BindView(R.id.app_bar_image) ImageView mAppBarImage;
  @BindView(R.id.text_crop) TextView mTextCrop;
  @BindView(R.id.text_phase) TextView mTextPhase;
  @BindView(R.id.button_edit_field) ImageButton mButtonEditField;
  @BindView(R.id.text_sowing_date) TextView mTextSowingDate;
  @BindView(R.id.text_area) TextView mTextArea;
  @BindView(R.id.recycler_view_tech_processes) RecyclerView mTechProcessesRecyclerView;
  @BindView(R.id.appbar) AppBarLayout mAppbar;
  @BindView(R.id.toolbar) Toolbar mToolbar;

  FieldTechnologicalProcessesAdapter mFieldTechnologicalProcessesAdapter;

  @ProvidePresenter FieldTechnologicalMapPresenter provideFieldTechnologicalMapPresenter() {
    return new FieldTechnologicalMapPresenter(
        getArguments().getParcelable(Constants.EditField.FIELD_BUNDLE_KEY));
  }

  public FieldTechnologicalMapFragment() {
    super(R.layout.fragment_field_technological_map, true, R.string.title_field);
  }

  public static FieldTechnologicalMapFragment newInstance(FieldObject fieldObject) {
    Bundle args = new Bundle();
    FieldTechnologicalMapFragment fragment = new FieldTechnologicalMapFragment();
    args.putParcelable(Constants.EditField.FIELD_BUNDLE_KEY, fieldObject);
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    setupRecyclerView();
  }

  @Override protected void updateActionBar(boolean mIsActionBarShown, String title) {
    mFieldTechnologicalMapPresenter.updateActionBar(mIsActionBarShown, title);
  }

  @Override protected void restoreActionBar() {
    mFieldTechnologicalMapPresenter.restoreActionBar();
  }

  @OnClick(R.id.button_edit_field) public void onViewClicked() {
    // TODO: open EditField screen
    showToastMessage("Эта кнопка еще не работает");
  }

  ///////////////////////////////////////////////////////////////////////////
  // MVP methods
  ///////////////////////////////////////////////////////////////////////////
  @Override public void showTechnologicalMap(
      List<FieldCropTechnologicalProcessObject> technologicalProcessObjectList) {
    mFieldTechnologicalProcessesAdapter.addAllFieldTechnologicalProcesses(
        technologicalProcessObjectList);
  }

  @Override public void openTechnologicalProcessFragment(int position) {
    mNavigator.addFragmentBackStack(((AppCompatActivity) getActivity()), R.id.container_start,
        makeFieldTechnologicalProcessFragment(
            mFieldTechnologicalProcessesAdapter.getTechProcessAt(position)));
  }

  @Override public void updateCrop(String cropName) {
    mTextCrop.setText(cropName);
  }

  @Override public void updatePhase(String phaseName) {
    mTextPhase.setText(phaseName);
  }

  @Override public void updateArea(double area) {
    // TODO format to "120 га" format (use resource string as placeholder)
    mTextArea.setText(area + " кв.м.");
  }

  @Override public void updateSowingDate(long sowingDate) {
    SimpleDateFormat df =
        new SimpleDateFormat("dd.MM.yyyy", new Locale("uk") /*TODO: keep locale in App*/);
    mTextSowingDate.setText(df.format(new Date(sowingDate)));
  }

  ///////////////////////////////////////////////////////////////////////////
  // Private section
  ///////////////////////////////////////////////////////////////////////////

  private void setupRecyclerView() {
    mFieldTechnologicalProcessesAdapter = new FieldTechnologicalProcessesAdapter();
    mTechProcessesRecyclerView.setAdapter(mFieldTechnologicalProcessesAdapter);
    mTechProcessesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    mTechProcessesRecyclerView.setItemAnimator(new DefaultItemAnimator());

    DividerItemDecoration dividerItemDecoration =
        new DividerItemDecoration(getContext(), RecyclerView.VERTICAL);
    dividerItemDecoration.setDrawable(
        ContextCompat.getDrawable(getContext(), R.drawable.shape_list_item_divider));
    mTechProcessesRecyclerView.addItemDecoration(dividerItemDecoration);

    ItemClickSupport.addTo(mTechProcessesRecyclerView)
        .setOnItemClickListener(
            (recyclerView, position, v) -> mFieldTechnologicalMapPresenter.onTechProcessClickedAtPosition(
                position));
  }

  private Fragment makeFieldTechnologicalProcessFragment(
      @NonNull FieldCropTechnologicalProcessObject processObject) {
    return FieldTechnologicalProcessFragment.newInstance(processObject);
  }
}
