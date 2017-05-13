package com.apps.twelve.floor.field.mvp.data.local.resolvers;

import android.support.annotation.NonNull;
import com.apps.twelve.floor.field.mvp.data.local.entities.FieldCropClimateZoneEntity;
import com.apps.twelve.floor.field.mvp.data.local.tables.ClimateZonesTable;
import com.apps.twelve.floor.field.mvp.data.local.tables.CropsTable;
import com.apps.twelve.floor.field.mvp.data.local.tables.FieldsTable;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.operations.delete.DeleteResolver;
import com.pushtorefresh.storio.sqlite.operations.delete.DeleteResult;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

/**
 * Created by Yaroslav on 13.05.2017.
 */

public class FieldCropClimateZoneDeleteResolver extends DeleteResolver<FieldCropClimateZoneEntity> {

  @NonNull @Override public DeleteResult performDelete(@NonNull StorIOSQLite storIOSQLite,
      @NonNull FieldCropClimateZoneEntity fieldCropClimateZoneEntity) {

    storIOSQLite.delete()
        .objects(asList(fieldCropClimateZoneEntity.getFieldEntity(),
            fieldCropClimateZoneEntity.getCropEntity(),
            fieldCropClimateZoneEntity.getClimateZoneEntity()))
        .prepare()
        .executeAsBlocking();

    final Set<String> affectedTables = new HashSet<String>(3);

    affectedTables.add(FieldsTable.TABLE);
    affectedTables.add(CropsTable.TABLE);
    affectedTables.add(ClimateZonesTable.TABLE);

    return DeleteResult.newInstance(2, affectedTables);
  }
}
