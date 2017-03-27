package com.apps.twelve.floor.field.mvp.data.local;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by John on 27.03.2017.
 */

public class PreferencesHelper {

  private static final String PREF_FILE_NAME = "com.filed.Filed";

  private final SharedPreferences mPreferences;

  public PreferencesHelper(Context context) {
    mPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
  }

  public void clear() {
    mPreferences.edit().clear().apply();
  }
}
