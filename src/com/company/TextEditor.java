package com.company;

import com.company.command.Command;


public class TextEditor {
    private final StringBuilder mainString = new StringBuilder();
    private final StringBuilder tempString = new StringBuilder();
    private final StringBuilder bufferString = new StringBuilder();
    private final CommandHistory commandHistory;

    public TextEditor(CommandHistory commandHistory) {
        this.commandHistory = commandHistory;
    }

    public void executeCommand(Command command, TextEditor textEditor) {
        if (command.execute()) {
            commandHistory.push(command, textEditor);
        }
    }

    public void setMainStringSnapshot(Command mainStringSnapshot) {
        this.tempString.setLength(0);
        tempString.append(mainString);
        mainStringSnapshot.outsideExecute();
        this.mainString.setLength(0);
        this.mainString.append(tempString);
        this.tempString.setLength(0);
    }

    public CommandHistory getCommandHistory() {
        return commandHistory;
    }

    public StringBuilder getMainString() {
        return mainString;
    }

    public StringBuilder getBufferString() {
        return bufferString;
    }

    public StringBuilder getTempString() {
        return tempString;
    }
}
