package com.company;

import com.company.command.impl.service.addtoend.*;
import com.company.command.impl.service.addtoindex.*;

import java.util.HashMap;


public class Strategy {
    public Strategy(boolean caps, HashMap<String, Object> map) {
        if(caps) {
            System.out.println("bebra");
            map.put("AddToEnd", AddToEndServiceCaps.getInstance());
            map.put("AddToIndex", AddToIndexServiceCaps.getInstance());
        } else {
            System.out.println("bebraddddd");
            map.put("AddToEnd", AddToEndService.getInstance());
            map.put("AddToIndex", AddToIndexService.getInstance());
        }
    }


}
