package ru.artur.view;

import com.sun.javafx.css.StyleManager;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import ru.artur.controller.AppController;
import ru.artur.controller.EditController;
import ru.artur.controller.ViewController;

/**
 * Created by Aleksandr on 19.12.17.
 */
public class AppSkin extends SkinBase<AppController> {

    static {
        StyleManager.getInstance().addUserAgentStylesheet(
                AppController.class.getResource("/style_default.css").toExternalForm());
    }

    public AppSkin(AppController control) {
        super(control);

        // ========================================================================================================== //
        // ПАНЕЛЬ СОДЕРЖИМОГО
        // ========================================================================================================== //

        final StackPane contextPane = new StackPane(
                ViewController.getInstance(),
                EditController.getInstance()
        );

        contextPane.setFocusTraversable(false);
        contextPane.getStyleClass().add("custom-application");

        // ========================================================================================================== //
        // ПАНЕЛЬ СЦЕНЫ
        // ========================================================================================================== //

        final Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        final BorderPane rootPane = new BorderPane(contextPane,
                null,
                null,
                null,
                null);
        rootPane.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight());

        getChildren().add(rootPane);

        getNode().setFocusTraversable(false);
        getNode().getStyleClass().add("root");

        getNode().getScene().heightProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) rootPane.setPrefHeight((Double) newValue);
        });

        getNode().getScene().widthProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) rootPane.setPrefWidth((Double) newValue);
        });
    }
}
