package com.company.command.impl.service;

import com.company.TextEditor;
import com.company.command.Command;

public class UndoService {
    private static UndoService instance = null;

    private UndoService() {}

    public boolean service(TextEditor textEditor) {
        if (!textEditor.getCommandHistory().isEmpty()) {
            textEditor.getCommandHistory().pop();
        } else {
            System.out.println("Список команд пуст");
        }
        return false;
    }

    public static UndoService getInstance() {
        if(instance!=null){
            return instance;
        }
        return instance = new UndoService();
    }
}
