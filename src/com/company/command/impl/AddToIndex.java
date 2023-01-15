package com.company.command.impl;

import com.company.Helper;
import com.company.TextEditor;
import com.company.command.Command;

public class AddToIndex extends Command {
    public static final String description="Вставить строку по индексу";
    public static final String name="AddToIndex";
    private int backUpIndexStart, backUpIndexEnd;

    public AddToIndex(TextEditor textEditor) {
        super(textEditor, name, description);
    }

    @Override
    public void undo() {
        textEditor.getMainString().delete(backUpIndexStart, backUpIndexEnd);
    }

    @Override
    public boolean execute() {
        int index;
        String input;
        if (!textEditor.getMainString().isEmpty()) {
            System.out.println("Введите индекс: ");
            index = Helper.getIndex(textEditor);
            System.out.println("Введите строку: ");
            input = Helper.scanner.nextLine();
            textEditor.getMainString().insert(index, input);

            backUpIndexStart=index;
            backUpIndexEnd=index+input.length();
            return true;
        } else {
            System.out.println("Строка пустая");
            return false;
        }
    }

    @Override
    public Command getInstance() {
        return new AddToIndex(textEditor);
    }
}
