package com.company.command.impl;

import com.company.Helper;
import com.company.TextEditor;
import com.company.command.Command;

public class Paste extends Command {
    public static final String description="Вставить строку по индексу из буфера";
    public static final String name="Paste";

    public Paste(TextEditor textEditor) {
        super(textEditor, name, description);
    }

    @Override
    public boolean execute() {
        setBackUp();
        int index;
        if (!textEditor.getBufferString().isEmpty()) {
            System.out.println("Введите индекс: ");
            index = Helper.getIndex(textEditor);
            textEditor.getMainString().insert(index, textEditor.getBufferString());
        } else {
            System.out.println("Буфер пустой");
        }
        return true;
    }

    @Override
    public Command getInstance() {
        return new Paste(textEditor);
    }
}
