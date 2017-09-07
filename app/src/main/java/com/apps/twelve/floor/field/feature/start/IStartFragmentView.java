package com.apps.twelve.floor.field.feature.start;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by yarrick on 07.09.17.
 */

@StateStrategyType(AddToEndSingleStrategy.class) public interface IStartFragmentView
    extends MvpView {
}
