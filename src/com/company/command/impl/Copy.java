package com.company.command.impl;

import com.company.Helper;
import com.company.TextEditor;
import com.company.command.Command;
import com.company.command.impl.service.CopyService;

public class Copy extends Command {
    public static final String description = "Копировать часть строки в буфер";
    public static final String name = "Copy";

    public Copy(TextEditor textEditor) {
        super(textEditor);
    }

    @Override
    public void undo() {
    }

    @Override
    public boolean execute() {
        int startIndex, endIndex;

        System.out.println("Введите индекс начала диапазона: ");
        startIndex = Helper.getIndex(textEditor);
        System.out.println("Введите индекс конца диапазона: ");
        endIndex = Helper.getIndex(textEditor);

        return CopyService.service(startIndex, endIndex, textEditor);
    }

    @Override
    public String getDescription() {
        return Copy.description;
    }

    @Override
    public Command getInstance() {
        return new Copy(textEditor);
    }

}
