package com.company.command.impl;

import com.company.Helper;
import com.company.TextEditor;
import com.company.command.Command;

public class DeleteFromArea extends Command {
    public static final String description="Удалить часть строки";
    public static final String name="DeleteFromArea";

    public DeleteFromArea(TextEditor textEditor) {
        super(textEditor, name, description);
    }

    @Override
    public boolean execute() {
        setBackUp();
        int startIndex, endIndex;
        if (!textEditor.getMainString().isEmpty()) {
            System.out.println("Введите индекс начала диапазона: ");
            startIndex = Helper.getIndex(textEditor);
            System.out.println("Введите индекс конца диапазона: ");
            endIndex = Helper.getIndex(textEditor);
            textEditor.getMainString().delete(startIndex, endIndex);
        } else {
            System.out.println("Строка пустая");
        }
        return true;
    }

    @Override
    public Command getInstance() {
        return new DeleteFromArea(textEditor);
    }

}
