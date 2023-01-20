package com.company.command.impl.service;

import com.company.command.impl.service.addtoend.*;
import com.company.command.impl.service.addtoindex.*;


public class Configurator {

    public Configurator(boolean caps) {
        if(caps) {
            Service.getInstance().setAddToEnd(AddToEndServiceCaps.getInstance());
            Service.getInstance().setAddToIndex(AddToIndexServiceCaps.getInstance());
        } else {
            Service.getInstance().setAddToEnd(AddToEndService.getInstance());
            Service.getInstance().setAddToIndex(AddToIndexService.getInstance());
        }
    }
}
