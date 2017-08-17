package com.apps.twelve.floor.field.feature.field_technological_process_conditions;

import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessConditionObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessObject;
import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import java.util.List;

/**
 * Created by yarrick on 16.08.17.
 */

@StateStrategyType(AddToEndSingleStrategy.class)
public interface ITechnologicalProcessConditionsFragmentView extends MvpView {

  @StateStrategyType(SingleStateStrategy.class) void showConditions(
      List<FieldCropTechnologicalProcessConditionObject> conditions);

  @StateStrategyType(AddToEndStrategy.class) void updateCondition(
      FieldCropTechnologicalProcessConditionObject condition);

  @StateStrategyType(SkipStrategy.class) void openTechnologicalProcessFragment(
      FieldCropTechnologicalProcessObject process);
}
