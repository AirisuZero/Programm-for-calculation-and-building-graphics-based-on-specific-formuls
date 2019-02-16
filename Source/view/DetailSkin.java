package ru.artur.view;

import com.sun.javafx.css.StyleManager;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ru.artur.controller.DetailController;
import ru.artur.model.SourceData;

import java.text.NumberFormat;

/**
 * Created by Aleksandr on 23.12.17.
 */
public class DetailSkin extends SkinBase<DetailController> {

    static {
        StyleManager.getInstance().addUserAgentStylesheet(
                DetailController.class.getResource("/style_default.css").toExternalForm());
    }

    public DetailSkin(DetailController control) {
        super(control);

        // ========================================================================================================== //
        // ФОРМАТИРОВАНИЕ ДАННЫХ ДЛЯ ОТОБРАЖЕНИЯ
        // ========================================================================================================== //

        final NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setGroupingUsed(true);
        numberFormat.setMinimumFractionDigits(5);

        final NumberFormat integerFormat = NumberFormat.getIntegerInstance();
        integerFormat.setGroupingUsed(true);

        // ========================================================================================================== //
        // ОБРАБОТЧИК СОБЫТИЙ
        // ========================================================================================================== //

        final EventHandler<MouseEvent> mouseEventHandler = event -> {
            if (event.getButton() == MouseButton.PRIMARY)
                getSkinnable().eventHandler(((Button) event.getSource()).idProperty().get());
        };

        // ========================================================================================================== //
        // ПАНЕЛЬ ИНСТРУМЕНТОВ
        // ========================================================================================================== //

        final Button editButton = new Button("Исходные данные");
        editButton.setPrefWidth(150.0);
        editButton.setId("EDIT");
        editButton.setFocusTraversable(false);
        editButton.getStyleClass().add("custom-toolbar-button");

        editButton.setOnMousePressed(mouseEventHandler);

        final Button calculateButton1 = new Button("Вычисление 1 (T, сек)");
        calculateButton1.setPrefWidth(150.0);
        calculateButton1.setId("CALCULATE_1");
        calculateButton1.setFocusTraversable(false);
        calculateButton1.getStyleClass().add("custom-toolbar-button");

        calculateButton1.setOnMousePressed(mouseEventHandler);

        final Button calculateButton2 = new Button("Вычисление 2 (θ, сек)");
        calculateButton2.setPrefWidth(150.0);
        calculateButton2.setId("CALCULATE_2");
        calculateButton2.setFocusTraversable(false);
        calculateButton2.getStyleClass().add("custom-toolbar-button");

        calculateButton2.setOnMousePressed(mouseEventHandler);

        final Button calculateButton3 = new Button("Вычисление 3 (p)");
        calculateButton3.setPrefWidth(150.0);
        calculateButton3.setId("CALCULATE_3");
        calculateButton3.setFocusTraversable(false);
        calculateButton3.getStyleClass().add("custom-toolbar-button");

        calculateButton3.setOnMousePressed(mouseEventHandler);

        final Button clearAllButton = new Button("Очистить все ...");
        clearAllButton.setPrefWidth(150.0);
        clearAllButton.setId("CLEAR_ALL");
        clearAllButton.setFocusTraversable(false);
        clearAllButton.getStyleClass().add("custom-toolbar-button");

        clearAllButton.setOnMousePressed(mouseEventHandler);

        final VBox buttonsBox = new VBox(5.0,
                editButton,
                new Separator(Orientation.HORIZONTAL),
                calculateButton1,
                calculateButton2,
                calculateButton3,
                new Separator(Orientation.HORIZONTAL),
                clearAllButton
        );
        buttonsBox.setPadding(new Insets(0.0, 5.0, 0.0, 10.0));
        buttonsBox.setFocusTraversable(false);

        // ========================================================================================================== //
        // ПАНЕЛЬ ТАБЛИЦЫ
        // ========================================================================================================== //

        final TableColumn nColumn = new TableColumn("n");
        nColumn.setSortType(TableColumn.SortType.ASCENDING);
        nColumn.setSortable(true);
        nColumn.setPrefWidth(75.0);

        nColumn.setCellValueFactory(new PropertyValueFactory<>("n"));
        nColumn.setCellFactory(param -> new TableCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                setContentDisplay(ContentDisplay.TEXT_ONLY);
                if (item == null) {
                    setText(null);
                } else {
                    setText(integerFormat.format((long) item));
                }
            }
        });

        final TableColumn dColumn = new TableColumn("d");
        dColumn.setPrefWidth(75.0);

        dColumn.setCellValueFactory(new PropertyValueFactory<>("d"));
        dColumn.setCellFactory(param -> new TableCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                setContentDisplay(ContentDisplay.TEXT_ONLY);
                if (item == null) {
                    setText(null);
                } else {
                    setText(numberFormat.format((double) item));
                }
            }
        });

        final TableColumn zColumn = new TableColumn("z");
        zColumn.setPrefWidth(75.0);

        zColumn.setCellValueFactory(new PropertyValueFactory<>("z"));
        zColumn.setCellFactory(param -> new TableCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                setContentDisplay(ContentDisplay.TEXT_ONLY);
                if (item == null) {
                    setText(null);
                } else {
                    setText(numberFormat.format((double) item));
                }
            }
        });

        final TableColumn param1Column = new TableColumn("T, сек");
        param1Column.setPrefWidth(75.0);

        param1Column.setCellValueFactory(new PropertyValueFactory<>("param1"));
        param1Column.setCellFactory(param -> new TableCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                setContentDisplay(ContentDisplay.TEXT_ONLY);
                if (item == null) {
                    setText(null);
                } else {
                    setText(numberFormat.format((double) item));
                }
            }
        });

        final TableColumn param2Column = new TableColumn("θ, сек");
        param2Column.setPrefWidth(75.0);

        param2Column.setCellValueFactory(new PropertyValueFactory<>("param2"));
        param2Column.setCellFactory(param -> new TableCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                setContentDisplay(ContentDisplay.TEXT_ONLY);
                if (item == null) {
                    setText(null);
                } else {
                    setText(numberFormat.format((double) item));
                }
            }
        });

        final TableColumn param3Column = new TableColumn("ω, бит/с");
        param3Column.setPrefWidth(75.0);

        param3Column.setCellValueFactory(new PropertyValueFactory<>("param3"));
        param3Column.setCellFactory(param -> new TableCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                setContentDisplay(ContentDisplay.TEXT_ONLY);
                if (item == null) {
                    setText(null);
                } else {
                    setText(integerFormat.format((int) item));
                }
            }
        });

        final TableColumn param4Column = new TableColumn("τ, сек");
        param4Column.setPrefWidth(75.0);

        param4Column.setCellValueFactory(new PropertyValueFactory<>("param4"));
        param4Column.setCellFactory(param -> new TableCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                setContentDisplay(ContentDisplay.TEXT_ONLY);
                if (item == null) {
                    setText(null);
                } else {
                    setText(integerFormat.format((int) item));
                }
            }
        });

        final TableColumn param5Column = new TableColumn("H tcp, бит");
        param5Column.setPrefWidth(75.0);

        param5Column.setCellValueFactory(new PropertyValueFactory<>("param5"));
        param5Column.setCellFactory(param -> new TableCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                setContentDisplay(ContentDisplay.TEXT_ONLY);
                if (item == null) {
                    setText(null);
                } else {
                    setText(integerFormat.format((int) item));
                }
            }
        });

        final TableColumn param6Column = new TableColumn("H, бит");
        param6Column.setPrefWidth(75.0);

        param6Column.setCellValueFactory(new PropertyValueFactory<>("param6"));
        param6Column.setCellFactory(param -> new TableCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                setContentDisplay(ContentDisplay.TEXT_ONLY);
                if (item == null) {
                    setText(null);
                } else {
                    setText(integerFormat.format((int) item));
                }
            }
        });

        final TableColumn param7Column = new TableColumn("H ip, бит");
        param7Column.setPrefWidth(75.0);

        param7Column.setCellValueFactory(new PropertyValueFactory<>("param7"));
        param7Column.setCellFactory(param -> new TableCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                setContentDisplay(ContentDisplay.TEXT_ONLY);
                if (item == null) {
                    setText(null);
                } else {
                    setText(integerFormat.format((int) item));
                }
            }
        });

        final TableColumn param8Column = new TableColumn("p");
        param8Column.setPrefWidth(75.0);

        param8Column.setCellValueFactory(new PropertyValueFactory<>("param8"));
        param8Column.setCellFactory(param -> new TableCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                setContentDisplay(ContentDisplay.TEXT_ONLY);
                if (item == null) {
                    setText(null);
                } else {
                    setText(numberFormat.format((double) item));
                }
            }
        });

        final TableColumn param9Column = new TableColumn("V, бит");
        param9Column.setPrefWidth(75.0);

        param9Column.setCellValueFactory(new PropertyValueFactory<>("param9"));
        param9Column.setCellFactory(param -> new TableCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                setContentDisplay(ContentDisplay.TEXT_ONLY);
                if (item == null) {
                    setText(null);
                } else {
                    setText(integerFormat.format((int) item));
                }
            }
        });

        final TableColumn param10Column = new TableColumn("υ, бит/с");
        param10Column.setPrefWidth(75.0);

        param10Column.setCellValueFactory(new PropertyValueFactory<>("param10"));
        param10Column.setCellFactory(param -> new TableCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                setContentDisplay(ContentDisplay.TEXT_ONLY);
                if (item == null) {
                    setText(null);
                } else {
                    setText(integerFormat.format((int) item));
                }
            }
        });

        final TableColumn result2Column = new TableColumn("(2) L*b");
        result2Column.setPrefWidth(75.0);

        result2Column.setCellValueFactory(new PropertyValueFactory<>("result2"));
        result2Column.setCellFactory(param -> new TableCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                setContentDisplay(ContentDisplay.TEXT_ONLY);
                if (item == null) {
                    setText(null);
                } else {
                    setText(numberFormat.format((double) item));
                }
            }
        });

        final TableColumn result3Column = new TableColumn("(3) P*b");
        result3Column.setPrefWidth(75.0);

        result3Column.setCellValueFactory(new PropertyValueFactory<>("result3"));
        result3Column.setCellFactory(param -> new TableCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                setContentDisplay(ContentDisplay.TEXT_ONLY);
                if (item == null) {
                    setText(null);
                } else {
                    setText(numberFormat.format((double) item));
                }
            }
        });

        final TableColumn result4Column = new TableColumn("(4) a*b st,m max");
        result4Column.setPrefWidth(75.0);

        result4Column.setCellValueFactory(new PropertyValueFactory<>("result4"));
        result4Column.setCellFactory(param -> new TableCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                setContentDisplay(ContentDisplay.TEXT_ONLY);
                if (item == null) {
                    setText(null);
                } else {
                    setText(numberFormat.format((double) item));
                }
            }
        });

        final TableColumn result5Column = new TableColumn("(5) L*c");
        result5Column.setPrefWidth(75.0);

        result5Column.setCellValueFactory(new PropertyValueFactory<>("result5"));
        result5Column.setCellFactory(param -> new TableCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                setContentDisplay(ContentDisplay.TEXT_ONLY);
                if (item == null) {
                    setText(null);
                } else {
                    setText(numberFormat.format((double) item));
                }
            }
        });

        final TableColumn result6Column = new TableColumn("(6) β*c");
        result6Column.setPrefWidth(75.0);

        result6Column.setCellValueFactory(new PropertyValueFactory<>("result6"));
        result6Column.setCellFactory(param -> new TableCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                setContentDisplay(ContentDisplay.TEXT_ONLY);
                if (item == null) {
                    setText(null);
                } else {
                    setText(numberFormat.format((double) item));
                }
            }
        });

        final TableColumn result7Column = new TableColumn("(7) ρ*c");
        result7Column.setPrefWidth(75.0);

        result7Column.setCellValueFactory(new PropertyValueFactory<>("result7"));
        result7Column.setCellFactory(param -> new TableCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                setContentDisplay(ContentDisplay.TEXT_ONLY);
                if (item == null) {
                    setText(null);
                } else {
                    setText(numberFormat.format((double) item));
                }
            }
        });

        final TableColumn result8Column = new TableColumn("(8) ρ*b");
        result8Column.setPrefWidth(75.0);

        result8Column.setCellValueFactory(new PropertyValueFactory<>("result8"));
        result8Column.setCellFactory(param -> new TableCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                setContentDisplay(ContentDisplay.TEXT_ONLY);
                if (item == null) {
                    setText(null);
                } else {
                    setText(numberFormat.format((double) item));
                }
            }
        });

        final TableColumn result9Column = new TableColumn("(9) L*c");
        result9Column.setPrefWidth(75.0);

        result9Column.setCellValueFactory(new PropertyValueFactory<>("result9"));
        result9Column.setCellFactory(param -> new TableCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                setContentDisplay(ContentDisplay.TEXT_ONLY);
                if (item == null) {
                    setText(null);
                } else {
                    setText(numberFormat.format((double) item));
                }
            }
        });

        final TableColumn result10Column = new TableColumn("(10) ρ*c");
        result10Column.setPrefWidth(75.0);

        result10Column.setCellValueFactory(new PropertyValueFactory<>("result10"));
        result10Column.setCellFactory(param -> new TableCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                setContentDisplay(ContentDisplay.TEXT_ONLY);
                if (item == null) {
                    setText(null);
                } else {
                    setText(numberFormat.format((double) item));
                }
            }
        });

        final TableColumn result11Column = new TableColumn("(11) V*c");
        result11Column.setPrefWidth(75.0);

        result11Column.setCellValueFactory(new PropertyValueFactory<>("result11"));
        result11Column.setCellFactory(param -> new TableCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                setContentDisplay(ContentDisplay.TEXT_ONLY);
                if (item == null) {
                    setText(null);
                } else {
                    setText(numberFormat.format((double) item));
                }
            }
        });

        final TableColumn result12Column = new TableColumn("(12) V*b");
        result12Column.setPrefWidth(75.0);

        result12Column.setCellValueFactory(new PropertyValueFactory<>("result12"));
        result12Column.setCellFactory(param -> new TableCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                setContentDisplay(ContentDisplay.TEXT_ONLY);
                if (item == null) {
                    setText(null);
                } else {
                    setText(numberFormat.format((double) item));
                }
            }
        });

        final TableColumn result13Column = new TableColumn("(13) R");
        result13Column.setPrefWidth(75.0);

        result13Column.setCellValueFactory(new PropertyValueFactory<>("result13"));
        result13Column.setCellFactory(param -> new TableCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                setContentDisplay(ContentDisplay.TEXT_ONLY);
                if (item == null) {
                    setText(null);
                } else {
                    setText(numberFormat.format((double) item));
                }
            }
        });

        // TODO: добавить все колонки в таблицу

        final Label textPlaceholder = new Label("Нет данных для отображения");
        textPlaceholder.getStyleClass().add("custom-label");

        final TableView<SourceData> tableView = new TableView<>();
        tableView.setPlaceholder(textPlaceholder);
        tableView.getStyleClass().add("custom-table-view");

        tableView.getColumns().addAll(
                nColumn,
                dColumn,
                zColumn,
                param1Column,
                param2Column,
                param3Column,
                param4Column,
                param5Column,
                param6Column,
                param7Column,
                param8Column,
                param9Column,
                param10Column,
                result2Column,
                result3Column,
                result4Column,
                result5Column,
                result6Column,
                result7Column,
                result8Column,
                result9Column,
                result10Column,
                result11Column,
                result12Column,
                result13Column
        );

        tableView.setItems(getSkinnable().getSortedList());
        tableView.getSelectionModel().select(getSkinnable().getSelected());

        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> getSkinnable().setSelected((SourceData) newValue));
        getSkinnable().selectedProperty().addListener((observable, oldValue, newValue) -> tableView.getSelectionModel().select(newValue));
        tableView.scrollTo(tableView.getSelectionModel().getSelectedItem());

        getSkinnable().getSortedList().comparatorProperty().bind(tableView.comparatorProperty());

        tableView.getSortOrder().add(nColumn);
        tableView.sort();

        // ========================================================================================================== //
        // ПАНЕЛЬ ИТОГОВ
        // ========================================================================================================== //

        final Label footerLabel = new Label();
        footerLabel.textProperty().bindBidirectional(getSkinnable().footerProperty());
        footerLabel.getStyleClass().add("custom-sub-label");

        final HBox centerBox = new HBox(5.0);
        centerBox.getChildren().addAll(
                footerLabel
        );
        centerBox.setFocusTraversable(false);

        final BorderPane footerPane = new BorderPane(
                centerBox,
                null,
                null,
                null,
                null
        );
        footerPane.setPadding(new Insets(5.0, 5.0, 3.0, 5.0));
        footerPane.setFocusTraversable(false);

        // ========================================================================================================== //
        // ПАНЕЛЬ СЦЕНЫ
        // ========================================================================================================== //

        final BorderPane panes = new BorderPane(tableView,
                null,
                buttonsBox,
                footerPane,
                null);

        final TitledPane titledPane = new TitledPane(
                "Расчет параметров ТС МСС без механизмов защиты",
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
