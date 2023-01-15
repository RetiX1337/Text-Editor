package com.company.command.impl;

import com.company.Helper;
import com.company.TextEditor;
import com.company.command.Command;

public class AddToEnd extends Command {
    public static final String description="Дописать строку к концу";
    public static final String name="AddToEnd";

    public AddToEnd(TextEditor textEditor) {
        super(textEditor, name, description);
    }

    @Override
    public boolean execute() {
        setBackUp();
        System.out.println("Введите строку: ");
        textEditor.getMainString().append(Helper.scanner.nextLine());
        return true;
    }

    @Override
    public Command getInstance() {
        return new AddToEnd(textEditor);
    }

}
