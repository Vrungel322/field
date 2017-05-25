package com.apps.twelve.floor.field.di.components;

import com.apps.twelve.floor.field.di.modules.AppModule;
import com.apps.twelve.floor.field.di.scopes.AppScope;
import com.apps.twelve.floor.field.mvp.data.DataManager;
import com.apps.twelve.floor.field.mvp.data.local.DbHelper;
import com.apps.twelve.floor.field.mvp.data.local.DbRelationsHelper;
import com.apps.twelve.floor.field.mvp.presenters.pr_activities.MainActivityPresenter;
import com.apps.twelve.floor.field.mvp.presenters.pr_fragments.AddFieldTrackingPresenter;
import com.apps.twelve.floor.field.mvp.presenters.pr_fragments.EditFieldPresenter;
import com.apps.twelve.floor.field.mvp.presenters.pr_fragments.FieldTechnologicalMapPresenter;
import com.apps.twelve.floor.field.mvp.presenters.pr_fragments.FieldTechnologicalProcessPresenter;
import com.apps.twelve.floor.field.mvp.presenters.pr_fragments.MapPolygonEditPresenter;
import com.apps.twelve.floor.field.mvp.presenters.pr_fragments.StartFragmentPresenter;
import com.apps.twelve.floor.field.ui.adapters.FieldTechnologicalProcessesAdapter;
import com.apps.twelve.floor.field.ui.adapters.FieldsAdapter;
import com.apps.twelve.floor.field.ui.adapters.TechnologicalSolutionAdapter;
import com.apps.twelve.floor.field.ui.base.BaseActivity;
import com.apps.twelve.floor.field.ui.base.BaseFragment;
import com.apps.twelve.floor.field.ui.base.BaseManualAttachFragment;
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
