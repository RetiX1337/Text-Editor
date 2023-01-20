package com.company.command.impl.service.addtoend;

import com.company.TextEditor;

public class AddToEndService implements AddToEndInterface {
    private static AddToEndService instance = null;

    private AddToEndService() {
    }

    @Override
    public boolean service(String input, TextEditor textEditor) {
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
