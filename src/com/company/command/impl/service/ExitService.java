package com.company.command.impl.service;

import com.company.ExitException;
import com.company.Menu;

public class ExitService {
    private static ExitService instance = null;

    private ExitService() {}

    public boolean service() {
        System.out.println("Конец программы");
        throw new ExitException();
    }

    public static ExitService getInstance() {
        if(instance!=null){
            return instance;
        }
        return instance = new ExitService();
    }
}
