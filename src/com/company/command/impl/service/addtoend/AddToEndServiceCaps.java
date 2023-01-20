package com.company.command.impl.service.addtoend;

import com.company.TextEditor;

public class AddToEndServiceCaps implements AddToEndInterface {
    private static AddToEndServiceCaps instance = null;

    private AddToEndServiceCaps() {
    }

    @Override
    public boolean service(String input, TextEditor textEditor) {
        textEditor.getTempString().append(input.toUpperCase());
        return true;
    }


    public static AddToEndServiceCaps getInstance() {
        if (instance != null) {
            return instance;
        }
        return instance = new AddToEndServiceCaps();
    }
}
