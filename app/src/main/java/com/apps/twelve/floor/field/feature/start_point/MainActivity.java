package com.apps.twelve.floor.field.feature.start_point;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.base.BaseActivity;
import com.apps.twelve.floor.field.feature.splash.SplashFragment;
import com.apps.twelve.floor.field.utils.Alerts;
import com.apps.twelve.floor.field.utils.Permissions;
import com.arellomobile.mvp.presenter.InjectPresenter;
import java.util.ArrayList;

public class MainActivity extends BaseActivity implements IMainActivityView {

  public static final long LOCATION_PERMISSION_ALERT_DURATION = 5000L;

  @InjectPresenter MainActivityPresenter mMainActivityPresenter;
  private ActionBar mActionBar;
  private ArrayList<ActionBarState> mActionBarStates;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mActionBar = getSupportActionBar();
    mActionBarStates = new ArrayList<>();
    updateActionbar(ActionBarState.DEFAULT.isShown, ActionBarState.DEFAULT.title, true);

    /*mActionBar.setHomeButtonEnabled(true);
    mActionBar.setDisplayHomeAsUpEnabled(true);*/

    Permissions.setPermission(MainActivity.this);
  }

  @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    if (requestCode == Permissions.PERMISSION_LOCATION && !Permissions.isLocationPermissionGranted(
        this)) {
      Alerts.showAlert(this, R.string.warning, R.string.warning_permission,
          LOCATION_PERMISSION_ALERT_DURATION);
      return;
    }
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
  }

  ///////////////////////////////////////////////////////////////////////////
  // MVP methods
  ///////////////////////////////////////////////////////////////////////////

  @Override public void addStartFragment() {
    mNavigator.addFragment(MainActivity.this, R.id.container_start, SplashFragment.newInstance());
  }

  @Override public void updateActionbar(boolean isShown, String title, boolean isSaveState) {
    if (mActionBar == null) return;

    setTitle(title);
    if (isShown) {
      mActionBar.show();
    } else {
      mActionBar.hide();
    }

    if (isSaveState) {
      mActionBarStates.add(new ActionBarState(isShown, title));
    }
  }

  @Override public void restoreActionBar() {
    if (mActionBarStates == null || mActionBarStates.size() == 0) {
      return;
    }

    mActionBarStates.remove(mActionBarStates.size() - 1);

    if (mActionBarStates.size() == 0) {
      return;
    }

    updateActionbar(mActionBarStates.get(mActionBarStates.size() - 1).isShown,
        mActionBarStates.get(mActionBarStates.size() - 1).title, false);
  }

  private static class ActionBarState {

    private static final ActionBarState DEFAULT = new ActionBarState(false, "");

    private boolean isShown;
    private String title;

    ActionBarState(boolean isShown, String title) {
      this.isShown = isShown;
      this.title = title;
    }
  }
}
