package com.apps.twelve.floor.field.di.modules;

import android.content.Context;
import android.content.res.AssetManager;
import com.apps.twelve.floor.field.data.local.db_filler.AssetHelper;
import com.apps.twelve.floor.field.di.scopes.AppScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by yarrick on 03.08.17.
 */

@Module public class AssetModule {

  @Provides @AppScope AssetHelper provideAssetHelper() {
    return new AssetHelper();
  }

  @Provides @AppScope public AssetManager provideAssetManager(Context context) {
    return context.getAssets();
  }
}
