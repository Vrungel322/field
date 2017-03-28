package com.apps.twelve.floor.field.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by John on 28.03.2017.
 */

@StateStrategyType(AddToEndSingleStrategy.class) public interface IStartFragmentView
    extends MvpView {
}
