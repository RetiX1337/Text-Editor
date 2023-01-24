package com.company.command.impl.service.addtoend;

import com.company.TextEditor;

public class AddToEndService implements AddToEndInterface {
    private static AddToEndService instance = null;

    private AddToEndService() {
    }

    @Override
    public boolean execute(String input, TextEditor textEditor) {
        textEditor.getTempString().append(input);
        return true;
    }


    public static AddToEndService getInstance() {
        if (instance != null) {
            return instance;
        }
        return instance = new AddToEndService();
    }
}
