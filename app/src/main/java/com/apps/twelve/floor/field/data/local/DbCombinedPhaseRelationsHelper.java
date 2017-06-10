package com.apps.twelve.floor.field.data.local;

import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.data.local.entities.process_time.CombinedPhaseEntity;
import com.apps.twelve.floor.field.data.local.tables.CropsTable;
import com.apps.twelve.floor.field.data.local.tables.process_time.PhasesTable;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.queries.RawQuery;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

/**
 * Created by Yaroslav on 09.06.2017.
 */

public class DbCombinedPhaseRelationsHelper {

  public static final String QUERY_COLUMN_PHASE_ID = "phase_id";
  public static final String QUERY_COLUMN_PHASE_NAME = "phase_name";
  public static final String QUERY_COLUMN_CROP_ID = "crop_id";
  public static final String QUERY_COLUMN_CROP_NAME = "crop_name";
  public static final String QUERY_COLUMN_CROP_PARENT_ID = "crop_parent_id";
  public static final String QUERY_COLUMN_CROP_IS_GROUP = "crop_is_group";

  public static final String QUERY_COMBINED_PHASE_ALL = "SELECT "
      + PhasesTable.COLUMN_ID_WITH_TABLE_PREFIX
      + " AS \""
      + QUERY_COLUMN_PHASE_ID
      + "\", "
      + PhasesTable.COLUMN_NAME_WITH_TABLE_PREFIX
      + " AS \""
      + QUERY_COLUMN_PHASE_NAME
      + "\", "
      + CropsTable.COLUMN_ID_WITH_TABLE_PREFIX
      + " AS \""
      + QUERY_COLUMN_CROP_ID
      + "\", "
      + CropsTable.COLUMN_NAME_WITH_TABLE_PREFIX
      + " AS \""
      + QUERY_COLUMN_CROP_NAME
      + "\", "
      + CropsTable.COLUMN_PARENT_ID_WITH_TABLE_PREFIX
      + " AS \""
      + QUERY_COLUMN_CROP_PARENT_ID
      + "\", "
      + CropsTable.COLUMN_IS_GROUP_WITH_TABLE_PREFIX
      + " AS \""
      + QUERY_COLUMN_CROP_IS_GROUP
      + "\", "
      + " FROM "
      + PhasesTable.TABLE
      + " JOIN "
      + CropsTable.TABLE
      + " ON "
      + PhasesTable.COLUMN_CROP_ID_WITH_TABLE_PREFIX
      + " = "
      + CropsTable.COLUMN_ID_WITH_TABLE_PREFIX;

  public static final String QUERY_COMBINED_PHASE_BY_CROP_ID =
      QUERY_COMBINED_PHASE_ALL + " WHERE " + CropsTable.COLUMN_ID_WITH_TABLE_PREFIX + " = $d";

  @Inject StorIOSQLite mStorIOSQLite;

  public DbCombinedPhaseRelationsHelper() {
    App.getAppComponent().inject(this);
  }

  public @NonNull Observable<List<CombinedPhaseEntity>> getCombinedPhaseEntities() {
    return mStorIOSQLite.get()
        .listOfObjects(CombinedPhaseEntity.class)
        .withQuery(RawQuery.builder().query(QUERY_COMBINED_PHASE_ALL).build())
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public @NonNull Observable<List<CombinedPhaseEntity>> getCombinedPhaseEntitiesByCropId(
      long cropId) {
    return mStorIOSQLite.get()
        .listOfObjects(CombinedPhaseEntity.class)
        .withQuery(RawQuery.builder()
            .query(String.format(QUERY_COMBINED_PHASE_BY_CROP_ID, cropId))
            .build())
        .prepare()
        .asRxObservable()
        .take(1);
  }

  public @NonNull List<CombinedPhaseEntity> getCombinedPhaseEntitiesAsList() {
    return mStorIOSQLite.get()
        .listOfObjects(CombinedPhaseEntity.class)
        .withQuery(RawQuery.builder().query(QUERY_COMBINED_PHASE_ALL).build())
        .prepare()
        .executeAsBlocking();
  }
}
