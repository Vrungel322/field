package com.apps.twelve.floor.field.ui.base;

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
import javax.inject.Inject;

/**
 * Created by Yaroslav on 31.03.2017.
 */

public abstract class ManualAttachBaseFragment extends MvpManualAttachBaseFragment {

  @Inject protected Context mContext;
  @Inject protected Navigator mNavigator;

  Unbinder unbinder;

  private final int mLayoutId;

  public ManualAttachBaseFragment(int mLayoutId) {
    this.mLayoutId = mLayoutId;
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

  @Override public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }

  // TODO: remove toast methods on release version
  protected void showToastMessage(String message) {
    Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
  }

  // TODO: remove toast methods on release version
  protected void showToastMessage(@StringRes int id) {
    Toast.makeText(mContext, id, Toast.LENGTH_SHORT).show();
  }
}
