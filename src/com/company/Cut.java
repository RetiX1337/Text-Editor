package com.company;

public class Cut extends Command{
    public static String description="Вырезать часть строки в буфер";

    public Cut(TextEditor textEditor) {
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
            TextEditor.bufferString.setLength(0);
            TextEditor.bufferString.append(TextEditor.mainString.substring(startIndex, endIndex));
            TextEditor.mainString.delete(startIndex, endIndex);
        } else {
            System.out.println("Строка пустая");
        }
        return true;
    }
}
