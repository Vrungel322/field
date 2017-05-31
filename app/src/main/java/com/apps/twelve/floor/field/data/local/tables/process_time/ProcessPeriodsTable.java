package com.apps.twelve.floor.field.data.local.tables.process_time;

import android.support.annotation.NonNull;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by Yaroslav on 30.05.2017.
 */

public class ProcessPeriodsTable {

  @NonNull public static final String TABLE = "ProcessPeriods";

  @NonNull public static final String COLUMN_ID = "id";
  @NonNull public static final String COLUMN_DATE_FROM = "date_from";
  @NonNull public static final String COLUMN_DATE_TO = "date_to";

  @NonNull public static final Query QUERY_ALL = Query.builder().table(TABLE).build();

  public ProcessPeriodsTable() {
    throw new IllegalStateException("No instances allowed");
  }

  @NonNull public static String getCreateTableQuery() {
    return "CREATE TABLE IF NOT EXISTS "
        + TABLE
        + " ("
        + COLUMN_ID
        + " INTEGER NOT NULL PRIMARY KEY, "
        + COLUMN_DATE_FROM
        + " TEXT NULL, "
        + COLUMN_DATE_TO
        + " TEXT NULL "
        + ");";
  }
}
