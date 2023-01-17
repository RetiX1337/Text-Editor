package com.company.command.impl.service;

import com.company.TextEditor;
import com.company.command.Command;

public class UndoService {
    public static boolean service(TextEditor textEditor) {
        if (!textEditor.getCommandHistory().isEmpty()) {
            Command command = textEditor.getCommandHistory().pop();
            command.undo();
        } else {
            System.out.println("Список команд пуст");
        }
        return false;
    }
}
