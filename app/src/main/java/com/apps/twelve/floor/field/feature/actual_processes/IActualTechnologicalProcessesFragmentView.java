package com.apps.twelve.floor.field.feature.actual_processes;

import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessObject;
import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import java.util.List;

/**
 * Created by yarrick on 07.09.17.
 */

@StateStrategyType(AddToEndSingleStrategy.class)
public interface IActualTechnologicalProcessesFragmentView extends MvpView {

  @StateStrategyType(SingleStateStrategy.class) void showTechnologicalProcesses(
      List<FieldCropTechnologicalProcessObject> technologicalProcessObjectList);

  @StateStrategyType(SkipStrategy.class) void openTechnologicalProcessFragment(int position);
}
