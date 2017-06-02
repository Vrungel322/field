package com.apps.twelve.floor.field.feature.field_technological_map;

import com.apps.twelve.floor.field.data.local.objects.technological_map.FieldCropTechnologicalProcessObject;
import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import java.util.List;

/**
 * Created by Yaroslav on 23.05.2017.
 */

@StateStrategyType(AddToEndSingleStrategy.class) public interface IFieldTechnologicalMapFragmentView
    extends MvpView {

  @StateStrategyType(SingleStateStrategy.class) void showTechnologicalMap(
      List<FieldCropTechnologicalProcessObject> technologicalProcessObjectList);

  @StateStrategyType(SkipStrategy.class) void openTechnologicalProcessFragment(int position);
}
