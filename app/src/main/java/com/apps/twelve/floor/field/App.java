package com.apps.twelve.floor.field;

import android.app.Application;
import com.apps.twelve.floor.field.di.components.AppComponent;
import com.apps.twelve.floor.field.di.components.DaggerAppComponent;
import com.apps.twelve.floor.field.di.modules.AppModule;
import timber.log.Timber;

/**
 * Created by John on 27.03.2017.
 */

public class App extends Application {

  private static AppComponent sAppComponent;

  public static AppComponent getAppComponent() {
    return sAppComponent;
  }

  @Override public void onCreate() {
    super.onCreate();

    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }

    sAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
  }
}
