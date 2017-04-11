package com.apps.twelve.floor.field.di.modules;

import android.content.Context;
import com.apps.twelve.floor.field.di.scopes.AppScope;
import com.apps.twelve.floor.field.mvp.data.DataManager;
import com.apps.twelve.floor.field.mvp.data.local.PreferencesHelper;
import com.apps.twelve.floor.field.mvp.data.model.FieldApi;
import com.apps.twelve.floor.field.mvp.data.remote.RestApi;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by John on 27.03.2017.
 */

@Module(includes = { RetrofitModule.class, DbModule.class }) public class DataModule {

  @Provides @AppScope FieldApi provideFieldApi(Retrofit retrofit) {
    return retrofit.create(FieldApi.class);
  }

  @Provides @AppScope RestApi provideRestApi(FieldApi api) {
    return new RestApi(api);
  }

  @Provides @AppScope DataManager provideDataManager(RestApi restApi) {
    return new DataManager(restApi);
  }

  @Provides @AppScope PreferencesHelper providePreferencesHelper(Context context) {
    return new PreferencesHelper(context);
  }
}
