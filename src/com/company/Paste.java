package com.company;

public class Paste extends Command{

    public Paste(TextEditor textEditor) {
        super(textEditor);
    }

    @Override
    public boolean execute() {
        setBackUp();
        int index;
        if (!TextEditor.bufferString.isEmpty()) {
            System.out.println("Введите индекс: ");
            index = Helper.getIndex();
            TextEditor.mainString.insert(index, TextEditor.bufferString);
        } else {
            System.out.println("Буфер пустой");
        }
        return true;
    }
}
