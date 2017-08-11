package com.apps.twelve.floor.field.utils;

import android.support.annotation.NonNull;

/**
 * Created by John on 27.03.2017.
 */

public final class Constants {
  public class Remote {
    @NonNull private static final String DOMAIN = "api.simple-website.in.ua";
    // TODO: do not forget to paste base url
    @NonNull public static final String BASE_URL = "http://" + DOMAIN + "/";
  }

  public class EditField {
    @NonNull public static final String FIELD_BUNDLE_KEY = "field_bundle_key";
    @NonNull public static final String FIELD_TECHNOLOGICAL_PROCESS_BUNDLE_KEY =
        "technological_process_bundle_key";
    @NonNull public static final String FIELD_TECHNOLOGICAL_PROCESS_SOLUTION_BUNDLE_KEY =
        "technological_process_solution_bundle_key";
  }

  public class Spinner {
    public static final int ADAPTER_TYPE_CROPS = 10;
    public static final int ADAPTER_TYPE_CLIMATE_ZONES = 20;
  }

  public class FragmentTag {
  }

  public class FragmentsArgumentKeys {
  }
}
