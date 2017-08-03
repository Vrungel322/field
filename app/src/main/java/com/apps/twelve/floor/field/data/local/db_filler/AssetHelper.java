package com.apps.twelve.floor.field.data.local.db_filler;

import android.content.res.AssetManager;
import com.apps.twelve.floor.field.App;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.inject.Inject;
import timber.log.Timber;

/**
 * Created by yarrick on 03.08.17.
 */

public class AssetHelper {
  public static final String ASSET_INITIAL_DB_DATA_V1 = "initial_db_data_v1.json";

  @Inject AssetManager mAssetManager;

  public AssetHelper() {
    App.getAppComponent().inject(this);
  }

  public String readStringFromAssetFile(String fileName) {
    StringBuilder builder = new StringBuilder();

    try {
      InputStream inStream = mAssetManager.open(fileName);
      BufferedReader inBuffer = new BufferedReader(new InputStreamReader(inStream, "UTF-8"));
      String str;
      while ((str = inBuffer.readLine()) != null) {
        builder.append(str);
      }
      inBuffer.close();
    } catch (IOException e) {
      Timber.e(e);
    }

    return builder.toString();
  }
}
