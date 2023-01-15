package com.company.command;

import com.company.TextEditor;

public abstract class Command {
    public TextEditor textEditor;
    public String description;
    public String name;

    public Command(TextEditor textEditor, String name, String description) {
        this.textEditor = textEditor;
        this.description = description;
        this.name = name;
    }

    public abstract void undo();

    public abstract boolean execute();

    public abstract Command getInstance();
}
