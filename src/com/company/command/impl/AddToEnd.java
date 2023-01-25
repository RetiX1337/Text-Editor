package com.company.command.impl;

import com.company.Helper;
import com.company.TextEditor;
import com.company.command.Command;
import com.company.command.impl.service.addtoend.AddToEndInterface;

public class AddToEnd extends Command {
    public static final String description = "Дописать строку к концу";
    public static final String name = "AddToEnd";
    private String input;
    private static AddToEndInterface service;

    public AddToEnd(TextEditor textEditor) {
        super(textEditor);
    }

    @Override
    public boolean execute() {
        textEditor.getCommandHistory().historyExecute(textEditor);
        boolean returnable = setData();
        textEditor.getTempString().setLength(0);
        return returnable;
    }

    @Override
    public boolean setData() {
        System.out.println("Введите строку: ");
        this.input = Helper.scanner.nextLine();
        return true;
    }

    @Override
    public void outsideExecute() {
        service.execute(input, textEditor);
    }

    public static void setService(AddToEndInterface addToEnd) {
        service=addToEnd;
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
