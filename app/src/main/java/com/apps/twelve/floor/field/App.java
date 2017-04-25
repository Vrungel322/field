package com.apps.twelve.floor.field;

import android.app.Application;
import android.content.Context;
import com.apps.twelve.floor.field.di.components.AppComponent;
import com.apps.twelve.floor.field.di.components.DaggerAppComponent;
import com.apps.twelve.floor.field.di.modules.AppModule;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import timber.log.Timber;

/**
 * Created by John on 27.03.2017.
 */

public class App extends Application {

  private static AppComponent sAppComponent;

  public static AppComponent getAppComponent() {
    return sAppComponent;
  }

  private RefWatcher mRefWatcher;

  @Override public void onCreate() {
    super.onCreate();

    // init LeakCanary
    if (LeakCanary.isInAnalyzerProcess(this)) {
      // This process is dedicated to LeakCanary for heap analysis.
      // You should not init your app in this process.
      return;
    }
    mRefWatcher = LeakCanary.install(this);

    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }

    sAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
  }

  public static RefWatcher getRefWatcher(Context context) {
    App application = (App) context.getApplicationContext();
    return application.mRefWatcher;
  }
}
