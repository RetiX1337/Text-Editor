package com.company.command.impl;

import com.company.Helper;
import com.company.TextEditor;
import com.company.command.Command;

public class Copy extends Command {
    public static final String description="Копировать часть строки в буфер";
    public static final String name="Copy";

    public Copy(TextEditor textEditor) {
        super(textEditor, name, description);
    }

    @Override
    public void undo() {
    }

    @Override
    public boolean execute() {
        int startIndex, endIndex;
        if (!textEditor.getMainString().isEmpty()) {
            System.out.println("Введите индекс начала диапазона: ");
            startIndex = Helper.getIndex(textEditor);
            System.out.println("Введите индекс конца диапазона: ");
            endIndex = Helper.getIndex(textEditor);
            textEditor.getBufferString().setLength(0);
            textEditor.getBufferString().append(textEditor.getMainString().substring(startIndex, endIndex));
        } else {
            System.out.println("Строка пустая");
        }
        return false;
    }

    @Override
    public Command getInstance() {
        return new Copy(textEditor);
    }

}
