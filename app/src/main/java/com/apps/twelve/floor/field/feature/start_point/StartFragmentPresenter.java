package com.apps.twelve.floor.field.feature.start_point;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.base.BasePresenter;
import com.apps.twelve.floor.field.data.DataManager;
import com.apps.twelve.floor.field.data.local.objects.CropObject;
import com.apps.twelve.floor.field.data.local.objects.FieldObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionTypeObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.SoilTypeObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.ClimateZoneObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.PhaseObject;
import com.apps.twelve.floor.field.utils.RxBus;
import com.apps.twelve.floor.field.utils.RxBusHelper;
import com.apps.twelve.floor.field.utils.ThreadSchedulers;
import com.arellomobile.mvp.InjectViewState;
import com.pushtorefresh.storio.sqlite.operations.delete.DeleteResult;
import java.util.ArrayList;
import javax.inject.Inject;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

/**
 * Created by John on 28.03.2017.
 */

@InjectViewState public class StartFragmentPresenter extends BasePresenter<IStartFragmentView> {

  @Inject DataManager mDataManager;
  @Inject RxBus mRxBus;

  private int mFieldTypePosition = -1;

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();

    getAllFields();

    subscribeToFieldsDbChanges();
    subscribeToFieldsListChanges();

    // TODO: this is for test - remove
    addTestData();
  }

  public void showFieldTypeDialog() {
    getViewState().showFieldAddTypeDialog();
  }

  public void hideFieldTypeDialog() {
    mFieldTypePosition = -1;
    getViewState().hideFieldAddTypeDialog();
  }

  public void setFieldTypePosition(int position) {
    mFieldTypePosition = position;
  }

  public int getFieldTypePosition() {
    return mFieldTypePosition;
  }

  private void getAllFields() {
    Subscription subscription = mDataManager.getAllFields()
        .compose(ThreadSchedulers.applySchedulers())
        .subscribe(fields -> getViewState().showFields(fields), Timber::e);

    addToUnsubscription(subscription);
  }

  private void addTestData() {

    // Crops
    CropObject cornCropObject = new CropObject(1, "Кукуруза", 0, false);
    mDataManager.putCrop(cornCropObject);
    mDataManager.putCrop(new CropObject(2, "Картошка", 0, false));
    mDataManager.putCrop(new CropObject(3, "Свекла", 0, false));
    mDataManager.putCrop(new CropObject(4, "Пшеница", 0, false));
    mDataManager.putCrop(new CropObject(5, "Виноград", 0, false));
    mDataManager.putCrop(new CropObject(6, "Лен", 0, false));

    // Climate zones
    mDataManager.putClimateZone(
        new ClimateZoneObject(1, "Влажная, умеренно теплая зона", new ArrayList<>()));
    mDataManager.putClimateZone(
        new ClimateZoneObject(2, "Подзона достаточно увлажненной почвы", new ArrayList<>()));
    mDataManager.putClimateZone(
        new ClimateZoneObject(3, "Закарпатский влажный, теплый раен с мягкой зимой",
            new ArrayList<>()));
    mDataManager.putClimateZone(
        new ClimateZoneObject(4, "Предкарпатский влажный, теплый раен", new ArrayList<>()));
    mDataManager.putClimateZone(
        new ClimateZoneObject(5, "Недостаточно влажная, теплая зона", new ArrayList<>()));
    mDataManager.putClimateZone(
        new ClimateZoneObject(6, "Засушливая, очень теплая зона", new ArrayList<>()));
    mDataManager.putClimateZone(
        new ClimateZoneObject(7, "Донецкий недостаточно влажный, очень теплый раен",
            new ArrayList<>()));
    mDataManager.putClimateZone(
        new ClimateZoneObject(8, "Очень засушливая, умеренно жаркая зона с мягкой зимой",
            new ArrayList<>()));
    mDataManager.putClimateZone(new ClimateZoneObject(9,
        "Передгорный Крымский засушливый, очень теплый раен с мягкой зимой", new ArrayList<>()));
    mDataManager.putClimateZone(
        new ClimateZoneObject(10, "Карпатский раен вертикальной климатической поясности",
            new ArrayList<>()));
    mDataManager.putClimateZone(
        new ClimateZoneObject(11, "Крымский раен вертикальной климатической поясности",
            new ArrayList<>()));

    // Phases
    mDataManager.putPhase(new PhaseObject(1, "Фізично стиглий ґрунт", cornCropObject));
    mDataManager.putPhase(new PhaseObject(2, "До посіву", cornCropObject));
    mDataManager.putPhase(new PhaseObject(3, "Суха зернівка", cornCropObject));
    mDataManager.putPhase(new PhaseObject(4, "Протруєне насіння", cornCropObject));
    mDataManager.putPhase(
        new PhaseObject(5, "Після посіву - початок набубнявіння насіння", cornCropObject));
    mDataManager.putPhase(
        new PhaseObject(6, "Після сівби до появи сходів кукурудзи", cornCropObject));
    mDataManager.putPhase(new PhaseObject(7, "До появи сходів кукурудзи", cornCropObject));
    mDataManager.putPhase(new PhaseObject(8, "У фазі 2-3-х листків", cornCropObject));
    mDataManager.putPhase(new PhaseObject(9, "У фазу 4-5-х листків", cornCropObject));
    mDataManager.putPhase(new PhaseObject(10, "3-5 листків у кукурудзи", cornCropObject));
    mDataManager.putPhase(new PhaseObject(11, "4-6 листків у кукурудзи", cornCropObject));
    mDataManager.putPhase(new PhaseObject(12, "Від 5 до 7 листка", cornCropObject));
    mDataManager.putPhase(new PhaseObject(13, "4-8 до 10 листків", cornCropObject));
    mDataManager.putPhase(new PhaseObject(14, "Висота рослин 30-40см", cornCropObject));
    mDataManager.putPhase(new PhaseObject(15, "Початок викидання волоті", cornCropObject));
    mDataManager.putPhase(
        new PhaseObject(16, "Кінець викидання волоті - початок цвітіння", cornCropObject));
    mDataManager.putPhase(new PhaseObject(17, "Слідом за збиранням попередника ", cornCropObject));
    mDataManager.putPhase(new PhaseObject(18,
        "У фазі розетки у багаторічних дводольних та за висоти 10-20 см у багаторічних злакових",
        cornCropObject));

    // Condition types
    ConditionTypeObject conditionTypeSoilType = new ConditionTypeObject(1, "Тип почвы");
    mDataManager.putConditionType(conditionTypeSoilType);
    mDataManager.putConditionType(new ConditionTypeObject(2, "Фаза развития вредного объекта"));
    mDataManager.putConditionType(
        new ConditionTypeObject(3, "Направление обработки почвы, посева, опрыскивания"));
    mDataManager.putConditionType(new ConditionTypeObject(4, "Фенологическая характеристика"));
    mDataManager.putConditionType(new ConditionTypeObject(5, "Числовой диапазон"));
    mDataManager.putConditionType(new ConditionTypeObject(6, "Число"));

    // Soil types
    mDataManager.putSoilType(
        new SoilTypeObject(1, "Дернисто-підзолисті", conditionTypeSoilType, ""));
    mDataManager.putSoilType(
        new SoilTypeObject(2, "Сірі, ясно-сірі та темно-сірі опідзолені", conditionTypeSoilType,
            ""));
    mDataManager.putSoilType(
        new SoilTypeObject(3, "Черноземи опідзолені і темно-сірі опідзолені", conditionTypeSoilType,
            ""));
    mDataManager.putSoilType(new SoilTypeObject(4, "Черноземи типові", conditionTypeSoilType, ""));
    mDataManager.putSoilType(
        new SoilTypeObject(5, "Черноземи звичайні", conditionTypeSoilType, ""));
    mDataManager.putSoilType(
        new SoilTypeObject(6, "Черноземи південні частково солонцюваті", conditionTypeSoilType,
            ""));
    mDataManager.putSoilType(
        new SoilTypeObject(7, "Черноземи дернові щебенясті на продуктах вивітрювання твердих порід",
            conditionTypeSoilType, ""));
    mDataManager.putSoilType(
        new SoilTypeObject(8, "Темно-каштанові в комплексі з солонцями", conditionTypeSoilType,
            ""));
    mDataManager.putSoilType(
        new SoilTypeObject(9, "Лучно-чорноземні, лучні, лучно-болотні", conditionTypeSoilType, ""));
    mDataManager.putSoilType(
        new SoilTypeObject(10, "Бурі гірськолісові", conditionTypeSoilType, ""));
    mDataManager.putSoilType(
        new SoilTypeObject(11, "Коричневі щебенясті", conditionTypeSoilType, ""));
  }

  private void subscribeToFieldsListChanges() {
    Subscription subscription = mRxBus.filteredObservable(RxBusHelper.FieldDeletedFromList.class)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(msg -> onFieldDeletedFromList(msg.field, msg.position), Timber::e);
    addToUnsubscription(subscription);
  }

  private void onFieldDeletedFromList(FieldObject field, int position) {
    DeleteResult deleteResult = mDataManager.deleteField(field);

    if (deleteResult.numberOfRowsDeleted() > 0) {
      getViewState().deleteFieldAtPosition(field, position);
    }
  }

  private void subscribeToFieldsDbChanges() {
    Subscription subscription = mRxBus.filteredObservable(RxBusHelper.FieldChangedInDb.class)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(msg -> onFieldChanged(msg.fieldObject, msg.change), Timber::e);
    addToUnsubscription(subscription);
  }

  private void onFieldChanged(FieldObject fieldObject, int change) {
    switch (change) {
      case RxBusHelper.FieldChangedInDb.CHANGE_INSERT:
        getViewState().addField(fieldObject);
        break;
      case RxBusHelper.FieldChangedInDb.CHANGE_UPDATE:
        getViewState().updateField(fieldObject);
        break;
      default:
        break;
    }
  }

  public void onFieldTypeDialogPositiveButton(int which) {
    switch (which) {
      case 0:
        getViewState().showEditFieldOnMapFragment();
        break;
      case 1:
        getViewState().showEditFieldTrackingFragment();
        break;
      case 2:
        getViewState().showEditFieldFullScreenFragment();
        break;
      default:
        break;
    }
  }

  public void onFiledClickedAtPosition(int position) {
    getViewState().openFieldTechnologicalMapFragment(position);
  }
}
