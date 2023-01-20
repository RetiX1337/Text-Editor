package com.company.command.impl.service.addtoindex;

import com.company.TextEditor;

public class AddToIndexServiceCaps implements AddToIndexInterface {
    private static AddToIndexServiceCaps instance = null;

    private AddToIndexServiceCaps(){}

    @Override
    public boolean service(String input, int index, TextEditor textEditor) {
        if (!textEditor.getTempString().isEmpty()) {
            textEditor.getTempString().insert(index, input.toUpperCase());
            return true;
        } else {
            System.out.println("Строка пустая");
            return false;
        }
    }

    public static AddToIndexServiceCaps getInstance() {
        if(instance!=null){
            return instance;
        }
        return instance = new AddToIndexServiceCaps();
    }
}
