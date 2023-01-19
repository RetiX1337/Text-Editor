package com.company.command;

import com.company.TextEditor;

public abstract class Command {
    public TextEditor textEditor;

    public Command(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    public abstract boolean execute();

    public abstract void outsideExecute();

    public abstract boolean setData();

    public abstract String getDescription();

    public abstract Command getInstance();
}
