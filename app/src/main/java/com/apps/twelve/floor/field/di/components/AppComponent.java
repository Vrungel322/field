package com.apps.twelve.floor.field.di.components;

import com.apps.twelve.floor.field.di.modules.AppModule;
import com.apps.twelve.floor.field.di.scopes.AppScope;
import com.apps.twelve.floor.field.mvp.presenters.pr_activities.MainActivityPresenter;
import com.apps.twelve.floor.field.mvp.presenters.pr_fragments.StartFragmentPresenter;
import com.apps.twelve.floor.field.ui.adapters.FieldsAdapter;
import com.apps.twelve.floor.field.ui.base.BaseActivity;
import com.apps.twelve.floor.field.ui.base.BaseFragment;
import dagger.Component;

/**
 * Created by John on 27.03.2017.
 */

@AppScope @Component(modules = AppModule.class) public interface AppComponent {

  //presenters
  void inject(MainActivityPresenter presenter);

  void inject(StartFragmentPresenter presenter);

  //activities
  void inject(BaseActivity activity);

  //fragments
  void inject(BaseFragment fragment);

  //adapters
  void inject(FieldsAdapter adapter);
}
