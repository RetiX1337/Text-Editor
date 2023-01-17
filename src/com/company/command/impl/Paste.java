package com.company.command.impl;

import com.company.Helper;
import com.company.TextEditor;
import com.company.command.Command;
import com.company.command.impl.service.PasteService;

public class Paste extends Command {
    public static final String description = "Вставить строку по индексу из буфера";
    public static final String name = "Paste";
    private int backUpIndexStart, backUpIndexEnd;

    public Paste(TextEditor textEditor) {
        super(textEditor);
    }

    @Override
    public void undo() {
        textEditor.getMainString().delete(backUpIndexStart, backUpIndexEnd);
    }

    @Override
    public boolean execute() {
        int index;

        System.out.println("Введите индекс: ");
        index = Helper.getIndex(textEditor);

        backUpIndexStart = index;
        backUpIndexEnd = index + textEditor.getBufferString().length();

        return PasteService.service(index, textEditor);
    }

    @Override
    public String getDescription() {
        return Paste.description;
    }

    @Override
    public Command getInstance() {
        return new Paste(textEditor);
    }
}
