package com.company;

public class AddToIndex extends Command{

    public AddToIndex(TextEditor textEditor) {
        super(textEditor);
    }

    @Override
    public boolean execute() {
        setBackUp();
        int index;
        if (!TextEditor.mainString.isEmpty()) {
            System.out.println("Введите индекс: ");
            index = Helper.getIndex();
            System.out.println("Введите строку: ");
            TextEditor.mainString.insert(index, TextEditor.scanner.nextLine());
        } else {
            System.out.println("Строка пустая");
        }
        return true;
    }
}
