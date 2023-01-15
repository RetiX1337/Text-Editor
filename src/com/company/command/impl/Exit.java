package com.company.command.impl;

import com.company.TextEditor;
import com.company.command.Command;

public class Exit extends Command {
    public static final String description="Выход из программы";
    public static final String name="Exit";

    public Exit(TextEditor textEditor) {
        super(textEditor, name, description);
    }

    @Override
    public void undo() {
    }

    @Override
    public boolean execute() {
        System.out.println("Конец программы");
        System.exit(0);
        return false;
    }

    @Override
    public Command getInstance() {
        return new Exit(textEditor);
    }
}
