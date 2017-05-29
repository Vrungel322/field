package com.apps.twelve.floor.field.di.components;

import com.apps.twelve.floor.field.base.BaseActivity;
import com.apps.twelve.floor.field.base.BaseFragment;
import com.apps.twelve.floor.field.base.BaseManualAttachFragment;
import com.apps.twelve.floor.field.data.DataManager;
import com.apps.twelve.floor.field.data.local.DbHelper;
import com.apps.twelve.floor.field.data.local.DbRelationsHelper;
import com.apps.twelve.floor.field.di.modules.AppModule;
import com.apps.twelve.floor.field.di.scopes.AppScope;
import com.apps.twelve.floor.field.feature.add_field.presenters.AddFieldTrackingPresenter;
import com.apps.twelve.floor.field.feature.edit_field.presenters.EditFieldPresenter;
import com.apps.twelve.floor.field.feature.edit_field.presenters.MapPolygonEditPresenter;
import com.apps.twelve.floor.field.feature.edit_field_technological_process.adapters.TechnologicalSolutionAdapter;
import com.apps.twelve.floor.field.feature.edit_field_technological_process.presenters.FieldTechnologicalProcessPresenter;
import com.apps.twelve.floor.field.feature.edit_field_technological_solution.presenters.EditFieldTechnologicalSolutionPresenter;
import com.apps.twelve.floor.field.feature.field_technological_map.adapters.FieldTechnologicalProcessesAdapter;
import com.apps.twelve.floor.field.feature.field_technological_map.presenters.FieldTechnologicalMapPresenter;
import com.apps.twelve.floor.field.feature.start_point.adapters.FieldsAdapter;
import com.apps.twelve.floor.field.feature.start_point.presenters.MainActivityPresenter;
import com.apps.twelve.floor.field.feature.start_point.presenters.StartFragmentPresenter;
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

  void inject(DbRelationsHelper dbRelationsHelper);
}
