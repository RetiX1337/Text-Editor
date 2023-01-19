package com.company.command.impl.service;

import com.company.TextEditor;

public class AddToIndexService {
    private static AddToIndexService instance = null;

    private AddToIndexService(){}

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
