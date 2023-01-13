package com.company;

public abstract class Command {
    public TextEditor textEditor;
    private String backUp;

    public Command(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    public void setBackUp() {
        backUp = String.valueOf(TextEditor.mainString);
    }

    public void undo() {
        TextEditor.mainString.setLength(0);
        TextEditor.mainString.append(backUp);
    }

    public abstract boolean execute();
}
