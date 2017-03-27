package com.apps.twelve.floor.field.mvp.data;

import com.apps.twelve.floor.field.mvp.data.remote.RestApi;

/**
 * Created by John on 27.03.2017.
 */

public class DataManager {

  private RestApi mRestApi;

  public DataManager(RestApi restApi) {
    this.mRestApi = restApi;
  }
}
