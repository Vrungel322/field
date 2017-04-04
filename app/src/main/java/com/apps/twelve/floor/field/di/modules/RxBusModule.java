package com.apps.twelve.floor.field.di.modules;

/**
 * Created by Yaroslav on 04.04.2017.
 */

import com.apps.twelve.floor.field.di.scopes.AppScope;
import com.apps.twelve.floor.field.utils.RxBus;
import dagger.Module;
import dagger.Provides;

@Module public class RxBusModule {

  @Provides @AppScope public RxBus provideRxBus() {
    return new RxBus();
  }
}
