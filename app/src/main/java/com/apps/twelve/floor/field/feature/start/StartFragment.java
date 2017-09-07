package com.apps.twelve.floor.field.feature.start;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.BindView;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.adapters.StartViewPagerAdapter;
import com.apps.twelve.floor.field.base.BaseFragment;
import com.apps.twelve.floor.field.feature.actual_processes.ActualTechnologicalProcessesFragment;
import com.apps.twelve.floor.field.feature.fields_list.FieldsListFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

/**
 * Created by yarrick on 07.09.17.
 */

public class StartFragment extends BaseFragment implements IStartFragmentView {

  @InjectPresenter StartFragmentPresenter mStartFragmentPresenter;

  //@BindView(R.id.toolbar) private Toolbar toolbar;
  @BindView(R.id.tabs) TabLayout tabLayout;
  @BindView(R.id.viewpager) ViewPager viewPager;

  public StartFragment() {
    super(R.layout.fragment_start, false, 0);
  }

  public static StartFragment newInstance() {
    return new StartFragment();
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    //getActivity().setSupportActionBar(toolbar);
    setupViewPager();
    setupTabs();
  }

  @Override protected void updateActionBar(boolean mIsActionBarShown, String title) {
    // do nothing - on start screen AB is hidden
  }

  @Override protected void restoreActionBar() {
    // do nothing - on start   screen AB is hidden
  }

  ///////////////////////////////////////////////////////////////////////////
  // Private section
  ///////////////////////////////////////////////////////////////////////////

  private void setupViewPager() {
    StartViewPagerAdapter adapter = new StartViewPagerAdapter(getFragmentManager());
    adapter.addFragment(new ActualTechnologicalProcessesFragment(),
        getString(R.string.title_actual_processes));
    adapter.addFragment(new FieldsListFragment(), getString(R.string.title_fields_list));
    viewPager.setAdapter(adapter);
  }

  private void setupTabs() {
    tabLayout.setupWithViewPager(viewPager);
    //tabLayout.setTabTextColors(R.color.white, R.color.white);
  }
}
