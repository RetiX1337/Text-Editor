package com.company.command.impl.service;

import com.company.Menu;

public class ExitService {
    public static boolean service() {
        System.out.println("Конец программы");
        Menu.setMenuIndicator(false);
        return false;
    }
}
