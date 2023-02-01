package com.company;

import java.util.HashMap;

public class Config {
    private final CommandHistory commandHistory = new CommandHistory();
    private final TextEditor textEditor = new TextEditor(commandHistory);
    private final HashMap<String, Object> strategy = new HashMap<>();
    private CommandContainer commandContainer;

    public void config(String s) {
        boolean set = mode(s, strategy);

        if (set) {
            commandContainer = new CommandContainer(textEditor, strategy);
        } else System.out.println(Main.bundle.getString("IncorrectValue"));
    }

    private static boolean mode(String s, HashMap<String, Object> strategy) {
        switch (s) {
            case "1":
                new Strategy(false, strategy);
                break;
            case "2":
                new Strategy(true, strategy);
                break;
            default:
                return false;
        }
        return true;
    }

    public CommandContainer getCommandContainer() {
        return commandContainer;
    }


    public TextEditor getTextEditor() {
        return textEditor;
    }
}
