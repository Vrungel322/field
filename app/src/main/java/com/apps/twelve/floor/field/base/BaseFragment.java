package com.apps.twelve.floor.field.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.apps.twelve.floor.field.App;
import com.arellomobile.mvp.MvpAppCompatFragment;
import javax.inject.Inject;

/**
 * Created by John on 27.03.2017.
 */

public abstract class BaseFragment extends MvpAppCompatFragment {

  @Inject protected Context mContext;
  @Inject protected Navigator mNavigator;

  Unbinder unbinder;

  private final int mLayoutId;
  private final boolean mIsActionBarShown;
  private final int mTitleId;

  public BaseFragment(int layoutId, boolean isActionBarShown, int titleId) {
    this.mLayoutId = layoutId;
    this.mIsActionBarShown = isActionBarShown;
    this.mTitleId = titleId;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    App.getAppComponent().inject(this);
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    final View fragmentView = inflater.inflate(mLayoutId, container, false);
    unbinder = ButterKnife.bind(this, fragmentView);
    return fragmentView;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    updateActionBar(mIsActionBarShown, (mTitleId == 0) ? "" : getString(mTitleId));
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
    restoreActionBar();
  }

  @Override public void onDestroy() {
    super.onDestroy();
    // leak canary
    App.getRefWatcher(getActivity()).watch(this);
  }

  protected abstract void updateActionBar(boolean mIsActionBarShown, String title);

  protected abstract void restoreActionBar();

  // TODO: remove toast methods on release version
  protected void showToastMessage(String message) {
    Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
  }

  // TODO: remove toast methods on release version
  protected void showToastMessage(@StringRes int id) {
    Toast.makeText(mContext, id, Toast.LENGTH_SHORT).show();
  }
}
