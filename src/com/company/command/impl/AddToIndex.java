package com.company.command.impl;

import com.company.Helper;
import com.company.TextEditor;
import com.company.command.Command;
import com.company.command.impl.service.AddToIndexService;

public class AddToIndex extends Command {
    public static final String description = "Вставить строку по индексу";
    public static final String name = "AddToIndex";
    private int backUpIndexStart, backUpIndexEnd;

    public AddToIndex(TextEditor textEditor) {
        super(textEditor);
    }

    @Override
    public void undo() {
        textEditor.getMainString().delete(backUpIndexStart, backUpIndexEnd);
    }

    @Override
    public boolean execute() {
        int index;
        String input;

        System.out.println("Введите индекс: ");
        index = Helper.getIndex(textEditor);
        System.out.println("Введите строку: ");
        input = Helper.scanner.nextLine();

        backUpIndexStart = index;
        backUpIndexEnd = index + input.length();

        return AddToIndexService.service(input, index, textEditor);
    }

    @Override
    public String getDescription() {
        return AddToIndex.description;
    }

    @Override
    public Command getInstance() {
        return new AddToIndex(textEditor);
    }
}
