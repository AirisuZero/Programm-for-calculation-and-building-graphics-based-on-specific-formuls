package ru.artur.view;

import com.sun.javafx.css.StyleManager;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.SkinBase;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import ru.artur.controller.GraphController;

/**
 * Created by Aleksandr on 23.12.17.
 */
public class GraphSkin extends SkinBase<GraphController> {

    static {
        StyleManager.getInstance().addUserAgentStylesheet(
                GraphController.class.getResource("/style_default.css").toExternalForm());
    }

    public GraphSkin(GraphController control) {
        super(control);

        // ========================================================================================================== //
        // ГРАФИК
        // ========================================================================================================== //

        final CategoryAxis xAxis2 = new CategoryAxis();
        xAxis2.labelProperty().bindBidirectional(getSkinnable().xAxisLabelProperty());

        final NumberAxis yAxis2 = new NumberAxis();
        yAxis2.setVisible(false);

        XYChart.Series XYSeries1 = new XYChart.Series(getSkinnable().getXyChartList1());
        XYSeries1.setName("a*b st,m max");

        XYChart.Series XYSeries2 = new XYChart.Series(getSkinnable().getXyChartList2());
        XYSeries2.setName("R");

        final LineChart<String,Number> lineChart2 = new LineChart<>(xAxis2,yAxis2);
        lineChart2.setTitle("График зависимости R от a*b st,m max при изменении исходных параметров");
        lineChart2.setPrefWidth(250);
        lineChart2.getData().addAll(
                XYSeries1,
                XYSeries2
        );

        // ========================================================================================================== //
        // ПАНЕЛЬ СЦЕНЫ
        // ========================================================================================================== //

        final BorderPane panes = new BorderPane(lineChart2,
                null,
                null,
                null,
                null);

        final TitledPane titledPane = new TitledPane(
                "График зависимости R от a*b st,m max при изменении исходных параметров",
                panes
        );

        titledPane.setCollapsible(false);
        titledPane.getStyleClass().add("custom-titled-pane");

        final AnchorPane detailPane = new AnchorPane(titledPane);
        detailPane.setTopAnchor(titledPane, 0.0);
        detailPane.setRightAnchor(titledPane, 0.0);
        detailPane.setBottomAnchor(titledPane, 0.0);
        detailPane.setLeftAnchor(titledPane, 0.0);

        getChildren().add(detailPane);

        getNode().setFocusTraversable(false);
    }
}
