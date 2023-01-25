package com.company;

import com.company.command.impl.AddToEnd;
import com.company.command.impl.AddToIndex;
import com.company.command.impl.service.addtoend.*;
import com.company.command.impl.service.addtoindex.*;


public class Configurator {
    public Configurator(boolean caps, TextEditor textEditor) {
        if(caps) {
            System.out.println("bebra");
            textEditor.getCommandContainer().setAddToEnd(AddToEndServiceCaps.getInstance());
            textEditor.getCommandContainer().setAddToIndex(AddToIndexServiceCaps.getInstance());
        } else {
            System.out.println("bebraddddd");
            textEditor.getCommandContainer().setAddToEnd(AddToEndService.getInstance());
            textEditor.getCommandContainer().setAddToIndex(AddToIndexService.getInstance());
        }
    }
}
