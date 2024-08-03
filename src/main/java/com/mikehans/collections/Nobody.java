package com.mikehans.collections;

public class Nobody extends Employee {

    private static int count = 0;

    public Nobody(String personText) {
        super(personText);
    }

    @Override
    public int getSalary() {
        return 0;
    }

    @Override
    public String toString() {
        count++;
        return "Lines of code that did not match regex: " + count;
    }
}
