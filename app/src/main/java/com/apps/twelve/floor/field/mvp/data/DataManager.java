package com.apps.twelve.floor.field.mvp.data;

import com.apps.twelve.floor.field.mvp.data.model.Field;
import com.apps.twelve.floor.field.mvp.data.remote.RestApi;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;

/**
 * Created by John on 27.03.2017.
 */

public class DataManager {

  private RestApi mRestApi;

  public DataManager(RestApi restApi) {
    this.mRestApi = restApi;
  }

  public Observable<List<Field>> fetchFields() {
    // TODO: add fetch from storIO

    ArrayList<Field> dataList = new ArrayList<>();
    for (int i = 0; i < 30; i++) {
      dataList.add(new Field("Some field " + (i+1), (i+1) * 100));
    }

    return Observable.just(dataList);
  }
}
