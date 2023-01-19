package com.company.command.impl;

import com.company.Helper;
import com.company.TextEditor;
import com.company.command.Command;
import com.company.command.impl.service.AddToEndService;

public class AddToEnd extends Command {
    public static final String description = "Дописать строку к концу";
    public static final String name = "AddToEnd";
    private int index;
    private String input;

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
        this.index = textEditor.getMainString().length();
        System.out.println("Введите строку: ");
        this.input = Helper.scanner.nextLine();
        return true;
    }

    @Override
    public void outsideExecute() {
        AddToEndService.getInstance().service(input, textEditor);
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
