package com.company.command.impl.service.deletefromarea;

import com.company.TextEditor;

public class DeleteFromAreaService {
    private static DeleteFromAreaService instance = null;

    private DeleteFromAreaService() {}

    public boolean service(int startIndex, int endIndex, TextEditor textEditor) {
        if (!textEditor.getTempString().isEmpty()) {
            textEditor.getTempString().delete(startIndex, endIndex);
            return true;
        } else {
            System.out.println("Строка пустая");
            return false;
        }
    }

    public static DeleteFromAreaService getInstance() {
        if(instance!=null){
            return instance;
        }
        return instance = new DeleteFromAreaService();
    }
}
