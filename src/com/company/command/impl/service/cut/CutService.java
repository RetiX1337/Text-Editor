package com.company.command.impl.service.cut;

import com.company.TextEditor;

public class CutService {
    private static CutService instance = null;

    private CutService() {}

    public boolean service(int startIndex, int endIndex, TextEditor textEditor) {
        if (!textEditor.getTempString().isEmpty()) {
            textEditor.getBufferString().setLength(0);
            textEditor.getBufferString().append(textEditor.getTempString().substring(startIndex, endIndex));
            textEditor.getTempString().delete(startIndex, endIndex);
            return true;
        } else {
            System.out.println("Строка пустая");
            return false;
        }
    }

    public static CutService getInstance() {
        if(instance!=null){
            return instance;
        }
        return instance = new CutService();
    }
}
