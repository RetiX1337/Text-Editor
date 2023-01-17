package com.company.command.impl;

import com.company.Helper;
import com.company.TextEditor;
import com.company.command.Command;
import com.company.command.impl.service.AddToEndService;

public class AddToEnd extends Command {
    public static final String description = "Дописать строку к концу";
    public static final String name = "AddToEnd";
    private int backUpIndex;

    public AddToEnd(TextEditor textEditor) {
        super(textEditor);
    }

    @Override
    public void undo() {
        textEditor.getMainString().delete(backUpIndex, textEditor.getMainString().length());
    }

    @Override
    public boolean execute() {
        backUpIndex = textEditor.getMainString().length();

        System.out.println("Введите строку: ");
        String input = Helper.scanner.nextLine();

        return AddToEndService.service(input, textEditor);
    }

    @Override
    public String getDescription() {
        return AddToEnd.description;
    }

    @Override
    public Command getInstance() {
        return new AddToEnd(textEditor);
    }

}
