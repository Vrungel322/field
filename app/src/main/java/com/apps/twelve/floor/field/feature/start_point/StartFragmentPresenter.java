package com.apps.twelve.floor.field.feature.start_point;

import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.base.BasePresenter;
import com.apps.twelve.floor.field.data.DataManager;
import com.apps.twelve.floor.field.data.local.mappers.ProcessPeriodObjectToProcessPeriodEntity;
import com.apps.twelve.floor.field.data.local.objects.CropObject;
import com.apps.twelve.floor.field.data.local.objects.FieldObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionSpanValueObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.ConditionTypeObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.PestObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.PhenologicalCharacteristicObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.SoilTypeObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.TillageDirectionObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.WeedNutritionTypeObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.ClimateZoneObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.PhaseObject;
import com.apps.twelve.floor.field.data.local.objects.process_time.ProcessPeriodObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.AggregateObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.InsectObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.ProductCategoryObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.ProductObject;
import com.apps.twelve.floor.field.data.local.objects.solutions.TechnologicalSolutionTypeObject;
import com.apps.twelve.floor.field.data.local.objects.technological_map.TechnologicalProcessStateObject;
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

  public int getFieldTypePosition() {
    return mFieldTypePosition;
  }

  public void setFieldTypePosition(int position) {
    mFieldTypePosition = position;
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

  private void getAllFields() {
    Subscription subscription = mDataManager.getAllFields()
        .compose(ThreadSchedulers.applySchedulers())
        .subscribe(fields -> getViewState().showFields(fields), Timber::e);

    addToUnsubscription(subscription);
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

  private void addTestData() {

    // Crops
    CropObject cornCropObject = new CropObject(1, "Кукуруза", 0, false, true);
    mDataManager.putCrop(cornCropObject);
    mDataManager.putCrop(new CropObject(2, "Картошка", 0, false, false));
    mDataManager.putCrop(new CropObject(3, "Свекла", 0, false, false));
    mDataManager.putCrop(new CropObject(4, "Пшеница", 0, false, false));
    mDataManager.putCrop(new CropObject(5, "Виноград", 0, false, false));
    mDataManager.putCrop(new CropObject(6, "Лен", 0, false, false));

    // Climate zones
    mDataManager.putClimateZone(new ClimateZoneObject(1, "Степ", new ArrayList<>()));
    mDataManager.putClimateZone(new ClimateZoneObject(2, "Лісо-степ", new ArrayList<>()));
    mDataManager.putClimateZone(new ClimateZoneObject(3, "Полісся", new ArrayList<>()));
    mDataManager.putClimateZone(
        new ClimateZoneObject(4, "Карпатські та Кримські гори", new ArrayList<>()));
    /*mDataManager.putClimateZone(
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
            new ArrayList<>()));*/

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
    ArrayList<ConditionTypeObject> conditionTypes = new ArrayList<>();
    conditionTypes.add(new ConditionTypeObject(1, "Тип почвы"));
    conditionTypes.add(new ConditionTypeObject(2, "Фаза развития вредного объекта"));
    conditionTypes.add(
        new ConditionTypeObject(3, "Направление обработки почвы, посева, опрыскивания"));
    conditionTypes.add(new ConditionTypeObject(4, "Фенологическая характеристика"));
    conditionTypes.add(new ConditionTypeObject(5, "Числовой диапазон"));
    conditionTypes.add(new ConditionTypeObject(6, "Число"));
    conditionTypes.add(new ConditionTypeObject(7, "Вредный объект"));
    for (ConditionTypeObject conditionType : conditionTypes) {
      mDataManager.putConditionType(conditionType);
    }

    //SpanValues
    ArrayList<ConditionSpanValueObject> conditionSpanValueObjects = new ArrayList<>();
    conditionSpanValueObjects.add(new ConditionSpanValueObject(1, conditionTypes.get(4), 0, 10));
    conditionSpanValueObjects.add(new ConditionSpanValueObject(1, conditionTypes.get(4), 0, 10));
    conditionSpanValueObjects.add(new ConditionSpanValueObject(1, conditionTypes.get(4), 10, 300));
    conditionSpanValueObjects.add(new ConditionSpanValueObject(1, conditionTypes.get(4), 12, 20));
    conditionSpanValueObjects.add(new ConditionSpanValueObject(1, conditionTypes.get(4), 8, 10));
    conditionSpanValueObjects.add(new ConditionSpanValueObject(1, conditionTypes.get(4), 0, 25));
    conditionSpanValueObjects.add(new ConditionSpanValueObject(1, conditionTypes.get(4), 0, 25));
    conditionSpanValueObjects.add(new ConditionSpanValueObject(1, conditionTypes.get(4), 0, 25));
    conditionSpanValueObjects.add(new ConditionSpanValueObject(1, conditionTypes.get(4), 0, 25));
    conditionSpanValueObjects.add(new ConditionSpanValueObject(1, conditionTypes.get(4), 0, 25));
    conditionSpanValueObjects.add(new ConditionSpanValueObject(1, conditionTypes.get(4), 0, 25));
    conditionSpanValueObjects.add(new ConditionSpanValueObject(1, conditionTypes.get(4), 0, 25));

    for (int i = 0; i < conditionSpanValueObjects.size(); i++) {
      mDataManager.putSpanValue(conditionSpanValueObjects.get(i));
    }

    //Temperature
    for (int i = 0; i < conditionSpanValueObjects.size(); i++) {
      mDataManager.putCondition(new ConditionObject(i, "T воздуха", 1, conditionTypes.get(4),
          conditionSpanValueObjects.get(i)));
    }

    // Soil types
    mDataManager.putSoilType(
        new SoilTypeObject(1, "Піщані, або легкі грунти", conditionTypes.get(0), ""));
    mDataManager.putSoilType(
        new SoilTypeObject(2, "Глинисті, або важкі грунти ", conditionTypes.get(0), ""));
    mDataManager.putSoilType(new SoilTypeObject(3, "Кам'янисті грунти", conditionTypes.get(0), ""));
    mDataManager.putSoilType(
        new SoilTypeObject(4, "Торф'яно-болотні грунти", conditionTypes.get(0), ""));
    mDataManager.putSoilType(new SoilTypeObject(5, "Супіщані грунти", conditionTypes.get(0), ""));
    mDataManager.putSoilType(
        new SoilTypeObject(6, "Суглинні, або середні грунти", conditionTypes.get(0), ""));

    // Soils
    /*mDataManager.putSoilType(
        new SoilTypeObject(1, "Дернисто-підзолисті", conditionTypes.get(0), ""));
    mDataManager.putSoilType(
        new SoilTypeObject(2, "Сірі, ясно-сірі та темно-сірі опідзолені", conditionTypes.get(0),
            ""));
    mDataManager.putSoilType(
        new SoilTypeObject(3, "Черноземи опідзолені і темно-сірі опідзолені", conditionTypes.get(0),
            ""));
    mDataManager.putSoilType(new SoilTypeObject(4, "Черноземи типові", conditionTypes.get(0), ""));
    mDataManager.putSoilType(
        new SoilTypeObject(5, "Черноземи звичайні", conditionTypes.get(0), ""));
    mDataManager.putSoilType(
        new SoilTypeObject(6, "Черноземи південні частково солонцюваті", conditionTypes.get(0),
            ""));
    mDataManager.putSoilType(
        new SoilTypeObject(7, "Черноземи дернові щебенясті на продуктах вивітрювання твердих порід",
            conditionTypes.get(0), ""));
    mDataManager.putSoilType(
        new SoilTypeObject(8, "Темно-каштанові в комплексі з солонцями", conditionTypes.get(0),
            ""));
    mDataManager.putSoilType(
        new SoilTypeObject(9, "Лучно-чорноземні, лучні, лучно-болотні", conditionTypes.get(0), ""));
    mDataManager.putSoilType(
        new SoilTypeObject(10, "Бурі гірськолісові", conditionTypes.get(0), ""));
    mDataManager.putSoilType(
        new SoilTypeObject(11, "Коричневі щебенясті", conditionTypes.get(0), ""));*/

    // Technological Process State
    mDataManager.putTechnologicalProcessState(
        new TechnologicalProcessStateObject(1, "В очереди", 0));
    mDataManager.putTechnologicalProcessState(
        new TechnologicalProcessStateObject(2, "Актуален", 0));
    mDataManager.putTechnologicalProcessState(
        new TechnologicalProcessStateObject(3, "Выполнен", 0));
    mDataManager.putTechnologicalProcessState(new TechnologicalProcessStateObject(4, "Отменен", 0));
    mDataManager.putTechnologicalProcessState(
        new TechnologicalProcessStateObject(5, "Пропущен", 0));

    // Pests
    mDataManager.putPest(new PestObject(1, "злакові бур’яни", conditionTypes.get(6), 0, false));
    mDataManager.putPest(
        new PestObject(2, "ярі дводольні бур’яни", conditionTypes.get(6), 0, false));
    mDataManager.putPest(
        new PestObject(3, "Однорічні зимуючі бур’яни", conditionTypes.get(6), 0, false));
    mDataManager.putPest(
        new PestObject(4, "Збудники пліснявіння  насіння", conditionTypes.get(6), 0, false));
    mDataManager.putPest(new PestObject(5, "Збудники фузаріозу", conditionTypes.get(6), 0, false));
    mDataManager.putPest(new PestObject(6, "Дротяники", conditionTypes.get(6), 0, false));
    mDataManager.putPest(new PestObject(7, "ківсяки", conditionTypes.get(6), 0, false));
    mDataManager.putPest(new PestObject(8, "личинки хрущів", conditionTypes.get(6), 0, false));
    mDataManager.putPest(
        new PestObject(9, "личинки хлібних жуків", conditionTypes.get(6), 0, false));
    mDataManager.putPest(
        new PestObject(10, "ярі дводольні бур’яни", conditionTypes.get(6), 0, false));
    mDataManager.putPest(
        new PestObject(11, "ярі злакові бур’яни", conditionTypes.get(6), 0, false));
    mDataManager.putPest(
        new PestObject(12, "Однорічні ярі дводольні бур’яни", conditionTypes.get(6), 0, false));
    mDataManager.putPest(
        new PestObject(13, "Однорічні ярі злакові бур’яни", conditionTypes.get(6), 0, false));
    mDataManager.putPest(
        new PestObject(14, "Однорічні дводольні бур’яни", conditionTypes.get(6), 0, false));
    mDataManager.putPest(
        new PestObject(15, "Однорічні злакові бур’яни", conditionTypes.get(6), 0, false));
    mDataManager.putPest(
        new PestObject(16, "багаторічні дводольні бур’яни", conditionTypes.get(6), 0, false));
    mDataManager.putPest(
        new PestObject(17, "багаторічні злакові бур’яни", conditionTypes.get(6), 0, false));
    mDataManager.putPest(new PestObject(18, "Шведська муха", conditionTypes.get(6), 0, false));
    mDataManager.putPest(new PestObject(19, "попелиці", conditionTypes.get(6), 0, false));
    mDataManager.putPest(
        new PestObject(20, "кукурудзяний метелик", conditionTypes.get(6), 0, false));
    mDataManager.putPest(new PestObject(21, "лучний метелик", conditionTypes.get(6), 0, false));
    mDataManager.putPest(new PestObject(22, "бавовникова совка", conditionTypes.get(6), 0, false));

    // Tillage directions
    mDataManager.putTillageDirection(
        new TillageDirectionObject(1, "під кутом 45⁰ до напряму оранки", conditionTypes.get(2)));
    mDataManager.putTillageDirection(
        new TillageDirectionObject(2, "Човнико-вий або діагональ-ний", conditionTypes.get(2)));
    mDataManager.putTillageDirection(
        new TillageDirectionObject(3, "міжряддя вздовж рядків", conditionTypes.get(2)));
    mDataManager.putTillageDirection(
        new TillageDirectionObject(4, "суцільний обробіток", conditionTypes.get(2)));

    // Phenological Characteristic
    mDataManager.putPhenologicalCharacteristic(
        new PhenologicalCharacteristicObject(1, "Цвітіння черемухи", conditionTypes.get(3)));
    mDataManager.putPhenologicalCharacteristic(
        new PhenologicalCharacteristicObject(2, "Цвітіння черешні", conditionTypes.get(3)));
    mDataManager.putPhenologicalCharacteristic(new PhenologicalCharacteristicObject(3,
        "Активна вегетація. Рослини не повинні перебувати в стресовому стані",
        conditionTypes.get(3)));
    mDataManager.putPhenologicalCharacteristic(new PhenologicalCharacteristicObject(4,
        "Початок масового льоту кукурудзяного метелика -визначається за допомогою феромонних пасток. ",
        conditionTypes.get(3)));
    mDataManager.putPhenologicalCharacteristic(
        new PhenologicalCharacteristicObject(5, "масове відкладання яєць кукурудзяним метеликом",
            conditionTypes.get(3)));
    mDataManager.putPhenologicalCharacteristic(
        new PhenologicalCharacteristicObject(6, "проникнення перших гусениць у стебла",
            conditionTypes.get(3)));
    mDataManager.putPhenologicalCharacteristic(
        new PhenologicalCharacteristicObject(7, "Активна вегетація бур’янів",
            conditionTypes.get(3)));
    mDataManager.putPhenologicalCharacteristic(new PhenologicalCharacteristicObject(9,
        "Візуально визначається по наявності чор-ного прошарку (чорної точки) між зерном і місцем прикріплення його до качана",
        conditionTypes.get(3)));

    // Technological Solution Types
    TechnologicalSolutionTypeObject techSolutionTypeAggregates =
        new TechnologicalSolutionTypeObject(1, "Агрегаты");
    TechnologicalSolutionTypeObject techSolutionTypeProducts =
        new TechnologicalSolutionTypeObject(2, "Препараты");
    TechnologicalSolutionTypeObject techSolutionTypeInsects =
        new TechnologicalSolutionTypeObject(3, "Насекомые");
    mDataManager.putTechnologicalSolutionType(techSolutionTypeAggregates);
    mDataManager.putTechnologicalSolutionType(techSolutionTypeProducts);
    mDataManager.putTechnologicalSolutionType(techSolutionTypeInsects);
    mDataManager.putTechnologicalSolutionType(
        new TechnologicalSolutionTypeObject(4, "Другие решения"));

    // Aggregates
    mDataManager.putAggregate(
        new AggregateObject(1, "Важка борона", techSolutionTypeAggregates, 0));
    mDataManager.putAggregate(
        new AggregateObject(2, "Волокуша-вирівнювач", techSolutionTypeAggregates, 0));
    mDataManager.putAggregate(new AggregateObject(3, "Культиватор", techSolutionTypeAggregates, 0));
    mDataManager.putAggregate(
        new AggregateObject(4, "Гладкорубчасті котки", techSolutionTypeAggregates, 0));
    mDataManager.putAggregate(
        new AggregateObject(5, "Кільчасті котки", techSolutionTypeAggregates, 0));
    mDataManager.putAggregate(
        new AggregateObject(6, "Борона ЗБП-0.6", techSolutionTypeAggregates, 0));
    mDataManager.putAggregate(
        new AggregateObject(7, "Борона БЗСС-1", techSolutionTypeAggregates, 0));
    mDataManager.putAggregate(
        new AggregateObject(8, "Культиватор КРН-4.2", techSolutionTypeAggregates, 0));
    mDataManager.putAggregate(
        new AggregateObject(9, "Культиватор КРН-5.6", techSolutionTypeAggregates, 0));
    mDataManager.putAggregate(
        new AggregateObject(11, "Дисковий лущильник", techSolutionTypeAggregates, 0));
    mDataManager.putAggregate(
        new AggregateObject(12, "Оприскувачі навісні", techSolutionTypeAggregates, 0));
    mDataManager.putAggregate(
        new AggregateObject(13, "Оприскувачі причіпні", techSolutionTypeAggregates, 0));
    mDataManager.putAggregate(
        new AggregateObject(14, "Кукурудзозбиральні комбайни", techSolutionTypeAggregates, 0));
    mDataManager.putAggregate(
        new AggregateObject(15, "Зернозбиральні комбайни", techSolutionTypeAggregates, 0));

    // Insects
    mDataManager.putInsect(
        new InsectObject(1, "Вогнівкова раса трихограми", techSolutionTypeInsects, 0));

    // Product categories
    ArrayList<ProductCategoryObject> productCategoryObjects = new ArrayList<>();
    productCategoryObjects.add(new ProductCategoryObject(1, "Гербіциди"));
    productCategoryObjects.add(new ProductCategoryObject(2, "Фунгiциди"));
    productCategoryObjects.add(new ProductCategoryObject(3, "Протруйники"));
    productCategoryObjects.add(new ProductCategoryObject(4, "Iнсектициди"));
    for (ProductCategoryObject productCategoryObject : productCategoryObjects) {
      mDataManager.putProductCategory(productCategoryObject);
    }

    // Products
    mDataManager.putProduct(new ProductObject(1, "Агрощит Супер", techSolutionTypeProducts, 0,
        productCategoryObjects.get(0)));
    mDataManager.putProduct(
        new ProductObject(2, "Азимут", techSolutionTypeProducts, 0, productCategoryObjects.get(1)));
    mDataManager.putProduct(
        new ProductObject(3, "Аліот", techSolutionTypeProducts, 0, productCategoryObjects.get(1)));
    mDataManager.putProduct(
        new ProductObject(4, "Велес", techSolutionTypeProducts, 0, productCategoryObjects.get(3)));
    mDataManager.putProduct(new ProductObject(5, "Вершина", techSolutionTypeProducts, 0,
        productCategoryObjects.get(2)));
    mDataManager.putProduct(
        new ProductObject(6, "Вирій", techSolutionTypeProducts, 0, productCategoryObjects.get(3)));
    mDataManager.putProduct(new ProductObject(7, "Екстракорн", techSolutionTypeProducts, 0,
        productCategoryObjects.get(0)));
    mDataManager.putProduct(new ProductObject(8, "Карбеназол", techSolutionTypeProducts, 0,
        productCategoryObjects.get(1)));
    mDataManager.putProduct(
        new ProductObject(9, "Кіаніт", techSolutionTypeProducts, 0, productCategoryObjects.get(0)));
    mDataManager.putProduct(
        new ProductObject(10, "Койот", techSolutionTypeProducts, 0, productCategoryObjects.get(2)));
    mDataManager.putProduct(new ProductObject(11, "Лавина", techSolutionTypeProducts, 0,
        productCategoryObjects.get(0)));
    mDataManager.putProduct(new ProductObject(12, "Ратник", techSolutionTypeProducts, 0,
        productCategoryObjects.get(0)));
    mDataManager.putProduct(new ProductObject(13, "Ріпіус", techSolutionTypeProducts, 0,
        productCategoryObjects.get(0)));
    mDataManager.putProduct(new ProductObject(14, "Сатурн", techSolutionTypeProducts, 0,
        productCategoryObjects.get(0)));
    mDataManager.putProduct(
        new ProductObject(15, "Скат", techSolutionTypeProducts, 0, productCategoryObjects.get(0)));
    mDataManager.putProduct(new ProductObject(16, "Сотейра", techSolutionTypeProducts, 0,
        productCategoryObjects.get(0)));
    mDataManager.putProduct(new ProductObject(17, "Таймень", techSolutionTypeProducts, 0,
        productCategoryObjects.get(2)));

    //Process Period
    ArrayList<ProcessPeriodObject> processPeriodObjects = new ArrayList<>();
    //tech process - 1
    processPeriodObjects.add(new ProcessPeriodObject(1, 10, 20, 3, 3));
    //tech process - 2
    processPeriodObjects.add(new ProcessPeriodObject(2, 23, 5, 3, 4));

    //tech process - 3, zone - step
    processPeriodObjects.add(new ProcessPeriodObject(3, 13, 13, 4, 5));
    //tech process - 3, zone - lisostep
    processPeriodObjects.add(new ProcessPeriodObject(4, 20, 20, 4, 5));
    //tech process - 3, zone - polisya
    processPeriodObjects.add(new ProcessPeriodObject(5, 23, 13, 4, 5));

    //tech process - 4a, zone - step
    processPeriodObjects.add(new ProcessPeriodObject(6, 15, 15, 4, 5));
    //tech process - 4a, zone - lisostep
    processPeriodObjects.add(new ProcessPeriodObject(7, 20, 20, 4, 5));
    //tech process - 4a, zone - polisya
    processPeriodObjects.add(new ProcessPeriodObject(8, 25, 15, 4, 5));

    //tech process - 4aa same as 4a

    //tech process - 4b, zone - step
    processPeriodObjects.add(new ProcessPeriodObject(9, 15, 15, 4, 5));
    //tech process - 4b, zone - lisostep
    processPeriodObjects.add(new ProcessPeriodObject(10, 20, 20, 4, 5));
    //tech process - 4b, zone - polisya
    processPeriodObjects.add(new ProcessPeriodObject(11, 25, 15, 4, 5));

    //tech process - 5a, zone - step
    processPeriodObjects.add(new ProcessPeriodObject(12, 21, 21, 4, 5));
    //tech process - 5a, zone - lisostep
    processPeriodObjects.add(new ProcessPeriodObject(13, 26, 26, 4, 5));
    //tech process - 5a, zone - polisya
    processPeriodObjects.add(new ProcessPeriodObject(14, 1, 21, 5, 5));

    //tech process - 6
    processPeriodObjects.add(new ProcessPeriodObject(15, 25, 15, 5, 6));

    //tech process - 7a voobsche hz

    //tech process - 7b
    processPeriodObjects.add(new ProcessPeriodObject(16, 1, 20, 6, 6));

    //tech process - 8 voobsche hz

    //tech process - 9a 9a2 9b hz

    //tech process - 10
    processPeriodObjects.add(new ProcessPeriodObject(17, 1, 1, 7, 8));

    //tech process - 11 hz

    //tech process - 12 hz
    for (int i = 0; i < processPeriodObjects.size(); i++) {
      mDataManager.putProcessPeriod(
          new ProcessPeriodObjectToProcessPeriodEntity().transform(processPeriodObjects.get(i)));
    }

    Timber.e(String.valueOf(mDataManager.getAllProcessPeriodEntitiesAsList().size()));

    // WeedNutritionTypes
    ArrayList<WeedNutritionTypeObject> weedNutritionTypeObjects = new ArrayList<>();
    weedNutritionTypeObjects.add(new WeedNutritionTypeObject(1, "Непаразити"));
    weedNutritionTypeObjects.add(new WeedNutritionTypeObject(2, "Напівпаразити"));
    weedNutritionTypeObjects.add(new WeedNutritionTypeObject(3, "Паразити"));
  }
}
