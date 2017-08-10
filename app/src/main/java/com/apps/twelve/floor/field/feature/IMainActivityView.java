package com.apps.twelve.floor.field.feature;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by John on 27.03.2017.
 */

@StateStrategyType(AddToEndSingleStrategy.class) public interface IMainActivityView
    extends MvpView {

  @StateStrategyType(SkipStrategy.class) void addStartFragment();

  void updateActionbar(boolean isShown, String title, boolean isSaveState);

  void restoreActionBar();
}
