package com.company.command.impl;

import com.company.TextEditor;
import com.company.command.Command;

public class Undo extends Command {
    public static final String description="Отменить действие";
    public static final String name="Undo";

    public Undo(TextEditor textEditor) {
        super(textEditor, name, description);
    }

    @Override
    public void undo() {
    }

    @Override
    public boolean execute() {
        if (textEditor.getCommandHistory().isEmpty()) {
            System.out.println("Список команд пуст");
        } else {
            Command command = textEditor.getCommandHistory().pop();
            command.undo();
        }
        return false;
    }

    @Override
    public Command getInstance() {
        return new Undo(textEditor);
    }
}

