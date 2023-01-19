package com.company.command.impl;

import com.company.TextEditor;
import com.company.command.Command;

public class Default extends Command {
    public static final String name = "";
    public static final String description = "";

    public Default(TextEditor textEditor) {
        super(textEditor);
    }

    @Override
    public boolean execute() {
        System.out.println("Данной команды не существует");
        return false;
    }

    @Override
    public void outsideExecute() {

    }

    @Override
    public boolean setData() {
        return false;
    }

    @Override
    public String getDescription() {
        return Default.description;
    }

    @Override
    public Command getInstance() {
        return new Default(textEditor);
    }

}
