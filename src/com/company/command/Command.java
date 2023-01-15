package com.company.command;

import com.company.TextEditor;

public abstract class Command {
    public TextEditor textEditor;
    private String backUp;
    public String description;
    public String name;

    public Command(TextEditor textEditor, String name, String description) {
        this.textEditor = textEditor;
        this.description = description;
        this.name = name;
    }

    public void setBackUp() {
        backUp = String.valueOf(textEditor.getMainString());
    }

    public void undo() {
        textEditor.getMainString().setLength(0);
        textEditor.getMainString().append(backUp);
    }

    public abstract boolean execute();

    public abstract Command getInstance();
}
