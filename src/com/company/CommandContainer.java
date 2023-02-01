package com.company;

import com.company.command.Command;
import com.company.command.impl.*;
import com.company.command.impl.service.addtoend.AddToEndInterface;
import com.company.command.impl.service.addtoend.AddToEndService;
import com.company.command.impl.service.addtoend.AddToEndServiceCaps;
import com.company.command.impl.service.addtoindex.AddToIndexInterface;
import com.company.command.impl.service.addtoindex.AddToIndexService;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {
    private final Map<String, Command> commandMap = new HashMap<>();
    public TextEditor textEditor;
    private AddToEndInterface addToEnd;
    private AddToIndexInterface addToIndex;

    public CommandContainer(TextEditor textEditor, HashMap<String, Object> strategy) {
        this.textEditor = textEditor;
        this.addToEnd = (AddToEndInterface) strategy.getOrDefault("AddToEnd", AddToEndService.getInstance());
        this.addToIndex = (AddToIndexInterface) strategy.getOrDefault("AddToIndex", AddToIndexService.getInstance());
        commandMap.put(AddToEnd.name, new AddToEnd(textEditor, this.addToEnd));
        commandMap.put(AddToIndex.name, new AddToIndex(textEditor, this.addToIndex));
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
