package com.apps.twelve.floor.field.utils;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by John on 27.03.2017.
 */

public final class Permissions {

  public static int PERMISSION_LOCATION = 1;

  public static void setPermission(AppCompatActivity appCompatActivity) {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      int fineLocation =
          appCompatActivity.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION);
      int coarseLocation =
          appCompatActivity.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION);

      if (fineLocation != PackageManager.PERMISSION_GRANTED
          && coarseLocation != PackageManager.PERMISSION_GRANTED) {
        appCompatActivity.requestPermissions(new String[] {
            Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
        }, PERMISSION_LOCATION);
      }
    }
  }
}
