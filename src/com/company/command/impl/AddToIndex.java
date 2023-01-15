package com.company.command.impl;

import com.company.Helper;
import com.company.TextEditor;
import com.company.command.Command;

public class AddToIndex extends Command {
    public static final String description="Вставить строку по индексу";
    public static final String name="AddToIndex";

    public AddToIndex(TextEditor textEditor) {
        super(textEditor, name, description);
    }

    @Override
    public boolean execute() {
        setBackUp();
        int index;
        if (!textEditor.getMainString().isEmpty()) {
            System.out.println("Введите индекс: ");
            index = Helper.getIndex(textEditor);
            System.out.println("Введите строку: ");
            textEditor.getMainString().insert(index, Helper.scanner.nextLine());
        } else {
            System.out.println("Строка пустая");
        }
        return true;
    }

    @Override
    public Command getInstance() {
        return new AddToIndex(textEditor);
    }
}
