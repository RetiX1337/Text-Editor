package com.company.command.impl.service.addtoindex;

import com.company.Helper;
import com.company.TextEditor;

public class AddToIndexService implements AddToIndexInterface {
    private static AddToIndexService instance = null;

    private AddToIndexService() {
    }

    @Override
    public boolean execute(String input, int index, TextEditor textEditor) {
        if (!textEditor.getTempString().isEmpty() && Helper.checkIndex(textEditor, index)) {
            textEditor.getTempString().insert(index, input);
            return true;
        } else {
            if (textEditor.getTempString().isEmpty()) System.out.println("Строка пустая");
            if (!Helper.checkIndex(textEditor, index)) System.out.println("Индекс выходит за границы строки");
            return false;
        }
    }

    public static AddToIndexService getInstance() {
        if (instance != null) {
            return instance;
        }
        return instance = new AddToIndexService();
    }
}
