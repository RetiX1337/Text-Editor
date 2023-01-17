package com.company.command.impl;

import com.company.TextEditor;
import com.company.command.Command;
import com.company.command.impl.service.ExitService;

public class Exit extends Command {
    public static final String description = "Выход из программы";
    public static final String name = "Exit";

    public Exit(TextEditor textEditor) {
        super(textEditor);
    }

    @Override
    public void undo() {
    }

    @Override
    public boolean execute() {
        return ExitService.service();
    }

    @Override
    public String getDescription() {
        return Exit.description;
    }

    @Override
    public Command getInstance() {
        return new Exit(textEditor);
    }
}
