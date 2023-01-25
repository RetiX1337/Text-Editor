package com.company;

import com.company.command.impl.AddToEnd;
import com.company.command.impl.AddToIndex;
import com.company.command.impl.service.addtoend.*;
import com.company.command.impl.service.addtoindex.*;


public class Configurator {
    public Configurator(boolean caps) {
        if(caps) {
            AddToEnd.setService(AddToEndServiceCaps.getInstance());
            AddToIndex.setService(AddToIndexServiceCaps.getInstance());
        } else {
            AddToEnd.setService(AddToEndService.getInstance());
            AddToIndex.setService(AddToIndexService.getInstance());
        }
    }
}
