package com.company.command.impl.service;

import com.company.command.impl.service.addtoend.*;
import com.company.command.impl.service.addtoindex.*;


public class Configurator {
    private final AddToEndInterface addToEnd;
    private final AddToIndexInterface addToIndex;
    private static Configurator instance=null;
    private static boolean capsIndicator;

    private Configurator() {
        if(capsIndicator) {
            this.addToEnd=AddToEndServiceCaps.getInstance();
            this.addToIndex=AddToIndexServiceCaps.getInstance();
        } else {
            this.addToEnd=AddToEndService.getInstance();
            this.addToIndex=AddToIndexService.getInstance();
        }
    }

    public static void setCaps(boolean caps) {
        capsIndicator = caps;
    }

    public AddToEndInterface getAddToEnd() {
        return addToEnd;
    }

    public AddToIndexInterface getAddToIndex() {
        return addToIndex;
    }

    public static Configurator getInstance() {
        if(instance!=null) {
            return instance;
        }
        return instance = new Configurator();
    }
}
