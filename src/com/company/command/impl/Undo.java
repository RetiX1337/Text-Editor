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
    public boolean execute() {
        UndoService.getInstance().service(textEditor);
        return false;
    }

    @Override
    public void outsideExecute() {
        UndoService.getInstance().service(textEditor);
    }

    @Override
    public boolean setData() {
        return false;
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

