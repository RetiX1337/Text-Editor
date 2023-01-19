package com.company.command.impl.service;

import com.company.TextEditor;

public class AddToEndService {
    private static AddToEndService instance=null;

    private AddToEndService(){
    }

    public boolean service(String input, TextEditor textEditor) {
        textEditor.getTempString().append(input);
        return true;
    }

    public static AddToEndService getInstance() {
        if(instance!=null){
            return instance;
        }
        return instance = new AddToEndService();
    }
}
