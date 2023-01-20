package com.company.command.impl.service.addtoindex;

import com.company.TextEditor;

public class AddToIndexService implements AddToIndexInterface {
    private static AddToIndexService instance = null;

    private AddToIndexService(){}

    @Override
    public boolean service(String input, int index, TextEditor textEditor) {
        if (!textEditor.getTempString().isEmpty()) {
            textEditor.getTempString().insert(index, input);
            return true;
        } else {
            System.out.println("Строка пустая");
            return false;
        }
    }

    public static AddToIndexService getInstance() {
        if(instance!=null){
            return instance;
        }
        return instance = new AddToIndexService();
    }
}
