package com.company.command.impl;

import com.company.Helper;
import com.company.TextEditor;
import com.company.command.Command;
import com.company.command.impl.service.Configurator;
import com.company.command.impl.service.addtoend.AddToEndInterface;
import com.company.command.impl.service.addtoindex.AddToIndexInterface;
import com.company.command.impl.service.addtoindex.AddToIndexServiceCaps;

public class AddToIndex extends Command {
    public static final String description = "Вставить строку по индексу";
    public static final String name = "AddToIndex";
    private int index;
    private String input;
    private final AddToIndexInterface service;

    public AddToIndex(TextEditor textEditor) {
        super(textEditor);
        this.service=Configurator.getInstance().getAddToIndex();
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
            this.input = Helper.scanner.nextLine();
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
        return new AddToIndex(textEditor);
    }

}
