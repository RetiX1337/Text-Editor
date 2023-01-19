package com.company.command.impl.service;

import com.company.TextEditor;

public class PasteService {
    private static PasteService instance = null;

    private PasteService() {
    }

    public boolean service(int index, TextEditor textEditor) {
        if (!textEditor.getBufferString().isEmpty()) {
            textEditor.getTempString().insert(index, textEditor.getBufferString());
            return true;
        } else {
            System.out.println("Буфер пустой");
            return false;
        }
    }

    public static PasteService getInstance() {
        if(instance!=null){
            return instance;
        }
        return instance = new PasteService();
    }
}
