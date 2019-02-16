package ru.artur.view;

import com.sun.javafx.css.StyleManager;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SkinBase;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.LongStringConverter;
import javafx.util.converter.NumberStringConverter;
import ru.artur.controller.EditController;
import ru.artur.view.controls.TextEditableField;

import java.text.NumberFormat;

/**
 * Created by Aleksandr on 22.12.17.
 */
public class EditSkin extends SkinBase<EditController> {

    static {
        StyleManager.getInstance().addUserAgentStylesheet(
                EditController.class.getResource("/style_default.css").toExternalForm());
    }

    public EditSkin(EditController control) {
        super(control);

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

        final Button homeButton = new Button("Назад");
        homeButton.setId("HOME");
        homeButton.setFocusTraversable(false);
        homeButton.getStyleClass().add("custom-toolbar-button");

        homeButton.setOnMousePressed(mouseEventHandler);

        final HBox leftBox = new HBox(5.0);
        leftBox.getChildren().addAll(
                homeButton
        );
        leftBox.setFocusTraversable(false);

        final BorderPane toolbarPane = new BorderPane(
                null,
                null,
                null,
                null,
                leftBox
        );
        toolbarPane.setPadding(new Insets(2.0, 5.0, 3.0, 5.0));
        toolbarPane.setFocusTraversable(false);
        toolbarPane.getStyleClass().add("custom-toolbar");

        // ========================================================================================================== //
        // ПАНЕЛЬ СОДЕРЖИМОГО
        // ========================================================================================================== //

        final Label group1Label = new Label("Табличные величины");
        group1Label.getStyleClass().add("custom-separator-label");

        final Label nLabel = new Label("Количество узлов в сети (n)");
        nLabel.getStyleClass().add("custom-label");

        final TextEditableField nField = new TextEditableField(4, "(\\d{1,4})?");
        nField.setEditable(false);
        nField.getStyleClass().add("custom-text");

        final Label dLabel = new Label("Допустимая вероятность превышения сквозной задержки пакетами класса B (d)");
        dLabel.getStyleClass().add("custom-label");

        final TextEditableField dField = new TextEditableField(8, "(\\d+([.,]\\d{0,5})?)?");
        dField.setEditable(false);
        dField.getStyleClass().add("custom-text");

        final Label zLabel = new Label("(z)");
        zLabel.getStyleClass().add("custom-label");

        final TextEditableField zField = new TextEditableField(8, "(\\d+([.,]\\d{0,5})?)?");
        zField.setEditable(false);
        zField.getStyleClass().add("custom-text");

        final Label group2Label = new Label("Исходные данные для расчетов");
        group2Label.getStyleClass().add("custom-separator-label");

        final Label param1Label = new Label("Среднее время пребывания пакета класса C в сети (T, сек)");
        param1Label.getStyleClass().add("custom-label");

        final TextEditableField param1Field = new TextEditableField(8, "(\\d+([,]\\d{0,5})?)?");
        param1Field.getStyleClass().add("custom-text");

        final Label param1Label_1 = new Label("-");
        param1Label_1.getStyleClass().add("custom-label");

        final TextEditableField param1Field_1 = new TextEditableField(8, "(\\d+([,]\\d{0,5})?)?");
        param1Field_1.getStyleClass().add("custom-text");

        final Label param1Label_2 = new Label(", шаг изменения диапазона");
        param1Label_2.getStyleClass().add("custom-label");

        final TextEditableField param1Field_2 = new TextEditableField(8, "(\\d+([,]\\d{0,5})?)?");
        param1Field_2.getStyleClass().add("custom-text");

        final Label param2Label = new Label("Заданная сквозная задержка пакетами класса B (θ, сек)");
        param2Label.getStyleClass().add("custom-label");

        final TextEditableField param2Field = new TextEditableField(8, "(\\d+([,]\\d{0,5})?)?");
        param2Field.getStyleClass().add("custom-text");

        final Label param2Label_1 = new Label("-");
        param2Label_1.getStyleClass().add("custom-label");

        final TextEditableField param2Field_1 = new TextEditableField(8, "(\\d+([,]\\d{0,5})?)?");
        param2Field_1.getStyleClass().add("custom-text");

        final Label param2Label_2 = new Label(", шаг изменения диапазона");
        param2Label_2.getStyleClass().add("custom-label");

        final TextEditableField param2Field_2 = new TextEditableField(8, "(\\d+([,]\\d{0,5})?)?");
        param2Field_2.getStyleClass().add("custom-text");

        final Label param3Label = new Label("Скорость работы абонентской установки данных (ω, бит/с)");
        param3Label.getStyleClass().add("custom-label");

        final TextEditableField param3Field = new TextEditableField(8, "(\\d{1,5})?");
        param3Field.getStyleClass().add("custom-text");

        final Label param4Label = new Label("Средняя длительность активного речевого фрагмента (τ, сек)");
        param4Label.getStyleClass().add("custom-label");

        final TextEditableField param4Field = new TextEditableField(8, "(\\d{1,4})?");
        param4Field.getStyleClass().add("custom-text");

        final Label param5Label = new Label("Размер заголовка TCP (H tcp, бит)");
        param5Label.getStyleClass().add("custom-label");

        final TextEditableField param5Field = new TextEditableField(8, "(\\d{1,4})?");
        param5Field.getStyleClass().add("custom-text");

        final Label param6Label = new Label("Размер заголовка NI (в данном случае – FR) (H, бит)");
        param6Label.getStyleClass().add("custom-label");

        final TextEditableField param6Field = new TextEditableField(8, "(\\d{1,4})?");
        param6Field.getStyleClass().add("custom-text");

        final Label param7Label = new Label("Размер заголовка IP (H ip, бит)");
        param7Label.getStyleClass().add("custom-label");

        final TextEditableField param7Field = new TextEditableField(8, "(\\d{1,4})?");
        param7Field.getStyleClass().add("custom-text");

        final Label param8Label = new Label("Вероятность ошибки в тракте (p)");
        param8Label.getStyleClass().add("custom-label");

        final TextEditableField param8Field = new TextEditableField(8, "(\\d+([,]\\d{0,5})?)?");
        param8Field.getStyleClass().add("custom-text");

        final Label param8Label_1 = new Label("-");
        param8Label_1.getStyleClass().add("custom-label");

        final TextEditableField param8Field_1 = new TextEditableField(8, "(\\d+([,]\\d{0,5})?)?");
        param8Field_1.getStyleClass().add("custom-text");

        final Label param8Label_2 = new Label(", шаг изменения диапазона");
        param8Label_2.getStyleClass().add("custom-label");

        final TextEditableField param8Field_2 = new TextEditableField(8, "(\\d+([,]\\d{0,5})?)?");
        param8Field_2.getStyleClass().add("custom-text");

        final Label param9Label = new Label("Скорость канала (V, бит)");
        param9Label.getStyleClass().add("custom-label");

        final TextEditableField param9Field = new TextEditableField(8, "(\\d{1,8})?");
        param9Field.getStyleClass().add("custom-text");

        final Label param10Label = new Label("Скорость работы речепреобразующего устройства (υ, бит/с)");
        param10Label.getStyleClass().add("custom-label");

        final TextEditableField param10Field = new TextEditableField(8, "(\\d{1,8})?");
        param10Field.getStyleClass().add("custom-text");

        final Label param11Label = new Label("(nu)");
        param11Label.getStyleClass().add("custom-label");

        final TextEditableField param11Field = new TextEditableField(8, "(\\d+([,]\\d{0,5})?)?");
        param11Field.getStyleClass().add("custom-text");

        final ColumnConstraints titleColumn1 = new ColumnConstraints();
        titleColumn1.setHalignment(HPos.RIGHT);

        final ColumnConstraints propertyColumn1 = new ColumnConstraints();

        propertyColumn1.prefWidthProperty().addListener((observable, oldValue, newValue) -> {
        });

        final ColumnConstraints titleColumn2 = new ColumnConstraints();
        titleColumn2.setHalignment(HPos.CENTER);

        final ColumnConstraints propertyColumn2 = new ColumnConstraints();

        propertyColumn2.prefWidthProperty().addListener((observable, oldValue, newValue) -> {
        });

        final ColumnConstraints titleColumn3 = new ColumnConstraints();
        titleColumn3.setHalignment(HPos.RIGHT);

        final ColumnConstraints propertyColumn3 = new ColumnConstraints();

        propertyColumn3.prefWidthProperty().addListener((observable, oldValue, newValue) -> {
        });

        final GridPane gridPane = new GridPane();
        gridPane.setVgap(5.0);
        gridPane.setHgap(20.0);
        gridPane.setPadding(new Insets(20.0, 20.0, 10.0, 20.0));

        gridPane.getColumnConstraints().addAll(
                titleColumn1,
                propertyColumn1,
                titleColumn2,
                propertyColumn2,
                titleColumn3,
                propertyColumn3
        );

        titleColumn1.setPrefWidth(500.0);
        propertyColumn1.setPrefWidth(150.0);
        titleColumn2.setPrefWidth(5.0);
        propertyColumn2.setPrefWidth(150.0);
        titleColumn3.setPrefWidth(175.0);
        propertyColumn3.setPrefWidth(150.0);

        gridPane.addRow(0, group1Label);
        gridPane.addRow(1, nLabel, nField);
        gridPane.addRow(2, dLabel, dField);
        gridPane.addRow(3, zLabel, zField);

        gridPane.addRow(4, group2Label);
        gridPane.addRow(5, param1Label, param1Field, param1Label_1, param1Field_1, param1Label_2, param1Field_2);
        gridPane.addRow(6, param2Label, param2Field, param2Label_1, param2Field_1, param2Label_2, param2Field_2);
        gridPane.addRow(7, param3Label, param3Field);
        gridPane.addRow(8, param4Label, param4Field);
        gridPane.addRow(9, param5Label, param5Field);
        gridPane.addRow(10, param6Label, param6Field);
        gridPane.addRow(11, param7Label, param7Field);
        gridPane.addRow(12, param8Label, param8Field, param8Label_1, param8Field_1, param8Label_2, param8Field_2);
        gridPane.addRow(13, param9Label, param9Field);
        gridPane.addRow(14, param10Label, param10Field);
        gridPane.addRow(15, param11Label, param11Field);

        // ========================================================================================================== //
        // ПАНЕЛЬ СЦЕНЫ
        // ========================================================================================================== //

        final BorderPane contextPane = new BorderPane(
                gridPane,
                toolbarPane,
                null,
                null,
                null
        );

        getChildren().add(contextPane);

        getNode().setFocusTraversable(false);
        getNode().getStyleClass().add("custom-empty-view");

        // ========================================================================================================== //
        // СВЯЗЬ ИСТОЧНИКА ДАННЫХ С ЭЛЕМЕНТАМИ ИНТЕРФЕЙСА
        // ========================================================================================================== //

        final NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setGroupingUsed(false);
        numberFormat.setMinimumFractionDigits(5);

        final NumberFormat integerFormat = NumberFormat.getIntegerInstance();
        integerFormat.setGroupingUsed(false);

        nField.textProperty().bindBidirectional(getSkinnable().getBasic().nProperty(), new LongStringConverter());
        dField.textProperty().bindBidirectional(getSkinnable().getBasic().dProperty(), new DoubleStringConverter());
        zField.textProperty().bindBidirectional(getSkinnable().getBasic().zProperty(), new DoubleStringConverter());

        param1Field.textProperty().bindBidirectional(getSkinnable().getBasic().param1Property(), new NumberStringConverter(numberFormat));
        param1Field_1.textProperty().bindBidirectional(getSkinnable().getBasic().param1_futureProperty(), new NumberStringConverter(numberFormat));
        param1Field_2.textProperty().bindBidirectional(getSkinnable().getBasic().param1_stepProperty(), new NumberStringConverter(numberFormat));
        param2Field.textProperty().bindBidirectional(getSkinnable().getBasic().param2Property(), new NumberStringConverter(numberFormat));
        param2Field_1.textProperty().bindBidirectional(getSkinnable().getBasic().param2_futureProperty(), new NumberStringConverter(numberFormat));
        param2Field_2.textProperty().bindBidirectional(getSkinnable().getBasic().param2_stepProperty(), new NumberStringConverter(numberFormat));
        param3Field.textProperty().bindBidirectional(getSkinnable().getBasic().param3Property(), new NumberStringConverter(integerFormat));
        param4Field.textProperty().bindBidirectional(getSkinnable().getBasic().param4Property(), new NumberStringConverter(integerFormat));
        param5Field.textProperty().bindBidirectional(getSkinnable().getBasic().param5Property(), new NumberStringConverter(integerFormat));
        param6Field.textProperty().bindBidirectional(getSkinnable().getBasic().param6Property(), new NumberStringConverter(integerFormat));
        param7Field.textProperty().bindBidirectional(getSkinnable().getBasic().param7Property(), new NumberStringConverter(integerFormat));
        param8Field.textProperty().bindBidirectional(getSkinnable().getBasic().param8Property(), new NumberStringConverter(numberFormat));
        param8Field_1.textProperty().bindBidirectional(getSkinnable().getBasic().param8_futureProperty(), new NumberStringConverter(numberFormat));
        param8Field_2.textProperty().bindBidirectional(getSkinnable().getBasic().param8_stepProperty(), new NumberStringConverter(numberFormat));
        param9Field.textProperty().bindBidirectional(getSkinnable().getBasic().param9Property(), new NumberStringConverter(integerFormat));
        param10Field.textProperty().bindBidirectional(getSkinnable().getBasic().param10Property(), new NumberStringConverter(integerFormat));
        param11Field.textProperty().bindBidirectional(getSkinnable().getBasic().param11Property(), new NumberStringConverter(numberFormat));
    }
}
