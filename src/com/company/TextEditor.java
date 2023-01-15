package com.company;

import com.company.command.Command;


public class TextEditor {

    private final StringBuilder mainString = new StringBuilder();
    private final StringBuilder bufferString = new StringBuilder();
    private final CommandHistory commandHistory = new CommandHistory();

    public void executeCommand(Command command) {
        if(command.execute()) {
            commandHistory.push(command);
        }
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
}
