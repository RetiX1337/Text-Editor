package com.company.command.impl.service;

import com.company.Menu;

public class ExitService {
    private static ExitService instance = null;

    private ExitService() {}

    public boolean service() {
        System.out.println("Конец программы");
        Menu.setMenuIndicator(false);
        return false;
    }

    public static ExitService getInstance() {
        if(instance!=null){
            return instance;
        }
        return instance = new ExitService();
    }
}
