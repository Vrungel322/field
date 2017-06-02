package com.apps.twelve.floor.field.feature.start_point;

import com.apps.twelve.floor.field.data.local.objects.FieldObject;
import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import java.util.List;

/**
 * Created by John on 28.03.2017.
 */

@StateStrategyType(AddToEndSingleStrategy.class) public interface IStartFragmentView
    extends MvpView {

  @StateStrategyType(SingleStateStrategy.class) void showFields(List<FieldObject> fieldObjects);

  void showFieldAddTypeDialog();

  void hideFieldAddTypeDialog();

  @StateStrategyType(SkipStrategy.class) void showEditFieldOnMapFragment();

  @StateStrategyType(SkipStrategy.class) void showEditFieldTrackingFragment();

  @StateStrategyType(SkipStrategy.class) void showEditFieldFullScreenFragment();

  @StateStrategyType(SkipStrategy.class) void openFieldTechnologicalMapFragment(int position);

  @StateStrategyType(AddToEndStrategy.class) void addField(FieldObject fieldObject);

  @StateStrategyType(AddToEndStrategy.class) void updateField(FieldObject fieldObject);

  @StateStrategyType(AddToEndStrategy.class) void deleteFieldAtPosition(FieldObject fieldObject,
      int position);
}
