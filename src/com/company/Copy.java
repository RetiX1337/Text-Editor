package com.company;

public class Copy extends Command{

    public Copy(TextEditor textEditor) {
        super(textEditor);
    }

    @Override
    public boolean execute() {
        int startIndex, endIndex;
        if (!TextEditor.mainString.isEmpty()) {
            System.out.println("Введите индекс начала диапазона: ");
            startIndex = Helper.getIndex();
            System.out.println("Введите индекс конца диапазона: ");
            endIndex = Helper.getIndex();
            TextEditor.bufferString.setLength(0);
            TextEditor.bufferString.append(TextEditor.mainString.substring(startIndex, endIndex));
        } else {
            System.out.println("Строка пустая");
        }
        return false;
    }
}
