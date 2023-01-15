package com.company.command.impl;

import com.company.Helper;
import com.company.TextEditor;
import com.company.command.Command;

public class DeleteFromArea extends Command {
    public static final String description="Удалить часть строки";
    public static final String name="DeleteFromArea";
    private int backUpIndexStart;
    private String backUpString;

    public DeleteFromArea(TextEditor textEditor) {
        super(textEditor, name, description);
    }

    @Override
    public void undo() {
        textEditor.getMainString().insert(backUpIndexStart, backUpString);
    }

    @Override
    public boolean execute() {
        int startIndex, endIndex;
        if (!textEditor.getMainString().isEmpty()) {
            System.out.println("Введите индекс начала диапазона: ");
            startIndex = Helper.getIndex(textEditor);
            System.out.println("Введите индекс конца диапазона: ");
            endIndex = Helper.getIndex(textEditor);
            backUpString=textEditor.getMainString().substring(startIndex, endIndex);
            textEditor.getMainString().delete(startIndex, endIndex);

            backUpIndexStart=startIndex;
            return true;
        } else {
            System.out.println("Строка пустая");
            return false;
        }
    }

    @Override
    public Command getInstance() {
        return new DeleteFromArea(textEditor);
    }

}
