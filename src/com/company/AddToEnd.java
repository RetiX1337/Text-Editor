package com.company;

public class AddToEnd extends Command{

    public AddToEnd(TextEditor textEditor) {
        super(textEditor);
    }

    @Override
    public boolean execute() {
        setBackUp();
        System.out.println("Введите строку: ");
        TextEditor.mainString.append(TextEditor.scanner.nextLine());
        return true;
    }
}
