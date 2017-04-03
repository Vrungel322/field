package com.apps.twelve.floor.field.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by Yaroslav on 03.04.2017.
 */

@StateStrategyType(AddToEndSingleStrategy.class) public interface IEditFieldFragmentView
    extends MvpView {

  void setFieldNameText(String name);

  void setFieldAreaText(String area);

  void setFieldCropText(String crop);
}
