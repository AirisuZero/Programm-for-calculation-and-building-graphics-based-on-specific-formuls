package ru.artur.controller;

import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import ru.artur.view.GraphSkin;

/**
 * Created by Aleksandr on 23.12.17.
 */
public class GraphController extends Control {

    @Override
    protected Skin<?> createDefaultSkin() {
        return new GraphSkin(this);
    }

    public ObservableList<XYChart.Data> getXyChartList1() {
        return ViewController.getInstance().getXyChartList1();
    }
    public ObservableList<XYChart.Data> getXyChartList2() {
        return ViewController.getInstance().getXyChartList2();
    }
    public StringProperty xAxisLabelProperty() {
        return ViewController.getInstance().xAxisLabelProperty();
    }

}
