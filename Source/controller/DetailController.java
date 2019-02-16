package ru.artur.controller;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import ru.artur.model.SourceData;
import ru.artur.view.DetailSkin;

import java.text.NumberFormat;

/**
 * Created by Aleksandr on 23.12.17.
 */
public class DetailController extends Control {

    @Override
    protected Skin<?> createDefaultSkin() {
        return new DetailSkin(this);
    }

    public SourceData getBasic() {
        return ViewController.getInstance().getBasic();
    }

    public ObservableList<SourceData> getObservableList() {
        return ViewController.getInstance().getObservableList();
    }

    public SortedList<SourceData> getSortedList() {
        return ViewController.getInstance().getSortedList();
    }

    public SourceData getSelected() {
        return ViewController.getInstance().getSelected();
    }
    public ObjectProperty<SourceData> selectedProperty() {
        return ViewController.getInstance().selectedProperty();
    }
    public void setSelected(SourceData selected) {
        ViewController.getInstance().setSelected(selected);
    }

    public StringProperty footer = new SimpleStringProperty("Для начала работы проверьте исходные данные и выполните требуемое вычисление");
    public String getFooter() {
        return footer.get();
    }
    public StringProperty footerProperty() {
        return footer;
    }
    public void setFooter(String footer) {
        this.footer.set(footer);
    }

    public void eventHandler(String event) {
        if (event == null) return;
        switch (event) {
            case "EDIT":
                edit();
                break;
            case "CALCULATE_1":
                clearAll();
                calculate1();
                break;
            case "CALCULATE_2":
                clearAll();
                calculate2();
                break;
            case "CALCULATE_3":
                clearAll();
                calculate3();
                break;
            case "CLEAR_ALL":
                clearAll();
                break;
        }
    }

    private void edit() {
        AppController.getInstance().setActiveController("EDIT_CONTROLLER");
    }

    private void calculate1() {
        ViewController.getInstance().calculate1();

        final NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setGroupingUsed(true);
        numberFormat.setMinimumFractionDigits(5);

        final NumberFormat integerFormat = NumberFormat.getIntegerInstance();
        integerFormat.setGroupingUsed(true);

        setFooter( "Вычисление 1. Количество строк: " + integerFormat.format(getObservableList().size()) + ". " +
                "Границы диапазона (T, сек): " + numberFormat.format(getBasic().getParam1()) +
                " - " + numberFormat.format(getBasic().getParam1_future()) +
                ", шаг вычислений: " + numberFormat.format(getBasic().getParam1_step()) );
    }

    private void calculate2() {
        ViewController.getInstance().calculate2();

        final NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setGroupingUsed(true);
        numberFormat.setMinimumFractionDigits(5);

        final NumberFormat integerFormat = NumberFormat.getIntegerInstance();
        integerFormat.setGroupingUsed(true);

        setFooter( "Вычисление 2. Количество строк: " + integerFormat.format(getObservableList().size()) + ". " +
                "Границы диапазона (θ, сек): " + numberFormat.format(getBasic().getParam2()) +
                " - " + numberFormat.format(getBasic().getParam2_future()) +
                ", шаг вычислений: " + numberFormat.format(getBasic().getParam2_step()) );
    }

    private void calculate3() {
        ViewController.getInstance().calculate3();

        final NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setGroupingUsed(true);
        numberFormat.setMinimumFractionDigits(5);

        final NumberFormat integerFormat = NumberFormat.getIntegerInstance();
        integerFormat.setGroupingUsed(true);

        setFooter( "Вычисление 3. Количество строк: " + integerFormat.format(getObservableList().size()) + ". " +
                "Границы диапазона (p): " + numberFormat.format(getBasic().getParam8()) +
                " - " + numberFormat.format(getBasic().getParam8_future()) +
                ", шаг вычислений: " + numberFormat.format(getBasic().getParam8_step()) );
    }

    private void clearAll() {
        ViewController.getInstance().clearAll();

        setFooter("Для начала работы проверьте исходные данные и выполните требуемое вычисление.");
    }
}
