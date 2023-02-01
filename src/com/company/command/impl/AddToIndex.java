package com.company.command.impl;

import com.company.Helper;
import com.company.TextEditor;
import com.company.command.Command;
import com.company.command.impl.service.addtoindex.AddToIndexInterface;

public class AddToIndex extends Command {
    public static final String description = "Вставить строку по индексу";
    public static final String name = "AddToIndex";
    private int index;
    private String input;
    private final AddToIndexInterface service;

    public AddToIndex(TextEditor textEditor, AddToIndexInterface service) {
        super(textEditor);
        this.service=service;
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
        if (!textEditor.getTempString().isEmpty()) {
            System.out.println("Введите индекс: ");
            this.index = Helper.getIndex(textEditor);
            System.out.println("Введите строку: ");
            this.input = Helper.getScanner().nextLine();
            return true;
        } else {
            System.out.println("Строка пустая");
            return false;
        }
    }

    @Override
    public void outsideExecute() {
        service.execute(input, index, textEditor);
    }

    @Override
    public String getDescription() {
        return AddToIndex.description;
    }

    @Override
    public Command getInstance() {
        return new AddToIndex(textEditor, service);
    }

}
