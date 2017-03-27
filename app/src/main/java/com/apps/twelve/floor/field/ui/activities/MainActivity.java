package com.apps.twelve.floor.field.ui.activities;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.utils.Permissions;
import com.tapadoo.alerter.Alerter;

public class MainActivity extends AppCompatActivity {

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

        Alerter.create(this)
            .setTitle("Предупреждение")
            .setText("Для работы приложения необходимо разрешение определения места положения")
            .setDuration(5000)
            .show();
        return;
      }
    }
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
  }
}
