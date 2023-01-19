package com.company.command.impl;

import com.company.Helper;
import com.company.TextEditor;
import com.company.command.Command;
import com.company.command.impl.service.CopyService;

public class Copy extends Command {
    public static final String description = "Копировать часть строки в буфер";
    public static final String name = "Copy";
    private int startIndex;
    private int endIndex;

    public Copy(TextEditor textEditor) {
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
        CopyService.getInstance().service(startIndex, endIndex, textEditor);
    }

    @Override
    public boolean setData() {
        System.out.println("Введите индекс начала диапазона: ");
        this.startIndex = Helper.getIndex(textEditor);
        System.out.println("Введите индекс конца диапазона: ");
        this.endIndex = Helper.getIndex(textEditor);
        return true;
    }

    @Override
    public String getDescription() {
        return Copy.description;
    }

    @Override
    public Command getInstance() {
        return new Copy(textEditor);
    }


}
