package com.company;

public class DeleteFromArea extends Command{
    public static String description="Удалить часть строки";

    public DeleteFromArea(TextEditor textEditor) {
        super(textEditor);
    }

    @Override
    public boolean execute() {
        setBackUp();
        int startIndex, endIndex;
        if (!TextEditor.mainString.isEmpty()) {
            System.out.println("Введите индекс начала диапазона: ");
            startIndex = Helper.getIndex();
            System.out.println("Введите индекс конца диапазона: ");
            endIndex = Helper.getIndex();
            TextEditor.mainString.delete(startIndex, endIndex);
        } else {
            System.out.println("Строка пустая");
        }
        return true;
    }
}
