package ru.artur.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import ru.artur.view.AppSkin;

/**
 * Created by Aleksandr on 19.12.17.
 */
public class AppController extends Control {

    private static AppController ourInstance = new AppController();
    public static AppController getInstance() {
        AppController localInstance = ourInstance;
        if (localInstance == null) {
            synchronized (AppController.class) {
                localInstance = ourInstance;
                if (localInstance == null) {
                    ourInstance = localInstance = new AppController();
                }
            }
        }
        return localInstance;
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new AppSkin(this);
    }

    private final StringProperty activeController = new SimpleStringProperty("VIEW_CONTROLLER");
    public String getActiveController() {
        return activeController.get();
    }
    public StringProperty activeControllerProperty() {
        return activeController;
    }
    public void setActiveController(String activeController) {
        this.activeController.set(activeController);
    }
}