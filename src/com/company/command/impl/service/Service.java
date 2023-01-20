package com.company.command.impl.service;

import com.company.TextEditor;
import com.company.command.impl.service.addtoend.AddToEndInterface;
import com.company.command.impl.service.addtoindex.AddToIndexInterface;

public class Service {
    private static Service instance = null;
    private AddToEndInterface addToEnd;
    private AddToIndexInterface addToIndex;

    private Service(){}

    public void setAddToEnd(AddToEndInterface addToEnd) {
        this.addToEnd = addToEnd;
    }

    public void executeAddToEnd(String input, TextEditor textEditor) {
        addToEnd.service(input, textEditor);
    }

    public void setAddToIndex(AddToIndexInterface addToIndex) {
        this.addToIndex = addToIndex;
    }

    public void executeAddToIndex(String input, int index, TextEditor textEditor) {
        addToIndex.service(input, index, textEditor);
    }

    public static Service getInstance() {
        if (instance != null) {
            return instance;
        }
        return instance = new Service();
    }
}
