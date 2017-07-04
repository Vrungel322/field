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
import com.apps.twelve.floor.field.data.local.objects.conditions.WeedClassObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.WeedGroupObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.WeedNutritionTypeObject;
import com.apps.twelve.floor.field.data.local.objects.conditions.WeedObject;
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
    for (int i = 0; i < weedNutritionTypeObjects.size(); i++) {
      mDataManager.putWeedNutritionType(weedNutritionTypeObjects.get(i));
    }

    // WeedClasses
    ArrayList<WeedClassObject> weedClassObjects = new ArrayList<>();
    weedClassObjects.add(new WeedClassObject(1, "Дводольні", 0, true));
    weedClassObjects.add(new WeedClassObject(2, "Губоцвіті ", 1, false));
    weedClassObjects.add(new WeedClassObject(3, "Капустяні", 1, false));
    weedClassObjects.add(new WeedClassObject(4, "Фіалкові", 1, false));
    weedClassObjects.add(new WeedClassObject(5, "Макові", 1, false));
    weedClassObjects.add(new WeedClassObject(6, "Геранієві", 1, false));
    weedClassObjects.add(new WeedClassObject(7, "Айстрові", 1, false));
    weedClassObjects.add(new WeedClassObject(8, "Бурачникові", 1, false));
    weedClassObjects.add(new WeedClassObject(9, "Жовтецеві", 1, false));
    weedClassObjects.add(new WeedClassObject(10, "Гвоздикові", 1, false));
    weedClassObjects.add(new WeedClassObject(11, "Лободові", 1, false));
    weedClassObjects.add(new WeedClassObject(12, "Мальвові", 1, false));
    weedClassObjects.add(new WeedClassObject(13, "Бобові", 1, false));
    weedClassObjects.add(new WeedClassObject(14, "Зонтичні", 1, false));
    weedClassObjects.add(new WeedClassObject(15, "Паролистові", 1, false));
    weedClassObjects.add(new WeedClassObject(16, "Маренові", 1, false));
    weedClassObjects.add(new WeedClassObject(17, "Гречкові", 1, false));
    weedClassObjects.add(new WeedClassObject(18, "Резедові", 1, false));
    weedClassObjects.add(new WeedClassObject(19, "Амарантові", 1, false));
    weedClassObjects.add(new WeedClassObject(20, "Складноцвіті", 1, false));
    weedClassObjects.add(new WeedClassObject(21, "Пасльонові", 1, false));
    weedClassObjects.add(new WeedClassObject(22, "Первоцвітові", 1, false));
    weedClassObjects.add(new WeedClassObject(23, "Кропивні", 1, false));
    weedClassObjects.add(new WeedClassObject(24, "Конопляні", 1, false));
    weedClassObjects.add(new WeedClassObject(25, "Камелінові", 1, false));
    weedClassObjects.add(new WeedClassObject(26, "Портулакові", 1, false));
    weedClassObjects.add(new WeedClassObject(27, "Щирицеві", 1, false));
    weedClassObjects.add(new WeedClassObject(28, "Барвінкові", 1, false));
    weedClassObjects.add(new WeedClassObject(29, "Квасеницюваті", 1, false));
    weedClassObjects.add(new WeedClassObject(30, "Хвилівникові", 1, false));
    weedClassObjects.add(new WeedClassObject(31, "Онагрові", 1, false));
    weedClassObjects.add(new WeedClassObject(32, "Молочайні", 1, false));
    weedClassObjects.add(new WeedClassObject(33, "Ранникові", 1, false));
    weedClassObjects.add(new WeedClassObject(34, "Березкові", 1, false));
    weedClassObjects.add(new WeedClassObject(35, "Подорожникові", 1, false));
    weedClassObjects.add(new WeedClassObject(36, "Розові", 1, false));
    weedClassObjects.add(new WeedClassObject(37, "Лілійні", 1, false));
    weedClassObjects.add(new WeedClassObject(38, "Шорстколисті", 1, false));
    weedClassObjects.add(new WeedClassObject(39, "Однодольні", 0, true));
    weedClassObjects.add(new WeedClassObject(40, "Злакові (тонконогові)", 39, false));
    weedClassObjects.add(new WeedClassObject(41, "Хвощовидні (спорові)", 0, true));
    for (int i = 0; i < weedClassObjects.size(); i++) {
      mDataManager.putWeedClass(weedClassObjects.get(i));
    }

    // WeedGroups
    ArrayList<WeedGroupObject> weedGroupObjects = new ArrayList<>();
    weedGroupObjects.add(new WeedGroupObject(1, "Малорічні", 0, true));
    weedGroupObjects.add(new WeedGroupObject(2, "Ярі", 1, true));
    weedGroupObjects.add(new WeedGroupObject(3, "Ефемери", 2, false));
    weedGroupObjects.add(new WeedGroupObject(4, "Ранні", 2, false));
    weedGroupObjects.add(new WeedGroupObject(5, "Пізні", 2, false));
    weedGroupObjects.add(new WeedGroupObject(6, "Озимі", 1, false));
    weedGroupObjects.add(new WeedGroupObject(7, "Зимуючі", 1, false));
    weedGroupObjects.add(new WeedGroupObject(8, "Дворічні", 1, false));
    weedGroupObjects.add(new WeedGroupObject(9, "Багаторічні", 0, true));
    weedGroupObjects.add(new WeedGroupObject(10, "Кореневищні", 9, false));
    weedGroupObjects.add(new WeedGroupObject(11, "Коренепаросткові", 9, false));
    weedGroupObjects.add(new WeedGroupObject(12, "Коренемичкуваті", 9, false));
    weedGroupObjects.add(new WeedGroupObject(13, "Стрижнекореневі", 9, false));
    weedGroupObjects.add(new WeedGroupObject(14, "Повзучі", 9, false));
    weedGroupObjects.add(new WeedGroupObject(15, "Бульбові", 9, false));
    weedGroupObjects.add(new WeedGroupObject(16, "Цибулинні", 9, false));
    for (int i = 0; i < weedGroupObjects.size(); i++) {
      mDataManager.putWeedGroup(weedGroupObjects.get(i));
    }

    //Weed harmful_type_id for all weeds = 1 !!!!!
    ArrayList<WeedObject> weedObjects = new ArrayList<>();
    weedObjects.add(new WeedObject(1,1,"Зірочник середній, або мокрець",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(9).getId(),weedGroupObjects.get(2).getId()));
    weedObjects.add(new WeedObject(2,1,"Гостриця лежача",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(37).getId(),weedGroupObjects.get(2).getId()));
    weedObjects.add(new WeedObject(3,1,"Червець однорічний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(9).getId(),weedGroupObjects.get(3).getId()));
    weedObjects.add(new WeedObject(4,1,"Кукіль звичайний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(9).getId(),weedGroupObjects.get(3).getId()));
    weedObjects.add(new WeedObject(5,1,"Наземка польова",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(10).getId(),weedGroupObjects.get(3).getId()));
    weedObjects.add(new WeedObject(6,1,"Лобода біла",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(10).getId(),weedGroupObjects.get(3).getId()));
    weedObjects.add(new WeedObject(7,1,"Редька дика",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(2).getId(),weedGroupObjects.get(3).getId()));
    weedObjects.add(new WeedObject(8,1,"Гірчиця польова",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(2).getId(),weedGroupObjects.get(3).getId()));
    weedObjects.add(new WeedObject(9,1,"Гібіск трійчастий",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(11).getId(),weedGroupObjects.get(3).getId()));
    weedObjects.add(new WeedObject(10,1,"Горошок волохатий",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(12).getId(),weedGroupObjects.get(3).getId()));
    weedObjects.add(new WeedObject(11,1,"Біфора промениста",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(13).getId(),weedGroupObjects.get(3).getId()));
    weedObjects.add(new WeedObject(12,1,"Якірці сланкі",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(14).getId(),weedGroupObjects.get(3).getId()));
    weedObjects.add(new WeedObject(13,1,"Рутка лікарська",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(4).getId(),weedGroupObjects.get(3).getId()));
    weedObjects.add(new WeedObject(14,1,"Підмаренник чіпкий",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(15).getId(),weedGroupObjects.get(3).getId()));
    weedObjects.add(new WeedObject(15,1,"Гречка татарська",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(15).getId(),weedGroupObjects.get(3).getId()));
    weedObjects.add(new WeedObject(16,1,"Гірчак березковидний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(15).getId(),weedGroupObjects.get(3).getId()));


    weedObjects.add(new WeedObject(17,1,"Резеда жовта",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(17).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(18,1,"Щириця жминдовидна",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(26).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(19,1,"Щириця біла",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(26).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(20,1,"Череда трироздільна",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(6).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(21,1,"Паслін чорний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(20).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(22,1,"Дурман звичайний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(20).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(23,1,"Очка курячі польові",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(21).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(24,1,"Остудник голий",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(9).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(25,1,"Шпергель звичайний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(9).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(26,1,"Кропива жалка",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(22).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(27,1,"Коноплі дикі",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(23).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(28,1,"Комеліна звичайна",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(24).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(29,1,"Комеліна звичайна",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(2).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(30,1,"Залізниця гірська",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(1).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(31,1,"Жабрій ладанний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(1).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(32,1,"Жабрій звичайний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(1).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(33,1,"Геліотроп європейський",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(37).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(34,1,"Портулак городній",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(25).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(35,1,"Курай руський",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(10).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(36,1,"Щириця звичайна",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(26).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(37,1,"Спориш звичайний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(16).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(38,1,"Гірчак шорсткий",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(16).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(39,1,"Осот жовтий городній",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(6).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(40,1,"Чорнощир звичайний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(6).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(41,1,"Соняшник смітний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(6).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(42,1,"Нетреба звичайна",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(6).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(43,1,"Галінсога дрібноквіткова, або незбутниця",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(6).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(44,1,"Амброзія трироздільна",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(6).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(45,1,"Амброзія полинолиста",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(6).getId(),weedGroupObjects.get(4).getId()));

    weedObjects.add(new WeedObject(46,1,"Хрінниця смердюча",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(2).getId(),weedGroupObjects.get(6).getId()));
    weedObjects.add(new WeedObject(47,1,"Хориспора ніжна",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(2).getId(),weedGroupObjects.get(6).getId()));
    weedObjects.add(new WeedObject(48,1,"Сухоребрик льозеліїв",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(2).getId(),weedGroupObjects.get(6).getId()));
    weedObjects.add(new WeedObject(49,1,"Талабан польовий",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(2).getId(),weedGroupObjects.get(6).getId()));
    weedObjects.add(new WeedObject(50,1,"Кучерявець Софії",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(2).getId(),weedGroupObjects.get(6).getId()));
    weedObjects.add(new WeedObject(51,1,"Грицики звичайні",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(2).getId(),weedGroupObjects.get(6).getId()));
    weedObjects.add(new WeedObject(52,1,"Латук дикий, компасний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(6).getId(),weedGroupObjects.get(6).getId()));
    weedObjects.add(new WeedObject(53,1,"Злинка канадська",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(6).getId(),weedGroupObjects.get(6).getId()));
    weedObjects.add(new WeedObject(54,1,"Триреберник непахучий, ромашка непахуча",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(6).getId(),weedGroupObjects.get(6).getId()));
    weedObjects.add(new WeedObject(55,1,"Жовтозілля весняне",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(6).getId(),weedGroupObjects.get(6).getId()));
    weedObjects.add(new WeedObject(56,1,"Волошка синя",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(6).getId(),weedGroupObjects.get(6).getId()));
    weedObjects.add(new WeedObject(57,1,"Фіалка триколірна",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(3).getId(),weedGroupObjects.get(6).getId()));
    weedObjects.add(new WeedObject(58,1,"Фіалка польова",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(3).getId(),weedGroupObjects.get(6).getId()));
    weedObjects.add(new WeedObject(59,1,"Чистець однорічний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(1).getId(),weedGroupObjects.get(6).getId()));
    weedObjects.add(new WeedObject(60,1,"Глуха кропива стеблеобгортаюча",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(1).getId(),weedGroupObjects.get(6).getId()));
    weedObjects.add(new WeedObject(61,1,"Мак дикий",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(4).getId(),weedGroupObjects.get(6).getId()));
    weedObjects.add(new WeedObject(62,1,"Грабельки звичайні",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(5).getId(),weedGroupObjects.get(6).getId()));
    weedObjects.add(new WeedObject(63,1,"Кривоцвіт польовий",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(37).getId(),weedGroupObjects.get(6).getId()));
    weedObjects.add(new WeedObject(64,1,"Сокирки польові",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(8).getId(),weedGroupObjects.get(6).getId()));

    weedObjects.add(new WeedObject(65,1,"Чорнокорінь лікарський",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(37).getId(),weedGroupObjects.get(7).getId()));
    weedObjects.add(new WeedObject(66,1,"Липучка їжакова",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(37).getId(),weedGroupObjects.get(7).getId()));
    weedObjects.add(new WeedObject(67,1,"Татарник звичайний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(6).getId(),weedGroupObjects.get(7).getId()));
    weedObjects.add(new WeedObject(68,1,"Будяк акантовидний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(6).getId(),weedGroupObjects.get(7).getId()));
    weedObjects.add(new WeedObject(69,1,"Скереда покрівельна",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(6).getId(),weedGroupObjects.get(7).getId()));
    weedObjects.add(new WeedObject(70,1,"Суріпиця звичайна",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(2).getId(),weedGroupObjects.get(7).getId()));
    weedObjects.add(new WeedObject(71,1,"Свербига східна",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(2).getId(),weedGroupObjects.get(7).getId()));
    weedObjects.add(new WeedObject(72,1,"Гикавка сіра",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(2).getId(),weedGroupObjects.get(7).getId()));
    weedObjects.add(new WeedObject(73,1,"Петрушка собача звичайна",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(13).getId(),weedGroupObjects.get(7).getId()));
    weedObjects.add(new WeedObject(74,1,"Морква дика",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(13).getId(),weedGroupObjects.get(7).getId()));
    weedObjects.add(new WeedObject(75,1,"Болиголов плямистий",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(13).getId(),weedGroupObjects.get(7).getId()));
    weedObjects.add(new WeedObject(76,1,"Куколиця біла",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(9).getId(),weedGroupObjects.get(7).getId()));
    weedObjects.add(new WeedObject(77,1,"Кропива глуха пурпурова",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(1).getId(),weedGroupObjects.get(7).getId()));
    weedObjects.add(new WeedObject(78,1,"Енотера дворічна",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(30).getId(),weedGroupObjects.get(7).getId()));
    weedObjects.add(new WeedObject(79,1,"Вероніка плющолиста",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(32).getId(),weedGroupObjects.get(7).getId()));
    weedObjects.add(new WeedObject(80,1,"Блекота чорна",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(20).getId(),weedGroupObjects.get(7).getId()));
    weedObjects.add(new WeedObject(81,1,"Синяк звичайний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(37).getId(),weedGroupObjects.get(7).getId()));
    weedObjects.add(new WeedObject(82,1,"Буркун лікарський",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(12).getId(),weedGroupObjects.get(7).getId()));

    weedObjects.add(new WeedObject(83,1,"Тонконіг однорічний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(39).getId(),weedGroupObjects.get(2).getId()));
    weedObjects.add(new WeedObject(84,1,"Тонконіг однорічний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(39).getId(),weedGroupObjects.get(3).getId()));
    weedObjects.add(new WeedObject(85,1,"Пажитниця льонова",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(39).getId(),weedGroupObjects.get(3).getId()));
    weedObjects.add(new WeedObject(86,1,"Вівсюг звичайний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(39).getId(),weedGroupObjects.get(3).getId()));

    weedObjects.add(new WeedObject(87,1,"Просо волосовидне",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(39).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(88,1,"Пальчатка кровоспиняюча",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(39).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(89,1,"Ценхрус якірцевий",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(39).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(90,1,"Плоскуха звичайна",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(39).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(91,1,"Мишій зелений",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(39).getId(),weedGroupObjects.get(4).getId()));
    weedObjects.add(new WeedObject(92,1,"Мишій сизий",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(39).getId(),weedGroupObjects.get(4).getId()));

    weedObjects.add(new WeedObject(93,1,"Метлюг звичайний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(39).getId(),weedGroupObjects.get(5).getId()));
    weedObjects.add(new WeedObject(94,1,"Бромус житній, або стоколос",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(39).getId(),weedGroupObjects.get(5).getId()));

    weedObjects.add(new WeedObject(95,1,"Чистець болотний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(1).getId(),weedGroupObjects.get(9).getId()));
    weedObjects.add(new WeedObject(96,1,"Ластовень гострий",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(27).getId(),weedGroupObjects.get(9).getId()));
    weedObjects.add(new WeedObject(97,1,"Кропива дводомна",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(22).getId(),weedGroupObjects.get(9).getId()));
    weedObjects.add(new WeedObject(98,1,"Квасениця прямостояча",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(28).getId(),weedGroupObjects.get(9).getId()));
    weedObjects.add(new WeedObject(99,1,"Деревій звичайний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(6).getId(),weedGroupObjects.get(9).getId()));

    weedObjects.add(new WeedObject(100,1,"Хрінниця крупковидна",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(2).getId(),weedGroupObjects.get(10).getId()));
    weedObjects.add(new WeedObject(101,1,"Хвилівник звичайний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(29).getId(),weedGroupObjects.get(10).getId()));
    weedObjects.add(new WeedObject(102,1,"Хаменерій вузьколистий",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(30).getId(),weedGroupObjects.get(10).getId()));
    weedObjects.add(new WeedObject(103,1,"Молочай лозяний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(31).getId(),weedGroupObjects.get(10).getId()));
    weedObjects.add(new WeedObject(104,1,"Льонок звичайний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(32).getId(),weedGroupObjects.get(10).getId()));
    weedObjects.add(new WeedObject(105,1,"Щавель горобиний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(16).getId(),weedGroupObjects.get(10).getId()));
    weedObjects.add(new WeedObject(106,1,"Осот рожевий польовий",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(6).getId(),weedGroupObjects.get(10).getId()));
    weedObjects.add(new WeedObject(107,1,"Осот жовтий польовий",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(6).getId(),weedGroupObjects.get(10).getId()));
    weedObjects.add(new WeedObject(108,1,"Гірчак степовий звичайний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(6).getId(),weedGroupObjects.get(10).getId()));
    weedObjects.add(new WeedObject(109,1,"Березка польова",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(33).getId(),weedGroupObjects.get(10).getId()));

    weedObjects.add(new WeedObject(110,1,"Подорожник великий",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(34).getId(),weedGroupObjects.get(11).getId()));

    weedObjects.add(new WeedObject(111,1,"Щавель кінський",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(16).getId(),weedGroupObjects.get(12).getId()));
    weedObjects.add(new WeedObject(112,1,"Чистотіл звичайний",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(4).getId(),weedGroupObjects.get(12).getId()));
    weedObjects.add(new WeedObject(113,1,"Миколайчики польові",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(13).getId(),weedGroupObjects.get(12).getId()));
    weedObjects.add(new WeedObject(114,1,"Гравілат міський",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(35).getId(),weedGroupObjects.get(12).getId()));
    weedObjects.add(new WeedObject(115,1,"Подорожник ланцетолистий",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(34).getId(),weedGroupObjects.get(12).getId()));
    weedObjects.add(new WeedObject(116,1,"Полин звичайний та полин гіркий",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(6).getId(),weedGroupObjects.get(12).getId()));
    weedObjects.add(new WeedObject(117,1,"Хондрила ситниковидна",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(6).getId(),weedGroupObjects.get(12).getId()));
    weedObjects.add(new WeedObject(118,1,"Кульбаба лікарська",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(6).getId(),weedGroupObjects.get(12).getId()));

    weedObjects.add(new WeedObject(119,1,"Перстач гусячий",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(35).getId(),weedGroupObjects.get(13).getId()));
    weedObjects.add(new WeedObject(120,1,"Жовтець повзучий",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(8).getId(),weedGroupObjects.get(13).getId()));

    weedObjects.add(new WeedObject(121,1,"Чина бульбиста",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(12).getId(),weedGroupObjects.get(14).getId()));

    weedObjects.add(new WeedObject(122,1,"Цибуля Вальдштейна",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(36).getId(),weedGroupObjects.get(15).getId()));

    weedObjects.add(new WeedObject(123,1,"Свинорий пальчастий",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(39).getId(),weedGroupObjects.get(9).getId()));
    weedObjects.add(new WeedObject(124,1,"Гумай, сорго алепське",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(39).getId(),weedGroupObjects.get(9).getId()));
    weedObjects.add(new WeedObject(125,1,"Пирій повзучий",weedNutritionTypeObjects.get(0).getId(),
        weedClassObjects.get(39).getId(),weedGroupObjects.get(9).getId()));

    for (int i = 0; i < weedObjects.size(); i++) {
      mDataManager.putWeed(weedObjects.get(i));
    }

    Timber.e(String.valueOf(mDataManager.getAllWeedEntitiesAsList().size()));
  }
}
