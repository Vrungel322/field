package com.apps.twelve.floor.field.feature.start_point.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.base.BaseActivity;
import com.apps.twelve.floor.field.feature.start_point.fragments.StartFragment;
import com.apps.twelve.floor.field.feature.start_point.presenters.MainActivityPresenter;
import com.apps.twelve.floor.field.feature.start_point.views.IMainActivityView;
import com.apps.twelve.floor.field.utils.Alerts;
import com.apps.twelve.floor.field.utils.Permissions;
import com.arellomobile.mvp.presenter.InjectPresenter;

public class MainActivity extends BaseActivity implements IMainActivityView {

  public static final long LOCATION_PERMISSION_ALERT_DURATION = 5000L;

  @InjectPresenter MainActivityPresenter mMainActivityPresenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

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

  @Override public void addStartFragment() {
    mNavigator.addFragmentBackStack(MainActivity.this, R.id.container_start,
        StartFragment.newInstance());
  }
}
