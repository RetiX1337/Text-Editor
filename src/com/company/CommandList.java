package com.company;

import java.util.HashMap;

public class CommandList {
    private final HashMap<Integer, String> commandMap = new HashMap<>();

    public CommandList() {
        commandMap.put(1, AddToEnd.description);
        commandMap.put(2, AddToIndex.description);
        commandMap.put(3, Copy.description);
        commandMap.put(4, DeleteFromArea.description);
        commandMap.put(5, Paste.description);
        commandMap.put(6, Cut.description);
        commandMap.put(7, "Отменить действие");
        commandMap.put(8, "Выйти из программы");
    }

    public String getDescription(Integer key) {
        return commandMap.get(key);
    }

    public int getLength() {
        return commandMap.size();
    }
}
