package com.apps.twelve.floor.field.feature.field_technological_process.views;

import com.apps.twelve.floor.field.data.local.objects.TechnologicalSolutionObject;
import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import java.util.List;

/**
 * Created by Yaroslav on 25.05.2017.
 */

@StateStrategyType(AddToEndSingleStrategy.class) public interface ITechnologicalProcessFragmentView
    extends MvpView {

  @StateStrategyType(SingleStateStrategy.class) void showTechnologicalSolutions(
      List<TechnologicalSolutionObject> technologicalSolutionsObjectList);
}
