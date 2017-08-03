package com.apps.twelve.floor.field.di.modules;

import android.app.Application;
import android.content.Context;
import com.apps.twelve.floor.field.base.Navigator;
import com.apps.twelve.floor.field.di.scopes.AppScope;
import com.apps.twelve.floor.field.utils.RxBus;
import dagger.Module;
import dagger.Provides;

/**
 * Created by John on 27.03.2017.
 */

@Module(includes = { DataModule.class, GoogleApiModule.class, AssetModule.class })
public class AppModule {

  private final Application mApplication;

  public AppModule(Application application) {
    mApplication = application;
  }

  @Provides @AppScope Context provideAppContext() {
    return mApplication;
  }

  @Provides @AppScope public RxBus provideRxBus() {
    return new RxBus();
  }

  @Provides @AppScope public Navigator provideNavigator() {
    return new Navigator();
  }
}
