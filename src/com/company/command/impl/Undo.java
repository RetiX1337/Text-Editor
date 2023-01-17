package com.company.command.impl;

import com.company.TextEditor;
import com.company.command.Command;
import com.company.command.impl.service.UndoService;

public class Undo extends Command {
    public static final String description = "Отменить действие";
    public static final String name = "Undo";

    public Undo(TextEditor textEditor) {
        super(textEditor);
    }

    @Override
    public void undo() {
    }

    @Override
    public boolean execute() {
        return UndoService.service(textEditor);
    }

    @Override
    public String getDescription() {
        return Undo.description;
    }

    @Override
    public Command getInstance() {
        return new Undo(textEditor);
    }
}

