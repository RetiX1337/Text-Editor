package com.company.command.impl;

import com.company.Helper;
import com.company.TextEditor;
import com.company.command.Command;
import com.company.command.impl.service.PasteService;

public class Paste extends Command {
    public static final String description = "Вставить строку по индексу из буфера";
    public static final String name = "Paste";
    private int index;

    public Paste(TextEditor textEditor) {
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
    public void outsideExecute() {
        PasteService.getInstance().service(index, textEditor);
    }

    @Override
    public boolean setData() {
        if (!textEditor.getBufferString().isEmpty()) {
            System.out.println("Введите индекс: ");
            this.index = Helper.getIndex(textEditor);
            return true;
        } else {
            System.out.println("Буфер пустой");
            return false;
        }
    }

    @Override
    public String getDescription() {
        return Paste.description;
    }

    @Override
    public Command getInstance() {
        return new Paste(textEditor);
    }

}
