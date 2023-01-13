package com.company;

public class AddToEnd extends Command{
    public static String description="Дописать строку к концу";

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