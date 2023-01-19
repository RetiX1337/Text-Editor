package com.company.command.impl;

import com.company.Helper;
import com.company.TextEditor;
import com.company.command.Command;
import com.company.command.impl.service.DeleteFromAreaService;

public class DeleteFromArea extends Command {
    public static final String description = "Удалить часть строки";
    public static final String name = "DeleteFromArea";
    private int startIndex;
    private int endIndex;

    public DeleteFromArea(TextEditor textEditor) {
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
        DeleteFromAreaService.getInstance().service(startIndex, endIndex, textEditor);
    }

    @Override
    public boolean setData() {
        if (!textEditor.getTempString().isEmpty()) {
            System.out.println("Введите индекс начала диапазона: ");
            this.startIndex = Helper.getIndex(textEditor);
            System.out.println("Введите индекс конца диапазона: ");
            this.endIndex = Helper.getIndex(textEditor);
            return true;
        } else {
            System.out.println("Строка пустая");
            return false;
        }
    }

    @Override
    public String getDescription() {
        return DeleteFromArea.description;
    }

    @Override
    public Command getInstance() {
        return new DeleteFromArea(textEditor);
    }


}
