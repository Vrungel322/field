package com.apps.twelve.floor.field.feature.edit_field.views;

import com.apps.twelve.floor.field.data.local.objects.CropObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.ClimateZoneObject;
import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import java.util.List;

/**
 * Created by Yaroslav on 03.04.2017.
 */

@StateStrategyType(AddToEndSingleStrategy.class) public interface IEditFieldFragmentView
    extends MvpView {

  void setFieldNameText(String name);

  void setFieldAreaText(String area);

  void setBtnOkEnabled(boolean isEnabled);

  void addCropsToSpinnerAdapter(List<CropObject> crops);

  void addPreviousCropsToSpinnerAdapter(List<CropObject> crops);

  void addClimateZonesToSpinnerAdapter(List<ClimateZoneObject> climateZones);

  void setSelectedCrop(CropObject cropObject);

  void setSelectedPreviousCrop(CropObject cropObject);

  void setSelectedClimateZone(ClimateZoneObject climateZoneObject);
}
