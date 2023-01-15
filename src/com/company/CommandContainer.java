package com.company;

import com.company.command.Command;
import com.company.command.impl.*;
import java.util.HashMap;
import java.util.Map;

public class CommandContainer {
    private final Map<Integer, Command> commandMap = new HashMap<>();
    public TextEditor textEditor;
    private Command defaultCommand;

    public CommandContainer(TextEditor textEditor) {
        this.textEditor = textEditor;
        commandMap.put(1, new AddToEnd(textEditor));
        commandMap.put(2, new AddToIndex(textEditor));
        commandMap.put(3, new Copy(textEditor));
        commandMap.put(4, new DeleteFromArea(textEditor));
        commandMap.put(5, new Paste(textEditor));
        commandMap.put(6, new Cut(textEditor));
        commandMap.put(7, new Undo(textEditor));
        commandMap.put(8, new Exit(textEditor));
    }

    public Command getCommand(int commandNumber)  {
        return commandMap.get(commandNumber).getInstance();
    }

    public Map<Integer, Command> getAllCommands() {
        return commandMap;
    }
}
