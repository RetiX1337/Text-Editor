package com.company.command.impl;

import com.company.Helper;
import com.company.TextEditor;
import com.company.command.Command;
import com.company.command.impl.service.CutService;

public class Cut extends Command {
    public static final String description = "Вырезать часть строки в буфер";
    public static final String name = "Cut";
    private int backUpIndexStart;
    private String backUpString;

    public Cut(TextEditor textEditor) {
        super(textEditor);
    }

    @Override
    public void undo() {
        textEditor.getMainString().insert(backUpIndexStart, backUpString);
    }

    @Override
    public boolean execute() {
        int startIndex, endIndex;

        System.out.println("Введите индекс начала диапазона: ");
        startIndex = Helper.getIndex(textEditor);
        System.out.println("Введите индекс конца диапазона: ");
        endIndex = Helper.getIndex(textEditor);

        backUpString = textEditor.getMainString().substring(startIndex, endIndex);
        backUpIndexStart = startIndex;

        return CutService.service(startIndex, endIndex, textEditor);
    }

    @Override
    public String getDescription() {
        return Cut.description;
    }

    @Override
    public Command getInstance() {
        return new Cut(textEditor);
    }
}
