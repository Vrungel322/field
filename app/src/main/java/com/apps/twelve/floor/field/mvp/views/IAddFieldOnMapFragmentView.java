package com.apps.twelve.floor.field.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by Yaroslav on 30.03.2017.
 */

@StateStrategyType(AddToEndSingleStrategy.class) public interface IAddFieldOnMapFragmentView
    extends MvpView {

}
