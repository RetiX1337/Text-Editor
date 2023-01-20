package com.company.command.impl.service.copy;

import com.company.TextEditor;

public class CopyService {
    private static CopyService instance = null;

    private CopyService(){}

    public boolean service(int startIndex, int endIndex, TextEditor textEditor) {
        if (!textEditor.getTempString().isEmpty()) {
            textEditor.getBufferString().setLength(0);
            textEditor.getBufferString().append(textEditor.getTempString().substring(startIndex, endIndex));
        } else {
            System.out.println("Строка пустая");
        }
        return false;
    }

    public static CopyService getInstance() {
        if(instance!=null){
            return instance;
        }
        return instance = new CopyService();
    }
}
