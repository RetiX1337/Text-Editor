package com.company;

import com.company.command.Command;
import com.company.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {
    private final Map<String, Command> commandMap = new HashMap<>();
    public TextEditor textEditor;

    public CommandContainer(TextEditor textEditor) {
        this.textEditor = textEditor;
        commandMap.put(AddToEnd.name, new AddToEnd(textEditor));
        commandMap.put(AddToIndex.name, new AddToIndex(textEditor));
        commandMap.put(Copy.name, new Copy(textEditor));
        commandMap.put(DeleteFromArea.name, new DeleteFromArea(textEditor));
        commandMap.put(Paste.name, new Paste(textEditor));
        commandMap.put(Cut.name, new Cut(textEditor));
        commandMap.put(Undo.name, new Undo(textEditor));
        commandMap.put(Exit.name, new Exit(textEditor));
    }

    public Command getCommand(String commandName) {
        Command returnableCommand = commandMap.getOrDefault(commandName, new Default(textEditor));
        return returnableCommand.getInstance();
    }

    public Map<String, Command> getAllCommands() {
        return commandMap;
    }
}
