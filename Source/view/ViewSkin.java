package ru.artur.view;

import com.sun.javafx.css.StyleManager;
import javafx.geometry.Orientation;
import javafx.scene.control.SkinBase;
import javafx.scene.control.SplitPane;
import ru.artur.controller.ViewController;

/**
 * Created by Aleksandr on 22.12.17.
 */
public class ViewSkin extends SkinBase<ViewController> {

    static {
        StyleManager.getInstance().addUserAgentStylesheet(
                ViewController.class.getResource("/style_default.css").toExternalForm());
    }

    public ViewSkin(ViewController control) {
        super(control);

        // ========================================================================================================== //
        // ПАНЕЛЬ СЦЕНЫ
        // ========================================================================================================== //

        final SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(
                getSkinnable().getGraphController(),
                getSkinnable().getDetailController()
        );
        splitPane.setOrientation(Orientation.VERTICAL);
        splitPane.setDividerPosition(0, 0.5);
        splitPane.setFocusTraversable(false);
        splitPane.getStyleClass().add("custom-split-pane");

        getChildren().add(splitPane);

        getNode().setFocusTraversable(false);
        getNode().getStyleClass().add("custom-transparent-view");
    }
}
