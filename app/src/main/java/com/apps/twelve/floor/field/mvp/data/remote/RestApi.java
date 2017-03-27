package com.apps.twelve.floor.field.mvp.data.remote;

import com.apps.twelve.floor.field.mvp.data.model.SalonApi;

/**
 * Created by John on 26.01.2017.
 */

public class RestApi {
  private final SalonApi api;

  public RestApi(SalonApi api) {
    this.api = api;
  }

  //public Observable<TokenEntity> login(LoginBody credentials) {
  //  return api.login(credentials);
  //}
}
