package ru.artur.view.controls;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

/**
 * Created by Aleksandr on 23.12.17.
 */
public class TextEditableField extends TextField {

    // =================================================================================================================
    // Internal properties
    // =================================================================================================================

    private final int maxLenght;
    private final String inputMask;

    // =================================================================================================================
    // Constructors
    // =================================================================================================================

    /**
     * Конструктор класса
     */
    public TextEditableField() {
        this(0, "");
    }

    /**
     * Конструктор класса
     * @param maxLenght максимальное количество символов
     */
    public TextEditableField(int maxLenght) {
        this(maxLenght, "");
    }

    /**
     * Конструктор класса
     * @param maxLenght максимальное количество символов
     * @param inputMask маска ввода
     */
    public TextEditableField(int maxLenght, String inputMask) {
        this.maxLenght = maxLenght;
        this.inputMask = inputMask;

        textProperty().addListener(new ChangeListener<String>() {
            private boolean ignore;

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (ignore || newValue == null) return;

                // check max lenght
                if (maxLenght != 0) {
                    if (newValue.length() > maxLenght) {
                        ignore = true;
                        setText(newValue.substring(0, maxLenght));
                        ignore = false;
                    }
                }

                // check regular expression
                if (!inputMask.isEmpty() && !newValue.matches(inputMask)) {
                    ignore = true;
                    setText(oldValue);
                    ignore = false;
                }
            }
        });

    }
}
