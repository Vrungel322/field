package com.apps.twelve.floor.field.feature.splash;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by yarrick on 04.08.17.
 */

@StateStrategyType(AddToEndSingleStrategy.class) public interface ISplashFragmentView
    extends MvpView {

  @StateStrategyType(SkipStrategy.class) void showStartFragment();

  void showErrorDialog();

  void hideErrorDialog();
}
