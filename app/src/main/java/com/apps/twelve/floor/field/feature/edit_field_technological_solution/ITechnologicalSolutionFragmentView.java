package com.apps.twelve.floor.field.feature.edit_field_technological_solution;

import com.apps.twelve.floor.field.data.local.objects.solutions.BaseTechnologicalSolutionObject;
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

  void addSolutionValuesToSpinnerAdapter(List<BaseTechnologicalSolutionObject> solutionValues);

  void setSelectedSolutionType(TechnologicalSolutionTypeObject solutionType);

  void setSelectedSolutionValue(BaseTechnologicalSolutionObject solutionValue);

  void updateTextQuantity(String quantity);

  void updateTextPrice(String price);

  void updateTextSum(String sum);
}
