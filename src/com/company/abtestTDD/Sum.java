package com.company.abtestTDD;

public class Sum {
    public static int sum(int a, int b) {
        int sum=a+b;
        if (sum >= Integer.MAX_VALUE || sum <= Integer.MIN_VALUE) throw new RuntimeException();
        return sum;
    }
}
