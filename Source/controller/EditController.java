package ru.artur.controller;

import javafx.beans.binding.BooleanBinding;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import ru.artur.model.SourceData;
import ru.artur.view.EditSkin;

/**
 * Created by Aleksandr on 22.12.17.
 */
public class EditController extends Control {

    private static EditController ourInstance = new EditController();
    public static EditController getInstance() {
        EditController localInstance = ourInstance;
        if (localInstance == null) {
            synchronized (EditController.class) {
                localInstance = ourInstance;
                if (localInstance == null) {
                    ourInstance = localInstance = new EditController();
                }
            }
        }
        return localInstance;
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new EditSkin(this);
    }

    public EditController() {

        visibleProperty().bind(new BooleanBinding() {
            {
                bind(AppController.getInstance().activeControllerProperty());
            }

            @Override
            protected boolean computeValue() {
                return (AppController.getInstance().getActiveController() == "EDIT_CONTROLLER" ? true : false);
            }
        });
    }

    public SourceData getBasic() {
        return ViewController.getInstance().getBasic();
    }

    public void eventHandler(String event) {
        if (event == null) return;
        switch (event) {
            case "HOME":
                home();
                break;
        }
    }

    private void home() {
        AppController.getInstance().setActiveController("VIEW_CONTROLLER");
    }

}
