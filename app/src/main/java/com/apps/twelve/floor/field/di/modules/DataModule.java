package com.apps.twelve.floor.field.di.modules;

import android.content.Context;
import com.apps.twelve.floor.field.di.scopes.AppScope;
import com.apps.twelve.floor.field.mvp.data.DataManager;
import com.apps.twelve.floor.field.mvp.data.local.PreferencesHelper;
import com.apps.twelve.floor.field.mvp.data.remote.FieldRetrofitApi;
import com.apps.twelve.floor.field.mvp.data.remote.RestApi;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by John on 27.03.2017.
 */

@Module(includes = { RetrofitModule.class, DbModule.class }) public class DataModule {

  @Provides @AppScope FieldRetrofitApi provideFieldApi(Retrofit retrofit) {
    return retrofit.create(FieldRetrofitApi.class);
  }

  @Provides @AppScope RestApi provideRestApi(FieldRetrofitApi api) {
    return new RestApi(api);
  }

  @Provides @AppScope DataManager provideDataManager() {
    return new DataManager();
  }

  @Provides @AppScope PreferencesHelper providePreferencesHelper(Context context) {
    return new PreferencesHelper(context);
  }
}
