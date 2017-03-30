package com.apps.twelve.floor.field.utils;

import android.app.Activity;
import com.tapadoo.alerter.Alerter;

/**
 * Created by Yaroslav on 30.03.2017.
 */

public final class Alerts {

  public static void showAlert(Activity activity, int titleId, int textId, long milliseconds) {
    Alerter.create(activity).setTitle(titleId).setText(textId).setDuration(milliseconds).show();
  }
}
