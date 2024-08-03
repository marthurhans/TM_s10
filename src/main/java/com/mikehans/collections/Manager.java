package com.mikehans.collections;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager extends Employee implements IEmployee, Apple {

    private int orgSize =0;
    private int directReport = 0;


    private final String mgrRegex = "\\w+=(?<orgSize>\\w+),\\w+=(?<dr>\\w+)";
    private final Pattern mgrPat = Pattern.compile(mgrRegex);


    public Manager(String personText) {
        super(personText);
        Matcher mgrMat= mgrPat.matcher(peopleMat.group("details"));
        if (mgrMat.find()) {
            this.orgSize = Integer.parseInt(mgrMat.group("orgSize"));
            this.directReport = Integer.parseInt(mgrMat.group("dr"));
        }

    }

    @Override
    public int getSalary() {
//        salary = 3500 + orgSize * directReports;
        return 3500 + orgSize * directReport;
    }

    public int getOrgSize() {
        return orgSize;
    }

    public void setOrgSize(int orgSize) {
        this.orgSize = orgSize;
    }

    public int getDirectReport() {
        return directReport;
    }

    public void setDirectReport(int directReport) {
        this.directReport = directReport;
    }
}


