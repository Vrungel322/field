package com.apps.twelve.floor.field.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.di.modules.GoogleApiModule;
import com.apps.twelve.floor.field.utils.RxBus;
import com.arellomobile.mvp.MvpDelegate;
import com.google.android.gms.common.api.GoogleApiClient;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Yaroslav on 31.03.2017.
 */

public abstract class BaseManualAttachFragment extends Fragment {

  @Inject protected Context mContext;
  @Inject protected Navigator mNavigator;
  @Inject protected RxBus mRxBus;
  @Inject @Named(GoogleApiModule.NAME_LOCATION_CLIENT) protected GoogleApiClient mGoogleApiClient;

  Unbinder unbinder;

  private final int mLayoutId;

  private boolean mIsStateSaved;
  private MvpDelegate<? extends BaseManualAttachFragment> mMvpDelegate;

  public BaseManualAttachFragment(int layoutId) {
    this.mLayoutId = layoutId;
  }

  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getMvpDelegate().onCreate(savedInstanceState);
    App.getAppComponent().inject(this);
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    final View fragmentView = inflater.inflate(mLayoutId, container, false);
    unbinder = ButterKnife.bind(this, fragmentView);
    return fragmentView;
  }

  @Override public void onStart() {
    super.onStart();
    mIsStateSaved = false;
  }

  public void onResume() {
    super.onResume();
    mIsStateSaved = false;
  }

  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    mIsStateSaved = true;

    getMvpDelegate().onSaveInstanceState(outState);
    getMvpDelegate().onDetach();
  }

  @Override public void onStop() {
    super.onStop();
    getMvpDelegate().onDetach();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();

    getMvpDelegate().onDetach();
    getMvpDelegate().onDestroyView();
    unbinder.unbind();
  }

  @Override public void onDestroy() {
    super.onDestroy();

    //We leave the screen and respectively all fragments will be destroyed
    if (getActivity().isFinishing()) {
      getMvpDelegate().onDestroy();
      return;
    }

    // When we rotate device isRemoving() return true for fragment placed in backstack
    // http://stackoverflow.com/questions/34649126/fragment-back-stack-and-isremoving
    if (mIsStateSaved) {
      mIsStateSaved = false;
      return;
    }

    // See https://github.com/Arello-Mobile/Moxy/issues/24
    boolean anyParentIsRemoving = false;
    Fragment parent = getParentFragment();
    while (!anyParentIsRemoving && parent != null) {
      anyParentIsRemoving = parent.isRemoving();
      parent = parent.getParentFragment();
    }

    if (isRemoving() || anyParentIsRemoving) {
      getMvpDelegate().onDestroy();
    }
  }

  public void attachToPresenter() {
    getMvpDelegate().onAttach();
  }

  /**
   * @return The {@link MvpDelegate} being used by this Fragment.
   */
  public MvpDelegate getMvpDelegate() {
    if (mMvpDelegate == null) {
      mMvpDelegate = new MvpDelegate<>(this);
    }

    return mMvpDelegate;
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
