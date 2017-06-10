package com.apps.twelve.floor.field.data.local.resolvers;

import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.entities.process_time.CombinedPhaseEntity;
import com.apps.twelve.floor.field.data.local.tables.CropsTable;
import com.apps.twelve.floor.field.data.local.tables.process_time.PhasesTable;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.operations.delete.DeleteResolver;
import com.pushtorefresh.storio.sqlite.operations.delete.DeleteResult;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

/**
 * Created by Yaroslav on 09.06.2017.
 */

public class CombinedPhaseDeleteResolver extends DeleteResolver<CombinedPhaseEntity> {

  private static final int NUMBER_OF_TABLES = 2;

  @NonNull @Override public DeleteResult performDelete(@NonNull StorIOSQLite storIOSQLite,
      @NonNull CombinedPhaseEntity combinedPhaseEntity) {
    storIOSQLite.delete()
        .objects(asList(combinedPhaseEntity.getPhaseEntity(), combinedPhaseEntity.getCropEntity()))
        .prepare()
        .executeAsBlocking();

    final Set<String> affectedTables = new HashSet<String>(NUMBER_OF_TABLES);

    affectedTables.add(PhasesTable.TABLE);
    affectedTables.add(CropsTable.TABLE);

    return DeleteResult.newInstance(NUMBER_OF_TABLES, affectedTables);
  }
}
