package com.company.command.impl;

import com.company.Helper;
import com.company.TextEditor;
import com.company.command.Command;

public class Paste extends Command {
    public static final String description="Вставить строку по индексу из буфера";
    public static final String name="Paste";
    private int backUpIndexStart, backUpIndexEnd;

    public Paste(TextEditor textEditor) {
        super(textEditor, name, description);
    }

    @Override
    public void undo() {
        textEditor.getMainString().delete(backUpIndexStart, backUpIndexEnd);
    }

    @Override
    public boolean execute() {
        int index;
        if (!textEditor.getBufferString().isEmpty()) {
            System.out.println("Введите индекс: ");
            index = Helper.getIndex(textEditor);
            textEditor.getMainString().insert(index, textEditor.getBufferString());
            backUpIndexStart=index;
            backUpIndexEnd=index+textEditor.getBufferString().length();
            return true;
        } else {
            System.out.println("Буфер пустой");
            return false;
        }
    }

    @Override
    public Command getInstance() {
        return new Paste(textEditor);
    }
}
