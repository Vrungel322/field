package com.apps.twelve.floor.field.di.modules;

import android.content.Context;
import com.apps.twelve.floor.field.di.scopes.AppScope;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

/**
 * Created by Yaroslav on 06.04.2017.
 */

@Module public class GoogleApiModule {
  public static final String NAME_LOCATION_CLIENT = "location_google_api_client";

  @Provides @Named(NAME_LOCATION_CLIENT) @AppScope
  public GoogleApiClient provideGoogleApiLocationClient(GoogleApiClient.Builder builder) {
    return builder.addApi(LocationServices.API).build();
  }

  @Provides @AppScope
  public GoogleApiClient.Builder provideGoogleApiClientBuilder(Context context) {
    return new GoogleApiClient.Builder(context);
  }
}
