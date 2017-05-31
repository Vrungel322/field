package com.apps.twelve.floor.field.data.local.resolvers;

import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.data.local.entities.CombinedFieldEntity;
import com.apps.twelve.floor.field.data.local.tables.CropsTable;
import com.apps.twelve.floor.field.data.local.tables.FieldsTable;
import com.apps.twelve.floor.field.data.local.tables.process_time.ClimateZonesTable;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.operations.put.PutResolver;
import com.pushtorefresh.storio.sqlite.operations.put.PutResult;
import com.pushtorefresh.storio.sqlite.operations.put.PutResults;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

/**
 * Created by Yaroslav on 13.05.2017.
 */

public class CombinedFieldPutResolver extends PutResolver<CombinedFieldEntity> {
  @NonNull @Override public PutResult performPut(@NonNull StorIOSQLite storIOSQLite,
      @NonNull CombinedFieldEntity combinedFieldEntity) {

    // We can even reuse StorIO methods
    final PutResults<Object> putResults = storIOSQLite.put()
        .objects(asList(combinedFieldEntity.getFieldEntity(), combinedFieldEntity.getCropEntity(),
            combinedFieldEntity.getClimateZoneEntity()))
        .prepare()
        .executeAsBlocking();

    final Set<String> affectedTables = new HashSet<String>(3);

    affectedTables.add(FieldsTable.TABLE);
    affectedTables.add(CropsTable.TABLE);
    affectedTables.add(ClimateZonesTable.TABLE);

    return PutResult.newUpdateResult(putResults.numberOfUpdates(), affectedTables);
  }
}
