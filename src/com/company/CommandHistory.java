package com.company;

import com.company.command.Command;

import java.util.*;

public class CommandHistory {

    private final ArrayDeque<Command> history = new ArrayDeque<>();

    public void push(Command command, TextEditor textEditor) {
        if(history.size()==2){
            textEditor.setMainStringSnapshot(history.pollFirst());
            history.offerLast(command);
        } else {
            history.offerLast(command);
        }
    }

    public Command pop() {
        return history.removeLast();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }

    public void historyExecute(TextEditor textEditor) {
        textEditor.getTempString().append(textEditor.getMainString());
        history.forEach(Command::outsideExecute);
    }
}
