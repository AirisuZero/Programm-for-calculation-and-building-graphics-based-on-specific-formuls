package ru.artur.controller;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import ru.artur.model.SourceData;
import ru.artur.view.ViewSkin;

import java.text.NumberFormat;


/**
 * Created by Aleksandr on 22.12.17.
 */
public class ViewController extends Control {

    private static ViewController ourInstance = new ViewController();
    public static ViewController getInstance() {
        ViewController localInstance = ourInstance;
        if (localInstance == null) {
            synchronized (ViewController.class) {
                localInstance = ourInstance;
                if (localInstance == null) {
                    ourInstance = localInstance = new ViewController();
                }
            }
        }
        return localInstance;
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new ViewSkin(this);
    }

    private final SourceData basic = new  SourceData(5, 0.001, 12.5941);
    public SourceData getBasic() {
        return basic;
    }

    public ViewController() {
        basic.setParam1(1); // диапазон от 1 до 0,1
        basic.setParam1_future(0.1);
        basic.setParam1_step(0.1);
        basic.setParam2(0.3); // диапазон от 0.3 до 0,001
        basic.setParam2_future(0.001);
        basic.setParam2_step(0.001);
        basic.setParam3(64000);
        basic.setParam4(0);
        basic.setParam5(160);
        basic.setParam6(48);
        basic.setParam7(320);
        basic.setParam8(0.01); // диапазон от 10^-2 до 10^-5
        basic.setParam8_future(0.00001);
        basic.setParam8_step(0.00001);
        basic.setParam9(512000);
        basic.setParam10(32000);
        basic.setParam11(0.497);

        visibleProperty().bind(new BooleanBinding() {
            {
                bind(AppController.getInstance().activeControllerProperty());
            }

            @Override
            protected boolean computeValue() {
                return (AppController.getInstance().getActiveController() == "VIEW_CONTROLLER" ? true : false);
            }
        });
    }

    private ObservableList<SourceData> observableList = FXCollections.observableArrayList();
    public ObservableList<SourceData> getObservableList() {
        return observableList;
    }

    private final SortedList<SourceData> sortedList = new SortedList<SourceData>(observableList);
    public SortedList<SourceData> getSortedList() {
        return sortedList;
    }

    private ObjectProperty<SourceData> selected = new SimpleObjectProperty<>(null);
    public SourceData getSelected() {
        return selected.get();
    }
    public ObjectProperty<SourceData> selectedProperty() {
        return selected;
    }
    public void setSelected(SourceData selected) {
        this.selected.set(selected);
    }

    private final GraphController graphController = new GraphController();
    public GraphController getGraphController() {
        return graphController;
    }

    private final DetailController detailController = new DetailController();
    public DetailController getDetailController() {
        return detailController;
    }

    private ObservableList<XYChart.Data> xyChartList1 = FXCollections.observableArrayList();
    public ObservableList<XYChart.Data> getXyChartList1() {
        return xyChartList1;
    }

    private ObservableList<XYChart.Data> xyChartList2 = FXCollections.observableArrayList();
    public ObservableList<XYChart.Data> getXyChartList2() {
        return xyChartList2;
    }

    private StringProperty xAxisLabel = new SimpleStringProperty("");
    public String getxAxisLabel() {
        return xAxisLabel.get();
    }
    public StringProperty xAxisLabelProperty() {
        return xAxisLabel;
    }
    public void setxAxisLabel(String xAxisLabel) {
        this.xAxisLabel.set(xAxisLabel);
    }

    public void calculate1() {
        for (double i = getBasic().getParam1(); i >= getBasic().getParam1_future(); i = i - getBasic().getParam1_step()) {
            final SourceData sourceData = new SourceData(getBasic().getN(), getBasic().getD(), getBasic().getZ());
            sourceData.setParam1(i);
            sourceData.setParam2(getBasic().getParam2());
            sourceData.setParam3(getBasic().getParam3());
            sourceData.setParam4(getBasic().getParam4());
            sourceData.setParam5(getBasic().getParam5());
            sourceData.setParam6(getBasic().getParam6());
            sourceData.setParam7(getBasic().getParam7());
            sourceData.setParam8(getBasic().getParam8());
            sourceData.setParam9(getBasic().getParam9());
            sourceData.setParam10(getBasic().getParam10());
            sourceData.setParam11(getBasic().getParam11());

            try {
                sourceData.calculate();
            } catch (Exception e) {
                // TODO: добавить messagebox с текстом ошибки
            } finally {
                getObservableList().add(sourceData);
            }
        }

        final NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setGroupingUsed(true);
        numberFormat.setMinimumFractionDigits(5);

        if (xyChartList1.size() != 0) xyChartList1.clear();
        if (xyChartList2.size() != 0) xyChartList2.clear();

        int counter = 0;
        int number = 0;
        if (observableList.size() > 15) counter = Math.round(observableList.size() / 15);

        for (int i = 0; i < observableList.size(); i++) {
            if (i == number || counter == 0) {
                //xyChartList1.add(new XYChart.Data(numberFormat.format(observableList.get(i).getParam1()), observableList.get(i).getResult4()));
                //xyChartList2.add(new XYChart.Data(numberFormat.format(observableList.get(i).getParam1()), observableList.get(i).getResult13()));
                xyChartList2.add(new XYChart.Data(numberFormat.format(observableList.get(i).getResult4()), observableList.get(i).getResult13()));
                number += counter;
            }
        }

        //setxAxisLabel("Значения входных параметров (T, сек.)");
       // setxAxisLabel("Значения входных параметров (T, сек.)");
    }

