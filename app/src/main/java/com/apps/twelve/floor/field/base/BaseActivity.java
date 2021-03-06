package com.apps.twelve.floor.field.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.apps.twelve.floor.field.App;
import com.arellomobile.mvp.MvpAppCompatActivity;
import javax.inject.Inject;

/**
 * Created by John on 27.03.2017.
 */

public abstract class BaseActivity extends MvpAppCompatActivity {

  @Inject protected Context mContext;
  @Inject protected Navigator mNavigator;

  Unbinder unbinder;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    unbinder = ButterKnife.bind(this);
    App.getAppComponent().inject(this);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    App.getRefWatcher(this).watch(this);
    unbinder.unbind();
  }

  protected void showToastMessage(String message) {
    Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
  }

  protected void showToastMessage(@StringRes int id) {
    Toast.makeText(mContext, id, Toast.LENGTH_SHORT).show();
  }
}
