package com.mikehans.collections;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CEO extends Employee implements IEmployee, Apple, Flyer {

    private int aveStockPrice = 0;
    private Flyer flyer = new Pilot(100, true);

    private final String ceoRegex = "\\w+=(?<aveStockPrice>\\w+)";
    private final Pattern ceoPat = Pattern.compile(ceoRegex);

    public CEO(String peopleText) {
        super(peopleText);
        Matcher ceoMat= ceoPat.matcher(peopleMat.group("details"));
        if (ceoMat.find()) {
            this.aveStockPrice = Integer.parseInt(ceoMat.group("aveStockPrice"));
        }
    }


    public int getSalary() {
//        salary = 3500 + orgSize * directReports;
        return 5000 * aveStockPrice;
    }

    public void fly() {
        flyer.fly();
    }

    public int getHoursFlown() {
        return flyer.getHoursFlown();
    }

    public void setHoursFlown(int hoursFlown) {
        flyer.setHoursFlown(hoursFlown);
    }

    public boolean isIfr() {
        return flyer.isIfr();
    }

    public void setIfr(boolean ifr) {
        flyer.setIfr(ifr);
    }

    public int getAveStockPrice() {
        return aveStockPrice;
    }

    public void setAveStockPrice(int aveStockPrice) {
        this.aveStockPrice = aveStockPrice;
    }

}