    public void calculate2() {
        for (double j = getBasic().getParam2(); j >= getBasic().getParam2_future(); j = j - getBasic().getParam2_step()) {
            final SourceData sourceData = new SourceData(getBasic().getN(), getBasic().getD(), getBasic().getZ());
            sourceData.setParam1(getBasic().getParam1());
            sourceData.setParam2(j);
            sourceData.setParam3(getBasic().getParam3());
            sourceData.setParam4(getBasic().getParam4());
            sourceData.setParam5(getBasic().getParam5());
            sourceData.setParam6(getBasic().getParam6());
            sourceData.setParam7(getBasic().getParam7());
            sourceData.setParam8(getBasic().getParam8());
            sourceData.setParam9(getBasic().getParam9());
            sourceData.setParam10(getBasic().getParam10());
            sourceData.setParam11(getBasic().getParam11());

            try {
                sourceData.calculate();
            } catch (Exception e) {
                // TODO: добавить messagebox с текстом ошибки
            } finally {
                getObservableList().add(sourceData);
            }
        }

        final NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setGroupingUsed(true);
        numberFormat.setMinimumFractionDigits(5);

        if (xyChartList1.size() != 0) xyChartList1.clear();
        if (xyChartList2.size() != 0) xyChartList2.clear();

        int counter = 0;
        int number = 0;
        if (observableList.size() > 15) counter = Math.round(observableList.size() / 15);

        for (int i = 0; i < observableList.size(); i++) {
            if (i == number || counter == 0) {
               // xyChartList1.add(new XYChart.Data(numberFormat.format(observableList.get(i).getParam2()), observableList.get(i).getResult4()));
               // xyChartList2.add(new XYChart.Data(numberFormat.format(observableList.get(i).getParam2()), observableList.get(i).getResult13()));
                xyChartList2.add(new XYChart.Data(numberFormat.format(observableList.get(i).getResult13()), observableList.get(i).getResult4()));
                number += counter;
            }
        }

        setxAxisLabel("Значения входных параметров (θ, сек.)");
    }

    public void calculate3() {
        for (double k = getBasic().getParam8(); k >= getBasic().getParam8_future(); k = k - getBasic().getParam8_step()) {
            final SourceData sourceData = new SourceData(getBasic().getN(), getBasic().getD(), getBasic().getZ());
            sourceData.setParam1(getBasic().getParam1());
            sourceData.setParam2(getBasic().getParam2());
            sourceData.setParam3(getBasic().getParam3());
            sourceData.setParam4(getBasic().getParam4());
            sourceData.setParam5(getBasic().getParam5());
            sourceData.setParam6(getBasic().getParam6());
            sourceData.setParam7(getBasic().getParam7());
            sourceData.setParam8(k);
            sourceData.setParam9(getBasic().getParam9());
            sourceData.setParam10(getBasic().getParam10());
            sourceData.setParam11(getBasic().getParam11());

            try {
                sourceData.calculate();
            } catch (Exception e) {
                // TODO: добавить messagebox с текстом ошибки
            } finally {
                getObservableList().add(sourceData);
            }
        }

        final NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setGroupingUsed(true);
        numberFormat.setMinimumFractionDigits(5);

        if (xyChartList1.size() != 0) xyChartList1.clear();
        if (xyChartList2.size() != 0) xyChartList2.clear();

        int counter = 0;
        int number = 0;
        if (observableList.size() > 15) counter = Math.round(observableList.size() / 15);

        for (int i = 0; i < observableList.size(); i++) {
            if (i == number || counter == 0) {
               // xyChartList1.add(new XYChart.Data(numberFormat.format(observableList.get(i).getParam8()), observableList.get(i).getResult4()));
               // xyChartList2.add(new XYChart.Data(numberFormat.format(observableList.get(i).getParam8()), observableList.get(i).getResult13()));
                xyChartList2.add(new XYChart.Data(numberFormat.format(observableList.get(i).getResult13()), observableList.get(i).getResult4()));
                number += counter;
            }
        }

        setxAxisLabel("Значения входных параметров (p)");
    }

    public void clearAll() {
        if (getObservableList().size() != 0)
            getObservableList().clear();

        clearGraph();
    }

    private void clearGraph() {
        if (xyChartList1.size() != 0) xyChartList1.clear();
        if (xyChartList2.size() != 0) xyChartList2.clear();

        setxAxisLabel("");
    }
}
