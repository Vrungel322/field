package com.apps.twelve.floor.field.feature.splash;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import butterknife.BindView;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.base.BaseFragment;
import com.apps.twelve.floor.field.feature.start_point.StartFragment;
import com.apps.twelve.floor.field.utils.DialogFactory;
import com.arellomobile.mvp.presenter.InjectPresenter;

/**
 * Created by yarrick on 04.08.17.
 */

public class SplashFragment extends BaseFragment implements ISplashFragmentView {

  @InjectPresenter SplashFragmentPresenter mSplashFragmentPresenter;

  @BindView(R.id.text_status) TextView mStatusText;

  private AlertDialog mErrorDialog;

  public SplashFragment() {
    super(R.layout.fragment_splash);
  }

  public static SplashFragment newInstance() {
    Bundle args = new Bundle();
    SplashFragment fragment = new SplashFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onDestroy() {
    super.onDestroy();
    hideErrorDialog();
  }

  @Override public void showStartFragment() {
    mNavigator.replaceFragment(((AppCompatActivity) getActivity()), R.id.container_start,
        StartFragment.newInstance());
  }

  @Override public void showErrorDialog() {
    Context context = getActivity();

    mErrorDialog =
        DialogFactory.createAlertDialogBuilder(context, getString(R.string.dialog_title_error))
            .setMessage(getString(R.string.dialog_error_message_db_fail))
            .setPositiveButton(R.string.dialog_action_ok,
                (dialog, which) -> mSplashFragmentPresenter.hideErrorDialog())
            .setCancelable(false)
            .create();

    mErrorDialog.show();
  }

  @Override public void hideErrorDialog() {
    if (mErrorDialog != null) mErrorDialog.dismiss();
  }
}
