package com.apps.twelve.floor.field.feature.edit_field_technological_solution.views;

import com.apps.twelve.floor.field.data.local.objects.solutions.TechnologicalSolutionTypeObject;
import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import java.util.List;

/**
 * Created by Yaroslav on 29.05.2017.
 */

@StateStrategyType(AddToEndSingleStrategy.class) public interface ITechnologicalSolutionFragmentView
    extends MvpView {

  void addSolutionTypesToSpinnerAdapter(List<TechnologicalSolutionTypeObject> solutionTypes);

  void setSelectedSolutionType(TechnologicalSolutionTypeObject type);
}
