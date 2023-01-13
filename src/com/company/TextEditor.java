package com.company;

import java.util.Scanner;

public class TextEditor {

    protected static final StringBuilder mainString = new StringBuilder();
    protected static final StringBuilder bufferString = new StringBuilder();
    protected static final Scanner scanner = new Scanner(System.in);
    CommandHistory commandHistory = new CommandHistory();

    public void executeCommand(Command command) {
        if(command.execute()) commandHistory.push(command);
    }

    public void undoCommand() {
        if (commandHistory.isEmpty()) {
            System.out.println("Список команд пуст");
            return;
        }
        Command command = commandHistory.pop();
        command.undo();
    }
}
