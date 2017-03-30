package com.apps.twelve.floor.field.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Yaroslav on 30.03.2017.
 */

@StateStrategyType(AddToEndSingleStrategy.class) public interface IAddFieldOnMapFragmentView
    extends MvpView {

  @StateStrategyType(SkipStrategy.class) void addMarkerOnMap(LatLng latLng);
}
