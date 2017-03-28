package com.apps.twelve.floor.field.ui.activities;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.mvp.presenters.pr_activities.MainActivityPresenter;
import com.apps.twelve.floor.field.mvp.views.IMainActivityView;
import com.apps.twelve.floor.field.ui.base.BaseActivity;
import com.apps.twelve.floor.field.ui.fragments.StartFragment;
import com.apps.twelve.floor.field.utils.Permissions;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.tapadoo.alerter.Alerter;

public class MainActivity extends BaseActivity implements IMainActivityView {

  @InjectPresenter MainActivityPresenter mMainActivityPresenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Permissions.setPermission(MainActivity.this);
  }

  @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    if (requestCode == Permissions.PERMISSION_LOCATION) {
      if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
          != PackageManager.PERMISSION_GRANTED
          && ActivityCompat.checkSelfPermission(this,
          android.Manifest.permission.ACCESS_COARSE_LOCATION)
          != PackageManager.PERMISSION_GRANTED) {

        Alerter.create(this).setTitle(R.string.warning).setText(R.string.warning_permission)
            .setDuration(5000)
            .show();
        return;
      }
    }
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
  }

  @Override public void addStartFragment() {
    mNavigator.addFragmentBackStack(MainActivity.this, R.id.container_start,
        StartFragment.newInstance());
  }
}
