package com.apps.twelve.floor.field.di.components;

import com.apps.twelve.floor.field.base.BaseActivity;
import com.apps.twelve.floor.field.base.BaseFragment;
import com.apps.twelve.floor.field.base.BaseManualAttachFragment;
import com.apps.twelve.floor.field.data.DataManager;
import com.apps.twelve.floor.field.data.local.DbCombinedFieldRelationsHelper;
import com.apps.twelve.floor.field.data.local.DbHelper;
import com.apps.twelve.floor.field.di.modules.AppModule;
import com.apps.twelve.floor.field.di.scopes.AppScope;
import com.apps.twelve.floor.field.feature.add_field.AddFieldTrackingPresenter;
import com.apps.twelve.floor.field.feature.edit_field.EditFieldPresenter;
import com.apps.twelve.floor.field.feature.edit_field.MapPolygonEditPresenter;
import com.apps.twelve.floor.field.feature.edit_field_technological_process.FieldTechnologicalProcessPresenter;
import com.apps.twelve.floor.field.feature.edit_field_technological_process.TechnologicalSolutionAdapter;
import com.apps.twelve.floor.field.feature.edit_field_technological_solution.EditFieldTechnologicalSolutionPresenter;
import com.apps.twelve.floor.field.feature.field_technological_map.FieldTechnologicalMapPresenter;
import com.apps.twelve.floor.field.feature.field_technological_map.FieldTechnologicalProcessesAdapter;
import com.apps.twelve.floor.field.feature.start_point.FieldsAdapter;
import com.apps.twelve.floor.field.feature.start_point.MainActivityPresenter;
import com.apps.twelve.floor.field.feature.start_point.StartFragmentPresenter;
import dagger.Component;

/**
 * Created by John on 27.03.2017.
 */

@AppScope @Component(modules = AppModule.class) public interface AppComponent {

  //presenters
  void inject(MainActivityPresenter presenter);

  void inject(StartFragmentPresenter presenter);

  void inject(MapPolygonEditPresenter presenter);

  void inject(EditFieldPresenter presenter);

  void inject(AddFieldTrackingPresenter presenter);

  void inject(FieldTechnologicalMapPresenter presenter);

  void inject(FieldTechnologicalProcessPresenter presenter);

  void inject(EditFieldTechnologicalSolutionPresenter presenter);

  //activities
  void inject(BaseActivity activity);

  //fragments
  void inject(BaseFragment fragment);

  void inject(BaseManualAttachFragment fragment);

  //adapters
  void inject(FieldsAdapter adapter);

  void inject(FieldTechnologicalProcessesAdapter adapter);

  void inject(TechnologicalSolutionAdapter adapter);

  // managers
  void inject(DataManager dataManager);

  // helpers
  void inject(DbHelper dbHelper);

  void inject(DbCombinedFieldRelationsHelper dbCombinedFieldRelationsHelper);
}
